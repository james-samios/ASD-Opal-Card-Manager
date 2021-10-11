<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/09/2021
  Time: 1:54 am
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
      <h1>Link Account</h1>
      <input type="text" id="user_email" name="user_email" autocomplete="off" placeholder="User Email" required>
      <input type="password" id="user_password" name="user_password" autocomplete="off" placeholder="Password" required>
      <input type="submit" form="login" name="login" value="link">
      <input type="button" value="Back" onclick="location.href='carddetails.jsp'">
      <!--
      <p> Not a Customer? <a href="register.jsp">Register</a></p>
      -->
    </form>
  </body>
</html>