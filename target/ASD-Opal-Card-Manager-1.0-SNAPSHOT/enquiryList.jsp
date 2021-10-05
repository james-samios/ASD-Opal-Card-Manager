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
        ArrayList<CustomerEnquiry> customerEnquiryList = (ArrayList<CustomerEnquiry>) session.getAttribute("enquiriesList");
        String enquirySearchErr = (String) session.getAttribute("enquirySearchErr");
        session.setAttribute("enquirySearchErr", "");
    %>

    <img src="img/Opal_card_logo.png" alt="Opal card logo"/>

    <div class="return">
        <a href="enquiryHome.jsp">&lt Return</a>
    </div>

    <div class="enquiryHome">

        <h1>Your enquiries</h1>
        <p>Below is a summary of your recent enquiries. We will endeavour to provide you updates as soon as possible.</p>

        <h2>Search an enquiry</h2>

        <form method="post" action="EnquiryDetailsServlet">
            <input type="text" name="customerEnquiryId" placeholder="Enquiry ID" required>
            <input type="submit" value="Search">
        </form>

        <span><%=(enquirySearchErr != null ? enquirySearchErr : "")%></span>

        <table class="enquiryTable">
            <tr>
                <th>Enquiry ID</th>
                <th>Enquiry Title</th>
                <th>Enquiry Details</th>
                <th>Date</th>
                <th>Status</th>
            </tr>

            <%
                if (customerEnquiryList != null) {
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

    </div>
    <%
        }
    %>

</body>
</html>
