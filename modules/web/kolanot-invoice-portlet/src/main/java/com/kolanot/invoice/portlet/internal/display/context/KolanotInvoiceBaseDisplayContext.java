package com.kolanot.invoice.portlet.internal.display.context;

import com.kolanot.invoice.portlet.util.KolanotInvoiceRequestHelper;
import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

public class KolanotInvoiceBaseDisplayContext {

	public KolanotInvoiceBaseDisplayContext(
			HttpServletRequest httpServletRequest, RenderRequest renderRequest,
			RenderResponse renderResponse) {

			_httpServletRequest = httpServletRequest;
			_renderRequest = renderRequest;
			_renderResponse = renderResponse;

			_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
				_httpServletRequest);

			_kolanotInvoiceRequestHelper =
				new KolanotInvoiceRequestHelper(httpServletRequest);

			_liferayPortletRequest =
				_kolanotInvoiceRequestHelper.getLiferayPortletRequest();
			_liferayPortletResponse =
				_kolanotInvoiceRequestHelper.getLiferayPortletResponse();

			_commerceContext = (CommerceContext)httpServletRequest.getAttribute(
				CommerceWebKeys.COMMERCE_CONTEXT);
		}

		protected final CommerceContext _commerceContext;
		protected final HttpServletRequest _httpServletRequest;
		protected final LiferayPortletRequest _liferayPortletRequest;
		protected final LiferayPortletResponse _liferayPortletResponse;
		protected final PortalPreferences _portalPreferences;
		protected final RenderRequest _renderRequest;
		protected final RenderResponse _renderResponse;
		protected final KolanotInvoiceRequestHelper
			_kolanotInvoiceRequestHelper;
}
