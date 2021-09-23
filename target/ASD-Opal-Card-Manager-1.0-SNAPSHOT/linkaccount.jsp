<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/09/2021
  Time: 1:54 am
  To change this template use File | Settings | File Templates.
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="group2.asd.uts.edu.au.opal.model.Card" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="CSS/login.css">
  <title>Link Account Page</title>
</head>
  <body>
    <%
      String emailFormErr = (String)session.getAttribute("emailErr");
      String passErr = (String)session.getAttribute("passErr");
      String previousEmail = (String)session.getAttribute("previous_email");
      String previousPass = (String)session.getAttribute("previous_password");
    %>

    <form class="box" action="LinkAccountServlet" method="post" id="link_account">
      <h1>Link Account</h1>
      <input type="text" id="user_email" name="user_email" autocomplete="off" value="<%=previousEmail != null?previousEmail:""%>" placeholder="User Email" required>
      <input type="password" id="user_password" name="user_password" value="<%=previousPass != null?previousPass:""%>" autocomplete="off" placeholder="Password" required>
      <input type="submit" form="link_account" name="link" value="link">
      <input type="button" value="Back" onclick="location.href='carddetails.jsp'">
      <!--
      <p> Not a Customer? <a href="register.jsp">Register</a></p>
      -->
      <p class="errorinfo"><%=emailFormErr != null? emailFormErr: ""%></p>
      <p class="errorinfo"><%=passErr != null? passErr: ""%></p>
    </form>
  </body>
</html>