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

package com.sapphire.commerce.payment.method.override;

import com.liferay.commerce.account.model.CommerceAccountGroup;
import com.liferay.commerce.account.service.CommerceAccountGroupLocalServiceUtil;
import com.liferay.commerce.constants.CommerceCheckoutWebKeys;
import com.liferay.commerce.constants.CommerceOrderActionKeys;
import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.exception.CommerceOrderPaymentMethodException;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.payment.engine.CommercePaymentEngine;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.commerce.service.CommerceOrderService;
import com.liferay.commerce.util.BaseCommerceCheckoutStep;
import com.liferay.commerce.util.CommerceCheckoutStep;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapphire.commerce.payment.method.override.display.context.SapphirePaymentMethodCheckoutStepDisplayContext;
import com.sapphire.commerce.payment.method.override.exception.CommerceOrderPaymentMethodLimitationException;
import com.sapphire.commerce.payment.method.override.util.CommerceCheckoutStepHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrea Di Giorgi
 * @author Alessio Antonio Rendina
 */
@Component(
	immediate = true,
	property = {
		"service.ranking:Integer=100",
		"commerce.checkout.step.name=" + PaymentMethodCommerceCheckoutStep.NAME,
		"commerce.checkout.step.order:Integer=40"
		
	},
	service = CommerceCheckoutStep.class
)
public class PaymentMethodCommerceCheckoutStep
	extends BaseCommerceCheckoutStep {

	public static final String NAME = "payment-method";

	@Override
	public String getName() {
		System.out.println("Get name????");
		return NAME;
	}

	@Override
	public boolean isActive(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		if (!_commerceCheckoutStepHelper.
				isActivePaymentMethodCommerceCheckoutStep(httpServletRequest)) {

			return false;
		}

		return true;
	}

	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			updateCommerceOrderPaymentMethod(actionRequest);
		}
		catch (Exception exception) {
			if (exception instanceof CommerceOrderPaymentMethodException) {
				SessionErrors.add(actionRequest, exception.getClass());

				return;
			}

			throw exception;
		}
	}

	@Override
	public void render(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		SapphirePaymentMethodCheckoutStepDisplayContext
				sapphirePaymentMethodCheckoutStepDisplayContext =
				new SapphirePaymentMethodCheckoutStepDisplayContext(
					_commercePaymentEngine, httpServletRequest);

		httpServletRequest.setAttribute(
			CommerceCheckoutWebKeys.COMMERCE_CHECKOUT_STEP_DISPLAY_CONTEXT,
				sapphirePaymentMethodCheckoutStepDisplayContext);

		_jspRenderer.renderJSP(_servletContext,
			httpServletRequest, httpServletResponse,
			"/checkout_step/payment_method.jsp");
	}

	@Reference(
		target = "(model.class.name=com.liferay.commerce.model.CommerceOrder)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<CommerceOrder> modelResourcePermission) {

		_commerceOrderModelResourcePermission = modelResourcePermission;
	}

	protected void updateCommerceOrderPaymentMethod(ActionRequest actionRequest)
		throws Exception {

		String commercePaymentMethodKey = ParamUtil.getString(
			actionRequest, "commercePaymentMethodKey");

		if (commercePaymentMethodKey.isEmpty()) {
			throw new CommerceOrderPaymentMethodException();
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String commerceOrderUuid = ParamUtil.getString(
			actionRequest, "commerceOrderUuid");

		CommerceContext commerceContext =
			(CommerceContext)actionRequest.getAttribute(
				CommerceWebKeys.COMMERCE_CONTEXT);

		CommerceOrder commerceOrder =
			_commerceOrderService.getCommerceOrderByUuidAndGroupId(
				commerceOrderUuid, commerceContext.getCommerceChannelGroupId());

		if (!_commerceOrderModelResourcePermission.contains(
				themeDisplay.getPermissionChecker(), commerceOrder,
				CommerceOrderActionKeys.CHECKOUT_COMMERCE_ORDER)) {

			return;
		}

		_commerceOrderLocalService.updateCommerceOrder(
			commerceOrder.getCommerceOrderId(),
			commerceOrder.getBillingAddressId(),
			commerceOrder.getShippingAddressId(), commercePaymentMethodKey,
			commerceOrder.getCommerceShippingMethodId(),
			commerceOrder.getShippingOptionName(),
			commerceOrder.getPurchaseOrderNumber(), commerceOrder.getSubtotal(),
			commerceOrder.getShippingAmount(), commerceOrder.getTotal(),
			commerceOrder.getAdvanceStatus(), commerceContext);
	}

	@Reference
	private CommerceCheckoutStepHelper _commerceCheckoutStepHelper;

	@Reference
	private CommerceOrderLocalService _commerceOrderLocalService;

	private ModelResourcePermission<CommerceOrder>
		_commerceOrderModelResourcePermission;

	@Reference
	private CommerceOrderService _commerceOrderService;

	@Reference
	private CommercePaymentEngine _commercePaymentEngine;

	@Reference
	private JSPRenderer _jspRenderer;


	@Reference(
			target = "(osgi.web.symbolicname=com.sapphire.commerce.payment.method.override)"
	)
	private ServletContext _servletContext;

}