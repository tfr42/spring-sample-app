<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Todo: ${todo.topic}</title>
</head>
<body>
    <h1>Todo: ${todo.topic}</h1>
    <form:form commandName="todo" method="POST">
        <fieldset>
            <c:if test="${not empty todo.id}">
                <form:hidden path="id" />
            </c:if>
            <div class="form-row">
                <label for="topic">Betreff:</label>
                <form:input path="topic" />
            </div>
            <div class="form-row">
                <label for="category">Kategorie:</label>
                <form:input path="description" />
            </div>
            <div class="form-buttons">
                <div class="button"><input name="submit" type="submit" value="Speichern" /></div>
            </div>
        </fieldset>
    </form:form>
</body>
</html>