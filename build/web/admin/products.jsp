<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_no_links.jsp" />
<%-- 
    Document   : layout
    Created on : Jul 13, 2012, 7:48:49 PM
    Author     : juliantais
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@ page import="music.business.*, music.data.*, java.util.Date" --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<td valign="top">
<c:choose>
    <c:when test="${includeUrl == null || includeUrl == ''}">
        <h1>Product Maintenance</h1>
        <a href="<c:url value='add' />">Products</a>
    </c:when>
    <c:otherwise>
        <c:import url="${includeUrl}" />

    </c:otherwise>
</c:choose>

</td>

<jsp:include page="/includes/footer.jsp" />