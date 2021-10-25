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

        <%
            if (incidentReport.getIncidentReportStatus().equals("Resolved")) {
        %>

        <p>This report is currently <span style="color: darkorange"><%=incidentReport.getIncidentReportStatus()%></span>. Please see below comments.</p>
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
                <th>Staff Comment:</th>
                <td><%=incidentReport.getResolveComment()%></td>
            </tr>
        </table>

        <%
        } else if (incidentReport.getIncidentReportStatus().equals("Customer Resolution Requested")){
        %>

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
        </table>

        <%
            } else {
        %>

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
        </table>

        <p>If you no longer need to continue with the report, <a href="resolveIncidentReport.jsp">click here</a> to request an early resolution.</p>

        <%
            }
        %>

    </div>

</body>
</html>
