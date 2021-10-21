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
    <p>Address Line 1</p>
    <input type="text" id="address_line_1" name="address_line_1" autocomplete="off" value="${customer.getAddress().getAddressLine1()}" placeholder="Address Line 1" required>
    <p>Address Line 2</p>
    <input type="text" id="address_line_2" name="address_line_2" autocomplete="off" value="${customer.getAddress().getAddressLine2()}" placeholder="Address Line 2">
    <p>Suburb</p>
    <input type="text" id="suburb" name="suburb" autocomplete="off" value="${customer.getAddress().getSuburb()}" placeholder="Suburb" required>
    <p>Postcode</p>
    <input type="number" id="postcode" name="postcode" autocomplete="off" value="${customer.getAddress().getPostCode()}" placeholder="Postcode" required>
    <p>State</p>
    <input type="text" id="state" name="state" autocomplete="off" value="${customer.getAddress().getState()}" placeholder="State" required>
    <input type="submit" form="update" name="update" value="Update Profile">
    <input type="button" value="Back" onclick="location.href='userprofile.jsp'">
    <br>
    <p style="color:red">${editErr}</p>
</form>

</body>
</html>
