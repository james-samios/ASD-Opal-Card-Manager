package group2.asd.uts.edu.au.opal;

import group2.asd.uts.edu.au.opal.dao.DBPaymentMethodManager;
import group2.asd.uts.edu.au.opal.object.PaymentMethod;
import org.bson.types.ObjectId;


/**
 * UTS Advanced Software Development - Assignment
 * Opal Card Management System
 * Created by: James Samios, Jack Shakespeare, Christopher Cruz, Nadeem Ahmed, Qiyang Wu and Tzu-Jung Yeh
 */

public class Main {
    public static void main(String[] args) {
        DBPaymentMethodManager dbPaymentMethodManager = new DBPaymentMethodManager();
        System.out.println("Before: Display All methods");
        //dbPaymentMethodManager.getAllPaymentMethods();
        //PaymentMethod paymentMethod = new PaymentMethod("1111222233334444", "Tzu Jung",  "333", "10/22");

        //dbPaymentMethodManager.createPaymentMethod(paymentMethod);
        ObjectId objectId = new ObjectId("612ed59a56cb54f515475557");
        PaymentMethod getPaymentMethod = dbPaymentMethodManager.getPaymentByObjectId(objectId);
        System.out.println("PaymentMethod: " + getPaymentMethod);
        //dbPaymentMethodManager.deletePaymentByPaymentMethodId("529361c5-9aa7-4609-a76c-ea452894f869");

        System.out.println("After: Display All methods");
        dbPaymentMethodManager.getAllPaymentMethods();

    }
}
