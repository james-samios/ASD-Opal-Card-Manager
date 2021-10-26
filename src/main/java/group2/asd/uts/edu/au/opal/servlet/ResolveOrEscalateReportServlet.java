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

public class ResolveOrEscalateReportServlet extends HttpServlet {

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

        //Resolve report
        String updatedStatus = request.getParameter("updatedStatus");
        String resolveReason = request.getParameter("resolveComment");
        IncidentReport incidentReport = (IncidentReport)  session.getAttribute("incidentReport");
        String incidentReportId = incidentReport.getIncidentReportId().toString();

        if (updatedStatus.equals("Resolve")) {
            String resolvedStatus = "Resolved";
            incidentReportManager.resolveReport(incidentReportId, resolveReason, resolvedStatus);
            request.getRequestDispatcher("/incidentReportManagerHome.jsp").forward(request, response);
        }

        if (updatedStatus.equals("Escalate")) {
            String escalateStatus = "Escalated";
            incidentReportManager.escalateReport(incidentReportId, resolveReason, escalateStatus);
            request.getRequestDispatcher("/incidentReportManagerHome.jsp").forward(request, response);
        }

    }

}
