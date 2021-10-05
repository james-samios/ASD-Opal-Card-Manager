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
import java.util.ArrayList;

public class ListIncidentReportServlet extends HttpServlet {

    private DBConnection connection;
    private DBIncidentReportManager incidentReportManager;

    @Override
    public void init() {
        this.connection = DBConnection.getDB();
        this.incidentReportManager = new DBIncidentReportManager();
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

        ArrayList<IncidentReport> incidentReportsList = null;
        incidentReportsList = incidentReportManager.listIncidentReports();
        session.setAttribute("incidentReportsList", incidentReportsList);
        request.getRequestDispatcher("/incidentReportList.jsp").forward(request, response);

    }

}
