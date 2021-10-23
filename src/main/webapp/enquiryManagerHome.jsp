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
    <title>Customer Enquiries</title>
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
            <li><a href="customerService.jsp">Home</a></li>

            <li><a href="index.jsp">Logout</a></li>
        </ul>
    </nav>

    <%
        ArrayList<CustomerEnquiry> unresolvedEnquiries = (ArrayList<CustomerEnquiry>) session.getAttribute("unresolvedEnquiries");
        ArrayList<CustomerEnquiry> resolvedEnquiries = (ArrayList<CustomerEnquiry>) session.getAttribute("resolvedEnquiries");
        String enquirySearchErr = (String) session.getAttribute("enquirySearchErr");
        session.setAttribute("enquirySearchErr", "");
    %>

    <div class="wrapper">
        <a href="customerService.jsp">&lt Return</a>

        <h2>Unresolved Enquiries</h2>
        <form method="post" action="ReviewEnquiryServlet">
            <input type="text" name="customerEnquiryId" placeholder="Enquiry ID" required>
            <input type="submit" value="Search">
        </form>

        <span><%=(enquirySearchErr != null ? enquirySearchErr : "")%></span>

            <%
                if (unresolvedEnquiries != null) {
                    %>

        <table class="enquiryTable">
            <tr>
                <th>Enquiry ID</th>
                <th>Enquiry Title</th>
                <th>Enquiry Details</th>
                <th>Date</th>
                <th>Status</th>
            </tr>

        <%
                    for (CustomerEnquiry customerEnquiry: unresolvedEnquiries){
            %>

            <tr>
                <td><%=customerEnquiry.getCustomerEnquiryId()%></td>
                <td><%=customerEnquiry.getEnquiryTitle()%></td>
                <td><%=customerEnquiry.getEnquiryDetails()%></td>
                <td><%=customerEnquiry.getEnquiryDate()%></td>
                <td><%=customerEnquiry.getEnquiryStatus()%></td>
            </tr>
            <%
                }
                    %>
            </table>
            <%
                } else {
            %>

        <p>There are no enquiries to view. </p>

            <%
                }
            %>

        <h2>Resolved Enquiries</h2>

        <%
            if (resolvedEnquiries != null) {
        %>

        <table class="enquiryTable">
            <tr>
                <th>Enquiry ID</th>
                <th>Enquiry Title</th>
                <th>Enquiry Details</th>
                <th>Date</th>
                <th>Status</th>
            </tr>

            <%
                for (CustomerEnquiry customerEnquiry: resolvedEnquiries){
            %>

            <tr>
                <td><%=customerEnquiry.getCustomerEnquiryId()%></td>
                <td><%=customerEnquiry.getEnquiryTitle()%></td>
                <td><%=customerEnquiry.getEnquiryDetails()%></td>
                <td><%=customerEnquiry.getEnquiryDate()%></td>
                <td><%=customerEnquiry.getEnquiryStatus()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
        } else {
        %>

        <p>There are no enquiries to view. </p>

        <%
            }
        %>

    </div>

</body>
</html>
