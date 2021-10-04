package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.dao.DBCustomerEnquiryManager;
import group2.asd.uts.edu.au.opal.model.*;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestDBCustomerEnquiryManagerClass {

    private final DBCustomerEnquiryManager customerEnquiryManager;
    private final UUID customerEnquiryId = UUID.randomUUID();
    private final CustomerEnquiry expectedEnquiry = new CustomerEnquiry(customerEnquiryId,
            "Test Enquiry Title",
            "Test Enquiry Details",
            "04/10/2021",
            "Submitted");
    private CustomerEnquiry actualCustomerEnquiry;

    public TestDBCustomerEnquiryManagerClass() {
        customerEnquiryManager = new DBCustomerEnquiryManager();
    }

    @Test
    public void testCreateCustomerEnquiry() {
        customerEnquiryManager.createCustomerEnquiry(customerEnquiryId,
                "Test Enquiry Title",
                "Test Enquiry Details",
                "04/10/2021",
                "Submitted");
        assertEquals(actualCustomerEnquiry, expectedEnquiry);
        actualCustomerEnquiry = null;
    }

    //to do

}