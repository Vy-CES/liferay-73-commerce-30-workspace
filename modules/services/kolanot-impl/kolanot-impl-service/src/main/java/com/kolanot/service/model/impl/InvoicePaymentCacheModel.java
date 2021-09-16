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

import com.kolanot.service.model.InvoicePayment;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing InvoicePayment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class InvoicePaymentCacheModel
	implements CacheModel<InvoicePayment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InvoicePaymentCacheModel)) {
			return false;
		}

		InvoicePaymentCacheModel invoicePaymentCacheModel =
			(InvoicePaymentCacheModel)object;

		if (invoicePaymentId == invoicePaymentCacheModel.invoicePaymentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, invoicePaymentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{invoicePaymentId=");
		sb.append(invoicePaymentId);
		sb.append(", transactionid=");
		sb.append(transactionid);
		sb.append(", invoiceId=");
		sb.append(invoiceId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InvoicePayment toEntityModel() {
		InvoicePaymentImpl invoicePaymentImpl = new InvoicePaymentImpl();

		invoicePaymentImpl.setInvoicePaymentId(invoicePaymentId);

		if (transactionid == null) {
			invoicePaymentImpl.setTransactionid("");
		}
		else {
			invoicePaymentImpl.setTransactionid(transactionid);
		}

		invoicePaymentImpl.setInvoiceId(invoiceId);

		invoicePaymentImpl.resetOriginalValues();

		return invoicePaymentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		invoicePaymentId = objectInput.readLong();
		transactionid = objectInput.readUTF();

		invoiceId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(invoicePaymentId);

		if (transactionid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(transactionid);
		}

		objectOutput.writeLong(invoiceId);
	}

	public long invoicePaymentId;
	public String transactionid;
	public long invoiceId;

}