package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.model.CustomerEnquiry;
import group2.asd.uts.edu.au.opal.model.IncidentReport;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class TestIncidentReportClass {

    private final UUID incidentReportId = UUID.fromString("5653e70d-8291-4705-8140-291442652d58");
    private String accountId = "123456789";
    private String incidentReportType = "Missing Opal Card";
    private String incidentReportDetails = "Test Report Details";
    private String incidentReportDate = "2021-05-06"; //requires Date type
    private String incidentReportStatus = "Submitted";
    private String resolveReason = "Test reason for resolving report";

    private final IncidentReport expectedIncidentReport = new IncidentReport(incidentReportId,
            accountId, incidentReportType, incidentReportDetails, incidentReportDate, incidentReportStatus, resolveReason);

    @Test
    public void testGetIncidentReportId() {
        assertEquals(incidentReportId, expectedIncidentReport.getIncidentReportId());
    }

    @Test
    public void testGetIncidentReportType() {
        assertEquals(incidentReportType, expectedIncidentReport.getIncidentReportType());
    }

    @Test
    public void testGetIncidentReportDetails() {
        assertEquals(incidentReportDetails, expectedIncidentReport.getIncidentReportDetails());
    }

    @Test
    public void testGetIncidentReportDate() {
        assertEquals(incidentReportDate, expectedIncidentReport.getIncidentReportDate());
    }

    @Test
    public void testGetIncidentReportStatus() {
        assertEquals(incidentReportStatus, expectedIncidentReport.getIncidentReportStatus());
    }

    @Test
    public void testGetResolveReason() {
        assertEquals(resolveReason, expectedIncidentReport.getResolveReason());
    }

}
