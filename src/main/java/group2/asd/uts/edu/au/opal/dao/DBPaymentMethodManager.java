package group2.asd.uts.edu.au.opal.dao;


import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import group2.asd.uts.edu.au.opal.api.CollectionType;
import group2.asd.uts.edu.au.opal.object.PaymentMethod;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.UUID;

/**
* DBPaymentMethodManager is used for access of PaymentMethod table on mongoDB
*
* */

public class DBPaymentMethodManager {
    private final MongoCollection<Document> mongoCollection;

    /**
     * Constructor for choosing a table with table name
     * */
    public DBPaymentMethodManager() {
        this.mongoCollection = new DBConnection().getTableCollection(CollectionType.PAYMENT_METHODS);
    }

    /*
     * Add methods for accessing CRUD on Table
     * "C" means creating a new object into table
     * "R" means reading objects from table
     * "U" means updating table's objects
     * "D" means deleting table's objects
     */


    /**
     * Registers a new object of payment method into the API.
     * @param paymentMethod The payment method to register.
     **/

    public void createPaymentMethod(final PaymentMethod paymentMethod) {
        try {
            mongoCollection.insertOne(paymentMethod.convertToDocument());
            System.out.println("Success: Success of running createPaymentMethod");
        } catch (Exception e) {
            System.out.println("Error: Failure of running createPaymentMethod");
        }
    }

    /* *************************************Methods for "R" section below**************************************** */

    /**
     * Returns a payment with provided objectId.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     * @param providedId The credit card's _id
     * @return PaymentMethod
     * @author Jung
     */

    public PaymentMethod getPaymentByObjectId(final ObjectId providedId) {
        try {
            Document document;
            BasicDBObject where = new BasicDBObject();

            where.put("_id", providedId);
            document = (Document) mongoCollection.find(where).first();
            //Retrieving the documents
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new PaymentMethod(document);
        }catch(Exception e) {
            System.out.println(e);
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

    public PaymentMethod getPaymentMethodByNumberAndCVC(final String cardNumber, final String cardCVC) {
        try {
            Document document;
            BasicDBObject where = new BasicDBObject();
            where.put("card_number", Double.parseDouble(cardNumber));
            where.put("cvc", Integer.parseInt(cardCVC));
            document = mongoCollection.find(where).first();
            //System.out.println("payment " + doc);
            //Retrieving the documents
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new PaymentMethod(document);
        }catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Returns a payment with provided payment details' ID.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     * @param paymentDetailsId The credit card's number
     * @return PaymentMethod
     * @author Jung
     */

    public PaymentMethod getPaymentMethodById(final String paymentDetailsId) {
        try {
            Document doc;
            BasicDBObject where = new BasicDBObject();
            where.put("payment_details_id", paymentDetailsId);
            doc = mongoCollection.find(where).first();
            System.out.println("payment " + doc);
            //Retrieving the documents
            if (doc == null || doc.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new PaymentMethod(doc);
        }catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void getAllPaymentMethods() {
        try {
            int counter = 1;
            for (Document document : mongoCollection.find()) {
                System.out.println("" + counter + ": " + document);
                counter = counter + 1;
            }
        }catch(Exception e) {
            System.out.println("Error: the failure of displaying all payment methods");
        }

    }

    /* *************************************Methods for "U" section below**************************************** */

    /**
     * If a payment method is found with provided object ID, it will update the payment method's owner name
     * No return
     * @param objectId The payment method's object_id
     * @param ownerName The payment method's owner name
     * @author Jung
     **/

    public void updatePaymentOwnerName(final ObjectId objectId, final String ownerName) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            mongoCollection.updateOne(where, Updates.set("card_name", ownerName));
            System.out.println("Success: the success of updating card's name");
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }

    /**
     * If a card is found with provided objectId, it will update the card number
     * No return
     * @param objectId The payment method's object_id
     * @param cardNumber The payment method number
     * @author Jung
     */

    public void updatePaymentCardNumber(final ObjectId objectId, final long cardNumber) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            mongoCollection.updateOne(where, Updates.set("card_number", cardNumber));
            System.out.println("Success: the success of updating card's number");
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }


    /**
     * If a card is found, it will update the account ID
     * No return
     * @param objectId The Opal card's objectId
     * @param accountId The Opal card's account_id
     * @author Jung
     */

    public void updatePaymentAccountId(final ObjectId objectId, final String accountId) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            mongoCollection.updateOne(where, Updates.set("account_id", accountId));
            System.out.println("Success: the success of updating card's name");
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }



    /* *************************************Methods for "D" section below**************************************** */

    /**
     * If a payment method is found with provided payment_details_id, it will delete it
     * No return
     * @param paymentDetailId The credit card's payment_details_id
     * @author Jung
     */

    public void deletePaymentByPaymentMethodId(final String paymentDetailId) {
        try {
            //deleting an object from table
            mongoCollection.deleteMany(Filters.eq("payment_details_id", UUID.fromString(paymentDetailId)));
            System.out.println("Success: the success of deleting an object from table");
        }catch(Exception e) {
            System.out.println("Error: the failure of deleting an object from table");
        }
    }

    /**
     * If a payment method is found with provided objectId, it will delete it
     * No return
     * @param objectId The credit card's objectId
     * @author Jung
     */


    public void deletePaymentByObjectId(final ObjectId objectId) {
        try {
            //deleting an object from table
            mongoCollection.deleteMany(Filters.eq("_id", objectId));
            //display the success of deleting an instance from table
            System.out.println("Success: the success of deleting an object from table");
        }catch(Exception e) {
            System.out.println("Error: the failure of deleting an object from table");
        }
    }

}
