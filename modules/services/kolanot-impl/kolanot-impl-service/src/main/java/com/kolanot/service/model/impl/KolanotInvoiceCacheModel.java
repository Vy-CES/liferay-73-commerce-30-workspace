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

package com.kolanot.service.model.impl;

import com.kolanot.service.model.KolanotInvoice;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

import java.util.Date;

/**
 * The cache model class for representing KolanotInvoice in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class KolanotInvoiceCacheModel
	implements CacheModel<KolanotInvoice>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof KolanotInvoiceCacheModel)) {
			return false;
		}

		KolanotInvoiceCacheModel kolanotInvoiceCacheModel =
			(KolanotInvoiceCacheModel)object;

		if (invoiceId == kolanotInvoiceCacheModel.invoiceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, invoiceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", invoiceId=");
		sb.append(invoiceId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdByAccountId=");
		sb.append(createdByAccountId);
		sb.append(", accountExternalReferenceCode=");
		sb.append(accountExternalReferenceCode);
		sb.append(", referenceNo=");
		sb.append(referenceNo);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", documentNumber=");
		sb.append(documentNumber);
		sb.append(", documentStatus=");
		sb.append(documentStatus);
		sb.append(", documentDate=");
		sb.append(documentDate);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", carrier=");
		sb.append(carrier);
		sb.append(", trackingNumber=");
		sb.append(trackingNumber);
		sb.append(", subTotal=");
		sb.append(subTotal);
		sb.append(", freightAmount=");
		sb.append(freightAmount);
		sb.append(", gst=");
		sb.append(gst);
		sb.append(", invoiceTotal=");
		sb.append(invoiceTotal);
		sb.append(", balanceDue=");
		sb.append(balanceDue);
		sb.append(", trackingURL=");
		sb.append(trackingURL);
		sb.append(", status=");
		sb.append(status);
		sb.append(", paidSum=");
		sb.append(paidSum);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", billingAddressId=");
		sb.append(billingAddressId);
		sb.append(", shippingAddressId=");
		sb.append(shippingAddressId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KolanotInvoice toEntityModel() {
		KolanotInvoiceImpl kolanotInvoiceImpl = new KolanotInvoiceImpl();

		if (uuid == null) {
			kolanotInvoiceImpl.setUuid("");
		}
		else {
			kolanotInvoiceImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			kolanotInvoiceImpl.setExternalReferenceCode("");
		}
		else {
			kolanotInvoiceImpl.setExternalReferenceCode(externalReferenceCode);
		}

		kolanotInvoiceImpl.setInvoiceId(invoiceId);
		kolanotInvoiceImpl.setGroupId(groupId);
		kolanotInvoiceImpl.setCompanyId(companyId);
		kolanotInvoiceImpl.setCreatedByAccountId(createdByAccountId);

		if (accountExternalReferenceCode == null) {
			kolanotInvoiceImpl.setAccountExternalReferenceCode("");
		}
		else {
			kolanotInvoiceImpl.setAccountExternalReferenceCode(
				accountExternalReferenceCode);
		}

		if (referenceNo == null) {
			kolanotInvoiceImpl.setReferenceNo("");
		}
		else {
			kolanotInvoiceImpl.setReferenceNo(referenceNo);
		}

		if (createdBy == null) {
			kolanotInvoiceImpl.setCreatedBy("");
		}
		else {
			kolanotInvoiceImpl.setCreatedBy(createdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			kolanotInvoiceImpl.setCreateDate(null);
		}
		else {
			kolanotInvoiceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kolanotInvoiceImpl.setModifiedDate(null);
		}
		else {
			kolanotInvoiceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (documentNumber == null) {
			kolanotInvoiceImpl.setDocumentNumber("");
		}
		else {
			kolanotInvoiceImpl.setDocumentNumber(documentNumber);
		}

		if (documentStatus == null) {
			kolanotInvoiceImpl.setDocumentStatus("");
		}
		else {
			kolanotInvoiceImpl.setDocumentStatus(documentStatus);
		}

		if (documentDate == Long.MIN_VALUE) {
			kolanotInvoiceImpl.setDocumentDate(null);
		}
		else {
			kolanotInvoiceImpl.setDocumentDate(new Date(documentDate));
		}

		if (dueDate == Long.MIN_VALUE) {
			kolanotInvoiceImpl.setDueDate(null);
		}
		else {
			kolanotInvoiceImpl.setDueDate(new Date(dueDate));
		}

		if (carrier == null) {
			kolanotInvoiceImpl.setCarrier("");
		}
		else {
			kolanotInvoiceImpl.setCarrier(carrier);
		}

		if (trackingNumber == null) {
			kolanotInvoiceImpl.setTrackingNumber("");
		}
		else {
			kolanotInvoiceImpl.setTrackingNumber(trackingNumber);
		}

		kolanotInvoiceImpl.setSubTotal(subTotal);
		kolanotInvoiceImpl.setFreightAmount(freightAmount);
		kolanotInvoiceImpl.setGst(gst);
		kolanotInvoiceImpl.setInvoiceTotal(invoiceTotal);
		kolanotInvoiceImpl.setBalanceDue(balanceDue);

		if (trackingURL == null) {
			kolanotInvoiceImpl.setTrackingURL("");
		}
		else {
			kolanotInvoiceImpl.setTrackingURL(trackingURL);
		}

		kolanotInvoiceImpl.setStatus(status);
		kolanotInvoiceImpl.setPaidSum(paidSum);
		kolanotInvoiceImpl.setFileEntryId(fileEntryId);
		kolanotInvoiceImpl.setBillingAddressId(billingAddressId);
		kolanotInvoiceImpl.setShippingAddressId(shippingAddressId);

		kolanotInvoiceImpl.resetOriginalValues();

		return kolanotInvoiceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		invoiceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		createdByAccountId = objectInput.readLong();
		accountExternalReferenceCode = objectInput.readUTF();
		referenceNo = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		documentNumber = objectInput.readUTF();
		documentStatus = objectInput.readUTF();
		documentDate = objectInput.readLong();
		dueDate = objectInput.readLong();
		carrier = objectInput.readUTF();
		trackingNumber = objectInput.readUTF();
		subTotal = (BigDecimal)objectInput.readObject();
		freightAmount = (BigDecimal)objectInput.readObject();
		gst = (BigDecimal)objectInput.readObject();
		invoiceTotal = (BigDecimal)objectInput.readObject();
		balanceDue = (BigDecimal)objectInput.readObject();
		trackingURL = objectInput.readUTF();

		status = objectInput.readInt();
		paidSum = (BigDecimal)objectInput.readObject();

		fileEntryId = objectInput.readLong();

		billingAddressId = objectInput.readLong();

		shippingAddressId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (externalReferenceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalReferenceCode);
		}

		objectOutput.writeLong(invoiceId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdByAccountId);

		if (accountExternalReferenceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accountExternalReferenceCode);
		}

		if (referenceNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(referenceNo);
		}

		if (createdBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (documentNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentNumber);
		}

		if (documentStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentStatus);
		}

		objectOutput.writeLong(documentDate);
		objectOutput.writeLong(dueDate);

		if (carrier == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(carrier);
		}

		if (trackingNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trackingNumber);
		}

		objectOutput.writeObject(subTotal);
		objectOutput.writeObject(freightAmount);
		objectOutput.writeObject(gst);
		objectOutput.writeObject(invoiceTotal);
		objectOutput.writeObject(balanceDue);

		if (trackingURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trackingURL);
		}

		objectOutput.writeInt(status);
		objectOutput.writeObject(paidSum);

		objectOutput.writeLong(fileEntryId);

		objectOutput.writeLong(billingAddressId);

		objectOutput.writeLong(shippingAddressId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long invoiceId;
	public long groupId;
	public long companyId;
	public long createdByAccountId;
	public String accountExternalReferenceCode;
	public String referenceNo;
	public String createdBy;
	public long createDate;
	public long modifiedDate;
	public String documentNumber;
	public String documentStatus;
	public long documentDate;
	public long dueDate;
	public String carrier;
	public String trackingNumber;
	public BigDecimal subTotal;
	public BigDecimal freightAmount;
	public BigDecimal gst;
	public BigDecimal invoiceTotal;
	public BigDecimal balanceDue;
	public String trackingURL;
	public int status;
	public BigDecimal paidSum;
	public long fileEntryId;
	public long billingAddressId;
	public long shippingAddressId;

}