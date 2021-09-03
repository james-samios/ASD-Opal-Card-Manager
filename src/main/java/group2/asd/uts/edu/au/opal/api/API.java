package group2.asd.uts.edu.au.opal.api;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import group2.asd.uts.edu.au.opal.object.Customer;
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

    /**
     * Gets a collection of documents from the Mongo Database.
     * @param client The active client
     * @param type The collection type, specified as an enum.
     * @return The collection of BSON Documents.
     * @author James
     */
    private MongoCollection<Document> getCollection(final MongoClient client, final CollectionType type) {
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
        Document doc;
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            doc = getCollection(mongoClient, CollectionType.ACCOUNTS).find(where).first();
            if (doc == null || doc.isEmpty()) return null;
            return new Customer(doc);
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
