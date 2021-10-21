<%@ page import="group2.asd.uts.edu.au.opal.model.Trip" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Card Trips</title>
    <link rel="stylesheet" href="CSS/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<%
    ArrayList<Trip> trips = (ArrayList<Trip>) session.getAttribute("trips");
    String cardType = (String) session.getAttribute("card_type");
%>

<body>

<nav class="customer">
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">Card Trips</label>

    <ul>
        <li><a href="linkedopalcards.jsp">BACK</a></li>
    </ul>
</nav>
<center>
    <section>
        <%for(int index = 0; index < trips.size(); index++) {
            Trip getTrip = trips.get(index);
        %>
            <table class="table-style">
                <tr>
                    <td class="<%=cardType%>">Trip start</td>
                    <td><%=getTrip.getTripStart()%></td>
                </tr>
                <tr>
                    <td class="<%=cardType%>">Trip end</td>
                    <td><%=getTrip.getTripEnd()%></td>
                </tr>
                <tr>
                    <td class="<%=cardType%>">Trip start time</td>
                    <td><%=getTrip.getStartTime()%></td>
                </tr>
                <tr>
                    <td class="<%=cardType%>">Trip end time</td>
                    <td><%=getTrip.getEndTime()%></td>
                </tr>
                <tr>
                    <td class="<%=cardType%>">Fare</td>
                    <td><%=getTrip.getFare()%></td>
                </tr>
            </table>
        <%}%>
    </section>
</center>

</body>
</html>