package group2.asd.uts.edu.au.opal.object;

import group2.asd.uts.edu.au.opal.Main;
import lombok.Getter;
import org.bson.Document;

import java.util.ArrayList;
import java.util.UUID;

@Getter
public class Customer extends Document {

    private final UUID accountId;

    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String phoneNumber;
    private final String password;
    private ArrayList<Card> opalCards;

    /**
     * Loads a Customer object from the API.
     * @param document The BSON document from the users collection.
     * @author James
     */
    public Customer(final Document document) {
        this.accountId = UUID.fromString(document.getString("account_id"));
        this.firstName = document.getString("first_name");
        this.lastName = document.getString("last_name");
        this.emailAddress = document.getString("email_address");
        this.password = document.getString("password");
        this.phoneNumber = document.getString("phone_number");
    }

    /**
     * Creates a new Customer object. Mainly used when registering a new user.
     * @param firstName The customer's first name.
     * @param lastName The customer's last name.
     * @param emailAddress The customer's email address, which will be used as their username.
     * @param phoneNumber The customer's mobile/landline number.
     * @param password The customer's chosen password, to be encrypted as a md5 hash.
     * @author James
     */

    public Customer(final String firstName, final String lastName, final String emailAddress, final String password, final String phoneNumber) {
        this.accountId = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    /**
     * Registers a new customer into the API.
     * @author James
     */

    /*private void register(final String password) { // TODO: Hash password
        Main.getApi().registerCustomer(this, password);
    }*/



    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " - " + getEmailAddress() + " - " + getPassword() + " - " + getPhoneNumber();
    }

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        return super.getOrDefault(key, defaultValue);
    }
}
