<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Payment Information</title>
    <link rel="stylesheet" href="CSS/paymentresult.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<%

    String first = request.getParameter("first");
    String last = request.getParameter("last");
    String dob = request.getParameter("dob");
    String card_number = request.getParameter("card_number");
    String cvc = request.getParameter("cvc");
    String expiry_date = request.getParameter("expiry_date");
    String paypal_email = request.getParameter("paypal_email");
    String password = request.getParameter("password");


%>
<body>

<nav class="customer">
    <input type="checkbox" id="check">
    <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
    </label>
    <label class="logo">Payment Details</label>

    <ul>
        <li><a href="payment.jsp">BACK</a></li>
    </ul>

</nav>
<section>
    <table class="table-style">
        <tbody>
        <tr>
            <td class="table-header customer">First Name</td>
            <td data-label="First Name"></td>
            <td><%=first%></td>
        </tr>
        <tr>
            <td class="table-header customer">Last Name</td>
            <td data-label="Last Name"></td>
            <td><%=last%></td>
        </tr>
        <tr>
            <td class="table-header customer">DOB</td>
            <td data-label="DOB"></td>
            <td><%=dob%></td>
        </tr>
        <tr>
            <td class="table-header customer">Card Number</td>
            <td data-label="Card_Number"></td>
            <td><%=card_number%></td>
        </tr>

        <tr>
            <td class="table-header customer">Expiry Date</td>
            <td data-label="Expiry_Date"></td>
            <td><%=expiry_date%></td>
        </tr>

        <tr>
            <td class="table-header customer">CVC</td>
            <td data-label="CVC"></td>
            <td><%=cvc%></td>

        </tr>
        <tr>
            <td class="table-header customer">Paypal</td>
            <td data-label="Email"></td>
            <td><%=paypal_email%></td>
        </tr>
        <tr>
            <td class="table-header customer">Password</td>
            <td data-label="Password"></td>
            <td><%=password%></td>
        </tr>

        <script>
            function submitForm(x){
                if(x.id=='b1'){
                    document.getElementById('hid1').value='button1action';
                }
                else if(x.id=='b2'){
                    document.getElementById('hid1').value='button2action';
                }
                else{
                    document.getElementById('hid1').value='button3action';
                }
                //alert(document.getElementById('hid1').value);
                document.forms[0].submit();
            }
        </script>
        <form action=youractionurl>


            <tr>
                <th><input type="button" id=b1 value="Save" name="button" onClick='submitForm(this)'/></th>
                <th><input type="button" id=b2 value="Update" name="button" onClick='submitForm(this)'/></th>
                <th><input type="button" id=b3 value="Delete" name="button" onClick='submitForm(this)'/></th>
            </tr>
            <input type='hidden' id='hid1'  name='hid1'>


        </form>

    </table>
</section>
<%--
<table border="1">
    <tbody>
    <tr>
        <td>First Name:</td>
        <td><%=first%></td>
    </tr>

    <tr>
        <td>Last Name:</td>
        <td><%=last%></td>
    </tr>

    <tr>
        <td>Date of Birth:</td>
        <td><%=dob%></td>

    </tr>

    <tr>
        <td>Card Number:</td>
        <td><%=card_number%></td>
    </tr>

    <tr>
        <td>CVC:</td>
        <td><%=cvc%></td>

    </tr>

    <tr>
        <td>Expiry Date:</td>
        <td><%=expiry_date%></td>
    </tr>
    <tr>
        <td>Paypal:</td>
        <td><%=paypal_email%></td>

    </tr>
    <tr>
        <td>Password:</td>
        <td><%=password%></td>

    </tr>

    </tbody>

</table>    --%>
</body>
</html>
