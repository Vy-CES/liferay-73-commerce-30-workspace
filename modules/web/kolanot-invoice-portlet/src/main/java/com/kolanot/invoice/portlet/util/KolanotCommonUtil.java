package com.kolanot.invoice.portlet.util;

import com.liferay.commerce.constants.CommercePortletKeys;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletRequest;

public class KolanotCommonUtil {

	public static String getOrderViewDetailURL(
            String commerceOrderId, ThemeDisplay themeDisplay)
		throws PortalException {

		long plid = PortalUtil.getPlidFromPortletId(
			themeDisplay.getScopeGroupId(),
			CommercePortletKeys.COMMERCE_ORDER_CONTENT);

		if (plid > 0) {

			LiferayPortletURL anotherPortletURL = PortletURLFactoryUtil.create(
				themeDisplay.getRequest(),
				CommercePortletKeys.COMMERCE_ORDER_CONTENT, plid,
				PortletRequest.RENDER_PHASE);

			anotherPortletURL.setParameter(
				"mvcRenderCommandName", "viewCommerceOrderDetails");
			anotherPortletURL.setParameter(
				"commerceOrderId", String.valueOf(commerceOrderId));

			return anotherPortletURL.toString();
		}

		return StringPool.BLANK;
	}
}
