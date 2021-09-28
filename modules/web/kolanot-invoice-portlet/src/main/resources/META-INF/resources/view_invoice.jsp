<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<%
	KolanotInvoiceDisplayContext kolanotInvoiceDisplayContext = (KolanotInvoiceDisplayContext)request
	.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

	KolanotInvoice kolanotInvoice = kolanotInvoiceDisplayContext
			.getKolanotInvoice();

	String paymentServletUrl = StringPool.BLANK;
	List<KolanotInvoice> kolanotInvoices = new ArrayList<KolanotInvoice>();
	if (kolanotInvoice != null) {
		kolanotInvoices.add(kolanotInvoice);
		paymentServletUrl = kolanotInvoiceDisplayContext.getPaymentServletUrl(kolanotInvoices);
	}
	Format dateFormatDateTime = FastDateFormatFactoryUtil.getSimpleDateFormat("MMM dd, yyyy", locale, timeZone);
	String commerceChannelCurrencyCode = kolanotInvoiceDisplayContext.getCommerceChannelCurrencyCode();
	BigDecimal invoiceBalanceDue = kolanotInvoice.getBalanceDue();
%>

<c:choose>
	<c:when
		test="<%= Validator.isNotNull(kolanotInvoice)%>"
	>

		<%
		List<String> paymentTransactionId = kolanotInvoiceDisplayContext.getTransactionIdsByInvoiceId(kolanotInvoice.getInvoiceId());
		boolean isFullPayment = true;
		%>

		<div class="col-12 row">
		    <div class="col-6" style="text-align: left;">
		        <div>
		            <div class="form-group" id="<portlet:namespace />invoicePaymentType">
                        <aui:input checked='<%= isFullPayment %>' label="full-payment" name="isFullPayment" value="<%= isFullPayment %>" type="radio" onChange='<%= liferayPortletResponse.getNamespace() + "isFullPayment(true);" %>' />
                        <aui:input checked='<%= !isFullPayment %>' label="partial-payment" name="isFullPayment" value="<%= !isFullPayment %>" type="radio" onChange='<%= liferayPortletResponse.getNamespace() + "isFullPayment(false);" %>' />
                    </div>

                    <div id="<portlet:namespace />partialPaymentInput" class="d-none">
                        <aui:form>
                            <aui:input label="please-invoice-partial-payment-amount" name="partialPaymentAmount" required="<%= !isFullPayment %>"
                                suffix="<%= HtmlUtil.escape(commerceChannelCurrencyCode) %>" type="text" placeholder="Enter amount"
                                onChange='<%= liferayPortletResponse.getNamespace() + "changePartialAmount(this);" %>'>

                                <aui:validator name="min">1</aui:validator>
                                <aui:validator name="max"><%= invoiceBalanceDue %></aui:validator>
                                <aui:validator name="number" />
                            </aui:input>
                        </aui:form>
                    </div>
		        </div>
		    </div>
		</div>
		<div class="col-12 row">
			<div class="col-6 float-left">
				<div class="info-box py-3">
					<header class="header pb-2">
						<h2 class="mb-0 title"><%= LanguageUtil.get(request, "kolanot-invoice") + " #"
							+ kolanotInvoice.getInvoiceId() %></h2>
					</header>
				</div>
			</div>

			<div class="col-6" style="text-align: right;">
				<a
					class="btn btn-white"
					onclick="<%= liferayPortletResponse.getNamespace() + "downloadPDF("
							+ kolanotInvoice.getInvoiceId() + ");" %>"
				>
					PDF <clay:icon symbol="download" />
				</a>
				<c:if
					test="<%= kolanotInvoice.getDocumentStatus().equalsIgnoreCase("open") %>"
				>
					<a class="btn btn-white" 
					
					onclick="<%= liferayPortletResponse.getNamespace() + "stripeCheckout();" %>"> <%= LanguageUtil.get(request, "invoice-continue")%></a>
				</c:if>
			</div>
		</div>

		<div class="col-12">
			<commerce-ui:panel bodyClasses="flex-fill">
				<div class="row vertically-divided">
					<div class="col-xl-3">
						<commerce-ui:info-box
							elementClasses="py-3"
							title='<%= LanguageUtil.get(request, "invoice-submitted-by") %>'
						>
							<%= kolanotInvoice.getCreatedBy() %>
						</commerce-ui:info-box>

						<commerce-ui:info-box
							elementClasses="py-3"
							title='<%= LanguageUtil.get(request, "invoice-document-date") %>'
						>
							<c:choose>
								<c:when
									test="<%= Validator.isNotNull(kolanotInvoice.getDocumentDate()) %>"
								>
									<%= HtmlUtil.escape(
											dateFormatDateTime.format(kolanotInvoice.getDocumentDate())) %>
								</c:when>
								<c:otherwise> -- </c:otherwise>
							</c:choose>
						</commerce-ui:info-box>

						<commerce-ui:info-box
							elementClasses="py-3"
							title='<%= LanguageUtil.get(request, "invoice-due-date") %>'
						>
							<c:choose>
								<c:when
									test="<%= Validator.isNotNull(kolanotInvoice.getDueDate()) %>"
								>
									<%= HtmlUtil
											.escape(dateFormatDateTime.format(kolanotInvoice.getDueDate())) %>
								</c:when>
								<c:otherwise> -- </c:otherwise>
							</c:choose>
						</commerce-ui:info-box>
					</div>

					<div class="col-xl-3">
						<commerce-ui:info-box
							elementClasses="py-3"
							title='<%= LanguageUtil.get(request, "invoice-stripe-session-id") %>'
						>
							<c:choose>
								<c:when
									test="<%= Validator.isNotNull(kolanotInvoice.getTransactionId()) %>"
								>
									<%= kolanotInvoice.getTransactionId() %>
								</c:when>
								<c:otherwise> -- </c:otherwise>
							</c:choose>
						</commerce-ui:info-box>

						<commerce-ui:info-box
							elementClasses="py-3"
							title='<%= LanguageUtil.get(request, "invoice-tracking-number") %>'
						>
							<c:choose>
								<c:when
									test="<%= Validator.isNotNull(kolanotInvoice.getTrackingNumber()) && Validator.isNotNull(kolanotInvoice.getTrackingURL()) %>"
								>
									<a href="<%= HtmlUtil.escape(kolanotInvoice.getTrackingURL()) %>" target="_blank">
										<%= kolanotInvoice.getTrackingNumber() %> </a>
								</c:when>
								<c:when
									test="<%= Validator.isNotNull(kolanotInvoice.getTrackingNumber()) %>"
								>
										<%= kolanotInvoice.getTrackingNumber() %>
								</c:when>
								<c:otherwise> -- </c:otherwise>
							</c:choose>
						</commerce-ui:info-box>

						<commerce-ui:info-box
							elementClasses="py-3"
							title='<%= LanguageUtil.get(request, "invoice-document-status") %>'
						>
							<c:choose>
								<c:when
									test="<%= Validator.isNotNull(kolanotInvoice.getDocumentStatus()) %>"
								>
									<%= kolanotInvoice.getDocumentStatus() %>
								</c:when>
								<c:otherwise> -- </c:otherwise>
							</c:choose>
						</commerce-ui:info-box>
					</div>

					<div class="col-xl-3">
						<commerce-ui:info-box
							elementClasses="py-3"
							title='<%= LanguageUtil.get(request, "invoice-total") %>'
						>
							<c:choose>
								<c:when
									test="<%= Validator.isNotNull(kolanotInvoice.getInvoiceTotal()) %>"
								>
									<%= commerceChannelCurrencyCode %>
									<%= kolanotInvoiceDisplayContext
											.round(kolanotInvoice.getInvoiceTotal()) %>
								</c:when>
								<c:otherwise> -- </c:otherwise>
							</c:choose>
						</commerce-ui:info-box>

						<commerce-ui:info-box
							elementClasses="py-3"
							title='<%= LanguageUtil.get(request, "invoice-paid-amount") %>'
						>
							<c:choose>
								<c:when
									test="<%= Validator.isNotNull(kolanotInvoice.getPaidSum()) %>"
								>
									<%= commerceChannelCurrencyCode %>
									<%= kolanotInvoiceDisplayContext.round(kolanotInvoice.getPaidSum()) %>
								</c:when>
								<c:otherwise> -- </c:otherwise>
							</c:choose>
						</commerce-ui:info-box>

						<commerce-ui:info-box
							elementClasses="py-3"
							title='<%= LanguageUtil.get(request, "invoice-balance-due") %>'
						>
							<c:choose>
								<c:when
									test="<%= Validator.isNotNull(kolanotInvoice.getBalanceDue()) %>"
								>
									<%= commerceChannelCurrencyCode %>
									<%= kolanotInvoiceDisplayContext
											.round(kolanotInvoice.getBalanceDue()) %>
								</c:when>
								<c:otherwise> -- </c:otherwise>
							</c:choose>
						</commerce-ui:info-box>
					</div>
				</div>
			</commerce-ui:panel>
		</div>
		<div class="row">
	<div class="col-md-12">

		<%
		java.util.Map<String, String> contextParams = new java.util.HashMap<>();
		contextParams.put("commerceOrderId", String.valueOf(kolanotInvoice.getCommerceOrderId()));
		%>

		<clay:data-set-display
			contextParams="<%= contextParams %>"
			dataProviderKey="<%= "commercePlacedOrderItems" %>"
			id="<%= "commercePlacedOrderItems" %>"
			itemsPerPage="<%= 10 %>"
			namespace="<%= liferayPortletResponse.getNamespace() %>"
			nestedItemsKey="orderItemId"
			nestedItemsReferenceKey="orderItems"
			pageNumber="<%= 1 %>"
			portletURL="<%= kolanotInvoiceDisplayContext.getPortletURL() %>"
			style="stacked"
		/>
	</div>
</div>
		
	</c:when>
	<c:otherwise>
		<portlet:renderURL var="viewAllInvoicesURL">
			<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
		</portlet:renderURL>

		<clay:alert
			message="the-current-account-does-not-have-permission-to-view-the-selected-invoices"
			style="danger"
			title="Error"
		/>
		Please go back to <a href="<%= viewAllInvoicesURL.toString() %>">listing</a> page
	</c:otherwise>
</c:choose>

<aui:script>
	function <portlet:namespace />stripeCheckout() {
	
		var url = new URL(
						'<%= kolanotInvoiceDisplayContext.getPaymentServletUrl(kolanotInvoices) %>'
		);
		window.location.replace(url.href);
	}

	function <portlet:namespace />downloadPDF(id) {
		var a = document.createElement('a');
		a.style.display = 'none';
		a.href = "/o/invoice-pdf-generator?invoiceId=" + id;
		//console.log(a);
		a.click();
	}

	var onCommerceAccountSelected = function() {
		   window.location.reload();
	};
	Liferay.on('accountSelected', ({accountId}) => onCommerceAccountSelected());

	function <portlet:namespace />isFullPayment(isFullPayment) {
            document.getElementById('<portlet:namespace />invoicePaymentType').value = isFullPayment;
            var partialPaymentInputElement = document.getElementById('<portlet:namespace />partialPaymentInput');
            var fullPaymentLinkElement = document.getElementById('<portlet:namespace />fullPaymentLink');
            var partialPaymentLinkElement = document.getElementById('<portlet:namespace />partialPaymentLink');

            if (!isFullPayment) {
                partialPaymentInputElement.classList.remove("d-none");
                partialPaymentLinkElement.classList.remove("d-none");
                fullPaymentLinkElement.classList.add("d-none");
            } else {
                partialPaymentInputElement.classList.add("d-none");
                fullPaymentLinkElement.classList.remove("d-none");
                partialPaymentLinkElement.href = "javascript: void(0)";
                partialPaymentLinkElement.classList.add("d-none");
            }
        }

        function <portlet:namespace />changePartialAmount(amount) {
            var partialPaymentLinkElement = document.getElementById('<portlet:namespace />partialPaymentLink');
            var url = new URL(document.getElementById('<portlet:namespace />fullPaymentLink').href);
            var searchParams = url.searchParams;
            var invoiceBalanceDue = searchParams.get('invoiceBalanceDue');
            if (amount != null && !isNaN(amount.value) && amount.value > 0 && amount.value <= +invoiceBalanceDue) {
                searchParams.set('invoiceBalanceDue', amount.value);
                url.search = searchParams.toString();
                partialPaymentLinkElement.href = url.toString();
            } else {
                partialPaymentLinkElement.href = "javascript: void(0)";
            }
        }
</aui:script>