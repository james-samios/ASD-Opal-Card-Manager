package group2.asd.uts.edu.au.opal.api;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import group2.asd.uts.edu.au.opal.dao.CollectionType;
import group2.asd.uts.edu.au.opal.model.Customer;
import group2.asd.uts.edu.au.opal.model.PaymentHistory;
import org.bson.Document;
import org.bson.types.ObjectId;

public class API {

    private final MongoClientSettings settings;

    /**
     * Main constructor for the API.
     * Creates a settings object for the Mongo Client.
     * The database is not loaded here. It is opened and closed after each request.
     * @author James
     */
    public API() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://opal:OPALCARDMANAGER@asd.axojh.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        System.out.println("MongoDB setup and ready for queries.");
    }

    public MongoClientSettings getSettings() {
        return this.settings;
    }

    /**
     * Gets a collection of documents from the Mongo Database.
     * @param client The active client
     * @param type The collection type, specified as an enum.
     * @return The collection of BSON Documents.
     * @author James
     */
    public MongoCollection<Document> getCollection(final MongoClient client, final CollectionType type) {
        return client.getDatabase("dev").getCollection(type.name().toLowerCase());
    }

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
        BasicDBObject where = new BasicDBObject();
        where.put("email_address", email);
        where.put("password", password);

        try (MongoClient mongoClient = MongoClients.create(settings)) {
            Document doc;
            doc = getCollection(mongoClient, CollectionType.ACCOUNTS).find(where).first();
            System.out.println("Customer " + doc);
            if (doc == null || doc.isEmpty()) return null;
            return new Customer(doc);
        }
    }

    /**
     * Returns a payment history with provided account ID.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     * @param accountId The customer's account ID
     * @return PaymentHistory
     * @author Jung
     */
    public PaymentHistory getPaymentHistory(final String accountId) {
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            BasicDBObject where = new BasicDBObject();
            Document doc;
            where.put("account_id", Double.parseDouble(accountId));
            doc = getCollection(mongoClient, CollectionType.PAYMENT_HISTORY).find(where).first();
            //System.out.println("PaymentHistory " + doc);
            //Retrieving the documents
            if (doc == null || doc.isEmpty()) {
                throw new Exception();
            }
            return new PaymentHistory(doc);
        }catch(Exception e) {
            return null;
        }
    }

    /**
     * Registers a new Customer object into the API.
     * @param customer The customer to register.
     * @param password The customer's chosen password, as a md5 hash.
     */
    public void registerCustomer(final Customer customer, final String password) {
        Document user = new Document("_id", new ObjectId());
        user.append("account_id", customer.getAccountId())
                .append("first_name", customer.getFirstName())
                .append("last_name", customer.getLastName())
                .append("email_address", customer.getEmailAddress())
                .append("phone_number", customer.getPhoneNumber())
                .append("password", password);

        try (MongoClient mongoClient = MongoClients.create(settings)) {
            getCollection(mongoClient, CollectionType.ACCOUNTS).insertOne(user);
        }
    }



}
