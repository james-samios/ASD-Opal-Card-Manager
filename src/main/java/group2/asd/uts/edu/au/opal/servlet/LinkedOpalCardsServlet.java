package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBConnection;
import group2.asd.uts.edu.au.opal.dao.DBCustomerManager;
import group2.asd.uts.edu.au.opal.model.Customer;
import group2.asd.uts.edu.au.opal.model.Trip;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;


public class LinkedOpalCardsServlet extends HttpServlet {

    private DBConnection connection;

    @Override
    public void init() {
        this.connection = DBConnection.getDB();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer)session.getAttribute("customer");
        request.setAttribute("cards",customer.getLinkedCards());
        ArrayList<Trip> tripList = new ArrayList<>();
        tripList.add(new Trip("Kings Cross", "Bondi Junction", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 1.49));
        tripList.add(new Trip("Kings Cross2", "Bondi Junction", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 1.49));
        tripList.add(new Trip("Kings Cross3", "Bondi Junction", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 1.49));
        request.setAttribute("trips", tripList);
        request.getRequestDispatcher("linkedopalcards.jsp").include(request, response);
    }

}