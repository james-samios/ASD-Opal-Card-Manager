package group2.asd.uts.edu.au.opal.dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class DBConnection {

    private final MongoClientSettings settings;

    private static DBConnection connection;

    public static DBConnection getDB() {
        if (connection == null) connection = new DBConnection();
        return connection;
    }

    /**
     * Main constructor for the DBConnection.
     * Creates a settings object for the Mongo Client.
     * The database is not loaded here. It is opened and closed after each request.
     * @author James
     */
    public DBConnection () {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://opal:OPALCARDMANAGER@asd.axojh.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        System.out.println("MongoDB setup and ready for queries.");
    }

    /*The method is to find the table in mongoDB by providing table name*/
    public MongoCollection<Document> getCollection(final CollectionType type) {
        try {
            MongoClient mongoClient = MongoClients.create(settings);
            return mongoClient.getDatabase("dev").getCollection(type.name().toLowerCase());
        }catch (Exception e) {
            return null;
        }

    }


}
