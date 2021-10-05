<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Customer Enquiry Confirmation</title>
    <link rel="stylesheet" href="css/interface.css">
</head>

<body>

    <div class="navbar">
        <a href="#home">Home</a>
        <a href="enquiryHome.jsp">Make an enquiry</a>
        <a href="incidentReportHome.jsp">Theft or loss</a>
        <a href="#about">Logout</a>
    </div>

    <img src="img/Opal_card_logo.png" alt="Opal card logo"/>

    <div class="enquiryConfirmation">
        <h1>Customer Enquiry Submission Confirmed</h1>
        <p>You enquiry has been successfully submitted. Our team will get in touch with you soon.</p>
        <button onclick="document.location='enquiryHome.jsp'" class="navButton">Return</button>
    </div>



</body>

</html>