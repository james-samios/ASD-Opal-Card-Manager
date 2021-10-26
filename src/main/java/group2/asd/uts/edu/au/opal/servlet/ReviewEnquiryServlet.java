package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBConnection;
import group2.asd.uts.edu.au.opal.dao.DBCustomerEnquiryManager;
import group2.asd.uts.edu.au.opal.model.CustomerEnquiry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ReviewEnquiryServlet extends HttpServlet {

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

        //Search for enquiry
        String customerEnquiryId = request.getParameter("customerEnquiryId");
        CustomerEnquiry customerEnquiry = customerEnquiryManager.getCustomerEnquiry(customerEnquiryId);
        session.setAttribute("customerEnquiry", customerEnquiry);

        //Set error message if customer enquiry is null
        if (customerEnquiry != null) {
            request.getRequestDispatcher("/reviewEnquiry.jsp").forward(request, response);
        } else {
            session.setAttribute("enquirySearchErr", "Error: The enquiry does not exist");
            request.getRequestDispatcher("/enquiryManagerHome.jsp").forward(request, response);
        }

    }

}
