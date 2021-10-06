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