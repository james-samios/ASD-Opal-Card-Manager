<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payment Information</title>
</head>
<body>
<h1>Payment Information</h1>
<form name="PaymentForm" action="results.jsp" method="post">
    <table>
        <tbody>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="first" value=""> </td>

        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="last" value=""> </td>

        </tr>
        <tr>
            <td>DOB:</td>
            <td><input type="text" name="dob" value=""> </td>

        </tr>
        <tr>
            <td>Card Number:</td>
            <td><input type="text" name="card_number" value=""> </td>

        </tr>
        <tr>
            <td>CVC:</td>
            <td><input type="text" name="cvc" value=""> </td>

        </tr>
        <tr>
            <td>Expiry Date:</td>
            <td><input type="text" name="expiry_date" value=""> </td>

        </tr>

        </tbody>
    </table>
    <input type="reset" value="Clear" id="clear">
    <input type="submit" value="Save" id="submmit">

</form>
</body>
</html>


