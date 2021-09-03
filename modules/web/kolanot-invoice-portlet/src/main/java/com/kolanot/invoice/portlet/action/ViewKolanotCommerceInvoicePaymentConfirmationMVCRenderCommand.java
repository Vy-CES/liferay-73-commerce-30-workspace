package com.kolanot.invoice.portlet.action;

import com.kolanot.invoice.portlet.constants.KolanotInvoicePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

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
		"mvc.command.name=viewKolanotCommerceInvoicePaymentConfirmation"
	},
	service = MVCRenderCommand.class
)
public class ViewKolanotCommerceInvoicePaymentConfirmationMVCRenderCommand
	implements MVCRenderCommand {

		@Override
		public String render(
			RenderRequest renderRequest, RenderResponse renderResponse) {

			return "/invoice_payment_results.jsp";
		}
}
