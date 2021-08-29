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

import com.kolanot.service.model.KolanotInvoiceLine;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

/**
 * The cache model class for representing KolanotInvoiceLine in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class KolanotInvoiceLineCacheModel
	implements CacheModel<KolanotInvoiceLine>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof KolanotInvoiceLineCacheModel)) {
			return false;
		}

		KolanotInvoiceLineCacheModel kolanotInvoiceLineCacheModel =
			(KolanotInvoiceLineCacheModel)object;

		if (invoiceLineId == kolanotInvoiceLineCacheModel.invoiceLineId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, invoiceLineId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", invoiceLineId=");
		sb.append(invoiceLineId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", invoiceId=");
		sb.append(invoiceId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", lineNum=");
		sb.append(lineNum);
		sb.append(", itemCode=");
		sb.append(itemCode);
		sb.append(", itemName=");
		sb.append(itemName);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", price=");
		sb.append(price);
		sb.append(", discountPercent=");
		sb.append(discountPercent);
		sb.append(", lineTotal=");
		sb.append(lineTotal);
		sb.append(", salesOrderID=");
		sb.append(salesOrderID);
		sb.append(", salesOrderDocNum=");
		sb.append(salesOrderDocNum);
		sb.append(", salesOrderLineNum=");
		sb.append(salesOrderLineNum);
		sb.append(", salesOrderQty=");
		sb.append(salesOrderQty);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KolanotInvoiceLine toEntityModel() {
		KolanotInvoiceLineImpl kolanotInvoiceLineImpl =
			new KolanotInvoiceLineImpl();

		if (uuid == null) {
			kolanotInvoiceLineImpl.setUuid("");
		}
		else {
			kolanotInvoiceLineImpl.setUuid(uuid);
		}

		kolanotInvoiceLineImpl.setInvoiceLineId(invoiceLineId);
		kolanotInvoiceLineImpl.setGroupId(groupId);
		kolanotInvoiceLineImpl.setInvoiceId(invoiceId);
		kolanotInvoiceLineImpl.setCompanyId(companyId);
		kolanotInvoiceLineImpl.setLineNum(lineNum);

		if (itemCode == null) {
			kolanotInvoiceLineImpl.setItemCode("");
		}
		else {
			kolanotInvoiceLineImpl.setItemCode(itemCode);
		}

		if (itemName == null) {
			kolanotInvoiceLineImpl.setItemName("");
		}
		else {
			kolanotInvoiceLineImpl.setItemName(itemName);
		}

		kolanotInvoiceLineImpl.setQuantity(quantity);
		kolanotInvoiceLineImpl.setPrice(price);
		kolanotInvoiceLineImpl.setDiscountPercent(discountPercent);
		kolanotInvoiceLineImpl.setLineTotal(lineTotal);

		if (salesOrderID == null) {
			kolanotInvoiceLineImpl.setSalesOrderID("");
		}
		else {
			kolanotInvoiceLineImpl.setSalesOrderID(salesOrderID);
		}

		if (salesOrderDocNum == null) {
			kolanotInvoiceLineImpl.setSalesOrderDocNum("");
		}
		else {
			kolanotInvoiceLineImpl.setSalesOrderDocNum(salesOrderDocNum);
		}

		kolanotInvoiceLineImpl.setSalesOrderLineNum(salesOrderLineNum);
		kolanotInvoiceLineImpl.setSalesOrderQty(salesOrderQty);

		kolanotInvoiceLineImpl.resetOriginalValues();

		return kolanotInvoiceLineImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		invoiceLineId = objectInput.readLong();

		groupId = objectInput.readLong();

		invoiceId = objectInput.readLong();

		companyId = objectInput.readLong();

		lineNum = objectInput.readInt();
		itemCode = objectInput.readUTF();
		itemName = objectInput.readUTF();

		quantity = objectInput.readInt();
		price = (BigDecimal)objectInput.readObject();
		discountPercent = (BigDecimal)objectInput.readObject();
		lineTotal = (BigDecimal)objectInput.readObject();
		salesOrderID = objectInput.readUTF();
		salesOrderDocNum = objectInput.readUTF();

		salesOrderLineNum = objectInput.readInt();

		salesOrderQty = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(invoiceLineId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(invoiceId);

		objectOutput.writeLong(companyId);

		objectOutput.writeInt(lineNum);

		if (itemCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(itemCode);
		}

		if (itemName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(itemName);
		}

		objectOutput.writeInt(quantity);
		objectOutput.writeObject(price);
		objectOutput.writeObject(discountPercent);
		objectOutput.writeObject(lineTotal);

		if (salesOrderID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(salesOrderID);
		}

		if (salesOrderDocNum == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(salesOrderDocNum);
		}

		objectOutput.writeInt(salesOrderLineNum);

		objectOutput.writeInt(salesOrderQty);
	}

	public String uuid;
	public long invoiceLineId;
	public long groupId;
	public long invoiceId;
	public long companyId;
	public int lineNum;
	public String itemCode;
	public String itemName;
	public int quantity;
	public BigDecimal price;
	public BigDecimal discountPercent;
	public BigDecimal lineTotal;
	public String salesOrderID;
	public String salesOrderDocNum;
	public int salesOrderLineNum;
	public int salesOrderQty;

}