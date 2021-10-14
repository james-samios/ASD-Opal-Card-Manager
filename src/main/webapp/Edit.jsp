<%--
<<<<<<< Updated upstream
Created by IntelliJ IDEA.
User: Qiyang Wu
Date: 2021/10/4
Time: 21:17
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form >
    <table>
        <tbody>
        <tr><td>ID：</td><td><input type="text" name="user_id" value="admin_01" readonly="readonly" /></td></tr>
        <tr><td>Name：</td><td>
        </td></tr>
        <tr><td>CardType：</td><td>
            <option value='r001'>Child</option><option value='r002' selected='selected'>Senior </option><option value='r003' selected='selected'>Concessions </option>
            </select>
        </td></tr>
        <tr><td>Balance：</td><td></td></tr>
        <tr><td>Active：</td><td></td></tr>
        <select active="role_id">
            <option value='r001'>Active</option><option value='r002' selected='selected'>nonActivated </option>
        </select>
        <tr><td>Application：</td><td><input type="text" name="user_phone" value="13900000002"  pattern="^1[1-9]\d{9}$" title="Error input. Enter 0~9 number" /></td></tr>
        <option value='r001'>Pass</option> <option value='r001'>Stay by</option>
        </tbody>

        <tfoot>
        <tr><td><input type="submit" value="确定" id="btnSure"/></td><td><input type="button" value="取消" id="btnCancel"/></td></tr>
        </tfoot>
    </table>
</form>
</body>
</body>
=======
  Created by IntelliJ IDEA.
  User: Qiyang Wu
  Date: 2021/10/14
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  </body>
>>>>>>> Stashed changes
</html>
