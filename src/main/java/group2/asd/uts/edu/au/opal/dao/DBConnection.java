package group2.asd.uts.edu.au.opal.dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;

@Getter
public class DBConnection {
    private final MongoDatabase mongoDatabase;
    /**
     * Main constructor for the DBConnection.
     * Creates a settings object for the Mongo Client.
     * The database is not loaded here. It is opened and closed after each request.
     * @author James
     */
    public DBConnection () {
        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://opal:OPALCARDMANAGER@asd.axojh.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        mongoDatabase = MongoClients.create(settings).getDatabase("dev");
        System.out.println("MongoDB setup and ready for queries.");
    }
}
