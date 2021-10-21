package group2.asd.uts.edu.au.opal.dao;


import com.mongodb.client.model.Filters;
import group2.asd.uts.edu.au.opal.model.Fares;
import org.bson.Document;
import org.bson.types.ObjectId;


import java.util.logging.Level;
import java.util.logging.Logger;

public class DBFaresManager extends DBManager{

    public DBFaresManager() {
        super(CollectionType.FARES);
    }

    /*
     * Add methods for accessing CRUD on Table
     * "C" means creating a new object into table
     * "R" means reading objects from table
     * "U" means updating table's objects
     * "D" means deleting table's objects
     *
     * */

    /*   *************************************Methods for "C" section below****************************************   */
    public void createFare(final Fares fare) {
        refresh();
        try {
            getCollection().insertOne(fare.convertClassToDocument());
        } catch (Exception e) {
            System.out.println("Error: Failure of running createFare");
        }
    }

    /*   *************************************Methods for "R" section below****************************************   */
    public Fares readFare() {
        refresh();
        try {
            Document document;
            document = getCollection().find().first();
            //Retrieving the documents
            System.out.println(document);

            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new Fares(document);
        } catch (Exception e) {
            System.out.println(e);
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    /*   *************************************Methods for "U" section below****************************************   */
    public void updateFaresByFares(final Fares fares) {
        refresh();
        try {
            //deleting an object from table
            deleteFaresByFares(fares);
            createFare(fares);
        }catch(Exception e) {
            System.out.println("Error: the failure of updating a fare from table");
        }


    }


    /*   *************************************Methods for "D" section below****************************************   */
    public void deleteFaresByFares(final Fares fares) {
        refresh();
        try {
            //deleting an object from table
            getCollection().deleteMany(Filters.eq("fare_id", fares.getFareId().toString()));
        }catch(Exception e) {
            System.out.println("Error: the failure of deleting Fares from table");
        }
    }

}
