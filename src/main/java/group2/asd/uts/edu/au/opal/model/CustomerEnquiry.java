package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.UUID;

@Getter
public class CustomerEnquiry extends Document {

    private ObjectId objectId;
    private final UUID customerEnquiryId;
    private String enquiryTitle;
    private String enquiryDetails;
    private String enquiryDate; //requires Date type
    private String enquiryStatus;
    // private String customerComments; //Create a customer comments object - to do for next release
    // private String officerComments; //Create an officer comments object - to do for next release

    /**
     * Loads a CustomerEnquiry object from the API.
     * @param document The BSON document from the users collection.
     * @author Chris
     */

    public CustomerEnquiry(final Document document) {
        this.objectId = new ObjectId(document.get("_id").toString());
        this.customerEnquiryId = UUID.fromString(document.getString("enquiry_id"));
        this.enquiryTitle = document.getString("enquiry_title");
        this.enquiryDetails = document.getString("enquiry_details");
        this.enquiryDate = document.getString("date_of_enquiry"); //to fix
        this.enquiryStatus = document.getString("enquiry_status");
        //to add customerComments
        //to add officerComments

    }

    /**
     * Creates a new CustomerEnquiry object.
     * @param enquiryTitle The title of the enquiry.
     * @param enquiryDetails The details of the enquiry.
     * @param enquiryDate The date the enquiry was submitted.
     * @param enquiryStatus The status of the enquiry.
     * @author Chris
     */

    public CustomerEnquiry(final String enquiryTitle, final String enquiryDetails, final String enquiryDate, final String enquiryStatus) {
        this.customerEnquiryId = UUID.randomUUID();
        this.enquiryTitle = enquiryTitle;
        this.enquiryDetails = enquiryDetails;
        this.enquiryDate = enquiryDate; //to fix
        this.enquiryStatus = enquiryStatus;
    }

    @Override
    public String toString() {
        return "" +
                getObjectId() + " - " +
                getCustomerEnquiryId() + " - " +
                getEnquiryTitle() + " - " +
                getEnquiryDetails() + " - " +
                getEnquiryDate() + " - " +
                getEnquiryStatus();
                //to add customerComments
                //to add officerComments
    }

}
