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

import com.kolanot.service.exception.NoSuchKolanotInvoiceLineException;
import com.kolanot.service.model.KolanotInvoiceLine;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the kolanot invoice line service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoiceLineUtil
 * @generated
 */
@ProviderType
public interface KolanotInvoiceLinePersistence
	extends BasePersistence<KolanotInvoiceLine> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KolanotInvoiceLineUtil} to access the kolanot invoice line persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the kolanot invoice lines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching kolanot invoice lines
	 */
	public java.util.List<KolanotInvoiceLine> findByUuid(String uuid);

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
	public java.util.List<KolanotInvoiceLine> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<KolanotInvoiceLine> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator);

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
	public java.util.List<KolanotInvoiceLine> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
				orderByComparator)
		throws NoSuchKolanotInvoiceLineException;

	/**
	 * Returns the first kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator);

	/**
	 * Returns the last kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
				orderByComparator)
		throws NoSuchKolanotInvoiceLineException;

	/**
	 * Returns the last kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator);

	/**
	 * Returns the kolanot invoice lines before and after the current kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param invoiceLineId the primary key of the current kolanot invoice line
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	public KolanotInvoiceLine[] findByUuid_PrevAndNext(
			long invoiceLineId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
				orderByComparator)
		throws NoSuchKolanotInvoiceLineException;

	/**
	 * Removes all the kolanot invoice lines where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of kolanot invoice lines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching kolanot invoice lines
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the kolanot invoice line where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchKolanotInvoiceLineException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine findByUUID_G(String uuid, long groupId)
		throws NoSuchKolanotInvoiceLineException;

	/**
	 * Returns the kolanot invoice line where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the kolanot invoice line where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the kolanot invoice line where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the kolanot invoice line that was removed
	 */
	public KolanotInvoiceLine removeByUUID_G(String uuid, long groupId)
		throws NoSuchKolanotInvoiceLineException;

	/**
	 * Returns the number of kolanot invoice lines where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching kolanot invoice lines
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the kolanot invoice lines where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching kolanot invoice lines
	 */
	public java.util.List<KolanotInvoiceLine> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<KolanotInvoiceLine> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<KolanotInvoiceLine> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator);

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
	public java.util.List<KolanotInvoiceLine> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kolanot invoice line in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
				orderByComparator)
		throws NoSuchKolanotInvoiceLineException;

	/**
	 * Returns the first kolanot invoice line in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator);

	/**
	 * Returns the last kolanot invoice line in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
				orderByComparator)
		throws NoSuchKolanotInvoiceLineException;

	/**
	 * Returns the last kolanot invoice line in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator);

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
	public KolanotInvoiceLine[] findByUuid_C_PrevAndNext(
			long invoiceLineId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
				orderByComparator)
		throws NoSuchKolanotInvoiceLineException;

	/**
	 * Removes all the kolanot invoice lines where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of kolanot invoice lines where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching kolanot invoice lines
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the kolanot invoice lines where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @return the matching kolanot invoice lines
	 */
	public java.util.List<KolanotInvoiceLine> findByInvoiceId(long invoiceId);

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
	public java.util.List<KolanotInvoiceLine> findByInvoiceId(
		long invoiceId, int start, int end);

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
	public java.util.List<KolanotInvoiceLine> findByInvoiceId(
		long invoiceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator);

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
	public java.util.List<KolanotInvoiceLine> findByInvoiceId(
		long invoiceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine findByInvoiceId_First(
			long invoiceId,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
				orderByComparator)
		throws NoSuchKolanotInvoiceLineException;

	/**
	 * Returns the first kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine fetchByInvoiceId_First(
		long invoiceId,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator);

	/**
	 * Returns the last kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine findByInvoiceId_Last(
			long invoiceId,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
				orderByComparator)
		throws NoSuchKolanotInvoiceLineException;

	/**
	 * Returns the last kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public KolanotInvoiceLine fetchByInvoiceId_Last(
		long invoiceId,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator);

	/**
	 * Returns the kolanot invoice lines before and after the current kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceLineId the primary key of the current kolanot invoice line
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	public KolanotInvoiceLine[] findByInvoiceId_PrevAndNext(
			long invoiceLineId, long invoiceId,
			com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
				orderByComparator)
		throws NoSuchKolanotInvoiceLineException;

	/**
	 * Removes all the kolanot invoice lines where invoiceId = &#63; from the database.
	 *
	 * @param invoiceId the invoice ID
	 */
	public void removeByInvoiceId(long invoiceId);

	/**
	 * Returns the number of kolanot invoice lines where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @return the number of matching kolanot invoice lines
	 */
	public int countByInvoiceId(long invoiceId);

	/**
	 * Caches the kolanot invoice line in the entity cache if it is enabled.
	 *
	 * @param kolanotInvoiceLine the kolanot invoice line
	 */
	public void cacheResult(KolanotInvoiceLine kolanotInvoiceLine);

	/**
	 * Caches the kolanot invoice lines in the entity cache if it is enabled.
	 *
	 * @param kolanotInvoiceLines the kolanot invoice lines
	 */
	public void cacheResult(
		java.util.List<KolanotInvoiceLine> kolanotInvoiceLines);

	/**
	 * Creates a new kolanot invoice line with the primary key. Does not add the kolanot invoice line to the database.
	 *
	 * @param invoiceLineId the primary key for the new kolanot invoice line
	 * @return the new kolanot invoice line
	 */
	public KolanotInvoiceLine create(long invoiceLineId);

	/**
	 * Removes the kolanot invoice line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoiceLineId the primary key of the kolanot invoice line
	 * @return the kolanot invoice line that was removed
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	public KolanotInvoiceLine remove(long invoiceLineId)
		throws NoSuchKolanotInvoiceLineException;

	public KolanotInvoiceLine updateImpl(KolanotInvoiceLine kolanotInvoiceLine);

	/**
	 * Returns the kolanot invoice line with the primary key or throws a <code>NoSuchKolanotInvoiceLineException</code> if it could not be found.
	 *
	 * @param invoiceLineId the primary key of the kolanot invoice line
	 * @return the kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	public KolanotInvoiceLine findByPrimaryKey(long invoiceLineId)
		throws NoSuchKolanotInvoiceLineException;

	/**
	 * Returns the kolanot invoice line with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoiceLineId the primary key of the kolanot invoice line
	 * @return the kolanot invoice line, or <code>null</code> if a kolanot invoice line with the primary key could not be found
	 */
	public KolanotInvoiceLine fetchByPrimaryKey(long invoiceLineId);

	/**
	 * Returns all the kolanot invoice lines.
	 *
	 * @return the kolanot invoice lines
	 */
	public java.util.List<KolanotInvoiceLine> findAll();

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
	public java.util.List<KolanotInvoiceLine> findAll(int start, int end);

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
	public java.util.List<KolanotInvoiceLine> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator);

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
	public java.util.List<KolanotInvoiceLine> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KolanotInvoiceLine>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the kolanot invoice lines from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of kolanot invoice lines.
	 *
	 * @return the number of kolanot invoice lines
	 */
	public int countAll();

}