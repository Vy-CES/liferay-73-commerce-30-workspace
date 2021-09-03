<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
SapphirePaymentMethodCheckoutStepDisplayContext paymentMethodCheckoutStepDisplayContext = (SapphirePaymentMethodCheckoutStepDisplayContext)request.getAttribute(CommerceCheckoutWebKeys.COMMERCE_CHECKOUT_STEP_DISPLAY_CONTEXT);

List<CommercePaymentMethod> commercePaymentMethods = paymentMethodCheckoutStepDisplayContext.getCommercePaymentMethods();

CommerceOrder commerceOrder = paymentMethodCheckoutStepDisplayContext.getCommerceOrder();

String commercePaymentMethodKey = BeanParamUtil.getString(commerceOrder, request, "commercePaymentMethodKey");
%>

<div id="commercePaymentMethodsContainer">
	<liferay-ui:error exception="<%= CommerceOrderPaymentMethodException.class %>" message="please-select-a-valid-payment-method" />
	<liferay-ui:error exception="<%= CommerceOrderPaymentMethodLimitationException.class %>" message="this-payment-method-only-available-for-prepaid-customer" />

	<c:choose>
		<c:when test="<%= commercePaymentMethods.isEmpty() %>">
			<aui:row>
				<aui:col width="<%= 100 %>">
					<aui:alert type="info">
						<liferay-ui:message key="there-are-no-available-payment-methods" />
					</aui:alert>
				</aui:col>
			</aui:row>

			<aui:script use="aui-base">
				var continueButton = A.one('#<portlet:namespace />continue');

				if (continueButton) {
					Liferay.Util.toggleDisabled(continueButton, true);
				}
			</aui:script>
		</c:when>
		<c:otherwise>
			<ul class="list-group">

				<%
				for (CommercePaymentMethod commercePaymentMethod : commercePaymentMethods) {
				%>

					<li class="commerce-payment-types list-group-item list-group-item-flex">
						<div class="autofit-col autofit-col-expand">
							<aui:input checked="<%= commercePaymentMethodKey.equals(commercePaymentMethod.getKey()) %>" label="<%= commercePaymentMethod.getName(locale) %>" name="commercePaymentMethodKey" type="radio" value="<%= commercePaymentMethod.getKey() %>" />
						</div>

						<%
						String thumbnailSrc = paymentMethodCheckoutStepDisplayContext.getImageURL(commerceOrder.getGroupId(), commercePaymentMethod.getKey(), themeDisplay);
						%>

						<c:if test="<%= Validator.isNotNull(thumbnailSrc) %>">
							<div class="autofit-col">
								<img alt="<%= commercePaymentMethod.getName(locale) %>" class="payment-icon" src="<%= thumbnailSrc %>" style="height: 45px; width: auto;" />
							</div>
						</c:if>
					</li>

				<%
				}
				%>

			</ul>
		</c:otherwise>
	</c:choose>
</div>

<c:if test="<%= commercePaymentMethods.isEmpty() %>">
	<aui:script use="aui-base">
		var value = A.one('#<portlet:namespace />continue');

		if (value) {
			Liferay.Util.toggleDisabled(value, true);
		}
	</aui:script>
</c:if>