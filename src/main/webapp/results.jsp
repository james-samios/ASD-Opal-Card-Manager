<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment Information</title>
</head>
<%
    String first_Name = request.getParameter(first);
    String Last_Name = request.getParameter(last);
    String dateOfBirth = request.getParameter(dob);
    String cardNumber = request.getParameter(card_number);
    String Cvc = request.getParameter(cvc);
    String expiryDate = request.getParameter(expiry_date));


%>
<body>
<h1>Payment Information</h1>
<table border="1">
    <tbody>
    <tr>
        <td>First Name:</td>
        <td><%first_Name%></td>
    </tr>

    <tr>
        <td>Last Name:</td>
        <td><%Last_Name%></td>
    </tr>

    <tr>
        <td>Date of Birth:</td>
        <td><%dateOfBirth%></td>

    </tr>

    <tr>
        <td>Card Number:</td>
        <td><%cardNumber%></td>
    </tr>

    <tr>
        <td>CVC:</td>
        <td><%Cvc%></td>

    </tr>

    <tr>
        <td>Expiry Date:</td>
        <td><%expiryDate%></td>
    </tr>

    </tbody>

</table>
</body>
</html>
