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
 * Provides a wrapper for {@link InvoiceGeneratorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceGeneratorLocalService
 * @generated
 */
public class InvoiceGeneratorLocalServiceWrapper
	implements InvoiceGeneratorLocalService,
			   ServiceWrapper<InvoiceGeneratorLocalService> {

	public InvoiceGeneratorLocalServiceWrapper(
		InvoiceGeneratorLocalService invoiceGeneratorLocalService) {

		_invoiceGeneratorLocalService = invoiceGeneratorLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.sapphire.commerce.invoice.management.service.InvoiceGeneratorLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.sapphire.commerce.invoice.management.service.InvoiceGeneratorLocalServiceUtil</code>.
	 */
	@Override
	public java.io.File getInvoicePDFFile(
			com.kolanot.service.model.KolanotInvoice commerceInvoice)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.io.IOException {

		return _invoiceGeneratorLocalService.getInvoicePDFFile(commerceInvoice);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _invoiceGeneratorLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public InvoiceGeneratorLocalService getWrappedService() {
		return _invoiceGeneratorLocalService;
	}

	@Override
	public void setWrappedService(
		InvoiceGeneratorLocalService invoiceGeneratorLocalService) {

		_invoiceGeneratorLocalService = invoiceGeneratorLocalService;
	}

	private InvoiceGeneratorLocalService _invoiceGeneratorLocalService;

}