<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>My Shopping Cart</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
     <h1>My Shopping Cart</h1>
        <c:if test="${not empty productList}">
            <table class="table table-condensed table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cartSession" items="${productList}">
                        <tr>
                            <td>${cartSession.product.ID}</td>
                            <td>${cartSession.product.productName}</td>
                            <td>${cartSession.product.productDescription}</td>
                            <td>${cartSession.product.unitPrice}</td>
                            <td>${cartSession.quantity}</td>
                              <td>
                                   <button class="btn btn-sm btn-danger"
                                   onclick="location.href='/remove/${cartSession.product.ID}'">Remove from cart</button>
                               </td>
                    </c:forEach>
                </tbody>
            </table>

             <button class="btn btn-sm btn-danger" onclick="location.href='/checkOut'">Check out</button>

        </c:if>
        <c:if test="${empty productList}">
            <p>Your cart is empty.</p>
        </c:if>
    </div>
</body>
</html>
