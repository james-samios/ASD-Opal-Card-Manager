<%@ page import="group2.asd.uts.edu.au.opal.model.Fares" %><%--
  Created by IntelliJ IDEA.
  User: Qiyang Wu
  Date: 2021/10/15
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fares </title>
</head>
<body>
<%
    Fares fares = (Fares) session.getAttribute("fares");
%>


<h1>Fares</h1>

<h2>Daily and Weekly Caps</h2>
<form method="post" action="UpdateFaresServlet">
    <p>never pay more than $<input type="number" name="daily_weekly_min" value="<%=fares.getDaily_weekly_min()%>"> a day, $<input type="number" name="daily_weekly_max" value="50"> a week or $<input type="number" name="daily_weekly_weekends" value="8.15"> on Saturdays, Sundays and public holidays.</p>

    <h2>Peak and off-peak times</h2>
    <p>30% fare discount on metro/train, bus and light rail services.<br>
        Sydney metro and trains peak times: 6.30am-10am; 3pm-7pm <br>
        Intercity trains peak times: 6am-10am; 3pm-7pm <br>
        Bus and light rail peak times: 6.30am-10am; 3pm-7pm
    </p>

    <h2>Metro and train fares</h2>
    <table>
        <tr>

            <td>Distance;</td>
            <td>Adult Opal fare;</td>
            <td>Adult Opal off peak fare;</td>
            <td>Adult Opal single trip fare;</td>

        </tr>

        <tr>

            <td>0-10 km</td>
            <td>$<input type="number" name="metro_train_single_0_10" value="3.66"></td>
            <td>$<input type="number" name="metro_train_off_peak_0_10" value="2.56"></td>
            <td>$<input type="number" name="metro_train_fare_0_10" value="4.50"></td>
        </tr>

        <tr>

            <td>10-20 km </td>
            <td>$<input type="number" name="metro_train_single_10_20" value="4.55"></td>
            <td>$<input type="number" name="metro_train_off_peak_10_20" value="3.18"></td>
            <td>$<input type="number" name="metro_train_fare_10_20" value="5.60"></td>
        </tr>
        <tr>

            <td>20-35 km</td>
            <td>$<input type="number" name="metro_train_single_20_35" value="5.23"></td>
            <td>$<input type="number" name="metro_train_off_peak_20_35" value="3.66"></td>
            <td>$<input type="number" name="metro_train_fare_20_35" value="6.40"></td>
        </tr>
        <tr>

            <td>35 - 65 km</td>
            <td>$<input type="number" name="metro_train_single_35_65" value="6.99"></td>
            <td>$<input type="number" name="metro_train_off_peak_35_65" value="4.89"></td>
            <td>$<input type="number" name="metro_train_fare_35_65" value="8.40"></td>
        </tr>

        <tr>

            <td>65+ km</td>
            <td>$<input type="number" name="metro_train_single_65" value="8.99"></td>
            <td>$<input type="number" name="metro_train_off_peak_65" value="6.29"></td>
            <td>$<input type="number" name="metro_train_fare_65" value="10.80"></td>
        </tr>
    </table>

    <h2>Bus fares</h2>
    <table>
        <tr>

            <td>Distance;</td>
            <td>Adult Opal fare;</td>
            <td>Adult Opal off peak fare;</td>
            <td>Adult Opal single trip fare;</td>

        </tr>

        <tr>

            <td>0-3 km</td>
            <td>$<input type="number" name="Bus_single_0_3" value="3.20"></td>
            <td>$<input type="number" name="Bus_off_peak_0_3" value="2.24"></td>
            <td>$<input type="number" name="Bus_fare_0_3" value="4.00"></td>
        </tr>

        <tr>

            <td>3-8 km </td>
            <td>$<input type="number" name="Bus_single_3_8" value="3.79"></td>
            <td>$<input type="number" name="Bus_off_peak_3_8" value="2.65"></td>
            <td>$<input type="number" name="Bus_fare_3_8" value="4.60"></td>
        </tr>
        <tr>

            <td>8+ km</td>
            <td>$<input type="number" name="Bus_single_8" value="4.87"></td>
            <td>$<input type="number" name="Bus_off_peak_8" value="3.40"></td>
            <td>$<input type="number" name="Bus_fare_8" value="6.00"></td>
        </tr>

    </table>
    <h2>Ferry fares</h2>
    <table>
        <tr>

            <td>Distance;</td>
            <td>Adult Opal fare;</td>
            <td>Adult Opal off peak fare;</td>
            <td>Adult Opal single trip fare;</td>

        </tr>

        <tr>

            <td>0-9 km</td>
            <td>$<input type="number" name="Ferry_single_0_9" value="6.21"></td>
            <td>$<input type="number" name="Ferry_off_peak_0_9" value="6.21"></td>
            <td>$<input type="number" name="Ferry_fare_0_9" value="7.60"></td>
        </tr>

        <tr>

            <td>9+ km </td>
            <td>$<input type="number" name="Ferry_single_9" value="7.76"></td>
            <td>$<input type="number" name="Ferry_off_peak_9" value="7.76"></td>
            <td>$<input type="number" name="Ferry_fare_9" value="9.40"></td>
        </tr>
        <tr>

            <td>Newcastle Stockton ferry 0-3 km</td>
            <td>$<input type="number" name="Ferry_single_NS_0_3" value="3.20"></td>
            <td>$<input type="number" name="Ferry_off_peak_NS_0_3" value="2.24"></td>
            <td>$<input type="number" name="Ferry_fare_NS_0_3" value="4.00"></td>
        </tr>

    </table>

    <h2>Light rail fares</h2>
    <table>
        <tr>

            <td>Distance;</td>
            <td>Concession Opal fare;</td>
            <td>Concession Opal off peak fare;</td>
            <td>Adult Opal single trip fare;</td>

        </tr>

        <tr>

            <td>0-3 km</td>
            <td>$<input type="number" name="Light_rail_single_0_3" value="3.10"></td>
            <td>$<input type="number" name="Light_rail_off_peak_0_3" value="3.10"></td>
            <td>$<input type="number" name="Light_rail_fare_0_3" value="3.80"></td>
        </tr>

        <tr>

            <td>3-8 km </td>
            <td>$<input type="number" name="Light_rail_single_3_8" value="3.88"></td>
            <td>$<input type="number" name="Light_rail_off_peak_3_8" value="3.88"></td>
            <td>$<input type="number" name="Light_rail_fare_3_8" value="4.70"></td>
        </tr>
        <tr>

            <td>8+ km</td>
            <td>$<input type="number" name="Light_rail_single_8" value="2.43"></td>
            <td>$<input type="number" name="Light_rail_off_peak_8" value="1.70"></td>
            <td>$<input type="number" name="Light_rail_fare_8" value="6.00"></td>
        </tr>
    </table>
    <br>
    <button type="submit">Save</button>
    <button  onclick="location.href='faremanagement.jsp'" type="button">Return</button>
</form>

</body>
</html>


