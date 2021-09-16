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

import com.kolanot.service.constant.KolanotInvoiceStatusMapping;
import com.kolanot.service.exception.NoSuchKolanotInvoiceException;
import com.kolanot.service.model.KolanotInvoice;
import com.kolanot.service.model.KolanotInvoiceLine;
import com.kolanot.service.service.KolanotInvoiceLineLocalService;
import com.kolanot.service.service.base.KolanotInvoiceLocalServiceBaseImpl;
import com.liferay.commerce.account.model.CommerceAccount;
import com.liferay.commerce.account.service.CommerceAccountLocalService;
import com.liferay.commerce.constants.CommerceOrderConstants;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderPayment;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.commerce.service.CommerceOrderPaymentLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.Validator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The implementation of the kolanot invoice local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.kolanot.service.service.KolanotInvoiceLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoiceLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.kolanot.service.model.KolanotInvoice",
	service = AopService.class
)
public class KolanotInvoiceLocalServiceImpl
	extends KolanotInvoiceLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public KolanotInvoice addKolanotInvoice(
			long commerceOrderId,
			ServiceContext serviceContext)
		throws PortalException {

		long invoiceId = counterLocalService.increment();
		long companyId = serviceContext.getCompanyId();
		
		CommerceOrder linkedOrder = _commerceOrderLocalService.fetchCommerceOrder(commerceOrderId);

		if (linkedOrder == null) {
			
			return null;
		}

		CommerceAccount commerceAccount =
			_commerceAccountLocalService.fetchCommerceAccount(linkedOrder.getCommerceAccountId());

		if (Validator.isNull(commerceAccount)) {
			_log.warn(
				"Failed to find commerce account linked with commerceOrderId [" +
						linkedOrder.getCommerceAccountId() + "].");

			throw new PortalException(
				"Could not find commerce account linked with commerceOrderId [" +
						linkedOrder.getCommerceAccountId() + "].");
		}

		KolanotInvoice invoice =
			kolanotInvoicePersistence.create(invoiceId);

		invoice.setBillingAddressId(linkedOrder.getBillingAddressId());
		invoice.setShippingAddressId(linkedOrder.getShippingAddressId());

		Date currentDate = new Date();

		invoice.setCreateDate(currentDate);
		invoice.setCreatedBy(commerceAccount.getName());
		invoice.setCreatedByAccountId(commerceAccount.getCommerceAccountId());
		invoice.setCompanyId(companyId);

//		invoice.setExternalReferenceCode(externalReferenceCode);
//		invoice.setReferenceNo(referenceNo);
//		invoice.setAccountExternalReferenceCode(cardCode);
//		invoice.setDocumentNumber(documentNumber);
		invoice.setDocumentStatus("open");
//		invoice.setDueDate(dueDate);
		invoice.setDocumentDate(currentDate);
//		invoice.setCarrier(carrier);
//		invoice.setTrackingNumber(trackingNumber);
//		invoice.setTrackingURL(trackingURL);

//		invoice.setSubTotal(subTotal);
//		invoice.setFreightAmount(freightAmount);
//		invoice.setGst(gst);
		invoice.setCommerceOrderId(commerceOrderId);
		invoice.setInvoiceTotal(linkedOrder.getTotal());
		invoice.setBalanceDue(linkedOrder.getTotal());
		invoice.setPaidSum(new BigDecimal(0));
		invoice.setStatus(getInvoiceStatus("open"));

		kolanotInvoiceLocalService.addKolanotInvoice(invoice);

		List<CommerceOrderPayment> orderPayments =  _commerceOrderPaymentService.getCommerceOrderPayments(commerceOrderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		System.out.println("Create invoice with order payment: " + orderPayments.size());
		for(CommerceOrderPayment payment: orderPayments) {
			System.out.println(payment.getCommerceOrderPaymentId());
			payment.setCommercePaymentMethodKey("stripe");
			
			_commerceOrderPaymentService.updateCommerceOrderPayment(payment);
		}

//		linkedOrder.setStatus(CommerceOrderConstants.ORDER_STATUS_PROCESSING);
		linkedOrder.setCommercePaymentMethodKey("stripe");

		_commerceOrderLocalService.updateCommerceOrder(linkedOrder);

		return invoice;
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public KolanotInvoice updateKolanotInvoice(
			Long invoiceId, BigDecimal balanceDue, BigDecimal paidAmount, String transactionId, ServiceContext serviceContext)
		throws PortalException {

		KolanotInvoice invoice =
				kolanotInvoiceLocalService.fetchKolanotInvoice(invoiceId);

		if (invoice == null) {
			_log.error(
				"Failed to fetch the invoice using Id [" +
						invoiceId + "].");

			throw new NoSuchKolanotInvoiceException(
				"Could not fetch the invoice Id [" + invoiceId +
					"].");
		}

		// update balanceDue

		if (invoice.getDocumentStatus().equalsIgnoreCase(
				KolanotInvoiceStatusMapping.OPEN.statusName)) {

			BigDecimal invoiceTotal = invoice.getInvoiceTotal();

			invoice.setStatus(KolanotInvoiceStatusMapping.CLOSED.statusNumber);
			invoice.setDocumentStatus(KolanotInvoiceStatusMapping.CLOSED.name());

			invoice.setBalanceDue(balanceDue);
			invoice.setPaidSum(invoiceTotal.subtract(balanceDue));
			invoice.setTransactionId(transactionId);
		}
		else {
			throw new PortalException("Can not update on closed invoices");
		}
//		else if (documentStatus.equalsIgnoreCase(
//				KolanotInvoiceStatusMapping.CLOSED.statusName)) {
//
//			invoice.setBalanceDue(new BigDecimal(0.0));
//			invoice.setStatus(KolanotInvoiceStatusMapping.CLOSED.statusNumber);
//		}
//
		Date currentDate = new Date();

		invoice.setModifiedDate(serviceContext.getModifiedDate(currentDate));
		invoice.setDocumentDate(currentDate);
//		invoice.setDocumentStatus(documentStatus);

		return kolanotInvoicePersistence.update(invoice);
	}

	public KolanotInvoice findInvoiceByOrderId(long commerceOrderId) throws NoSuchKolanotInvoiceException {
		return kolanotInvoicePersistence.findByLinkWithOrder(commerceOrderId);
	}

	private int getInvoiceStatus(String documentStatus) throws PortalException {
		return KolanotInvoiceStatusMapping.getStatusNumberByName(
			documentStatus);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public KolanotInvoice deleteKolanotInvoice(long invoiceId)
			throws PortalException {

			KolanotInvoice invoice =
				kolanotInvoiceLocalService.fetchKolanotInvoice(
					invoiceId);

			if (Validator.isNull(invoice)) {
				_log.warn("Failed to find invoice using id [" + invoiceId + "].");

				throw new NoSuchKolanotInvoiceException(
					"Could not find invoice [" + invoiceId + "].");
			}

			List<KolanotInvoiceLine> invoiceLines =
					_kolanotInvoiceLineLocalService.findInvoiceLineByInvoiceId(invoiceId, -1, -1);

			for (KolanotInvoiceLine invoiceLine : invoiceLines) {
				_kolanotInvoiceLineLocalService.deleteKolanotInvoiceLine(
					invoiceLine);
			}

			return kolanotInvoiceLocalService.
				deleteKolanotInvoice(invoice);
		}
	
	private static final Logger _log = LoggerFactory.getLogger(
			KolanotInvoiceLocalServiceImpl.class);

	@Reference
	private CommerceAccountLocalService _commerceAccountLocalService;

	@Reference
	private CommerceOrderLocalService _commerceOrderLocalService;

	@Reference
	private CommerceOrderPaymentLocalService _commerceOrderPaymentService;

	@Reference
	private KolanotInvoiceLineLocalService _kolanotInvoiceLineLocalService;
}