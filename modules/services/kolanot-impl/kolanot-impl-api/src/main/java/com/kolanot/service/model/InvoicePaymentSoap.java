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

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class InvoicePaymentSoap implements Serializable {

	public static InvoicePaymentSoap toSoapModel(InvoicePayment model) {
		InvoicePaymentSoap soapModel = new InvoicePaymentSoap();

		soapModel.setInvoicePaymentId(model.getInvoicePaymentId());
		soapModel.setTransactionid(model.getTransactionid());
		soapModel.setInvoiceId(model.getInvoiceId());

		return soapModel;
	}

	public static InvoicePaymentSoap[] toSoapModels(InvoicePayment[] models) {
		InvoicePaymentSoap[] soapModels = new InvoicePaymentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InvoicePaymentSoap[][] toSoapModels(
		InvoicePayment[][] models) {

		InvoicePaymentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new InvoicePaymentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InvoicePaymentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InvoicePaymentSoap[] toSoapModels(
		List<InvoicePayment> models) {

		List<InvoicePaymentSoap> soapModels = new ArrayList<InvoicePaymentSoap>(
			models.size());

		for (InvoicePayment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InvoicePaymentSoap[soapModels.size()]);
	}

	public InvoicePaymentSoap() {
	}

	public long getPrimaryKey() {
		return _invoicePaymentId;
	}

	public void setPrimaryKey(long pk) {
		setInvoicePaymentId(pk);
	}

	public long getInvoicePaymentId() {
		return _invoicePaymentId;
	}

	public void setInvoicePaymentId(long invoicePaymentId) {
		_invoicePaymentId = invoicePaymentId;
	}

	public String getTransactionid() {
		return _transactionid;
	}

	public void setTransactionid(String transactionid) {
		_transactionid = transactionid;
	}

	public long getInvoiceId() {
		return _invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		_invoiceId = invoiceId;
	}

	private long _invoicePaymentId;
	private String _transactionid;
	private long _invoiceId;

}