<%@ page import="group2.asd.uts.edu.au.opal.object.Card" %>
<%@ page import="java.text.DecimalFormat" %><%--
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
<%
    Card card = (Card)session.getAttribute("card");
    DecimalFormat balanceFormat = new DecimalFormat("$###,###.##");
%>
    <form class="box" action="carddetails.jsp" method="get" id="top_up">
        <h1>Top Up</h1>
        <h3>Card Number</h3>
        <h2><%=card.getCardNumber()%></h2>
        <h3>Balance</h3>
        <h2><%=balanceFormat.format(card.getBalance())%></h2>
        <h3>Top-Up Fees:</h3>
        <label for="twenty">
            <input type="radio" id="twenty" name="amount" value="20" checked>
            $20
            <span></span>
        </label>
        <label for="forty">
            <input type="radio" id="forty" name="amount" value="40">
            $40
            <span></span>
        </label>
        <label for="sixty">
            <input type="radio" id="sixty" name="amount" value="60">
            $60
            <span></span>
        </label>
        <!--
        <h3>Payment Type:</h3>
        <label for="credit_card">
            <input type="radio" id="credit_card" name="pay_type" value="credit_card" checked>
            Credit Card
            <span></span>
        </label>
        <label for="paypal">
            <input type="radio" id="paypal" name="pay_type" value="paypal">
            PayPal
            <span></span>
        </label>
        -->
        <h3>Payment Details</h3>
        <input type="text" id="pay_number" name="pay_number" autocomplete="off" placeholder="Payment Number" required>
        <input type="text" id="pay_ccv" name="pay_cvc" autocomplete="off" placeholder="CVC">
        <input type="text" id="pay_name" name="pay_name" autocomplete="off" placeholder="Card Name">
        <input type="submit" form="top_up" name="confirm" value="Confirm">
        <input type="button" value="Back" onclick="location.href='carddetails.jsp'">
    </form>

</body>
</html>
