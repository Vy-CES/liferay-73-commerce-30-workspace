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
import com.kolanot.service.model.InvoicePaymentModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the InvoicePayment service. Represents a row in the &quot;kolanot_InvoicePayment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>InvoicePaymentModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link InvoicePaymentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoicePaymentImpl
 * @generated
 */
public class InvoicePaymentModelImpl
	extends BaseModelImpl<InvoicePayment> implements InvoicePaymentModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a invoice payment model instance should use the <code>InvoicePayment</code> interface instead.
	 */
	public static final String TABLE_NAME = "kolanot_InvoicePayment";

	public static final Object[][] TABLE_COLUMNS = {
		{"invoicePaymentId", Types.BIGINT}, {"transactionid", Types.VARCHAR},
		{"invoiceId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("invoicePaymentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("transactionid", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("invoiceId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table kolanot_InvoicePayment (invoicePaymentId LONG not null primary key,transactionid VARCHAR(75) null,invoiceId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table kolanot_InvoicePayment";

	public static final String ORDER_BY_JPQL =
		" ORDER BY invoicePayment.invoicePaymentId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY kolanot_InvoicePayment.invoicePaymentId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long INVOICEID_COLUMN_BITMASK = 1L;

	public static final long INVOICEPAYMENTID_COLUMN_BITMASK = 2L;

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

	public InvoicePaymentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _invoicePaymentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInvoicePaymentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _invoicePaymentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return InvoicePayment.class;
	}

	@Override
	public String getModelClassName() {
		return InvoicePayment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<InvoicePayment, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<InvoicePayment, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<InvoicePayment, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((InvoicePayment)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<InvoicePayment, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<InvoicePayment, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(InvoicePayment)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<InvoicePayment, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<InvoicePayment, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, InvoicePayment>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			InvoicePayment.class.getClassLoader(), InvoicePayment.class,
			ModelWrapper.class);

		try {
			Constructor<InvoicePayment> constructor =
				(Constructor<InvoicePayment>)proxyClass.getConstructor(
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

	private static final Map<String, Function<InvoicePayment, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<InvoicePayment, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<InvoicePayment, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<InvoicePayment, Object>>();
		Map<String, BiConsumer<InvoicePayment, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<InvoicePayment, ?>>();

		attributeGetterFunctions.put(
			"invoicePaymentId", InvoicePayment::getInvoicePaymentId);
		attributeSetterBiConsumers.put(
			"invoicePaymentId",
			(BiConsumer<InvoicePayment, Long>)
				InvoicePayment::setInvoicePaymentId);
		attributeGetterFunctions.put(
			"transactionid", InvoicePayment::getTransactionid);
		attributeSetterBiConsumers.put(
			"transactionid",
			(BiConsumer<InvoicePayment, String>)
				InvoicePayment::setTransactionid);
		attributeGetterFunctions.put("invoiceId", InvoicePayment::getInvoiceId);
		attributeSetterBiConsumers.put(
			"invoiceId",
			(BiConsumer<InvoicePayment, Long>)InvoicePayment::setInvoiceId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getInvoicePaymentId() {
		return _invoicePaymentId;
	}

	@Override
	public void setInvoicePaymentId(long invoicePaymentId) {
		_invoicePaymentId = invoicePaymentId;
	}

	@Override
	public String getTransactionid() {
		if (_transactionid == null) {
			return "";
		}
		else {
			return _transactionid;
		}
	}

	@Override
	public void setTransactionid(String transactionid) {
		_transactionid = transactionid;
	}

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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, InvoicePayment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public InvoicePayment toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, InvoicePayment>
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
		InvoicePaymentImpl invoicePaymentImpl = new InvoicePaymentImpl();

		invoicePaymentImpl.setInvoicePaymentId(getInvoicePaymentId());
		invoicePaymentImpl.setTransactionid(getTransactionid());
		invoicePaymentImpl.setInvoiceId(getInvoiceId());

		invoicePaymentImpl.resetOriginalValues();

		return invoicePaymentImpl;
	}

	@Override
	public int compareTo(InvoicePayment invoicePayment) {
		long primaryKey = invoicePayment.getPrimaryKey();

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

		if (!(object instanceof InvoicePayment)) {
			return false;
		}

		InvoicePayment invoicePayment = (InvoicePayment)object;

		long primaryKey = invoicePayment.getPrimaryKey();

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
		InvoicePaymentModelImpl invoicePaymentModelImpl = this;

		invoicePaymentModelImpl._originalInvoiceId =
			invoicePaymentModelImpl._invoiceId;

		invoicePaymentModelImpl._setOriginalInvoiceId = false;

		invoicePaymentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<InvoicePayment> toCacheModel() {
		InvoicePaymentCacheModel invoicePaymentCacheModel =
			new InvoicePaymentCacheModel();

		invoicePaymentCacheModel.invoicePaymentId = getInvoicePaymentId();

		invoicePaymentCacheModel.transactionid = getTransactionid();

		String transactionid = invoicePaymentCacheModel.transactionid;

		if ((transactionid != null) && (transactionid.length() == 0)) {
			invoicePaymentCacheModel.transactionid = null;
		}

		invoicePaymentCacheModel.invoiceId = getInvoiceId();

		return invoicePaymentCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<InvoicePayment, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<InvoicePayment, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<InvoicePayment, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((InvoicePayment)this));
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
		Map<String, Function<InvoicePayment, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<InvoicePayment, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<InvoicePayment, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((InvoicePayment)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, InvoicePayment>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _invoicePaymentId;
	private String _transactionid;
	private long _invoiceId;
	private long _originalInvoiceId;
	private boolean _setOriginalInvoiceId;
	private long _columnBitmask;
	private InvoicePayment _escapedModel;

}