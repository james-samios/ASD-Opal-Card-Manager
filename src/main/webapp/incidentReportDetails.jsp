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

    <%
        IncidentReport incidentReport = (IncidentReport)  session.getAttribute("incidentReport");
    %>

    <div class="wrapper">
        <a href="incidentReportList.jsp">&lt Return</a>
        <h2>Report Details</h2>
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
