<%-- 
    Document   : edit-items
    Created on : Jul 20, 2012, 5:25:46 PM
    Author     : juliantais
--%>
<%@taglib prefix="jt" uri="/WEB-INF/tlds/julian.tld" %>
<h1>Edit Item</h1>

<p><i>${message}</i></p>

<form action="edit" method="post">
    <table class="add-product">
        <tr><td>Product SKU: ${product.SKU}</td></tr> 
        <tr><td>Product Description: <input type="text" 
                                            name="description" value="${product.description}">
                <jt:required field="${product.description}" /></td></tr>
        <tr><td>Product Price: <input type="text" name="price" 
                                      value ="${product.getPriceFormat()}">
                <jt:required field="${product.getPriceFormat()}" /></td></tr>
        <tr><td><input type="submit" value="Submit" /></td></tr>
    </table>
</form>