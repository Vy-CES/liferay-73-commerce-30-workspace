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

import com.kolanot.service.exception.NoSuchInvoicePaymentException;
import com.kolanot.service.model.InvoicePayment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the invoice payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoicePaymentUtil
 * @generated
 */
@ProviderType
public interface InvoicePaymentPersistence
	extends BasePersistence<InvoicePayment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InvoicePaymentUtil} to access the invoice payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the invoice payments where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @return the matching invoice payments
	 */
	public java.util.List<InvoicePayment> findByInvoiceId(long invoiceId);

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
	public java.util.List<InvoicePayment> findByInvoiceId(
		long invoiceId, int start, int end);

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
	public java.util.List<InvoicePayment> findByInvoiceId(
		long invoiceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvoicePayment>
			orderByComparator);

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
	public java.util.List<InvoicePayment> findByInvoiceId(
		long invoiceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvoicePayment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoice payment
	 * @throws NoSuchInvoicePaymentException if a matching invoice payment could not be found
	 */
	public InvoicePayment findByInvoiceId_First(
			long invoiceId,
			com.liferay.portal.kernel.util.OrderByComparator<InvoicePayment>
				orderByComparator)
		throws NoSuchInvoicePaymentException;

	/**
	 * Returns the first invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoice payment, or <code>null</code> if a matching invoice payment could not be found
	 */
	public InvoicePayment fetchByInvoiceId_First(
		long invoiceId,
		com.liferay.portal.kernel.util.OrderByComparator<InvoicePayment>
			orderByComparator);

	/**
	 * Returns the last invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoice payment
	 * @throws NoSuchInvoicePaymentException if a matching invoice payment could not be found
	 */
	public InvoicePayment findByInvoiceId_Last(
			long invoiceId,
			com.liferay.portal.kernel.util.OrderByComparator<InvoicePayment>
				orderByComparator)
		throws NoSuchInvoicePaymentException;

	/**
	 * Returns the last invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoice payment, or <code>null</code> if a matching invoice payment could not be found
	 */
	public InvoicePayment fetchByInvoiceId_Last(
		long invoiceId,
		com.liferay.portal.kernel.util.OrderByComparator<InvoicePayment>
			orderByComparator);

	/**
	 * Returns the invoice payments before and after the current invoice payment in the ordered set where invoiceId = &#63;.
	 *
	 * @param invoicePaymentId the primary key of the current invoice payment
	 * @param invoiceId the invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invoice payment
	 * @throws NoSuchInvoicePaymentException if a invoice payment with the primary key could not be found
	 */
	public InvoicePayment[] findByInvoiceId_PrevAndNext(
			long invoicePaymentId, long invoiceId,
			com.liferay.portal.kernel.util.OrderByComparator<InvoicePayment>
				orderByComparator)
		throws NoSuchInvoicePaymentException;

	/**
	 * Removes all the invoice payments where invoiceId = &#63; from the database.
	 *
	 * @param invoiceId the invoice ID
	 */
	public void removeByInvoiceId(long invoiceId);

	/**
	 * Returns the number of invoice payments where invoiceId = &#63;.
	 *
	 * @param invoiceId the invoice ID
	 * @return the number of matching invoice payments
	 */
	public int countByInvoiceId(long invoiceId);

	/**
	 * Caches the invoice payment in the entity cache if it is enabled.
	 *
	 * @param invoicePayment the invoice payment
	 */
	public void cacheResult(InvoicePayment invoicePayment);

	/**
	 * Caches the invoice payments in the entity cache if it is enabled.
	 *
	 * @param invoicePayments the invoice payments
	 */
	public void cacheResult(java.util.List<InvoicePayment> invoicePayments);

	/**
	 * Creates a new invoice payment with the primary key. Does not add the invoice payment to the database.
	 *
	 * @param invoicePaymentId the primary key for the new invoice payment
	 * @return the new invoice payment
	 */
	public InvoicePayment create(long invoicePaymentId);

	/**
	 * Removes the invoice payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoicePaymentId the primary key of the invoice payment
	 * @return the invoice payment that was removed
	 * @throws NoSuchInvoicePaymentException if a invoice payment with the primary key could not be found
	 */
	public InvoicePayment remove(long invoicePaymentId)
		throws NoSuchInvoicePaymentException;

	public InvoicePayment updateImpl(InvoicePayment invoicePayment);

	/**
	 * Returns the invoice payment with the primary key or throws a <code>NoSuchInvoicePaymentException</code> if it could not be found.
	 *
	 * @param invoicePaymentId the primary key of the invoice payment
	 * @return the invoice payment
	 * @throws NoSuchInvoicePaymentException if a invoice payment with the primary key could not be found
	 */
	public InvoicePayment findByPrimaryKey(long invoicePaymentId)
		throws NoSuchInvoicePaymentException;

	/**
	 * Returns the invoice payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoicePaymentId the primary key of the invoice payment
	 * @return the invoice payment, or <code>null</code> if a invoice payment with the primary key could not be found
	 */
	public InvoicePayment fetchByPrimaryKey(long invoicePaymentId);

	/**
	 * Returns all the invoice payments.
	 *
	 * @return the invoice payments
	 */
	public java.util.List<InvoicePayment> findAll();

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
	public java.util.List<InvoicePayment> findAll(int start, int end);

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
	public java.util.List<InvoicePayment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvoicePayment>
			orderByComparator);

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
	public java.util.List<InvoicePayment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InvoicePayment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the invoice payments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of invoice payments.
	 *
	 * @return the number of invoice payments
	 */
	public int countAll();

}