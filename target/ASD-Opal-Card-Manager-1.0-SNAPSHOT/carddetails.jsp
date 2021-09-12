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
    <link rel="stylesheet" href="CSS/userprofile.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <title>Card Details Page</title>
</head>
<body>
    <%
        Card card = (Card)session.getAttribute("card");
    %>

    <nav class="customer">
        <input type="checkbox" id="check">
        <label for="check" class="checkbtn">
            <i class="fas fa-bars"></i>
        </label>
        <label class="logo">Card Details</label>
        <ul>
            <li><a href="carddetails.jsp">Activate Card</a></li>

            <li><a href="topupmenu.jsp">Top Up</a></li>

            <li><a href="login.jsp">linked To Account</a></li>

            <li><a href="index.jsp">Logout</a></li>
        </ul>
    </nav>

    <center>
        <section>
            <table class="table-style">
                <tbody>
                    <tr>
                        <td class="table-header customer">Card ID</td>
                        <td data-label="card_id"><%=card.getCardId()%></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Number</td>
                        <td data-label="card_number"><%=card.getCardNumber()%></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Pin</td>
                        <td data-label="card_number"><%=card.getCardPin()%></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Type</td>
                        <td data-label="card_type"><%=card.getType()%></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Activate</td>
                        <td data-label="card_active"><%=card.isActive()?"Active": "Lock"%></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Lock</td>
                        <td data-label="card_locked"><%=card.isLocked()%></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Link</td>
                        <td data-label="card_link"><%=card.isLinked()%></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Balance</td>
                        <td data-label="balance"><%=card.getBalance()%></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Card Owner</td>
                        <td data-label="card_owner"></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Owner Email</td>
                        <td data-label="email"></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Owner Phone</td>
                        <td data-label="phone"></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Top-Up Amount</td>
                        <td data-label="top_up_amount"><%=card.getTopUp().getAmount()%></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Top-Up Payment ID</td>
                        <td data-label="top_up_payment_id"><%=card.getTopUp().getPaymentDetailsId()%></td>
                    </tr>
                    <tr>
                        <td class="table-header customer">Top-Up When</td>
                        <td data-label="top_up_when"><%=card.getTopUp().getWhen()%></td>
                    </tr>
                    <%for(Trip trip: card.getTrips()) {%>
                        <tr>
                            <td class="table-header customer">Trip Start</td>
                            <td data-label="trip_start"><%=trip.getTripStart()%></td>
                        </tr>
                        <tr>
                            <td class="table-header customer">Trip End</td>
                            <td data-label="trip_end"><%=trip.getTripEnd()%></td>
                        </tr>
                        <tr>
                            <td class="table-header customer">Trip Start Time</td>
                            <td data-label="trip_start_time"><%=trip.getStartTime()%></td>
                        </tr>
                        <tr>
                            <td class="table-header customer">Trip End Time</td>
                            <td data-label="trip_end_time"><%=trip.getEndTime()%></td>
                        </tr>
                    <%}%>
                </tbody>
            </table>
        </section>
    </center>
</body>
</html>
