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
    <title>add card</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<div id="main"  align="center">
    <h2>
        add card1
    </h2>
    <form action="CardsServlet?method=add" method="post">
        <table>
            <tr style="display: none">
                <td>objectId：</td>
                <td><input readonly type="text"  name="objectId"
                ></td>
            </tr>
            <tr style="display: none">
                <td>cardId：</td>
                <td><input readonly type="text"  name="cardId"
                ></td>
            </tr>
            <tr>
                <td>cardPin：</td>
                <td><input type="text"   name="cardPin"
                ></td>
            </tr>
            <tr>
                <td>cardNumber：</td>
                <td><input type="text"    onchange = "value=value.replace(/[^\d]/g,'');"   name="cardNumber"
                ></td>
            </tr>
            <tr>
                <td>type</td>
                <td><select name="type">
                    <option value="ADULT">Adult</option>
                    <option  value="CHILD">Child</option>
                    <option  value="SCHOOL">Senior</option>
                    <option  value="CONCESSION">Concessions</option>
                </select></td>
            </tr>
            <tr>
                <td>balance</td>
                <td><input type="text"  onchange = "value=value.replace(/[^\d]/g,'');"  name="balance"></td>
            </tr>

            <tr>
                <td>active</td>
                <td><select name="active">
                    <option value=true>true</option>
                    <option  value=false>false</option>
                </select></td>
            </tr>


            <tr>
                <td><input type="submit" value="add">&nbsp;<input  type="button" value="back"  onclick="location.href='faremanagement.jsp'" /></td>


            </tr>
        </table>
    </form>
</div>

</div>
</body>
</html>

