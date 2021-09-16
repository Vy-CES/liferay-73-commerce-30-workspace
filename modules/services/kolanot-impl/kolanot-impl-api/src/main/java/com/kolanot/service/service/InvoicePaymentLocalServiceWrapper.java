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

package com.kolanot.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InvoicePaymentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvoicePaymentLocalService
 * @generated
 */
public class InvoicePaymentLocalServiceWrapper
	implements InvoicePaymentLocalService,
			   ServiceWrapper<InvoicePaymentLocalService> {

	public InvoicePaymentLocalServiceWrapper(
		InvoicePaymentLocalService invoicePaymentLocalService) {

		_invoicePaymentLocalService = invoicePaymentLocalService;
	}

	/**
	 * Adds the invoice payment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InvoicePaymentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invoicePayment the invoice payment
	 * @return the invoice payment that was added
	 */
	@Override
	public com.kolanot.service.model.InvoicePayment addInvoicePayment(
		com.kolanot.service.model.InvoicePayment invoicePayment) {

		return _invoicePaymentLocalService.addInvoicePayment(invoicePayment);
	}

	/**
	 * Creates a new invoice payment with the primary key. Does not add the invoice payment to the database.
	 *
	 * @param invoicePaymentId the primary key for the new invoice payment
	 * @return the new invoice payment
	 */
	@Override
	public com.kolanot.service.model.InvoicePayment createInvoicePayment(
		long invoicePaymentId) {

		return _invoicePaymentLocalService.createInvoicePayment(
			invoicePaymentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invoicePaymentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the invoice payment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InvoicePaymentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invoicePayment the invoice payment
	 * @return the invoice payment that was removed
	 */
	@Override
	public com.kolanot.service.model.InvoicePayment deleteInvoicePayment(
		com.kolanot.service.model.InvoicePayment invoicePayment) {

		return _invoicePaymentLocalService.deleteInvoicePayment(invoicePayment);
	}

	/**
	 * Deletes the invoice payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InvoicePaymentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invoicePaymentId the primary key of the invoice payment
	 * @return the invoice payment that was removed
	 * @throws PortalException if a invoice payment with the primary key could not be found
	 */
	@Override
	public com.kolanot.service.model.InvoicePayment deleteInvoicePayment(
			long invoicePaymentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invoicePaymentLocalService.deleteInvoicePayment(
			invoicePaymentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invoicePaymentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _invoicePaymentLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _invoicePaymentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.kolanot.service.model.impl.InvoicePaymentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _invoicePaymentLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.kolanot.service.model.impl.InvoicePaymentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _invoicePaymentLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _invoicePaymentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _invoicePaymentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.kolanot.service.model.InvoicePayment fetchInvoicePayment(
		long invoicePaymentId) {

		return _invoicePaymentLocalService.fetchInvoicePayment(
			invoicePaymentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _invoicePaymentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _invoicePaymentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the invoice payment with the primary key.
	 *
	 * @param invoicePaymentId the primary key of the invoice payment
	 * @return the invoice payment
	 * @throws PortalException if a invoice payment with the primary key could not be found
	 */
	@Override
	public com.kolanot.service.model.InvoicePayment getInvoicePayment(
			long invoicePaymentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invoicePaymentLocalService.getInvoicePayment(invoicePaymentId);
	}

	/**
	 * Returns a range of all the invoice payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.kolanot.service.model.impl.InvoicePaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invoice payments
	 * @param end the upper bound of the range of invoice payments (not inclusive)
	 * @return the range of invoice payments
	 */
	@Override
	public java.util.List<com.kolanot.service.model.InvoicePayment>
		getInvoicePayments(int start, int end) {

		return _invoicePaymentLocalService.getInvoicePayments(start, end);
	}

	/**
	 * Returns the number of invoice payments.
	 *
	 * @return the number of invoice payments
	 */
	@Override
	public int getInvoicePaymentsCount() {
		return _invoicePaymentLocalService.getInvoicePaymentsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _invoicePaymentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invoicePaymentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the invoice payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InvoicePaymentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invoicePayment the invoice payment
	 * @return the invoice payment that was updated
	 */
	@Override
	public com.kolanot.service.model.InvoicePayment updateInvoicePayment(
		com.kolanot.service.model.InvoicePayment invoicePayment) {

		return _invoicePaymentLocalService.updateInvoicePayment(invoicePayment);
	}

	@Override
	public InvoicePaymentLocalService getWrappedService() {
		return _invoicePaymentLocalService;
	}

	@Override
	public void setWrappedService(
		InvoicePaymentLocalService invoicePaymentLocalService) {

		_invoicePaymentLocalService = invoicePaymentLocalService;
	}

	private InvoicePaymentLocalService _invoicePaymentLocalService;

}