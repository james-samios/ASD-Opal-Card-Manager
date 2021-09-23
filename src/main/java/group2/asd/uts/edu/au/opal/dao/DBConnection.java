package group2.asd.uts.edu.au.opal.dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import org.bson.Document;

@Getter
public class DBConnection {
    private final MongoDatabase mongoDatabase;

    private static DBConnection connection;

    /**
     * Main constructor for the DBConnection.
     * Creates a settings object for the Mongo Client.
     * The database is not loaded here. It is opened and closed after each request.
     * @author James
     */
    public DBConnection() {
        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://opal:OPALCARDMANAGER@asd.axojh.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        mongoDatabase = MongoClients.create(settings).getDatabase("dev");
        System.out.println("MongoDB setup and ready for queries.");
    }

    /**
     * Gets a collection of documents from the Mongo Database.
     * @param type The collection type, specified as an enum.
     * @return The collection of BSON Documents.
     * @author James
     */
    public MongoCollection<Document> getCollection(final CollectionType type) {
        return getDB().getMongoDatabase().getCollection(type.name().toLowerCase());
    }

    /**
     * Gets the active connection to the Mongo database. The entire project uses the same connection.
     * @return The active DBConnection for Servlet usage.
     */
    public static DBConnection getDB() {
        if (connection == null) connection = new DBConnection();
        return connection;
    }
}