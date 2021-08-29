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

import com.kolanot.service.exception.NoSuchKolanotInvoiceException;
import com.kolanot.service.model.KolanotInvoice;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the kolanot invoice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoiceUtil
 * @generated
 */
@ProviderType
public interface KolanotInvoicePersistence
	extends BasePersistence<KolanotInvoice> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KolanotInvoiceUtil} to access the kolanot invoice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the kolanot invoices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching kolanot invoices
	 */
	public java.util.List<KolanotInvoice> findByUuid(String uuid);

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
	public java.util.List<KolanotInvoice> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<KolanotInvoice> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

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
	public java.util.List<KolanotInvoice> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
				orderByComparator)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the first kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

	/**
	 * Returns the last kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
				orderByComparator)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the last kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

	/**
	 * Returns the kolanot invoices before and after the current kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param invoiceId the primary key of the current kolanot invoice
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	public KolanotInvoice[] findByUuid_PrevAndNext(
			long invoiceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
				orderByComparator)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Removes all the kolanot invoices where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of kolanot invoices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching kolanot invoices
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the kolanot invoice where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchKolanotInvoiceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice findByUUID_G(String uuid, long groupId)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the kolanot invoice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the kolanot invoice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the kolanot invoice where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the kolanot invoice that was removed
	 */
	public KolanotInvoice removeByUUID_G(String uuid, long groupId)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the number of kolanot invoices where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching kolanot invoices
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the kolanot invoices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching kolanot invoices
	 */
	public java.util.List<KolanotInvoice> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<KolanotInvoice> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<KolanotInvoice> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

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
	public java.util.List<KolanotInvoice> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kolanot invoice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
				orderByComparator)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the first kolanot invoice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

	/**
	 * Returns the last kolanot invoice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
				orderByComparator)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the last kolanot invoice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

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
	public KolanotInvoice[] findByUuid_C_PrevAndNext(
			long invoiceId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
				orderByComparator)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Removes all the kolanot invoices where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of kolanot invoices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching kolanot invoices
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the kolanot invoices where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @return the matching kolanot invoices
	 */
	public java.util.List<KolanotInvoice> findByCreatedByAccountId(
		long createdByAccountId);

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
	public java.util.List<KolanotInvoice> findByCreatedByAccountId(
		long createdByAccountId, int start, int end);

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
	public java.util.List<KolanotInvoice> findByCreatedByAccountId(
		long createdByAccountId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

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
	public java.util.List<KolanotInvoice> findByCreatedByAccountId(
		long createdByAccountId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice findByCreatedByAccountId_First(
			long createdByAccountId,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
				orderByComparator)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the first kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice fetchByCreatedByAccountId_First(
		long createdByAccountId,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

	/**
	 * Returns the last kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice findByCreatedByAccountId_Last(
			long createdByAccountId,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
				orderByComparator)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the last kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice fetchByCreatedByAccountId_Last(
		long createdByAccountId,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

	/**
	 * Returns the kolanot invoices before and after the current kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param invoiceId the primary key of the current kolanot invoice
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	public KolanotInvoice[] findByCreatedByAccountId_PrevAndNext(
			long invoiceId, long createdByAccountId,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
				orderByComparator)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Removes all the kolanot invoices where createdByAccountId = &#63; from the database.
	 *
	 * @param createdByAccountId the created by account ID
	 */
	public void removeByCreatedByAccountId(long createdByAccountId);

	/**
	 * Returns the number of kolanot invoices where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @return the number of matching kolanot invoices
	 */
	public int countByCreatedByAccountId(long createdByAccountId);

	/**
	 * Returns all the kolanot invoices where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @return the matching kolanot invoices
	 */
	public java.util.List<KolanotInvoice> findByAccountExternalReferenceCode(
		String accountExternalReferenceCode);

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
	public java.util.List<KolanotInvoice> findByAccountExternalReferenceCode(
		String accountExternalReferenceCode, int start, int end);

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
	public java.util.List<KolanotInvoice> findByAccountExternalReferenceCode(
		String accountExternalReferenceCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

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
	public java.util.List<KolanotInvoice> findByAccountExternalReferenceCode(
		String accountExternalReferenceCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice findByAccountExternalReferenceCode_First(
			String accountExternalReferenceCode,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
				orderByComparator)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the first kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice fetchByAccountExternalReferenceCode_First(
		String accountExternalReferenceCode,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

	/**
	 * Returns the last kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice findByAccountExternalReferenceCode_Last(
			String accountExternalReferenceCode,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
				orderByComparator)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the last kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice fetchByAccountExternalReferenceCode_Last(
		String accountExternalReferenceCode,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

	/**
	 * Returns the kolanot invoices before and after the current kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param invoiceId the primary key of the current kolanot invoice
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	public KolanotInvoice[] findByAccountExternalReferenceCode_PrevAndNext(
			long invoiceId, String accountExternalReferenceCode,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
				orderByComparator)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Removes all the kolanot invoices where accountExternalReferenceCode = &#63; from the database.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 */
	public void removeByAccountExternalReferenceCode(
		String accountExternalReferenceCode);

	/**
	 * Returns the number of kolanot invoices where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @return the number of matching kolanot invoices
	 */
	public int countByAccountExternalReferenceCode(
		String accountExternalReferenceCode);

	/**
	 * Returns the kolanot invoice where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchKolanotInvoiceException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the kolanot invoice where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the kolanot invoice where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	public KolanotInvoice fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the kolanot invoice where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the kolanot invoice that was removed
	 */
	public KolanotInvoice removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the number of kolanot invoices where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching kolanot invoices
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the kolanot invoice in the entity cache if it is enabled.
	 *
	 * @param kolanotInvoice the kolanot invoice
	 */
	public void cacheResult(KolanotInvoice kolanotInvoice);

	/**
	 * Caches the kolanot invoices in the entity cache if it is enabled.
	 *
	 * @param kolanotInvoices the kolanot invoices
	 */
	public void cacheResult(java.util.List<KolanotInvoice> kolanotInvoices);

	/**
	 * Creates a new kolanot invoice with the primary key. Does not add the kolanot invoice to the database.
	 *
	 * @param invoiceId the primary key for the new kolanot invoice
	 * @return the new kolanot invoice
	 */
	public KolanotInvoice create(long invoiceId);

	/**
	 * Removes the kolanot invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoiceId the primary key of the kolanot invoice
	 * @return the kolanot invoice that was removed
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	public KolanotInvoice remove(long invoiceId)
		throws NoSuchKolanotInvoiceException;

	public KolanotInvoice updateImpl(KolanotInvoice kolanotInvoice);

	/**
	 * Returns the kolanot invoice with the primary key or throws a <code>NoSuchKolanotInvoiceException</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the kolanot invoice
	 * @return the kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	public KolanotInvoice findByPrimaryKey(long invoiceId)
		throws NoSuchKolanotInvoiceException;

	/**
	 * Returns the kolanot invoice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the kolanot invoice
	 * @return the kolanot invoice, or <code>null</code> if a kolanot invoice with the primary key could not be found
	 */
	public KolanotInvoice fetchByPrimaryKey(long invoiceId);

	/**
	 * Returns all the kolanot invoices.
	 *
	 * @return the kolanot invoices
	 */
	public java.util.List<KolanotInvoice> findAll();

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
	public java.util.List<KolanotInvoice> findAll(int start, int end);

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
	public java.util.List<KolanotInvoice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator);

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
	public java.util.List<KolanotInvoice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the kolanot invoices from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of kolanot invoices.
	 *
	 * @return the number of kolanot invoices
	 */
	public int countAll();

}