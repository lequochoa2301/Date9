<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sản Phẩm</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-10">
                <c:if test="${not empty productList}">
                    <table class="table table-condensed table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Unit Price</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="product" items="${productList}">
                                <tr>
                                    <td>${product.ID}</td>
                                    <td>${product.productName}</td>
                                    <td>${product.productDescription}</td>
                                    <td>${product.unitPrice}</td>
                                    <td>
                                        <button class="btn btn-sm btn-danger"
                                                onclick="location.href='/addTocart/${product.ID}'">Add to cart</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty productList}">
                    <br>
                    <div class="alert alert-warning">Không có dữ liệu</div>
                </c:if>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
