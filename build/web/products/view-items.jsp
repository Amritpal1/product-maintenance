<%-- 
    Document   : view-items
    Created on : Jul 20, 2012, 4:42:41 PM
    Author     : juliantais
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <h1>Products</h1>
 ${message}
 <c:choose>
     <c:when test="${productList.size() == 0}">
         <p>There are no items in your database</p>
     </c:when>
     <c:otherwise>
         <table border="1" cellspacing="1" cellpadding="1">
            <c:forEach var="product" items="${productList}" varStatus="status">
                <tr>
                    
                    <td>${status.index + 1}</td>
                    <td>${product.SKU}</td>
                    <td>${product.description}</td>
                    <td>${product.getPriceCurrencyFormat()}</td>
                    <td><a href="/musicStore/admin/products/edit?sku=${product.SKU}">Edit</a></td>
                    <td><a href="/musicStore/admin/products/delete?sku=${product.SKU}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
     </c:otherwise>
 </c:choose>
 
        <p>
        <form action="/musicStore/admin/products/add" method ="get">
            <input type="submit" value="Add Product" />
        </form>
        </p>
   