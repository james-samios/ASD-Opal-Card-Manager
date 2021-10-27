<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Customer Enquiry Confirmation</title>
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
            <li><a href="userprofile.jsp">Return to profile</a></li>

            <li><a href="enquiryHome.jsp">Make an enquiry</a></li>

            <li><a href="incidentReportHome.jsp">Theft or loss</a></li>

            <li><a href="index.jsp">Logout</a></li>
        </ul>
    </nav>

    <div class="wrapper">
        <h1>Customer Enquiry Submission Confirmed</h1>
        <p>You enquiry has been successfully submitted. Our team will get in touch with you soon.</p>
        <button onclick="document.location='enquiryHome.jsp'" class="navButton">Return</button>
    </div>



</body>

</html>