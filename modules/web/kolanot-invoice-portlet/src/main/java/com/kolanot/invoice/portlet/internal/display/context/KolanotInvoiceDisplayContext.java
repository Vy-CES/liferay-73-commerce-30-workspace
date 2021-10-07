package com.kolanot.invoice.portlet.internal.display.context;

import com.kolanot.invoice.portlet.util.KolanotInvoiceCommonUtil;
import com.kolanot.service.model.KolanotInvoice;
import com.kolanot.service.service.KolanotInvoiceLineLocalService;
import com.kolanot.service.service.KolanotInvoiceLocalService;
import com.kolanot.service.service.KolanotInvoiceLocalServiceUtil;
import com.liferay.commerce.account.model.CommerceAccount;
import com.liferay.commerce.account.service.CommerceAccountService;
import com.liferay.commerce.constants.CommerceOrderConstants;
import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.currency.service.CommerceCurrencyLocalService;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.payment.model.CommercePaymentMethodGroupRel;
import com.liferay.commerce.payment.service.CommercePaymentMethodGroupRelLocalService;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CommerceChannelLocalService;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LinkedHashMapBuilder;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.TextFormatter;
import com.liferay.portal.kernel.util.URLCodec;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Vy Bui
 */
public class KolanotInvoiceDisplayContext extends KolanotInvoiceBaseDisplayContext {
	public KolanotInvoiceDisplayContext(
            HttpServletRequest httpServletRequest, RenderRequest renderRequest,
            RenderResponse renderResponse,
            KolanotInvoiceLocalService kolanotInvoiceLocalService,
            CommerceOrderLocalService commerceOrderLocalService,
            CommerceCurrencyLocalService commerceCurrencyLocalService,
            Portal portal, CommercePaymentMethodGroupRelLocalService commercePaymentMethodGroupRelLocalService,
            CommerceChannelLocalService commerceChannelLocalService,
            CommerceAccountService commerceAccountService, GroupLocalService groupLocalService,
            KolanotInvoiceLineLocalService kolanotInvoiceLineLocalService) {

		super(httpServletRequest, renderRequest, renderResponse);

        _kolanotInvoiceLocalService =
                kolanotInvoiceLocalService;
        _commerceOrderLocalService = commerceOrderLocalService;
        _commerceCurrencyLocalService = commerceCurrencyLocalService;
        _commercePaymentMethodGroupRelLocalService = commercePaymentMethodGroupRelLocalService;
        _commerceChannelLocalService = commerceChannelLocalService;
        _commerceAccountService = commerceAccountService;
        _groupLocalService = groupLocalService;
        _portal = portal;
	}

	 public PortletURL getPortletURL() {
			PortletURL portletURL = _liferayPortletResponse.createRenderURL();

			String redirect = ParamUtil.getString(_httpServletRequest, "redirect");

			if (Validator.isNotNull(redirect)) {
				portletURL.setParameter("redirect", redirect);
			}

			long kolanotInvoiceId = ParamUtil.getLong(
				_httpServletRequest, "kolanotInvoiceId");

			if (kolanotInvoiceId > 0) {
				portletURL.setParameter(
					"kolanotInvoiceId", String.valueOf(kolanotInvoiceId));
			}

			return portletURL;
		}

	 	public PortletURL commerceOrderItemGetPortletURL() {

	 			PortletURL portletURL = _liferayPortletResponse.createRenderURL();

	 			String delta = ParamUtil.getString(_httpServletRequest, "delta");

	 			if (Validator.isNotNull(delta)) {
	 				portletURL.setParameter("delta", delta);
	 			}

	 			String deltaEntry = ParamUtil.getString(
	 				_httpServletRequest, "deltaEntry");

	 			if (Validator.isNotNull(deltaEntry)) {
	 				portletURL.setParameter("deltaEntry", deltaEntry);
	 			}

	 			return portletURL;
	 	}
	    
	    public String getClearResultsURL() {
	        PortletURL clearResultsURL = _getPortletURL();

	        clearResultsURL.setParameter("keywords", StringPool.BLANK);

	        return clearResultsURL.toString();
	    }

		public CommerceAccount getCurrentCommerceAccount() throws PortalException {
			long commerceAccountId = ParamUtil.getLong(
					_kolanotInvoiceRequestHelper.getRequest(), "commerceAccountId");

			if (commerceAccountId > 0) {
				return _commerceAccountService.getCommerceAccount(
					commerceAccountId);
			}

			return getCurrentAccount();
		}

		public List<String> getTransactionIdsByInvoiceId(long invoiceId) throws PortalException {
	        List<String> paymentTransactionIds = new ArrayList<>();
	        
	        KolanotInvoice invoice = _kolanotInvoiceLocalService.getKolanotInvoice(invoiceId);

	        List<KolanotInvoice> invoices = new ArrayList<KolanotInvoice>();
	        invoices.add(invoice);

	        if (!invoices.isEmpty()) {
	            paymentTransactionIds = invoices
	                    .stream()
	                    .map(x -> x.getTransactionId())
	                    .collect(Collectors.toList());
	        }

	        return paymentTransactionIds;
	    }

		public List<CommerceOrder> getPendingCommerceOrderByAccountId(long commerceAccountId, long groupId) throws PortalException {
			List<CommerceOrder> accountOrders = _commerceOrderLocalService.getCommerceOrdersByCommerceAccountId(commerceAccountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			List<CommerceOrder> pendingOrders = new ArrayList<CommerceOrder>();

			Iterator<CommerceOrder> iter = accountOrders.iterator();
			while(iter.hasNext()){
				CommerceOrder order = iter.next();
				
				System.out.println("get order status: " + order.getOrderStatus());
				System.out.println("order status constant: " + CommerceOrderConstants.ORDER_STATUS_PENDING);
			    if(order.getOrderStatus() == CommerceOrderConstants.ORDER_STATUS_PENDING) {
			    	pendingOrders.add(order);
			    }
			}

			return pendingOrders;
		}

	    public CommerceOrder getCommerceOrder(long orderId) throws PortalException {
	        if (_commerceOrder != null) {
	            return _commerceOrder;
	        }

	        _commerceOrder = _commerceOrderLocalService.getCommerceOrder(orderId);

	        return _commerceOrder;
	    }

	    public long getCommerceOrderId() {
	        if (_commerceOrder == null) {
	            return 0;
	        }

	        return _commerceOrder.getCommerceOrderId();
	    }

	    public PortletURL getCommerceOrderItemsPortletURL() {
	        LiferayPortletResponse liferayPortletResponse =
	                _kolanotInvoiceRequestHelper.getLiferayPortletResponse();

	        PortletURL portletURL = liferayPortletResponse.createRenderURL();

	        portletURL.setParameter("mvcRenderCommandName", "editCommerceOrder");
	        portletURL.setParameter(
	                "commerceOrderId", String.valueOf(getCommerceOrderId()));
	        portletURL.setParameter(
	                "screenNavigationCategoryKey",
	                "general");

	        String redirect = ParamUtil.getString(
	                _kolanotInvoiceRequestHelper.getRequest(), "redirect");

	        if (Validator.isNotNull(redirect)) {
	            portletURL.setParameter("redirect", redirect);
	        }

	        return portletURL;
	    }

	    public String getDefaultCommerceCurrencyCode() {
	        CommerceCurrency commerceCurrency = getDefaultCommerceCurrency();

	        if (commerceCurrency == null) {
	            return StringPool.BLANK;
	        }

	        return commerceCurrency.getCode();
	    }

	    public String getDisplayStyle() {
	        if (_displayStyle != null) {
	            return _displayStyle;
	        }

	        _displayStyle = ParamUtil.getString(
	                _renderRequest, "displayStyle", "list");

	        return _displayStyle;
	    }

	    public List<DropdownItem> getFilterItemsDropdownItems() {
	        return DropdownItemListBuilder.addGroup(
	                dropdownGroupItem -> {
	                    dropdownGroupItem.setDropdownItems(
	                            _getFilterNavigationDropdownItems());
	                    dropdownGroupItem.setLabel(
	                            LanguageUtil.get(_httpServletRequest, "status"));
	                }
	        ).addGroup(
	                dropdownGroupItem -> {
	                    dropdownGroupItem.setDropdownItems(_getOrderByDropdownItems());
	                    dropdownGroupItem.setLabel(
	                            LanguageUtil.get(_httpServletRequest, "order-by"));
	                }
	        ).build();
	    }

	    public String getOrderByType() {
	        if (Validator.isNotNull(_orderByType)) {
	            return _orderByType;
	        }

	        _orderByType = ParamUtil.getString(
	                _httpServletRequest, "orderByType", "asc");

	        return _orderByType;
	    }

		public String getOrderByCol() {
			if (_orderByCol != null) {
				return _orderByCol;
			}

			_orderByCol = ParamUtil.getString(_renderRequest, "orderByCol", "status");

			return _orderByCol;
		}

	    public KolanotInvoice getKolanotInvoice()
	            throws PortalException {

	        if (_kolanotInvoice != null) {
	            return _kolanotInvoice;
	        }

	        long invoiceId = ParamUtil.getLong(
	                _kolanotInvoiceRequestHelper.getRequest(), "invoiceId");

	        if (invoiceId > 0) {
	            _kolanotInvoice =
	                    _kolanotInvoiceLocalService.getKolanotInvoice(
	                            GetterUtil.getLong(invoiceId));
	        }

	        return _kolanotInvoice;
	    }

	    public List<KolanotInvoice> getMultiKolanotInvoice()
	            throws PortalException {

	        List<KolanotInvoice> kolanotInvoices = new ArrayList<>();

	        String[] invoiceIds = ParamUtil.getStringValues(_kolanotInvoiceRequestHelper.getRequest(), "invoiceIds");

	        if (invoiceIds.length > 0) {
	            for (String invoiceId : invoiceIds) {
	                KolanotInvoice kolanotInvoice =
	                        _kolanotInvoiceLocalService.getKolanotInvoice(
	                                GetterUtil.getLong(invoiceId));
	                kolanotInvoices.add(kolanotInvoice);
	            }
	        }

	        return kolanotInvoices;
	    }

	    public String getSearchActionURL() {
	        PortletURL portletURL = _getPortletURL();

	        return portletURL.toString();
	    }

	    public SearchContainer<KolanotInvoice> getSearchContainer(CommerceAccount commerceAccount)
	            throws PortalException {

	        if (_searchContainer != null) {

	            return _searchContainer;
	        }

	        if (commerceAccount == null) {
	        	return new SearchContainer<>(
	                    _kolanotInvoiceRequestHelper.getLiferayPortletRequest(),
	                    _getPortletURL(), null, "could-not-find-invoices-with-no-selected-commerce-account");
	        }

	        _searchContainer = new SearchContainer<>(
	                _kolanotInvoiceRequestHelper.getLiferayPortletRequest(), null, null, SearchContainer.DEFAULT_CUR_PARAM, 8,
	                _getPortletURL(), null, "there-are-no-invoices");

	        setOrderByColAndType(
	                KolanotInvoice.class, _searchContainer, "status",
	                "desc");

	        OrderByComparator<KolanotInvoice> orderByComparator =
	                KolanotInvoiceCommonUtil.
	                        getKolanotInvoiceByComparator(
	                                _searchContainer.getOrderByCol(),
	                                _searchContainer.getOrderByType());

	        _searchContainer.setOrderByComparator(orderByComparator);

	        _searchContainer.setRowChecker(
	                new EmptyOnClickRowChecker(
	                        _kolanotInvoiceRequestHelper.
	                                getLiferayPortletResponse()));

	        Sort sort =
	                KolanotInvoiceCommonUtil.getKolanotInvoiceBySort(
	                        _searchContainer.getOrderByCol(),
	                        _searchContainer.getOrderByType());

	        Sort sortByModifiedDate =
	                KolanotInvoiceCommonUtil.getKolanotInvoiceBySort(
	                        "modified-date",
	                        _searchContainer.getOrderByType());

	        ThemeDisplay themeDisplay =
	                (ThemeDisplay)
	                        _kolanotInvoiceRequestHelper.getLiferayPortletRequest(
	                        ).getAttribute(
	                                WebKeys.THEME_DISPLAY
	                        );

	        SearchContext searchContext = buildSearchContext(
	                themeDisplay.getCompanyId(), commerceAccount.getCommerceAccountId(),
	                _getKeywords(), WorkflowConstants.STATUS_ANY,
	                _searchContainer.getStart(), _searchContainer.getEnd(), sort, sortByModifiedDate);

	        BaseModelSearchResult<KolanotInvoice> baseModelSearchResult =
	                searchKolanotInvoices(searchContext);

	        _searchContainer.setTotal(baseModelSearchResult.getLength());
	        _searchContainer.setResults(baseModelSearchResult.getBaseModels());

	        return _searchContainer;
	    }

	    public String getSortingURL() {
	        PortletURL sortingURL = _getPortletURL();

	        sortingURL.setParameter(
	                "orderByType",
	                Objects.equals(getOrderByType(), "asc") ? "desc" : "asc");

	        return sortingURL.toString();
	    }

	    public String getSearchContainerId() {
			return "resource";
		}

	    public BigDecimal round(BigDecimal value) {

	        return KolanotInvoiceCommonUtil.round(
	                value, _kolanotInvoiceRequestHelper.getCompanyId());
	    }

	    public long getCurrentGroupId() throws PortalException {
	        ThemeDisplay themeDisplay =
	                (ThemeDisplay)
	                        _kolanotInvoiceRequestHelper.getLiferayPortletRequest(
	                        ).getAttribute(
	                                WebKeys.THEME_DISPLAY
	                        );

	        return KolanotInvoiceCommonUtil.getCurrentGroupId(themeDisplay);
	    }

	    public String getCommerceChannelCurrencyCode() {
	        ThemeDisplay themeDisplay =
	                (ThemeDisplay)
	                        _kolanotInvoiceRequestHelper.getLiferayPortletRequest(
	                        ).getAttribute(
	                                WebKeys.THEME_DISPLAY
	                        );

	        return KolanotInvoiceCommonUtil.getCommerceChannelCurrencyCode(themeDisplay);
	    }

	    public BigDecimal getMultiSubtotal(List<KolanotInvoice> kolanotInvoices) {

	        return KolanotInvoiceCommonUtil.getMultiSubtotal(kolanotInvoices);
	    }

	    public BigDecimal getMultiBalanceDue(List<KolanotInvoice> kolanotInvoices) throws PortalException {
	        if (this.multiBalanceDue != null) {
	            return this.multiBalanceDue;
	        }

	        BigDecimal multiBalanceDue = KolanotInvoiceCommonUtil.getMultiBalanceDue(kolanotInvoices);

	        this.multiBalanceDue = multiBalanceDue;
	        return this.multiBalanceDue;
	    }

	    public BigDecimal getMultiBalanceDueWithOutCreditNote(
	            List<KolanotInvoice> kolanotInvoices) throws PortalException {

	        return KolanotInvoiceCommonUtil.
	                getMultiBalanceDue(kolanotInvoices);
	    }

	    public BaseModelSearchResult<KolanotInvoice> searchKolanotInvoices(SearchContext searchContext)
	            throws PortalException {

	        Indexer<KolanotInvoice> indexer =
	                IndexerRegistryUtil.nullSafeGetIndexer(
	                        KolanotInvoice.class);

	        for (int i = 0; i < 10; i++) {
	            Hits hits = indexer.search(searchContext);

	            List<KolanotInvoice> kolanotInvoices =
	                    getKolanotInvoices(hits);

	            if (kolanotInvoices != null) {
	                return new BaseModelSearchResult<>(
	                        kolanotInvoices, hits.getLength());
	            }
	        }

	        throw new SearchException(
	                "Unable to fix the search index after 10 attempts");
	    }

	    public boolean hasViewInvoicePermission(long createdByAccountId)
			throws PortalException {

			CommerceAccount currentAccount = getCurrentAccount();
			return currentAccount.getCommerceAccountId() == createdByAccountId;
	    }

	    protected CommerceAccount getCurrentAccount() throws PortalException {
			return _commerceContext.getCommerceAccount();
		}
	   
	    protected List<KolanotInvoice> getKolanotInvoices(
	            Hits hits)
	            throws PortalException {

	        if (Validator.isNotNull(hits)) {
	            List<Document> documents = hits.toList();

	            List<KolanotInvoice> kolanotInvoices = new ArrayList<>(
	                    documents.size());

	            for (Document document : documents) {
	                long kolanotInvoiceId = GetterUtil.getLong(
	                        document.get(Field.ENTRY_CLASS_PK));

	                KolanotInvoice kolanotInvoice =
	                        KolanotInvoiceLocalServiceUtil.
	                                fetchKolanotInvoice(kolanotInvoiceId);

	                if (kolanotInvoice == null) {
	                    kolanotInvoices = null;

	                    Indexer<KolanotInvoice> indexer =
	                            IndexerRegistryUtil.getIndexer(
	                                    KolanotInvoice.class);

	                    long companyId = GetterUtil.getLong(
	                            document.get(Field.COMPANY_ID));

	                    indexer.delete(companyId, document.getUID());
	                } else if (kolanotInvoices != null) {
	                    kolanotInvoices.add(kolanotInvoice);
	                }
	            }

	            return kolanotInvoices;
	        }

	        return null;
	    }

	    protected <T> void setOrderByColAndType(
	            Class<T> clazz, SearchContainer<T> searchContainer,
	            String defaultOrderByCol, String defaultOrderByType) {

	        HttpServletRequest httpServletRequest =
	                _kolanotInvoiceRequestHelper.getRequest();

	        String orderByCol = ParamUtil.getString(
	                httpServletRequest, searchContainer.getOrderByColParam());
	        String orderByType = ParamUtil.getString(
	                httpServletRequest, searchContainer.getOrderByTypeParam());

	        String namespace = _kolanotInvoiceRequestHelper.getPortletId();
	        String prefix = TextFormatter.format(
	                clazz.getSimpleName(), TextFormatter.K);

	        if (Validator.isNotNull(orderByCol) &&
	                Validator.isNotNull(orderByType)) {

	            _portalPreferences.setValue(
	                    namespace, prefix + "-order-by-col", orderByCol);
	            _portalPreferences.setValue(
	                    namespace, prefix + "-order-by-type", orderByType);
	        } else {
	            orderByCol = _portalPreferences.getValue(
	                    namespace, prefix + "-order-by-col", defaultOrderByCol);
	            orderByType = _portalPreferences.getValue(
	                    namespace, prefix + "-order-by-type", defaultOrderByType);
	        }

	        searchContainer.setOrderByCol(orderByCol);
	        searchContainer.setOrderByType(orderByType);
	    }

	    public CommerceCurrency getDefaultCommerceCurrency() {
	        CommerceCurrency commerceCurrency =
	                _commerceCurrencyLocalService.fetchPrimaryCommerceCurrency(
	                        _kolanotInvoiceRequestHelper.getCompanyId());

	        return commerceCurrency;
	    }

	    private List<DropdownItem> _getFilterNavigationDropdownItems() {
	        return DropdownItemListBuilder.add(
	                dropdownItem -> {
	                    dropdownItem.setActive(true);
	                    dropdownItem.setHref(_renderResponse.createRenderURL());
	                    dropdownItem.setLabel(
	                            LanguageUtil.get(_httpServletRequest, "all"));
	                }
	        ).build();
	    }

	    private String _getKeywords() {
	        if (_keywords != null) {
	            return _keywords;
	        }

	        _keywords = ParamUtil.getString(_httpServletRequest, "keywords");

	        return _keywords;
	    }

	    private List<DropdownItem> _getOrderByDropdownItems() {
	        return DropdownItemListBuilder.add(
	                dropdownItem -> {
	                    dropdownItem.setActive(
	                            Objects.equals(getOrderByCol(), "status"));
	                    dropdownItem.setHref(
	                            _getPortletURL(), "orderByCol", "status");
	                    dropdownItem.setLabel(
	                            LanguageUtil.get(_httpServletRequest, "status"));
	                }
	        ).build();
	    }

	    private PortletURL _getPortletURL() {
	        PortletURL portletURL = _renderResponse.createRenderURL();

	        portletURL.setParameter("mvcPath", "/view.jsp");

	        String keywords = _getKeywords();

	        if (Validator.isNotNull(keywords)) {
	            portletURL.setParameter("keywords", keywords);
	        }

	        portletURL.setParameter("displayStyle", getDisplayStyle());
	        portletURL.setParameter("orderByCol", getOrderByCol());
	        portletURL.setParameter("orderByType", getOrderByType());

	        return portletURL;
	    }

	    private SearchContext buildSearchContext(
	            long companyId, long commerceAccountId, String keywords, int status, int start,
	            int end, Sort... sorts) {

	        SearchContext searchContext = new SearchContext();

	        searchContext.setAttributes(
	                HashMapBuilder.<String, Serializable>put(
	                        Field.ENTRY_CLASS_PK, keywords
	                ).put(
	                        Field.STATUS, status
	                ).put(
	                        Field.TITLE, keywords
	                ).put(
	                        "params",
	                        LinkedHashMapBuilder.<String, Object>put(
	                                "keywords", keywords
	                        ).build()
	                ).put(
	                		"commerceAccountId", commerceAccountId)
	                .build());

	        searchContext.setCompanyId(companyId);
	        searchContext.setEnd(end);

	        if (Validator.isNotNull(keywords)) {
	            searchContext.setKeywords(keywords);
	        }

	        if (sorts != null) {
	            searchContext.setSorts(sorts);
	        }

	        searchContext.setStart(start);

	        QueryConfig queryConfig = searchContext.getQueryConfig();

	        queryConfig.setHighlightEnabled(false);
	        queryConfig.setScoreEnabled(false);

	        return searchContext;
	    }

	    public String getOrderManagementPortletURL(long commerceOrderId) {
	        ThemeDisplay themeDisplay =
	                (ThemeDisplay)
	                        _kolanotInvoiceRequestHelper.getLiferayPortletRequest(
	                        ).getAttribute(
	                                WebKeys.THEME_DISPLAY
	                        );

	        String viewURL = "";

	        try {
	            viewURL = KolanotInvoiceCommonUtil.getOrderViewDetailURL(
	                    String.valueOf(commerceOrderId), themeDisplay);
	        } catch (PortalException e) {
	            _log.error(e.getMessage());
	        }

	        return viewURL;
	    }

	    public List<CommercePaymentMethodGroupRel> getCommercePaymentMethodGroupRels() throws PortalException {
	        long groupId = getCurrentGroupId();

	        return _commercePaymentMethodGroupRelLocalService.getCommercePaymentMethodGroupRels(groupId, true);
	    }

	    public Group getCurrentGroup() throws PortalException {
	        CommerceChannel commerceChannel = _getCurrentCommerceChannel();

	        return _groupLocalService.loadGetGroup(commerceChannel.getCompanyId(),
	                String.valueOf(commerceChannel.getCommerceChannelId()));
	    }

	    private CommerceChannel _getCurrentCommerceChannel() {
	        ThemeDisplay themeDisplay =
	                (ThemeDisplay)
	                        _kolanotInvoiceRequestHelper.getLiferayPortletRequest(
	                        ).getAttribute(
	                                WebKeys.THEME_DISPLAY
	                        );

	        return _commerceChannelLocalService.fetchCommerceChannelBySiteGroupId(themeDisplay.getSiteGroupId());
	    }

	    public String getPaymentServletUrlAgain(List<KolanotInvoice> commerceInvoices, String payAmount) throws Exception {

	        return _getPaymentUrl(commerceInvoices, payAmount);
	    }

	    private String _getPaymentUrl(List<KolanotInvoice> commerceInvoices, String payAmount) throws PortalException {
	        if (!commerceInvoices.isEmpty()) {
	            StringBundler sb = new StringBundler(26);
	            CommerceOrder commerceOrder = _commerceOrderLocalService.getCommerceOrder(commerceInvoices.get(0).getCommerceOrderId());

	            sb.append(_getPortalUrl());
	            sb.append(_getPathModule());
	            sb.append(CharPool.SLASH);
	            sb.append(_getPaymentServletPath());
	            sb.append(CharPool.QUESTION);
	            sb.append("groupId=");
	            sb.append(getCurrentGroupId());
	            sb.append(StringPool.AMPERSAND);
	            
	            sb.append("uuid=");
	            sb.append(commerceOrder.getUuid());
	            sb.append(StringPool.AMPERSAND);
	            
//	            sb.append("commerceOrderId=");
//	            sb.append(commerceInvoices.get(0).getCommerceOrderId());
//	            sb.append(StringPool.AMPERSAND);

	            List<String> invoiceIds = commerceInvoices.stream().map(e -> String.valueOf(e.getInvoiceId())).collect(Collectors.toList());
//
	            sb.append("invoiceIds=");
	            sb.append(String.join(",", invoiceIds));
	            sb.append(StringPool.AMPERSAND);
//	            sb.append("commerceChannelCurrencyCode=");
//	            sb.append(getCommerceChannelCurrencyCode());
//	            sb.append(StringPool.AMPERSAND);
//	            BigDecimal multiBalanceDue = Validator.isBlank(payAmount) ? getMultiBalanceDue(commerceInvoices) : new BigDecimal(payAmount);
//	            sb.append("multiBalanceDue=");
//	            sb.append(multiBalanceDue);
//	            sb.append(StringPool.AMPERSAND);
	            sb.append("nextStep=");
	            sb.append(URLCodec.encodeURL(_getInvoiceConfirmationPaymentUrl(invoiceIds, true)));
	            sb.append(StringPool.AMPERSAND);

//	            BigDecimal multiBalanceDueWithOutCreditNote = getMultiBalanceDueWithOutCreditNote(commerceInvoices);
//
//	            sb.append("creditNoteValue=");
//	            sb.append(multiBalanceDueWithOutCreditNote.doubleValue() >= creditNoteValue.doubleValue() ? creditNoteValue : BigDecimal.ZERO);
//	            sb.append("failedUrl=");
//	            sb.append(URLCodec.encodeURL(_getInvoiceConfirmationPaymentUrl(invoiceIds, false)));
//	            sb.append(StringPool.AMPERSAND);
	            return sb.toString();
	        }

	        return StringPool.BLANK;
	    }


	    public String getPaymentServletUrl(List<KolanotInvoice> commerceInvoices) throws Exception {

	        return _getPaymentUrl(commerceInvoices, StringPool.BLANK);
	    }

	    private String _getInvoiceConfirmationPaymentUrl(List<String> invoiceIds, boolean isSuccess) {
	        LiferayPortletResponse liferayPortletResponse =
	                _kolanotInvoiceRequestHelper.getLiferayPortletResponse();

	        PortletURL portletURL = liferayPortletResponse.createRenderURL();

	        portletURL.setParameter(
	                "mvcRenderCommandName", "viewKolanotInvoice");
	        portletURL.setParameter("invoiceId", String.join(",", invoiceIds));
	        portletURL.setParameter("isSuccess", String.valueOf(isSuccess));

	        return portletURL.toString();
	    }

	    private String _getPathModule() {
	        return _portal.getPathModule();
	    }

	    private String _getPaymentServletPath() {
	        return "commerce-payment";
	    }

	    private String _getPortalUrl() {
	        return _portal.getPortalURL(_httpServletRequest);
	    }

	    public String getInvoicePDFDownloadLink(long fileEntryId) throws PortalException {
	        String downloadLink = "";
	        try {
	            FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
	            downloadLink = DLURLHelperUtil.getDownloadURL(fileEntry, fileEntry.getFileVersion(), null, null);
	        } catch (Exception ex) {
	            _log.error(ex.getMessage());
	        }
	        return downloadLink;
	    }

//	    public String getAccountHolderCreditNoteItemIds(long createdByAccountId, String customerCode) throws PortalException {
//
//	        if (accountHolderCreditNoteIds != null) {
//	            return accountHolderCreditNoteIds;
//	        }
//
//	        CreditNote creditNote = KolanotInvoiceCommonUtil
//	                .getAccountHolderCreditNote(createdByAccountId, customerCode, getCurrentGroupId());
//
//	        if (creditNote != null) {
//	            List<CreditNoteItem> creditNoteItems = creditNote.creditNoteItems;
//	            if (creditNoteItems != null && !creditNoteItems.isEmpty()) {
//	                accountHolderCreditNoteIds = creditNoteItems.stream()
//	                        .map(x -> x.creditNoteId)
//	                        .collect(Collectors.joining(", "));
//	            }
//	        } else {
//	            accountHolderCreditNoteIds = StringPool.BLANK;
//	        }
//
//	        return accountHolderCreditNoteIds;
//	    }
//
//	    public List<String> getPaymentTransactionIdsByInvoiceId(long invoiceId) {
//	        List<String> paymentTransactionIds = new ArrayList<>();
//	        List<SapphirePartialPaymentInvoice> sapphirePartialPaymentInvoices =
//	                _sapphirePartialPaymentInvoiceService.findByInvoiceId(invoiceId);
//
//	        if (!sapphirePartialPaymentInvoices.isEmpty()) {
//	            paymentTransactionIds = sapphirePartialPaymentInvoices
//	                    .stream()
//	                    .map(x -> x.getPaymentTransactionId())
//	                    .collect(Collectors.toList());
//	        }
//
//	        return paymentTransactionIds;
//	    }
	
	private static final Log _log = LogFactoryUtil.getLog(
			KolanotInvoiceDisplayContext.class);

    private final CommerceCurrencyLocalService _commerceCurrencyLocalService;
    private CommerceOrder _commerceOrder;
    private final CommerceOrderLocalService _commerceOrderLocalService;
    private String _displayStyle;
    private String _keywords;
    private String _orderByCol;
    private String _orderByType;
    private KolanotInvoice _kolanotInvoice;
    private final KolanotInvoiceLocalService
            _kolanotInvoiceLocalService;
    private SearchContainer<KolanotInvoice> _searchContainer;
    private final CommercePaymentMethodGroupRelLocalService _commercePaymentMethodGroupRelLocalService;
    private final CommerceChannelLocalService _commerceChannelLocalService;
    private final CommerceAccountService _commerceAccountService;
    private final GroupLocalService _groupLocalService;
    private final Portal _portal;
    private BigDecimal multiBalanceDue;
}
