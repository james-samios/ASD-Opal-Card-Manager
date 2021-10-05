<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Report Theft or Loss</title>
    <link rel="stylesheet" href="css/interface.css">
</head>

<body>

    <div class="navbar">
        <a href="#home">Home</a>
        <a href="enquiryHome.jsp">Make an enquiry</a>
        <a href="incidentReportForm.jsp">Theft or loss</a>
        <a href="#about">Logout</a>
    </div>

    <img src="img/Opal_card_logo.png" alt="Opal card logo"/>

    <div class="return">
        <a href="incidentReportHome.jsp">&lt Return</a>
    </div>

    <div class="enquirySubmissionForm">
        <h1>Report Theft or Loss</h1>
        <p>Please fill out the following details to report a case of a stolen or lost Opal Card.</p>

        <form method="post" action="CreateIncidentReportServlet">

            <table>
                <tr>
                    <td>Report Type:</td>
                    <td>
                        <select name="incidentReportType">
                            <option value="Missing Opal Card">Missing Opal Card</option>
                            <option value="Stolen Opal Card">Stolen Opal Card</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Report Details:</td>
                    <td><textarea name="incidentReportDetails" rows="5" cols="30" required></textarea></td>
                </tr>
                <tr>
                    <td>Date the incident occurred:</td>
                    <td><input type="date" name="incidentReportDate"></td>
                </tr>
            </table>

            <input type="submit" value="Lodge Report" class="submitButton">
        </form>

    </div>
</body>

</html>