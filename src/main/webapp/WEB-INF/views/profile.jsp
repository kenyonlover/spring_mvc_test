<%--
  Created by IntelliJ IDEA.
  User: kenyon
  Date: 2019/10/25
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>your profile</h1>
    <c:out value="${spitter.username}" /><br />
    <c:out value="${spitter.firstName}" /><br />
    <c:out value="${spitter.lastName}" /><br />
</body>
</html>
