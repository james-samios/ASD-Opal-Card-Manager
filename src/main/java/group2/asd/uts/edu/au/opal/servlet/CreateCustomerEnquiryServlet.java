package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class CreateCustomerEnquiryServlet extends HttpServlet {

    private DBConnection connection;
    private DBCustomerEnquiryManager customerEnquiryManager;

    @Override
    public void init() {
        this.connection = DBConnection.getDB();
        this.customerEnquiryManager = new DBCustomerEnquiryManager();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Retrieve the current session
        HttpSession session = request.getSession();

        //Create an instance of the Validator class
        //Validator validator = (Validator) session.getAttribute("validatorMessage");

        //Initialise the error message
        //validator.clean(session);

        //Create the Customer Enquiry DBManager
        //DBCustomerEnquiryManager customerEnquiryManager = (DBCustomerEnquiryManager) session.getAttribute("customerEnquiryManager");

        //Read POST parameters from the request
        UUID customerEnquiryID = UUID.randomUUID();
        String enquiryTitle = request.getParameter("enquiryTitle");
        String enquiryDetails = request.getParameter("enquiryDetails");
        String enquiryStatus = "Submitted";
        String enquiryDate = "2/10/2021"; //temporary - TO DO put current date

        //Create the enquiry
        customerEnquiryManager.createCustomerEnquiry(customerEnquiryID, enquiryTitle, enquiryDetails, enquiryDate, enquiryStatus);

        //Push to enquiry home page
        request.getRequestDispatcher("/enquiryConfirmation.jsp").forward(request, response);

    }

}
