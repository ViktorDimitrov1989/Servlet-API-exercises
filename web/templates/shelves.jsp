<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Atlas
  Date: 2/12/2018
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shelves</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<div>
    <%@ include file="/templates/partials/navigation-bar.jsp" %>
</div>

<div>
    <h1>Shelves page</h1>
    <table style="width:100%">
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Pages</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.pages}</td>
                <td><a href="${pageContext.request.contextPath}/shelves/edit/${book.title}" role="button">Edit</a></td>
                <td><a href="${pageContext.request.contextPath}/shelves/delete/${book.title}" role="button">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<div>
    <%@ include file="/templates/partials/footer.jsp" %>
</div>
</body>
</html>
