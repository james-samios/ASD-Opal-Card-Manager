package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.UUID;

@Getter
public class Customer extends Document {

    private ObjectId objectId;
    private final UUID accountId;
    private final String emailAddress;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private ArrayList<String> opalCards;
    private Address address;
    private WeeklyTripReward weeklyTripReward;

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
        this.opalCards = (ArrayList<String>) document.getList("opal_card", String.class);
        this.address = new Address(document.get("address", Document.class));
        this.weeklyTripReward = new WeeklyTripReward(document.get("weekly_trip_reward", Document.class));
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

    public Customer(final String firstName, final String lastName, final String emailAddress, final String password,
                    final String phoneNumber) {
        this.accountId = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
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
                getOpalCards() + " - " +
                getAddress() + " - " +
                getWeeklyTripReward();
    }

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        return super.getOrDefault(key, defaultValue);
    }

}
