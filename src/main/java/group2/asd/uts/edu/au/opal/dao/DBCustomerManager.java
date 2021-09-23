package group2.asd.uts.edu.au.opal.dao;

import com.mongodb.BasicDBObject;
import group2.asd.uts.edu.au.opal.model.Customer;
import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

@Getter
public class DBCustomerManager extends DBManager {

    public DBCustomerManager() {
        super(CollectionType.ACCOUNTS);
    }

    /*   *************************************Methods for "C" section below****************************************   */

    /**
     * Registers a new Customer object into the API.
     * @param customer The customer to register.
     * @param password The customer's chosen password, as a md5 hash.
     */
    public void registerCustomer(final Customer customer, final String password) {
        refresh();
        Document user = new Document("_id", new ObjectId());
        user.append("account_id", customer.getAccountId())
                .append("first_name", customer.getFirstName())
                .append("last_name", customer.getLastName())
                .append("email_address", customer.getEmailAddress())
                .append("phone_number", customer.getPhoneNumber())
                .append("password", password);

        getCollection().insertOne(user);
    }

    /*   *************************************Methods for "R" section below****************************************   */

    /**
     * Returns a Customer with provided email and password.
     * If the provided email / password combo is not found, it will return
     * null, implying incorrect details were supplied.
     * @param email The customer's email address
     * @param password The customer's password, in md5 hash form.
     * @return Customer Account
     * @author James
     */
    public Customer getCustomer(final String email, final String password) {
        refresh();
        BasicDBObject where = new BasicDBObject();
        where.put("email_address", email);
        where.put("password", password);
        Document doc = getCollection().find(where).first();
        if (doc == null || doc.isEmpty()) return null;
        return new Customer(doc);
    }

    /*   *************************************Methods for "U" section below****************************************   */
    /*   *************************************Methods for "D" section below****************************************   */
}