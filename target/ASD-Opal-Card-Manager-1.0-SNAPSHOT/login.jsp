<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/09/2021
  Time: 11:26 pm
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/login.css">
    <title>Login Page</title>
</head>
<body>
    <form class="box" action="LoginServlet" method="post" id="login">
        <h1>Login</h1>
        <input type="text" id="uname" name="uname" autocomplete="off" placeholder="Username" required>
        <input type="password" id="upassword" name="upassword" autocomplete="off" placeholder="Password" required>
        <input type="submit" form="login" name="login" value="Login">
        <input type="button" value="Back" onclick="location.href='index.jsp'">
        <p> Not a Customer? <a href="register.jsp">Register</a></p>
    </form>
</body>
</html>
