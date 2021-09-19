package group2.asd.uts.edu.au.opal.dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class DBConnection {
    private final MongoClientSettings settings;

    /*Constructor is for setting up connection with database*/
    public DBConnection () {
        ConnectionString connectionString =
                new ConnectionString("mongodb+srv://opal:OPALCARDMANAGER@asd.axojh.mongodb.net/" +
                        "myFirstDatabase?retryWrites=true&w=majority");
        settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        System.out.println("MongoDB connection is set up");
    }

    /*The method is to find the table in mongoDB by providing table name*/
    public MongoCollection<Document> getTableCollection(final CollectionType type) {
        try {
            MongoClient mongoClient = MongoClients.create(settings);
            MongoCollection<Document> mongoCollection =
                    mongoClient.getDatabase("dev").getCollection(type.name().toLowerCase());
            return mongoCollection;
        }catch (Exception e) {
            return null;
        }

    }
}
