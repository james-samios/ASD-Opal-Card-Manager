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

public class IncidentReportReviewListServlet extends HttpServlet {

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

        //Return unresolved reports
        ArrayList<IncidentReport> unresolvedReportsList = null;
        unresolvedReportsList = incidentReportManager.listUnresolvedReports();
        session.setAttribute("unresolvedReports", unresolvedReportsList);

        //Return resolved reports
        ArrayList<IncidentReport> resolvedReportsList = null;
        String resolvedStatus = "Resolved";
        resolvedReportsList = incidentReportManager.listReportsByStatus(resolvedStatus);
        session.setAttribute("resolvedReports", resolvedReportsList);

        //Redirect to Enquiry Manager Home page
        request.getRequestDispatcher("/incidentReportManagerHome.jsp").forward(request, response);

    }

}
