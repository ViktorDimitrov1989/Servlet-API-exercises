<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Atlas
  Date: 2/12/2018
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<div>
    <%@ include file="/templates/partials/navigation-bar.jsp" %>
</div>

<div>
    <h1>Edit book</h1>
   <%-- <form method="post">
        Title:<br>
        <input type="text" name="title" value="${book.title}">
        <br>
        Author:<br>
        <input type="text" name="author" value="${book.author}">
        <br>
        Pages:<br>
        <input type="number" name="pagescnt" value="${book.pages}">
        <br><br>
        <input type="submit" value="Edit">
    </form>--%>
</div>

<div>
    <%@ include file="/templates/partials/footer.jsp" %>
</div>
</body>
</html>
