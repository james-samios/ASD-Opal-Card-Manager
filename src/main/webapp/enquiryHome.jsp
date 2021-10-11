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
    <link rel="stylesheet" href="CSS/interface.css">
</head>
<body>

    <div class="navbar">
        <a href="userprofile.jsp">Return to profile</a>
        <a href="enquiryHome.jsp">Make an enquiry</a>
        <a href="incidentReportHome.jsp">Theft or loss</a>
        <a href="index.jsp">Logout</a>
    </div>


    <img src="img/Opal_card_logo.png" alt="Opal card logo"/>

    <div class="enquiryHome">
        <h1>Make an enquiry</h1>
        <p>Our team is ready to provide answers to any of your questions.</p>
        <button class="button" onclick="document.location='enquiryForm.jsp'">Make an enquiry</button>
        <h1>My enquiries</h1>
        <p>If you have submitted enquiries you can view your enquiries and their status.</p>
        <form action="ListEnquiriesServlet" method="post"><input class="button" type="submit" value="View Your Enquiries"></form>

    </div>


</body>
</html>
