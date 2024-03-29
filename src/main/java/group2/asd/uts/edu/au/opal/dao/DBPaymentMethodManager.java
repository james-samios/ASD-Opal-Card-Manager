package group2.asd.uts.edu.au.opal.dao;


import com.mongodb.BasicDBObject;
import group2.asd.uts.edu.au.opal.model.PaymentMethod;
import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DBPaymentMethodManager is used for access of PaymentMethod table on mongoDB
 *
 * */
@Getter
public class DBPaymentMethodManager extends DBManager{
    public DBPaymentMethodManager() {
        super(CollectionType.PAYMENT_METHODS);
    }
    /*
    private final MongoCollection<Document> collection;
    public DBPaymentMethodManager(MongoDatabase db) {
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
     * @param paymentMethod The payment method to register.
     **/

    public void createPaymentMethod(final PaymentMethod paymentMethod) {
        refresh();
        try {
            getCollection().insertOne(paymentMethod.convertClassToDocument());
        } catch (Exception e) {
            Logger.getLogger(DBPaymentMethodManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /*   *************************************Methods for "R" section below****************************************   */

    /**
     * Returns a payment with provided objectId.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     * @param objectId The credit card's _id
     * @return PaymentMethod
     * @author Jung
     */

    public PaymentMethod readPaymentByObjectId(final ObjectId objectId) {
        refresh();
        try {
            Document document;
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            document = getCollection().find(where).first();
            //Retrieving the documents
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new PaymentMethod(document);
        }catch(Exception e) {
            Logger.getLogger(DBPaymentMethodManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    /**
     * Returns a payment with provided payment details' ID.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     * @param paymentMethodId The credit card's number
     * @return PaymentMethod
     * @author Jung
     */

    public PaymentMethod readPaymentMethodByPaymentMethodId(final String paymentMethodId) {
        refresh();
        try {
            Document document;
            BasicDBObject where = new BasicDBObject();
            where.put("payment_method_id", paymentMethodId);
            document = getCollection().find(where).first();
            //Retrieving the documents
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new PaymentMethod(document);
        }catch(Exception e) {
            Logger.getLogger(DBPaymentMethodManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }


    /**
     * Returns a payment with provided card number and CVC.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     * @param cardNumber The credit card's number
     * @param cardCVC The card CVS.
     * @return PaymentMethod
     * @author Jung
     */

    public PaymentMethod readPaymentMethodByNumberAndCVC(final String cardNumber, final String cardCVC) {
        refresh();
        try {
            Document document;
            BasicDBObject where = new BasicDBObject();
            where.put("card_number", cardNumber);
            where.put("cvc", cardCVC);
            document = getCollection().find(where).first();
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new PaymentMethod(document);
        }catch(Exception e) {
            Logger.getLogger(DBPaymentMethodManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    /**
     * read all payment methods form the payment method table
     * No return
     * @author Jung
     */
    public void readAllPaymentMethods() {
        refresh();
        try {
            int counter = 1;
            for (Document document : getCollection().find()) {
                System.out.println("" + counter + ": " + document);
                counter = counter + 1;
            }
        }catch(Exception e) {
            Logger.getLogger(DBPaymentMethodManager.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /*   *************************************Methods for "U" section below****************************************   */

    /**
     * If a payment method is found with provided object ID, it will update the payment method's owner name
     * No return
     * @param paymentMethod A payment method
     * @author Jung
     **/

    public void updatePaymentMethod(PaymentMethod paymentMethod) {
        refresh();
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", paymentMethod.getObjectId());
            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("payment_method_id", paymentMethod.getPaymentMethodId().toString());
            newDocument.put("opal_card_id", paymentMethod.getOpalCardId().toString());
            newDocument.put("card_number", paymentMethod.getCardNumber());
            newDocument.put("card_name", paymentMethod.getCardName());
            newDocument.put("cvc", paymentMethod.getCardCVC());
            newDocument.put("expiry_date", paymentMethod.getExpiryDate());
            BasicDBObject updateObject = new BasicDBObject();
            updateObject.put("$set", newDocument);
            getCollection().updateOne(where, updateObject);
        }catch(Exception e) {
            System.out.println("Error: Update error happens. Check the code");
        }
    }

    /*   *************************************Methods for "D" section below****************************************   */

    /**
     * If a payment method is found with provided payment_details_id, it will delete it
     * No return
     * @param paymentMethodId The credit card's payment_details_id
     * @author Jung
     */

    public void deletePaymentByPaymentMethodId(final String paymentMethodId) {
        refresh();
        try {
            //deleting an object from table
            BasicDBObject where = new BasicDBObject();
            where.put("payment_method_id", paymentMethodId);
            getCollection().deleteMany(where);
        }catch(Exception e) {
            System.out.println("Error: Delete error happens. Check the code");
        }
    }

    /**
     * If a payment method is found with provided objectId, it will delete it
     * No return
     * @param objectId The credit card's objectId
     * @author Jung
     */

    public void deletePaymentByObjectId(final ObjectId objectId) {
        refresh();
        try {
            //deleting an object from table
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            getCollection().deleteOne(where);
        }catch(Exception e) {
            Logger.getLogger(DBPaymentMethodManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
