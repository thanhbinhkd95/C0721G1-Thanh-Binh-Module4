<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/15/2021
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
        <h1>
            Sandwich Condiments
        </h1>

        <form action="/condiment" method="get">
            <input type="checkbox" name="condiment" value="Lettuce">Lettuce
            <input type="checkbox" name="condiment" value="Tomato">Tomato
            <input type="checkbox" name="condiment" value="Mustard">Mustard
            <input type="checkbox" name="condiment" value="Sprouts">Sprouts
            <p></p>
            <input type="submit" value="Save">
        </form>
        <c:if test="${listcondiment != null}">
            <h3>Result Menu</h3>
            <c:forEach items="${listcondiment}" var="list">
                <span style="color: red">${list.toString()}</span>
            </c:forEach>
        </c:if>

</body>
</html>
