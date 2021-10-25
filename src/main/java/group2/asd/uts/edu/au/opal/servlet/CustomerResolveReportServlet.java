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

public class CustomerResolveReportServlet extends HttpServlet {

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

        String resolveReason = request.getParameter("resolveReason");
        IncidentReport incidentReport = (IncidentReport)  session.getAttribute("incidentReport");
        String incidentReportId = incidentReport.getIncidentReportId().toString();
        String updatedStatus = "Customer Resolution Requested";

        incidentReportManager.updateResolveReason(incidentReportId, resolveReason, updatedStatus);

        //Redirect to reports list
        request.getRequestDispatcher("/incidentReportHome.jsp").forward(request, response);

    }

}
