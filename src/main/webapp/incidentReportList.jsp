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
    <link rel="stylesheet" href="css/interface.css">
</head>
<body>

    <div class="navbar">
        <a href="#home">Home</a>
        <a href="enquiryHome.jsp">Make an enquiry</a>
        <a href="incidentReportHome.jsp">Theft or loss</a>
        <a href="#about">Logout</a>
    </div>

    <%
        ArrayList<IncidentReport> incidentReportsList = (ArrayList<IncidentReport>) session.getAttribute("incidentReportsList");
        String reportSearchErr = (String) session.getAttribute("reportSearchErr");
        session.setAttribute("reportSearchErr", "");
    %>

    <img src="img/Opal_card_logo.png" alt="Opal card logo"/>

    <div class="return">
        <a href="incidentReportHome.jsp">&lt Return</a>
    </div>

    <div class="enquiryHome">

        <h1>Recent Reports</h1>
        <p>Below is a summary of your recent reports. We will endeavour to provide you updates as soon as possible.</p>

        <h2>View report details</h2>

        <form method="post" action="IncidentReportDetailsServlet">
            <input type="text" name="incidentReportId" placeholder="Report ID" required>
            <input type="submit" value="Search">
        </form>

        <span><%=(reportSearchErr != null ? reportSearchErr : "")%></span>

            <%
                if (incidentReportsList != null) {
                    for (IncidentReport incidentReport: incidentReportsList){
            %>

        <table class="enquiryTable">
            <tr>
                <th>Report ID</th>
                <th>Report Type</th>
                <th>Details</th>
                <th>Date of Incident</th>
                <th>Status</th>
            </tr>

            <tr>
                <td><%=incidentReport.getIncidentReportId()%></td>
                <td><%=incidentReport.getIncidentReportType()%></td>
                <td><%=incidentReport.getIncidentReportDetails()%></td>
                <td><%=incidentReport.getIncidentReportDate()%></td>
                <td><%=incidentReport.getIncidentReportStatus()%></td>
            </tr>

        </table>

            <%
                }
                } else {
            %>

        <p>There are no reports submitted. <a href="incidentReportForm.jsp">Click here</a> to report a lost or stolen Opal Card.</p>

        <%
            }
        %>

    </div>

</body>
</html>
