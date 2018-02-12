<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Atlas
  Date: 2/12/2018
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<div>
    <%@ include file="/templates/partials/navigation-bar.jsp" %>
</div>

<article>
    <h1>London</h1>
    <p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
    <p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>
</article>

<div>
    <%@ include file="/templates/partials/footer.jsp" %>
</div>
</body>
</html>
