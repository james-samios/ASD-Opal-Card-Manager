package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.*;
import group2.asd.uts.edu.au.opal.model.Customer;

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
        Customer customer = (Customer) session.getAttribute("customer");

        //Read POST parameters from the request
        UUID customerEnquiryID = UUID.randomUUID();
        String accountId = customer.getAccountId().toString();
        String enquiryTitle = request.getParameter("enquiryTitle");
        String enquiryDetails = request.getParameter("enquiryDetails");
        String enquiryStatus = "Submitted";
        String enquiryDate = "2/10/2021"; //temporary - TO DO put current date

        //Create the enquiry
        customerEnquiryManager.createCustomerEnquiry(customerEnquiryID, accountId, enquiryTitle, enquiryDetails, enquiryDate, enquiryStatus);

        //Push to enquiry home page
        request.getRequestDispatcher("/enquiryConfirmation.jsp").forward(request, response);

    }

}
