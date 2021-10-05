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
     * @param resolveReason Customer's reason for resolving an incident before investigation.
     */
    public void createIncidentReport(final UUID incidentReportId, final String incidentReportType, final String incidentReportDetails, final String incidentReportDate, final String incidentReportStatus, final String resolveReason) {
        refresh();

        Document incidentReport = new Document("_id", new ObjectId());
        incidentReport.append("report_id", incidentReportId.toString())
                .append("report_type", incidentReportType)
                .append("report_details", incidentReportDetails)
                .append("date_of_report", incidentReportDate)
                .append("report_status", incidentReportStatus)
                .append("resolve_reason", resolveReason);
                //to add comments
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
     * Returns a list of all the incident reports submitted
     * @return ArrayList of incident reports
     * @author Chris
     */

    public ArrayList<IncidentReport> listIncidentReports() {

        ArrayList<IncidentReport> incidentReports = new ArrayList<>();

        //to do - return only submitted enquiries?
        List<Document> enquiriesList = getCollection().find().into(new ArrayList<>());
        for (Document enquiry : enquiriesList) {
            IncidentReport newIncidentReport = new IncidentReport(enquiry);
            incidentReports.add(newIncidentReport);
        }

        return incidentReports;

    }

    /*   *************************************Methods for "U" section below****************************************   */

    /**
     * Updates a Customer Enquiry status with a provided customerEnquiryId
     * @param customerEnquiryId The ID of the customer enquiry to be updated.
     * @param updatedStatus The updated status of the customer enquiry.
     * @author Chris
     */

    public void updateEnquiryStatus(final String customerEnquiryId, final String updatedStatus) {
        BasicDBObject where = new BasicDBObject();
        where.put("enquiry_id", customerEnquiryId);
        getCollection().updateOne(where, Updates.set("enquiry_status", updatedStatus));

        // to do
    }

    /**
     * Adds a customer comment to the enquiry
     */

    public void addCustomerComment(final String customerEnquiryId, String comment) {
        BasicDBObject where = new BasicDBObject();
        where.put("enquiry_id", customerEnquiryId);
        //to do
    }



    /*   *************************************Methods for "D" section below****************************************   */

    /**
     * Deletes a Customer Enquiry with a provided customerEnquiryId
     * @param customerEnquiryId The ID of the customer enquiry to be deleted.
     * @author Chris
     */

    public void deleteCustomerEnquiry(final String customerEnquiryId) {
        BasicDBObject where = new BasicDBObject();
        where.put("enquiry_id", customerEnquiryId);
        getCollection().deleteOne(where);

        //to do
    }


}
