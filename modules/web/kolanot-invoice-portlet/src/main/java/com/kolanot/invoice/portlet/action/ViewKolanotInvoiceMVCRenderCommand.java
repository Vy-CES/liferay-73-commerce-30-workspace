package com.kolanot.invoice.portlet.action;

import com.kolanot.invoice.portlet.constants.KolanotInvoicePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Vy
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + KolanotInvoicePortletKeys.KOLANOTINVOICE,
		"mvc.command.name=viewKolanotInvoice"
	},
	service = MVCRenderCommand.class
)
public class ViewKolanotInvoiceMVCRenderCommand implements MVCRenderCommand  {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		long invoiceId = ParamUtil.getLong(renderRequest, "invoiceId");
		
		renderRequest.setAttribute("invoiceId", invoiceId);
		
		return "/view_invoice.jsp";
	}

}
