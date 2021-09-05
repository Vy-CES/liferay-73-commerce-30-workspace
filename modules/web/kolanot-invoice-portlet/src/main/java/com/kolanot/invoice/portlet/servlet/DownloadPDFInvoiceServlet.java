package com.kolanot.invoice.portlet.servlet;

import com.kolanot.service.model.KolanotInvoice;
import com.kolanot.service.service.InvoiceGeneratorLocalService;
import com.kolanot.service.service.KolanotInvoiceLocalService;
import com.liferay.commerce.account.model.CommerceAccount;
import com.liferay.commerce.account.service.CommerceAccountLocalService;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.util.PortalInstances;
import com.liferay.portal.util.PropsValues;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "osgi.http.whiteboard.context.path=/",
		"osgi.http.whiteboard.servlet.name=com.kolanot.invoice.portlet.servlet.DownloadPDFInvoiceServlet",
		"osgi.http.whiteboard.servlet.pattern=/"
				+ DownloadPDFInvoiceServlet.KOLANOT_INVOICE_PDF_GENERATOR_SERVLET_PATH }, service = Servlet.class)
public class DownloadPDFInvoiceServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String KOLANOT_INVOICE_PDF_GENERATOR_SERVLET_PATH = "invoice-pdf-generator";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HERERERERER!!!!!!");

		File invoicePDFFile;
		try {
			long invoiceId = ParamUtil.getLong(req, "invoiceId");

			System.out.println("invoiceId: " + invoiceId);

			User user = _portal.getUser(req);

			KolanotInvoice kolanotInvoice = _kolanotInvoiceLocalService.getKolanotInvoice(invoiceId);

			CommerceOrder commerceOrder = _commerceOrderLocalService
					.getCommerceOrder(kolanotInvoice.getCommerceOrderId());

			CommerceAccount commerceAccount = _commerceAccountLocalService.getCommerceAccount(user.getUserId(),
					commerceOrder.getCommerceAccountId());

			if (commerceAccount == null && !_isOmniadmin(user)) {
				processPrincipalException(new PrincipalException("User don't have permission"), user, req, resp);
			}

			invoicePDFFile = _invoiceGeneratorLocalService.getInvoicePDFFile(kolanotInvoice);
			FileInputStream inStream = new FileInputStream(invoicePDFFile);

			String fileName = invoicePDFFile.getName();
			long contentLength = Files.size(invoicePDFFile.toPath());
			String contentType = MimeTypesUtil.getContentType(fileName);

			ServletResponseUtil.sendFile(req, resp, invoicePDFFile.getName(), inStream, contentLength, contentType,
					HttpHeaders.CONTENT_DISPOSITION_ATTACHMENT);
		} catch (Exception exception) {
			PortalUtil.sendError(exception, req, resp);
		}

	}

	protected void processPrincipalException(Throwable throwable, User user, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException, ServletException {

		if (!user.isDefaultUser()) {
			PortalUtil.sendError(HttpServletResponse.SC_UNAUTHORIZED, (Exception) throwable, httpServletRequest,
					httpServletResponse);

			return;
		}

		String redirect = PortalUtil.getPathMain() + "/portal/login";

		redirect = HttpUtil.addParameter(redirect, "redirect", PortalUtil.getCurrentURL(httpServletRequest));

		httpServletResponse.sendRedirect(redirect);
	}

	public boolean _isOmniadmin(User user) {
		try {
			if (PropsValues.OMNIADMIN_USERS.length > 0) {
				for (int i = 0; i < PropsValues.OMNIADMIN_USERS.length; i++) {
					if (PropsValues.OMNIADMIN_USERS[i] == user.getUserId()) {
						if (user.getCompanyId() != PortalInstances.getDefaultCompanyId()) {

							return false;
						}

						return true;
					}
				}

				return false;
			}

			if (user.isDefaultUser() || (user.getCompanyId() != PortalInstances.getDefaultCompanyId())) {

				return false;
			}

			return RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleConstants.ADMINISTRATOR,
					true);
		} catch (Exception exception) {
			_log.error("Unable to check if a user is an omniadmin", exception);

			return false;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(DownloadPDFInvoiceServlet.class);

	@Reference
	private InvoiceGeneratorLocalService _invoiceGeneratorLocalService;

	@Reference
	private KolanotInvoiceLocalService _kolanotInvoiceLocalService;

	@Reference
	private CommerceOrderLocalService _commerceOrderLocalService;

	@Reference
	private CommerceAccountLocalService _commerceAccountLocalService;

	@Reference
	private Portal _portal;
}
