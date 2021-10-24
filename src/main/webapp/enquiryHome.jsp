<%@ page import="group2.asd.uts.edu.au.opal.model.CustomerEnquiry" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 7/09/2021
  Time: 1:51 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Enquiries</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <nav class="customer">
        <input type="checkbox" id="check">
        <label for="check" class="checkbtn">
            <i class="fas fa-bars"></i>
        </label>
        <label class="logo">Customer Support</label>
        <ul>
            <li><a href="userprofile.jsp">Return to profile</a></li>

            <li><a href="enquiryHome.jsp">Make an enquiry</a></li>

            <li><a href="incidentReportHome.jsp">Theft or loss</a></li>

            <li><a href="index.jsp">Logout</a></li>
        </ul>
    </nav>

    <div class="wrapper">
        <h2>Make an enquiry</h2>
        <p>Our team is ready to provide answers to any of your questions.</p>
        <button class="button1" onclick="document.location='enquiryForm.jsp'">Make an enquiry</button>
        <h2>My enquiries</h2>
        <p>If you have submitted enquiries you can view your enquiries and their status.</p>
        <form action="ListEnquiriesServlet" method="post"><input class="button1" type="submit" value="View Your Enquiries"></form>

    </div>


</body>
</html>
