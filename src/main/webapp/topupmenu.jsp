<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/09/2021
  Time: 2:43 am
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--//STEP 1. Import required packages --%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/topupmenu.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Top Up Menu</title>
</head>
<body>
<form class="box" action="/ASD_Opal_Card_Manager_war_exploded/carddetails.jsp" method="get" id="topup">
    <h1>Top-up</h1>
    <h3>Card Number</h3>
    <h3>xxxx-xxxx-xxxx-xxxx</h3>
    <h3>Top-Up Fees:</h3>
    <label for="twenty">
        <input type="radio" id="twenty" name="ttype" value="20" checked>
        $20
        <span></span>
    </label>
    <label for="forty">
        <input type="radio" id="forty" name="ttype" value="40">
        $40
        <span></span>
    </label>
    <label for="sixty">
        <input type="radio" id="sixty" name="ttype" value="60">
        $60
        <span></span>
    </label>
    <h3>Payment Type:</h3>
    <label for="creditcard">
        <input type="radio" id="creditcard" name="ptype" value="credit" checked>
        Credit Card
        <span></span>
    </label>
    <label for="paypal">
        <input type="radio" id="paypal" name="ptype" value="paypal">
        PayPal
        <span></span>
    </label>
    <h3>Payment Number</h3>
    <input type="text" id="pnumber" name="pnumber" autocomplete="off" placeholder="Payment Number" required>
    <input type="text" id="pccv" name="pccv" autocomplete="off" placeholder="CCV">
    <input type="submit" form="topup" name="confirm" value="Confirm">
    <input type="button" value="Back" onclick="location.href='http://localhost:8080/ASD_Opal_Card_Manager_war_exploded/carddetails.jsp'">
</form>

</body>
</html>
