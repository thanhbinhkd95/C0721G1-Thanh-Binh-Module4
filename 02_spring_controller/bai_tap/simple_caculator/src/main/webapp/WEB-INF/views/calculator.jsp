<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/15/2021
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <h1>Calculator</h1>
    <form action="/calculator-page" method="get">
        <div>
            <input type="text" name="numberone" pattern="[0-9-.]+">
            <input type="text" name="numbertwo" pattern="[0-9-.]+">
        </div>
        <div>
            <input type="submit" name="calculator" value="Addition(+)">
            <input type="submit" name="calculator" value="Subtraction(-)">
            <input type="submit" name="calculator" value="Multiplication(X)">
            <input type="submit" name="calculator" value="Division(/)">
        </div>
    </form>

    <c:if test="${message != null}">
        <h2 style="color: red">Exception : ${message}</h2>
    </c:if>
    <c:if test="${message == null && calculate != null}">
        <h2>Result : ${result}</h2>
    </c:if>
</body>
</html>
