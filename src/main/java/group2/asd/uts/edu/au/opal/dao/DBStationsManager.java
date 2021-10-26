package group2.asd.uts.edu.au.opal.dao;


import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import group2.asd.uts.edu.au.opal.model.Station;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBStationsManager extends DBManager {

    public DBStationsManager() {
        super(CollectionType.STATIONS);
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
    public void createStation(final Station station) {
        try {
            getCollection().insertOne(station.convertClassToDocument());
        } catch (Exception e) {
            System.out.println("Error: Failure of running createStation");
        }
    }

    /*   *************************************Methods for "R" section below****************************************   */
    public Station readStation() {
//        // refresh();
        try {
            Document document = (Document) getCollection().find().first();
            //Retrieving the documents
            System.out.println(document);

            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new Station(document);
        } catch (Exception e) {
            System.out.println(e);
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public Station findStation(String id) {
        FindIterable<Document> docs = getCollection().find();
        for (Document doc : docs) {
            if (doc.get("_id").toString().equals(id)) {
                return new Station(doc);
            }

        }
        return null;
    }

    public List<Station> allStations() {
        List<Station> stations = new ArrayList<>();
        FindIterable<Document> docs = getCollection().find();
        for (Document doc : docs) {
            stations.add(new Station(doc));
        }

        return stations;
    }

    /*   *************************************Methods for "U" section below****************************************   */
    public void updateStationByStation(final Station station) {
        // refresh();
        try {
            //deleting an object from table
            deleteStationByStation(station);
            createStation(station);
        } catch (Exception e) {
            System.out.println("Error: the failure of updating a fare from table");
        }


    }


    /*   *************************************Methods for "D" section below****************************************   */
    public void deleteStationByStation(final Station station) {
        // refresh();
        try {
            //deleting an object from table
            getCollection().deleteMany(Filters.eq("station_id", station.get("id").toString()));
        } catch (Exception e) {
            System.out.println("Error: the failure of deleting Station from table");
        }
    }

}
