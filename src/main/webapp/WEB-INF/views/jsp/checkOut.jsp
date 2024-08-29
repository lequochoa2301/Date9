<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Checkout</title>
    <jsp:include page="header.jsp" />

    <link rel=""stylesheet"" type=""text/css"" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
    <script type=""text/javascript"" src=""${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js""></script>
    <meta http-equiv=""Content-Type"" content=""text/html; charset=UTF-8"">

</head>
<body>
 <div class="container">
 <div class="col-md-8">
    <h2>Please fill information</h2>
    <form:form modelAttribute="order" action="${pageContext.request.contextPath}/checkOut" method="POST">
        <div class="form-group">
            <label class="control-label">Customer Name (*)</label><br>
            <form:input path="customerName" type="text" class="form-control" placeholder="Customer Name" required="true"/>
        </div><br>
        <div class="form-group">
            <label class="control-label">Customer Address (*)</label><br>
            <form:input path="customerAddress" type="text" class="form-control" placeholder="Customer Address" required="true"/>
        </div><br>
       <button class="btn btn-sm btn-danger" onclick="location.href='/order'">Continue</button>
    </form:form>
 </div>
 </div>
</body>
</html>
