
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

<form class="box" action="RegisterServlet" method="post" id="register">
    <h1>Register</h1>
    <input type="text" id="email" name="email" autocomplete="off" placeholder="Email Address" required>
    <input type="text" id="fname" name="fname" autocomplete="off" placeholder="First Name" required>
    <input type="text" id="lname" name="lname" autocomplete="off" placeholder="Last Name" required>
    <input type="text" id="phone" name="phone" autocomplete="off" placeholder="Phone Number" required>
    <input type="password" id="password" name="password" autocomplete="off" placeholder="Password" required>
    <input type="password" id="cpassword" name="cpassword" autocomplete="off" placeholder="Confirm Password" required>
    <input type="submit" form="register" name="register" value="Register">
    <input type="button" value="Back" onclick="location.href='index.jsp'">
    <p>Already a Customer? <a href="login.jsp">Click here.</a></p>
</form>

</body>
</html>
