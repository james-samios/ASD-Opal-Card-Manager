package group2.asd.uts.edu.au.opal.servlet;

import com.mongodb.DB;
import group2.asd.uts.edu.au.opal.dao.DBFaresManager;
import group2.asd.uts.edu.au.opal.model.Fares;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateFaresServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        //1 Get fares from session.getAttribute();
        Fares fares = (Fares) session.getAttribute("fares");

        //2 update fares
        //2.1 Reading post parameters from the request
        String dailyWeeklyMin = request.getParameter("daily_weekly_min");
        String dailyWeeklyMax = request.getParameter("daily_weekly_max");
        String dailyWeeklyWeekends = request.getParameter("daily_weekly_weekends");
        String MetroTrainSingle010 = request.getParameter("metro_train_single_0_10");
        String MetroTrainOffPeak010 = request.getParameter("metro_train_off_peak_0_10");
        String MetroTrainFare010 = request.getParameter("metro_train_fare_0_10");
        String MetroTrainSingle1020 = request.getParameter("metro_train_single_10_20");
        String MetroTrainOffPeak1020 = request.getParameter("metro_train_off_peak_10_20");
        String MetroTrainFare1020 = request.getParameter("metro_train_fare_10_20");
        String MetroTrainSingle2035 = request.getParameter("metro_train_single_20_35");
        String MetroTrainOffPeak2035 = request.getParameter("metro_train_off_peak_20_35");
        String MetroTrainFare2035 = request.getParameter("metro_train_fare_20_35");
        String MetroTrainSingle3565 = request.getParameter("metro_train_single_35_65");
        String MetroTrainOffPeak3565 = request.getParameter("metro_train_off_peak_35_65");
        String MetroTrainFare3565 = request.getParameter("metro_train_fare_35_65");
        String MetroTrainSingle65 = request.getParameter("metro_train_single_65");
        String MetroTrainOffPeak65 = request.getParameter("metro_train_off_peak_65");
        String MetroTrainFare65 = request.getParameter("metro_train_fare_65");
        String BusSingle03 = request.getParameter("Bus_single_0_3");
        String BusOffPeak03 = request.getParameter("Bus_off_peak_0_3");
        String BusFare03 = request.getParameter("Bus_fare_0_3");
        String BusSingle38 = request.getParameter("Bus_single_3_8");
        String BusOffPeak38 = request.getParameter("Bus_off_peak_3_8");
        String BusFare38 = request.getParameter("Bus_fare_3_8");
        String BusSingle8 = request.getParameter("Bus_single_8");
        String BusOffPeak8 = request.getParameter("Bus_off_peak_8");
        String BusFare8 = request.getParameter("Bus_fare_8");
        String FerrySingle09 = request.getParameter("Ferry_single_0_9");
        String FerryOffPeak09 = request.getParameter("Ferry_off_peak_0_9");
        String FerryFare09 = request.getParameter("Ferry_fare_0_9");
        String FerrySingle9 = request.getParameter("Ferry_single_9");
        String FerryOffPeak9 = request.getParameter("Ferry_off_peak_9");
        String FerryFare9 = request.getParameter("Ferry_fare_9");
        String FerrySingleNS03 = request.getParameter("Ferry_single_NS_0_3");
        String FerryOffPeakNS03 = request.getParameter("Ferry_off_peak_NS_0_3");
        String FerryFareNS03 = request.getParameter("Ferry_fare_NS_0_3");
        String LightRailSingle03 = request.getParameter("Light_rail_single_0_3");
        String LightRailOffPeak03 = request.getParameter("Light_rail_off_peak_0_3");
        String LightRailFare03 = request.getParameter("Light_rail_fare_0_3");
        String LightRailSingle38 = request.getParameter("Light_rail_single_3_8");
        String LightRailOffPeak38 = request.getParameter("Light_rail_off_peak_3_8");
        String LightRailFare38 = request.getParameter("Light_rail_fare_3_8");
        String LightRailSingle8 = request.getParameter("Light_rail_single_8");
        String LightRailOffPeak8 = request.getParameter("Light_rail_off_peak_8");
        String LightRailFare8 = request.getParameter("Light_rail_fare_8");







        //2.2 update fares
        fares.setDaily_weekly_min(Double.parseDouble(dailyWeeklyMin));
        fares.setDaily_weekly_max(Double.parseDouble(dailyWeeklyMax));
        fares.setDaily_weekly_weekends(Double.parseDouble(dailyWeeklyWeekends));
        fares.setMetro_train_single_0_10(Double.parseDouble(MetroTrainSingle010));
        fares.setMetro_train_off_peak_0_10(Double.parseDouble(MetroTrainOffPeak010));
        fares.setMetro_train_fare_0_10(Double.parseDouble(MetroTrainFare010));

        fares.setMetro_train_single_10_20(Double.parseDouble(MetroTrainSingle1020));
        fares.setMetro_train_off_peak_10_20(Double.parseDouble(MetroTrainOffPeak1020));
        fares.setMetro_train_fare_10_20(Double.parseDouble(MetroTrainFare1020));

        fares.setMetro_train_single_20_35(Double.parseDouble(MetroTrainSingle2035));
        fares.setMetro_train_off_peak_20_35(Double.parseDouble(MetroTrainOffPeak2035));
        fares.setMetro_train_fare_20_35(Double.parseDouble(MetroTrainFare2035));

        fares.setMetro_train_single_35_65(Double.parseDouble(MetroTrainSingle3565));
        fares.setMetro_train_off_peak_35_65(Double.parseDouble(MetroTrainOffPeak3565));
        fares.setMetro_train_fare_35_65(Double.parseDouble(MetroTrainFare3565));

        fares.setMetro_train_single_65(Double.parseDouble(MetroTrainSingle65));
        fares.setMetro_train_off_peak_65(Double.parseDouble(MetroTrainOffPeak65));
        fares.setMetro_train_fare_65(Double.parseDouble(MetroTrainFare65));

        fares.setBus_single_0_3(Double.parseDouble(BusSingle03));
        fares.setBus_off_peak_0_3(Double.parseDouble(BusOffPeak03));
        fares.setBus_fare_0_3(Double.parseDouble(BusFare03));

        fares.setBus_single_3_8(Double.parseDouble(BusSingle38));
        fares.setBus_off_peak_3_8(Double.parseDouble(BusOffPeak38));
        fares.setBus_fare_3_8(Double.parseDouble(BusFare38));

        fares.setBus_single_8(Double.parseDouble(BusSingle8));
        fares.setBus_off_peak_8(Double.parseDouble(BusOffPeak8));
        fares.setBus_fare_8(Double.parseDouble(BusFare8));

        fares.setFerry_single_0_9(Double.parseDouble(FerrySingle09));
        fares.setFerry_off_peak_0_9(Double.parseDouble(FerryOffPeak09));
        fares.setFerry_fare_0_9(Double.parseDouble(FerryFare09));

        fares.setFerry_single_9(Double.parseDouble(FerrySingle9));
        fares.setFerry_off_peak_9(Double.parseDouble(FerryOffPeak9));
        fares.setFerry_fare_9(Double.parseDouble(FerryFare9));

        fares.setFerry_single_NS_0_3(Double.parseDouble(FerrySingleNS03));
        fares.setFerry_off_peak_NS_0_3(Double.parseDouble(FerryOffPeakNS03));
        fares.setFerry_fare_NS_0_3(Double.parseDouble(FerryFareNS03));

        fares.setLight_rail_single_0_3(Double.parseDouble(LightRailSingle03));
        fares.setLight_rail_off_peak_0_3(Double.parseDouble(LightRailOffPeak03));
        fares.setLight_rail_fare_0_3(Double.parseDouble(LightRailFare03));

        fares.setLight_rail_single_3_8(Double.parseDouble(LightRailSingle38));
        fares.setLight_rail_off_peak_3_8(Double.parseDouble(LightRailOffPeak38));
        fares.setLight_rail_fare_3_8(Double.parseDouble(LightRailFare38));

        fares.setLight_rail_single_8(Double.parseDouble(LightRailSingle8));
        fares.setLight_rail_off_peak_8(Double.parseDouble(LightRailOffPeak8));
        fares.setLight_rail_fare_8(Double.parseDouble(LightRailFare8));








        //3 create DBFaresManager to update data into database
        DBFaresManager dbFaresManager = new DBFaresManager();
        dbFaresManager.updateFaresByFares(fares);


        //4 update the fares in the current cession
        session.setAttribute("fares", fares);

        //5 push view
        request.getRequestDispatcher("Concessions.jsp").include(request, response);
    }
}
