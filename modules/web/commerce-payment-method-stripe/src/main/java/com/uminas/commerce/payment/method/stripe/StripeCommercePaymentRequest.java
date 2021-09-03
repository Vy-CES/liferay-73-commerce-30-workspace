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

package com.uminas.commerce.payment.method.stripe;

import com.liferay.commerce.payment.request.CommercePaymentRequest;

import java.io.Console;
import java.math.BigDecimal;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qtle
 */
public class StripeCommercePaymentRequest extends CommercePaymentRequest {

	public StripeCommercePaymentRequest(
		BigDecimal amount, String cancelUrl, long commerceOrderId,
		Locale locale, String sessionId, HttpServletRequest httpServletRequest, String returnUrl, String transactionId) {

		super(
			amount, cancelUrl, commerceOrderId, locale, returnUrl,
			transactionId);
		System.out.println("stripe payment request: " + returnUrl);
		System.out.println("stripe payment request: " + httpServletRequest.toString());
		_stripeSessionId = sessionId;
	
		_httpServletRequest = httpServletRequest;
	}

	public HttpServletRequest getHttpServletRequest() {
		return _httpServletRequest;
	}

	
	public String getStripeSessionId() {
		return _stripeSessionId;
	}

	private final String _stripeSessionId;
	private final HttpServletRequest _httpServletRequest;

}