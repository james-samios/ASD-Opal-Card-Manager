<%@ page import="group2.asd.uts.edu.au.opal.object.Card" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/09/2021
  Time: 12:01 am
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="group2.asd.uts.edu.au.opal.object.Card"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Opal Card Signin Page</title>
    <link rel="stylesheet" href="CSS/opalcard.css">
</head>
<body>
    <%
        String redirectURL = "http://localhost:8080/opcarddetails.jsp";
        String cardNumberFormErr = (String)session.getAttribute("cardNumberFormErr");
        System.out.println(cardNumberFormErr);
        String cardPinFormErr = (String)session.getAttribute("cardPinFormErr");
        String cardNumAndPinErr = (String)session.getAttribute("cardNumAndPinErr");
        Card card = (Card)session.getAttribute("card");
        if (card != null) {
            response.sendRedirect(redirectURL);
        }

    %>
    <form class="box" action="CardLoginServlet" method="post" id="sign_in">
        <h1>Opal Card</h1>
        <input type="text" id="card_number" name="card_number" autocomplete="off" placeholder="Card Number">
        <input type="password" id="card_pin" name="card_pin" autocomplete="off" placeholder="Card Pin">
        <input type="submit" form="sign_in" name="sign_in" value="Sign in">
        <input type="button" value="Back" onclick="location.href='index.jsp'">
        <p class="errorinfo"><%=cardNumberFormErr != null? cardNumberFormErr: ""%></p>
        <p class="errorinfo"><%=cardPinFormErr != null? cardPinFormErr: ""%></p>
        <p class="errorinfo"><%=cardNumAndPinErr != null? cardNumAndPinErr: ""%></p>
    </form>
</body>
</html>
