<%--
  Created by IntelliJ IDEA.
  User: Qiyang Wu
  Date: 2021/10/15
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Concession Manager</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<h1>Opal cards concessions manager </h1>
<br>
<a href="CardsServlet?method=toadd">add</a>
<table>
    <tr>
        <th>ID</th>
        <th>cardPin</th>
        <th>CardNumber</th>
        <th>CardType</th>
        <th>Balance</th>
        <th>Active</th>
        <th>Edit</th>

    </tr>
    <c:forEach items="${list}"  var="card">
        <tr>

            <td>${card.cardId}</td>
            <td>${card.cardPin}</td>
            <td>${card.cardNumber}</td>
            <td>${card.type}</td>
            <td>${card.balance}</td>
            <td>${card.active}</td>
            <td><a href="CardsServlet?method=preedit&id=${card.cardId}">edit</a>|<a href="CardsServlet?method=delete&id=${card.objectId}">delete</a></td>
            <td>
        </tr>
    </c:forEach>
    ${msg}


</table>
</form>
<!--<input type="text" placeholder="Enter price" name="name" required>-->
<button  onclick="location.href='faremanagement.jsp'" type="button">Return</button>
</body>
</html>

