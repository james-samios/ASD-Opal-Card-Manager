<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/style.css">
    <title>Login Page</title>
</head>

<% String logErr = (String) session.getAttribute("logErr"); %>

<body>
    <form class="box" action="LoginServlet" method="post" id="login">
        <h1>Login</h1>
        <input type="text" id="user_email" name="user_email" autocomplete="off" placeholder="Email Address" required>
        <input type="password" id="user_password" name="user_password" autocomplete="off" placeholder="Password" required>
        <input type="submit" form="login" name="login" value="Login">
        <input type="button" value="Back" onclick="location.href='index.jsp'">
        <br>
        <p style="color:red">${logErr}</p>
        <br>
        <p>Don't have an account? <a href="register.jsp">Register here</a></p>
    </form>
</body>
</html>
