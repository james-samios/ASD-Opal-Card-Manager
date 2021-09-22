package group2.asd.uts.edu.au.opal.test;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import group2.asd.uts.edu.au.opal.dao.CollectionType;
import group2.asd.uts.edu.au.opal.dao.DB;
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
        //DB db = new DB();
        //MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(new ConnectionString(db.getUrl())).build();
        //DBCardsManager dbCardsManager = new DBCardsManager(MongoClients.create(settings).getDatabase(db.getDatabaseName()));
        //DBPaymentMethodManager dbPaymentMethodManager = new DBPaymentMethodManager(MongoClients.create(settings).getDatabase(db.getDatabaseName()));



        UUID uuid1 = new UUID(0, 0);
        UUID uuid2 = UUID.fromString("00000000-0000-0000-0000-000000000000");
        System.out.println(uuid1.compareTo(uuid2));
        if(uuid1.compareTo(uuid2) > -1) {
            System.out.println("same");
        }else {
            System.out.println("different");
        }
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
