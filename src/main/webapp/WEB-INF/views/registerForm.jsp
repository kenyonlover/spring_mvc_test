<%--
  Created by IntelliJ IDEA.
  User: kenyon
  Date: 2019/10/25
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>spitter regiter</title>
</head>
<body>
    <h1>regiter</h1>

    <form method="post">
        Firs Name:<input type="text" name="firstName" /><br />
        Last Name:<input type="text" name="lastName" /><br />
        Username:<input type="text" name="username" /><br />
        PassWord:<input type="password" name="password" /><br />
        <input type="submit" value="Register">
    </form>
</body>
</html>
