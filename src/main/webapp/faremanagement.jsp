<%--
  Created by IntelliJ IDEA.
  User: Qiyang Wu
  Date: 2021/10/15
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Opal Cards Manage</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<nav class="customer">
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">Staff Home Page</label>
    <ul>
        <li><a href="customerService.jsp">Customer Service Support</a></li>
        <li><a href="index.jsp">Logout</a></li>
    </ul>
</nav>

<h1>Opal cards fares and Concession Manager </h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Card type name</th>
            <th>Requirements</th>
            <th>Price</th>
            <th>Fares</th>
            <th>Manage</th>


        </tr>
        <tr>
            <td>1</td>
            <td>Adult</td>
            <td>16 years of age, or older </td>


            <td>20</td>

            <td><button class ='button1' onclick="location.href='FaresServlet'">Detail</button></td>
            <td><button class ='button1' onclick="location.href='CardsServlet?method=show&type=ADULT'">Enter</button></td>
        </tr>
        <tr>
            <td>2</td>
            <td>Child/Youth</td>
            <td>Children aged 4 - 15 years </td>

            <td>10 </td>

            <td><button class ='button1' onclick="location.href='FaresServlet'">Detail</button></td>
            <td><button class ='button1' onclick="location.href='CardsServlet?method=show&type=CHILD'">Enter</button></td>
        </tr>
        <tr>
            <td>3</td>
            <td>Senior/pensioner</td>
            <td>NSW permanent resident aged 60 or over </td>

            <td> 10 </td>

            <td><button class ='button1' onclick="location.href='FaresServlet'">Detail</button></td>
            <td><button class ='button1' onclick="location.href='CardsServlet?method=show&type=SCHOOL'">Enter</button></td>

        </tr>
        <tr>
            <td>4</td>
            <td>Concessions</td>
            <td>students, apprentices and trainees, job seekers and Centrelink customers </td>

            <td> 10 </td>

            <td><button class ='button1' onclick="location.href='FaresServlet'">Detail</button></td>
            <td><button  class ='button1' onclick="location.href='CardsServlet?method=show&type=CONCESSION'">Enter</button></td>

        </tr>

    </table>


<!--<input type="text" placeholder="Enter price" name="name" required>-->
</body>
</html>

