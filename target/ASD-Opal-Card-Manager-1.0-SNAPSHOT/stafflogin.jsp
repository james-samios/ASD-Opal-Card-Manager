<%--
  Created by IntelliJ IDEA.
  User: Qiyang Wu
  Date: 2021/10/15
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Login</title>
</head>
<body>

<table>
    <form action="faremanagement.jsp" method="post">
        <tr>
            <td> Administrator:<input type="text" placeholder="Enter name" name="name" required="true"><br/></td>
            <td> Pass:<input type="password" placeholder="Enter password" name="password" required><br/></td>
            <td><input type="submit" value="login"></td>
        </tr>
    </form>
</table>
</body>
</html>