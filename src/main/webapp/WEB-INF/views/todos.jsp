<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>ToDo Liste</title>
</head>
<body>
    <h1>ToDo Liste</h1>
    <ul>
    <c:forEach var="todoItem" items="${todoItems}">
        <li><a href="todos/${todoItem.id}">${todoItem.topic}</a></li>
    </c:forEach>
    </ul>
</body>
</html>