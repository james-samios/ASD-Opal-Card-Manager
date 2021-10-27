<%@ page import="group2.asd.uts.edu.au.opal.model.Card" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="group2.asd.uts.edu.au.opal.model.PaymentHistory" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/10/2021
  Time: 9:04 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="CSS/style.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <title>Payment Histroy Page</title>
</head>

<body>
    <%
        Card card = (Card)session.getAttribute("card");
        ArrayList<PaymentHistory> paymentHistories = (ArrayList<PaymentHistory>) session.getAttribute("paymentHistories");
        for(PaymentHistory paymentHistory: paymentHistories) {
            System.out.println(paymentHistory);
        }
        String type = card.getType().toString();
        String typeToLowerCase = type.toLowerCase();
        String colorChosen = typeToLowerCase.equals("child")?"child":
                typeToLowerCase.equals("senior")?"senior": typeToLowerCase.equals("concession")?"concession":"adult";
        String tdClass = "table-header " + colorChosen;
    %>
    <nav class="<%=colorChosen%>">
        <input type="checkbox" id="check">
        <label for="check" class="checkbtn">
            <i class="fas fa-bars"></i>
        </label>
        <label class="logo">Card Number: <%=card.outPutCardFormat()%></label>
        <ul>
            <li><a href="carddetails.jsp">Back</a></li>
        </ul>
    </nav>
    <center>
        <section>
                    <%for(PaymentHistory paymentHistory: paymentHistories) {%>
                        <table class="table-style">
                            <tbody>
                                <tr>
                                    <td class="<%=tdClass%>">Date</td>
                                    <td><%=paymentHistory.getPaymentDate()%></td>

                                </tr>
                                <tr>
                                    <td class="<%=tdClass%>">Status</td>
                                    <td><%=paymentHistory.getStatus()%></td>
                                </tr>
                                <tr>
                                    <td class="<%=tdClass%>">Payment Method</td>
                                    <td><%=paymentHistory.getPaymentMethod()%></td>
                                </tr>
                                <tr>
                                    <td class="<%=tdClass%>">Top Up Fee</td>
                                    <td><%=paymentHistory.getAmount()%></td>
                                </tr>
                            </tbody>
                        </table>
                    <%}%>
                    <!-- Need to add each payment history

                    -->

        </section>
    </center>
</body>
</html>
