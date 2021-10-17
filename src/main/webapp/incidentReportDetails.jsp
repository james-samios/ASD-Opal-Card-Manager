<%@ page import="group2.asd.uts.edu.au.opal.model.Customer" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.CustomerEnquiry" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.IncidentReport" %><%--
  Created by IntelliJ IDEA.
  User: chrom
  Date: 7/09/2021
  Time: 4:13 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report Details</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>

    <div class="navbar">
        <a href="userprofile.jsp">Return to profile</a>
        <a href="enquiryHome.jsp">Make an enquiry</a>
        <a href="incidentReportHome.jsp">Theft or loss</a>
        <a href="index.jsp">Logout</a>
    </div>

    <%
        IncidentReport incidentReport = (IncidentReport)  session.getAttribute("incidentReport");
    %>

    <img src="img/Opal_card_logo.png" alt="Opal card logo"/>

    <div class="return">
        <a href="incidentReportList.jsp">&lt Return</a>
    </div>

    <div class="enquiryDetails">
        <h1>Report Details</h1>
        <p>This report is currently <span style="color: darkorange"><%=incidentReport.getIncidentReportStatus()%></span>. Our team is investigating your report and will be in touch with you soon.</p>
        <table class="detailsTable">
            <tr>
                <th>Report Type:</th>
                <td><%=incidentReport.getIncidentReportType()%></td>
            </tr>
            <tr>
                <th>Details:</th>
                <td><%=incidentReport.getIncidentReportDetails()%></td>
            </tr>
            <tr>
                <th>Comments:</th>
                <td>TO DO</td>
            </tr>
        </table>

        <p>If you no longer need to continue with the report, <a href="resolveIncidentReport.jsp">click here</a> to request an early resolution.</p>

        <div class="addComments">
            <h2>Add Comments</h2>
            <p>You can provide comments to your report if you have further details.</p>
            <form>
                <textarea name="enquiryComments" rows="5" col="50"></textarea>
                <div style="padding: 10px;">
                    <input type="submit" value="Add comment" class="submitButton">
                </div>
            </form>
        </div>

    </div>

</body>
</html>
