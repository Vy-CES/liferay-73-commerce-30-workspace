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

package com.kolanot.service.service.persistence;

import com.kolanot.service.model.InvoicePayment;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the invoice payment service. This utility wraps <code>com.kolanot.service.service.persistence.impl.InvoicePaymentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoicePaymentPersistence
 * @generated
 */
public class InvoicePaymentUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(InvoicePayment invoicePayment) {
		getPersistence().clearCache(invoicePayment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, InvoicePayment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<InvoicePayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InvoicePayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InvoicePayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<InvoicePayment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static InvoicePayment update(InvoicePayment invoicePayment) {
		return getPersistence().update(invoicePayment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static InvoicePayment update(
		InvoicePayment invoicePayment, ServiceContext serviceContext) {

		return getPersistence().update(invoicePayment, serviceContext);
	}

	/**
	 * Returns all the invoice payments where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @return the matching invoice payments
	 */
	public static List<InvoicePayment> findByInvoiceId(long invoiceId) {
		return getPersistence().findByInvoiceId(invoiceId);
	}

	/**
	 * Returns a range of all the invoice payments where invoiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvoicePaymentModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceId the invoice ID
	 * @param start the lower bound of the range of invoice payments
	 * @param end the upper bound of the range of invoice payments (not inclusive)
	 * @return the range of matching invoice payments
	 */
	public static List<InvoicePayment> findByInvoiceId(
		long invoiceId, int start, int end) {

		return getPersistence().findByInvoiceId(invoiceId, start, end);
	}

	/**
	 * Returns an ordered range of all the invoice payments where invoiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvoicePaymentModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceId the invoice ID
	 * @param start the lower bound of the range of invoice payments
	 * @param end the upper bound of the range of invoice payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invoice payments
	 */
	public static List<InvoicePayment> findByInvoiceId(
		long invoiceId, int start, int end,
		OrderByComparator<InvoicePayment> orderByComparator) {

		return getPersistence().findByInvoiceId(
			invoiceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the invoice payments where invoiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvoicePaymentModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceId the invoice ID
	 * @param start the lower bound of the range of invoice payments
	 * @param end the upper bound of the range of invoice payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching invoice payments
	 */
	public static List<InvoicePayment> findByInvoiceId(
		long invoiceId, int start, int end,
		OrderByComparator<InvoicePayment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByInvoiceId(
			invoiceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoice payment
	 * @throws NoSuchInvoicePaymentException if a matching invoice payment could not be found
	 */
	public static InvoicePayment findByInvoiceId_First(
			long invoiceId, OrderByComparator<InvoicePayment> orderByComparator)
		throws com.kolanot.service.exception.NoSuchInvoicePaymentException {

		return getPersistence().findByInvoiceId_First(
			invoiceId, orderByComparator);
	}

	/**
	 * Returns the first invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoice payment, or <code>null</code> if a matching invoice payment could not be found
	 */
	public static InvoicePayment fetchByInvoiceId_First(
		long invoiceId, OrderByComparator<InvoicePayment> orderByComparator) {

		return getPersistence().fetchByInvoiceId_First(
			invoiceId, orderByComparator);
	}

	/**
	 * Returns the last invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoice payment
	 * @throws NoSuchInvoicePaymentException if a matching invoice payment could not be found
	 */
	public static InvoicePayment findByInvoiceId_Last(
			long invoiceId, OrderByComparator<InvoicePayment> orderByComparator)
		throws com.kolanot.service.exception.NoSuchInvoicePaymentException {

		return getPersistence().findByInvoiceId_Last(
			invoiceId, orderByComparator);
	}

	/**
	 * Returns the last invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoice payment, or <code>null</code> if a matching invoice payment could not be found
	 */
	public static InvoicePayment fetchByInvoiceId_Last(
		long invoiceId, OrderByComparator<InvoicePayment> orderByComparator) {

		return getPersistence().fetchByInvoiceId_Last(
			invoiceId, orderByComparator);
	}

	/**
	 * Returns the invoice payments before and after the current invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoicePaymentId the primary key of the current invoice payment
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invoice payment
	 * @throws NoSuchInvoicePaymentException if a invoice payment with the primary key could not be found
	 */
	public static InvoicePayment[] findByInvoiceId_PrevAndNext(
			long invoicePaymentId, long invoiceId,
			OrderByComparator<InvoicePayment> orderByComparator)
		throws com.kolanot.service.exception.NoSuchInvoicePaymentException {

		return getPersistence().findByInvoiceId_PrevAndNext(
			invoicePaymentId, invoiceId, orderByComparator);
	}

	/**
	 * Removes all the invoice payments where invoiceId = &#63; from the database.
	 *
	 * @param invoiceId the invoice ID
	 */
	public static void removeByInvoiceId(long invoiceId) {
		getPersistence().removeByInvoiceId(invoiceId);
	}

	/**
	 * Returns the number of invoice payments where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @return the number of matching invoice payments
	 */
	public static int countByInvoiceId(long invoiceId) {
		return getPersistence().countByInvoiceId(invoiceId);
	}

	/**
	 * Caches the invoice payment in the entity cache if it is enabled.
	 *
	 * @param invoicePayment the invoice payment
	 */
	public static void cacheResult(InvoicePayment invoicePayment) {
		getPersistence().cacheResult(invoicePayment);
	}

	/**
	 * Caches the invoice payments in the entity cache if it is enabled.
	 *
	 * @param invoicePayments the invoice payments
	 */
	public static void cacheResult(List<InvoicePayment> invoicePayments) {
		getPersistence().cacheResult(invoicePayments);
	}

	/**
	 * Creates a new invoice payment with the primary key. Does not add the invoice payment to the database.
	 *
	 * @param invoicePaymentId the primary key for the new invoice payment
	 * @return the new invoice payment
	 */
	public static InvoicePayment create(long invoicePaymentId) {
		return getPersistence().create(invoicePaymentId);
	}

	/**
	 * Removes the invoice payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoicePaymentId the primary key of the invoice payment
	 * @return the invoice payment that was removed
	 * @throws NoSuchInvoicePaymentException if a invoice payment with the primary key could not be found
	 */
	public static InvoicePayment remove(long invoicePaymentId)
		throws com.kolanot.service.exception.NoSuchInvoicePaymentException {

		return getPersistence().remove(invoicePaymentId);
	}

	public static InvoicePayment updateImpl(InvoicePayment invoicePayment) {
		return getPersistence().updateImpl(invoicePayment);
	}

	/**
	 * Returns the invoice payment with the primary key or throws a <code>NoSuchInvoicePaymentException</code> if it could not be found.
	 *
	 * @param invoicePaymentId the primary key of the invoice payment
	 * @return the invoice payment
	 * @throws NoSuchInvoicePaymentException if a invoice payment with the primary key could not be found
	 */
	public static InvoicePayment findByPrimaryKey(long invoicePaymentId)
		throws com.kolanot.service.exception.NoSuchInvoicePaymentException {

		return getPersistence().findByPrimaryKey(invoicePaymentId);
	}

	/**
	 * Returns the invoice payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoicePaymentId the primary key of the invoice payment
	 * @return the invoice payment, or <code>null</code> if a invoice payment with the primary key could not be found
	 */
	public static InvoicePayment fetchByPrimaryKey(long invoicePaymentId) {
		return getPersistence().fetchByPrimaryKey(invoicePaymentId);
	}

	/**
	 * Returns all the invoice payments.
	 *
	 * @return the invoice payments
	 */
	public static List<InvoicePayment> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the invoice payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvoicePaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invoice payments
	 * @param end the upper bound of the range of invoice payments (not inclusive)
	 * @return the range of invoice payments
	 */
	public static List<InvoicePayment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the invoice payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvoicePaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invoice payments
	 * @param end the upper bound of the range of invoice payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of invoice payments
	 */
	public static List<InvoicePayment> findAll(
		int start, int end,
		OrderByComparator<InvoicePayment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the invoice payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvoicePaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invoice payments
	 * @param end the upper bound of the range of invoice payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of invoice payments
	 */
	public static List<InvoicePayment> findAll(
		int start, int end, OrderByComparator<InvoicePayment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the invoice payments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of invoice payments.
	 *
	 * @return the number of invoice payments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InvoicePaymentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<InvoicePaymentPersistence, InvoicePaymentPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			InvoicePaymentPersistence.class);

		ServiceTracker<InvoicePaymentPersistence, InvoicePaymentPersistence>
			serviceTracker =
				new ServiceTracker
					<InvoicePaymentPersistence, InvoicePaymentPersistence>(
						bundle.getBundleContext(),
						InvoicePaymentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}