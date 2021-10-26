<%@ page import="group2.asd.uts.edu.au.opal.model.Station" %>
<%@ page import="java.util.List" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.Customer" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          crossorigin="anonymous">
    <title>Home Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

</head>
<body>
<nav>
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">Transport for NSW</label>
    <ul>
        <li><a href="opalcard.jsp">Opal Card</a></li>
        <li><a href="login.jsp">Sign in</a></li>
        <li><a href="stafflogin.jsp">Staff</a></li>
        <li><a href="register.jsp">Sign up</a></li>
    </ul>
</nav>
<%
    List<Station> stations = (List<Station>) session.getAttribute("stations");
%>
<section>
    <div class="container">

    </div>
</section>
<script>

</script>
</body>
</html>