package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Customer {

    private ObjectId objectId;
    private final UUID accountId;
    private final String emailAddress;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final Address address;
    private WeeklyTripReward weeklyTripReward;
    private List<Card> linkedCards;

    /**
     * Loads a Customer object from the API.
     * @param document The BSON document from the users collection.
     * @author James
     */
    public Customer(final Document document) {
        this.objectId = new ObjectId(document.get("_id").toString());
        this.accountId = UUID.fromString(document.getString("account_id"));
        this.firstName = document.getString("first_name");
        this.lastName = document.getString("last_name");
        this.emailAddress = document.getString("email_address");
        this.password = document.getString("password");
        this.phoneNumber = document.getString("phone_number");
        this.address = new Address(document.get("address", Document.class));
        this.weeklyTripReward = new WeeklyTripReward(document.get("weekly_trip_reward", Document.class));
        this.linkedCards = new ArrayList<>();
    }

    /**
     * Creates a new Customer object. Mainly used when registering a new user.
     * @param firstName The customer's first name.
     * @param lastName The customer's last name.
     * @param emailAddress The customer's email address, which will be used as their username.
     * @param phoneNumber The customer's mobile/landline number.
     * @param password The customer's chosen password, to be encrypted as a md5 hash.
     * @param address The customer's address, as an Address object.
     * @author James
     */
    public Customer(final String firstName, final String lastName, final String emailAddress, final String password,
                    final String phoneNumber, final Address address) {
        this.accountId = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "" +
                getObjectId() + " - " +
                getAccountId() + " - " +
                getFirstName() + " - " +
                getLastName() + " - " +
                getEmailAddress() + " - " +
                getPassword() + " - " +
                getPhoneNumber() + " - " +
                getAddress() + " - " +
                getWeeklyTripReward();
    }
}
