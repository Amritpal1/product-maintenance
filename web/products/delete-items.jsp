<%-- 
    Document   : delete-items
    Created on : Jul 20, 2012, 5:25:59 PM
    Author     : juliantais
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- import packages -->


<h1>Are you sure you want to delete this product? </h1>
<p>SKU: ${product.SKU}</p>
<p>Product Description: ${product.description}</p>
<p>Product Price: ${product.getPriceFormat()}</p>


<a href="/musicStore/admin/products/delete?sku=${product.SKU}&delete=yes">Yes</a>
<a href="/musicStore/admin/products">No</a>


