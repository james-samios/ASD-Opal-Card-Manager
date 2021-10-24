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
    <title>Report List</title>
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
        ArrayList<IncidentReport> incidentReportsList = (ArrayList<IncidentReport>) session.getAttribute("incidentReportsList");
        String reportSearchErr = (String) session.getAttribute("reportSearchErr");
        session.setAttribute("reportSearchErr", "");
    %>



    <div class="wrapper">

        <a href="incidentReportHome.jsp">&lt Return</a>

        <h2>Recent Reports</h2>
        <p>Below is a summary of your recent reports. We will endeavour to provide you updates as soon as possible.</p>

        <h2>View report details</h2>

        <form method="post" action="IncidentReportDetailsServlet">
            <input type="text" name="incidentReportId" placeholder="Report ID" required>
            <input type="submit" value="Search">
        </form>

        <span><%=(reportSearchErr != null ? reportSearchErr : "")%></span>

            <%
                if (incidentReportsList != null) {
                    %>

        <table class="enquiryTable">
            <tr>
                <th>Report ID</th>
                <th>Report Type</th>
                <th>Details</th>
                <th>Date of Incident</th>
                <th>Status</th>
            </tr>

        <%
                    for (IncidentReport incidentReport: incidentReportsList){
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

        <p>There are no reports submitted. <a href="incidentReportForm.jsp">Click here</a> to report a lost or stolen Opal Card.</p>

        <%
            }
        %>

    </div>

</body>
</html>
