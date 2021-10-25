<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/style.css">
    <title>Change Password</title>
</head>

<% String updatePassErr = (String) session.getAttribute("updatePassErr"); %>

<body>
    <form class="box" action="ChangePasswordServlet" method="post" id="changePass">
        <h1>Change Password</h1>
        <br>
        <p>Please enter your existing password and the new one you'd like. Keep in mind there is a minimum requirement of 8 characters.</p>
        <br>
        <label>
            <input type="password" form="changePass" name="password" placeholder="Current Password">
        </label>
        <br>
        <label>
            <input type="password" form="changePass" name="npassword" placeholder="New Password">
        </label>
        <label>
            <input type="password" form="changePass" name="npassword2" placeholder="New Password">
        </label>
        <br>
        <p style="color:red">${updatePassErr}</p>
        <br>
        <input type="submit" form="changePass" name="changePass" value="Change Password">
    </form>
</body>
</html>
