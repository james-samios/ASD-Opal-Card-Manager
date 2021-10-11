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
    <link rel="stylesheet" href="CSS/interface.css">
</head>
<body>

    <div class="navbar">
        <a href="userprofile.jsp">Return to profile</a>
        <a href="enquiryHome.jsp">Make an enquiry</a>
        <a href="incidentReportForm.jsp">Theft or loss</a>
        <a href="index.jsp">Logout</a>
    </div>


    <img src="img/Opal_card_logo.png" alt="Opal card logo"/>

    <div class="enquiryHome">
        <h1>Lost or Stolen Opal Cards</h1>
        <p>If your Opal Card was lost or stolen, lodge a report so our team can investigate and freeze your card from unauthorised transactions.</p>
        <button class="button" onclick="document.location='incidentReportForm.jsp'">Make a report</button>
        <h1>My Lodged Reports</h1>
        <p>If you have a lodged a report, you can view your reports and their status.</p>
        <form action="ListIncidentReportServlet" method="post"><input class="button" type="submit" value="View Your Lodged Reports"></form>

    </div>


</body>
</html>
