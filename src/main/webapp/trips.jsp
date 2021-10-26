<%@ page import="group2.asd.uts.edu.au.opal.model.Station" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.Trip" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 7/09/2021
  Time: 1:51 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report List</title>
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          crossorigin="anonymous">
</head>
<body>
<%
    List<Trip> trips = (List<Trip>) request.getSession().getAttribute("trips");
%>

<nav class="customer">
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">Search Trips</label>
    <ul>
        <li><a href="LinkedOpalCardsServlet">Opal Cards</a></li>

        <li><a href="LocationServlet">Search Trips</a></li>

        <li><a href="EditProfileServlet">Edit Profile</a></li>

        <li><a href="payment.jsp">Payment</a></li>

        <li><a href="enquiryHome.jsp">Make an Enquiry</a></li>

        <li><a href="incidentReportHome.jsp">Report a lost or stolen Opal Card</a></li>

        <li><a href="index.jsp">Logout</a></li>
    </ul>
</nav>

<%
    Station location = (Station) session.getAttribute("location");
    Station destination = (Station) session.getAttribute("destination");
    Integer distance = (Integer) session.getAttribute("distance");
    Integer fare = (Integer) session.getAttribute("fare");
%>
<div class="container">
    <%
        if (location != null) {
    %>
    <table class="table">
        <thead>
        <tr>
            <th>Location</th>
            <th>Destination</th>
            <th>Fare</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><%=location.getName()%><br>
                <small>Arrival: <%=location.getArrivalTime()%>
                </small><br>
                <small>Daparture: <%=location.getDepartureTime()%>
                </small><br>
            </td>
            <td><%=destination.getName()%><br>
                <small>Arrival: <%=destination.getArrivalTime()%>
                </small>
                </small><br>
            </td>
            <td>
                <p>
                    <strong>$<%=fare%>
                    </strong><br>
                    <small><%=distance%> KM
                    </small>
                </p>
            </td>
        </tr>
        </tbody>
    </table>
    <%
        }
    %>

    <h2>Other Trips </h2>
    <table class="table">
        <thead>
        <tr>
            <th>Location</th>
            <th>Destination</th>
            <th>Fare</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (trips != null) {
                for (Trip trip : trips) {
        %>
        <tr>
            <td><%=trip.getTripStart()%><br>
                <small>Start: <%=trip.getStartTime()%>
                </small><br>
            </td>
            <td><%=trip.getTripEnd()%><br>
                <small>Start: <%=trip.getEndTime()%>
                </small><br>
            </td>
            <td>
                <p>
                    <strong>$<%=trip.getFare()%>
                    </strong>
                </p>
            </td>
            <td>
                <div class="row">
                    <div class="col">
                        <a class="btn button-primary"
                           href="TripServlet?trip=<%=trip.getObjectId().toString()%>">Edit</a>
                    </div>
                    <div class="col">
                        <form action="TripServlet?method=delete" method="POST">
                            <input type="hidden" name="trip" value="<%=trip.getObjectId().toString()%>">
                            <button type="submit" class="btn button-danger">Delete</button>
                        </form>
                    </div>
                </div>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <p> No Trips available</p>
        <%
            }
        %>
        </tbody>
    </table>
</div>


</body>
</html>
