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
    <title>Opal Card Theft or Loss</title>
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

            <li><a href="enquiryForm.jsp">Make an enquiry</a></li>

            <li><a href="incidentReportHome.jsp">Theft or loss</a></li>

            <li><a href="index.jsp">Logout</a></li>
        </ul>
    </nav>

    <div class="wrapper">
        <h2>Lost or Stolen Opal Cards</h2>
        <p class="sectionText">If your Opal Card was lost or stolen, lodge a report so our team can investigate and freeze your card from unauthorised transactions.</p>
        <button class="button1" onclick="document.location='incidentReportForm.jsp'">Make a report</button>
        <h2>My Lodged Reports</h2>
        <p class="sectionText">If you have a lodged a report, you can view your reports and their status.</p>
        <form action="ListIncidentReportServlet" method="post"><input class="button1" type="submit" value="View Your Lodged Reports"></form>

    </div>


</body>
</html>
