<%@ include file="/init.jsp" %>

<%
KolanotInvoiceDisplayContext kolanotInvoiceDisplayContext = (KolanotInvoiceDisplayContext)request
.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

String[] resultMessages = ParamUtil.getStringValues(request, "resultMessages");
String paymentTransactionId = ParamUtil.getString(request, "paymentTransactionId");

%>

 <%
                    for (String message : resultMessages) {
                    %>
                        <p><%= message %></p>
                    <%
                    }
                    %>