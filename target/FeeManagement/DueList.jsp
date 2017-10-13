<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 9/8/2017
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="jumbtron">
        <c:forEach var="student" items="${dList}">
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
