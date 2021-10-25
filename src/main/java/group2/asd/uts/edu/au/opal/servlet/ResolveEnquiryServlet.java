package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBConnection;
import group2.asd.uts.edu.au.opal.dao.DBCustomerEnquiryManager;
import group2.asd.uts.edu.au.opal.dao.DBIncidentReportManager;
import group2.asd.uts.edu.au.opal.model.CustomerEnquiry;
import group2.asd.uts.edu.au.opal.model.IncidentReport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ResolveEnquiryServlet extends HttpServlet {

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

        //Update the enquiry details
        String resolveReason = request.getParameter("resolveComment");
        CustomerEnquiry customerEnquiry = (CustomerEnquiry)  session.getAttribute("customerEnquiry");
        String customerEnquiryId = customerEnquiry.getCustomerEnquiryId().toString();
        String updatedStatus = "Resolved";
        customerEnquiryManager.resolveEnquiry(customerEnquiryId, resolveReason, updatedStatus);

        //Redirect to Enquiry Manager Home page
        request.getRequestDispatcher("/enquiryManagerHome.jsp").forward(request, response);

    }

}
