<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/09/2021
  Time: 12:02 am
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/register.css">
    <title>User Registration Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body class="back">



<form class="box" action="/ASD_Opal_Card_Manager_war_exploded/userprofile.jsp" method="post" id="register">
    <h1>Register</h1>
    <input type="text" id="uname" name="uname" autocomplete="off" placeholder="Username" required>
    <input type="password" id="upassword" name="upassword" autocomplete="off" placeholder="Password" required>
    <input type="password" id="cupassword" name="cupassword" autocomplete="off" placeholder="Confirm Password" required>
    <input type="mail" id="email" name="email" autocomplete="off" placeholder="xxx.xxx@xxx.xxx.xx" required>
    <input type="submit" form="register" name="register" value="Register">
    <input type="button" value="Back" onclick="location.href='http://localhost:8080/ASD_Opal_Card_Manager_war_exploded/'">
    <p> Already a Customer? <a href="login.jsp">Login</a></p>


</form>

</body>
</html>
