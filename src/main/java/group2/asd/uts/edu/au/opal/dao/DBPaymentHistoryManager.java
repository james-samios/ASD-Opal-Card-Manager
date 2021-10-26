package group2.asd.uts.edu.au.opal.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import group2.asd.uts.edu.au.opal.model.PaymentHistory;
import org.bson.Document;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBPaymentHistoryManager extends DBManager {
    public DBPaymentHistoryManager() {
        super(CollectionType.PAYMENTS_HISTORY);
    }

    /*
     * Add methods for accessing CRUD on Table
     * "C" means creating a new object into table
     * "R" means reading objects from table
     * "U" means updating table's objects
     * "D" means deleting table's objects
     */

    /*   *************************************Methods for "C" section below****************************************   */
    public void createPaymentHistory(final PaymentHistory paymentHistory) {
        // refresh();
        try {
            getCollection().insertOne(paymentHistory.convertClassToDocument());

        } catch (Exception e) {
            System.out.println("Error: Failure of running createPaymentHistory");
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    /*   *************************************Methods for "R" section below****************************************   */
    public ArrayList<PaymentHistory> readAllPaymentHistoryByProvidedCardId(final UUID cardId) {
        // refresh();
        ArrayList<PaymentHistory> paymentHistories = new ArrayList<>();
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("card_id", cardId.toString());

            for(Object document: getCollection().find(where)) {
                paymentHistories.add(new PaymentHistory((Document) document));
            }
            return paymentHistories;
        }catch (Exception e) {
            System.out.println("Error: Failure of running readPaymentHistoryByCardId");
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);
            return paymentHistories;
        }




    }

    public ArrayList<PaymentHistory> readAllPaymentHistoryByProvidedPaymentMethodId(final UUID paymentId) {
        // refresh();
        ArrayList<PaymentHistory> paymentHistories = new ArrayList<>();
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("payment_id", paymentId.toString());
            for (Object document : getCollection().find(where)) {
                paymentHistories.add(new PaymentHistory((Document) document));
            }
            return paymentHistories;
        }catch (Exception e) {
            System.out.println("Error: Failure of running readPaymentHistoryByPaymentMethodId");
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);
            return paymentHistories;
        }
    }

    public PaymentHistory readAPaymentHistoryByProvidedPaymentMethodId(final UUID paymentId) {
        // refresh();
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("payment_id", paymentId.toString());
            Document document = (Document) getCollection().find(where).first();
            return new PaymentHistory(document);
        }catch (Exception e) {
            System.out.println("Error: Failure of running readPaymentHistoryByPaymentMethodId");
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    /*   *************************************Methods for "U" section below****************************************   */

    /*   *************************************Methods for "D" section below****************************************   */
    public void deletePaymentHistoryByProvidedPaymentId(final UUID paymentMethodId) {
        // refresh();
        try {
            //deleting an object from table
            getCollection().deleteMany(Filters.eq("payment_id", paymentMethodId.toString()));
        }catch(Exception e) {
            System.out.println("Error: the failure of deleting an object from table");
        }

    }





}
