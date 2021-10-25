<%@ page import="group2.asd.uts.edu.au.opal.model.CustomerEnquiry" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.IncidentReport" %><%--
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
            <li><a href="customerService.jsp">Staff Home</a></li>

            <li><a href="index.jsp">Logout</a></li>
        </ul>
    </nav>

    <%
        ArrayList<IncidentReport> unresolvedReports = (ArrayList<IncidentReport>) session.getAttribute("unresolvedReports");
        ArrayList<IncidentReport> resolvedReports = (ArrayList<IncidentReport>) session.getAttribute("resolvedReports");
        String reportSearchErr = (String) session.getAttribute("reportSearchErr");
        session.setAttribute("reportSearchErr", "");
    %>

    <div class="wrapper">
        <a href="customerService.jsp">&lt Return</a>

        <h2>Unresolved Reports</h2>
        <form method="post" action="ReviewIncidentReportServlet">
            <input type="text" name="incidentReportId" placeholder="Report ID" required>
            <input type="submit" value="Search">
        </form>

        <span><%=(reportSearchErr != null ? reportSearchErr : "")%></span>

            <%
                if (unresolvedReports != null) {
                    %>

        <table class="enquiryTable">
            <tr>
                <th>Report ID</th>
                <th>Report Type</th>
                <th>Details</th>
                <th>Date</th>
                <th>Status</th>
            </tr>

        <%
                    for (IncidentReport incidentReport: unresolvedReports){
            %>

            <tr>
                <td><%=incidentReport.getIncidentReportId()%></td>
                <td><%=incidentReport.getIncidentReportType()%></td>
                <td><%=incidentReport.getIncidentReportDetails()%></td>
                <td><%=incidentReport.getIncidentReportDate()%></td>
                <td><%=incidentReport.getIncidentReportStatus()%></td>
            </tr>
            <%
                }
                    %>
            </table>
            <%
                } else {
            %>

        <p>There are no reports to view. </p>

            <%
                }
            %>

        <h2>Resolved Reports</h2>

        <%
            if (resolvedReports != null) {
        %>

        <table class="enquiryTable">
            <tr>
                <th>Report ID</th>
                <th>Report Type</th>
                <th>Details</th>
                <th>Date</th>
                <th>Status</th>
            </tr>

            <%
                for (IncidentReport incidentReport: resolvedReports){
            %>

            <tr>
                <td><%=incidentReport.getIncidentReportId()%></td>
                <td><%=incidentReport.getIncidentReportType()%></td>
                <td><%=incidentReport.getIncidentReportDetails()%></td>
                <td><%=incidentReport.getIncidentReportDate()%></td>
                <td><%=incidentReport.getIncidentReportStatus()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
        } else {
        %>

        <p>There are no reports to view. </p>

        <%
            }
        %>

    </div>

</body>
</html>
