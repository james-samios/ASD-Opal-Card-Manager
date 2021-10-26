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
    //List<Card> cards = customer.getLinkedCards();
    ArrayList<Trip> tripList = (ArrayList<Trip>) request.getAttribute("trips");
    Trip trip1 = tripList.get(0);
    Trip trip2 = tripList.get(1);
    Trip trip3 = tripList.get(2);
%>

<body>

<nav class="customer">
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">My Opal Cards</label>

    <ul>
        <!--<li><a href="AddProductController">ADD PRODUCT</a></li>-->
        <li><a href="userprofile.jsp">BACK</a></li>
    </ul>

</nav>
<section>
    <div>
        <form class="keyword" method="post" action="SearchCardServlet">
            <input type="text" class="search" name="keyword" autocomplete="off" placeholder="Enter Opal card number">
            <button type="submit" class="submit" name="filter" value="search">Search</button>
            <p class="successinfo"></p>
        </form>
    </div>

    <div>
        <div class="adult">
            <h1>Type: Adult</h1>
        </div>
        <div class="adult">
            <h3>Card number:</h3>
            <h3>Card status: Activated</h3>
            <h3>Balance:</h3>
        </div>
        <div class="adult">
            <form class="inline" method="post">
                <button type="submit" class="edit" name="topup" value="cardnumber">Top-up</button>
            </form>
            <form class="inline" method="post">
                <button type="submit" class="lock" name="deactivate" value="lock">Lock</button>
            </form>
            <form class="inline" method="post">
                <button type="submit" class="delete" name="delete" value="delete">Delete</button>
            </form>
        </div>
    </div>

    <div class="adult">
        <table class = "table-style"><br/>
            <tr class = "table-style">
                <th class = "table-header">Date/time</th>
                <th class = "table-header">Mode</th>
                <th class = "table-header">Details</th>
                <th class = "table-header">Fare</th>
            </tr>
            <c:if test = "${customer.getFirstName().equals('test')}">
                <%
                    System.out.println("new row");
                    System.out.println(trip1.toString());
                    System.out.println(trip1.getTripStart());
                %>
                <tr class = "table-style">
                    <td class = "table-style customer">9/2/2021 12:32</td>
                    <td class = "table-style customer">Train</td>
                    <td class = "table-style customer">Kings Cross to Town Hall</td>
                    <td class = "table-style customer">$1.49</td>
                </tr>
                <tr class = "table-style">
                    <td class = "table-style customer">29/6/2021 21:20</td>
                    <td class = "table-style customer">Bus</td>
                    <td class = "table-style customer">High St nr Gate 9 UNSW to Eddy Av</td>
                    <td class = "table-style customer">$1.49</td>
                </tr>
                <tr class = "table-style">
                    <td class = "table-style customer">17/9/2021 10:08</td>
                    <td class = "table-style customer">Ferry</td>
                    <td class = "table-style customer">Balmain East to Circular Quay</td>
                    <td class = "table-style customer">$2</td>
                </tr>
            </c:if>
        </table>
     </div>
</section>
</body>
</html>
