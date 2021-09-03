<%@ include file="/init.jsp" %>

<liferay-ui:success key="invoiceAdded" message="invoice-added"/>
<liferay-ui:success key="invoiceDeleted" message="invoice-deleted"/>

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

<style>

.label-closed {
	border-color: #33af0f;
	color: #33af0f;
}
.label-open {
	border-color: #d61414;
	color: #d61414;
}

</style>

<div>
	<h1><%= LanguageUtil.get(request, "kolanot-invoices") %></h1>

	<aui:button-row cssClass="invoices-buttons">

	    <portlet:renderURL var="addInvoiceURL">
		            <portlet:param name="mvcPath" value="/add_invoice.jsp"/>
		</portlet:renderURL>
		
		<aui:button onClick="<%=addInvoiceURL.toString()%>" value="Add Invoice" />
	</aui:button-row>

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
					<liferay-portlet:renderURL var="viewKolanotInvoiceURL">
						<portlet:param
							name="mvcRenderCommandName"
							value="viewKolanotInvoice"
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
						<a href="<%= viewKolanotInvoiceURL %>"> <%= HtmlUtil.escape(String.valueOf(commerceInvoice.getInvoiceId())) %>
						</a>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="status"
					>
						<span
							class="label label-<%= commerceInvoice.getDocumentStatus() %> status workflow-value"
						>
							<liferay-ui:message
								key="<%= commerceInvoice.getDocumentStatus() %>"
							/>
						</span>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="commerce-order-id"
					>
						<c:choose>
							<c:when
								test="<%= Validator.isNotNull(commerceInvoice.getCommerceOrderId()) %>"
							>
								<%= commerceInvoice.getCommerceOrderId() %>
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
						name="invoice-balance-due"
					>
						<%= commerceChannelCurrencyCode %>
						<%= kolanotInvoiceDisplayContext.round(commerceInvoice.getBalanceDue()) %>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="table-cell-content"
						name="invoice-document-date"
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
		a.href = "/o/invoice-pdf-generator?invoiceId=" + id;
		a.click();
	}

</aui:script></p>