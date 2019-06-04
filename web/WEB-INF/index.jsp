<%-- 
    Document   : index
    Created on : Jun 4, 2019, 2:09:25 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oder Product</title>
    </head>
    <body>
        <h1>Welcome to Shop Top!</h1>
        <hr/>
        <jsp:useBean id="prod" class="model.ProductCart" scope="session"/>
        <form action="shoppingServlet" name="shoppingForm" method="post">
            <p>Products</p><br>
            <select name="products">
                <c:forEach var="item" items="${prod.products}">
                    <option>
                        ${item.productId}${'|'}${item.productName}${'|'}${item.productType}${'|'}${item.price}
                    </option>
                    
                </c:forEach>
            </select>
            <br><br>
            <b>Quanity</b><input type="text" name="qty" value="1"><br>
            <input type="hidden" name="action" value="ADD">
            <input type="submit" name="submit" value="Add to Cart">
                
                
        </form>
        <p>${message}</p>
        <jsp:include page="cart.jsp" flush="true"/>
    </body>
</html>
