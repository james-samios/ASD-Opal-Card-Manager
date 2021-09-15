<%@ page import="group2.asd.uts.edu.au.opal.object.Card" %>
<%@ page import="group2.asd.uts.edu.au.opal.object.Trip" %><%--
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

        /*
        boolean isCardNull = card == null? true: false;
        if(isCardNull) {

        }*/

        String cardId = card.getCardId().toString();
        String cardNumber = "" + card.getCardNumber();
        String cardPin = "" + card.getCardPin();
        String type = card.getType().toString();
        boolean isActive = card.isActive();
        boolean isLocked = card.isLocked();
        boolean isLinked = card.isLinked();
        String balance = "" + card.getBalance();
        String paymentDetailsId = card.getTopUp().getPaymentDetailsId().toString();
        String amount = "" + card.getTopUp().getAmount();
        String when = "" + card.getTopUp().getWhen();
    %>

    <nav class="customer">
        <input type="checkbox" id="check">
        <label for="check" class="checkbtn">
            <i class="fas fa-bars"></i>
        </label>
        <label class="logo">Card Details</label>
        <ul>
            <li><a href="carddetails.jsp">Activate Card</a></li>

            <li><a href="login.jsp">Auto Top-up Setting</a></li>

            <li><a href="topupmenu.jsp">Top Up</a></li>

            <li><a href="login.jsp">linked To Account</a></li>

            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </nav>

    <center>
        <section>
            <table class="table-style">
                <tbody>
                    <tr>
                        <td class="table-header customer">Card ID</td>
                        <td data-label="card_id"><%=cardId%></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Number</td>
                        <td data-label="card_number"><%=cardNumber%></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Pin</td>
                        <td data-label="card_number"><%=cardPin%></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Type</td>
                        <td data-label="card_type"><%=type%></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Activate</td>
                        <td data-label="card_active"><%=isActive?"Active": "Lock"%></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Lock</td>
                        <td data-label="card_locked"><%=isLocked%></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Link</td>
                        <td data-label="card_link"><%=isLinked%></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Balance</td>
                        <td data-label="balance"><%=balance%></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Owner</td>
                        <td data-label="card_owner"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Owner Email</td>
                        <td data-label="email"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Owner Phone</td>
                        <td data-label="phone"></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
                <table class="table-style">
                    <tbody>
                        <tr>
                            <td class="table-header customer">Auto Top Up</td>
                            <td data-label="auto_top_up"><%=isActive? "Enable": "Disable"%></td>
                            <td><button class="submit <%=isActive?"yellow":"light_green"%>"><%=isActive?"Deactivation":"Activation"%></button></td>
                        </tr>
                        <%if(paymentDetailsId != null) {%>
                            <tr>
                                <td class="table-header customer">Payment Method</td>
                                <td class="table-header customer"></td>
                                <td class="table-header customer"><button class="submit">Edit</button></td>
                            </tr>
                            <tr>
                                <td class="table-header customer">Card Number</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="table-header customer">Card Owner Name</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="table-header customer">CVC</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="table-header customer">Card Expiry</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="table-header customer">Top-Up Amount</td>
                                <td><%=amount%></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="table-header customer">Top up when the price below</td>
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
