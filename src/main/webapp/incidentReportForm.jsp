<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Report Theft or Loss</title>
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

    <div class="wrapper">
        <a href="incidentReportHome.jsp">&lt Return</a>
        <h2>Report Theft or Loss</h2>
        <p>Please fill out the following details to report a case of a stolen or lost Opal Card.</p>

        <div class="enquirySubmissionForm">
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
    </div>
</body>

</html>