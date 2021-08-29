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

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link KolanotInvoiceLine}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoiceLine
 * @generated
 */
public class KolanotInvoiceLineWrapper
	extends BaseModelWrapper<KolanotInvoiceLine>
	implements KolanotInvoiceLine, ModelWrapper<KolanotInvoiceLine> {

	public KolanotInvoiceLineWrapper(KolanotInvoiceLine kolanotInvoiceLine) {
		super(kolanotInvoiceLine);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("invoiceLineId", getInvoiceLineId());
		attributes.put("groupId", getGroupId());
		attributes.put("invoiceId", getInvoiceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("lineNum", getLineNum());
		attributes.put("itemCode", getItemCode());
		attributes.put("itemName", getItemName());
		attributes.put("quantity", getQuantity());
		attributes.put("price", getPrice());
		attributes.put("discountPercent", getDiscountPercent());
		attributes.put("lineTotal", getLineTotal());
		attributes.put("salesOrderID", getSalesOrderID());
		attributes.put("salesOrderDocNum", getSalesOrderDocNum());
		attributes.put("salesOrderLineNum", getSalesOrderLineNum());
		attributes.put("salesOrderQty", getSalesOrderQty());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long invoiceLineId = (Long)attributes.get("invoiceLineId");

		if (invoiceLineId != null) {
			setInvoiceLineId(invoiceLineId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long invoiceId = (Long)attributes.get("invoiceId");

		if (invoiceId != null) {
			setInvoiceId(invoiceId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Integer lineNum = (Integer)attributes.get("lineNum");

		if (lineNum != null) {
			setLineNum(lineNum);
		}

		String itemCode = (String)attributes.get("itemCode");

		if (itemCode != null) {
			setItemCode(itemCode);
		}

		String itemName = (String)attributes.get("itemName");

		if (itemName != null) {
			setItemName(itemName);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		BigDecimal price = (BigDecimal)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		BigDecimal discountPercent = (BigDecimal)attributes.get(
			"discountPercent");

		if (discountPercent != null) {
			setDiscountPercent(discountPercent);
		}

		BigDecimal lineTotal = (BigDecimal)attributes.get("lineTotal");

		if (lineTotal != null) {
			setLineTotal(lineTotal);
		}

		String salesOrderID = (String)attributes.get("salesOrderID");

		if (salesOrderID != null) {
			setSalesOrderID(salesOrderID);
		}

		String salesOrderDocNum = (String)attributes.get("salesOrderDocNum");

		if (salesOrderDocNum != null) {
			setSalesOrderDocNum(salesOrderDocNum);
		}

		Integer salesOrderLineNum = (Integer)attributes.get(
			"salesOrderLineNum");

		if (salesOrderLineNum != null) {
			setSalesOrderLineNum(salesOrderLineNum);
		}

		Integer salesOrderQty = (Integer)attributes.get("salesOrderQty");

		if (salesOrderQty != null) {
			setSalesOrderQty(salesOrderQty);
		}
	}

	/**
	 * Returns the company ID of this kolanot invoice line.
	 *
	 * @return the company ID of this kolanot invoice line
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the discount percent of this kolanot invoice line.
	 *
	 * @return the discount percent of this kolanot invoice line
	 */
	@Override
	public BigDecimal getDiscountPercent() {
		return model.getDiscountPercent();
	}

	/**
	 * Returns the group ID of this kolanot invoice line.
	 *
	 * @return the group ID of this kolanot invoice line
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the invoice ID of this kolanot invoice line.
	 *
	 * @return the invoice ID of this kolanot invoice line
	 */
	@Override
	public long getInvoiceId() {
		return model.getInvoiceId();
	}

	/**
	 * Returns the invoice line ID of this kolanot invoice line.
	 *
	 * @return the invoice line ID of this kolanot invoice line
	 */
	@Override
	public long getInvoiceLineId() {
		return model.getInvoiceLineId();
	}

	/**
	 * Returns the item code of this kolanot invoice line.
	 *
	 * @return the item code of this kolanot invoice line
	 */
	@Override
	public String getItemCode() {
		return model.getItemCode();
	}

	/**
	 * Returns the item name of this kolanot invoice line.
	 *
	 * @return the item name of this kolanot invoice line
	 */
	@Override
	public String getItemName() {
		return model.getItemName();
	}

	/**
	 * Returns the line num of this kolanot invoice line.
	 *
	 * @return the line num of this kolanot invoice line
	 */
	@Override
	public int getLineNum() {
		return model.getLineNum();
	}

	/**
	 * Returns the line total of this kolanot invoice line.
	 *
	 * @return the line total of this kolanot invoice line
	 */
	@Override
	public BigDecimal getLineTotal() {
		return model.getLineTotal();
	}

	/**
	 * Returns the price of this kolanot invoice line.
	 *
	 * @return the price of this kolanot invoice line
	 */
	@Override
	public BigDecimal getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this kolanot invoice line.
	 *
	 * @return the primary key of this kolanot invoice line
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quantity of this kolanot invoice line.
	 *
	 * @return the quantity of this kolanot invoice line
	 */
	@Override
	public int getQuantity() {
		return model.getQuantity();
	}

	/**
	 * Returns the sales order doc num of this kolanot invoice line.
	 *
	 * @return the sales order doc num of this kolanot invoice line
	 */
	@Override
	public String getSalesOrderDocNum() {
		return model.getSalesOrderDocNum();
	}

	/**
	 * Returns the sales order ID of this kolanot invoice line.
	 *
	 * @return the sales order ID of this kolanot invoice line
	 */
	@Override
	public String getSalesOrderID() {
		return model.getSalesOrderID();
	}

	/**
	 * Returns the sales order line num of this kolanot invoice line.
	 *
	 * @return the sales order line num of this kolanot invoice line
	 */
	@Override
	public int getSalesOrderLineNum() {
		return model.getSalesOrderLineNum();
	}

	/**
	 * Returns the sales order qty of this kolanot invoice line.
	 *
	 * @return the sales order qty of this kolanot invoice line
	 */
	@Override
	public int getSalesOrderQty() {
		return model.getSalesOrderQty();
	}

	/**
	 * Returns the uuid of this kolanot invoice line.
	 *
	 * @return the uuid of this kolanot invoice line
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
	 * Sets the company ID of this kolanot invoice line.
	 *
	 * @param companyId the company ID of this kolanot invoice line
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the discount percent of this kolanot invoice line.
	 *
	 * @param discountPercent the discount percent of this kolanot invoice line
	 */
	@Override
	public void setDiscountPercent(BigDecimal discountPercent) {
		model.setDiscountPercent(discountPercent);
	}

	/**
	 * Sets the group ID of this kolanot invoice line.
	 *
	 * @param groupId the group ID of this kolanot invoice line
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the invoice ID of this kolanot invoice line.
	 *
	 * @param invoiceId the invoice ID of this kolanot invoice line
	 */
	@Override
	public void setInvoiceId(long invoiceId) {
		model.setInvoiceId(invoiceId);
	}

	/**
	 * Sets the invoice line ID of this kolanot invoice line.
	 *
	 * @param invoiceLineId the invoice line ID of this kolanot invoice line
	 */
	@Override
	public void setInvoiceLineId(long invoiceLineId) {
		model.setInvoiceLineId(invoiceLineId);
	}

	/**
	 * Sets the item code of this kolanot invoice line.
	 *
	 * @param itemCode the item code of this kolanot invoice line
	 */
	@Override
	public void setItemCode(String itemCode) {
		model.setItemCode(itemCode);
	}

	/**
	 * Sets the item name of this kolanot invoice line.
	 *
	 * @param itemName the item name of this kolanot invoice line
	 */
	@Override
	public void setItemName(String itemName) {
		model.setItemName(itemName);
	}

	/**
	 * Sets the line num of this kolanot invoice line.
	 *
	 * @param lineNum the line num of this kolanot invoice line
	 */
	@Override
	public void setLineNum(int lineNum) {
		model.setLineNum(lineNum);
	}

	/**
	 * Sets the line total of this kolanot invoice line.
	 *
	 * @param lineTotal the line total of this kolanot invoice line
	 */
	@Override
	public void setLineTotal(BigDecimal lineTotal) {
		model.setLineTotal(lineTotal);
	}

	/**
	 * Sets the price of this kolanot invoice line.
	 *
	 * @param price the price of this kolanot invoice line
	 */
	@Override
	public void setPrice(BigDecimal price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this kolanot invoice line.
	 *
	 * @param primaryKey the primary key of this kolanot invoice line
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quantity of this kolanot invoice line.
	 *
	 * @param quantity the quantity of this kolanot invoice line
	 */
	@Override
	public void setQuantity(int quantity) {
		model.setQuantity(quantity);
	}

	/**
	 * Sets the sales order doc num of this kolanot invoice line.
	 *
	 * @param salesOrderDocNum the sales order doc num of this kolanot invoice line
	 */
	@Override
	public void setSalesOrderDocNum(String salesOrderDocNum) {
		model.setSalesOrderDocNum(salesOrderDocNum);
	}

	/**
	 * Sets the sales order ID of this kolanot invoice line.
	 *
	 * @param salesOrderID the sales order ID of this kolanot invoice line
	 */
	@Override
	public void setSalesOrderID(String salesOrderID) {
		model.setSalesOrderID(salesOrderID);
	}

	/**
	 * Sets the sales order line num of this kolanot invoice line.
	 *
	 * @param salesOrderLineNum the sales order line num of this kolanot invoice line
	 */
	@Override
	public void setSalesOrderLineNum(int salesOrderLineNum) {
		model.setSalesOrderLineNum(salesOrderLineNum);
	}

	/**
	 * Sets the sales order qty of this kolanot invoice line.
	 *
	 * @param salesOrderQty the sales order qty of this kolanot invoice line
	 */
	@Override
	public void setSalesOrderQty(int salesOrderQty) {
		model.setSalesOrderQty(salesOrderQty);
	}

	/**
	 * Sets the uuid of this kolanot invoice line.
	 *
	 * @param uuid the uuid of this kolanot invoice line
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected KolanotInvoiceLineWrapper wrap(
		KolanotInvoiceLine kolanotInvoiceLine) {

		return new KolanotInvoiceLineWrapper(kolanotInvoiceLine);
	}

}