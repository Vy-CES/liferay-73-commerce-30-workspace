/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.kolanot.service.service.impl;

import com.kolanot.service.model.KolanotInvoice;
import com.kolanot.service.service.base.InvoiceGeneratorLocalServiceBaseImpl;
import com.liferay.commerce.account.model.CommerceAccount;
import com.liferay.commerce.account.service.CommerceAccountLocalService;
import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.model.CommerceAddress;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.service.CommerceAddressLocalService;
import com.liferay.commerce.service.CommerceOrderItemLocalService;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.sapphire.commerce.invoice.pdf.generator.InvoicePDFBuilder;
import com.sapphire.commerce.invoice.pdf.generator.constants.InvoicePDFGeneratorConstants;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the invoice generator local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.kolanot.service.service.InvoiceGeneratorLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceGeneratorLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.kolanot.service.model.InvoiceGenerator",
	service = AopService.class
)
public class InvoiceGeneratorLocalServiceImpl
	extends InvoiceGeneratorLocalServiceBaseImpl {


	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.sapphire.commerce.invoice.management.service.InvoiceGeneratorLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.sapphire.commerce.invoice.management.service.InvoiceGeneratorLocalServiceUtil</code>.
	 */
	@Override
	public File getInvoicePDFFile(KolanotInvoice commerceInvoice)
		throws IOException, PortalException {

		if (_log.isDebugEnabled()) {
			_log.debug("In getInvoicePDFAssetId");
		}

		long commerceOrderId = commerceInvoice.getCommerceOrderId();
		
		CommerceOrder commerceOrder = _commerceOrderLocalService.getCommerceOrder(commerceOrderId);

		List<CommerceOrderItem> productLines =
			
			_commerceOrderItemLocalService.getCommerceOrderItems(commerceOrderId, -1, -1);

		String[] productHeaders = getProductInformationHeaders();

		List<String[]> productInformation = new ArrayList<>();

		for (CommerceOrderItem commerceOrderItem : productLines) {
			productInformation.add(getProductInformation(commerceOrderItem));
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Creating the PDF file");
		}

		
		CommerceAddress billingAddress = _commerceAddressLocalService.getCommerceAddress(commerceInvoice.getBillingAddressId());
		CommerceAddress shippingAddress = _commerceAddressLocalService.getCommerceAddress(commerceInvoice.getShippingAddressId());

		CommerceAccount commerceAccount =
			_commerceAccountLocalService.getCommerceAccount(
				commerceInvoice.getCreatedByAccountId());

		String[] invoiceInfoTableData = buildInvoiceInfoTableData(
			commerceInvoice, commerceAccount);

		String[] balanceValueTable = buildBalanceValueTable(commerceInvoice);

		String[] remitanceTable = buildRemitanceTable(
			commerceInvoice, commerceAccount);

		return InvoicePDFBuilder.buildSupplierPDF(
			commerceOrderId, buildAddress(billingAddress),
			buildAddress(shippingAddress), productHeaders, productInformation,
			invoiceInfoTableData, balanceValueTable, remitanceTable);
	}

	private String[] buildAddress(CommerceAddress address) {
		String[] addressArr = new String[3];
		addressArr[0] = address.getName();
		addressArr[1] = address.getStreet1();
		addressArr[2] =
			address.getCity();

		return addressArr;
	}

	private String[] buildBalanceValueTable(KolanotInvoice invoice) {
		String[] balanceValueTable = new String[3];

		balanceValueTable[0] = String.valueOf(
			invoice.getInvoiceTotal(
			).setScale(
				2, RoundingMode.CEILING
			));
		balanceValueTable[1] = String.valueOf(
			invoice.getPaidSum(
			).setScale(
				2, RoundingMode.CEILING
			));
		balanceValueTable[2] = String.valueOf(
			invoice.getBalanceDue(
			).setScale(
				2, RoundingMode.CEILING
			));

		return balanceValueTable;
	}

	private String[] buildInvoiceInfoTableData(
		KolanotInvoice commerceInvoice,
		CommerceAccount commerceAccount) throws PortalException {

		String[] invoiceInfoTable = new String[7];
		invoiceInfoTable[0] = String.valueOf(
			commerceInvoice.getDocumentNumber());

		CommerceOrder order = _commerceOrderLocalService.getCommerceOrder(commerceInvoice.getCommerceOrderId());
		CommerceCurrency currency = order.getCommerceCurrency();

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
			String documentDate = formatter.format(
				commerceInvoice.getDocumentDate());

			invoiceInfoTable[1] = documentDate;
		}
		catch (Exception exception) {
			_log.error(
				"Error while parsing document date: " +
					commerceInvoice.getDocumentDate());
			invoiceInfoTable[1] = "";
		}

		invoiceInfoTable[2] = String.valueOf(
			commerceInvoice.getExternalReferenceCode());
		invoiceInfoTable[3] = commerceAccount.getName();
		invoiceInfoTable[4] = commerceAccount.getExternalReferenceCode();
		//TODO: Terms
		invoiceInfoTable[5] = currency.getCode();

		return invoiceInfoTable;
	}

	private String[] buildRemitanceTable(
		KolanotInvoice invoice, CommerceAccount commerceAccount) {

		String[] remitanceTable = new String[3];
		remitanceTable[0] = commerceAccount.getExternalReferenceCode();
		remitanceTable[1] = invoice.getDocumentNumber();
		remitanceTable[2] = "";

		return remitanceTable;
	}

	private String[] getProductInformation(
			CommerceOrderItem commerceOrderItem)
		throws PortalException {

		if (_log.isDebugEnabled()) {
			_log.debug("Getting the order item info");
		}

		String[] productInformation = new String[9];

		productInformation[0] = String.valueOf(commerceOrderItem.getCommerceOrderItemId());
		productInformation[1] = commerceOrderItem.getName(LocaleUtil.getDefault());
		productInformation[2] = String.valueOf(
			commerceOrderItem.getCommerceOrderId());
		productInformation[3] = "0"; //TODO: BackOrder
		productInformation[4] = String.valueOf(
			commerceOrderItem.getQuantity());
		productInformation[5] = String.valueOf(
			commerceOrderItem.getUnitPrice(
			).setScale(
				2, RoundingMode.CEILING
			));
		productInformation[6] = String.valueOf(
			commerceOrderItem.getDiscountAmount(
			).setScale(
				2, RoundingMode.CEILING
			));
		productInformation[7] = String.valueOf(
			commerceOrderItem.getFinalPrice(
			).setScale(
				2, RoundingMode.CEILING
			));

		return productInformation;
	}

	private String[] getProductInformationHeaders() {
		String[] headers = new String[8];

		if (_log.isDebugEnabled()) {
			_log.debug("Getting the headers info");
		}

		headers[0] = InvoicePDFGeneratorConstants.STOCK_CODE;
		headers[1] = InvoicePDFGeneratorConstants.DESCRIPTION;
		headers[2] = InvoicePDFGeneratorConstants.QUANTITY_ORDER;
		headers[3] = InvoicePDFGeneratorConstants.BACK_ORDER;
		headers[4] = InvoicePDFGeneratorConstants.INVOICED_QTY;
		headers[5] = InvoicePDFGeneratorConstants.PRICE;
		headers[6] = InvoicePDFGeneratorConstants.DISCOUNT_PERCENT;
		headers[7] = InvoicePDFGeneratorConstants.TOTAL;

		return headers;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		InvoiceGeneratorLocalServiceImpl.class);

	@Reference
	private CommerceAccountLocalService _commerceAccountLocalService;

	@Reference
	private CommerceAddressLocalService _commerceAddressLocalService;

	@Reference
	private CommerceOrderLocalService
		_commerceOrderLocalService;

	@Reference
	private CommerceOrderItemLocalService _commerceOrderItemLocalService;

}