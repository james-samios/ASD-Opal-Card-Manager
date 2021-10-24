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
            <li><a href="userprofile.jsp">Return to profile</a></li>

            <li><a href="enquiryHome.jsp">Make an enquiry</a></li>

            <li><a href="incidentReportHome.jsp">Theft or loss</a></li>

            <li><a href="index.jsp">Logout</a></li>
        </ul>
    </nav>

    <%
        ArrayList<CustomerEnquiry> customerEnquiryList = (ArrayList<CustomerEnquiry>) session.getAttribute("enquiriesList");
        String enquirySearchErr = (String) session.getAttribute("enquirySearchErr");
        session.setAttribute("enquirySearchErr", "");
    %>

    <div class="wrapper">
        <a href="enquiryHome.jsp">&lt Return</a>
        <h2>Your enquiries</h2>
        <p>Below is a summary of your recent enquiries. We will endeavour to provide you updates as soon as possible.</p>

        <h2>Search an enquiry</h2>

        <form method="post" action="EnquiryDetailsServlet">
            <input type="text" name="customerEnquiryId" placeholder="Enquiry ID" required>
            <input type="submit" value="Search">
        </form>

        <span><%=(enquirySearchErr != null ? enquirySearchErr : "")%></span>

            <%
                if (customerEnquiryList != null) {
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
                    for (CustomerEnquiry customerEnquiry: customerEnquiryList){
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

        <p>There are no enquiries to view. <a href="enquiryForm.jsp">Click here</a> to submit an enquiry.</p>

            <%
                }
            %>
    </div>

</body>
</html>
