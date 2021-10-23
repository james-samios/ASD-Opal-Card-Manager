<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Customer Enquiry Confirmation</title>
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

    <img src="img/Opal_card_logo.png" alt="Opal card logo"/>

    <div class="enquiryConfirmation">
        <h1>Customer Enquiry Submission Confirmed</h1>
        <p>You enquiry has been successfully submitted. Our team will get in touch with you soon.</p>
        <button onclick="document.location='enquiryHome.jsp'" class="navButton">Return</button>
    </div>



</body>

</html>