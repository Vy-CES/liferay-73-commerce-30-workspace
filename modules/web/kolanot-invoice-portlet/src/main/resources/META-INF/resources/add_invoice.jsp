<%@ include file="/init.jsp" %>
<%
	long invoiceId = Long.valueOf((Long)renderRequest.getAttribute("invoiceId"));
	long groupId = Long.valueOf((Long) renderRequest.getAttribute("groupId"));

	KolanotInvoice invoice = null;
	CommerceOrder commerceOrder = null;

	if (invoiceId > 0) {
		invoice = KolanotInvoiceLocalServiceUtil.getKolanotInvoice(invoiceId);
		commerceOrder = CommerceOrderLocalServiceUtil.getCommerceOrder(invoice.getCommerceOrderId());
	}

	KolanotInvoiceDisplayContext kolanotInvoiceDisplayContext = (KolanotInvoiceDisplayContext)request
			.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

	CommerceAccount currentCommerceAccount = kolanotInvoiceDisplayContext.getCurrentCommerceAccount();

	List<CommerceOrder> accountOrders = null;

	if (currentCommerceAccount != null) {
		accountOrders = kolanotInvoiceDisplayContext.getPendingCommerceOrderByAccountId(currentCommerceAccount.getCommerceAccountId(), groupId);	
	}
%>

<portlet:renderURL var="viewURL">
    <portlet:param
            name="mvcPath"
            value="/view.jsp"
    />
</portlet:renderURL>

<liferay-ui:header
        backURL="<%= viewURL.toString() %>"
        title="<%= invoice == null ? "Add Invoice" : String.valueOf(invoice.getInvoiceId()) %>"
/>

<portlet:actionURL name="addInvoice" var="addInvoiceURL"/>

<aui:form action="<%= addInvoiceURL %>" name="fm">
    <aui:model-context bean="<%= invoice %>" model="<%= KolanotInvoice.class %>"/>

    <aui:fieldset>
        <aui:input name="invoiceId" type="hidden"/>
        
        <aui:select label="choose-order-to-invoice" name="commerceOrderId" showEmptyOption="<%= true %>">
        	<% 
        		if (commerceOrder == null && accountOrders != null) {
        			for(CommerceOrder order : accountOrders) {
        				%>
        					<aui:option label="<%= order.getCommerceOrderId() %>" value="<%= order.getCommerceOrderId() %>" />
        				<%
        			}
        		}
        		else if (invoice != null) {
        			%>
        				<aui:option label="<%= invoice.getCommerceOrderId() %>" selected="<%= (invoice != null) %>" value="<%= invoice.getCommerceOrderId() %>" />
        			<%
        			
        		}
        	%>
        </aui:select>

        <aui:input name="createdBy" value="<%= currentCommerceAccount == null ? "" : currentCommerceAccount.getName() %>" disabled="<%= true %>"/>

		<aui:input name="invoiceTotal" type="hidden"/>

    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>

        <aui:button onClick="<%= viewURL.toString() %>" type="cancel"/>
    </aui:button-row>
</aui:form>