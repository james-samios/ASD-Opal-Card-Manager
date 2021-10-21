package group2.asd.uts.edu.au.opal.dao;


import com.mongodb.client.MongoCollection;
import lombok.Getter;
import org.bson.Document;

@Getter
public class DBManager {

    private MongoCollection<Document> collection;
    private final DBConnection connection;
    private final CollectionType type;

    public DBManager(final CollectionType type) {
        this.type = type;
        this.connection = DBConnection.getDB();
        this.collection = connection.getCollection(type);
    }
    public void refresh() {
        this.collection = connection.getCollection(type);
    }
}