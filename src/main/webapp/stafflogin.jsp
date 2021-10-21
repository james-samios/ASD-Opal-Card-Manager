<%--
  Created by IntelliJ IDEA.
  User: Qiyang Wu
  Date: 2021/10/15
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath(); %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - StaffLogin</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<form method="'get" id="form" action="<%=path%>/StaffLoginServlet">
    <td> Administrator: <input type="text" id="username" name="username"  value="${username}" placeholder="Please Enter Staff Name" /></td>
    <td> Pass:<input type="password" id="password" name="password" placeholder="Please Enter password " /></td>
    <input type="submit" name="loginButton" onclick="loginVerify();" value="Login">

${error}
</form>
</body>
</html>

<script>
    function loginVerify(){
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        if(username =='') {
            alert('Staff name should not be empty!');
            return;
        }
        if(password =='') {
            alert('Password should not be empty!');
            return;
        }

        document.getElementById("form").submit();

    }

</script>