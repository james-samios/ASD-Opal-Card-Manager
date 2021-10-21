<%--
  Created by IntelliJ IDEA.
  User: Qiyang Wu
  Date: 2021/10/15
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>edit card</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<div id="main"  align="center">
    <h2>
        edit card1
    </h2>
    <form action="CardsServlet?method=edit" method="post">
        <table>
            <tr>
                <td>objectId：</td>
                <td><input readonly type="text" value="${card.objectId}" name="objectId"
                ></td>
            </tr>
            <tr style="display: none">
                <td>cardId：</td>
                <td><input readonly type="text" value="${card.cardId}" name="cardId"
                ></td>
            </tr>
            <tr>
                <td>cardPin：</td>
                <td><input type="text" value="${card.cardPin}" name="cardPin"
                ></td>
            </tr>
            <tr>
                <td>cardNumber：</td>
                <td><input type="text"
                           value="${card.cardNumber}"   onchange = "value=value.replace(/[^\d]/g,'');"  name="cardNumber"
                ></td>
            </tr>
            <tr>
                <td>type</td>
                <td><select name="type">${card.leixing}
                    <option <c:if test="${card.leixing.toUpperCase() eq 'ADULT'}"> selected </c:if> value="ADULT">Adult</option>
                    <option <c:if test="${card.leixing.toUpperCase() eq 'CHILD'}"> selected </c:if> value="CHILD">Child</option>
                    <option <c:if test="${card.leixing.toUpperCase() eq 'SCHOOL'}"> selected </c:if> value="SCHOOL">School</option>
                    <option <c:if test="${card.leixing.toUpperCase() eq 'CONCESSION'}"> selected </c:if> value="CONCESSION">Concession</option>
                </select></td>
            </tr>
            <tr>
                <td>balance</td>
                <td><input type="text"  onchange = "value=value.replace(/[^\d]/g,'');" value="${card.balance}"  name="balance"></td>
            </tr>

            <tr>
                <td>active</td>
                <td><select name="active">
                    <option <c:if test="${card.active}"> selected </c:if> value=true>true</option>
                    <option <c:if test="${!card.active}"> selected </c:if> value=false>false</option>
                </select></td>
            </tr>


            <tr>
                <td><input type="submit" value="edit">&nbsp;<input  type="button" value="back"  onclick="location.href='faremanagement.jsp'" /></td>


            </tr>
        </table>
    </form>
</div>

</div>
</body>
</html>
