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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link KolanotInvoice}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoice
 * @generated
 */
public class KolanotInvoiceWrapper
	extends BaseModelWrapper<KolanotInvoice>
	implements KolanotInvoice, ModelWrapper<KolanotInvoice> {

	public KolanotInvoiceWrapper(KolanotInvoice kolanotInvoice) {
		super(kolanotInvoice);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("invoiceId", getInvoiceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdByAccountId", getCreatedByAccountId());
		attributes.put(
			"accountExternalReferenceCode", getAccountExternalReferenceCode());
		attributes.put("referenceNo", getReferenceNo());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("documentNumber", getDocumentNumber());
		attributes.put("documentStatus", getDocumentStatus());
		attributes.put("documentDate", getDocumentDate());
		attributes.put("dueDate", getDueDate());
		attributes.put("carrier", getCarrier());
		attributes.put("trackingNumber", getTrackingNumber());
		attributes.put("subTotal", getSubTotal());
		attributes.put("freightAmount", getFreightAmount());
		attributes.put("gst", getGst());
		attributes.put("invoiceTotal", getInvoiceTotal());
		attributes.put("balanceDue", getBalanceDue());
		attributes.put("trackingURL", getTrackingURL());
		attributes.put("status", getStatus());
		attributes.put("paidSum", getPaidSum());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("billingAddressId", getBillingAddressId());
		attributes.put("shippingAddressId", getShippingAddressId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String externalReferenceCode = (String)attributes.get(
			"externalReferenceCode");

		if (externalReferenceCode != null) {
			setExternalReferenceCode(externalReferenceCode);
		}

		Long invoiceId = (Long)attributes.get("invoiceId");

		if (invoiceId != null) {
			setInvoiceId(invoiceId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdByAccountId = (Long)attributes.get("createdByAccountId");

		if (createdByAccountId != null) {
			setCreatedByAccountId(createdByAccountId);
		}

		String accountExternalReferenceCode = (String)attributes.get(
			"accountExternalReferenceCode");

		if (accountExternalReferenceCode != null) {
			setAccountExternalReferenceCode(accountExternalReferenceCode);
		}

		String referenceNo = (String)attributes.get("referenceNo");

		if (referenceNo != null) {
			setReferenceNo(referenceNo);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String documentNumber = (String)attributes.get("documentNumber");

		if (documentNumber != null) {
			setDocumentNumber(documentNumber);
		}

		String documentStatus = (String)attributes.get("documentStatus");

		if (documentStatus != null) {
			setDocumentStatus(documentStatus);
		}

		Date documentDate = (Date)attributes.get("documentDate");

		if (documentDate != null) {
			setDocumentDate(documentDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		String carrier = (String)attributes.get("carrier");

		if (carrier != null) {
			setCarrier(carrier);
		}

		String trackingNumber = (String)attributes.get("trackingNumber");

		if (trackingNumber != null) {
			setTrackingNumber(trackingNumber);
		}

		BigDecimal subTotal = (BigDecimal)attributes.get("subTotal");

		if (subTotal != null) {
			setSubTotal(subTotal);
		}

		BigDecimal freightAmount = (BigDecimal)attributes.get("freightAmount");

		if (freightAmount != null) {
			setFreightAmount(freightAmount);
		}

		BigDecimal gst = (BigDecimal)attributes.get("gst");

		if (gst != null) {
			setGst(gst);
		}

		BigDecimal invoiceTotal = (BigDecimal)attributes.get("invoiceTotal");

		if (invoiceTotal != null) {
			setInvoiceTotal(invoiceTotal);
		}

		BigDecimal balanceDue = (BigDecimal)attributes.get("balanceDue");

		if (balanceDue != null) {
			setBalanceDue(balanceDue);
		}

		String trackingURL = (String)attributes.get("trackingURL");

		if (trackingURL != null) {
			setTrackingURL(trackingURL);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		BigDecimal paidSum = (BigDecimal)attributes.get("paidSum");

		if (paidSum != null) {
			setPaidSum(paidSum);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long billingAddressId = (Long)attributes.get("billingAddressId");

		if (billingAddressId != null) {
			setBillingAddressId(billingAddressId);
		}

		Long shippingAddressId = (Long)attributes.get("shippingAddressId");

		if (shippingAddressId != null) {
			setShippingAddressId(shippingAddressId);
		}
	}

	/**
	 * Returns the account external reference code of this kolanot invoice.
	 *
	 * @return the account external reference code of this kolanot invoice
	 */
	@Override
	public String getAccountExternalReferenceCode() {
		return model.getAccountExternalReferenceCode();
	}

	/**
	 * Returns the balance due of this kolanot invoice.
	 *
	 * @return the balance due of this kolanot invoice
	 */
	@Override
	public BigDecimal getBalanceDue() {
		return model.getBalanceDue();
	}

	/**
	 * Returns the billing address ID of this kolanot invoice.
	 *
	 * @return the billing address ID of this kolanot invoice
	 */
	@Override
	public long getBillingAddressId() {
		return model.getBillingAddressId();
	}

	/**
	 * Returns the carrier of this kolanot invoice.
	 *
	 * @return the carrier of this kolanot invoice
	 */
	@Override
	public String getCarrier() {
		return model.getCarrier();
	}

	/**
	 * Returns the company ID of this kolanot invoice.
	 *
	 * @return the company ID of this kolanot invoice
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this kolanot invoice.
	 *
	 * @return the create date of this kolanot invoice
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this kolanot invoice.
	 *
	 * @return the created by of this kolanot invoice
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created by account ID of this kolanot invoice.
	 *
	 * @return the created by account ID of this kolanot invoice
	 */
	@Override
	public long getCreatedByAccountId() {
		return model.getCreatedByAccountId();
	}

	/**
	 * Returns the document date of this kolanot invoice.
	 *
	 * @return the document date of this kolanot invoice
	 */
	@Override
	public Date getDocumentDate() {
		return model.getDocumentDate();
	}

	/**
	 * Returns the document number of this kolanot invoice.
	 *
	 * @return the document number of this kolanot invoice
	 */
	@Override
	public String getDocumentNumber() {
		return model.getDocumentNumber();
	}

	/**
	 * Returns the document status of this kolanot invoice.
	 *
	 * @return the document status of this kolanot invoice
	 */
	@Override
	public String getDocumentStatus() {
		return model.getDocumentStatus();
	}

	/**
	 * Returns the due date of this kolanot invoice.
	 *
	 * @return the due date of this kolanot invoice
	 */
	@Override
	public Date getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the external reference code of this kolanot invoice.
	 *
	 * @return the external reference code of this kolanot invoice
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the file entry ID of this kolanot invoice.
	 *
	 * @return the file entry ID of this kolanot invoice
	 */
	@Override
	public long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the freight amount of this kolanot invoice.
	 *
	 * @return the freight amount of this kolanot invoice
	 */
	@Override
	public BigDecimal getFreightAmount() {
		return model.getFreightAmount();
	}

	/**
	 * Returns the group ID of this kolanot invoice.
	 *
	 * @return the group ID of this kolanot invoice
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the gst of this kolanot invoice.
	 *
	 * @return the gst of this kolanot invoice
	 */
	@Override
	public BigDecimal getGst() {
		return model.getGst();
	}

	/**
	 * Returns the invoice ID of this kolanot invoice.
	 *
	 * @return the invoice ID of this kolanot invoice
	 */
	@Override
	public long getInvoiceId() {
		return model.getInvoiceId();
	}

	/**
	 * Returns the invoice total of this kolanot invoice.
	 *
	 * @return the invoice total of this kolanot invoice
	 */
	@Override
	public BigDecimal getInvoiceTotal() {
		return model.getInvoiceTotal();
	}

	/**
	 * Returns the modified date of this kolanot invoice.
	 *
	 * @return the modified date of this kolanot invoice
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the paid sum of this kolanot invoice.
	 *
	 * @return the paid sum of this kolanot invoice
	 */
	@Override
	public BigDecimal getPaidSum() {
		return model.getPaidSum();
	}

	/**
	 * Returns the primary key of this kolanot invoice.
	 *
	 * @return the primary key of this kolanot invoice
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reference no of this kolanot invoice.
	 *
	 * @return the reference no of this kolanot invoice
	 */
	@Override
	public String getReferenceNo() {
		return model.getReferenceNo();
	}

	/**
	 * Returns the shipping address ID of this kolanot invoice.
	 *
	 * @return the shipping address ID of this kolanot invoice
	 */
	@Override
	public long getShippingAddressId() {
		return model.getShippingAddressId();
	}

	/**
	 * Returns the status of this kolanot invoice.
	 *
	 * @return the status of this kolanot invoice
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the sub total of this kolanot invoice.
	 *
	 * @return the sub total of this kolanot invoice
	 */
	@Override
	public BigDecimal getSubTotal() {
		return model.getSubTotal();
	}

	/**
	 * Returns the tracking number of this kolanot invoice.
	 *
	 * @return the tracking number of this kolanot invoice
	 */
	@Override
	public String getTrackingNumber() {
		return model.getTrackingNumber();
	}

	/**
	 * Returns the tracking url of this kolanot invoice.
	 *
	 * @return the tracking url of this kolanot invoice
	 */
	@Override
	public String getTrackingURL() {
		return model.getTrackingURL();
	}

	/**
	 * Returns the uuid of this kolanot invoice.
	 *
	 * @return the uuid of this kolanot invoice
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the account external reference code of this kolanot invoice.
	 *
	 * @param accountExternalReferenceCode the account external reference code of this kolanot invoice
	 */
	@Override
	public void setAccountExternalReferenceCode(
		String accountExternalReferenceCode) {

		model.setAccountExternalReferenceCode(accountExternalReferenceCode);
	}

	/**
	 * Sets the balance due of this kolanot invoice.
	 *
	 * @param balanceDue the balance due of this kolanot invoice
	 */
	@Override
	public void setBalanceDue(BigDecimal balanceDue) {
		model.setBalanceDue(balanceDue);
	}

	/**
	 * Sets the billing address ID of this kolanot invoice.
	 *
	 * @param billingAddressId the billing address ID of this kolanot invoice
	 */
	@Override
	public void setBillingAddressId(long billingAddressId) {
		model.setBillingAddressId(billingAddressId);
	}

	/**
	 * Sets the carrier of this kolanot invoice.
	 *
	 * @param carrier the carrier of this kolanot invoice
	 */
	@Override
	public void setCarrier(String carrier) {
		model.setCarrier(carrier);
	}

	/**
	 * Sets the company ID of this kolanot invoice.
	 *
	 * @param companyId the company ID of this kolanot invoice
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this kolanot invoice.
	 *
	 * @param createDate the create date of this kolanot invoice
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this kolanot invoice.
	 *
	 * @param createdBy the created by of this kolanot invoice
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created by account ID of this kolanot invoice.
	 *
	 * @param createdByAccountId the created by account ID of this kolanot invoice
	 */
	@Override
	public void setCreatedByAccountId(long createdByAccountId) {
		model.setCreatedByAccountId(createdByAccountId);
	}

	/**
	 * Sets the document date of this kolanot invoice.
	 *
	 * @param documentDate the document date of this kolanot invoice
	 */
	@Override
	public void setDocumentDate(Date documentDate) {
		model.setDocumentDate(documentDate);
	}

	/**
	 * Sets the document number of this kolanot invoice.
	 *
	 * @param documentNumber the document number of this kolanot invoice
	 */
	@Override
	public void setDocumentNumber(String documentNumber) {
		model.setDocumentNumber(documentNumber);
	}

	/**
	 * Sets the document status of this kolanot invoice.
	 *
	 * @param documentStatus the document status of this kolanot invoice
	 */
	@Override
	public void setDocumentStatus(String documentStatus) {
		model.setDocumentStatus(documentStatus);
	}

	/**
	 * Sets the due date of this kolanot invoice.
	 *
	 * @param dueDate the due date of this kolanot invoice
	 */
	@Override
	public void setDueDate(Date dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the external reference code of this kolanot invoice.
	 *
	 * @param externalReferenceCode the external reference code of this kolanot invoice
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the file entry ID of this kolanot invoice.
	 *
	 * @param fileEntryId the file entry ID of this kolanot invoice
	 */
	@Override
	public void setFileEntryId(long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the freight amount of this kolanot invoice.
	 *
	 * @param freightAmount the freight amount of this kolanot invoice
	 */
	@Override
	public void setFreightAmount(BigDecimal freightAmount) {
		model.setFreightAmount(freightAmount);
	}

	/**
	 * Sets the group ID of this kolanot invoice.
	 *
	 * @param groupId the group ID of this kolanot invoice
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the gst of this kolanot invoice.
	 *
	 * @param gst the gst of this kolanot invoice
	 */
	@Override
	public void setGst(BigDecimal gst) {
		model.setGst(gst);
	}

	/**
	 * Sets the invoice ID of this kolanot invoice.
	 *
	 * @param invoiceId the invoice ID of this kolanot invoice
	 */
	@Override
	public void setInvoiceId(long invoiceId) {
		model.setInvoiceId(invoiceId);
	}

	/**
	 * Sets the invoice total of this kolanot invoice.
	 *
	 * @param invoiceTotal the invoice total of this kolanot invoice
	 */
	@Override
	public void setInvoiceTotal(BigDecimal invoiceTotal) {
		model.setInvoiceTotal(invoiceTotal);
	}

	/**
	 * Sets the modified date of this kolanot invoice.
	 *
	 * @param modifiedDate the modified date of this kolanot invoice
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the paid sum of this kolanot invoice.
	 *
	 * @param paidSum the paid sum of this kolanot invoice
	 */
	@Override
	public void setPaidSum(BigDecimal paidSum) {
		model.setPaidSum(paidSum);
	}

	/**
	 * Sets the primary key of this kolanot invoice.
	 *
	 * @param primaryKey the primary key of this kolanot invoice
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reference no of this kolanot invoice.
	 *
	 * @param referenceNo the reference no of this kolanot invoice
	 */
	@Override
	public void setReferenceNo(String referenceNo) {
		model.setReferenceNo(referenceNo);
	}

	/**
	 * Sets the shipping address ID of this kolanot invoice.
	 *
	 * @param shippingAddressId the shipping address ID of this kolanot invoice
	 */
	@Override
	public void setShippingAddressId(long shippingAddressId) {
		model.setShippingAddressId(shippingAddressId);
	}

	/**
	 * Sets the status of this kolanot invoice.
	 *
	 * @param status the status of this kolanot invoice
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the sub total of this kolanot invoice.
	 *
	 * @param subTotal the sub total of this kolanot invoice
	 */
	@Override
	public void setSubTotal(BigDecimal subTotal) {
		model.setSubTotal(subTotal);
	}

	/**
	 * Sets the tracking number of this kolanot invoice.
	 *
	 * @param trackingNumber the tracking number of this kolanot invoice
	 */
	@Override
	public void setTrackingNumber(String trackingNumber) {
		model.setTrackingNumber(trackingNumber);
	}

	/**
	 * Sets the tracking url of this kolanot invoice.
	 *
	 * @param trackingURL the tracking url of this kolanot invoice
	 */
	@Override
	public void setTrackingURL(String trackingURL) {
		model.setTrackingURL(trackingURL);
	}

	/**
	 * Sets the uuid of this kolanot invoice.
	 *
	 * @param uuid the uuid of this kolanot invoice
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected KolanotInvoiceWrapper wrap(KolanotInvoice kolanotInvoice) {
		return new KolanotInvoiceWrapper(kolanotInvoice);
	}

}