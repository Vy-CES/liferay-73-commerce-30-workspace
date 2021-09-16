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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link InvoicePayment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoicePayment
 * @generated
 */
public class InvoicePaymentWrapper
	extends BaseModelWrapper<InvoicePayment>
	implements InvoicePayment, ModelWrapper<InvoicePayment> {

	public InvoicePaymentWrapper(InvoicePayment invoicePayment) {
		super(invoicePayment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("invoicePaymentId", getInvoicePaymentId());
		attributes.put("transactionid", getTransactionid());
		attributes.put("invoiceId", getInvoiceId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long invoicePaymentId = (Long)attributes.get("invoicePaymentId");

		if (invoicePaymentId != null) {
			setInvoicePaymentId(invoicePaymentId);
		}

		String transactionid = (String)attributes.get("transactionid");

		if (transactionid != null) {
			setTransactionid(transactionid);
		}

		Long invoiceId = (Long)attributes.get("invoiceId");

		if (invoiceId != null) {
			setInvoiceId(invoiceId);
		}
	}

	/**
	 * Returns the invoice ID of this invoice payment.
	 *
	 * @return the invoice ID of this invoice payment
	 */
	@Override
	public long getInvoiceId() {
		return model.getInvoiceId();
	}

	/**
	 * Returns the invoice payment ID of this invoice payment.
	 *
	 * @return the invoice payment ID of this invoice payment
	 */
	@Override
	public long getInvoicePaymentId() {
		return model.getInvoicePaymentId();
	}

	/**
	 * Returns the primary key of this invoice payment.
	 *
	 * @return the primary key of this invoice payment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the transactionid of this invoice payment.
	 *
	 * @return the transactionid of this invoice payment
	 */
	@Override
	public String getTransactionid() {
		return model.getTransactionid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the invoice ID of this invoice payment.
	 *
	 * @param invoiceId the invoice ID of this invoice payment
	 */
	@Override
	public void setInvoiceId(long invoiceId) {
		model.setInvoiceId(invoiceId);
	}

	/**
	 * Sets the invoice payment ID of this invoice payment.
	 *
	 * @param invoicePaymentId the invoice payment ID of this invoice payment
	 */
	@Override
	public void setInvoicePaymentId(long invoicePaymentId) {
		model.setInvoicePaymentId(invoicePaymentId);
	}

	/**
	 * Sets the primary key of this invoice payment.
	 *
	 * @param primaryKey the primary key of this invoice payment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the transactionid of this invoice payment.
	 *
	 * @param transactionid the transactionid of this invoice payment
	 */
	@Override
	public void setTransactionid(String transactionid) {
		model.setTransactionid(transactionid);
	}

	@Override
	protected InvoicePaymentWrapper wrap(InvoicePayment invoicePayment) {
		return new InvoicePaymentWrapper(invoicePayment);
	}

}