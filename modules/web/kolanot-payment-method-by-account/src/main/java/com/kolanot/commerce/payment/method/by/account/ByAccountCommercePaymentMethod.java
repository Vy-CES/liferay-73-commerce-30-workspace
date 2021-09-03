/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.kolanot.commerce.payment.method.by.account;

import com.liferay.commerce.constants.CommerceOrderConstants;
import com.liferay.commerce.constants.CommercePaymentConstants;
import com.liferay.commerce.payment.method.CommercePaymentMethod;
import com.liferay.commerce.payment.request.CommercePaymentRequest;
import com.liferay.commerce.payment.result.CommercePaymentResult;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import org.osgi.service.component.annotations.Component;

import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Dinh Thai
 */
@Component(
    immediate = true,
    property = "commerce.payment.engine.method.key=" + ByAccountCommercePaymentMethod.KEY,
    service = CommercePaymentMethod.class
)
public class ByAccountCommercePaymentMethod implements CommercePaymentMethod {

    public final static String KEY = "payment-by-account";

    @Override
    public String getDescription(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
            "content.Language", locale, getClass());

        return LanguageUtil.get(
            resourceBundle, "by-account-payment-method-description");
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String getName(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
            "content.Language", locale, getClass());

        return LanguageUtil.get(resourceBundle, "by-account-payment-with-card");
    }

    @Override
    public int getPaymentType() {
        return CommercePaymentConstants.COMMERCE_PAYMENT_METHOD_TYPE_OFFLINE;
    }

    @Override
    public String getServletPath() {
        return null;
    }

    @Override
    public CommercePaymentResult completePayment(
            CommercePaymentRequest commercePaymentRequest)
            throws Exception {

        return new CommercePaymentResult(
                null, commercePaymentRequest.getCommerceOrderId(),
                CommerceOrderConstants.PAYMENT_STATUS_PENDING, false, null, null,
                Collections.emptyList(), true);
    }

    @Override
    public boolean isCompleteEnabled() {
        return true;
    }

    @Override
    public boolean isProcessPaymentEnabled() {
        return true;
    }

    @Override
    public CommercePaymentResult processPayment(
            CommercePaymentRequest commercePaymentRequest)
            throws Exception {

        return new CommercePaymentResult(
                null, commercePaymentRequest.getCommerceOrderId(),
                CommerceOrderConstants.PAYMENT_STATUS_AUTHORIZED, false, null, null,
                Collections.emptyList(), true);
    }
}
