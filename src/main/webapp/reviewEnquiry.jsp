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
    <title>Review Enquiry</title>
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
            <li><a href="index.jsp">Logout</a></li>
        </ul>
    </nav>

    <%
        CustomerEnquiry customerEnquiry = (CustomerEnquiry) session.getAttribute("customerEnquiry");
    %>

    <div class="wrapper">
        <a href="enquiryManagerHome.jsp">&lt Return</a>
        <h2>Enquiry Details</h2>
        <table class="detailsTable">
            <tr>
                <th>Title:</th>
                <td><%=customerEnquiry.getEnquiryTitle()%></td>
            </tr>
            <tr>
                <th>Status:</th>
                <td><%=customerEnquiry.getEnquiryStatus()%></td>
            </tr>
            <tr>
                <th>Details:</th>
                <td><%=customerEnquiry.getEnquiryDetails()%></td>
            </tr>
        </table>

        <div class="addComments">
            <h2>Resolve Enquiry</h2>
            <form method="post" action="ResolveEnquiryServlet">
                <textarea name="resolveComment" rows="5" col="50" required></textarea>
                <div style="padding: 10px;">
                    <input type="submit" value="Resolve" class="submitButton">
                </div>
            </form>
        </div>

    </div>

</body>
</html>
