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
    <title>Card Details Page</title>
</head>
<body>


<nav class="customer">
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">Card Details</label>
    <ul>
        <li><a href="carddetails.jsp">Activate Card</a></li>

        <li><a href="topupmenu.jsp">Top Up</a></li>

        <li><a href="login.jsp">linked To Account</a></li>

        <li><a href="index.jsp">Logout</a></li>
    </ul>
</nav>

<center>
    <section>
        <table class="table-style">
            <tbody>
            <tr>
                <td class="table-header customer">Card Number</td>
                <td data-label="First Name">xxxx-xxxx-xxxx-xxxx</td>
            </tr>
            <tr>
                <td class="table-header customer">Status</td>
                <td data-label="Last Name"></td>
            </tr>
            <tr>
                <td class="table-header customer">Balance</td>
                <td data-label="Password"></td>
            </tr>
            <tr>
                <td class="table-header customer">Email</td>
                <td data-label="Email"></td>
            </tr>
            <tr>
                <td class="table-header customer">Card Owner</td>
                <td data-label="Birthday"></td>
            </tr>
            <tr>
                <td class="table-header customer">Owner Phone</td>
                <td data-label="Phone"></td>
            </tr>
            </tbody>
        </table>
    </section>
</center>
</body>
</html>
