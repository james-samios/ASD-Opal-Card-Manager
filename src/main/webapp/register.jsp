<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Opal - Login</title>
</head>
<body>
<h1><%= "Register new Account" %>
</h1>
<br/>
    <form action="RegisterServlet" method="post">
        <label for="fname"><b>First Name</b></label>
        <input type="text" placeholder="John" name="fname" required>

        <label for="lname"><b>Last Name</b></label>
        <input type="text" placeholder="Smith" name="lname" required>

        <label for="email"><b>Email Address</b></label>
        <input type="text" placeholder="john.smith@email.com" name="email" required>

        <label for="phone"><b>Phone Number</b></label>
        <input type="text" placeholder="0412 345 678" name="phone" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <button type="submit">Register Account</button>
        <label>
            <input type="checkbox" checked="checked" name="offers"> Receive Opal Card Updates via Email
        </label>
    </form>
</body>
</html>