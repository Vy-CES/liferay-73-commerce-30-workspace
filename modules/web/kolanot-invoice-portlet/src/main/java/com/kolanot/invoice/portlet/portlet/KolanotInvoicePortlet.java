package com.kolanot.invoice.portlet.portlet;

import com.kolanot.invoice.portlet.constants.KolanotInvoicePortletKeys;
import com.kolanot.invoice.portlet.internal.display.context.KolanotInvoiceDisplayContext;
import com.kolanot.service.model.KolanotInvoice;
import com.kolanot.service.service.KolanotInvoiceLineLocalService;
import com.kolanot.service.service.KolanotInvoiceLocalService;
import com.liferay.commerce.account.service.CommerceAccountService;
import com.liferay.commerce.currency.service.CommerceCurrencyLocalService;
import com.liferay.commerce.payment.service.CommercePaymentMethodGroupRelLocalService;
import com.liferay.commerce.product.service.CommerceChannelLocalService;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Vy
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Kolanot Invoice",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + KolanotInvoicePortletKeys.KOLANOTINVOICE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class KolanotInvoicePortlet extends MVCPortlet {

	public void addInvoice(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(KolanotInvoice.class.getName(), request);

		long invoiceId = ParamUtil.getLong(request, "invoiceId");
		long commerceOrderId = ParamUtil.getLong(request, "commerceOrderId");

		if (invoiceId > 0) {

//			try {
//
//				_kolanotInvoiceLocalService.updateKolanotInvoice(invoiceId, commerceOrderId, serviceContext);
//
//				response.setRenderParameter("invoiceId", Long.toString(invoiceId));
//
//			} catch (Exception e) {
//
//				PortalUtil.copyRequestParameters(request, response);
//
//				response.setRenderParameter("mvcPath", "/add_invoice.jsp");
//			}

		} else {

			try {
				KolanotInvoice invoice = _kolanotInvoiceLocalService.addKolanotInvoice(
						commerceOrderId, serviceContext);

				response.setRenderParameter("invoiceId", String.valueOf(invoice.getInvoiceId()));

				SessionMessages.add(request, "invoiceAdded");

			} catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath", "/add_invoice.jsp");
			}
		}

		request.setAttribute("invoiceId", invoiceId);
	}

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					KolanotInvoice.class.getName(), renderRequest);

			long groupId = serviceContext.getScopeGroupId();

	        long invoiceId = ParamUtil.getLong(renderRequest, "invoiceId", 0);

			KolanotInvoiceDisplayContext sapphireInvoiceDisplayContext =
					new KolanotInvoiceDisplayContext(
						_portal.getHttpServletRequest(renderRequest), renderRequest,
						renderResponse, _kolanotInvoiceLocalService,
						_commerceOrderLocalService, _commerceCurrencyLocalService,
						_portal, _commercePaymentMethodGroupRelLocalService,
						_commerceChannelLocalService, _commerceAccountService,
						_groupLocalService,
						_sapphireInvoiceLineLocalService);
			
			renderRequest.setAttribute("invoiceId", invoiceId);
			renderRequest.setAttribute("groupId", groupId);

			renderRequest.setAttribute(
					WebKeys.PORTLET_DISPLAY_CONTEXT, sapphireInvoiceDisplayContext);
			super.render(renderRequest, renderResponse);
		}
		catch(Exception e) {
			throw new PortletException(e);
		}
	}

	@Reference
	private CommerceCurrencyLocalService _commerceCurrencyLocalService;

	@Reference
	private CommerceOrderLocalService _commerceOrderLocalService;

	@Reference
	private CommercePaymentMethodGroupRelLocalService
		_commercePaymentMethodGroupRelLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private KolanotInvoiceLocalService
		_kolanotInvoiceLocalService;

	@Reference
	private CommerceChannelLocalService _commerceChannelLocalService;

	@Reference
	private CommerceAccountService _commerceAccountService;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private KolanotInvoiceLineLocalService _sapphireInvoiceLineLocalService;
}