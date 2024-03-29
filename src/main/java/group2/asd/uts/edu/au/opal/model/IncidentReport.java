package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.UUID;

@Getter
public class IncidentReport extends Document {

    private ObjectId objectId;
    private final UUID incidentReportId;
    private String accountId;
    private String incidentReportType;
    private String incidentReportDetails;
    private String incidentReportDate; //requires Date type
    private String incidentReportStatus;
    private String customerResolveReason;
    private String resolveComment;
    private String escalationReason;

    /**
     * Loads an Incident Report object from the API.
     * @param document The BSON document from the users collection.
     * @author Chris
     */

    public IncidentReport(final Document document) {
        this.objectId = new ObjectId(document.get("_id").toString());
        this.incidentReportId = UUID.fromString(document.getString("report_id"));
        this.incidentReportType = document.getString("report_type");
        this.incidentReportDetails = document.getString("report_details");
        this.incidentReportDate = document.getString("date_of_report"); //to fix
        this.incidentReportStatus = document.getString("report_status");
        this.customerResolveReason = document.getString("resolve_reason");
        this.resolveComment = document.getString("resolve_comment");
        this.escalationReason = document.getString("escalation_reason");

    }

    /**
     * Creates a new Incident Report object.
     * @param incidentReportType The report type, either theft or loss.
     * @param incidentReportDetails The details of the report.
     * @param incidentReportDate The date the incident occurred.
     * @param incidentReportStatus The status of the report.
     * @author Chris
     */

    public IncidentReport(final UUID incidentReportId, final String accountId, final String incidentReportType, final String incidentReportDetails, final String incidentReportDate, final String incidentReportStatus, final String resolveReason) {
        this.accountId = accountId;
        this.incidentReportId = incidentReportId;
        this.incidentReportType = incidentReportType;
        this.incidentReportDetails = incidentReportDetails;
        this.incidentReportDate = incidentReportDate; //to fix
        this.incidentReportStatus = incidentReportStatus;
        this.customerResolveReason = resolveReason;
        this.resolveComment = "";
        this.escalationReason = "";
    }

    @Override
    public String toString() {
        return "" +
                getObjectId() + " - " +
                getIncidentReportId() + " - " +
                getAccountId() + " - " +
                getIncidentReportType() + " - " +
                getIncidentReportDetails() + " - " +
                getIncidentReportDate() + " - " +
                getIncidentReportStatus() + " - " +
                getCustomerResolveReason() + " - " +
                getResolveComment() + " - " +
                getEscalationReason();
    }

}
