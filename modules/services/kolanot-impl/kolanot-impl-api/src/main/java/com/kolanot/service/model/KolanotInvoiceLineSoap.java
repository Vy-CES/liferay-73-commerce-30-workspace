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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.kolanot.service.service.http.KolanotInvoiceLineServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class KolanotInvoiceLineSoap implements Serializable {

	public static KolanotInvoiceLineSoap toSoapModel(KolanotInvoiceLine model) {
		KolanotInvoiceLineSoap soapModel = new KolanotInvoiceLineSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setInvoiceLineId(model.getInvoiceLineId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setInvoiceId(model.getInvoiceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setLineNum(model.getLineNum());
		soapModel.setItemCode(model.getItemCode());
		soapModel.setItemName(model.getItemName());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setPrice(model.getPrice());
		soapModel.setDiscountPercent(model.getDiscountPercent());
		soapModel.setLineTotal(model.getLineTotal());
		soapModel.setSalesOrderID(model.getSalesOrderID());
		soapModel.setSalesOrderDocNum(model.getSalesOrderDocNum());
		soapModel.setSalesOrderLineNum(model.getSalesOrderLineNum());
		soapModel.setSalesOrderQty(model.getSalesOrderQty());

		return soapModel;
	}

	public static KolanotInvoiceLineSoap[] toSoapModels(
		KolanotInvoiceLine[] models) {

		KolanotInvoiceLineSoap[] soapModels =
			new KolanotInvoiceLineSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KolanotInvoiceLineSoap[][] toSoapModels(
		KolanotInvoiceLine[][] models) {

		KolanotInvoiceLineSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new KolanotInvoiceLineSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KolanotInvoiceLineSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KolanotInvoiceLineSoap[] toSoapModels(
		List<KolanotInvoiceLine> models) {

		List<KolanotInvoiceLineSoap> soapModels =
			new ArrayList<KolanotInvoiceLineSoap>(models.size());

		for (KolanotInvoiceLine model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new KolanotInvoiceLineSoap[soapModels.size()]);
	}

	public KolanotInvoiceLineSoap() {
	}

	public long getPrimaryKey() {
		return _invoiceLineId;
	}

	public void setPrimaryKey(long pk) {
		setInvoiceLineId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getInvoiceLineId() {
		return _invoiceLineId;
	}

	public void setInvoiceLineId(long invoiceLineId) {
		_invoiceLineId = invoiceLineId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getInvoiceId() {
		return _invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		_invoiceId = invoiceId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public int getLineNum() {
		return _lineNum;
	}

	public void setLineNum(int lineNum) {
		_lineNum = lineNum;
	}

	public String getItemCode() {
		return _itemCode;
	}

	public void setItemCode(String itemCode) {
		_itemCode = itemCode;
	}

	public String getItemName() {
		return _itemName;
	}

	public void setItemName(String itemName) {
		_itemName = itemName;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public BigDecimal getPrice() {
		return _price;
	}

	public void setPrice(BigDecimal price) {
		_price = price;
	}

	public BigDecimal getDiscountPercent() {
		return _discountPercent;
	}

	public void setDiscountPercent(BigDecimal discountPercent) {
		_discountPercent = discountPercent;
	}

	public BigDecimal getLineTotal() {
		return _lineTotal;
	}

	public void setLineTotal(BigDecimal lineTotal) {
		_lineTotal = lineTotal;
	}

	public String getSalesOrderID() {
		return _salesOrderID;
	}

	public void setSalesOrderID(String salesOrderID) {
		_salesOrderID = salesOrderID;
	}

	public String getSalesOrderDocNum() {
		return _salesOrderDocNum;
	}

	public void setSalesOrderDocNum(String salesOrderDocNum) {
		_salesOrderDocNum = salesOrderDocNum;
	}

	public int getSalesOrderLineNum() {
		return _salesOrderLineNum;
	}

	public void setSalesOrderLineNum(int salesOrderLineNum) {
		_salesOrderLineNum = salesOrderLineNum;
	}

	public int getSalesOrderQty() {
		return _salesOrderQty;
	}

	public void setSalesOrderQty(int salesOrderQty) {
		_salesOrderQty = salesOrderQty;
	}

	private String _uuid;
	private long _invoiceLineId;
	private long _groupId;
	private long _invoiceId;
	private long _companyId;
	private int _lineNum;
	private String _itemCode;
	private String _itemName;
	private int _quantity;
	private BigDecimal _price;
	private BigDecimal _discountPercent;
	private BigDecimal _lineTotal;
	private String _salesOrderID;
	private String _salesOrderDocNum;
	private int _salesOrderLineNum;
	private int _salesOrderQty;

}