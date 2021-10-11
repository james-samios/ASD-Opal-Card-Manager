package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.model.Address;
import group2.asd.uts.edu.au.opal.model.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCustomerClass {

    private final String firstName = "Barry";
    private final String lastName = "Johnson";
    private final String email = "barry.johnson@uts.com";
    private final String phone = "0412222345";
    private final String password = "Barry123!";
    private final Address address = new Address("Apartment 1A", "123 Sydney Street", "Sydney", 2000, "NSW");

    private final Customer expectedCustomer = new Customer(firstName, lastName, email, phone, password, address);

    @Test
    public void testGetCustomerFirstName() {
        assertEquals(firstName, expectedCustomer.getFirstName());
    }

    @Test
    public void testGetCustomerLastName() {
        assertEquals(lastName, expectedCustomer.getLastName());
    }

    @Test
    public void testCustomerGetEmail() {
        assertEquals(email, expectedCustomer.getEmailAddress());
    }

    @Test
    public void testCustomerAddress() {
        assertEquals(address, expectedCustomer.getAddress());
    }

}
