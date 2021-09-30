package group2.asd.uts.edu.au.opal.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


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
