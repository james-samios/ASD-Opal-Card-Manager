<%@ page import="group2.asd.uts.edu.au.opal.model.Card" %>
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
        <link rel="stylesheet" href="CSS/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Top Up Menu</title>
    </head>
    <body>
        <%
            Card card = (Card)session.getAttribute("card");
            DecimalFormat balanceFormat = new DecimalFormat("$###,###.##");
            String cardNumberFormErr = (String)session.getAttribute("cardNumberFormErr");
            String cardNameErr = (String)session.getAttribute("cardNameErr");
            String cardCvcErr = (String)session.getAttribute("cardCvcErr");
            String cardExpiryErr = (String)session.getAttribute("cardExpiryErr");
            String previousPaymentAmount = (String)session.getAttribute("previous_payment_amount");
            String previousPaymentNumber = (String)session.getAttribute("previous_payment_number");
            String previousPaymentOwner = (String)session.getAttribute("previous_payment_owner");
            String previousPaymentCvc = (String)session.getAttribute("previous_payment_cvc");
            String previousPaymentExpiry = (String)session.getAttribute("previous_payment_expiry");
            String selectedAmount = previousPaymentAmount == null || previousPaymentAmount.equals("20") ? "20":
                    previousPaymentAmount.equals("40")? "40": "60";
            String checked = "checked";
            String empty = "";
        %>
        <form class="box" action="TopUpServlet" method="post" id="top_up">
            <h1>Top Up</h1>
            <h3>Card Number</h3>
            <h2><%=card.getCardNumber()%></h2>
            <h3>Balance</h3>
            <h2><%=balanceFormat.format(card.getBalance())%></h2>
            <h3>Top-Up Fees:</h3>
            <label for="twenty">
                <input type="radio" id="twenty" name="amount" <%=selectedAmount.equals("20")? checked:empty%> value="20">
                $20
                <span></span>
            </label>
            <label for="forty">
                <input type="radio" id="forty" name="amount" <%=selectedAmount.equals("40")? checked:empty%> value="40">
                $40
                <span></span>
            </label>
            <label for="sixty">
                <input type="radio" id="sixty" name="amount" <%=selectedAmount.equals("60")? checked:empty%> value="60">
                $60
                <span></span>
            </label>
            <h3>Payment Details</h3>
            <label>
                <input type="text" name="payment_number" value="<%=previousPaymentNumber != null? previousPaymentNumber:""%>" autocomplete="off" placeholder="Payment Number" required>
            </label>
            <label>
                <input type="text" name="payment_cvc" value="<%=previousPaymentCvc != null? previousPaymentCvc:""%>" autocomplete="off" placeholder="CVC">
            </label>
            <label>
                <input type="text" name="payment_owner" value="<%=previousPaymentOwner != null? previousPaymentOwner:""%>" autocomplete="off" placeholder="Card Name">
            </label>
            <label>
                <input type="text" name="payment_expiry" value="<%=previousPaymentExpiry != null? previousPaymentExpiry:""%>" autocomplete="off" placeholder="XX/XX">
            </label>
            <input type="submit" form="top_up" name="confirm" value="Confirm">
            <input type="button" value="Back" onclick="location.href='carddetails.jsp'">
            <p class="errorinfo"><%=cardNumberFormErr != null? cardNumberFormErr: empty%></p>
            <p class="errorinfo"><%=cardCvcErr != null? cardCvcErr: empty%></p>
            <p class="errorinfo"><%=cardNameErr != null? cardNameErr: empty%></p>
            <p class="errorinfo"><%=cardExpiryErr != null? cardExpiryErr: empty%></p>
        </form>
    </body>
</html>