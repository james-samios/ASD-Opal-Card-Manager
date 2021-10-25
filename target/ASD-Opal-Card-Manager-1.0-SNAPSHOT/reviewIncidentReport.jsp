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
    <title>Review Incident Report</title>
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
            <li><a href="index.jsp">Logout</a></li>
        </ul>
    </nav>

    <%
        IncidentReport incidentReport = (IncidentReport) session.getAttribute("incidentReport");
    %>

    <div class="wrapper">
        <a href="incidentReportManagerHome.jsp">&lt Return</a>
        <h2>Report Details</h2>
        <table class="detailsTable">
            <tr>
                <th>Report Type:</th>
                <td><%=incidentReport.getIncidentReportType()%></td>
            </tr>
            <tr>
                <th>Status:</th>
                <td><%=incidentReport.getIncidentReportStatus()%></td>
            </tr>
            <tr>
                <th>Details:</th>
                <td><%=incidentReport.getIncidentReportDetails()%></td>
            </tr>
        </table>

        <div class="addComments">
            <h2>Review Report</h2>
            <form method="post" action="ResolveOrEscalateReportServlet">
                <select name="updatedStatus" required>
                    <option value="Resolve">Resolve</option>
                    <option value="Escalate">Escalate</option>
                </select>
                <textarea name="resolveComment" rows="5" col="50" required></textarea>
                <div style="padding: 10px;">
                    <input type="submit" value="Submit" class="submitButton">
                </div>
            </form>
        </div>

    </div>

</body>
</html>
