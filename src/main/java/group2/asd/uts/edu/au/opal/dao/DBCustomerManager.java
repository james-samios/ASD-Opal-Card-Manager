package group2.asd.uts.edu.au.opal.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Updates;
import group2.asd.uts.edu.au.opal.model.Address;
import group2.asd.uts.edu.au.opal.model.Customer;
import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;

@Getter
public class DBCustomerManager extends DBManager {

    public DBCustomerManager() {
        super(CollectionType.ACCOUNTS);
    }

    /*   *************************************Methods for "C" section below****************************************   */

    /**
     * Registers a new Customer object into the API.
     * @param customer The customer to register.
     * @param password The customer's chosen password, as plaintext, converted as it's put in the document.
     * @author James
     */
    public void registerCustomer(final Customer customer, final String password) {
        refresh();

        Address a = customer.getAddress();

        Document address = new Document();

        address.append(
                        "address_line_1", a.getAddressLine1())
                .append("address_line_2", a.getAddressLine2())
                .append("suburb", a.getSuburb())
                .append("post_code", a.getPostCode())
                .append("state", a.getState()
                );

        Document weeklyReward = new Document();

        weeklyReward.append(
                        "reward_percentage", 0.0)
                .append("reward_name", "null")
                .append("reward_claimed", false
                );

        Document user = new Document("_id", new ObjectId());
        user.append("account_id", customer.getAccountId().toString())
                .append("first_name", customer.getFirstName())
                .append("last_name", customer.getLastName())
                .append("email_address", customer.getEmailAddress())
                .append("phone_number", customer.getPhoneNumber())
                .append("password", stringToMd5(password))
                .append("address", address)
                .append("weekly_trip_reward", weeklyReward);

        getCollection().insertOne(user);
        customer.setPassword(stringToMd5(password));
    }

    /**
     * Converts a plaintext password to md5 hash for storage in MongoDB.
     * @author James
     */
    public String stringToMd5(String password) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md5.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            StringBuilder hashText = new StringBuilder(no.toString(16));
            while (hashText.length() < 32) {
                hashText.insert(0, "0");
            }
            return hashText.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*   *************************************Methods for "R" section below****************************************   */

    /**
     * Returns a Customer with provided email and password.
     * If the provided email / password combo is not found, it will return
     * null, implying incorrect details were supplied.
     * @param email The customer's email address
     * @param password The customer's password, in plaintext form, changed to md5 in the query.
     * @return Customer Account
     * @author James
     */
    public Customer getCustomer(final String email, final String password) {
        refresh();
        BasicDBObject where = new BasicDBObject();
        where.put("email_address", email);
        where.put("password", stringToMd5(password));
        Document doc = getCollection().find(where).first();
        if (doc == null || doc.isEmpty()) return null;
        return new Customer(doc);
    }

    public Customer getCustomerById(final UUID uuid) {
        refresh();
        BasicDBObject where = new BasicDBObject();
        where.put("account_id", uuid.toString());
        Document doc = getCollection().find(where).first();
        if (doc == null || doc.isEmpty()) return null;
        return new Customer(doc);
    }

    /*   *************************************Methods for "U" section below****************************************   */

    /**
     * Update a Customer's password. Used in the ChangePasswordServlet.
     * @param uuid The Customer's account ID.
     * @param newPassword The new password the customer would like
     */
    public void changePassword(final UUID uuid, final String newPassword) {
        refresh();
        BasicDBObject where = new BasicDBObject();
        where.put("account_id", uuid.toString());
        getCollection().updateOne(where, Updates.set("password", stringToMd5(newPassword)));
    }

    /**
     * Updates all customer fields. Used in the EditProfileServlet.
     * @param customer The Customer object.
     */
    public void updateCustomer(final Customer customer) {
        // Customer Account
        updateField(customer.getAccountId(), AccountField.FIRST_NAME, customer.getFirstName());
        updateField(customer.getAccountId(), AccountField.LAST_NAME, customer.getLastName());
        updateField(customer.getAccountId(), AccountField.EMAIL_ADDRESS, customer.getEmailAddress());
        updateField(customer.getAccountId(), AccountField.PHONE_NUMBER, customer.getPhoneNumber());

        // Customer Address
        Address address = customer.getAddress();
        updateAddressField(customer.getAccountId(), AddressField.ADDRESS_LINE_1, address.getAddressLine1());
        updateAddressField(customer.getAccountId(), AddressField.ADDRESS_LINE_2, address.getAddressLine2());
        updateAddressField(customer.getAccountId(), AddressField.SUBURB, address.getSuburb());
        updateAddressField(customer.getAccountId(), AddressField.POSTCODE, address.getPostCode());
        updateAddressField(customer.getAccountId(), AddressField.STATE, address.getState());
    }

    /**
     * Update a customer field. Such as first or last name, email address, phone number, etc.
     * @param uuid The Customer's account ID.
     * @param field The field to be updated.
     * @param update The updated field contents.
     */
    private void updateField(final UUID uuid, final AccountField field, final String update) {
        refresh();
        BasicDBObject where = new BasicDBObject();
        where.put("account_id", uuid.toString());
        getCollection().updateOne(where, Updates.set(field.name().toLowerCase(), update));
    }

    /**
     * Update a customer's address field.
     * @param uuid The Customer's account ID.
     * @param field The field to be updated.
     * @param update The updated field contents.
     */
    public void updateAddressField(final UUID uuid, final AddressField field, final Object update) {
        refresh();
        BasicDBObject where = new BasicDBObject();
        where.put("account_id", uuid.toString());
        getCollection().updateOne(where, Updates.set("address." + field.name().toLowerCase(), update));
    }

    /**
     * The available fields in a customer account that can be updated.
     */
    public enum AccountField {
        FIRST_NAME,
        LAST_NAME,
        EMAIL_ADDRESS,
        PHONE_NUMBER;
    }

    /**
     * The available fields in a customer's address that can be updated.
     */
    public enum AddressField {
        ADDRESS_LINE_1,
        ADDRESS_LINE_2,
        SUBURB,
        POSTCODE,
        STATE;
    }

    /*   *************************************Methods for "D" section below****************************************   */

    /**
     * Deletes a Customer's account by removing the document from the MongoDB collection.
     * It also unlinks all active cards.
     * @param uuid The Customer's account ID.
     */
    public void deleteAccount(final UUID uuid) {
        refresh();
        BasicDBObject where = new BasicDBObject();
        where.put("account_id", uuid.toString());
        getCollection().deleteOne(where);
        new DBCardsManager().unLinkCardByGivenAccountId(uuid.toString());
    }
}