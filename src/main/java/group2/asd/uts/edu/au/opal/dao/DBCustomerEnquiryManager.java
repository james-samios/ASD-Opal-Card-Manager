package group2.asd.uts.edu.au.opal.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.model.Updates;
import group2.asd.uts.edu.au.opal.model.Customer;
import group2.asd.uts.edu.au.opal.model.CustomerComments;
import group2.asd.uts.edu.au.opal.model.CustomerEnquiry;
import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.persistence.Basic;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class DBCustomerEnquiryManager extends DBManager {

    public DBCustomerEnquiryManager() {
        super(CollectionType.CUSTOMER_ENQUIRIES);
    }

    /*   *************************************Methods for "C" section below****************************************   */

    /**
     * Creates a new customerEnquiry object into the API.
     * @param enquiryTitle The title of the enquiry.
     * @param enquiryDetails The details of the enquiry.
     * @param enquiryDate The date the enquiry was submitted.
     * @param enquiryStatus The status of the enquiry (initially set as "Submitted").
     */
    public void createCustomerEnquiry(final UUID customerEnquiryID, final String accountId, final String enquiryTitle, final String enquiryDetails, final String enquiryDate, final String enquiryStatus) {
        refresh();

        Document enquiry = new Document("_id", new ObjectId());
        enquiry.append("enquiry_id", customerEnquiryID.toString())
                .append("account_id", accountId)
                .append("enquiry_title", enquiryTitle)
                .append("enquiry_details", enquiryDetails)
                .append("date_of_enquiry", enquiryDate)
                .append("enquiry_status", enquiryStatus)
                .append("resolve_comment", "");
        getCollection().insertOne(enquiry);
    }

    /*   *************************************Methods for "R" section below****************************************   */

    /**
     * Returns a Customer Enquiry with a provided customerEnquiryId
     * If the Customer Enquiry cannot be found, it will return null
     * @param customerEnquiryId The ID of the Customer Enquiry object.
     * @return Customer Enquiry object.
     * @author Chris
     */

    public CustomerEnquiry getCustomerEnquiry(final String customerEnquiryId) {
        refresh();
        BasicDBObject where = new BasicDBObject();
        where.put("enquiry_id", customerEnquiryId);
        Document doc = getCollection().find(where).first();
        if (doc == null || doc.isEmpty()) return null;
        return new CustomerEnquiry(doc);
    }

    /**
     * Returns a list of all the enquiries submitted
     * @return ArrayList of customer enquiries
     * @author Chris
     */

    public ArrayList<CustomerEnquiry> listCustomerEnquiries(String accountId) {

        ArrayList<CustomerEnquiry> enquiries = new ArrayList<CustomerEnquiry>();

        BasicDBObject where = new BasicDBObject();
        where.put("account_id", accountId);

        List<Document> enquiriesList = getCollection().find(where).into(new ArrayList<>());
        for (Document enquiry : enquiriesList) {
            CustomerEnquiry newEnquiry = new CustomerEnquiry(enquiry);
            enquiries.add(newEnquiry);
        }

        return enquiries;

    }

    /**
     * Returns a list of enquiries according to status
     * @return
     */

    public ArrayList<CustomerEnquiry> listEnquiriesByStatus(String status) {

        ArrayList<CustomerEnquiry> enquiries = new ArrayList<CustomerEnquiry>();

        BasicDBObject where = new BasicDBObject();
        where.put("enquiry_status", status);

        List<Document> enquiriesList = getCollection().find(where).into(new ArrayList<>());
        for (Document enquiry : enquiriesList) {
            CustomerEnquiry newEnquiry = new CustomerEnquiry(enquiry);
            enquiries.add(newEnquiry);
        }

        return enquiries;

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
    }

    /**
     * Updates and resolves an enquiry
     * @param customerEnquiryId the ID of the enquiry
     * @param resolveComment the staff comment for resolving the enquiry
     * @param updatedStatus the updated status
     */

    public void resolveEnquiry(final String customerEnquiryId, final String resolveComment, final String updatedStatus) {
        BasicDBObject where = new BasicDBObject();
        where.put("enquiry_id", customerEnquiryId);
        getCollection().updateOne(where, Updates.set("enquiry_status", updatedStatus));
        getCollection().updateOne(where, Updates.set("resolve_comment", resolveComment));
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
    }


}
