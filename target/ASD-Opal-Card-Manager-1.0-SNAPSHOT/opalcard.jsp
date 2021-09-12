<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/09/2021
  Time: 12:01 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Opal Card Signin Page</title>
    <link rel="stylesheet" href="CSS/opalcard.css">
</head>
<body>
    <form class="box" action="CardLoginServlet" method="post" id="signin">
        <h1>Opal Card</h1>
        <input type="text" id="cardnumber" name="cnumber" autocomplete="off" placeholder="Card Number">
        <input type="password" id="cardpin" name="cpin" autocomplete="off" placeholder="Card Pin">
        <input type="submit" form="signin" name="signin" value="Sign in">
        <input type="button" value="Back" onclick="location.href='index.jsp'">
    </form>
</body>
</html>
