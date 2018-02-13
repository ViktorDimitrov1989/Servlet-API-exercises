<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Atlas
  Date: 2/12/2018
  Time: 11:26 PM
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
    <%@ include file="/templates/partials/notifications.jsp" %>
</div>

<div>
    <h1>Sign up</h1>
    <form method="post">
            Username:<br>
            <input type="text" name="username">
        <br>
            Password:<br>
            <input type="password" name="password">
        <br><br>
            <input type="submit" value="Sign up">
    </form>
</div>

<div>
    <%@ include file="/templates/partials/footer.jsp" %>
</div>
</body>
</html>
