package group2.asd.uts.edu.au.opal.dao;


import com.mongodb.client.MongoCollection;
import lombok.Getter;
import org.bson.Document;


@Getter
public class DBManager extends DBConnection {
    private final MongoCollection<Document> collection;
    public DBManager(final CollectionType type) {
        super();
        this.collection = getMongoDatabase().getCollection(type.toString().toLowerCase());
    }
}
