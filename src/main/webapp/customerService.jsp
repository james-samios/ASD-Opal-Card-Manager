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
    <title>Customer Support Management</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>

    <nav class="customer">
        <input type="checkbox" id="check">
        <label for="check" class="checkbtn">
            <i class="fas fa-bars"></i>
        </label>
        <label class="logo">Customer Support</label>
        <ul>
            <li><a href="faremanagement.jsp">Staff Home</a></li>
            <li><a href="index.jsp">Logout</a></li>
        </ul>
    </nav>

    <div class="wrapper">
        <h2>Review Customer Enquiries</h2>
        <form action="ListUnresolvedEnquiriesServlet" method="post"><input class="button1" type="submit" value="Review Enquiries"></form>
        <h2>Review Incident Reports</h2>
        <form action="IncidentReportReviewListServlet" method="post"><input class="button1" type="submit" value="Review Reports"></form>
    </div>

</body>
</html>
