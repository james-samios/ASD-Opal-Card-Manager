package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.dao.DBCustomerEnquiryManager;
import group2.asd.uts.edu.au.opal.dao.DBPaymentMethodManager;
import group2.asd.uts.edu.au.opal.model.Card;
import group2.asd.uts.edu.au.opal.model.CustomerEnquiry;
import group2.asd.uts.edu.au.opal.model.PaymentMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class CreateCustomerEnquiryServlet extends HttpServlet {

    private DBCustomerEnquiryManager customerEnquiryManager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Retrieve the current session
        HttpSession session = request.getSession();

        //Create an instance of the Validator class
        Validator validator = (Validator) session.getAttribute("validator");

        //Initialise the error message
        validator.clean(session);

        //Create the Customer Enquiry DBManager
        DBCustomerEnquiryManager customerEnquiryManager = (DBCustomerEnquiryManager) session.getAttribute("customerEnquiryManager");

        //Read POST parameters from the request
        String enquiryTitle = request.getParameter("enquiryTitle");
        String enquiryDetails = request.getParameter("enquiryDetails");
        String enquiryStatus = request.getParameter("enquiryStatus");
        String enquiryDate = request.getParameter("enquiryDate");

        //Methods for validation - sets error message
        //to do


    }

}
