<%--
  Created by IntelliJ IDEA.
  User: Atlas
  Date: 2/12/2018
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <ul class="nav">
        <li><a href="${pageContext.request.contextPath}/">Home</a></li>
        <c:if test="${username != null}">
            <li><a href="${pageContext.request.contextPath}/add" role="button">Add Book</a></li>
            <li><a href="${pageContext.request.contextPath}/shelves" role="button">Shelves</a></li>
            <li><a href="${pageContext.request.contextPath}/signout" role="button">Logout</a></li>

            <li style="float:right" style="color: white;"><p>Hello ${username}</p></li>
        </c:if>
        <c:if test="${username == null}">
            <li><a href="${pageContext.request.contextPath}/signup" role="button">Sign Up</a></li>
            <li><a href="${pageContext.request.contextPath}/signin" role="button">Sign In</a></li>
        </c:if>
    </ul>


</html>
