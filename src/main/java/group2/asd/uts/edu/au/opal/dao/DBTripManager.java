package group2.asd.uts.edu.au.opal.dao;


import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import group2.asd.uts.edu.au.opal.model.Trip;
import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.eq;

/**
 * DBTripManager is used for access of Trip table on mongoDB
 */
@Getter
public class DBTripManager extends DBManager {
    public DBTripManager() {
        super(CollectionType.TRIPS);
    }
    /*
    private final MongoCollection<Document> collection;
    public DBTripManager(MongoDatabase db) {
        collection = db.getCollection(CollectionType.PAYMENT_METHODS.toString().toLowerCase());
    }*/


    /*
     * Add methods for accessing CRUD on Table
     * "C" means creating a new object into table
     * "R" means reading objects from table
     * "U" means updating table's objects
     * "D" means deleting table's objects
     */

    /*   *************************************Methods for "C" section below****************************************   */

    /**
     * Registers a new object of payment method into the API.
     *
     * @param paymentMethod The payment method to register.
     **/

    public void createTrip(final Trip paymentMethod) {
        // refresh();
        try {
            getCollection().insertOne(paymentMethod.convertClassToDocument());
        } catch (Exception e) {
            Logger.getLogger(DBTripManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /*   *************************************Methods for "R" section below****************************************   */

    /**
     * Returns a payment with provided objectId.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     *
     * @param objectId The credit card's _id
     * @return Trip
     * @author Jung
     */

    public Trip readPaymentByObjectId(final ObjectId objectId) {
        // refresh();
        try {
            Document document;
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            document = (Document) getCollection().find(where).first();
            //Retrieving the documents
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new Trip(document);
        } catch (Exception e) {
            Logger.getLogger(DBTripManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public Trip readTripByTripId(final String tripId) {
        // refresh();
        try {
            Document document;
            BasicDBObject where = new BasicDBObject();
            where.put("_id", tripId);
            document = (Document) getCollection().find(eq("_id", new ObjectId(tripId))).first();
            //Retrieving the documents
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new Trip(document);
        } catch (Exception e) {
            Logger.getLogger(DBTripManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }


    /**
     * read all payment methods form the payment method table
     * No return
     *
     * @author Jung
     */
    public void readAllTrips() {
        // refresh();
        try {
            int counter = 1;
            for (Document document : getCollection().find()) {
                System.out.println("" + counter + ": " + document);
                counter = counter + 1;
            }
        } catch (Exception e) {
            Logger.getLogger(DBTripManager.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public List<Trip> readTrips() {
        // refresh();
        try {
            BasicDBObject where = new BasicDBObject();
            FindIterable<Document> docs = getCollection().find();
            //Retrieving the documents
            if (docs == null) {
                throw new Exception("Error: The document is null or empty.");
            }

            List<Trip> paymentMethods = new ArrayList<>();
            for (Document document : docs) {
                paymentMethods.add(new Trip(document));
            }
            return paymentMethods;
        } catch (Exception e) {
            Logger.getLogger(DBTripManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }


    public void deleteTripByID(final String id) {
        // refresh();
        try {
            //deleting an object from table
            getCollection().deleteOne(new Document("_id", new ObjectId(id)));
        } catch (Exception e) {
            System.out.println("Error: Delete error happens. Check the code");
        }
    }


}
