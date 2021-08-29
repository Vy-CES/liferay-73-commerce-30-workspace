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

import com.kolanot.service.model.KolanotInvoiceLine;

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
 * The persistence utility for the kolanot invoice line service. This utility wraps <code>com.kolanot.service.service.persistence.impl.KolanotInvoiceLinePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoiceLinePersistence
 * @generated
 */
public class KolanotInvoiceLineUtil {

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
	public static void clearCache(KolanotInvoiceLine kolanotInvoiceLine) {
		getPersistence().clearCache(kolanotInvoiceLine);
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
	public static Map<Serializable, KolanotInvoiceLine> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<KolanotInvoiceLine> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<KolanotInvoiceLine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<KolanotInvoiceLine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static KolanotInvoiceLine update(
		KolanotInvoiceLine kolanotInvoiceLine) {

		return getPersistence().update(kolanotInvoiceLine);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static KolanotInvoiceLine update(
		KolanotInvoiceLine kolanotInvoiceLine, ServiceContext serviceContext) {

		return getPersistence().update(kolanotInvoiceLine, serviceContext);
	}

	/**
	 * Returns all the kolanot invoice lines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the kolanot invoice lines where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @return the range of matching kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the kolanot invoice lines where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the kolanot invoice lines where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine findByUuid_First(
			String uuid,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine fetchByUuid_First(
		String uuid, OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine findByUuid_Last(
			String uuid,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine fetchByUuid_Last(
		String uuid, OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the kolanot invoice lines before and after the current kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param invoiceLineId the primary key of the current kolanot invoice line
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	public static KolanotInvoiceLine[] findByUuid_PrevAndNext(
			long invoiceLineId, String uuid,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().findByUuid_PrevAndNext(
			invoiceLineId, uuid, orderByComparator);
	}

	/**
	 * Removes all the kolanot invoice lines where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of kolanot invoice lines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching kolanot invoice lines
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the kolanot invoice line where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchKolanotInvoiceLineException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine findByUUID_G(String uuid, long groupId)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the kolanot invoice line where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the kolanot invoice line where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the kolanot invoice line where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the kolanot invoice line that was removed
	 */
	public static KolanotInvoiceLine removeByUUID_G(String uuid, long groupId)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of kolanot invoice lines where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching kolanot invoice lines
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the kolanot invoice lines where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the kolanot invoice lines where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @return the range of matching kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the kolanot invoice lines where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the kolanot invoice lines where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first kolanot invoice line in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first kolanot invoice line in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice line in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice line in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the kolanot invoice lines before and after the current kolanot invoice line in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param invoiceLineId the primary key of the current kolanot invoice line
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	public static KolanotInvoiceLine[] findByUuid_C_PrevAndNext(
			long invoiceLineId, String uuid, long companyId,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().findByUuid_C_PrevAndNext(
			invoiceLineId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the kolanot invoice lines where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of kolanot invoice lines where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching kolanot invoice lines
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the kolanot invoice lines where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @return the matching kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findByInvoiceId(long invoiceId) {
		return getPersistence().findByInvoiceId(invoiceId);
	}

	/**
	 * Returns a range of all the kolanot invoice lines where invoiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceId the invoice ID
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @return the range of matching kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findByInvoiceId(
		long invoiceId, int start, int end) {

		return getPersistence().findByInvoiceId(invoiceId, start, end);
	}

	/**
	 * Returns an ordered range of all the kolanot invoice lines where invoiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceId the invoice ID
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findByInvoiceId(
		long invoiceId, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return getPersistence().findByInvoiceId(
			invoiceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the kolanot invoice lines where invoiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceId the invoice ID
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findByInvoiceId(
		long invoiceId, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByInvoiceId(
			invoiceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine findByInvoiceId_First(
			long invoiceId,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().findByInvoiceId_First(
			invoiceId, orderByComparator);
	}

	/**
	 * Returns the first kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine fetchByInvoiceId_First(
		long invoiceId,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return getPersistence().fetchByInvoiceId_First(
			invoiceId, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine findByInvoiceId_Last(
			long invoiceId,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().findByInvoiceId_Last(
			invoiceId, orderByComparator);
	}

	/**
	 * Returns the last kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public static KolanotInvoiceLine fetchByInvoiceId_Last(
		long invoiceId,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return getPersistence().fetchByInvoiceId_Last(
			invoiceId, orderByComparator);
	}

	/**
	 * Returns the kolanot invoice lines before and after the current kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceLineId the primary key of the current kolanot invoice line
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	public static KolanotInvoiceLine[] findByInvoiceId_PrevAndNext(
			long invoiceLineId, long invoiceId,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().findByInvoiceId_PrevAndNext(
			invoiceLineId, invoiceId, orderByComparator);
	}

	/**
	 * Removes all the kolanot invoice lines where invoiceId = &#63; from the database.
	 *
	 * @param invoiceId the invoice ID
	 */
	public static void removeByInvoiceId(long invoiceId) {
		getPersistence().removeByInvoiceId(invoiceId);
	}

	/**
	 * Returns the number of kolanot invoice lines where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @return the number of matching kolanot invoice lines
	 */
	public static int countByInvoiceId(long invoiceId) {
		return getPersistence().countByInvoiceId(invoiceId);
	}

	/**
	 * Caches the kolanot invoice line in the entity cache if it is enabled.
	 *
	 * @param kolanotInvoiceLine the kolanot invoice line
	 */
	public static void cacheResult(KolanotInvoiceLine kolanotInvoiceLine) {
		getPersistence().cacheResult(kolanotInvoiceLine);
	}

	/**
	 * Caches the kolanot invoice lines in the entity cache if it is enabled.
	 *
	 * @param kolanotInvoiceLines the kolanot invoice lines
	 */
	public static void cacheResult(
		List<KolanotInvoiceLine> kolanotInvoiceLines) {

		getPersistence().cacheResult(kolanotInvoiceLines);
	}

	/**
	 * Creates a new kolanot invoice line with the primary key. Does not add the kolanot invoice line to the database.
	 *
	 * @param invoiceLineId the primary key for the new kolanot invoice line
	 * @return the new kolanot invoice line
	 */
	public static KolanotInvoiceLine create(long invoiceLineId) {
		return getPersistence().create(invoiceLineId);
	}

	/**
	 * Removes the kolanot invoice line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoiceLineId the primary key of the kolanot invoice line
	 * @return the kolanot invoice line that was removed
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	public static KolanotInvoiceLine remove(long invoiceLineId)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().remove(invoiceLineId);
	}

	public static KolanotInvoiceLine updateImpl(
		KolanotInvoiceLine kolanotInvoiceLine) {

		return getPersistence().updateImpl(kolanotInvoiceLine);
	}

	/**
	 * Returns the kolanot invoice line with the primary key or throws a <code>NoSuchKolanotInvoiceLineException</code> if it could not be found.
	 *
	 * @param invoiceLineId the primary key of the kolanot invoice line
	 * @return the kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	public static KolanotInvoiceLine findByPrimaryKey(long invoiceLineId)
		throws com.kolanot.service.exception.NoSuchKolanotInvoiceLineException {

		return getPersistence().findByPrimaryKey(invoiceLineId);
	}

	/**
	 * Returns the kolanot invoice line with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoiceLineId the primary key of the kolanot invoice line
	 * @return the kolanot invoice line, or <code>null</code> if a kolanot invoice line with the primary key could not be found
	 */
	public static KolanotInvoiceLine fetchByPrimaryKey(long invoiceLineId) {
		return getPersistence().fetchByPrimaryKey(invoiceLineId);
	}

	/**
	 * Returns all the kolanot invoice lines.
	 *
	 * @return the kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the kolanot invoice lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @return the range of kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the kolanot invoice lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findAll(
		int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the kolanot invoice lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of kolanot invoice lines
	 */
	public static List<KolanotInvoiceLine> findAll(
		int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the kolanot invoice lines from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of kolanot invoice lines.
	 *
	 * @return the number of kolanot invoice lines
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static KolanotInvoiceLinePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<KolanotInvoiceLinePersistence, KolanotInvoiceLinePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			KolanotInvoiceLinePersistence.class);

		ServiceTracker
			<KolanotInvoiceLinePersistence, KolanotInvoiceLinePersistence>
				serviceTracker =
					new ServiceTracker
						<KolanotInvoiceLinePersistence,
						 KolanotInvoiceLinePersistence>(
							 bundle.getBundleContext(),
							 KolanotInvoiceLinePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}