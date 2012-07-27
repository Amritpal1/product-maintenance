<%@taglib prefix="jt" uri="/WEB-INF/tlds/julian.tld" %>
<h1>Add Product</h1>

<p><i>${message}</i></p>

<p><jt:required field="" /> </p> fields are required
<form action="add" method="post">
    <table class="add-product">
        <tr><td>Product SKU: <input type="text" name="sku" 
                                    value="${product.SKU}">
                <jt:required field="${product.SKU}" /></td></tr> 
        <tr><td>Product Description: <input type="text" name="description" 
                                            value="${product.description}">
            <jt:required field="${product.description}" /></td></tr>
        <tr><td>Product Price: <input type="text" name="price" 
                                      value ="${product.getPriceFormat()}">
            <jt:required field="${product.getPriceFormat()}" /></td></tr>
        <tr><td><input type="submit" value="Submit" /></td></tr>
    </table>
</form>