<%@ page import="group2.asd.uts.edu.au.opal.model.Card" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/09/2021
  Time: 1:25 am
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/carddetails.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <title>Card Details Page</title>
</head>
<body>
    <%
        //String redirectURL = "http://localhost:8080/LogoutServlet";
        Card card = (Card)session.getAttribute("card");

        String cardId = card.getCardId().toString();
        String cardNumber = card.getCardNumber();
        String cardPin = card.getCardPin();
        String type = card.getType().toString();
        boolean isActive = card.isActive();
        boolean isLocked = card.isLocked();
        String accountId = card.getAccountId().toString();
        String balance = "" + card.getBalance();
        String paymentDetailsId = card.getTopUp().getPaymentMethodId().toString();
        String amount = "" + card.getTopUp().getAmount();
        String when = "" + card.getTopUp().getWhen();
        String typeToLowerCase = type.toLowerCase();
        String colorChosen = typeToLowerCase.equals("child")?"child":
            typeToLowerCase.equals("senior")?"senior":
            typeToLowerCase.equals("concession")?"concession":"adult";
        System.out.println(colorChosen);
        String tdClass = "table-header " + colorChosen;

    %>

    <nav class="<%=colorChosen%>">
        <input type="checkbox" id="check">
        <label for="check" class="checkbtn">
            <i class="fas fa-bars"></i>
        </label>
        <label class="logo">Card Number: <%=card.outPutCardFormat()%></label>
        <ul>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </nav>

    <center>
        <section>
                <table class="table-style">
                    <tbody>
                        <tr>
                            <td class="<%=tdClass%>">Card Status</td>
                            <td data-label="card_active"><%=isActive?"Activation": "Deactivation"%></td>
                            <td><button class="submit <%=isActive?"red":"light_green"%>"><%=isActive?"Deactivation":"Activation"%></button></td>
                        </tr>
                        <tr>
                            <td class="<%=tdClass%>">Balance</td>
                            <td data-label="balance"><%=balance%></td>
                            <td><button class="submit light_blue" onclick="location.href='topupmenu.jsp'">Top Up</button></td>
                        </tr>

                        <tr>
                            <td class="<%=tdClass%>">Auto Top Up</td>
                            <td data-label="auto_top_up"><%=isActive?"Activation": "Deactivation"%></td>
                            <td><button class="submit <%=isActive?"red":"light_green"%>"><%=isActive?"Deactivation":"Activation"%></button></td>
                        </tr>
                        <%if(paymentDetailsId != null) {%>
                            <tr>
                                <td class="<%=tdClass%>">Payment Method</td>
                                <td class="<%=tdClass%>"></td>
                                <td class="<%=tdClass%>"><button class="submit">Edit</button></td>
                            </tr>
                            <tr>
                                <td class="<%=tdClass%>">Card Number</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="<%=tdClass%>">Card Owner Name</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="<%=tdClass%>">CVC</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="<%=tdClass%>">Card Expiry</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="<%=tdClass%>">Top-Up Amount</td>
                                <td><%=amount%></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="<%=tdClass%>">When</td>
                                <td><%=when%></td>
                                <td></td>
                            </tr>
                        <%}%>
                    </tbody>
                </table>
        </section>
    </center>
</body>
</html>
