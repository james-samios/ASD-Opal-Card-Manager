package group2.asd.uts.edu.au.opal.test;


import com.mongodb.ConnectionString;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import group2.asd.uts.edu.au.opal.dao.CollectionType;
import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.dao.DBPaymentMethodManager;
import group2.asd.uts.edu.au.opal.model.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

/**
 * UTS Advanced Software Development - Assignment
 * Opal Card Management System
 * Created by: James Samios, Jack Shakespeare, Christopher Cruz, Nadeem Ahmed, Qiyang Wu and Tzu-Jung Yeh
 */


public class DemoTestClass {
    public static void main(String[] args) {

        /*Test of models*/
        /*
        DBPaymentMethodManager dbPaymentMethodManager = new DBPaymentMethodManager();
        dbPaymentMethodManager.readAllPaymentMethods();
        */
        /*
        DBCardsManager dbCardsManager = new DBCardsManager(MongoClients.create(new ConnectionString(
                "mongodb+srv://opal:OPALCARDMANAGER@asd.axojh.mongodb.net/myFirstDatabase?retryWrites=true&w=majority"))
                .getDatabase("dev"));
        */
        MongoDatabase mongoDatabase = MongoClients.create(new ConnectionString(
                        "mongodb+srv://opal:OPALCARDMANAGER@asd.axojh.mongodb.net/myFirstDatabase?retryWrites=true&w=majority"))
                .getDatabase("dev");
        ListCollectionsIterable<Document> collections;
        collections =  mongoDatabase.listCollections();

        //dbCardsManager.readAllCards();


        /*
        Trip trip = new Trip("Padstow", "Central", Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(trip);
        Card newCard = new Card(new ObjectId(),
                UUID.randomUUID(),
                "3085220000000000",
                "9999",
                CardType.CONCESSION,
                100.0,
                UUID.randomUUID(),
                false,
                false,
                new TopUp(UUID.randomUUID(), true, 10.0, 5.0 ),
                trips);
        dbCardsManager.createOpalCard(newCard);
        dbCardsManager.readAllCards();

         */
        /*
        Document{{_id=612ed0e456cb54f515475554,
                card_id=8c7eda3f-ab45-4c82-9ba8-a462043f1dde,
                card_number="3085220000000000",
                card_pin="9999",
                "type"=CONCESSION,
                balance=131.5,
                linked_to_account=true,
                active=true,
                locked=false,
                top_up=Document{{enabled=true, amount=10.0, when=5.0, payment_details_id=5653e70d-8291-4705-8140-291442652d58}},
            trips=[Document{{trip_start=Kings Cross,
                    trip_end=Bondi Junction,
                    start_time=Wed Jan 01 00:00:00 AEDT 2020,
                    end_time=Wed Jan 01 00:00:00 AEDT 2020}}]}}

         */

        /*
        testCardModel();
        testPaymentMethodModel();
        testTopUpModel();
        testTripModel();
        */

        /*Test of DAO*/

    }

    /*Methods for testing class*/
    private static void testCardModel() {
        System.out.println("Test the card model...");
        Result result = JUnitCore.runClasses(TestCardClass.class);
        for(Failure failure: result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Test Result == " +
                (result.wasSuccessful()?
                        "Test of the model of card is successful":
                        "Test of the model of card is fail"
                ));
    }

    private static void testPaymentMethodModel() {
        System.out.println("Test the paymentMethod model...");
        Result result = JUnitCore.runClasses(TestPaymentMethodClass.class);
        for(Failure failure: result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Test Result == " +
                (result.wasSuccessful()?
                        "Test of the model of PaymentMethod is successful":
                        "Test of the model of PaymentMethod is fail"
                ));

    }

    private static void testTopUpModel() {
        System.out.println("Test the TopUp model...");
        Result result = JUnitCore.runClasses(TestTopUpClass.class);
        for(Failure failure: result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Test Result == " +
                (result.wasSuccessful()?
                        "Test of the model of TopUp is successful":
                        "Test of the model of TopUp is fail"
                ));

    }

    private static void testTripModel() {
        System.out.println("Test the Trip model...");
        Result result = JUnitCore.runClasses(TestTripClass.class);
        for(Failure failure: result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Test Result == " +
                (result.wasSuccessful()?
                        "Test of the model of Trip is successful":
                        "Test of the model of Trip is fail"
                ));

    }
}
