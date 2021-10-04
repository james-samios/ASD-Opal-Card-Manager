<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment Information</title>
</head>
<%

    String first = request.getParameter("first");
    String last = request.getParameter("last");
    String dob = request.getParameter("dob");
    String card_number = request.getParameter("card_number");
    String cvc = request.getParameter("cvc");
    String expiry_date = request.getParameter("expiry_date");


%>
<body>
<h1>Payment Information</h1>
<table border="1">
    <tbody>
    <tr>
        <td>First Name:</td>
        <td><%=first%></td>
    </tr>

    <tr>
        <td>Last Name:</td>
        <td><%=last%></td>
    </tr>

    <tr>
        <td>Date of Birth:</td>
        <td><%=dob%></td>

    </tr>

    <tr>
        <td>Card Number:</td>
        <td><%=card_number%></td>
    </tr>

    <tr>
        <td>CVC:</td>
        <td><%=cvc%></td>

    </tr>

    <tr>
        <td>Expiry Date:</td>
        <td><%=expiry_date%></td>
    </tr>

    </tbody>

</table>
</body>
</html>
