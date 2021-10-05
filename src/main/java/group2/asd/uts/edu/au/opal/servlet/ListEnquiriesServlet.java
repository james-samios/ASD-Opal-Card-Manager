package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBConnection;
import group2.asd.uts.edu.au.opal.dao.DBCustomerEnquiryManager;
import group2.asd.uts.edu.au.opal.model.Customer;
import group2.asd.uts.edu.au.opal.model.CustomerEnquiry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ListEnquiriesServlet extends HttpServlet {

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

        String accountId = customer.getAccountId().toString();
        ArrayList<CustomerEnquiry> enquiriesList = null;
        enquiriesList = customerEnquiryManager.listCustomerEnquiries(accountId);
        session.setAttribute("enquiriesList", enquiriesList);
        request.getRequestDispatcher("/enquiryList.jsp").forward(request, response);

    }

}
