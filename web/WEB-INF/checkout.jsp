<%-- 
    Document   : checkout
    Created on : Jun 4, 2019, 2:09:15 PM
    Author     : admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="prod" class="model.ProductCart" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaction</title>
    </head>
    <body>
        <h1>Transaction Details!</h1>
    <center>
        <table>
            <tr>
                <td><b>Product Id</b></td>
                <td><b>Product Name</b></td>
                <td><b>Product Type</b></td>
                <td><b>Price</b></td>
                <td><b>Quantity</b></td>
            </tr>
            <c:forEach var="item" items="${prod.cartItems}">
                <tr>
                    <td></td>
                    <td></td>
                    <td><b>Total</b></td>
                    <td><b>${prod.amout}</b></td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="index.jsp">Home</a>
    </center>
</body>
</html>
