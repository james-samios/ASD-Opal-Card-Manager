package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBStationsManager;
import group2.asd.uts.edu.au.opal.model.Customer;
import group2.asd.uts.edu.au.opal.model.Station;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LocationServlet", value = "/")
public class LocationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Customer currentUser = (Customer)session.getAttribute("customer");
        if(currentUser ==null){
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        //1.1 initialise database manager
        DBStationsManager dbStationsManager = new DBStationsManager();

        //1.2 create a variable of fares to store data from database
        List<Station> stations = dbStationsManager.allStations();

        //2.2 store fares into the current session
        session.setAttribute("stations", stations);

        /* if (session.isNew()) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } */

        request.getRequestDispatcher("/locations.jsp").forward(request, response);

    }
}