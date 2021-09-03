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

package com.sapphire.commerce.payment.method.override.exception;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Dinh Thai
 */
public class CommerceOrderPaymentMethodLimitationException extends PortalException {
    private static String _msg = StringPool.BLANK;

    public CommerceOrderPaymentMethodLimitationException() {
    }

    public CommerceOrderPaymentMethodLimitationException(String msg) {
        super(msg);
        _msg = msg;
    }

    public CommerceOrderPaymentMethodLimitationException(String msg, Throwable throwable) {
        super(msg, throwable);
        _msg = msg;
    }

    public CommerceOrderPaymentMethodLimitationException(Throwable throwable) {
        super(throwable);
    }

    public static String getErrorMessage() {
        return _msg;
    }
}
