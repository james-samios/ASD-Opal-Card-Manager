<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Customer Enquiry Form</title>
</head>

<body>

    <h1>Customer Enquiry Form</h1>
    <p>Welcome to the Customer Enquiry Form page. Please fill out the following details to begin an enquiry.</p>

    <div id="enquirySubmissionForm">

        <form action="enquirySubmission">

            <table>
                <tr>
                    <td>Enquiry Title:</td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>Enquiry Details:</td>
                    <td><input type="text"></td>
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

            <input type="submit" value="Submit Enquiry">

        </form>
    </div>

</body>

</html>