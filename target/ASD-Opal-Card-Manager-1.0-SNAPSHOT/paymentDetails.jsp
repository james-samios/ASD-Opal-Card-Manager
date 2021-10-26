<%@ page import="group2.asd.uts.edu.au.opal.model.PaymentMethod" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/09/2021
  Time: 1:25 am
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/style.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          crossorigin="anonymous">
    <title>Card Details Page</title>
</head>
<body>
<%
    PaymentMethod card = (PaymentMethod) session.getAttribute("card");
%>

<nav>
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">Card Number: <%=card.getCardNumber()%>
    </label>
    <ul>
        <li><a href="PaymentMethodServlet?card=all">View Payment Methods</a></li>
      <li><a href="userprofile.jsp">Back to Profile</a></li>
        <li><a href="LogoutServlet">Logout</a></li>
    </ul>
</nav>


<center>
    <section class="container py-6">
        <div class="card w-50">
            <div class="card-body">
                <p>Card Owner: <%=card.getCardName()%>
                </p>
                <p>Card Number: <%=card.getCardNumber()%>
                </p>
                <p>Card CVC: <%=card.getCardCVC()%>
                </p>
                <p>Card Expiry: <%=card.getExpiryDate()%>
                </p>

                <a class="btn button-primary"
                   href="PaymentMethodServlet?card=<%=card.getCardNumber().toString()%>">Edit</a>
                <form action="PaymentMethodServlet?method=delete" method="POST">
                    <input type="hidden" value="<%=card.getCardNumber().toString()%>">
                    <button type="submit" class="btn button-danger">Delete</button>
                </form>
            </div>
        </div>
    </section>
</center>
</body>
</html>
