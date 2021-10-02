package group2.asd.uts.edu.au.opal.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import group2.asd.uts.edu.au.opal.model.Card;
import group2.asd.uts.edu.au.opal.model.TopUp;
import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * DBCardsManager is used for access of cards table on mongoDB
 *
 * */
@Getter
public class DBCardsManager extends DBManager {

    public DBCardsManager() {
        super(CollectionType.CARDS);
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

    public void createOpalCard(final Card card) {
        try {
            getCollection().insertOne(card.convertClassToDocument());

        } catch (Exception e) {
            System.out.println("Error: Failure of running createPaymentMethod");
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);

        }
    }


    /*   *************************************Methods for "R" section below****************************************   */


    /**
     * Returns a Card with provided card number and pin.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     * @param cardNumber The Opal card's number
     * @param cardPin The customer's password, in md5 hash form.
     * @return Card
     * @author Jung
     */

    public Card readCardByNumberAndPin(final String cardNumber, final String cardPin) {
        try {
            Document document;
            BasicDBObject where = new BasicDBObject();
            where.put("card_number", cardNumber);
            where.put("card_pin", cardPin);
            document = getCollection().find(where).first();
            //Retrieving the documents
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new Card(document);
        }catch(Exception e) {
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    /**
     * Returns a Card with provided card ID.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     * @param cardId The Opal card's ID
     * @return Card
     * @author Jung
     */

    public Card readCardByCardId(final String cardId) {
        try {
            Document document;
            BasicDBObject where = new BasicDBObject();
            where.put("card_id", UUID.fromString(cardId));
            document = getCollection().find(where).first();

            //Retrieving the documents
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new Card(document);
        }catch(Exception e) {
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    /**
     * Returns a Card with provided card ID.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     * @param objectId The Opal card's ID
     * @return Card
     * @author Jung
     */

    public Card readCardByObjectId(final ObjectId objectId) {
        try {
            Document document;
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            document = getCollection().find(where).first();
            //Retrieving the documents
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new Card(document);
        }catch(Exception e) {
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public void readAllCards() {
        try {
            int counter = 1;
            for (Document document : getCollection().find()) {
                System.out.println("" + counter + ": " + document);
                counter = counter + 1;
            }
        }catch(Exception e) {
            System.out.println("Error: the failure of running displayAllCards");
        }

    }
    /*   *************************************Methods for "U" section below****************************************   */

    /**
     * No return
     * If a card is found, it will update the balance of the card
     * null, implying incorrect details were supplied.
     * @param objectId The Opal card's ID
     * @param amount The Opal card's new balance
     * @author Jung
     */

    public void updateCardBalance(final ObjectId objectId, final double amount) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            getCollection().updateOne(where, Updates.set("balance", amount));
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }

    /**
     * No return
     * If a card is found, it will update the card's number
     * @param objectId The Opal card's object ID
     * @param cardNumber The Opal card's pin
     * @author Jung
     */

    public void updateCardNumber(final ObjectId objectId, final String cardNumber) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            getCollection().updateOne(where, Updates.set("card_number", cardNumber));
            System.out.println("Success: the success of updating card's number");
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }

    /**
     * No return
     * If a card is found, it will update the card's pin
     * @param objectId The Opal card's object ID
     * @param cardPin The Opal card's pin
     * @author Jung
     */

    public void updateCardPin(final ObjectId objectId, final String cardPin) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            getCollection().updateOne(where, Updates.set("card_pin", cardPin));
            System.out.println("Success: the success of updating card's pin");
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }

    /**
     * No return
     * If a card is found, it will update the card's type
     * @param objectId The Opal card's object ID
     * @param type The Opal card's type
     * @author Jung
     */

    public void updateCardType(final ObjectId objectId, final String type) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            getCollection().updateOne(where, Updates.set("type", type));
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }

    /**
     * No return
     * If a card is found, it will update the UUID of account ID
     * @param objectId The Opal card's object ID
     * @param accountId The Opal card's linked account ID
     * @author Jung
     */
    public void updateAccountId(final ObjectId objectId, final UUID accountId) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            getCollection().updateOne(where, Updates.set("account_id", accountId));
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's linked account ID");
        }
    }

    /**
     * No return
     * If a card is found, it will update boolean of card activation
     * @param objectId The Opal card's object ID
     * @param active The Opal card's activation
     * @author Jung
     */

    public void updateCardActive(final ObjectId objectId, final boolean active) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            getCollection().updateOne(where, Updates.set("active", active));
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's activate");
        }
    }


    /**
     * No return
     * If a card is found, it will update Document of Top up
     * @param objectId The Opal card's object ID
     * @param topUp The Opal card's Top up
     * @author Jung
     */
    public void updateCardTopUp(final ObjectId objectId, final TopUp topUp) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            getCollection().updateOne(where, Updates.set("top_up", topUp.convertClassToDocument()));
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }

    /**
     * No return
     * If a card is found, it will update Document of Trips
     * @param objectId The Opal card's object ID
     * @param trips The Opal card's trips
     * @author Jung
     */
    public void updateCardTrips(final ObjectId objectId, final ArrayList<Document> trips) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            getCollection().updateOne(where, Updates.set("trips", trips));
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }

    /*   *************************************Methods for "D" section below****************************************   */
    public void deleteCardByObjectId(final ObjectId objectId) {
        try {
            //deleting an object from table
            getCollection().deleteMany(Filters.eq("_id", objectId));
        }catch(Exception e) {
            System.out.println("Error: the failure of deleting an object from table");
        }
    }

    public void deleteCardByCardNumberAndPin(final String cardNumber, final String cardPin) {
        try {
            //deleting an object from table
            BasicDBObject where = new BasicDBObject();
            where.put("card_number", cardNumber);
            where.put("card_pin", cardPin);
            getCollection().deleteMany(where);
        }catch(Exception e) {
            System.out.println("Error: the failure of deleting an object from table");
        }
    }
}
