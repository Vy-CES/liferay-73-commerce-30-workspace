/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.sapphire.commerce.payment.method.override.display.context;

import com.liferay.commerce.constants.CommerceCheckoutWebKeys;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.payment.engine.CommercePaymentEngine;
import com.liferay.commerce.payment.method.CommercePaymentMethod;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Andrea Di Giorgi
 */
public class SapphirePaymentMethodCheckoutStepDisplayContext {

	public SapphirePaymentMethodCheckoutStepDisplayContext(
		CommercePaymentEngine commercePaymentEngine,
		HttpServletRequest httpServletRequest) {

		System.out.println("is this ever called?");
		_commercePaymentEngine = commercePaymentEngine;

		_commerceOrder = (CommerceOrder)httpServletRequest.getAttribute(
			CommerceCheckoutWebKeys.COMMERCE_ORDER);
	}

	public CommerceOrder getCommerceOrder() {
		return _commerceOrder;
	}

	public List<CommercePaymentMethod> getCommercePaymentMethods()
		throws Exception {

		return _commercePaymentEngine.getEnabledCommercePaymentMethodsForOrder(
			_commerceOrder.getGroupId(), _commerceOrder.getCommerceOrderId());
	}

	public String getImageURL(
			long groupId, String paymentMethodKey, ThemeDisplay themeDisplay)
		throws PortalException {

		return _commercePaymentEngine.getPaymentMethodImageURL(
			groupId, paymentMethodKey, themeDisplay);
	}

	private final CommerceOrder _commerceOrder;
	private final CommercePaymentEngine _commercePaymentEngine;

}