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

package com.kolanot.service.service.impl;

import com.kolanot.service.model.KolanotInvoiceLine;
import com.kolanot.service.service.base.KolanotInvoiceLineLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the kolanot invoice line local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.kolanot.service.service.KolanotInvoiceLineLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoiceLineLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.kolanot.service.model.KolanotInvoiceLine",
	service = AopService.class
)
public class KolanotInvoiceLineLocalServiceImpl
	extends KolanotInvoiceLineLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.kolanot.service.service.KolanotInvoiceLineLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.kolanot.service.service.KolanotInvoiceLineLocalServiceUtil</code>.
	 */
	public List<KolanotInvoiceLine> findInvoiceLineByInvoiceId(
			long invoiceId, int start, int end) {

			return kolanotInvoiceLinePersistence.findByInvoiceId(
				invoiceId, start, end);
		}
}