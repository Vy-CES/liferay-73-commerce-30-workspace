<%@page import="com.kolanot.service.service.KolanotInvoiceLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<%
   long invoiceId = ParamUtil.getLong(renderRequest, "invoiceId");
	System.out.println(invoiceId);
	KolanotInvoice invoice = null;

	if (invoiceId > 0) {
		invoice = KolanotInvoiceLocalServiceUtil.getKolanotInvoice(invoiceId);
	}
%>

<portlet:renderURL var="viewURL">
    <portlet:param
            name="mvcPath"
            value="view.jsp"
    />
</portlet:renderURL>

<liferay-ui:header
        backURL="<%= viewURL.toString() %>"
        title="<%= invoice == null ? "Add Invoice" : invoice.getInvoiceId() %>"
/>

<portlet:actionURL name="addInvoice" var="addInvoiceURL"/>

<aui:form action="<%= addInvoiceURL %>" name="fm">
    <aui:model-context bean="<%= invoice %>" model="<%= KolanotInvoice.class %>"/>

    <aui:fieldset>
        <aui:input name="invoiceId"/>

        <aui:input name="commerceOrderId"/>

        <aui:input name="createdBy"/>

		<aui:input name="invoiceTotal"/>

    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>

        <aui:button onClick="<%= viewURL.toString() %>" type="cancel"/>
    </aui:button-row>
</aui:form>