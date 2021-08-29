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
 * Provides a wrapper for {@link KolanotInvoiceLineLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoiceLineLocalService
 * @generated
 */
public class KolanotInvoiceLineLocalServiceWrapper
	implements KolanotInvoiceLineLocalService,
			   ServiceWrapper<KolanotInvoiceLineLocalService> {

	public KolanotInvoiceLineLocalServiceWrapper(
		KolanotInvoiceLineLocalService kolanotInvoiceLineLocalService) {

		_kolanotInvoiceLineLocalService = kolanotInvoiceLineLocalService;
	}

	/**
	 * Adds the kolanot invoice line to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect KolanotInvoiceLineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param kolanotInvoiceLine the kolanot invoice line
	 * @return the kolanot invoice line that was added
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoiceLine addKolanotInvoiceLine(
		com.kolanot.service.model.KolanotInvoiceLine kolanotInvoiceLine) {

		return _kolanotInvoiceLineLocalService.addKolanotInvoiceLine(
			kolanotInvoiceLine);
	}

	/**
	 * Creates a new kolanot invoice line with the primary key. Does not add the kolanot invoice line to the database.
	 *
	 * @param invoiceLineId the primary key for the new kolanot invoice line
	 * @return the new kolanot invoice line
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoiceLine
		createKolanotInvoiceLine(long invoiceLineId) {

		return _kolanotInvoiceLineLocalService.createKolanotInvoiceLine(
			invoiceLineId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLineLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the kolanot invoice line from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect KolanotInvoiceLineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param kolanotInvoiceLine the kolanot invoice line
	 * @return the kolanot invoice line that was removed
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoiceLine
		deleteKolanotInvoiceLine(
			com.kolanot.service.model.KolanotInvoiceLine kolanotInvoiceLine) {

		return _kolanotInvoiceLineLocalService.deleteKolanotInvoiceLine(
			kolanotInvoiceLine);
	}

	/**
	 * Deletes the kolanot invoice line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect KolanotInvoiceLineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invoiceLineId the primary key of the kolanot invoice line
	 * @return the kolanot invoice line that was removed
	 * @throws PortalException if a kolanot invoice line with the primary key could not be found
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoiceLine
			deleteKolanotInvoiceLine(long invoiceLineId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLineLocalService.deleteKolanotInvoiceLine(
			invoiceLineId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLineLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _kolanotInvoiceLineLocalService.dynamicQuery();
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

		return _kolanotInvoiceLineLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.kolanot.service.model.impl.KolanotInvoiceLineModelImpl</code>.
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

		return _kolanotInvoiceLineLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.kolanot.service.model.impl.KolanotInvoiceLineModelImpl</code>.
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

		return _kolanotInvoiceLineLocalService.dynamicQuery(
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

		return _kolanotInvoiceLineLocalService.dynamicQueryCount(dynamicQuery);
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

		return _kolanotInvoiceLineLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.kolanot.service.model.KolanotInvoiceLine fetchKolanotInvoiceLine(
		long invoiceLineId) {

		return _kolanotInvoiceLineLocalService.fetchKolanotInvoiceLine(
			invoiceLineId);
	}

	/**
	 * Returns the kolanot invoice line matching the UUID and group.
	 *
	 * @param uuid the kolanot invoice line's UUID
	 * @param groupId the primary key of the group
	 * @return the matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoiceLine
		fetchKolanotInvoiceLineByUuidAndGroupId(String uuid, long groupId) {

		return _kolanotInvoiceLineLocalService.
			fetchKolanotInvoiceLineByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.kolanot.service.model.KolanotInvoiceLine>
		findInvoiceLineByInvoiceId(long invoiceId, int start, int end) {

		return _kolanotInvoiceLineLocalService.findInvoiceLineByInvoiceId(
			invoiceId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _kolanotInvoiceLineLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _kolanotInvoiceLineLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the kolanot invoice line with the primary key.
	 *
	 * @param invoiceLineId the primary key of the kolanot invoice line
	 * @return the kolanot invoice line
	 * @throws PortalException if a kolanot invoice line with the primary key could not be found
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoiceLine getKolanotInvoiceLine(
			long invoiceLineId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLineLocalService.getKolanotInvoiceLine(
			invoiceLineId);
	}

	/**
	 * Returns the kolanot invoice line matching the UUID and group.
	 *
	 * @param uuid the kolanot invoice line's UUID
	 * @param groupId the primary key of the group
	 * @return the matching kolanot invoice line
	 * @throws PortalException if a matching kolanot invoice line could not be found
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoiceLine
			getKolanotInvoiceLineByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLineLocalService.
			getKolanotInvoiceLineByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the kolanot invoice lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.kolanot.service.model.impl.KolanotInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @return the range of kolanot invoice lines
	 */
	@Override
	public java.util.List<com.kolanot.service.model.KolanotInvoiceLine>
		getKolanotInvoiceLines(int start, int end) {

		return _kolanotInvoiceLineLocalService.getKolanotInvoiceLines(
			start, end);
	}

	/**
	 * Returns all the kolanot invoice lines matching the UUID and company.
	 *
	 * @param uuid the UUID of the kolanot invoice lines
	 * @param companyId the primary key of the company
	 * @return the matching kolanot invoice lines, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.kolanot.service.model.KolanotInvoiceLine>
		getKolanotInvoiceLinesByUuidAndCompanyId(String uuid, long companyId) {

		return _kolanotInvoiceLineLocalService.
			getKolanotInvoiceLinesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of kolanot invoice lines matching the UUID and company.
	 *
	 * @param uuid the UUID of the kolanot invoice lines
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of kolanot invoice lines
	 * @param end the upper bound of the range of kolanot invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching kolanot invoice lines, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.kolanot.service.model.KolanotInvoiceLine>
		getKolanotInvoiceLinesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.kolanot.service.model.KolanotInvoiceLine>
					orderByComparator) {

		return _kolanotInvoiceLineLocalService.
			getKolanotInvoiceLinesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of kolanot invoice lines.
	 *
	 * @return the number of kolanot invoice lines
	 */
	@Override
	public int getKolanotInvoiceLinesCount() {
		return _kolanotInvoiceLineLocalService.getKolanotInvoiceLinesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _kolanotInvoiceLineLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _kolanotInvoiceLineLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the kolanot invoice line in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect KolanotInvoiceLineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param kolanotInvoiceLine the kolanot invoice line
	 * @return the kolanot invoice line that was updated
	 */
	@Override
	public com.kolanot.service.model.KolanotInvoiceLine
		updateKolanotInvoiceLine(
			com.kolanot.service.model.KolanotInvoiceLine kolanotInvoiceLine) {

		return _kolanotInvoiceLineLocalService.updateKolanotInvoiceLine(
			kolanotInvoiceLine);
	}

	@Override
	public KolanotInvoiceLineLocalService getWrappedService() {
		return _kolanotInvoiceLineLocalService;
	}

	@Override
	public void setWrappedService(
		KolanotInvoiceLineLocalService kolanotInvoiceLineLocalService) {

		_kolanotInvoiceLineLocalService = kolanotInvoiceLineLocalService;
	}

	private KolanotInvoiceLineLocalService _kolanotInvoiceLineLocalService;

}