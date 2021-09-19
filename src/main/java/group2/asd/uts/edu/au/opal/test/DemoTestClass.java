package group2.asd.uts.edu.au.opal.test;


import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.dao.DBPaymentMethodManager;
import group2.asd.uts.edu.au.opal.model.*;
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
        //testCardModel();
        //testPaymentMethodModel();
        //testTopUpModel();
        //testTripModel();

        /*Test of DAO*/
        DBCardsManager dbCardsManager = new DBCardsManager();
        dbCardsManager.readAllCards();
        dbCardsManager.updateCardPin(new ObjectId("61473d1760f9601b1b82d2f5"), "9999");
        dbCardsManager.updateCardNumber(new ObjectId("61473d1760f9601b1b82d2f5"), "3085220000000000");
        //DBPaymentMethodManager dbpaymentMethodManager = new DBPaymentMethodManager();
        //dbpaymentMethodManager.readAllPaymentMethods();
        /*
        final PaymentMethod paymentMethod = new PaymentMethod(
                "adc8a0e8-eda8-4ac1-989c-c82407d008e1",
                "8c7eda3f-ab45-4c82-9ba8-a462043f1dde",
                "1111222211112222",
                "Tzu Jung",
                "111",
                "12/22"
        );
        final ObjectId objectId = new ObjectId("6147405173eeae77825d8320");
        paymentMethod.setObjectId(objectId);
        dbpaymentMethodManager.updatePaymentMethodByProvidedObjectId(paymentMethod);
        dbpaymentMethodManager.readAllPaymentMethods();

         */
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
