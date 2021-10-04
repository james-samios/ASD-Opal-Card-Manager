<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Customer Enquiry Form</title>
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

    <div class="return">
        <a href="enquiryHome.jsp">&lt Return</a>
    </div>

    <div class="enquirySubmissionForm">
        <h1>Customer Enquiry Form</h1>
        <p>Welcome to the Customer Enquiry Form page. Please fill out the following details to begin an enquiry.</p>

        <form method="post" action="CreateCustomerEnquiryServlet">

            <table>
                <tr>
                    <td>Enquiry Title:</td>
                    <td><input type="text" name="enquiryTitle" required></td>
                </tr>
                <tr>
                    <td>Enquiry Details:</td>
                    <td><textarea name="enquiryDetails" rows="5" cols="30" name="enquiryDetails" required></textarea></td>
                </tr>
                <tr>
                    <td>Preferred Contact Method:</td>
                    <td>
                        <select name="preferredContactMethod">
                            <option value="Email">Email</option>
                            <option value="Phone">Phone</option>
                        </select>
                    </td>
                </tr>
            </table>

            <input type="submit" value="Submit Enquiry" class="submitButton">
        </form>

    </div>
</body>

</html>