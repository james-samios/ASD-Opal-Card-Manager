package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBFaresManager;
import group2.asd.uts.edu.au.opal.model.Fares;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class FaresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1 get data from database
        //1.1 initialise database manager
        DBFaresManager dbFaresManager = new DBFaresManager();

        //1.2 create a variable of fares to store data from database
        Fares fares = dbFaresManager.readFare();

        //2 store data into current session
        //2.1 create a variable of HttpSession to store current session
        HttpSession session = request.getSession();

        //2.2 store fares into the current session
        session.setAttribute("fares", fares);

        //3 push view
        request.getRequestDispatcher("/Concessions.jsp").forward(request, response);
    }
}
