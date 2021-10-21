<%@ page import="group2.asd.uts.edu.au.opal.model.Customer" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.Card" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.Trip" %>
<%@ page import="java.util.*" %>
<%@ page import="org.bson.Document" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/09/2021
  Time: 1:56 am
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My Opal Cards</title>
    <link rel="stylesheet" href="CSS/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<%
    Customer customer = (Customer) session.getAttribute("customer");
    ArrayList<Card> linkedCards = (ArrayList<Card>) session.getAttribute("linked_cards");    ArrayList<Trip> tripList = new ArrayList<Trip>();
    HashMap<Integer, Double> discounts = new HashMap<Integer, Double>();
    discounts.put(1,1.0);discounts.put(3,2.5);discounts.put(5,3.7);discounts.put(10,4.5);discounts.put(15,10.0);

    boolean check = false;
    int checker = 0;
    customer.getLinkedCards().forEach(card -> {
        tripList.addAll(card.getTrips());
    });
    int totalTrips = tripList.size();
    Double currentDiscount = 0.0;
    Double nextDiscount = 0.0;
    int remainingTrips = 0;

%>

<body>

<nav class="customer">
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">My Opal Cards</label>

    <ul>
        <li><a href="userprofile.jsp">BACK</a></li>
    </ul>

</nav>
<center>
    <section>
        <%
            for(int i = 0; i < linkedCards.size(); i++){
                Card card = linkedCards.get(i);
                String cardType = card.getType().toString();
                String tdClass = "table-header " + cardType.toLowerCase();
        %>
            <table class="table-style">
                <tr>
                    <td class="<%=tdClass%>">Card Status</td>
                    <td><%=card.isActive()? "ON":"OFF"%></td>
                </tr>
                <tr>
                    <td class="<%=tdClass%>">Card Type</td>
                    <td><%=cardType%></td>
                </tr>
                <tr>
                    <td class="<%=tdClass%>">Card Number</td>
                    <td><%=card.getCardNumber()%></td>
                </tr>
                <tr>
                    <td class="<%=tdClass%>">Card Balance</td>
                    <td><%=card.getBalance()%></td>
                </tr>
                <tr>
                    <td class="<%=tdClass%>">
                        <form method="get" action="ViewTripsServlet">
                            <input type="hidden" name="index" value="<%=i%>">
                            <input class="submit3" type="submit" value="View trips">
                        </form>
                    </td>
                    <td class="<%=tdClass%>">
                        <form method="get" action="CancelCustomerLinkedCardServlet">
                            <input type="hidden" name="index" value="<%=i%>">
                            <input class="submit4" type="submit" value="Cancel link">
                        </form>
                    </td>
                </tr>
            </table>
        <%}%>
        <table class="table-style">
            <%
                for(Integer i = 0; i < totalTrips; i++){
                    if (discounts.containsKey(i)) {
                        currentDiscount = discounts.get(i);
                        checker = i;
                    }
                }


                while(!check){
                    checker++;
                    if (discounts.containsKey(checker)) {
                        check = true;
                        nextDiscount = discounts.get(checker);
                    }
                }
            %>
            <tr>
                <td class="table-header ">Total Trips</td>
                <td><%=totalTrips%></td>
            </tr>
            <tr>
                <td class="table-header ">Available reward</td>
                <td><%=currentDiscount%>% off</td>
            </tr>
            <tr>
                <td class="table-header ">Next reward</td>
                <td><%=nextDiscount%>% off</td>
            </tr>
            <tr>
                <td class="table-header ">Trips until next reward</td>
                <td><%=checker-totalTrips%></td>
            </tr>
            <tr>
                <td class="table-header">
                    <form method="get" action="ViewTripsServlet">
                        <input type="hidden" name="index" value="">
                        <input class="submit3" type="submit" value="Claim Reward">
                    </form>
                </td>
                <td class="table-header">
                </td>
            </tr>
        </table>
    </section>
</center>

</body>
</html>
