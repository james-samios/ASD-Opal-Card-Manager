<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Report Theft or Loss</title>
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
        <a href="incidentReportDetails.jsp">&lt Return</a>
        <h2>Request to resolve a report</h2>
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