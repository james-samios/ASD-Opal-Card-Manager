<%--
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
        <a href="#contact">Theft or loss</a>
        <a href="#about">Logout</a>
    </div>


    <img src="img/Opal_card_logo.png" alt="Opal card logo"/>

    <div class="enquiryHome">
        <h1>Make an enquiry</h1>
        <p>Our team are ready to provide you answers to any of your questions.</p>
        <button class="button" onclick="document.location='enquiryForm.jsp'">Make an enquiry</button>
        <h1>Your enquiries</h1>
        <p>Below is a summary of your recent enquiries. We will endeavour to provide you updates as soon as possible.</p>

        <table class="enquiryTable">
            <tr>
                <th>Enquiry Title</th>
                <th>Enquiry Details</th>
                <th>Date</th>
                <th>Status</th>
            </tr>
            <tr>
                <td><a href="enquiryDetails.jsp">How to add funds</a></td>
                <td>Hi, I'm having difficulty adding funds to my card. How do I add funds? Thanks</td>
                <td>06/09/2021</td>
                <td>In progress</td>
            </tr>
            <tr>
                <td>Error in fares</td>
                <td>Hi there, I've recently applied for a fare adjustment but my fare is still the same. I need this fixed.</td>
                <td>05/08/2021</td>
                <td>Resolved</td>
            </tr>
        </table>

    </div>


</body>
</html>
