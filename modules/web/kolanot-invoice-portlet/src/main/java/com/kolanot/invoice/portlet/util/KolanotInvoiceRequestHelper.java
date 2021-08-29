package com.kolanot.invoice.portlet.util;

import com.liferay.portal.kernel.display.context.util.BaseRequestHelper;
import com.liferay.portal.kernel.util.JavaConstants;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

public class KolanotInvoiceRequestHelper  extends BaseRequestHelper {

	public KolanotInvoiceRequestHelper(
		HttpServletRequest httpServletRequest) {

		super(httpServletRequest);

		Object portletRequest = httpServletRequest.getAttribute(
			JavaConstants.JAVAX_PORTLET_REQUEST);

		Object portletResponse = httpServletRequest.getAttribute(
			JavaConstants.JAVAX_PORTLET_RESPONSE);

		if (!(portletRequest instanceof RenderRequest) ||
			!(portletResponse instanceof RenderResponse)) {

			throw new IllegalArgumentException();
		}

		_renderRequest = (RenderRequest)portletRequest;
		_renderResponse = (RenderResponse)portletResponse;
	}

	public RenderRequest getRenderRequest() {
		return _renderRequest;
	}

	public RenderResponse getRenderResponse() {
		return _renderResponse;
	}

	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
}
