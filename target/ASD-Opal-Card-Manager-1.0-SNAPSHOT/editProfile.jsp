<%@ page import="group2.asd.uts.edu.au.opal.model.Customer" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/style.css">
    <title>Edit Profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<% Customer customer = (Customer) session.getAttribute("customer");
    String editErr = (String) session.getAttribute("editErr"); %>

<body class="back">

<form class="box" action="EditProfileServlet" method="post" id="update">
    <h1>Edit Profile</h1>
    <br>
    <p>Email Address</p>
    <input type="text" id="email" name="email" autocomplete="off" value="${customer.getEmailAddress()}" placeholder="Email Address" required>
    <p>First Name</p>
    <input type="text" id="fname" name="fname" autocomplete="off" value="${customer.getFirstName()}" placeholder="First Name" required>
    <p>Last Name</p>
    <input type="text" id="lname" name="lname" autocomplete="off" value="${customer.getLastName()}" placeholder="Last Name" required>
    <p>Phone Number</p>
    <input type="text" id="phone" name="phone" autocomplete="off" value="${customer.getPhoneNumber()}" placeholder="Phone Number" required>
    <br>
    <input type="submit" form="update" name="update" value="Update Profile">
    <input type="button" value="Back" onclick="location.href='userprofile.jsp'">
    <br>
    <p><a href="editAddress.jsp">Click here to edit address details.</a></p>
    <p style="color:red">${editErr}</p>
</form>

</body>
</html>
