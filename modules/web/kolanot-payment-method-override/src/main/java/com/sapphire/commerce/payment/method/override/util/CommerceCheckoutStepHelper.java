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

package com.sapphire.commerce.payment.method.override.util;

import com.liferay.commerce.account.model.CommerceAccount;
import com.liferay.commerce.constants.CommerceCheckoutWebKeys;
import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.currency.model.CommerceMoney;
import com.liferay.commerce.model.CommerceAddress;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.order.CommerceOrderHttpHelper;
import com.liferay.commerce.payment.engine.CommercePaymentEngine;
import com.liferay.commerce.payment.method.CommercePaymentMethod;
import com.liferay.commerce.price.CommerceOrderPrice;
import com.liferay.commerce.price.CommerceOrderPriceCalculation;
import com.liferay.commerce.service.CommerceAddressService;
import com.liferay.commerce.service.CommerceOrderService;
import com.liferay.commerce.service.CommerceShippingMethodLocalService;
import com.liferay.commerce.util.CommerceBigDecimalUtil;
import com.liferay.commerce.util.CommerceShippingHelper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Alessio Antonio Rendina
 * @author Luca Pellizzon
 */
@Component(
	immediate = true,
	service = CommerceCheckoutStepHelper.class
)
public class CommerceCheckoutStepHelper {

	public String getOrderDetailURL(
			HttpServletRequest httpServletRequest, CommerceOrder commerceOrder)
		throws PortalException {

		PortletURL portletURL =
			_commerceOrderHttpHelper.getCommerceCartPortletURL(
				httpServletRequest, commerceOrder);

		if (portletURL == null) {
			return StringPool.BLANK;
		}

		return portletURL.toString();
	}

	public boolean isActiveBillingAddressCommerceCheckoutStep(
			HttpServletRequest httpServletRequest)
		throws PortalException {

		CommerceOrder commerceOrder =
			(CommerceOrder)httpServletRequest.getAttribute(
				CommerceCheckoutWebKeys.COMMERCE_ORDER);

		CommerceAccount commerceAccount = commerceOrder.getCommerceAccount();
		CommerceAddress shippingAddress = commerceOrder.getShippingAddress();
		CommerceAddress billingAddress = commerceOrder.getBillingAddress();

		if ((commerceAccount != null) &&
			(commerceAccount.getDefaultBillingAddressId() ==
				commerceAccount.getDefaultShippingAddressId()) &&
			(billingAddress != null) && (shippingAddress != null) &&
			(shippingAddress.getCommerceAddressId() ==
				billingAddress.getCommerceAddressId())) {

			return false;
		}

		return true;
	}

	public boolean isActivePaymentMethodCommerceCheckoutStep(
			HttpServletRequest httpServletRequest)
		throws PortalException {

		CommerceOrder commerceOrder =
			(CommerceOrder)httpServletRequest.getAttribute(
				CommerceCheckoutWebKeys.COMMERCE_ORDER);

		long commercePaymentMethodGroupRelsCount =
			_commercePaymentEngine.getCommercePaymentMethodGroupRelsCount(
				commerceOrder.getGroupId());

		if (commercePaymentMethodGroupRelsCount < 1) {
			return false;
		}

		CommerceContext commerceContext =
			(CommerceContext)httpServletRequest.getAttribute(
				CommerceWebKeys.COMMERCE_CONTEXT);

		CommerceOrderPrice commerceOrderPrice =
			_commerceOrderPriceCalculation.getCommerceOrderPrice(
				commerceOrder, commerceContext);

		CommerceMoney orderPriceTotal = commerceOrderPrice.getTotal();

		if (CommerceBigDecimalUtil.isZero(orderPriceTotal.getPrice())) {
			return false;
		}

		List<CommercePaymentMethod> commercePaymentMethods =
			_commercePaymentEngine.getEnabledCommercePaymentMethodsForOrder(
				commerceOrder.getGroupId(), commerceOrder.getCommerceOrderId());

		if (commercePaymentMethods.isEmpty()) {
			return false;
		}

		if (commercePaymentMethods.size() == 1) {
			CommercePaymentMethod commercePaymentMethod =
				commercePaymentMethods.get(0);

			_updateCommerceOrder(
				httpServletRequest, commerceOrder,
				commercePaymentMethod.getKey());

			return false;
		}

		return true;
	}

	public boolean isActiveShippingMethodCommerceCheckoutStep(
			HttpServletRequest httpServletRequest)
		throws PortalException {

		CommerceOrder commerceOrder =
			(CommerceOrder)httpServletRequest.getAttribute(
				CommerceCheckoutWebKeys.COMMERCE_ORDER);

		if (!_commerceShippingHelper.isShippable(commerceOrder) ||
			_commerceShippingHelper.isFreeShipping(commerceOrder)) {

			return false;
		}

		long commerceGroupShippingMethodsCount =
			_commerceShippingMethodLocalService.getCommerceShippingMethodsCount(
				commerceOrder.getGroupId(), true);

		if (commerceGroupShippingMethodsCount > 0) {
			return true;
		}

		return false;
	}

	private void _updateCommerceOrder(
			HttpServletRequest httpServletRequest, CommerceOrder commerceOrder,
			String commercePaymentMethodKey)
		throws PortalException {

		CommerceAddress commerceAddress = commerceOrder.getBillingAddress();

		if (commerceAddress == null) {
			commerceAddress = commerceOrder.getShippingAddress();
		}

		if (commerceAddress == null) {
			return;
		}

		if (commercePaymentMethodKey.equals(
				commerceOrder.getCommercePaymentMethodKey())) {

			return;
		}

		commerceOrder = _commerceOrderService.updateCommercePaymentMethodKey(
			commerceOrder.getCommerceOrderId(), commercePaymentMethodKey);

		httpServletRequest.setAttribute(
			CommerceCheckoutWebKeys.COMMERCE_ORDER, commerceOrder);
	}

	@Reference
	private CommerceAddressService _commerceAddressService;

	@Reference
	private CommerceOrderHttpHelper _commerceOrderHttpHelper;

	@Reference
	private CommerceOrderPriceCalculation _commerceOrderPriceCalculation;

	@Reference
	private CommerceOrderService _commerceOrderService;

	@Reference
	private CommercePaymentEngine _commercePaymentEngine;

	@Reference
	private CommerceShippingHelper _commerceShippingHelper;

	@Reference
	private CommerceShippingMethodLocalService
		_commerceShippingMethodLocalService;

	@Reference
	private Portal _portal;

}