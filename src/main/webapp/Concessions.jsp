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
    <p>never pay more than $<input type="number" name="daily_weekly_min" value="<%=fares.getDaily_weekly_min()%>"> a day, $<input type="number" name="daily_weekly_max" value="<%=fares.getDaily_weekly_max()%>"> a week or $<input type="number" name="daily_weekly_weekends" value="<%=fares.getDaily_weekly_weekends()%>"> on Saturdays, Sundays and public holidays.</p>

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
            <td>$<input type="number" name="metro_train_single_0_10" value="<%=fares.getMetro_train_single_0_10()%>"></td>
            <td>$<input type="number" name="metro_train_off_peak_0_10" value="<%=fares.getMetro_train_off_peak_0_10()%>"></td>
            <td>$<input type="number" name="metro_train_fare_0_10" value="<%=fares.getMetro_train_fare_0_10()%>"></td>
        </tr>

        <tr>

            <td>10-20 km </td>
            <td>$<input type="number" name="metro_train_single_10_20" value="<%=fares.getMetro_train_single_10_20()%>"></td>
            <td>$<input type="number" name="metro_train_off_peak_10_20" value="<%=fares.getMetro_train_off_peak_10_20()%>"></td>
            <td>$<input type="number" name="metro_train_fare_10_20" value="<%=fares.getMetro_train_fare_10_20()%>"></td>
        </tr>
        <tr>

            <td>20-35 km</td>
            <td>$<input type="number" name="metro_train_single_20_35" value="<%=fares.getMetro_train_single_20_35()%>"></td>
            <td>$<input type="number" name="metro_train_off_peak_20_35" value="<%=fares.getMetro_train_off_peak_20_35()%>"></td>
            <td>$<input type="number" name="metro_train_fare_20_35" value="<%=fares.getMetro_train_fare_20_35()%>"></td>
        </tr>
        <tr>

            <td>35 - 65 km</td>
            <td>$<input type="number" name="metro_train_single_35_65" value="<%=fares.getMetro_train_single_35_65()%>"></td>
            <td>$<input type="number" name="metro_train_off_peak_35_65" value="<%=fares.getMetro_train_off_peak_35_65()%>"></td>
            <td>$<input type="number" name="metro_train_fare_35_65" value="<%=fares.getMetro_train_fare_35_65()%>"></td>
        </tr>

        <tr>

            <td>65+ km</td>
            <td>$<input type="number" name="metro_train_single_65" value="<%=fares.getMetro_train_single_65()%>"></td>
            <td>$<input type="number" name="metro_train_off_peak_65" value="<%=fares.getMetro_train_off_peak_65()%>"></td>
            <td>$<input type="number" name="metro_train_fare_65" value="<%=fares.getMetro_train_fare_65()%>"></td>
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
            <td>$<input type="number" name="Bus_single_0_3" value="<%=fares.getBus_single_0_3()%>"></td>
            <td>$<input type="number" name="Bus_off_peak_0_3" value="<%=fares.getBus_off_peak_0_3()%>"></td>
            <td>$<input type="number" name="Bus_fare_0_3" value="<%=fares.getBus_fare_0_3()%>"></td>
        </tr>

        <tr>

            <td>3-8 km </td>
            <td>$<input type="number" name="Bus_single_3_8" value="<%=fares.getBus_single_3_8()%>"></td>
            <td>$<input type="number" name="Bus_off_peak_3_8" value="<%=fares.getBus_off_peak_3_8()%>"></td>
            <td>$<input type="number" name="Bus_fare_3_8" value="<%=fares.getBus_fare_3_8()%>"></td>
        </tr>
        <tr>

            <td>8+ km</td>
            <td>$<input type="number" name="Bus_single_8" value="<%=fares.getBus_single_8()%>"></td>
            <td>$<input type="number" name="Bus_off_peak_8" value="<%=fares.getBus_off_peak_8()%>"></td>
            <td>$<input type="number" name="Bus_fare_8" value="<%=fares.getBus_fare_8()%>"></td>
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
            <td>$<input type="number" name="Ferry_single_0_9" value="<%=fares.getFerry_single_0_9()%>"></td>
            <td>$<input type="number" name="Ferry_off_peak_0_9" value="<%=fares.getFerry_off_peak_0_9()%>"></td>
            <td>$<input type="number" name="Ferry_fare_0_9" value="<%=fares.getFerry_fare_0_9()%>"></td>
        </tr>

        <tr>

            <td>9+ km </td>
            <td>$<input type="number" name="Ferry_single_9" value="<%=fares.getFerry_single_9()%>"></td>
            <td>$<input type="number" name="Ferry_off_peak_9" value="<%=fares.getFerry_off_peak_9()%>"></td>
            <td>$<input type="number" name="Ferry_fare_9" value="<%=fares.getFerry_fare_9()%>"></td>
        </tr>
        <tr>

            <td>Newcastle Stockton ferry 0-3 km</td>
            <td>$<input type="number" name="Ferry_single_NS_0_3" value="<%=fares.getFerry_single_NS_0_3()%>"></td>
            <td>$<input type="number" name="Ferry_off_peak_NS_0_3" value="<%=fares.getFerry_off_peak_NS_0_3()%>"></td>
            <td>$<input type="number" name="Ferry_fare_NS_0_3" value="<%=fares.getFerry_fare_NS_0_3()%>"></td>
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
            <td>$<input type="number" name="Light_rail_single_0_3" value="<%=fares.getLight_rail_single_0_3()%>"></td>
            <td>$<input type="number" name="Light_rail_off_peak_0_3" value="<%=fares.getLight_rail_off_peak_0_3()%>"></td>
            <td>$<input type="number" name="Light_rail_fare_0_3" value="<%=fares.getLight_rail_fare_0_3()%>"></td>
        </tr>

        <tr>

            <td>3-8 km </td>
            <td>$<input type="number" name="Light_rail_single_3_8" value="<%=fares.getLight_rail_single_3_8()%>"></td>
            <td>$<input type="number" name="Light_rail_off_peak_3_8" value="<%=fares.getLight_rail_off_peak_3_8()%>"></td>
            <td>$<input type="number" name="Light_rail_fare_3_8" value="<%=fares.getLight_rail_fare_3_8()%>"></td>
        </tr>
        <tr>

            <td>8+ km</td>
            <td>$<input type="number" name="Light_rail_single_8" value="<%=fares.getLight_rail_single_8()%>"></td>
            <td>$<input type="number" name="Light_rail_off_peak_8" value="<%=fares.getLight_rail_off_peak_8()%>"></td>
            <td>$<input type="number" name="Light_rail_fare_8" value="<%=fares.getLight_rail_fare_8()%>"></td>
        </tr>
    </table>
    <br>
    <button type="submit">Save</button>
    <button  onclick="location.href='faremanagement.jsp'" type="button">Return</button>
</form>

</body>
</html>


