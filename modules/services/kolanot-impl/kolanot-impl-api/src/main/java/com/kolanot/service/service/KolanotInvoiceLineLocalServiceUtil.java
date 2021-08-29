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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for KolanotInvoiceLine. This utility wraps
 * <code>com.kolanot.service.service.impl.KolanotInvoiceLineLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoiceLineLocalService
 * @generated
 */
public class KolanotInvoiceLineLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.kolanot.service.service.impl.KolanotInvoiceLineLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.kolanot.service.model.KolanotInvoiceLine
		addKolanotInvoiceLine(
			com.kolanot.service.model.KolanotInvoiceLine kolanotInvoiceLine) {

		return getService().addKolanotInvoiceLine(kolanotInvoiceLine);
	}

	/**
	 * Creates a new kolanot invoice line with the primary key. Does not add the kolanot invoice line to the database.
	 *
	 * @param invoiceLineId the primary key for the new kolanot invoice line
	 * @return the new kolanot invoice line
	 */
	public static com.kolanot.service.model.KolanotInvoiceLine
		createKolanotInvoiceLine(long invoiceLineId) {

		return getService().createKolanotInvoiceLine(invoiceLineId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static com.kolanot.service.model.KolanotInvoiceLine
		deleteKolanotInvoiceLine(
			com.kolanot.service.model.KolanotInvoiceLine kolanotInvoiceLine) {

		return getService().deleteKolanotInvoiceLine(kolanotInvoiceLine);
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
	public static com.kolanot.service.model.KolanotInvoiceLine
			deleteKolanotInvoiceLine(long invoiceLineId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteKolanotInvoiceLine(invoiceLineId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.kolanot.service.model.KolanotInvoiceLine
		fetchKolanotInvoiceLine(long invoiceLineId) {

		return getService().fetchKolanotInvoiceLine(invoiceLineId);
	}

	/**
	 * Returns the kolanot invoice line matching the UUID and group.
	 *
	 * @param uuid the kolanot invoice line's UUID
	 * @param groupId the primary key of the group
	 * @return the matching kolanot invoice line, or <code>null</code> if a matching kolanot invoice line could not be found
	 */
	public static com.kolanot.service.model.KolanotInvoiceLine
		fetchKolanotInvoiceLineByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchKolanotInvoiceLineByUuidAndGroupId(
			uuid, groupId);
	}

	public static java.util.List<com.kolanot.service.model.KolanotInvoiceLine>
		findInvoiceLineByInvoiceId(long invoiceId, int start, int end) {

		return getService().findInvoiceLineByInvoiceId(invoiceId, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the kolanot invoice line with the primary key.
	 *
	 * @param invoiceLineId the primary key of the kolanot invoice line
	 * @return the kolanot invoice line
	 * @throws PortalException if a kolanot invoice line with the primary key could not be found
	 */
	public static com.kolanot.service.model.KolanotInvoiceLine
			getKolanotInvoiceLine(long invoiceLineId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getKolanotInvoiceLine(invoiceLineId);
	}

	/**
	 * Returns the kolanot invoice line matching the UUID and group.
	 *
	 * @param uuid the kolanot invoice line's UUID
	 * @param groupId the primary key of the group
	 * @return the matching kolanot invoice line
	 * @throws PortalException if a matching kolanot invoice line could not be found
	 */
	public static com.kolanot.service.model.KolanotInvoiceLine
			getKolanotInvoiceLineByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getKolanotInvoiceLineByUuidAndGroupId(
			uuid, groupId);
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
	public static java.util.List<com.kolanot.service.model.KolanotInvoiceLine>
		getKolanotInvoiceLines(int start, int end) {

		return getService().getKolanotInvoiceLines(start, end);
	}

	/**
	 * Returns all the kolanot invoice lines matching the UUID and company.
	 *
	 * @param uuid the UUID of the kolanot invoice lines
	 * @param companyId the primary key of the company
	 * @return the matching kolanot invoice lines, or an empty list if no matches were found
	 */
	public static java.util.List<com.kolanot.service.model.KolanotInvoiceLine>
		getKolanotInvoiceLinesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getKolanotInvoiceLinesByUuidAndCompanyId(
			uuid, companyId);
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
	public static java.util.List<com.kolanot.service.model.KolanotInvoiceLine>
		getKolanotInvoiceLinesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.kolanot.service.model.KolanotInvoiceLine>
					orderByComparator) {

		return getService().getKolanotInvoiceLinesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of kolanot invoice lines.
	 *
	 * @return the number of kolanot invoice lines
	 */
	public static int getKolanotInvoiceLinesCount() {
		return getService().getKolanotInvoiceLinesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.kolanot.service.model.KolanotInvoiceLine
		updateKolanotInvoiceLine(
			com.kolanot.service.model.KolanotInvoiceLine kolanotInvoiceLine) {

		return getService().updateKolanotInvoiceLine(kolanotInvoiceLine);
	}

	public static KolanotInvoiceLineLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<KolanotInvoiceLineLocalService, KolanotInvoiceLineLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			KolanotInvoiceLineLocalService.class);

		ServiceTracker
			<KolanotInvoiceLineLocalService, KolanotInvoiceLineLocalService>
				serviceTracker =
					new ServiceTracker
						<KolanotInvoiceLineLocalService,
						 KolanotInvoiceLineLocalService>(
							 bundle.getBundleContext(),
							 KolanotInvoiceLineLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}