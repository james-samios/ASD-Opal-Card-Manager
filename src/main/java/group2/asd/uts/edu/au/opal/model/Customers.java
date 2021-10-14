<<<<<<< Updated upstream
package group2.asd.uts.edu.au.opal.model;


import lombok.Getter;
import org.bson.Document;

import java.util.ArrayList;
import java.util.UUID;

@Getter
public class Customers {

    private final UUID accountId;

    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String phoneNumber;

    private ArrayList<Card> opalCards;

    /**
     * Loads a Customer object from the API.
     * @param document The BSON document from the users collection.
     * @author Qiyang Wu
     */
    public Customers(final Document document) {
        this.accountId = UUID.fromString(document.getString("account_id"));
        this.firstName = document.getString("first_name");
        this.lastName = document.getString("last_name");
        this.emailAddress = document.getString("email_address");
        this.phoneNumber = document.getString("phone_number");
    }

    /**
     * Creates a new Customer object. Mainly used when registering a new user.
     * @param firstName The customer's first name.
     * @param lastName The customer's last name.
     * @param emailAddress The customer's email address, which will be used as their username.
     * @param phoneNumber The customer's mobile/landline number.
     * @param password The customer's chosen password, to be encrypted as a md5 hash.
     * @author Qiyang Wu
     */
    public Customers(final String firstName, final String lastName, final String emailAddress, final String password, final String phoneNumber) {
        this.accountId = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;

    }

    /**
     * Registers a new customer into the API.
     * @author Qiyang Wu
     */



    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " - " + getEmailAddress() + " - " + getPhoneNumber();
    }
}

=======
package group2.asd.uts.edu.au.opal.model;public class Customers {
}
>>>>>>> Stashed changes
