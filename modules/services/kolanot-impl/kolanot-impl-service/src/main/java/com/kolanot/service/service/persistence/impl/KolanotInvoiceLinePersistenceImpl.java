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

import com.kolanot.service.exception.NoSuchKolanotInvoiceLineException;
import com.kolanot.service.model.KolanotInvoiceLine;
import com.kolanot.service.model.impl.KolanotInvoiceLineImpl;
import com.kolanot.service.model.impl.KolanotInvoiceLineModelImpl;
import com.kolanot.service.service.persistence.KolanotInvoiceLinePersistence;
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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the kolanot invoice line service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = KolanotInvoiceLinePersistence.class)
public class KolanotInvoiceLinePersistenceImpl
	extends BasePersistenceImpl<KolanotInvoiceLine>
	implements KolanotInvoiceLinePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>KolanotInvoiceLineUtil</code> to access the kolanot invoice line persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		KolanotInvoiceLineImpl.class.getName();

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
	 * Returns all the kolanot invoice lines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching kolanot invoice lines
	 */
	@Override
	public List<KolanotInvoiceLine> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<KolanotInvoiceLine> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<KolanotInvoiceLine> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<KolanotInvoiceLine> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator,
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

		List<KolanotInvoiceLine> list = null;

		if (useFinderCache) {
			list = (List<KolanotInvoiceLine>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KolanotInvoiceLine kolanotInvoiceLine : list) {
					if (!uuid.equals(kolanotInvoiceLine.getUuid())) {
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

			sb.append(_SQL_SELECT_KOLANOTINVOICELINE_WHERE);

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
				sb.append(KolanotInvoiceLineModelImpl.ORDER_BY_JPQL);
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

				list = (List<KolanotInvoiceLine>)QueryUtil.list(
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
	 * Returns the first kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine findByUuid_First(
			String uuid,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws NoSuchKolanotInvoiceLineException {

		KolanotInvoiceLine kolanotInvoiceLine = fetchByUuid_First(
			uuid, orderByComparator);

		if (kolanotInvoiceLine != null) {
			return kolanotInvoiceLine;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchKolanotInvoiceLineException(sb.toString());
	}

	/**
	 * Returns the first kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine fetchByUuid_First(
		String uuid, OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		List<KolanotInvoiceLine> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine findByUuid_Last(
			String uuid,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws NoSuchKolanotInvoiceLineException {

		KolanotInvoiceLine kolanotInvoiceLine = fetchByUuid_Last(
			uuid, orderByComparator);

		if (kolanotInvoiceLine != null) {
			return kolanotInvoiceLine;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchKolanotInvoiceLineException(sb.toString());
	}

	/**
	 * Returns the last kolanot invoice line in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine fetchByUuid_Last(
		String uuid, OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<KolanotInvoiceLine> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public KolanotInvoiceLine[] findByUuid_PrevAndNext(
			long invoiceLineId, String uuid,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws NoSuchKolanotInvoiceLineException {

		uuid = Objects.toString(uuid, "");

		KolanotInvoiceLine kolanotInvoiceLine = findByPrimaryKey(invoiceLineId);

		Session session = null;

		try {
			session = openSession();

			KolanotInvoiceLine[] array = new KolanotInvoiceLineImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, kolanotInvoiceLine, uuid, orderByComparator, true);

			array[1] = kolanotInvoiceLine;

			array[2] = getByUuid_PrevAndNext(
				session, kolanotInvoiceLine, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected KolanotInvoiceLine getByUuid_PrevAndNext(
		Session session, KolanotInvoiceLine kolanotInvoiceLine, String uuid,
		OrderByComparator<KolanotInvoiceLine> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_KOLANOTINVOICELINE_WHERE);

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
			sb.append(KolanotInvoiceLineModelImpl.ORDER_BY_JPQL);
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
						kolanotInvoiceLine)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<KolanotInvoiceLine> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kolanot invoice lines where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (KolanotInvoiceLine kolanotInvoiceLine :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(kolanotInvoiceLine);
		}
	}

	/**
	 * Returns the number of kolanot invoice lines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching kolanot invoice lines
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_KOLANOTINVOICELINE_WHERE);

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
		"kolanotInvoiceLine.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(kolanotInvoiceLine.uuid IS NULL OR kolanotInvoiceLine.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the kolanot invoice line where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchKolanotInvoiceLineException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine findByUUID_G(String uuid, long groupId)
		throws NoSuchKolanotInvoiceLineException {

		KolanotInvoiceLine kolanotInvoiceLine = fetchByUUID_G(uuid, groupId);

		if (kolanotInvoiceLine == null) {
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

			throw new NoSuchKolanotInvoiceLineException(sb.toString());
		}

		return kolanotInvoiceLine;
	}

	/**
	 * Returns the kolanot invoice line where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the kolanot invoice line where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine fetchByUUID_G(
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

		if (result instanceof KolanotInvoiceLine) {
			KolanotInvoiceLine kolanotInvoiceLine = (KolanotInvoiceLine)result;

			if (!Objects.equals(uuid, kolanotInvoiceLine.getUuid()) ||
				(groupId != kolanotInvoiceLine.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_KOLANOTINVOICELINE_WHERE);

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

				List<KolanotInvoiceLine> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					KolanotInvoiceLine kolanotInvoiceLine = list.get(0);

					result = kolanotInvoiceLine;

					cacheResult(kolanotInvoiceLine);
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
			return (KolanotInvoiceLine)result;
		}
	}

	/**
	 * Removes the kolanot invoice line where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the kolanot invoice line that was removed
	 */
	@Override
	public KolanotInvoiceLine removeByUUID_G(String uuid, long groupId)
		throws NoSuchKolanotInvoiceLineException {

		KolanotInvoiceLine kolanotInvoiceLine = findByUUID_G(uuid, groupId);

		return remove(kolanotInvoiceLine);
	}

	/**
	 * Returns the number of kolanot invoice lines where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching kolanot invoice lines
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_KOLANOTINVOICELINE_WHERE);

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
		"kolanotInvoiceLine.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(kolanotInvoiceLine.uuid IS NULL OR kolanotInvoiceLine.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"kolanotInvoiceLine.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the kolanot invoice lines where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching kolanot invoice lines
	 */
	@Override
	public List<KolanotInvoiceLine> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<KolanotInvoiceLine> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<KolanotInvoiceLine> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<KolanotInvoiceLine> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator,
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

		List<KolanotInvoiceLine> list = null;

		if (useFinderCache) {
			list = (List<KolanotInvoiceLine>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KolanotInvoiceLine kolanotInvoiceLine : list) {
					if (!uuid.equals(kolanotInvoiceLine.getUuid()) ||
						(companyId != kolanotInvoiceLine.getCompanyId())) {

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

			sb.append(_SQL_SELECT_KOLANOTINVOICELINE_WHERE);

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
				sb.append(KolanotInvoiceLineModelImpl.ORDER_BY_JPQL);
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

				list = (List<KolanotInvoiceLine>)QueryUtil.list(
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
	 * Returns the first kolanot invoice line in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws NoSuchKolanotInvoiceLineException {

		KolanotInvoiceLine kolanotInvoiceLine = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (kolanotInvoiceLine != null) {
			return kolanotInvoiceLine;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchKolanotInvoiceLineException(sb.toString());
	}

	/**
	 * Returns the first kolanot invoice line in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		List<KolanotInvoiceLine> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public KolanotInvoiceLine findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws NoSuchKolanotInvoiceLineException {

		KolanotInvoiceLine kolanotInvoiceLine = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (kolanotInvoiceLine != null) {
			return kolanotInvoiceLine;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchKolanotInvoiceLineException(sb.toString());
	}

	/**
	 * Returns the last kolanot invoice line in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<KolanotInvoiceLine> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public KolanotInvoiceLine[] findByUuid_C_PrevAndNext(
			long invoiceLineId, String uuid, long companyId,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws NoSuchKolanotInvoiceLineException {

		uuid = Objects.toString(uuid, "");

		KolanotInvoiceLine kolanotInvoiceLine = findByPrimaryKey(invoiceLineId);

		Session session = null;

		try {
			session = openSession();

			KolanotInvoiceLine[] array = new KolanotInvoiceLineImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, kolanotInvoiceLine, uuid, companyId, orderByComparator,
				true);

			array[1] = kolanotInvoiceLine;

			array[2] = getByUuid_C_PrevAndNext(
				session, kolanotInvoiceLine, uuid, companyId, orderByComparator,
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

	protected KolanotInvoiceLine getByUuid_C_PrevAndNext(
		Session session, KolanotInvoiceLine kolanotInvoiceLine, String uuid,
		long companyId, OrderByComparator<KolanotInvoiceLine> orderByComparator,
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

		sb.append(_SQL_SELECT_KOLANOTINVOICELINE_WHERE);

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
			sb.append(KolanotInvoiceLineModelImpl.ORDER_BY_JPQL);
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
						kolanotInvoiceLine)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<KolanotInvoiceLine> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kolanot invoice lines where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (KolanotInvoiceLine kolanotInvoiceLine :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(kolanotInvoiceLine);
		}
	}

	/**
	 * Returns the number of kolanot invoice lines where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching kolanot invoice lines
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_KOLANOTINVOICELINE_WHERE);

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
		"kolanotInvoiceLine.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(kolanotInvoiceLine.uuid IS NULL OR kolanotInvoiceLine.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"kolanotInvoiceLine.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByInvoiceId;
	private FinderPath _finderPathWithoutPaginationFindByInvoiceId;
	private FinderPath _finderPathCountByInvoiceId;

	/**
	 * Returns all the kolanot invoice lines where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @return the matching kolanot invoice lines
	 */
	@Override
	public List<KolanotInvoiceLine> findByInvoiceId(long invoiceId) {
		return findByInvoiceId(
			invoiceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<KolanotInvoiceLine> findByInvoiceId(
		long invoiceId, int start, int end) {

		return findByInvoiceId(invoiceId, start, end, null);
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
	@Override
	public List<KolanotInvoiceLine> findByInvoiceId(
		long invoiceId, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return findByInvoiceId(invoiceId, start, end, orderByComparator, true);
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
	@Override
	public List<KolanotInvoiceLine> findByInvoiceId(
		long invoiceId, int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByInvoiceId;
				finderArgs = new Object[] {invoiceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByInvoiceId;
			finderArgs = new Object[] {
				invoiceId, start, end, orderByComparator
			};
		}

		List<KolanotInvoiceLine> list = null;

		if (useFinderCache) {
			list = (List<KolanotInvoiceLine>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KolanotInvoiceLine kolanotInvoiceLine : list) {
					if (invoiceId != kolanotInvoiceLine.getInvoiceId()) {
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

			sb.append(_SQL_SELECT_KOLANOTINVOICELINE_WHERE);

			sb.append(_FINDER_COLUMN_INVOICEID_INVOICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(KolanotInvoiceLineModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(invoiceId);

				list = (List<KolanotInvoiceLine>)QueryUtil.list(
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
	 * Returns the first kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine findByInvoiceId_First(
			long invoiceId,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws NoSuchKolanotInvoiceLineException {

		KolanotInvoiceLine kolanotInvoiceLine = fetchByInvoiceId_First(
			invoiceId, orderByComparator);

		if (kolanotInvoiceLine != null) {
			return kolanotInvoiceLine;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("invoiceId=");
		sb.append(invoiceId);

		sb.append("}");

		throw new NoSuchKolanotInvoiceLineException(sb.toString());
	}

	/**
	 * Returns the first kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine fetchByInvoiceId_First(
		long invoiceId,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		List<KolanotInvoiceLine> list = findByInvoiceId(
			invoiceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine findByInvoiceId_Last(
			long invoiceId,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws NoSuchKolanotInvoiceLineException {

		KolanotInvoiceLine kolanotInvoiceLine = fetchByInvoiceId_Last(
			invoiceId, orderByComparator);

		if (kolanotInvoiceLine != null) {
			return kolanotInvoiceLine;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("invoiceId=");
		sb.append(invoiceId);

		sb.append("}");

		throw new NoSuchKolanotInvoiceLineException(sb.toString());
	}

	/**
	 * Returns the last kolanot invoice line in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	@Override
	public KolanotInvoiceLine fetchByInvoiceId_Last(
		long invoiceId,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		int count = countByInvoiceId(invoiceId);

		if (count == 0) {
			return null;
		}

		List<KolanotInvoiceLine> list = findByInvoiceId(
			invoiceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public KolanotInvoiceLine[] findByInvoiceId_PrevAndNext(
			long invoiceLineId, long invoiceId,
			OrderByComparator<KolanotInvoiceLine> orderByComparator)
		throws NoSuchKolanotInvoiceLineException {

		KolanotInvoiceLine kolanotInvoiceLine = findByPrimaryKey(invoiceLineId);

		Session session = null;

		try {
			session = openSession();

			KolanotInvoiceLine[] array = new KolanotInvoiceLineImpl[3];

			array[0] = getByInvoiceId_PrevAndNext(
				session, kolanotInvoiceLine, invoiceId, orderByComparator,
				true);

			array[1] = kolanotInvoiceLine;

			array[2] = getByInvoiceId_PrevAndNext(
				session, kolanotInvoiceLine, invoiceId, orderByComparator,
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

	protected KolanotInvoiceLine getByInvoiceId_PrevAndNext(
		Session session, KolanotInvoiceLine kolanotInvoiceLine, long invoiceId,
		OrderByComparator<KolanotInvoiceLine> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_KOLANOTINVOICELINE_WHERE);

		sb.append(_FINDER_COLUMN_INVOICEID_INVOICEID_2);

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
			sb.append(KolanotInvoiceLineModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(invoiceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						kolanotInvoiceLine)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<KolanotInvoiceLine> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kolanot invoice lines where invoiceId = &#63; from the database.
	 *
	 * @param invoiceId the invoice ID
	 */
	@Override
	public void removeByInvoiceId(long invoiceId) {
		for (KolanotInvoiceLine kolanotInvoiceLine :
				findByInvoiceId(
					invoiceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(kolanotInvoiceLine);
		}
	}

	/**
	 * Returns the number of kolanot invoice lines where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @return the number of matching kolanot invoice lines
	 */
	@Override
	public int countByInvoiceId(long invoiceId) {
		FinderPath finderPath = _finderPathCountByInvoiceId;

		Object[] finderArgs = new Object[] {invoiceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_KOLANOTINVOICELINE_WHERE);

			sb.append(_FINDER_COLUMN_INVOICEID_INVOICEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(invoiceId);

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

	private static final String _FINDER_COLUMN_INVOICEID_INVOICEID_2 =
		"kolanotInvoiceLine.invoiceId = ?";

	public KolanotInvoiceLinePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(KolanotInvoiceLine.class);

		setModelImplClass(KolanotInvoiceLineImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the kolanot invoice line in the entity cache if it is enabled.
	 *
	 * @param kolanotInvoiceLine the kolanot invoice line
	 */
	@Override
	public void cacheResult(KolanotInvoiceLine kolanotInvoiceLine) {
		entityCache.putResult(
			KolanotInvoiceLineImpl.class, kolanotInvoiceLine.getPrimaryKey(),
			kolanotInvoiceLine);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				kolanotInvoiceLine.getUuid(), kolanotInvoiceLine.getGroupId()
			},
			kolanotInvoiceLine);

		kolanotInvoiceLine.resetOriginalValues();
	}

	/**
	 * Caches the kolanot invoice lines in the entity cache if it is enabled.
	 *
	 * @param kolanotInvoiceLines the kolanot invoice lines
	 */
	@Override
	public void cacheResult(List<KolanotInvoiceLine> kolanotInvoiceLines) {
		for (KolanotInvoiceLine kolanotInvoiceLine : kolanotInvoiceLines) {
			if (entityCache.getResult(
					KolanotInvoiceLineImpl.class,
					kolanotInvoiceLine.getPrimaryKey()) == null) {

				cacheResult(kolanotInvoiceLine);
			}
			else {
				kolanotInvoiceLine.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kolanot invoice lines.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(KolanotInvoiceLineImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kolanot invoice line.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KolanotInvoiceLine kolanotInvoiceLine) {
		entityCache.removeResult(
			KolanotInvoiceLineImpl.class, kolanotInvoiceLine.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(KolanotInvoiceLineModelImpl)kolanotInvoiceLine, true);
	}

	@Override
	public void clearCache(List<KolanotInvoiceLine> kolanotInvoiceLines) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KolanotInvoiceLine kolanotInvoiceLine : kolanotInvoiceLines) {
			entityCache.removeResult(
				KolanotInvoiceLineImpl.class,
				kolanotInvoiceLine.getPrimaryKey());

			clearUniqueFindersCache(
				(KolanotInvoiceLineModelImpl)kolanotInvoiceLine, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(KolanotInvoiceLineImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		KolanotInvoiceLineModelImpl kolanotInvoiceLineModelImpl) {

		Object[] args = new Object[] {
			kolanotInvoiceLineModelImpl.getUuid(),
			kolanotInvoiceLineModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, kolanotInvoiceLineModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		KolanotInvoiceLineModelImpl kolanotInvoiceLineModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				kolanotInvoiceLineModelImpl.getUuid(),
				kolanotInvoiceLineModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((kolanotInvoiceLineModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				kolanotInvoiceLineModelImpl.getOriginalUuid(),
				kolanotInvoiceLineModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new kolanot invoice line with the primary key. Does not add the kolanot invoice line to the database.
	 *
	 * @param invoiceLineId the primary key for the new kolanot invoice line
	 * @return the new kolanot invoice line
	 */
	@Override
	public KolanotInvoiceLine create(long invoiceLineId) {
		KolanotInvoiceLine kolanotInvoiceLine = new KolanotInvoiceLineImpl();

		kolanotInvoiceLine.setNew(true);
		kolanotInvoiceLine.setPrimaryKey(invoiceLineId);

		String uuid = PortalUUIDUtil.generate();

		kolanotInvoiceLine.setUuid(uuid);

		kolanotInvoiceLine.setCompanyId(CompanyThreadLocal.getCompanyId());

		return kolanotInvoiceLine;
	}

	/**
	 * Removes the kolanot invoice line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoiceLineId the primary key of the kolanot invoice line
	 * @return the kolanot invoice line that was removed
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	@Override
	public KolanotInvoiceLine remove(long invoiceLineId)
		throws NoSuchKolanotInvoiceLineException {

		return remove((Serializable)invoiceLineId);
	}

	/**
	 * Removes the kolanot invoice line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kolanot invoice line
	 * @return the kolanot invoice line that was removed
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	@Override
	public KolanotInvoiceLine remove(Serializable primaryKey)
		throws NoSuchKolanotInvoiceLineException {

		Session session = null;

		try {
			session = openSession();

			KolanotInvoiceLine kolanotInvoiceLine =
				(KolanotInvoiceLine)session.get(
					KolanotInvoiceLineImpl.class, primaryKey);

			if (kolanotInvoiceLine == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKolanotInvoiceLineException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(kolanotInvoiceLine);
		}
		catch (NoSuchKolanotInvoiceLineException noSuchEntityException) {
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
	protected KolanotInvoiceLine removeImpl(
		KolanotInvoiceLine kolanotInvoiceLine) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kolanotInvoiceLine)) {
				kolanotInvoiceLine = (KolanotInvoiceLine)session.get(
					KolanotInvoiceLineImpl.class,
					kolanotInvoiceLine.getPrimaryKeyObj());
			}

			if (kolanotInvoiceLine != null) {
				session.delete(kolanotInvoiceLine);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (kolanotInvoiceLine != null) {
			clearCache(kolanotInvoiceLine);
		}

		return kolanotInvoiceLine;
	}

	@Override
	public KolanotInvoiceLine updateImpl(
		KolanotInvoiceLine kolanotInvoiceLine) {

		boolean isNew = kolanotInvoiceLine.isNew();

		if (!(kolanotInvoiceLine instanceof KolanotInvoiceLineModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(kolanotInvoiceLine.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					kolanotInvoiceLine);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in kolanotInvoiceLine proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom KolanotInvoiceLine implementation " +
					kolanotInvoiceLine.getClass());
		}

		KolanotInvoiceLineModelImpl kolanotInvoiceLineModelImpl =
			(KolanotInvoiceLineModelImpl)kolanotInvoiceLine;

		if (Validator.isNull(kolanotInvoiceLine.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			kolanotInvoiceLine.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (kolanotInvoiceLine.isNew()) {
				session.save(kolanotInvoiceLine);

				kolanotInvoiceLine.setNew(false);
			}
			else {
				kolanotInvoiceLine = (KolanotInvoiceLine)session.merge(
					kolanotInvoiceLine);
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
			Object[] args = new Object[] {
				kolanotInvoiceLineModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				kolanotInvoiceLineModelImpl.getUuid(),
				kolanotInvoiceLineModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {kolanotInvoiceLineModelImpl.getInvoiceId()};

			finderCache.removeResult(_finderPathCountByInvoiceId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByInvoiceId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((kolanotInvoiceLineModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					kolanotInvoiceLineModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {kolanotInvoiceLineModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((kolanotInvoiceLineModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					kolanotInvoiceLineModelImpl.getOriginalUuid(),
					kolanotInvoiceLineModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					kolanotInvoiceLineModelImpl.getUuid(),
					kolanotInvoiceLineModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((kolanotInvoiceLineModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByInvoiceId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					kolanotInvoiceLineModelImpl.getOriginalInvoiceId()
				};

				finderCache.removeResult(_finderPathCountByInvoiceId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByInvoiceId, args);

				args = new Object[] {
					kolanotInvoiceLineModelImpl.getInvoiceId()
				};

				finderCache.removeResult(_finderPathCountByInvoiceId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByInvoiceId, args);
			}
		}

		entityCache.putResult(
			KolanotInvoiceLineImpl.class, kolanotInvoiceLine.getPrimaryKey(),
			kolanotInvoiceLine, false);

		clearUniqueFindersCache(kolanotInvoiceLineModelImpl, false);
		cacheUniqueFindersCache(kolanotInvoiceLineModelImpl);

		kolanotInvoiceLine.resetOriginalValues();

		return kolanotInvoiceLine;
	}

	/**
	 * Returns the kolanot invoice line with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kolanot invoice line
	 * @return the kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	@Override
	public KolanotInvoiceLine findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKolanotInvoiceLineException {

		KolanotInvoiceLine kolanotInvoiceLine = fetchByPrimaryKey(primaryKey);

		if (kolanotInvoiceLine == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKolanotInvoiceLineException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return kolanotInvoiceLine;
	}

	/**
	 * Returns the kolanot invoice line with the primary key or throws a <code>NoSuchKolanotInvoiceLineException</code> if it could not be found.
	 *
	 * @param invoiceLineId the primary key of the kolanot invoice line
	 * @return the kolanot invoice line
	 * @throws NoSuchKolanotInvoiceLineException if a kolanot invoice line with the primary key could not be found
	 */
	@Override
	public KolanotInvoiceLine findByPrimaryKey(long invoiceLineId)
		throws NoSuchKolanotInvoiceLineException {

		return findByPrimaryKey((Serializable)invoiceLineId);
	}

	/**
	 * Returns the kolanot invoice line with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoiceLineId the primary key of the kolanot invoice line
	 * @return the kolanot invoice line, or <code>null</code> if a kolanot invoice line with the primary key could not be found
	 */
	@Override
	public KolanotInvoiceLine fetchByPrimaryKey(long invoiceLineId) {
		return fetchByPrimaryKey((Serializable)invoiceLineId);
	}

	/**
	 * Returns all the kolanot invoice lines.
	 *
	 * @return the kolanot invoice lines
	 */
	@Override
	public List<KolanotInvoiceLine> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<KolanotInvoiceLine> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<KolanotInvoiceLine> findAll(
		int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<KolanotInvoiceLine> findAll(
		int start, int end,
		OrderByComparator<KolanotInvoiceLine> orderByComparator,
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

		List<KolanotInvoiceLine> list = null;

		if (useFinderCache) {
			list = (List<KolanotInvoiceLine>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_KOLANOTINVOICELINE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_KOLANOTINVOICELINE;

				sql = sql.concat(KolanotInvoiceLineModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<KolanotInvoiceLine>)QueryUtil.list(
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
	 * Removes all the kolanot invoice lines from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (KolanotInvoiceLine kolanotInvoiceLine : findAll()) {
			remove(kolanotInvoiceLine);
		}
	}

	/**
	 * Returns the number of kolanot invoice lines.
	 *
	 * @return the number of kolanot invoice lines
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_KOLANOTINVOICELINE);

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
		return "invoiceLineId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_KOLANOTINVOICELINE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return KolanotInvoiceLineModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the kolanot invoice line persistence.
	 */
	@Activate
	public void activate() {
		_finderPathWithPaginationFindAll = new FinderPath(
			KolanotInvoiceLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			KolanotInvoiceLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			KolanotInvoiceLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			KolanotInvoiceLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			KolanotInvoiceLineModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			KolanotInvoiceLineImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			KolanotInvoiceLineModelImpl.UUID_COLUMN_BITMASK |
			KolanotInvoiceLineModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			KolanotInvoiceLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			KolanotInvoiceLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			KolanotInvoiceLineModelImpl.UUID_COLUMN_BITMASK |
			KolanotInvoiceLineModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByInvoiceId = new FinderPath(
			KolanotInvoiceLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInvoiceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByInvoiceId = new FinderPath(
			KolanotInvoiceLineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInvoiceId",
			new String[] {Long.class.getName()},
			KolanotInvoiceLineModelImpl.INVOICEID_COLUMN_BITMASK);

		_finderPathCountByInvoiceId = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByInvoiceId", new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(KolanotInvoiceLineImpl.class.getName());
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

	private static final String _SQL_SELECT_KOLANOTINVOICELINE =
		"SELECT kolanotInvoiceLine FROM KolanotInvoiceLine kolanotInvoiceLine";

	private static final String _SQL_SELECT_KOLANOTINVOICELINE_WHERE =
		"SELECT kolanotInvoiceLine FROM KolanotInvoiceLine kolanotInvoiceLine WHERE ";

	private static final String _SQL_COUNT_KOLANOTINVOICELINE =
		"SELECT COUNT(kolanotInvoiceLine) FROM KolanotInvoiceLine kolanotInvoiceLine";

	private static final String _SQL_COUNT_KOLANOTINVOICELINE_WHERE =
		"SELECT COUNT(kolanotInvoiceLine) FROM KolanotInvoiceLine kolanotInvoiceLine WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "kolanotInvoiceLine.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No KolanotInvoiceLine exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No KolanotInvoiceLine exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		KolanotInvoiceLinePersistenceImpl.class);

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