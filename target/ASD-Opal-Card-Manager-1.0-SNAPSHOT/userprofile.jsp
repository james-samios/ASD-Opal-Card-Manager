<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/09/2021
  Time: 1:25 am
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/userprofile.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <title>User Profile Page</title>
</head>
<body>


<nav class="customer">
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">My Profile</label>
    <ul>
        <li><a href="linkedopalcards.jsp">My OpalCard</a></li>

        <li><a href="EditServlet">Edit Profile</a></li>

        <li><a href="ChangePasswordServlet">Change Password</a></li>

        <li><a href="DeleteUserServlet">Delete Account</a></li>

        <li><a href="payment.jsp">Payment</a></li>

        <li><a href="index.jsp">Logout</a></li>
        
        <li><a href="tripmanager.jsp">Trip Planner</a></li>

    </ul>
</nav>

<center>
    <section>
        <table class="table-style">
            <tbody>
            <tr>
                <td class="table-header customer">First Name</td>
                <td data-label="First Name"></td>
            </tr>
            <tr>
                <td class="table-header customer">Last Name</td>
                <td data-label="Last Name"></td>
            </tr>
            <tr>
                <td class="table-header customer">Password</td>
                <td data-label="Password"></td>
            </tr>
            <tr>
                <td class="table-header customer">Email</td>
                <td data-label="Email"></td>
            </tr>
            <tr>
                <td class="table-header customer">Birthday</td>
                <td data-label="Birthday"></td>
            </tr>
            <tr>
                <td class="table-header customer">Phone</td>
                <td data-label="Phone"></td>
            </tr>
            </tbody>
        </table>
    </section>
</center>
</body>
</html>
