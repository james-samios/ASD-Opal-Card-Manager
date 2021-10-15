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

        //2.2 update fares
        fares.setDaily_weekly_min(Double.parseDouble(dailyWeeklyMin));
        fares.setDaily_weekly_min(Double.parseDouble(dailyWeeklyMax));

        //3 create DBFaresManager to update data into database
        DBFaresManager dbFaresManager = new DBFaresManager();
        dbFaresManager.updateFaresByFares(fares);


        //4 update the fares in the current cession
        session.setAttribute("fares", fares);

        //5 push view
        request.getRequestDispatcher("Concessions.jsp").include(request, response);
    }
}
