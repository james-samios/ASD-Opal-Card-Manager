<%@ page import="group2.asd.uts.edu.au.opal.model.Customer" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.Address" %>
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

<% Customer customer = (Customer) session.getAttribute("customer"); %>

<nav class="customer">
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">My Profile</label>
    <ul>
        <li><a href="LinkedOpalCardsServlet">Opal Cards</a></li>

        <li><a href="EditProfileServlet">Edit Profile</a></li>

        <li><a href="ChangePasswordServlet">Change Password</a></li>

        <li><a href="DeleteUserServlet">Delete Account</a></li>

        <li><a href="payment.jsp">Payment</a></li>

        <li><a href="enquiryHome.jsp">Make an Enquiry</a></li>

        <li><a href="incidentReportHome.jsp">Report a lost or stolen Opal Card</a></li>

        <li><a href="index.jsp">Logout</a></li>
    </ul>
</nav>

<center>
    <section>
        <table class="table-style">
            <tbody>
                <tr>
                    <td class="table-header customer">First Name</td>
                    <td data-label="First Name">${customer.getFirstName()}</td>
                </tr>
                <tr>
                    <td class="table-header customer">Last Name</td>
                    <td data-label="Last Name">${customer.getLastName()}</td>
                </tr>
                <tr>
                    <td class="table-header customer">Email Address</td>
                    <td data-label="Email Address">${customer.getEmailAddress()}</td>
                </tr>
                <tr>
                    <td class="table-header customer">Phone Number</td>
                    <td data-label="Phone Number">${customer.getPhoneNumber()}</td>
                </tr>
                <tr>
                    <td class="table-header customer">Address Line 1</td>
                    <td data-label="Address Line 1">${customer.getAddress().getAddressLine1()}</td>
                </tr>
                <tr>
                    <td class="table-header customer">Address Line 2</td>
                    <td data-label="Address Line 2">${customer.getAddress().getAddressLine2()}</td>
                </tr>
                <tr>
                    <td class="table-header customer">Suburb</td>
                    <td data-label="Suburb">${customer.getAddress().getSuburb()}</td>
                </tr>
                <tr>
                    <td class="table-header customer">Postcode</td>
                    <td data-label="Postcode">${customer.getAddress().getPostCode()}</td>
                </tr>
                <tr>
                    <td class="table-header customer">State</td>
                    <td data-label="State">${customer.getAddress().getState()}</td>
                </tr>
            </tbody>
        </table>

        <button onclick="window.location.href='changepassword.jsp'" type="button">Change Password</button>
        <br>
        <button onclick="window.location.href='deleteaccount.jsp'" type="button">Delete Account</button>
    </section>
</center>
</body>
</html>
