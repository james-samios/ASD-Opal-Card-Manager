package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.model.CustomerEnquiry;
import group2.asd.uts.edu.au.opal.model.TopUp;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class TestCustomerEnquiryClass {

    private final UUID customerEnquiryId = UUID.fromString("5653e70d-8291-4705-8140-291442652d58");
    private String accountId = "12345";
    private String enquiryTitle = "Test Enquiry Title";
    private String enquiryDetails = "Test Enquiry Details";
    private String enquiryDate = "04/10/2021"; //requires Date type
    private String enquiryStatus = "Submitted";

    private final CustomerEnquiry expectedCustomerEnquiry = new CustomerEnquiry(customerEnquiryId, accountId,
            enquiryTitle, enquiryDetails, enquiryDate, enquiryStatus);

    @Test
    public void testGetCustomerEnquiryId() {
        assertEquals(customerEnquiryId, expectedCustomerEnquiry.getCustomerEnquiryId());
    }

    @Test
    public void testGetEnquiryTitle() {
        assertEquals(enquiryTitle, expectedCustomerEnquiry.getEnquiryTitle());
    }

    @Test
    public void testGetEnquiryDetails() {
        assertEquals(enquiryDetails, expectedCustomerEnquiry.getEnquiryDetails());
    }

    @Test
    public void testGetEnquiryDate() {
        assertEquals(enquiryDate, expectedCustomerEnquiry.getEnquiryDate());
    }

    @Test
    public void testGetEnquiryStatus() {
        assertEquals(enquiryStatus, expectedCustomerEnquiry.getEnquiryStatus());
    }

}
