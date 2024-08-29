<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>My Order List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <c:if test="${not empty orderList}">
            <table class="table table-condensed table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Customer Name</th>
                        <th>Customer Address</th>
                        <th>Order Details</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orderList}">
                        <tr>
                            <td>${order.ID}</td>
                            <td>${order.customerName}</td>
                            <td>${order.customerAddress}</td>
                            <td>
                                <!-- Assuming you have some details to display -->
                                <a href="${pageContext.request.contextPath}/orderDetails/${order.ID}" class="btn btn-info btn-sm">View Details</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty orderList}">
            <p>No orders available.</p>
        </c:if>
    </div>
</body>
</html>
