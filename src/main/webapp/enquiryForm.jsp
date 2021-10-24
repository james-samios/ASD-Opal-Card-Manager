<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Customer Enquiry Form</title>
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
        <a href="enquiryHome.jsp">&lt Return</a>
        <h2>Customer Enquiry Form</h2>
        <p>Welcome to the Customer Enquiry Form page. Please fill out the following details to begin an enquiry.</p>
        <div class="enquirySubmissionForm">


            <form method="post" action="CreateCustomerEnquiryServlet">

                <table>
                    <tr>
                        <td>Enquiry Title:</td>
                        <td><input type="text" name="enquiryTitle" required></td>
                    </tr>
                    <tr>
                        <td>Enquiry Details:</td>
                        <td><textarea name="enquiryDetails" rows="5" cols="30" required></textarea></td>
                    </tr>
                </table>

                <input type="submit" value="Submit" class="submitButton">
            </form>

        </div>
    </div>
</body>

</html>