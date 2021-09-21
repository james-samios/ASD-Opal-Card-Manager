<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/index.css">
    <title>Home Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
<nav>
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">Transport for NSW</label>
    <ul>
        <li><a href="opalcard.jsp">Opal Card</a></li>
        <li><a href="login.jsp">Sign in</a></li>
        <li><a href="register.jsp">Sign up</a></li>
    </ul>
</nav>
<section></section>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<h1>Opal</h1>
<h2>Card Activity:</h2>

<table>
    <tr>
        <th>From</th>
        <th>To</th>
        <th>Time</th>
    </tr>
    <tr>
        <td>Central</td>
        <td>Circular Quay</td>
        <td>12:37</td>
    </tr>
    <tr>
        <td>Wynyard</td>
        <td>Liverpool</td>
        <td>11:00</td>
    </tr>
    <tr>
        <td>Oxford Street</td>
        <td>Bondi Road</td>
        <td>23:00</td>
    </tr>
    <tr>
        <td>Town Hall</td>
        <td>Central</td>
        <td>1:05</td>
    </tr>
    <tr>
        <td>Central</td>
        <td>Circular Quay</td>
        <td>9:00</td>
    </tr>
    <tr>
        <td>Watson's Bay</td>
        <td>Circular Quay</td>
        <td>8:45</td>
    </tr>
</table>

</body>
</html>
