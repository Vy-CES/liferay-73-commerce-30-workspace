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
 * Provides a wrapper for {@link KolanotInvoiceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoiceLocalService
 * @generated
 */
public class KolanotInvoiceLocalServiceWrapper
	implements KolanotInvoiceLocalService,
			   ServiceWrapper<KolanotInvoiceLocalService> {

	public KolanotInvoiceLocalServiceWrapper(
		KolanotInvoiceLocalService kolanotInvoiceLocalService) {

		_kolanotInvoiceLocalService = kolanotInvoiceLocalService;
	}

	/**
	 * Adds the kolanot invoice to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect KolanotInvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param kolanotInvoice the kolanot invoice
	 * @return the kolanot invoice that was added
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoice addKolanotInvoice(
		com.kolanot.service.model.KolanotInvoice kolanotInvoice) {

		return _kolanotInvoiceLocalService.addKolanotInvoice(kolanotInvoice);
	}

	@Override
	public com.kolanot.service.model.KolanotInvoice addKolanotInvoice(
			String externalReferenceCode, String referenceNo, String cardCode,
			String cardName, String documentNumber, String documentStatus,
			java.util.Date documentDate, java.util.Date dueDate, String carrier,
			String trackingNumber, java.math.BigDecimal subTotal,
			java.math.BigDecimal freightAmount, java.math.BigDecimal gst,
			java.math.BigDecimal invoiceTotal, java.math.BigDecimal balanceDue,
			java.math.BigDecimal paidSum, long billingAddressId,
			long shippingAddressId,
			java.util.List<com.kolanot.service.model.KolanotInvoiceLine>
				KolanotInvoiceLines,
			String trackingURL,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLocalService.addKolanotInvoice(
			externalReferenceCode, referenceNo, cardCode, cardName,
			documentNumber, documentStatus, documentDate, dueDate, carrier,
			trackingNumber, subTotal, freightAmount, gst, invoiceTotal,
			balanceDue, paidSum, billingAddressId, shippingAddressId,
			KolanotInvoiceLines, trackingURL, serviceContext);
	}

	/**
	 * Creates a new kolanot invoice with the primary key. Does not add the kolanot invoice to the database.
	 *
	 * @param invoiceId the primary key for the new kolanot invoice
	 * @return the new kolanot invoice
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoice createKolanotInvoice(
		long invoiceId) {

		return _kolanotInvoiceLocalService.createKolanotInvoice(invoiceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the kolanot invoice from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect KolanotInvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param kolanotInvoice the kolanot invoice
	 * @return the kolanot invoice that was removed
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoice deleteKolanotInvoice(
		com.kolanot.service.model.KolanotInvoice kolanotInvoice) {

		return _kolanotInvoiceLocalService.deleteKolanotInvoice(kolanotInvoice);
	}

	/**
	 * Deletes the kolanot invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect KolanotInvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invoiceId the primary key of the kolanot invoice
	 * @return the kolanot invoice that was removed
	 * @throws PortalException if a kolanot invoice with the primary key could not be found
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoice deleteKolanotInvoice(
			long invoiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLocalService.deleteKolanotInvoice(invoiceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _kolanotInvoiceLocalService.dynamicQuery();
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

		return _kolanotInvoiceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.kolanot.service.model.impl.KolanotInvoiceModelImpl</code>.
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

		return _kolanotInvoiceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.kolanot.service.model.impl.KolanotInvoiceModelImpl</code>.
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

		return _kolanotInvoiceLocalService.dynamicQuery(
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

		return _kolanotInvoiceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _kolanotInvoiceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.kolanot.service.model.KolanotInvoice fetchKolanotInvoice(
		long invoiceId) {

		return _kolanotInvoiceLocalService.fetchKolanotInvoice(invoiceId);
	}

	/**
	 * Returns the kolanot invoice with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the kolanot invoice's external reference code
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoice
		fetchKolanotInvoiceByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _kolanotInvoiceLocalService.fetchKolanotInvoiceByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the kolanot invoice matching the UUID and group.
	 *
	 * @param uuid the kolanot invoice's UUID
	 * @param groupId the primary key of the group
	 * @return the matching kolanot invoice, or <code>null</code> if a matching kolanot invoice could not be found
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoice
		fetchKolanotInvoiceByUuidAndGroupId(String uuid, long groupId) {

		return _kolanotInvoiceLocalService.fetchKolanotInvoiceByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _kolanotInvoiceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _kolanotInvoiceLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _kolanotInvoiceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the kolanot invoice with the primary key.
	 *
	 * @param invoiceId the primary key of the kolanot invoice
	 * @return the kolanot invoice
	 * @throws PortalException if a kolanot invoice with the primary key could not be found
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoice getKolanotInvoice(
			long invoiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLocalService.getKolanotInvoice(invoiceId);
	}

	/**
	 * Returns the kolanot invoice matching the UUID and group.
	 *
	 * @param uuid the kolanot invoice's UUID
	 * @param groupId the primary key of the group
	 * @return the matching kolanot invoice
	 * @throws PortalException if a matching kolanot invoice could not be found
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoice
			getKolanotInvoiceByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLocalService.getKolanotInvoiceByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the kolanot invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.kolanot.service.model.impl.KolanotInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @return the range of kolanot invoices
	 */
	@Override
	public java.util.List<com.kolanot.service.model.KolanotInvoice>
		getKolanotInvoices(int start, int end) {

		return _kolanotInvoiceLocalService.getKolanotInvoices(start, end);
	}

	/**
	 * Returns all the kolanot invoices matching the UUID and company.
	 *
	 * @param uuid the UUID of the kolanot invoices
	 * @param companyId the primary key of the company
	 * @return the matching kolanot invoices, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.kolanot.service.model.KolanotInvoice>
		getKolanotInvoicesByUuidAndCompanyId(String uuid, long companyId) {

		return _kolanotInvoiceLocalService.getKolanotInvoicesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of kolanot invoices matching the UUID and company.
	 *
	 * @param uuid the UUID of the kolanot invoices
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of kolanot invoices
	 * @param end the upper bound of the range of kolanot invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching kolanot invoices, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.kolanot.service.model.KolanotInvoice>
		getKolanotInvoicesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.kolanot.service.model.KolanotInvoice> orderByComparator) {

		return _kolanotInvoiceLocalService.getKolanotInvoicesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of kolanot invoices.
	 *
	 * @return the number of kolanot invoices
	 */
	@Override
	public int getKolanotInvoicesCount() {
		return _kolanotInvoiceLocalService.getKolanotInvoicesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _kolanotInvoiceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the kolanot invoice in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect KolanotInvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param kolanotInvoice the kolanot invoice
	 * @return the kolanot invoice that was updated
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoice updateKolanotInvoice(
		com.kolanot.service.model.KolanotInvoice kolanotInvoice) {

		return _kolanotInvoiceLocalService.updateKolanotInvoice(kolanotInvoice);
	}

	@Override
	public com.kolanot.service.model.KolanotInvoice updateKolanotInvoice(
			Long invoiceId, String documentStatus,
			java.math.BigDecimal balanceDue,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLocalService.updateKolanotInvoice(
			invoiceId, documentStatus, balanceDue, serviceContext);
	}

	@Override
	public KolanotInvoiceLocalService getWrappedService() {
		return _kolanotInvoiceLocalService;
	}

	@Override
	public void setWrappedService(
		KolanotInvoiceLocalService kolanotInvoiceLocalService) {

		_kolanotInvoiceLocalService = kolanotInvoiceLocalService;
	}

	private KolanotInvoiceLocalService _kolanotInvoiceLocalService;

}