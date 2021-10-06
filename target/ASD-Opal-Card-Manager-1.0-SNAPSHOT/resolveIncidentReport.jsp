<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Report Theft or Loss</title>
    <link rel="stylesheet" href="css/interface.css">
</head>

<body>

    <div class="navbar">
        <a href="userprofile.jsp">Return to profile</a>
        <a href="enquiryHome.jsp">Make an enquiry</a>
        <a href="incidentReportForm.jsp">Theft or loss</a>
        <a href="index.jsp">Logout</a>
    </div>

    <img src="img/Opal_card_logo.png" alt="Opal card logo"/>

    <div class="return">
        <a href="incidentReportDetails.jsp">&lt Return</a>
    </div>

    <div class="enquirySubmissionForm">
        <h1>Request to resolve a report</h1>
        <p>Please fill out the reason for resolving your report. Your Opal Card will remain locked until reviewed by our team. We thank you for your patience.</p>

        <form method="post" action="CustomerResolveReportServlet">

            <table>
                <tr>
                    <td>Reason:</td>
                    <td><textarea name="resolveReason" rows="5" cols="30" required></textarea></td>
                </tr>
            </table>

            <input type="submit" value="Submit" class="submitButton">
        </form>

    </div>
</body>

</html>