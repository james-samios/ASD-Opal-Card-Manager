package group2.asd.uts.edu.au.opal.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Updates;
import group2.asd.uts.edu.au.opal.model.CustomerEnquiry;
import group2.asd.uts.edu.au.opal.model.IncidentReport;
import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class DBIncidentReportManager extends DBManager {

    public DBIncidentReportManager() {
        super(CollectionType.INCIDENT_REPORTS);
    }

    /*   *************************************Methods for "C" section below****************************************   */

    /**
     * Creates a new customerEnquiry object into the API.
     * @param incidentReportType The incident type, either theft or loss.
     * @param incidentReportDetails The details of the report.
     * @param incidentReportDate The date of the incident.
     * @param incidentReportStatus The status of the report (initially set as "Submitted").
     * @param customerResolveReason Customer's reason for resolving an incident before investigation.
     */
    public void createIncidentReport(final UUID incidentReportId, final String accountId, final String incidentReportType, final String incidentReportDetails, final String incidentReportDate, final String incidentReportStatus, final String customerResolveReason) {
        refresh();

        Document incidentReport = new Document("_id", new ObjectId());
        incidentReport.append("report_id", incidentReportId.toString())
                .append("account_id", accountId)
                .append("report_type", incidentReportType)
                .append("report_details", incidentReportDetails)
                .append("date_of_report", incidentReportDate)
                .append("report_status", incidentReportStatus)
                .append("customer_resolve_reason", customerResolveReason)
                .append("resolve_comment", "")
                .append("escalation_reason", "");
        getCollection().insertOne(incidentReport);
    }

    /*   *************************************Methods for "R" section below****************************************   */

    /**
     * Returns an Incident Report object with a provided incidentReportId
     * If the Customer Enquiry cannot be found, it will return null
     * @param incidentReportId The ID of the Incident Report object.
     * @return Incident Report object.
     * @author Chris
     */

    public IncidentReport getIncidentReport(final String incidentReportId) {
        refresh();
        BasicDBObject where = new BasicDBObject();
        where.put("report_id", incidentReportId);
        Document doc = getCollection().find(where).first();
        if (doc == null || doc.isEmpty()) return null;
        return new IncidentReport(doc);
    }

    /**
     * Returns a list of all the incident reports given an accountID
     * @return ArrayList of incident reports
     * @author Chris
     */

    public ArrayList<IncidentReport> listIncidentReports(String accountId) {

        ArrayList<IncidentReport> incidentReports = new ArrayList<>();

        BasicDBObject where = new BasicDBObject();
        where.put("account_id", accountId);

        List<Document> enquiriesList = getCollection().find(where).into(new ArrayList<>());
        for (Document enquiry : enquiriesList) {
            IncidentReport newIncidentReport = new IncidentReport(enquiry);
            incidentReports.add(newIncidentReport);
        }

        return incidentReports;

    }

    /**
     * Return an Arraylist of reports according to status
     */

    public ArrayList<IncidentReport> listReportsByStatus(String status) {

        ArrayList<IncidentReport> incidentReports = new ArrayList<>();

        BasicDBObject where = new BasicDBObject();
        where.put("report_status", status);

        List<Document> enquiriesList = getCollection().find(where).into(new ArrayList<>());
        for (Document enquiry : enquiriesList) {
            IncidentReport newIncidentReport = new IncidentReport(enquiry);
            incidentReports.add(newIncidentReport);
        }

        return incidentReports;

    }

    /**
     * Returns a list of reports that are unresolved
     * @return
     */

    public ArrayList<IncidentReport> listUnresolvedReports() {

        ArrayList<IncidentReport> incidentReports = new ArrayList<>();

        BasicDBObject where = new BasicDBObject();

        List<Document> enquiriesList = getCollection().find(where).into(new ArrayList<>());
        for (Document enquiry : enquiriesList) {
            IncidentReport newIncidentReport = new IncidentReport(enquiry);
            if (!newIncidentReport.getIncidentReportStatus().equals("Resolved")) {
                incidentReports.add(newIncidentReport);
            }
        }

        return incidentReports;

    }

    /*   *************************************Methods for "U" section below****************************************   */

    /**
     * Updates a Report status and resolve reason with a provided incidentReportId
     * @param incidentReportId The ID of the report to be updated.
     * @param resolveReason The Customer's reason to resolve the report.
     * @param reportStatus The status to be updated.
     * @author Chris
     */

    public void updateResolveReason(final String incidentReportId, final String resolveReason, final String reportStatus) {
        BasicDBObject where = new BasicDBObject();
        where.put("report_id", incidentReportId);
        getCollection().updateOne(where, Updates.set("customer_resolve_comment", resolveReason));
        getCollection().updateOne(where, Updates.set("report_status", reportStatus));
    }

    /**
     * Resolves a report
     * @param incidentReportId the report ID
     * @param resolveComment the reason for resolving the report
     * @param updatedStatus the updated status of the report
     */

    public void resolveReport(final String incidentReportId, final String resolveComment, final String updatedStatus) {
        BasicDBObject where = new BasicDBObject();
        where.put("report_id", incidentReportId);
        getCollection().updateOne(where, Updates.set("report_status", updatedStatus));
        getCollection().updateOne(where, Updates.set("resolve_comment", resolveComment));
    }

    /**
     * Escalates a report
     * @param incidentReportId the report ID
     * @param escalationReason the reason for escalating the report
     * @param updatedStatus the updated status of the report
     */

    public void escalateReport(final String incidentReportId, final String escalationReason, final String updatedStatus) {
        BasicDBObject where = new BasicDBObject();
        where.put("report_id", incidentReportId);
        getCollection().updateOne(where, Updates.set("report_status", updatedStatus));
        getCollection().updateOne(where, Updates.set("escalation_reason", escalationReason));
    }

    /*   *************************************Methods for "D" section below****************************************   */

    /**
     * Deletes an Incident Report with a provided report ID
     * @param incidentReportId The ID of the report to be deleted.
     * @author Chris
     */

    public void deleteIncidentReport(final String incidentReportId) {
        BasicDBObject where = new BasicDBObject();
        where.put("report_id", incidentReportId);
        getCollection().deleteOne(where);
    }


}
