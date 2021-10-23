<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/style.css">
    <title>Delete Account</title>
</head>
<body>
    <form class="box" action="DeleteAccountServlet" method="post" id="delete">
        <h1>Delete Account Confirmation</h1>
        <br>
        <p>Are you sure you want to do this? This action is immediate and irrevokable. Your opal cards will be unlinked but the balances were remain.</p>
        <br>
        <input type="submit" form="delete" name="delete" value="Delete Account" style="background-color:red;color:white">
    </form>
</body>
</html>
