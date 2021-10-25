<%@ page import="group2.asd.uts.edu.au.opal.model.Customer" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.CustomerEnquiry" %><%--
  Created by IntelliJ IDEA.
  User: chrom
  Date: 7/09/2021
  Time: 4:13 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enquiry Details</title>
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
        CustomerEnquiry customerEnquiry = (CustomerEnquiry) session.getAttribute("customerEnquiry");
    %>

    <div class="wrapper">
        <a href="enquiryList.jsp">&lt Return</a>
        <h2>Enquiry Details</h2>

        <%
            if (customerEnquiry.getEnquiryStatus().equals("Resolved")) {
        %>

        <p>This enquiry is currently <span style="color: darkorange"><%=customerEnquiry.getEnquiryStatus()%></span>. Please see below comments.</p>
        <table class="detailsTable">
            <tr>
                <th>Title:</th>
                <td><%=customerEnquiry.getEnquiryTitle()%></td>
            </tr>
            <tr>
                <th>Details:</th>
                <td><%=customerEnquiry.getEnquiryDetails()%></td>
            </tr>
            <tr>
                <th>Staff Comment:</th>
                <td><%=customerEnquiry.getResolveComment()%></td>
            </tr>
        </table>

        <%
            } else {
        %>

        <p>This enquiry is currently <span style="color: darkorange"><%=customerEnquiry.getEnquiryStatus()%></span>. Our team is reviewing your enquiry and will be in touch with you soon.</p>
        <table class="detailsTable">
            <tr>
                <th>Title:</th>
                <td><%=customerEnquiry.getEnquiryTitle()%></td>
            </tr>
            <tr>
                <th>Details:</th>
                <td><%=customerEnquiry.getEnquiryDetails()%></td>
            </tr>
        </table>

        <%
            }
        %>

    </div>

</body>
</html>
