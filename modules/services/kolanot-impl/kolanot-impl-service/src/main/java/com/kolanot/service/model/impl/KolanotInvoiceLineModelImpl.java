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
import com.kolanot.service.model.KolanotInvoiceLineModel;
import com.kolanot.service.model.KolanotInvoiceLineSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.math.BigDecimal;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the KolanotInvoiceLine service. Represents a row in the &quot;kolanot_KolanotInvoiceLine&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>KolanotInvoiceLineModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KolanotInvoiceLineImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoiceLineImpl
 * @generated
 */
@JSON(strict = true)
public class KolanotInvoiceLineModelImpl
	extends BaseModelImpl<KolanotInvoiceLine>
	implements KolanotInvoiceLineModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kolanot invoice line model instance should use the <code>KolanotInvoiceLine</code> interface instead.
	 */
	public static final String TABLE_NAME = "kolanot_KolanotInvoiceLine";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"invoiceLineId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"invoiceId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"lineNum", Types.INTEGER},
		{"itemCode", Types.VARCHAR}, {"itemName", Types.VARCHAR},
		{"quantity", Types.INTEGER}, {"price", Types.DECIMAL},
		{"discountPercent", Types.DECIMAL}, {"lineTotal", Types.DECIMAL},
		{"salesOrderID", Types.VARCHAR}, {"salesOrderDocNum", Types.VARCHAR},
		{"salesOrderLineNum", Types.INTEGER}, {"salesOrderQty", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("invoiceLineId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("invoiceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lineNum", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("itemCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("itemName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("quantity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("price", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("discountPercent", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("lineTotal", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("salesOrderID", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("salesOrderDocNum", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("salesOrderLineNum", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("salesOrderQty", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table kolanot_KolanotInvoiceLine (uuid_ VARCHAR(75) null,invoiceLineId LONG not null primary key,groupId LONG,invoiceId LONG,companyId LONG,lineNum INTEGER,itemCode VARCHAR(75) null,itemName VARCHAR(75) null,quantity INTEGER,price DECIMAL(30, 16) null,discountPercent DECIMAL(30, 16) null,lineTotal DECIMAL(30, 16) null,salesOrderID VARCHAR(75) null,salesOrderDocNum VARCHAR(75) null,salesOrderLineNum INTEGER,salesOrderQty INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table kolanot_KolanotInvoiceLine";

	public static final String ORDER_BY_JPQL =
		" ORDER BY kolanotInvoiceLine.invoiceLineId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY kolanot_KolanotInvoiceLine.invoiceLineId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long INVOICEID_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	public static final long INVOICELINEID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static KolanotInvoiceLine toModel(KolanotInvoiceLineSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		KolanotInvoiceLine model = new KolanotInvoiceLineImpl();

		model.setUuid(soapModel.getUuid());
		model.setInvoiceLineId(soapModel.getInvoiceLineId());
		model.setGroupId(soapModel.getGroupId());
		model.setInvoiceId(soapModel.getInvoiceId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setLineNum(soapModel.getLineNum());
		model.setItemCode(soapModel.getItemCode());
		model.setItemName(soapModel.getItemName());
		model.setQuantity(soapModel.getQuantity());
		model.setPrice(soapModel.getPrice());
		model.setDiscountPercent(soapModel.getDiscountPercent());
		model.setLineTotal(soapModel.getLineTotal());
		model.setSalesOrderID(soapModel.getSalesOrderID());
		model.setSalesOrderDocNum(soapModel.getSalesOrderDocNum());
		model.setSalesOrderLineNum(soapModel.getSalesOrderLineNum());
		model.setSalesOrderQty(soapModel.getSalesOrderQty());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<KolanotInvoiceLine> toModels(
		KolanotInvoiceLineSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<KolanotInvoiceLine> models = new ArrayList<KolanotInvoiceLine>(
			soapModels.length);

		for (KolanotInvoiceLineSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public KolanotInvoiceLineModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _invoiceLineId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInvoiceLineId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _invoiceLineId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return KolanotInvoiceLine.class;
	}

	@Override
	public String getModelClassName() {
		return KolanotInvoiceLine.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<KolanotInvoiceLine, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<KolanotInvoiceLine, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KolanotInvoiceLine, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((KolanotInvoiceLine)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<KolanotInvoiceLine, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<KolanotInvoiceLine, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(KolanotInvoiceLine)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<KolanotInvoiceLine, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<KolanotInvoiceLine, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, KolanotInvoiceLine>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			KolanotInvoiceLine.class.getClassLoader(), KolanotInvoiceLine.class,
			ModelWrapper.class);

		try {
			Constructor<KolanotInvoiceLine> constructor =
				(Constructor<KolanotInvoiceLine>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<KolanotInvoiceLine, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<KolanotInvoiceLine, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<KolanotInvoiceLine, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<KolanotInvoiceLine, Object>>();
		Map<String, BiConsumer<KolanotInvoiceLine, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<KolanotInvoiceLine, ?>>();

		attributeGetterFunctions.put("uuid", KolanotInvoiceLine::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<KolanotInvoiceLine, String>)
				KolanotInvoiceLine::setUuid);
		attributeGetterFunctions.put(
			"invoiceLineId", KolanotInvoiceLine::getInvoiceLineId);
		attributeSetterBiConsumers.put(
			"invoiceLineId",
			(BiConsumer<KolanotInvoiceLine, Long>)
				KolanotInvoiceLine::setInvoiceLineId);
		attributeGetterFunctions.put("groupId", KolanotInvoiceLine::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<KolanotInvoiceLine, Long>)
				KolanotInvoiceLine::setGroupId);
		attributeGetterFunctions.put(
			"invoiceId", KolanotInvoiceLine::getInvoiceId);
		attributeSetterBiConsumers.put(
			"invoiceId",
			(BiConsumer<KolanotInvoiceLine, Long>)
				KolanotInvoiceLine::setInvoiceId);
		attributeGetterFunctions.put(
			"companyId", KolanotInvoiceLine::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<KolanotInvoiceLine, Long>)
				KolanotInvoiceLine::setCompanyId);
		attributeGetterFunctions.put("lineNum", KolanotInvoiceLine::getLineNum);
		attributeSetterBiConsumers.put(
			"lineNum",
			(BiConsumer<KolanotInvoiceLine, Integer>)
				KolanotInvoiceLine::setLineNum);
		attributeGetterFunctions.put(
			"itemCode", KolanotInvoiceLine::getItemCode);
		attributeSetterBiConsumers.put(
			"itemCode",
			(BiConsumer<KolanotInvoiceLine, String>)
				KolanotInvoiceLine::setItemCode);
		attributeGetterFunctions.put(
			"itemName", KolanotInvoiceLine::getItemName);
		attributeSetterBiConsumers.put(
			"itemName",
			(BiConsumer<KolanotInvoiceLine, String>)
				KolanotInvoiceLine::setItemName);
		attributeGetterFunctions.put(
			"quantity", KolanotInvoiceLine::getQuantity);
		attributeSetterBiConsumers.put(
			"quantity",
			(BiConsumer<KolanotInvoiceLine, Integer>)
				KolanotInvoiceLine::setQuantity);
		attributeGetterFunctions.put("price", KolanotInvoiceLine::getPrice);
		attributeSetterBiConsumers.put(
			"price",
			(BiConsumer<KolanotInvoiceLine, BigDecimal>)
				KolanotInvoiceLine::setPrice);
		attributeGetterFunctions.put(
			"discountPercent", KolanotInvoiceLine::getDiscountPercent);
		attributeSetterBiConsumers.put(
			"discountPercent",
			(BiConsumer<KolanotInvoiceLine, BigDecimal>)
				KolanotInvoiceLine::setDiscountPercent);
		attributeGetterFunctions.put(
			"lineTotal", KolanotInvoiceLine::getLineTotal);
		attributeSetterBiConsumers.put(
			"lineTotal",
			(BiConsumer<KolanotInvoiceLine, BigDecimal>)
				KolanotInvoiceLine::setLineTotal);
		attributeGetterFunctions.put(
			"salesOrderID", KolanotInvoiceLine::getSalesOrderID);
		attributeSetterBiConsumers.put(
			"salesOrderID",
			(BiConsumer<KolanotInvoiceLine, String>)
				KolanotInvoiceLine::setSalesOrderID);
		attributeGetterFunctions.put(
			"salesOrderDocNum", KolanotInvoiceLine::getSalesOrderDocNum);
		attributeSetterBiConsumers.put(
			"salesOrderDocNum",
			(BiConsumer<KolanotInvoiceLine, String>)
				KolanotInvoiceLine::setSalesOrderDocNum);
		attributeGetterFunctions.put(
			"salesOrderLineNum", KolanotInvoiceLine::getSalesOrderLineNum);
		attributeSetterBiConsumers.put(
			"salesOrderLineNum",
			(BiConsumer<KolanotInvoiceLine, Integer>)
				KolanotInvoiceLine::setSalesOrderLineNum);
		attributeGetterFunctions.put(
			"salesOrderQty", KolanotInvoiceLine::getSalesOrderQty);
		attributeSetterBiConsumers.put(
			"salesOrderQty",
			(BiConsumer<KolanotInvoiceLine, Integer>)
				KolanotInvoiceLine::setSalesOrderQty);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getInvoiceLineId() {
		return _invoiceLineId;
	}

	@Override
	public void setInvoiceLineId(long invoiceLineId) {
		_invoiceLineId = invoiceLineId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getInvoiceId() {
		return _invoiceId;
	}

	@Override
	public void setInvoiceId(long invoiceId) {
		_columnBitmask |= INVOICEID_COLUMN_BITMASK;

		if (!_setOriginalInvoiceId) {
			_setOriginalInvoiceId = true;

			_originalInvoiceId = _invoiceId;
		}

		_invoiceId = invoiceId;
	}

	public long getOriginalInvoiceId() {
		return _originalInvoiceId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public int getLineNum() {
		return _lineNum;
	}

	@Override
	public void setLineNum(int lineNum) {
		_lineNum = lineNum;
	}

	@JSON
	@Override
	public String getItemCode() {
		if (_itemCode == null) {
			return "";
		}
		else {
			return _itemCode;
		}
	}

	@Override
	public void setItemCode(String itemCode) {
		_itemCode = itemCode;
	}

	@JSON
	@Override
	public String getItemName() {
		if (_itemName == null) {
			return "";
		}
		else {
			return _itemName;
		}
	}

	@Override
	public void setItemName(String itemName) {
		_itemName = itemName;
	}

	@JSON
	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	@JSON
	@Override
	public BigDecimal getPrice() {
		return _price;
	}

	@Override
	public void setPrice(BigDecimal price) {
		_price = price;
	}

	@JSON
	@Override
	public BigDecimal getDiscountPercent() {
		return _discountPercent;
	}

	@Override
	public void setDiscountPercent(BigDecimal discountPercent) {
		_discountPercent = discountPercent;
	}

	@JSON
	@Override
	public BigDecimal getLineTotal() {
		return _lineTotal;
	}

	@Override
	public void setLineTotal(BigDecimal lineTotal) {
		_lineTotal = lineTotal;
	}

	@JSON
	@Override
	public String getSalesOrderID() {
		if (_salesOrderID == null) {
			return "";
		}
		else {
			return _salesOrderID;
		}
	}

	@Override
	public void setSalesOrderID(String salesOrderID) {
		_salesOrderID = salesOrderID;
	}

	@JSON
	@Override
	public String getSalesOrderDocNum() {
		if (_salesOrderDocNum == null) {
			return "";
		}
		else {
			return _salesOrderDocNum;
		}
	}

	@Override
	public void setSalesOrderDocNum(String salesOrderDocNum) {
		_salesOrderDocNum = salesOrderDocNum;
	}

	@JSON
	@Override
	public int getSalesOrderLineNum() {
		return _salesOrderLineNum;
	}

	@Override
	public void setSalesOrderLineNum(int salesOrderLineNum) {
		_salesOrderLineNum = salesOrderLineNum;
	}

	@JSON
	@Override
	public int getSalesOrderQty() {
		return _salesOrderQty;
	}

	@Override
	public void setSalesOrderQty(int salesOrderQty) {
		_salesOrderQty = salesOrderQty;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), KolanotInvoiceLine.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public KolanotInvoiceLine toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, KolanotInvoiceLine>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		KolanotInvoiceLineImpl kolanotInvoiceLineImpl =
			new KolanotInvoiceLineImpl();

		kolanotInvoiceLineImpl.setUuid(getUuid());
		kolanotInvoiceLineImpl.setInvoiceLineId(getInvoiceLineId());
		kolanotInvoiceLineImpl.setGroupId(getGroupId());
		kolanotInvoiceLineImpl.setInvoiceId(getInvoiceId());
		kolanotInvoiceLineImpl.setCompanyId(getCompanyId());
		kolanotInvoiceLineImpl.setLineNum(getLineNum());
		kolanotInvoiceLineImpl.setItemCode(getItemCode());
		kolanotInvoiceLineImpl.setItemName(getItemName());
		kolanotInvoiceLineImpl.setQuantity(getQuantity());
		kolanotInvoiceLineImpl.setPrice(getPrice());
		kolanotInvoiceLineImpl.setDiscountPercent(getDiscountPercent());
		kolanotInvoiceLineImpl.setLineTotal(getLineTotal());
		kolanotInvoiceLineImpl.setSalesOrderID(getSalesOrderID());
		kolanotInvoiceLineImpl.setSalesOrderDocNum(getSalesOrderDocNum());
		kolanotInvoiceLineImpl.setSalesOrderLineNum(getSalesOrderLineNum());
		kolanotInvoiceLineImpl.setSalesOrderQty(getSalesOrderQty());

		kolanotInvoiceLineImpl.resetOriginalValues();

		return kolanotInvoiceLineImpl;
	}

	@Override
	public int compareTo(KolanotInvoiceLine kolanotInvoiceLine) {
		long primaryKey = kolanotInvoiceLine.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof KolanotInvoiceLine)) {
			return false;
		}

		KolanotInvoiceLine kolanotInvoiceLine = (KolanotInvoiceLine)object;

		long primaryKey = kolanotInvoiceLine.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		KolanotInvoiceLineModelImpl kolanotInvoiceLineModelImpl = this;

		kolanotInvoiceLineModelImpl._originalUuid =
			kolanotInvoiceLineModelImpl._uuid;

		kolanotInvoiceLineModelImpl._originalGroupId =
			kolanotInvoiceLineModelImpl._groupId;

		kolanotInvoiceLineModelImpl._setOriginalGroupId = false;

		kolanotInvoiceLineModelImpl._originalInvoiceId =
			kolanotInvoiceLineModelImpl._invoiceId;

		kolanotInvoiceLineModelImpl._setOriginalInvoiceId = false;

		kolanotInvoiceLineModelImpl._originalCompanyId =
			kolanotInvoiceLineModelImpl._companyId;

		kolanotInvoiceLineModelImpl._setOriginalCompanyId = false;

		kolanotInvoiceLineModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KolanotInvoiceLine> toCacheModel() {
		KolanotInvoiceLineCacheModel kolanotInvoiceLineCacheModel =
			new KolanotInvoiceLineCacheModel();

		kolanotInvoiceLineCacheModel.uuid = getUuid();

		String uuid = kolanotInvoiceLineCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			kolanotInvoiceLineCacheModel.uuid = null;
		}

		kolanotInvoiceLineCacheModel.invoiceLineId = getInvoiceLineId();

		kolanotInvoiceLineCacheModel.groupId = getGroupId();

		kolanotInvoiceLineCacheModel.invoiceId = getInvoiceId();

		kolanotInvoiceLineCacheModel.companyId = getCompanyId();

		kolanotInvoiceLineCacheModel.lineNum = getLineNum();

		kolanotInvoiceLineCacheModel.itemCode = getItemCode();

		String itemCode = kolanotInvoiceLineCacheModel.itemCode;

		if ((itemCode != null) && (itemCode.length() == 0)) {
			kolanotInvoiceLineCacheModel.itemCode = null;
		}

		kolanotInvoiceLineCacheModel.itemName = getItemName();

		String itemName = kolanotInvoiceLineCacheModel.itemName;

		if ((itemName != null) && (itemName.length() == 0)) {
			kolanotInvoiceLineCacheModel.itemName = null;
		}

		kolanotInvoiceLineCacheModel.quantity = getQuantity();

		kolanotInvoiceLineCacheModel.price = getPrice();

		kolanotInvoiceLineCacheModel.discountPercent = getDiscountPercent();

		kolanotInvoiceLineCacheModel.lineTotal = getLineTotal();

		kolanotInvoiceLineCacheModel.salesOrderID = getSalesOrderID();

		String salesOrderID = kolanotInvoiceLineCacheModel.salesOrderID;

		if ((salesOrderID != null) && (salesOrderID.length() == 0)) {
			kolanotInvoiceLineCacheModel.salesOrderID = null;
		}

		kolanotInvoiceLineCacheModel.salesOrderDocNum = getSalesOrderDocNum();

		String salesOrderDocNum = kolanotInvoiceLineCacheModel.salesOrderDocNum;

		if ((salesOrderDocNum != null) && (salesOrderDocNum.length() == 0)) {
			kolanotInvoiceLineCacheModel.salesOrderDocNum = null;
		}

		kolanotInvoiceLineCacheModel.salesOrderLineNum = getSalesOrderLineNum();

		kolanotInvoiceLineCacheModel.salesOrderQty = getSalesOrderQty();

		return kolanotInvoiceLineCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<KolanotInvoiceLine, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<KolanotInvoiceLine, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KolanotInvoiceLine, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((KolanotInvoiceLine)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<KolanotInvoiceLine, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<KolanotInvoiceLine, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KolanotInvoiceLine, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((KolanotInvoiceLine)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, KolanotInvoiceLine>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _invoiceLineId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _invoiceId;
	private long _originalInvoiceId;
	private boolean _setOriginalInvoiceId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
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
	private long _columnBitmask;
	private KolanotInvoiceLine _escapedModel;

}