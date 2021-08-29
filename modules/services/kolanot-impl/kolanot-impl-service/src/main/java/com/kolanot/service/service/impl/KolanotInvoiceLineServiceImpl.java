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

import com.kolanot.service.service.base.KolanotInvoiceLineServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the kolanot invoice line remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.kolanot.service.service.KolanotInvoiceLineService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KolanotInvoiceLineServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=kolanot",
		"json.web.service.context.path=KolanotInvoiceLine"
	},
	service = AopService.class
)
public class KolanotInvoiceLineServiceImpl
	extends KolanotInvoiceLineServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.kolanot.service.service.KolanotInvoiceLineServiceUtil</code> to access the kolanot invoice line remote service.
	 */
}