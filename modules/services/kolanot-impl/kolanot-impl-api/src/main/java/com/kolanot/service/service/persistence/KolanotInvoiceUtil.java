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

import com.kolanot.service.model.KolanotInvoice;

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
 * The persistence utility for the kolanot invoice service. This utility wraps <code>com.kolanot.service.service.persistence.impl.KolanotInvoicePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoicePersistence
 * @generated
 */
public class KolanotInvoiceUtil {

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
	public static void clearCache(KolanotInvoice kolanotInvoice) {
		getPersistence().clearCache(kolanotInvoice);
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
	public static Map<Serializable, KolanotInvoice> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<KolanotInvoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<KolanotInvoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<KolanotInvoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static KolanotInvoice update(KolanotInvoice kolanotInvoice) {
		return getPersistence().update(kolanotInvoice);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static KolanotInvoice update(
		KolanotInvoice kolanotInvoice, ServiceContext serviceContext) {

		return getPersistence().update(kolanotInvoice, serviceContext);
	}

	/**
	 * Returns all the kolanot invoices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the kolanot invoices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @return the range of matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the kolanot invoices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the kolanot invoices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice findByUuid_First(
			String uuid, OrderByComparator<KolanotInvoice> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice fetchByUuid_First(
		String uuid, OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice findByUuid_Last(
			String uuid, OrderByComparator<KolanotInvoice> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice fetchByUuid_Last(
		String uuid, OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the kolanot invoices before and after the current kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param invoiceId the primary key of the current kolanot invoice
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	public static KolanotInvoice[] findByUuid_PrevAndNext(
			long invoiceId, String uuid,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByUuid_PrevAndNext(
			invoiceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the kolanot invoices where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of kolanot invoices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching kolanot invoices
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the kolanot invoice where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchKolanotInvoiceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice findByUUID_G(String uuid, long groupId)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the kolanot invoice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the kolanot invoice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the kolanot invoice where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the kolanot invoice that was removed
	 */
	public static KolanotInvoice removeByUUID_G(String uuid, long groupId)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of kolanot invoices where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching kolanot invoices
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the kolanot invoices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the kolanot invoices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @return the range of matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the kolanot invoices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the kolanot invoices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the kolanot invoices before and after the current kolanot invoice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param invoiceId the primary key of the current kolanot invoice
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	public static KolanotInvoice[] findByUuid_C_PrevAndNext(
			long invoiceId, String uuid, long companyId,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByUuid_C_PrevAndNext(
			invoiceId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the kolanot invoices where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of kolanot invoices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching kolanot invoices
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the kolanot invoices where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @return the matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByCreatedByAccountId(
		long createdByAccountId) {

		return getPersistence().findByCreatedByAccountId(createdByAccountId);
	}

	/**
	 * Returns a range of all the kolanot invoices where createdByAccountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param createdByAccountId the created by account ID
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @return the range of matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByCreatedByAccountId(
		long createdByAccountId, int start, int end) {

		return getPersistence().findByCreatedByAccountId(
			createdByAccountId, start, end);
	}

	/**
	 * Returns an ordered range of all the kolanot invoices where createdByAccountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param createdByAccountId the created by account ID
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByCreatedByAccountId(
		long createdByAccountId, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().findByCreatedByAccountId(
			createdByAccountId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the kolanot invoices where createdByAccountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param createdByAccountId the created by account ID
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByCreatedByAccountId(
		long createdByAccountId, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCreatedByAccountId(
			createdByAccountId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice findByCreatedByAccountId_First(
			long createdByAccountId,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByCreatedByAccountId_First(
			createdByAccountId, orderByComparator);
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice fetchByCreatedByAccountId_First(
		long createdByAccountId,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().fetchByCreatedByAccountId_First(
			createdByAccountId, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice findByCreatedByAccountId_Last(
			long createdByAccountId,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByCreatedByAccountId_Last(
			createdByAccountId, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice fetchByCreatedByAccountId_Last(
		long createdByAccountId,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().fetchByCreatedByAccountId_Last(
			createdByAccountId, orderByComparator);
	}

	/**
	 * Returns the kolanot invoices before and after the current kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param invoiceId the primary key of the current kolanot invoice
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	public static KolanotInvoice[] findByCreatedByAccountId_PrevAndNext(
			long invoiceId, long createdByAccountId,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByCreatedByAccountId_PrevAndNext(
			invoiceId, createdByAccountId, orderByComparator);
	}

	/**
	 * Removes all the kolanot invoices where createdByAccountId = &#63; from the database.
	 *
	 * @param createdByAccountId the created by account ID
	 */
	public static void removeByCreatedByAccountId(long createdByAccountId) {
		getPersistence().removeByCreatedByAccountId(createdByAccountId);
	}

	/**
	 * Returns the number of kolanot invoices where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @return the number of matching kolanot invoices
	 */
	public static int countByCreatedByAccountId(long createdByAccountId) {
		return getPersistence().countByCreatedByAccountId(createdByAccountId);
	}

	/**
	 * Returns all the kolanot invoices where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @return the matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByAccountExternalReferenceCode(
		String accountExternalReferenceCode) {

		return getPersistence().findByAccountExternalReferenceCode(
			accountExternalReferenceCode);
	}

	/**
	 * Returns a range of all the kolanot invoices where accountExternalReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @return the range of matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByAccountExternalReferenceCode(
		String accountExternalReferenceCode, int start, int end) {

		return getPersistence().findByAccountExternalReferenceCode(
			accountExternalReferenceCode, start, end);
	}

	/**
	 * Returns an ordered range of all the kolanot invoices where accountExternalReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByAccountExternalReferenceCode(
		String accountExternalReferenceCode, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().findByAccountExternalReferenceCode(
			accountExternalReferenceCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the kolanot invoices where accountExternalReferenceCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kolanot invoices
	 */
	public static List<KolanotInvoice> findByAccountExternalReferenceCode(
		String accountExternalReferenceCode, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAccountExternalReferenceCode(
			accountExternalReferenceCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice findByAccountExternalReferenceCode_First(
			String accountExternalReferenceCode,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByAccountExternalReferenceCode_First(
			accountExternalReferenceCode, orderByComparator);
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice fetchByAccountExternalReferenceCode_First(
		String accountExternalReferenceCode,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().fetchByAccountExternalReferenceCode_First(
			accountExternalReferenceCode, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice findByAccountExternalReferenceCode_Last(
			String accountExternalReferenceCode,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByAccountExternalReferenceCode_Last(
			accountExternalReferenceCode, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice fetchByAccountExternalReferenceCode_Last(
		String accountExternalReferenceCode,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().fetchByAccountExternalReferenceCode_Last(
			accountExternalReferenceCode, orderByComparator);
	}

	/**
	 * Returns the kolanot invoices before and after the current kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param invoiceId the primary key of the current kolanot invoice
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	public static KolanotInvoice[]
			findByAccountExternalReferenceCode_PrevAndNext(
				long invoiceId, String accountExternalReferenceCode,
				OrderByComparator<KolanotInvoice> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByAccountExternalReferenceCode_PrevAndNext(
			invoiceId, accountExternalReferenceCode, orderByComparator);
	}

	/**
	 * Removes all the kolanot invoices where accountExternalReferenceCode = &#63; from the database.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 */
	public static void removeByAccountExternalReferenceCode(
		String accountExternalReferenceCode) {

		getPersistence().removeByAccountExternalReferenceCode(
			accountExternalReferenceCode);
	}

	/**
	 * Returns the number of kolanot invoices where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @return the number of matching kolanot invoices
	 */
	public static int countByAccountExternalReferenceCode(
		String accountExternalReferenceCode) {

		return getPersistence().countByAccountExternalReferenceCode(
			accountExternalReferenceCode);
	}

	/**
	 * Returns the kolanot invoice where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchKolanotInvoiceException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice findByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the kolanot invoice where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the kolanot invoice where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public static KolanotInvoice fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the kolanot invoice where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the kolanot invoice that was removed
	 */
	public static KolanotInvoice removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of kolanot invoices where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching kolanot invoices
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the kolanot invoice in the entity cache if it is enabled.
	 *
	 * @param kolanotInvoice the kolanot invoice
	 */
	public static void cacheResult(KolanotInvoice kolanotInvoice) {
		getPersistence().cacheResult(kolanotInvoice);
	}

	/**
	 * Caches the kolanot invoices in the entity cache if it is enabled.
	 *
	 * @param kolanotInvoices the kolanot invoices
	 */
	public static void cacheResult(List<KolanotInvoice> kolanotInvoices) {
		getPersistence().cacheResult(kolanotInvoices);
	}

	/**
	 * Creates a new kolanot invoice with the primary key. Does not add the kolanot invoice to the database.
	 *
	 * @param invoiceId the primary key for the new kolanot invoice
	 * @return the new kolanot invoice
	 */
	public static KolanotInvoice create(long invoiceId) {
		return getPersistence().create(invoiceId);
	}

	/**
	 * Removes the kolanot invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoiceId the primary key of the kolanot invoice
	 * @return the kolanot invoice that was removed
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	public static KolanotInvoice remove(long invoiceId)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().remove(invoiceId);
	}

	public static KolanotInvoice updateImpl(KolanotInvoice kolanotInvoice) {
		return getPersistence().updateImpl(kolanotInvoice);
	}

	/**
	 * Returns the kolanot invoice with the primary key or throws a <code>NoSuchKolanotInvoiceException</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the kolanot invoice
	 * @return the kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	public static KolanotInvoice findByPrimaryKey(long invoiceId)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceException {

		return getPersistence().findByPrimaryKey(invoiceId);
	}

	/**
	 * Returns the kolanot invoice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the kolanot invoice
	 * @return the kolanot invoice, or <code>null</code> if a kolanot invoice with the primary key could not be found
	 */
	public static KolanotInvoice fetchByPrimaryKey(long invoiceId) {
		return getPersistence().fetchByPrimaryKey(invoiceId);
	}

	/**
	 * Returns all the kolanot invoices.
	 *
	 * @return the kolanot invoices
	 */
	public static List<KolanotInvoice> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the kolanot invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @return the range of kolanot invoices
	 */
	public static List<KolanotInvoice> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the kolanot invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kolanot invoices
	 */
	public static List<KolanotInvoice> findAll(
		int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the kolanot invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of kolanot invoices
	 */
	public static List<KolanotInvoice> findAll(
		int start, int end, OrderByComparator<KolanotInvoice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the kolanot invoices from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of kolanot invoices.
	 *
	 * @return the number of kolanot invoices
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static KolanotInvoicePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<KolanotInvoicePersistence, KolanotInvoicePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			KolanotInvoicePersistence.class);

		ServiceTracker<KolanotInvoicePersistence, KolanotInvoicePersistence>
			serviceTracker =
				new ServiceTracker
					<KolanotInvoicePersistence, KolanotInvoicePersistence>(
						bundle.getBundleContext(),
						KolanotInvoicePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}