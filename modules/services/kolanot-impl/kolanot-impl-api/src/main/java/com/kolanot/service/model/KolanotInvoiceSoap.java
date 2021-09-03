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

package com.kolanot.service.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.kolanot.service.service.http.KolanotInvoiceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class KolanotInvoiceSoap implements Serializable {

	public static KolanotInvoiceSoap toSoapModel(KolanotInvoice model) {
		KolanotInvoiceSoap soapModel = new KolanotInvoiceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setInvoiceId(model.getInvoiceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedByAccountId(model.getCreatedByAccountId());
		soapModel.setCommerceOrderId(model.getCommerceOrderId());
		soapModel.setAccountExternalReferenceCode(
			model.getAccountExternalReferenceCode());
		soapModel.setReferenceNo(model.getReferenceNo());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTransactionId(model.getTransactionId());
		soapModel.setDocumentNumber(model.getDocumentNumber());
		soapModel.setDocumentStatus(model.getDocumentStatus());
		soapModel.setDocumentDate(model.getDocumentDate());
		soapModel.setDueDate(model.getDueDate());
		soapModel.setCarrier(model.getCarrier());
		soapModel.setTrackingNumber(model.getTrackingNumber());
		soapModel.setSubTotal(model.getSubTotal());
		soapModel.setFreightAmount(model.getFreightAmount());
		soapModel.setGst(model.getGst());
		soapModel.setInvoiceTotal(model.getInvoiceTotal());
		soapModel.setBalanceDue(model.getBalanceDue());
		soapModel.setTrackingURL(model.getTrackingURL());
		soapModel.setStatus(model.getStatus());
		soapModel.setPaidSum(model.getPaidSum());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setBillingAddressId(model.getBillingAddressId());
		soapModel.setShippingAddressId(model.getShippingAddressId());

		return soapModel;
	}

	public static KolanotInvoiceSoap[] toSoapModels(KolanotInvoice[] models) {
		KolanotInvoiceSoap[] soapModels = new KolanotInvoiceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KolanotInvoiceSoap[][] toSoapModels(
		KolanotInvoice[][] models) {

		KolanotInvoiceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new KolanotInvoiceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KolanotInvoiceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KolanotInvoiceSoap[] toSoapModels(
		List<KolanotInvoice> models) {

		List<KolanotInvoiceSoap> soapModels = new ArrayList<KolanotInvoiceSoap>(
			models.size());

		for (KolanotInvoice model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KolanotInvoiceSoap[soapModels.size()]);
	}

	public KolanotInvoiceSoap() {
	}

	public long getPrimaryKey() {
		return _invoiceId;
	}

	public void setPrimaryKey(long pk) {
		setInvoiceId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getExternalReferenceCode() {
		return _externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		_externalReferenceCode = externalReferenceCode;
	}

	public long getInvoiceId() {
		return _invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		_invoiceId = invoiceId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getCreatedByAccountId() {
		return _createdByAccountId;
	}

	public void setCreatedByAccountId(long createdByAccountId) {
		_createdByAccountId = createdByAccountId;
	}

	public long getCommerceOrderId() {
		return _commerceOrderId;
	}

	public void setCommerceOrderId(long commerceOrderId) {
		_commerceOrderId = commerceOrderId;
	}

	public String getAccountExternalReferenceCode() {
		return _accountExternalReferenceCode;
	}

	public void setAccountExternalReferenceCode(
		String accountExternalReferenceCode) {

		_accountExternalReferenceCode = accountExternalReferenceCode;
	}

	public String getReferenceNo() {
		return _referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		_referenceNo = referenceNo;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTransactionId() {
		return _transactionId;
	}

	public void setTransactionId(String transactionId) {
		_transactionId = transactionId;
	}

	public String getDocumentNumber() {
		return _documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		_documentNumber = documentNumber;
	}

	public String getDocumentStatus() {
		return _documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		_documentStatus = documentStatus;
	}

	public Date getDocumentDate() {
		return _documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		_documentDate = documentDate;
	}

	public Date getDueDate() {
		return _dueDate;
	}

	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	public String getCarrier() {
		return _carrier;
	}

	public void setCarrier(String carrier) {
		_carrier = carrier;
	}

	public String getTrackingNumber() {
		return _trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		_trackingNumber = trackingNumber;
	}

	public BigDecimal getSubTotal() {
		return _subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		_subTotal = subTotal;
	}

	public BigDecimal getFreightAmount() {
		return _freightAmount;
	}

	public void setFreightAmount(BigDecimal freightAmount) {
		_freightAmount = freightAmount;
	}

	public BigDecimal getGst() {
		return _gst;
	}

	public void setGst(BigDecimal gst) {
		_gst = gst;
	}

	public BigDecimal getInvoiceTotal() {
		return _invoiceTotal;
	}

	public void setInvoiceTotal(BigDecimal invoiceTotal) {
		_invoiceTotal = invoiceTotal;
	}

	public BigDecimal getBalanceDue() {
		return _balanceDue;
	}

	public void setBalanceDue(BigDecimal balanceDue) {
		_balanceDue = balanceDue;
	}

	public String getTrackingURL() {
		return _trackingURL;
	}

	public void setTrackingURL(String trackingURL) {
		_trackingURL = trackingURL;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public BigDecimal getPaidSum() {
		return _paidSum;
	}

	public void setPaidSum(BigDecimal paidSum) {
		_paidSum = paidSum;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public long getBillingAddressId() {
		return _billingAddressId;
	}

	public void setBillingAddressId(long billingAddressId) {
		_billingAddressId = billingAddressId;
	}

	public long getShippingAddressId() {
		return _shippingAddressId;
	}

	public void setShippingAddressId(long shippingAddressId) {
		_shippingAddressId = shippingAddressId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _invoiceId;
	private long _groupId;
	private long _companyId;
	private long _createdByAccountId;
	private long _commerceOrderId;
	private String _accountExternalReferenceCode;
	private String _referenceNo;
	private String _createdBy;
	private Date _createDate;
	private Date _modifiedDate;
	private String _transactionId;
	private String _documentNumber;
	private String _documentStatus;
	private Date _documentDate;
	private Date _dueDate;
	private String _carrier;
	private String _trackingNumber;
	private BigDecimal _subTotal;
	private BigDecimal _freightAmount;
	private BigDecimal _gst;
	private BigDecimal _invoiceTotal;
	private BigDecimal _balanceDue;
	private String _trackingURL;
	private int _status;
	private BigDecimal _paidSum;
	private long _fileEntryId;
	private long _billingAddressId;
	private long _shippingAddressId;

}