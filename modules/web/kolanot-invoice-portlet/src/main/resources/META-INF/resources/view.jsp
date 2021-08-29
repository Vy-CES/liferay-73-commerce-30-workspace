<%@ include file="/init.jsp" %>

<liferay-ui:success key="entryAdded" message="entry-added"/>
<liferay-ui:success key="guestbookAdded" message="guestbook-added"/>
<liferay-ui:success key="entryDeleted" message="entry-deleted"/>

<%
	KolanotInvoiceDisplayContext kolanotInvoiceDisplayContext = (KolanotInvoiceDisplayContext)request
			.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

	CommerceAccount currentCommerceAccount = kolanotInvoiceDisplayContext.getCurrentCommerceAccount();

	Format dateFormatDateTime = FastDateFormatFactoryUtil.getSimpleDateFormat("MMM dd, yyyy", locale, timeZone);
	String commerceChannelCurrencyCode = kolanotInvoiceDisplayContext.getCommerceChannelCurrencyCode();
	SearchContainer<KolanotInvoice> commerceInvoiceSearchContainer = kolanotInvoiceDisplayContext
		.getSearchContainer(currentCommerceAccount);
	
	long invoiceId = Long.valueOf((Long) renderRequest
	        .getAttribute("invoiceId"));
%>

<div>
	<h1><%= LanguageUtil.get(request, "kolanot-invoices") %></h1>

	<aui:button-row cssClass="invoices-buttons">

	    <portlet:renderURL var="addInvoiceURL">
		            <portlet:param name="mvcPath" value="/edit_invoice.jsp"/>
		            <portlet:param name="invoiceId"
		                           value="<%=String.valueOf(invoiceId)%>"/>
		        </portlet:renderURL>
		
		        <aui:button onClick="<%=addInvoiceURL.toString()%>" value="Add Invoice" />

	</aui:button-row>

	<liferay-frontend:management-bar
		includeCheckBox="<%= true %>"
		searchContainerId="commerceInvoices"
	>
		<liferay-frontend:management-bar-buttons>
		</liferay-frontend:management-bar-buttons>

		<liferay-frontend:management-bar-filters>
			<liferay-frontend:management-bar-navigation
				navigationKeys='<%= new String[] {"all"} %>'
				portletURL="<%= kolanotInvoiceDisplayContext.getPortletURL() %>"
			/>

			<liferay-frontend:management-bar-sort
				orderByCol="<%= kolanotInvoiceDisplayContext.getOrderByCol() %>"
				orderByType="<%= kolanotInvoiceDisplayContext.getOrderByType() %>"
				orderColumns='<%= new String[] {"status"} %>'
				portletURL="<%= kolanotInvoiceDisplayContext.getPortletURL() %>"
			/>

			<li><liferay-commerce:search-input
					actionURL="<%= kolanotInvoiceDisplayContext.getPortletURL() %>"
					formName="searchFm" /></li>
		</liferay-frontend:management-bar-filters>
	</liferay-frontend:management-bar>

	<div class="container-fluid-1280">
		<liferay-ui:error
			exception="<%= PortalException.class %>"
			message="could-not-process-invoice-that-is-already-paid"
		/>

		<portlet:renderURL var="viewSapphireMultiCommerceInvoiceURL">
			<portlet:param
				name="mvcRenderCommandName"
				value="viewSapphireMultiCommerceInvoice"
			/>
		</portlet:renderURL>

		<aui:form
			action="<%= viewSapphireMultiCommerceInvoiceURL %>"
			method="post"
			name="fm"
		>
			<aui:input name="invoiceIds" type="hidden" value="" />

			<aui:input
				name="p_auth"
				type="hidden"
				value="<%= AuthTokenUtil.getToken(request) %>"
			/>

			<liferay-ui:search-container
				id="commerceInvoices"
				searchContainer="<%= commerceInvoiceSearchContainer %>"
			>
				<liferay-ui:search-container-row
					className="com.kolanot.service.model.KolanotInvoice"
					keyProperty="invoiceId"
					modelVar="commerceInvoice"
				>
					<liferay-portlet:renderURL var="viewSapphireCommerceInvoiceURL">
						<portlet:param
							name="mvcRenderCommandName"
							value="viewSapphireCommerceInvoice"
						/>

						<portlet:param
							name="invoiceId"
							value="<%= String.valueOf(commerceInvoice.getInvoiceId()) %>"
						/>
					</liferay-portlet:renderURL>

					<liferay-ui:search-container-column-text
						cssClass="important table-cell-content"
						name="invoice-id"
					>
						<a href="<%= viewSapphireCommerceInvoiceURL %>"> <%= HtmlUtil.escape(String.valueOf(commerceInvoice.getInvoiceId())) %>
						</a>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="sapphire-invoice-document-date"
					>
						<c:choose>
							<c:when
								test="<%= Validator.isNotNull(commerceInvoice.getDocumentDate()) %>"
							>
								<%= HtmlUtil
											.escape(dateFormatDateTime.format(commerceInvoice.getDocumentDate())) %>
							</c:when>
							<c:otherwise> -- </c:otherwise>
						</c:choose>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="sapphire-invoice-due-date"
					>
						<c:choose>
							<c:when
								test="<%= Validator.isNotNull(commerceInvoice.getDueDate()) %>"
							>
								<%= HtmlUtil
											.escape(dateFormatDateTime.format(commerceInvoice.getDueDate())) %>
							</c:when>
							<c:otherwise> -- </c:otherwise>
						</c:choose>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="sapphire-invoice-no"
					>
						<c:choose>
							<c:when
								test="<%= Validator.isNotNull(commerceInvoice.getDocumentNumber()) %>"
							>
								<%= commerceInvoice.getDocumentNumber() %>
							</c:when>
							<c:otherwise> -- </c:otherwise>
						</c:choose>

					</liferay-ui:search-container-column-text>
										<liferay-ui:search-container-column-text
											cssClass="table-cell-content"
											name="created-by"
											property="createdBy"
										/>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="total"
					>
						<%= commerceChannelCurrencyCode %>
						<%= kolanotInvoiceDisplayContext.round(commerceInvoice.getInvoiceTotal()) %>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="amount-paid"
					>
						<%= commerceChannelCurrencyCode %>
						<%= kolanotInvoiceDisplayContext.round(commerceInvoice.getPaidSum()) %>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="sapphire-invoice-balance-due"
					>
						<%= commerceChannelCurrencyCode %>
						<%= kolanotInvoiceDisplayContext.round(commerceInvoice.getBalanceDue()) %>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
					>
						<a
							class="btn btn-white"
							onclick="<%= liferayPortletResponse.getNamespace() + "downloadPDF("
									+ commerceInvoice.getInvoiceId() + ");" %>"
						>
							PDF <clay:icon symbol="download" />
						</a>
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator markupView="lexicon" />
			</liferay-ui:search-container>
		</aui:form>
	</div>
</div>

<aui:script>
	showStatusMessage = Liferay.lazyLoad(
		'frontend-js-web/liferay/toast/commands/OpenToast.es',
		function(toastCommands, data) {
			toastCommands.openToast(data);
		}
	);

	function showError(message) {
		showStatusMessage({
			message: message,
			type: 'danger',
		});
	}

	var onCommerceAccountSelected = function() {
			window.location.reload();
	};
	Liferay.on('accountSelected', ({accountId}) => onCommerceAccountSelected());

	function <portlet:namespace />downloadPDF(id) {
		var a = document.createElement('a');
		a.style.display = 'none';
		a.href = "/o/sapphire-invoice-pdf-generator?invoiceId=" + id;
		a.click();
	}

</aui:script></p>