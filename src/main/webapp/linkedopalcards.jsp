<%--
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
    <link rel="stylesheet" href="CSS/linkedopalcards.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
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

</section>
</body>
</html>
