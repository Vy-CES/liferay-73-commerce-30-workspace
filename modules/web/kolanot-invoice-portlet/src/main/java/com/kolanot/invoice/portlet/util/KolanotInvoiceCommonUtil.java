package com.kolanot.invoice.portlet.util;

import com.kolanot.invoice.portlet.constants.KolanotInvoicePortletKeys;
import com.kolanot.service.model.KolanotInvoice;
import com.liferay.commerce.account.model.CommerceAccountGroup;
import com.liferay.commerce.account.service.CommerceAccountGroupLocalServiceUtil;
import com.liferay.commerce.constants.CommercePortletKeys;
import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.currency.service.CommerceCurrencyLocalServiceUtil;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CommerceChannelLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Dinh Thai
 */
public class KolanotInvoiceCommonUtil {
	private static final String ACCOUNT_HOLDER_NET_7_DAYS = "NET7DAYS";
	private static final String ACCOUNT_HOLDER_30_DAYS_EOM = "30DAYSEOM";
	private static final String ACCOUNT_HOLDER_NET_60_DAYS = "NET60DAYS";

	public static String getCommerceChannelCurrencyCode(
		ThemeDisplay themeDisplay) {

		CommerceChannel commerceChannel = getCurrentCommerceChannel(
			themeDisplay);

		if (commerceChannel != null) {
			return commerceChannel.getCommerceCurrencyCode();
		}

		return StringPool.BLANK;
	}

	public static CommerceChannel getCurrentCommerceChannel(
		ThemeDisplay themeDisplay) {

		return CommerceChannelLocalServiceUtil.
			fetchCommerceChannelBySiteGroupId(themeDisplay.getSiteGroupId());
	}

	public static Group getCurrentGroup(ThemeDisplay themeDisplay)
		throws PortalException {

		CommerceChannel commerceChannel = getCurrentCommerceChannel(
			themeDisplay);

		return GroupLocalServiceUtil.loadGetGroup(
			commerceChannel.getCompanyId(),
			String.valueOf(commerceChannel.getCommerceChannelId()));
	}

	public static long getCurrentGroupId(ThemeDisplay themeDisplay)
		throws PortalException {

		Group group = getCurrentGroup(themeDisplay);

		return group.getGroupId();
	}

	public static CommerceCurrency getDefaultCommerceCurrency(long companyId) {
		return CommerceCurrencyLocalServiceUtil.fetchPrimaryCommerceCurrency(
			companyId);
	}

	public static String getInvoiceDetailURL(
		long invoiceId, ThemeDisplay themeDisplay, boolean isStatement) {

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		PortletURL portletURL;

		if (isStatement) {
			portletURL = PortletURLFactoryUtil.create(
				themeDisplay.getRequest(),
				KolanotInvoicePortletKeys.KOLANOTINVOICE,
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

			try {
				portletURL.setPortletMode(PortletMode.VIEW);
				portletURL.setWindowState(LiferayWindowState.MAXIMIZED);
			}
			catch (WindowStateException e) {
				_log.error(e.getMessage());
			}
			catch (PortletModeException e) {
				_log.error(e.getMessage());
			}
		}
		else {
			portletURL = PortletURLFactoryUtil.create(
				themeDisplay.getRequest(), portletDisplay.getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		}

		portletURL.setParameter(
			"mvcRenderCommandName", "viewKolanotInvoice");
		portletURL.setParameter("invoiceId", String.valueOf(invoiceId));

		return portletURL.toString();
	}

	public static BigDecimal getMultiBalanceDue(
			List<KolanotInvoice> sapphireCommerceInvoices) {

		if (!sapphireCommerceInvoices.isEmpty()) {
			return sapphireCommerceInvoices
					.stream()
					.map(x -> x.getBalanceDue())
					.reduce(BigDecimal.ZERO, BigDecimal::add);
		}

		return BigDecimal.ZERO;
	}

	public static BigDecimal getMultiSubtotal(
		List<KolanotInvoice> sapphireCommerceInvoices) {

		BigDecimal multiSubtotal = new BigDecimal(0);

		for (KolanotInvoice sapphireCommerceInvoice :
				sapphireCommerceInvoices) {

			multiSubtotal = multiSubtotal.add(
				sapphireCommerceInvoice.getSubTotal());
		}

		return multiSubtotal;
	}

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

	public static String getPaymentHistoryDetailPortletURL(
		ThemeDisplay themeDisplay, String paymentTransactionId) {

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		PortletURL portletURL = PortletURLFactoryUtil.create(
			themeDisplay.getRequest(), portletDisplay.getId(),
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);

		portletURL.setParameter(
			"mvcRenderCommandName", "viewSapphireInvoiceStatementDetail");
		portletURL.setParameter(
			"paymentTransactionId", String.valueOf(paymentTransactionId));

		return portletURL.toString();
	}

	public static OrderByComparator<KolanotInvoice>
		getKolanotInvoiceByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<KolanotInvoice> orderByComparator = null;

		return orderByComparator;
	}

	public static Sort getKolanotInvoiceBySort(
		String orderByCol, String orderByType) {

		boolean reverse = true;

		if (orderByType.equals("asc")) {
			reverse = false;
		}

		Sort sort = null;

		if (orderByCol.equals("status")) {
			sort = SortFactoryUtil.create(
					Field.STATUS + "_Number_sortable", Sort.INT_TYPE, reverse);
		}
		else if (orderByCol.equals("modified-date")) {
			sort = SortFactoryUtil.create(
					Field.MODIFIED_DATE + "_sortable", reverse);
		}
		return sort;
	}

	public static BigDecimal round(BigDecimal value, long companyId) {
		if (value == null) {
			value = BigDecimal.ZERO;
		}

		CommerceCurrency commerceCurrency = getDefaultCommerceCurrency(
			companyId);

		if (commerceCurrency == null) {
			return value;
		}

		return commerceCurrency.round(value);
	}

	private static PortletURL _getPortletURL(
			HttpServletRequest httpServletRequest, String portletId)
		throws PortalException {

		long groupId = PortalUtil.getScopeGroupId(httpServletRequest);

		long plid = PortalUtil.getPlidFromPortletId(groupId, portletId);

		if (plid > 0) {
			return PortletURLFactoryUtil.create(
				httpServletRequest, portletId, plid,
				PortletRequest.ACTION_PHASE);
		}

		return PortletURLFactoryUtil.create(
			httpServletRequest, portletId, PortletRequest.ACTION_PHASE);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		KolanotInvoiceCommonUtil.class);

	public static BigDecimal getMultiPaidSum(List<KolanotInvoice> sapphireCommerceInvoices) {
		BigDecimal multiPaidSum = new BigDecimal(0);

		for (KolanotInvoice sapphireCommerceInvoice :
				sapphireCommerceInvoices) {

			multiPaidSum = multiPaidSum.add(
					sapphireCommerceInvoice.getPaidSum());
		}

		return multiPaidSum;
	}
}
