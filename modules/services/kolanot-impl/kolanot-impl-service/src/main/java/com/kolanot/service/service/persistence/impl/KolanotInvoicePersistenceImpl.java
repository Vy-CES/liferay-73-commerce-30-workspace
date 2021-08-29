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

package com.kolanot.service.service.persistence.impl;

import com.kolanot.service.exception.NoSuchKolanotInvoiceException;
import com.kolanot.service.model.KolanotInvoice;
import com.kolanot.service.model.impl.KolanotInvoiceImpl;
import com.kolanot.service.model.impl.KolanotInvoiceModelImpl;
import com.kolanot.service.service.persistence.KolanotInvoicePersistence;
import com.kolanot.service.service.persistence.impl.constants.kolanotPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the kolanot invoice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = KolanotInvoicePersistence.class)
public class KolanotInvoicePersistenceImpl
	extends BasePersistenceImpl<KolanotInvoice>
	implements KolanotInvoicePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>KolanotInvoiceUtil</code> to access the kolanot invoice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		KolanotInvoiceImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the kolanot invoices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching kolanot invoices
	 */
	@Override
	public List<KolanotInvoice> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<KolanotInvoice> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<KolanotInvoice> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<KolanotInvoice> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<KolanotInvoice> list = null;

		if (useFinderCache) {
			list = (List<KolanotInvoice>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KolanotInvoice kolanotInvoice : list) {
					if (!uuid.equals(kolanotInvoice.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_KOLANOTINVOICE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(KolanotInvoiceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<KolanotInvoice>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice findByUuid_First(
			String uuid, OrderByComparator<KolanotInvoice> orderByComparator)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice = fetchByUuid_First(
			uuid, orderByComparator);

		if (kolanotInvoice != null) {
			return kolanotInvoice;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchKolanotInvoiceException(sb.toString());
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice fetchByUuid_First(
		String uuid, OrderByComparator<KolanotInvoice> orderByComparator) {

		List<KolanotInvoice> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice findByUuid_Last(
			String uuid, OrderByComparator<KolanotInvoice> orderByComparator)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice = fetchByUuid_Last(
			uuid, orderByComparator);

		if (kolanotInvoice != null) {
			return kolanotInvoice;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchKolanotInvoiceException(sb.toString());
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice fetchByUuid_Last(
		String uuid, OrderByComparator<KolanotInvoice> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<KolanotInvoice> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public KolanotInvoice[] findByUuid_PrevAndNext(
			long invoiceId, String uuid,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws NoSuchKolanotInvoiceException {

		uuid = Objects.toString(uuid, "");

		KolanotInvoice kolanotInvoice = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			KolanotInvoice[] array = new KolanotInvoiceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, kolanotInvoice, uuid, orderByComparator, true);

			array[1] = kolanotInvoice;

			array[2] = getByUuid_PrevAndNext(
				session, kolanotInvoice, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected KolanotInvoice getByUuid_PrevAndNext(
		Session session, KolanotInvoice kolanotInvoice, String uuid,
		OrderByComparator<KolanotInvoice> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_KOLANOTINVOICE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(KolanotInvoiceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						kolanotInvoice)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<KolanotInvoice> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kolanot invoices where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (KolanotInvoice kolanotInvoice :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(kolanotInvoice);
		}
	}

	/**
	 * Returns the number of kolanot invoices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching kolanot invoices
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_KOLANOTINVOICE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"kolanotInvoice.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(kolanotInvoice.uuid IS NULL OR kolanotInvoice.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the kolanot invoice where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchKolanotInvoiceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice findByUUID_G(String uuid, long groupId)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice = fetchByUUID_G(uuid, groupId);

		if (kolanotInvoice == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchKolanotInvoiceException(sb.toString());
		}

		return kolanotInvoice;
	}

	/**
	 * Returns the kolanot invoice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the kolanot invoice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof KolanotInvoice) {
			KolanotInvoice kolanotInvoice = (KolanotInvoice)result;

			if (!Objects.equals(uuid, kolanotInvoice.getUuid()) ||
				(groupId != kolanotInvoice.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_KOLANOTINVOICE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<KolanotInvoice> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					KolanotInvoice kolanotInvoice = list.get(0);

					result = kolanotInvoice;

					cacheResult(kolanotInvoice);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (KolanotInvoice)result;
		}
	}

	/**
	 * Removes the kolanot invoice where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the kolanot invoice that was removed
	 */
	@Override
	public KolanotInvoice removeByUUID_G(String uuid, long groupId)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice = findByUUID_G(uuid, groupId);

		return remove(kolanotInvoice);
	}

	/**
	 * Returns the number of kolanot invoices where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching kolanot invoices
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_KOLANOTINVOICE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"kolanotInvoice.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(kolanotInvoice.uuid IS NULL OR kolanotInvoice.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"kolanotInvoice.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the kolanot invoices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching kolanot invoices
	 */
	@Override
	public List<KolanotInvoice> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<KolanotInvoice> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<KolanotInvoice> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<KolanotInvoice> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<KolanotInvoice> list = null;

		if (useFinderCache) {
			list = (List<KolanotInvoice>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KolanotInvoice kolanotInvoice : list) {
					if (!uuid.equals(kolanotInvoice.getUuid()) ||
						(companyId != kolanotInvoice.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_KOLANOTINVOICE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(KolanotInvoiceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<KolanotInvoice>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public KolanotInvoice findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (kolanotInvoice != null) {
			return kolanotInvoice;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchKolanotInvoiceException(sb.toString());
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		List<KolanotInvoice> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public KolanotInvoice findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (kolanotInvoice != null) {
			return kolanotInvoice;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchKolanotInvoiceException(sb.toString());
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<KolanotInvoice> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public KolanotInvoice[] findByUuid_C_PrevAndNext(
			long invoiceId, String uuid, long companyId,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws NoSuchKolanotInvoiceException {

		uuid = Objects.toString(uuid, "");

		KolanotInvoice kolanotInvoice = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			KolanotInvoice[] array = new KolanotInvoiceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, kolanotInvoice, uuid, companyId, orderByComparator,
				true);

			array[1] = kolanotInvoice;

			array[2] = getByUuid_C_PrevAndNext(
				session, kolanotInvoice, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected KolanotInvoice getByUuid_C_PrevAndNext(
		Session session, KolanotInvoice kolanotInvoice, String uuid,
		long companyId, OrderByComparator<KolanotInvoice> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_KOLANOTINVOICE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(KolanotInvoiceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						kolanotInvoice)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<KolanotInvoice> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kolanot invoices where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (KolanotInvoice kolanotInvoice :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(kolanotInvoice);
		}
	}

	/**
	 * Returns the number of kolanot invoices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching kolanot invoices
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_KOLANOTINVOICE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"kolanotInvoice.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(kolanotInvoice.uuid IS NULL OR kolanotInvoice.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"kolanotInvoice.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCreatedByAccountId;
	private FinderPath _finderPathWithoutPaginationFindByCreatedByAccountId;
	private FinderPath _finderPathCountByCreatedByAccountId;

	/**
	 * Returns all the kolanot invoices where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @return the matching kolanot invoices
	 */
	@Override
	public List<KolanotInvoice> findByCreatedByAccountId(
		long createdByAccountId) {

		return findByCreatedByAccountId(
			createdByAccountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<KolanotInvoice> findByCreatedByAccountId(
		long createdByAccountId, int start, int end) {

		return findByCreatedByAccountId(createdByAccountId, start, end, null);
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
	@Override
	public List<KolanotInvoice> findByCreatedByAccountId(
		long createdByAccountId, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return findByCreatedByAccountId(
			createdByAccountId, start, end, orderByComparator, true);
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
	@Override
	public List<KolanotInvoice> findByCreatedByAccountId(
		long createdByAccountId, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCreatedByAccountId;
				finderArgs = new Object[] {createdByAccountId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCreatedByAccountId;
			finderArgs = new Object[] {
				createdByAccountId, start, end, orderByComparator
			};
		}

		List<KolanotInvoice> list = null;

		if (useFinderCache) {
			list = (List<KolanotInvoice>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KolanotInvoice kolanotInvoice : list) {
					if (createdByAccountId !=
							kolanotInvoice.getCreatedByAccountId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_KOLANOTINVOICE_WHERE);

			sb.append(_FINDER_COLUMN_CREATEDBYACCOUNTID_CREATEDBYACCOUNTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(KolanotInvoiceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(createdByAccountId);

				list = (List<KolanotInvoice>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice findByCreatedByAccountId_First(
			long createdByAccountId,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice = fetchByCreatedByAccountId_First(
			createdByAccountId, orderByComparator);

		if (kolanotInvoice != null) {
			return kolanotInvoice;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createdByAccountId=");
		sb.append(createdByAccountId);

		sb.append("}");

		throw new NoSuchKolanotInvoiceException(sb.toString());
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice fetchByCreatedByAccountId_First(
		long createdByAccountId,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		List<KolanotInvoice> list = findByCreatedByAccountId(
			createdByAccountId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice findByCreatedByAccountId_Last(
			long createdByAccountId,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice = fetchByCreatedByAccountId_Last(
			createdByAccountId, orderByComparator);

		if (kolanotInvoice != null) {
			return kolanotInvoice;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createdByAccountId=");
		sb.append(createdByAccountId);

		sb.append("}");

		throw new NoSuchKolanotInvoiceException(sb.toString());
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice fetchByCreatedByAccountId_Last(
		long createdByAccountId,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		int count = countByCreatedByAccountId(createdByAccountId);

		if (count == 0) {
			return null;
		}

		List<KolanotInvoice> list = findByCreatedByAccountId(
			createdByAccountId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public KolanotInvoice[] findByCreatedByAccountId_PrevAndNext(
			long invoiceId, long createdByAccountId,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			KolanotInvoice[] array = new KolanotInvoiceImpl[3];

			array[0] = getByCreatedByAccountId_PrevAndNext(
				session, kolanotInvoice, createdByAccountId, orderByComparator,
				true);

			array[1] = kolanotInvoice;

			array[2] = getByCreatedByAccountId_PrevAndNext(
				session, kolanotInvoice, createdByAccountId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected KolanotInvoice getByCreatedByAccountId_PrevAndNext(
		Session session, KolanotInvoice kolanotInvoice, long createdByAccountId,
		OrderByComparator<KolanotInvoice> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_KOLANOTINVOICE_WHERE);

		sb.append(_FINDER_COLUMN_CREATEDBYACCOUNTID_CREATEDBYACCOUNTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(KolanotInvoiceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(createdByAccountId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						kolanotInvoice)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<KolanotInvoice> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kolanot invoices where createdByAccountId = &#63; from the database.
	 *
	 * @param createdByAccountId the created by account ID
	 */
	@Override
	public void removeByCreatedByAccountId(long createdByAccountId) {
		for (KolanotInvoice kolanotInvoice :
				findByCreatedByAccountId(
					createdByAccountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(kolanotInvoice);
		}
	}

	/**
	 * Returns the number of kolanot invoices where createdByAccountId = &#63;.
	 *
	 * @param createdByAccountId the created by account ID
	 * @return the number of matching kolanot invoices
	 */
	@Override
	public int countByCreatedByAccountId(long createdByAccountId) {
		FinderPath finderPath = _finderPathCountByCreatedByAccountId;

		Object[] finderArgs = new Object[] {createdByAccountId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_KOLANOTINVOICE_WHERE);

			sb.append(_FINDER_COLUMN_CREATEDBYACCOUNTID_CREATEDBYACCOUNTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(createdByAccountId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_CREATEDBYACCOUNTID_CREATEDBYACCOUNTID_2 =
			"kolanotInvoice.createdByAccountId = ?";

	private FinderPath
		_finderPathWithPaginationFindByAccountExternalReferenceCode;
	private FinderPath
		_finderPathWithoutPaginationFindByAccountExternalReferenceCode;
	private FinderPath _finderPathCountByAccountExternalReferenceCode;

	/**
	 * Returns all the kolanot invoices where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @return the matching kolanot invoices
	 */
	@Override
	public List<KolanotInvoice> findByAccountExternalReferenceCode(
		String accountExternalReferenceCode) {

		return findByAccountExternalReferenceCode(
			accountExternalReferenceCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<KolanotInvoice> findByAccountExternalReferenceCode(
		String accountExternalReferenceCode, int start, int end) {

		return findByAccountExternalReferenceCode(
			accountExternalReferenceCode, start, end, null);
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
	@Override
	public List<KolanotInvoice> findByAccountExternalReferenceCode(
		String accountExternalReferenceCode, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return findByAccountExternalReferenceCode(
			accountExternalReferenceCode, start, end, orderByComparator, true);
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
	@Override
	public List<KolanotInvoice> findByAccountExternalReferenceCode(
		String accountExternalReferenceCode, int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator,
		boolean useFinderCache) {

		accountExternalReferenceCode = Objects.toString(
			accountExternalReferenceCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByAccountExternalReferenceCode;
				finderArgs = new Object[] {accountExternalReferenceCode};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByAccountExternalReferenceCode;
			finderArgs = new Object[] {
				accountExternalReferenceCode, start, end, orderByComparator
			};
		}

		List<KolanotInvoice> list = null;

		if (useFinderCache) {
			list = (List<KolanotInvoice>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KolanotInvoice kolanotInvoice : list) {
					if (!accountExternalReferenceCode.equals(
							kolanotInvoice.getAccountExternalReferenceCode())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_KOLANOTINVOICE_WHERE);

			boolean bindAccountExternalReferenceCode = false;

			if (accountExternalReferenceCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ACCOUNTEXTERNALREFERENCECODE_ACCOUNTEXTERNALREFERENCECODE_3);
			}
			else {
				bindAccountExternalReferenceCode = true;

				sb.append(
					_FINDER_COLUMN_ACCOUNTEXTERNALREFERENCECODE_ACCOUNTEXTERNALREFERENCECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(KolanotInvoiceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAccountExternalReferenceCode) {
					queryPos.add(accountExternalReferenceCode);
				}

				list = (List<KolanotInvoice>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice findByAccountExternalReferenceCode_First(
			String accountExternalReferenceCode,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice =
			fetchByAccountExternalReferenceCode_First(
				accountExternalReferenceCode, orderByComparator);

		if (kolanotInvoice != null) {
			return kolanotInvoice;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("accountExternalReferenceCode=");
		sb.append(accountExternalReferenceCode);

		sb.append("}");

		throw new NoSuchKolanotInvoiceException(sb.toString());
	}

	/**
	 * Returns the first kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice fetchByAccountExternalReferenceCode_First(
		String accountExternalReferenceCode,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		List<KolanotInvoice> list = findByAccountExternalReferenceCode(
			accountExternalReferenceCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice findByAccountExternalReferenceCode_Last(
			String accountExternalReferenceCode,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice =
			fetchByAccountExternalReferenceCode_Last(
				accountExternalReferenceCode, orderByComparator);

		if (kolanotInvoice != null) {
			return kolanotInvoice;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("accountExternalReferenceCode=");
		sb.append(accountExternalReferenceCode);

		sb.append("}");

		throw new NoSuchKolanotInvoiceException(sb.toString());
	}

	/**
	 * Returns the last kolanot invoice in the ordered set where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice fetchByAccountExternalReferenceCode_Last(
		String accountExternalReferenceCode,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		int count = countByAccountExternalReferenceCode(
			accountExternalReferenceCode);

		if (count == 0) {
			return null;
		}

		List<KolanotInvoice> list = findByAccountExternalReferenceCode(
			accountExternalReferenceCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public KolanotInvoice[] findByAccountExternalReferenceCode_PrevAndNext(
			long invoiceId, String accountExternalReferenceCode,
			OrderByComparator<KolanotInvoice> orderByComparator)
		throws NoSuchKolanotInvoiceException {

		accountExternalReferenceCode = Objects.toString(
			accountExternalReferenceCode, "");

		KolanotInvoice kolanotInvoice = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			KolanotInvoice[] array = new KolanotInvoiceImpl[3];

			array[0] = getByAccountExternalReferenceCode_PrevAndNext(
				session, kolanotInvoice, accountExternalReferenceCode,
				orderByComparator, true);

			array[1] = kolanotInvoice;

			array[2] = getByAccountExternalReferenceCode_PrevAndNext(
				session, kolanotInvoice, accountExternalReferenceCode,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected KolanotInvoice getByAccountExternalReferenceCode_PrevAndNext(
		Session session, KolanotInvoice kolanotInvoice,
		String accountExternalReferenceCode,
		OrderByComparator<KolanotInvoice> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_KOLANOTINVOICE_WHERE);

		boolean bindAccountExternalReferenceCode = false;

		if (accountExternalReferenceCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_ACCOUNTEXTERNALREFERENCECODE_ACCOUNTEXTERNALREFERENCECODE_3);
		}
		else {
			bindAccountExternalReferenceCode = true;

			sb.append(
				_FINDER_COLUMN_ACCOUNTEXTERNALREFERENCECODE_ACCOUNTEXTERNALREFERENCECODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(KolanotInvoiceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAccountExternalReferenceCode) {
			queryPos.add(accountExternalReferenceCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						kolanotInvoice)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<KolanotInvoice> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kolanot invoices where accountExternalReferenceCode = &#63; from the database.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 */
	@Override
	public void removeByAccountExternalReferenceCode(
		String accountExternalReferenceCode) {

		for (KolanotInvoice kolanotInvoice :
				findByAccountExternalReferenceCode(
					accountExternalReferenceCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(kolanotInvoice);
		}
	}

	/**
	 * Returns the number of kolanot invoices where accountExternalReferenceCode = &#63;.
	 *
	 * @param accountExternalReferenceCode the account external reference code
	 * @return the number of matching kolanot invoices
	 */
	@Override
	public int countByAccountExternalReferenceCode(
		String accountExternalReferenceCode) {

		accountExternalReferenceCode = Objects.toString(
			accountExternalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByAccountExternalReferenceCode;

		Object[] finderArgs = new Object[] {accountExternalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_KOLANOTINVOICE_WHERE);

			boolean bindAccountExternalReferenceCode = false;

			if (accountExternalReferenceCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ACCOUNTEXTERNALREFERENCECODE_ACCOUNTEXTERNALREFERENCECODE_3);
			}
			else {
				bindAccountExternalReferenceCode = true;

				sb.append(
					_FINDER_COLUMN_ACCOUNTEXTERNALREFERENCECODE_ACCOUNTEXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAccountExternalReferenceCode) {
					queryPos.add(accountExternalReferenceCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_ACCOUNTEXTERNALREFERENCECODE_ACCOUNTEXTERNALREFERENCECODE_2 =
			"kolanotInvoice.accountExternalReferenceCode = ?";

	private static final String
		_FINDER_COLUMN_ACCOUNTEXTERNALREFERENCECODE_ACCOUNTEXTERNALREFERENCECODE_3 =
			"(kolanotInvoice.accountExternalReferenceCode IS NULL OR kolanotInvoice.accountExternalReferenceCode = '')";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the kolanot invoice where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchKolanotInvoiceException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (kolanotInvoice == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", externalReferenceCode=");
			sb.append(externalReferenceCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchKolanotInvoiceException(sb.toString());
		}

		return kolanotInvoice;
	}

	/**
	 * Returns the kolanot invoice where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the kolanot invoice where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public KolanotInvoice fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, externalReferenceCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_ERC, finderArgs, this);
		}

		if (result instanceof KolanotInvoice) {
			KolanotInvoice kolanotInvoice = (KolanotInvoice)result;

			if ((companyId != kolanotInvoice.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					kolanotInvoice.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_KOLANOTINVOICE_WHERE);

			sb.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
				}

				List<KolanotInvoice> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_ERC, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									companyId, externalReferenceCode
								};
							}

							_log.warn(
								"KolanotInvoicePersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					KolanotInvoice kolanotInvoice = list.get(0);

					result = kolanotInvoice;

					cacheResult(kolanotInvoice);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (KolanotInvoice)result;
		}
	}

	/**
	 * Removes the kolanot invoice where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the kolanot invoice that was removed
	 */
	@Override
	public KolanotInvoice removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(kolanotInvoice);
	}

	/**
	 * Returns the number of kolanot invoices where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching kolanot invoices
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_KOLANOTINVOICE_WHERE);

			sb.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_ERC_COMPANYID_2 =
		"kolanotInvoice.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"kolanotInvoice.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(kolanotInvoice.externalReferenceCode IS NULL OR kolanotInvoice.externalReferenceCode = '')";

	public KolanotInvoicePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(KolanotInvoice.class);

		setModelImplClass(KolanotInvoiceImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the kolanot invoice in the entity cache if it is enabled.
	 *
	 * @param kolanotInvoice the kolanot invoice
	 */
	@Override
	public void cacheResult(KolanotInvoice kolanotInvoice) {
		entityCache.putResult(
			KolanotInvoiceImpl.class, kolanotInvoice.getPrimaryKey(),
			kolanotInvoice);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				kolanotInvoice.getUuid(), kolanotInvoice.getGroupId()
			},
			kolanotInvoice);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				kolanotInvoice.getCompanyId(),
				kolanotInvoice.getExternalReferenceCode()
			},
			kolanotInvoice);

		kolanotInvoice.resetOriginalValues();
	}

	/**
	 * Caches the kolanot invoices in the entity cache if it is enabled.
	 *
	 * @param kolanotInvoices the kolanot invoices
	 */
	@Override
	public void cacheResult(List<KolanotInvoice> kolanotInvoices) {
		for (KolanotInvoice kolanotInvoice : kolanotInvoices) {
			if (entityCache.getResult(
					KolanotInvoiceImpl.class, kolanotInvoice.getPrimaryKey()) ==
						null) {

				cacheResult(kolanotInvoice);
			}
			else {
				kolanotInvoice.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kolanot invoices.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(KolanotInvoiceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kolanot invoice.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KolanotInvoice kolanotInvoice) {
		entityCache.removeResult(
			KolanotInvoiceImpl.class, kolanotInvoice.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((KolanotInvoiceModelImpl)kolanotInvoice, true);
	}

	@Override
	public void clearCache(List<KolanotInvoice> kolanotInvoices) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KolanotInvoice kolanotInvoice : kolanotInvoices) {
			entityCache.removeResult(
				KolanotInvoiceImpl.class, kolanotInvoice.getPrimaryKey());

			clearUniqueFindersCache(
				(KolanotInvoiceModelImpl)kolanotInvoice, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(KolanotInvoiceImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		KolanotInvoiceModelImpl kolanotInvoiceModelImpl) {

		Object[] args = new Object[] {
			kolanotInvoiceModelImpl.getUuid(),
			kolanotInvoiceModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, kolanotInvoiceModelImpl, false);

		args = new Object[] {
			kolanotInvoiceModelImpl.getCompanyId(),
			kolanotInvoiceModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(
			_finderPathCountByC_ERC, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, kolanotInvoiceModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		KolanotInvoiceModelImpl kolanotInvoiceModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				kolanotInvoiceModelImpl.getUuid(),
				kolanotInvoiceModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((kolanotInvoiceModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				kolanotInvoiceModelImpl.getOriginalUuid(),
				kolanotInvoiceModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				kolanotInvoiceModelImpl.getCompanyId(),
				kolanotInvoiceModelImpl.getExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}

		if ((kolanotInvoiceModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_ERC.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				kolanotInvoiceModelImpl.getOriginalCompanyId(),
				kolanotInvoiceModelImpl.getOriginalExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}
	}

	/**
	 * Creates a new kolanot invoice with the primary key. Does not add the kolanot invoice to the database.
	 *
	 * @param invoiceId the primary key for the new kolanot invoice
	 * @return the new kolanot invoice
	 */
	@Override
	public KolanotInvoice create(long invoiceId) {
		KolanotInvoice kolanotInvoice = new KolanotInvoiceImpl();

		kolanotInvoice.setNew(true);
		kolanotInvoice.setPrimaryKey(invoiceId);

		String uuid = PortalUUIDUtil.generate();

		kolanotInvoice.setUuid(uuid);

		kolanotInvoice.setCompanyId(CompanyThreadLocal.getCompanyId());

		return kolanotInvoice;
	}

	/**
	 * Removes the kolanot invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoiceId the primary key of the kolanot invoice
	 * @return the kolanot invoice that was removed
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	@Override
	public KolanotInvoice remove(long invoiceId)
		throws NoSuchKolanotInvoiceException {

		return remove((Serializable)invoiceId);
	}

	/**
	 * Removes the kolanot invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kolanot invoice
	 * @return the kolanot invoice that was removed
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	@Override
	public KolanotInvoice remove(Serializable primaryKey)
		throws NoSuchKolanotInvoiceException {

		Session session = null;

		try {
			session = openSession();

			KolanotInvoice kolanotInvoice = (KolanotInvoice)session.get(
				KolanotInvoiceImpl.class, primaryKey);

			if (kolanotInvoice == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKolanotInvoiceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(kolanotInvoice);
		}
		catch (NoSuchKolanotInvoiceException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected KolanotInvoice removeImpl(KolanotInvoice kolanotInvoice) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kolanotInvoice)) {
				kolanotInvoice = (KolanotInvoice)session.get(
					KolanotInvoiceImpl.class,
					kolanotInvoice.getPrimaryKeyObj());
			}

			if (kolanotInvoice != null) {
				session.delete(kolanotInvoice);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (kolanotInvoice != null) {
			clearCache(kolanotInvoice);
		}

		return kolanotInvoice;
	}

	@Override
	public KolanotInvoice updateImpl(KolanotInvoice kolanotInvoice) {
		boolean isNew = kolanotInvoice.isNew();

		if (!(kolanotInvoice instanceof KolanotInvoiceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(kolanotInvoice.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					kolanotInvoice);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in kolanotInvoice proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom KolanotInvoice implementation " +
					kolanotInvoice.getClass());
		}

		KolanotInvoiceModelImpl kolanotInvoiceModelImpl =
			(KolanotInvoiceModelImpl)kolanotInvoice;

		if (Validator.isNull(kolanotInvoice.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			kolanotInvoice.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (kolanotInvoice.getCreateDate() == null)) {
			if (serviceContext == null) {
				kolanotInvoice.setCreateDate(now);
			}
			else {
				kolanotInvoice.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!kolanotInvoiceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				kolanotInvoice.setModifiedDate(now);
			}
			else {
				kolanotInvoice.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (kolanotInvoice.isNew()) {
				session.save(kolanotInvoice);

				kolanotInvoice.setNew(false);
			}
			else {
				kolanotInvoice = (KolanotInvoice)session.merge(kolanotInvoice);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			Object[] args = new Object[] {kolanotInvoiceModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				kolanotInvoiceModelImpl.getUuid(),
				kolanotInvoiceModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				kolanotInvoiceModelImpl.getCreatedByAccountId()
			};

			finderCache.removeResult(
				_finderPathCountByCreatedByAccountId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCreatedByAccountId, args);

			args = new Object[] {
				kolanotInvoiceModelImpl.getAccountExternalReferenceCode()
			};

			finderCache.removeResult(
				_finderPathCountByAccountExternalReferenceCode, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAccountExternalReferenceCode,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((kolanotInvoiceModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					kolanotInvoiceModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {kolanotInvoiceModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((kolanotInvoiceModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					kolanotInvoiceModelImpl.getOriginalUuid(),
					kolanotInvoiceModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					kolanotInvoiceModelImpl.getUuid(),
					kolanotInvoiceModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((kolanotInvoiceModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCreatedByAccountId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					kolanotInvoiceModelImpl.getOriginalCreatedByAccountId()
				};

				finderCache.removeResult(
					_finderPathCountByCreatedByAccountId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCreatedByAccountId, args);

				args = new Object[] {
					kolanotInvoiceModelImpl.getCreatedByAccountId()
				};

				finderCache.removeResult(
					_finderPathCountByCreatedByAccountId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCreatedByAccountId, args);
			}

			if ((kolanotInvoiceModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAccountExternalReferenceCode.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					kolanotInvoiceModelImpl.
						getOriginalAccountExternalReferenceCode()
				};

				finderCache.removeResult(
					_finderPathCountByAccountExternalReferenceCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAccountExternalReferenceCode,
					args);

				args = new Object[] {
					kolanotInvoiceModelImpl.getAccountExternalReferenceCode()
				};

				finderCache.removeResult(
					_finderPathCountByAccountExternalReferenceCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAccountExternalReferenceCode,
					args);
			}
		}

		entityCache.putResult(
			KolanotInvoiceImpl.class, kolanotInvoice.getPrimaryKey(),
			kolanotInvoice, false);

		clearUniqueFindersCache(kolanotInvoiceModelImpl, false);
		cacheUniqueFindersCache(kolanotInvoiceModelImpl);

		kolanotInvoice.resetOriginalValues();

		return kolanotInvoice;
	}

	/**
	 * Returns the kolanot invoice with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kolanot invoice
	 * @return the kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	@Override
	public KolanotInvoice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKolanotInvoiceException {

		KolanotInvoice kolanotInvoice = fetchByPrimaryKey(primaryKey);

		if (kolanotInvoice == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKolanotInvoiceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return kolanotInvoice;
	}

	/**
	 * Returns the kolanot invoice with the primary key or throws a <code>NoSuchKolanotInvoiceException</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the kolanot invoice
	 * @return the kolanot invoice
	 * @throws NoSuchKolanotInvoiceException if a kolanot invoice with the primary key could not be found
	 */
	@Override
	public KolanotInvoice findByPrimaryKey(long invoiceId)
		throws NoSuchKolanotInvoiceException {

		return findByPrimaryKey((Serializable)invoiceId);
	}

	/**
	 * Returns the kolanot invoice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the kolanot invoice
	 * @return the kolanot invoice, or <code>null</code> if a kolanot invoice with the primary key could not be found
	 */
	@Override
	public KolanotInvoice fetchByPrimaryKey(long invoiceId) {
		return fetchByPrimaryKey((Serializable)invoiceId);
	}

	/**
	 * Returns all the kolanot invoices.
	 *
	 * @return the kolanot invoices
	 */
	@Override
	public List<KolanotInvoice> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<KolanotInvoice> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<KolanotInvoice> findAll(
		int start, int end,
		OrderByComparator<KolanotInvoice> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<KolanotInvoice> findAll(
		int start, int end, OrderByComparator<KolanotInvoice> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<KolanotInvoice> list = null;

		if (useFinderCache) {
			list = (List<KolanotInvoice>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_KOLANOTINVOICE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_KOLANOTINVOICE;

				sql = sql.concat(KolanotInvoiceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<KolanotInvoice>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the kolanot invoices from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (KolanotInvoice kolanotInvoice : findAll()) {
			remove(kolanotInvoice);
		}
	}

	/**
	 * Returns the number of kolanot invoices.
	 *
	 * @return the number of kolanot invoices
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_KOLANOTINVOICE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "invoiceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_KOLANOTINVOICE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return KolanotInvoiceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the kolanot invoice persistence.
	 */
	@Activate
	public void activate() {
		_finderPathWithPaginationFindAll = new FinderPath(
			KolanotInvoiceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			KolanotInvoiceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			KolanotInvoiceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			KolanotInvoiceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] {String.class.getName()},
			KolanotInvoiceModelImpl.UUID_COLUMN_BITMASK |
			KolanotInvoiceModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			KolanotInvoiceImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			KolanotInvoiceModelImpl.UUID_COLUMN_BITMASK |
			KolanotInvoiceModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			KolanotInvoiceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			KolanotInvoiceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			KolanotInvoiceModelImpl.UUID_COLUMN_BITMASK |
			KolanotInvoiceModelImpl.COMPANYID_COLUMN_BITMASK |
			KolanotInvoiceModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByCreatedByAccountId = new FinderPath(
			KolanotInvoiceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreatedByAccountId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCreatedByAccountId = new FinderPath(
			KolanotInvoiceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCreatedByAccountId", new String[] {Long.class.getName()},
			KolanotInvoiceModelImpl.CREATEDBYACCOUNTID_COLUMN_BITMASK |
			KolanotInvoiceModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByCreatedByAccountId = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCreatedByAccountId", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByAccountExternalReferenceCode =
			new FinderPath(
				KolanotInvoiceImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByAccountExternalReferenceCode",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByAccountExternalReferenceCode =
			new FinderPath(
				KolanotInvoiceImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByAccountExternalReferenceCode",
				new String[] {String.class.getName()},
				KolanotInvoiceModelImpl.
					ACCOUNTEXTERNALREFERENCECODE_COLUMN_BITMASK |
				KolanotInvoiceModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByAccountExternalReferenceCode = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAccountExternalReferenceCode",
			new String[] {String.class.getName()});

		_finderPathFetchByC_ERC = new FinderPath(
			KolanotInvoiceImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			KolanotInvoiceModelImpl.COMPANYID_COLUMN_BITMASK |
			KolanotInvoiceModelImpl.EXTERNALREFERENCECODE_COLUMN_BITMASK);

		_finderPathCountByC_ERC = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(KolanotInvoiceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = kolanotPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = kolanotPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = kolanotPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_KOLANOTINVOICE =
		"SELECT kolanotInvoice FROM KolanotInvoice kolanotInvoice";

	private static final String _SQL_SELECT_KOLANOTINVOICE_WHERE =
		"SELECT kolanotInvoice FROM KolanotInvoice kolanotInvoice WHERE ";

	private static final String _SQL_COUNT_KOLANOTINVOICE =
		"SELECT COUNT(kolanotInvoice) FROM KolanotInvoice kolanotInvoice";

	private static final String _SQL_COUNT_KOLANOTINVOICE_WHERE =
		"SELECT COUNT(kolanotInvoice) FROM KolanotInvoice kolanotInvoice WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "kolanotInvoice.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No KolanotInvoice exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No KolanotInvoice exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		KolanotInvoicePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(kolanotPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}