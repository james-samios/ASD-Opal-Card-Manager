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
<form  class="box" method="'get" id="form" action="<%=path%>/StaffLoginServlet">
    <table>
    Administrator: <input type="text" id="username" name="username"  value="${username}" placeholder="Please Enter Staff Name" /></tr></h2>
    Password:<input type="password" id="password" name="password" placeholder="Please Enter password " /></tr></h2>
    <input class = "button1"type="submit" name="loginButton" onclick="loginVerify();" value="Login"></tr>
    </table>
${error}
</form>
</body>
</div>
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