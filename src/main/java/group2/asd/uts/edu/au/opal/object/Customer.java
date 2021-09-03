package group2.asd.uts.edu.au.opal.object;

import lombok.Getter;
import org.bson.Document;

import java.util.UUID;

@Getter
public class Customer {

    private final UUID accountId;

    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String phoneNumber;

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
        this.phoneNumber = document.getString("phone_number");
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " - " + getEmailAddress() + " - " + getPhoneNumber();
    }
}
