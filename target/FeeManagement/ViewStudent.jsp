<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 9/8/2017
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="jumbtron">
        <c:forEach var="student" items="${sList}">
            <div class="panel">
                <c:out value="${student.name}"></c:out>
                <c:out value="${student.email}"></c:out>
                <c:out value="${student.sex}"></c:out>
                <c:out value="${student.course}"></c:out>
                <c:out value="${student.fee}"></c:out>
                <c:out value="${student.paid}"></c:out>
                <c:out value="${student.due}"></c:out>
                <c:out value="${student.address}"></c:out>
                <c:out value="${student.contact}"></c:out>
            </div>
        </c:forEach>

    </div>

</div>
</body>
</html>
