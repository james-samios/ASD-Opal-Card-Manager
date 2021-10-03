<%@ page import="group2.asd.uts.edu.au.opal.model.Card" %>
<%@ page import="java.util.UUID" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.PaymentMethod" %>
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
        Card card = (Card)session.getAttribute("card");
        String type = card.getType().toString();
        boolean isActive = card.isActive();
        boolean isAutoTopUp = card.getTopUp().isEnabled();
        UUID accountId = card.getAccountId();
        boolean isAccountLinked = accountId.compareTo(new UUID(0, 0)) <= -1;
        String balance = "" + card.getBalance();
        String customerEmail = (String) session.getAttribute("customerEmail");
        String amount = "" + card.getTopUp().getAmount();
        String when = "" + card.getTopUp().getWhen();
        String typeToLowerCase = type.toLowerCase();
        String colorChosen = typeToLowerCase.equals("child")?"child":
            typeToLowerCase.equals("senior")?"senior":
            typeToLowerCase.equals("concession")?"concession":"adult";
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
                            <td data-label="card_active"><%=isActive?"ON": "OFF"%></td>
                            <td></td>
                            <td>
                                <button class="submit <%=isActive?"red":"light_green"%>" onclick="location.href='CardStatusServlet'">
                                    <%=isActive?"OFF":"ON"%>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td class="<%=tdClass%>">Balance</td>
                            <td data-label="balance"><%=balance%></td>
                            <td>
                                <button class="submit light_blue" onclick="location.href='topupmenu.jsp'">Top Up</button>
                            </td>
                            <td>
                                <button class="submit light_blue" onclick="location.href='PaymentHistoryServlet'">Record</button>
                            </td>
                        </tr>

                        <tr>
                            <td class="<%=tdClass%>">Linked Account</td>
                            <td data-label="linked_account"><%=customerEmail == null? "OFF": customerEmail%></td>
                            <td></td>
                            <%if(isAccountLinked) {%>
                                <td>
                                    <button class="submit red" onclick="location.href='CancelAccountLinkServlet'">
                                        Cancel
                                    </button>
                                </td>
                            <%}else {%>
                                <td>
                                    <button class="submit light_green" onclick="location.href='linkaccount.jsp'">
                                        Link
                                    </button>
                                </td>
                            <%}%>
                        </tr>

                        <tr>
                            <td class="<%=tdClass%>">Auto Top Up</td>
                            <td data-label="auto_top_up"><%=isAutoTopUp?"ON": "OFF"%></td>
                            <td></td>
                            <%if(isAutoTopUp) {%>
                                <td>
                                    <button class="submit red" onclick="location.href='CancelAutoTopUpServlet'">
                                        <%="OFF"%>
                                    </button>
                                </td>
                            <%}else {%>
                                <td>
                                    <button class="submit light_green" onclick="location.href='autotopupmenu.jsp'">
                                        <%="ON"%>
                                    </button>
                                </td>
                            <%}%>
                        </tr>

                        <%if(isAutoTopUp) {
                            PaymentMethod paymentMethod = (PaymentMethod) session.getAttribute("paymentMethod");
                        %>

                            <tr>
                                <td class="<%=tdClass%>">Payment Method</td>
                                <td class="<%=tdClass%>"></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="<%=tdClass%>">Card Number</td>
                                <td><%=paymentMethod.getCardNumber()%></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="<%=tdClass%>">Card Owner Name</td>
                                <td><%=paymentMethod.getCardName()%></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="<%=tdClass%>">CVC</td>
                                <td><%=paymentMethod.getCardCVC()%></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="<%=tdClass%>">Card Expiry</td>
                                <td><%=paymentMethod.getExpiryDate()%></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="<%=tdClass%>">Top-Up Amount</td>
                                <td><%=amount%></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="<%=tdClass%>">When</td>
                                <td><%=when%></td>
                                <td></td>
                                <td></td>
                            </tr>
                        <%}%>
                    </tbody>
                </table>
        </section>
    </center>
</body>
</html>
