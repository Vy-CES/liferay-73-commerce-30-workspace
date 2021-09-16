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

import com.kolanot.service.exception.NoSuchInvoicePaymentException;
import com.kolanot.service.model.InvoicePayment;
import com.kolanot.service.model.impl.InvoicePaymentImpl;
import com.kolanot.service.model.impl.InvoicePaymentModelImpl;
import com.kolanot.service.service.persistence.InvoicePaymentPersistence;
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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the invoice payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = InvoicePaymentPersistence.class)
public class InvoicePaymentPersistenceImpl
	extends BasePersistenceImpl<InvoicePayment>
	implements InvoicePaymentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>InvoicePaymentUtil</code> to access the invoice payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		InvoicePaymentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByInvoiceId;
	private FinderPath _finderPathWithoutPaginationFindByInvoiceId;
	private FinderPath _finderPathCountByInvoiceId;

	/**
	 * Returns all the invoice payments where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @return the matching invoice payments
	 */
	@Override
	public List<InvoicePayment> findByInvoiceId(long invoiceId) {
		return findByInvoiceId(
			invoiceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<InvoicePayment> findByInvoiceId(
		long invoiceId, int start, int end) {

		return findByInvoiceId(invoiceId, start, end, null);
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
	@Override
	public List<InvoicePayment> findByInvoiceId(
		long invoiceId, int start, int end,
		OrderByComparator<InvoicePayment> orderByComparator) {

		return findByInvoiceId(invoiceId, start, end, orderByComparator, true);
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
	@Override
	public List<InvoicePayment> findByInvoiceId(
		long invoiceId, int start, int end,
		OrderByComparator<InvoicePayment> orderByComparator,
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

		List<InvoicePayment> list = null;

		if (useFinderCache) {
			list = (List<InvoicePayment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InvoicePayment invoicePayment : list) {
					if (invoiceId != invoicePayment.getInvoiceId()) {
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

			sb.append(_SQL_SELECT_INVOICEPAYMENT_WHERE);

			sb.append(_FINDER_COLUMN_INVOICEID_INVOICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InvoicePaymentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(invoiceId);

				list = (List<InvoicePayment>)QueryUtil.list(
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
	 * Returns the first invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoice payment
	 * @throws NoSuchInvoicePaymentException if a matching invoice payment could not be found
	 */
	@Override
	public InvoicePayment findByInvoiceId_First(
			long invoiceId, OrderByComparator<InvoicePayment> orderByComparator)
		throws NoSuchInvoicePaymentException {

		InvoicePayment invoicePayment = fetchByInvoiceId_First(
			invoiceId, orderByComparator);

		if (invoicePayment != null) {
			return invoicePayment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("invoiceId=");
		sb.append(invoiceId);

		sb.append("}");

		throw new NoSuchInvoicePaymentException(sb.toString());
	}

	/**
	 * Returns the first invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoice payment, or <code>null</code> if a matching invoice payment could not be found
	 */
	@Override
	public InvoicePayment fetchByInvoiceId_First(
		long invoiceId, OrderByComparator<InvoicePayment> orderByComparator) {

		List<InvoicePayment> list = findByInvoiceId(
			invoiceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoice payment
	 * @throws NoSuchInvoicePaymentException if a matching invoice payment could not be found
	 */
	@Override
	public InvoicePayment findByInvoiceId_Last(
			long invoiceId, OrderByComparator<InvoicePayment> orderByComparator)
		throws NoSuchInvoicePaymentException {

		InvoicePayment invoicePayment = fetchByInvoiceId_Last(
			invoiceId, orderByComparator);

		if (invoicePayment != null) {
			return invoicePayment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("invoiceId=");
		sb.append(invoiceId);

		sb.append("}");

		throw new NoSuchInvoicePaymentException(sb.toString());
	}

	/**
	 * Returns the last invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoice payment, or <code>null</code> if a matching invoice payment could not be found
	 */
	@Override
	public InvoicePayment fetchByInvoiceId_Last(
		long invoiceId, OrderByComparator<InvoicePayment> orderByComparator) {

		int count = countByInvoiceId(invoiceId);

		if (count == 0) {
			return null;
		}

		List<InvoicePayment> list = findByInvoiceId(
			invoiceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public InvoicePayment[] findByInvoiceId_PrevAndNext(
			long invoicePaymentId, long invoiceId,
			OrderByComparator<InvoicePayment> orderByComparator)
		throws NoSuchInvoicePaymentException {

		InvoicePayment invoicePayment = findByPrimaryKey(invoicePaymentId);

		Session session = null;

		try {
			session = openSession();

			InvoicePayment[] array = new InvoicePaymentImpl[3];

			array[0] = getByInvoiceId_PrevAndNext(
				session, invoicePayment, invoiceId, orderByComparator, true);

			array[1] = invoicePayment;

			array[2] = getByInvoiceId_PrevAndNext(
				session, invoicePayment, invoiceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected InvoicePayment getByInvoiceId_PrevAndNext(
		Session session, InvoicePayment invoicePayment, long invoiceId,
		OrderByComparator<InvoicePayment> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INVOICEPAYMENT_WHERE);

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
			sb.append(InvoicePaymentModelImpl.ORDER_BY_JPQL);
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
						invoicePayment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<InvoicePayment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invoice payments where invoiceId = &#63; from the database.
	 *
	 * @param invoiceId the invoice ID
	 */
	@Override
	public void removeByInvoiceId(long invoiceId) {
		for (InvoicePayment invoicePayment :
				findByInvoiceId(
					invoiceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(invoicePayment);
		}
	}

	/**
	 * Returns the number of invoice payments where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @return the number of matching invoice payments
	 */
	@Override
	public int countByInvoiceId(long invoiceId) {
		FinderPath finderPath = _finderPathCountByInvoiceId;

		Object[] finderArgs = new Object[] {invoiceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INVOICEPAYMENT_WHERE);

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
		"invoicePayment.invoiceId = ?";

	public InvoicePaymentPersistenceImpl() {
		setModelClass(InvoicePayment.class);

		setModelImplClass(InvoicePaymentImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the invoice payment in the entity cache if it is enabled.
	 *
	 * @param invoicePayment the invoice payment
	 */
	@Override
	public void cacheResult(InvoicePayment invoicePayment) {
		entityCache.putResult(
			InvoicePaymentImpl.class, invoicePayment.getPrimaryKey(),
			invoicePayment);

		invoicePayment.resetOriginalValues();
	}

	/**
	 * Caches the invoice payments in the entity cache if it is enabled.
	 *
	 * @param invoicePayments the invoice payments
	 */
	@Override
	public void cacheResult(List<InvoicePayment> invoicePayments) {
		for (InvoicePayment invoicePayment : invoicePayments) {
			if (entityCache.getResult(
					InvoicePaymentImpl.class, invoicePayment.getPrimaryKey()) ==
						null) {

				cacheResult(invoicePayment);
			}
			else {
				invoicePayment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all invoice payments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InvoicePaymentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the invoice payment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InvoicePayment invoicePayment) {
		entityCache.removeResult(
			InvoicePaymentImpl.class, invoicePayment.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<InvoicePayment> invoicePayments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InvoicePayment invoicePayment : invoicePayments) {
			entityCache.removeResult(
				InvoicePaymentImpl.class, invoicePayment.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(InvoicePaymentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new invoice payment with the primary key. Does not add the invoice payment to the database.
	 *
	 * @param invoicePaymentId the primary key for the new invoice payment
	 * @return the new invoice payment
	 */
	@Override
	public InvoicePayment create(long invoicePaymentId) {
		InvoicePayment invoicePayment = new InvoicePaymentImpl();

		invoicePayment.setNew(true);
		invoicePayment.setPrimaryKey(invoicePaymentId);

		return invoicePayment;
	}

	/**
	 * Removes the invoice payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoicePaymentId the primary key of the invoice payment
	 * @return the invoice payment that was removed
	 * @throws NoSuchInvoicePaymentException if a invoice payment with the primary key could not be found
	 */
	@Override
	public InvoicePayment remove(long invoicePaymentId)
		throws NoSuchInvoicePaymentException {

		return remove((Serializable)invoicePaymentId);
	}

	/**
	 * Removes the invoice payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the invoice payment
	 * @return the invoice payment that was removed
	 * @throws NoSuchInvoicePaymentException if a invoice payment with the primary key could not be found
	 */
	@Override
	public InvoicePayment remove(Serializable primaryKey)
		throws NoSuchInvoicePaymentException {

		Session session = null;

		try {
			session = openSession();

			InvoicePayment invoicePayment = (InvoicePayment)session.get(
				InvoicePaymentImpl.class, primaryKey);

			if (invoicePayment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInvoicePaymentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(invoicePayment);
		}
		catch (NoSuchInvoicePaymentException noSuchEntityException) {
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
	protected InvoicePayment removeImpl(InvoicePayment invoicePayment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(invoicePayment)) {
				invoicePayment = (InvoicePayment)session.get(
					InvoicePaymentImpl.class,
					invoicePayment.getPrimaryKeyObj());
			}

			if (invoicePayment != null) {
				session.delete(invoicePayment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (invoicePayment != null) {
			clearCache(invoicePayment);
		}

		return invoicePayment;
	}

	@Override
	public InvoicePayment updateImpl(InvoicePayment invoicePayment) {
		boolean isNew = invoicePayment.isNew();

		if (!(invoicePayment instanceof InvoicePaymentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(invoicePayment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					invoicePayment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in invoicePayment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom InvoicePayment implementation " +
					invoicePayment.getClass());
		}

		InvoicePaymentModelImpl invoicePaymentModelImpl =
			(InvoicePaymentModelImpl)invoicePayment;

		Session session = null;

		try {
			session = openSession();

			if (invoicePayment.isNew()) {
				session.save(invoicePayment);

				invoicePayment.setNew(false);
			}
			else {
				invoicePayment = (InvoicePayment)session.merge(invoicePayment);
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
				invoicePaymentModelImpl.getInvoiceId()
			};

			finderCache.removeResult(_finderPathCountByInvoiceId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByInvoiceId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((invoicePaymentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByInvoiceId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					invoicePaymentModelImpl.getOriginalInvoiceId()
				};

				finderCache.removeResult(_finderPathCountByInvoiceId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByInvoiceId, args);

				args = new Object[] {invoicePaymentModelImpl.getInvoiceId()};

				finderCache.removeResult(_finderPathCountByInvoiceId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByInvoiceId, args);
			}
		}

		entityCache.putResult(
			InvoicePaymentImpl.class, invoicePayment.getPrimaryKey(),
			invoicePayment, false);

		invoicePayment.resetOriginalValues();

		return invoicePayment;
	}

	/**
	 * Returns the invoice payment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the invoice payment
	 * @return the invoice payment
	 * @throws NoSuchInvoicePaymentException if a invoice payment with the primary key could not be found
	 */
	@Override
	public InvoicePayment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInvoicePaymentException {

		InvoicePayment invoicePayment = fetchByPrimaryKey(primaryKey);

		if (invoicePayment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInvoicePaymentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return invoicePayment;
	}

	/**
	 * Returns the invoice payment with the primary key or throws a <code>NoSuchInvoicePaymentException</code> if it could not be found.
	 *
	 * @param invoicePaymentId the primary key of the invoice payment
	 * @return the invoice payment
	 * @throws NoSuchInvoicePaymentException if a invoice payment with the primary key could not be found
	 */
	@Override
	public InvoicePayment findByPrimaryKey(long invoicePaymentId)
		throws NoSuchInvoicePaymentException {

		return findByPrimaryKey((Serializable)invoicePaymentId);
	}

	/**
	 * Returns the invoice payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoicePaymentId the primary key of the invoice payment
	 * @return the invoice payment, or <code>null</code> if a invoice payment with the primary key could not be found
	 */
	@Override
	public InvoicePayment fetchByPrimaryKey(long invoicePaymentId) {
		return fetchByPrimaryKey((Serializable)invoicePaymentId);
	}

	/**
	 * Returns all the invoice payments.
	 *
	 * @return the invoice payments
	 */
	@Override
	public List<InvoicePayment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<InvoicePayment> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<InvoicePayment> findAll(
		int start, int end,
		OrderByComparator<InvoicePayment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<InvoicePayment> findAll(
		int start, int end, OrderByComparator<InvoicePayment> orderByComparator,
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

		List<InvoicePayment> list = null;

		if (useFinderCache) {
			list = (List<InvoicePayment>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INVOICEPAYMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INVOICEPAYMENT;

				sql = sql.concat(InvoicePaymentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<InvoicePayment>)QueryUtil.list(
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
	 * Removes all the invoice payments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (InvoicePayment invoicePayment : findAll()) {
			remove(invoicePayment);
		}
	}

	/**
	 * Returns the number of invoice payments.
	 *
	 * @return the number of invoice payments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INVOICEPAYMENT);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "invoicePaymentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INVOICEPAYMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return InvoicePaymentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the invoice payment persistence.
	 */
	@Activate
	public void activate() {
		_finderPathWithPaginationFindAll = new FinderPath(
			InvoicePaymentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			InvoicePaymentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByInvoiceId = new FinderPath(
			InvoicePaymentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByInvoiceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByInvoiceId = new FinderPath(
			InvoicePaymentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByInvoiceId", new String[] {Long.class.getName()},
			InvoicePaymentModelImpl.INVOICEID_COLUMN_BITMASK);

		_finderPathCountByInvoiceId = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByInvoiceId", new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(InvoicePaymentImpl.class.getName());
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

	private static final String _SQL_SELECT_INVOICEPAYMENT =
		"SELECT invoicePayment FROM InvoicePayment invoicePayment";

	private static final String _SQL_SELECT_INVOICEPAYMENT_WHERE =
		"SELECT invoicePayment FROM InvoicePayment invoicePayment WHERE ";

	private static final String _SQL_COUNT_INVOICEPAYMENT =
		"SELECT COUNT(invoicePayment) FROM InvoicePayment invoicePayment";

	private static final String _SQL_COUNT_INVOICEPAYMENT_WHERE =
		"SELECT COUNT(invoicePayment) FROM InvoicePayment invoicePayment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "invoicePayment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No InvoicePayment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No InvoicePayment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		InvoicePaymentPersistenceImpl.class);

	static {
		try {
			Class.forName(kolanotPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}