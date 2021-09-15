package group2.asd.uts.edu.au.opal.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import group2.asd.uts.edu.au.opal.api.CollectionType;
import group2.asd.uts.edu.au.opal.object.Card;
import group2.asd.uts.edu.au.opal.object.TopUp;
import org.bson.Document;


/**
 * DBCardsManager is used for access of cards table on mongoDB
 *
 * */
public class DBCardsManager {

    private final MongoCollection<Document> mongoCollection;

    /**
     * Constructor for choosing a table with table name
     * */

    public DBCardsManager() {
        this.mongoCollection = new DBConnection().getTableCollection(CollectionType.CARDS);
    }

    /*
     * Add methods for accessing CRUD on Table
     * "C" means creating a new object into table
     * "R" means reading objects from table
     * "U" means updating table's objects
     * "D" means deleting table's objects
     *
     * */


    /* ************************************Methods for "C" section below**************************************** */




    /* *************************************Methods for "R" section below**************************************** */


    /**
     * Returns a Card with provided card number and pin.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     * @param cardNumber The Opal card's number
     * @param cardPin The customer's password, in md5 hash form.
     * @return Card
     * @author Jung
     */

    public Card getCardByNumberAndPin(final String cardNumber, final String cardPin) {
        try {
            Document document;
            BasicDBObject where = new BasicDBObject();
            where.put("card_number", Double.parseDouble(cardNumber));
            where.put("card_pin", Integer.parseInt(cardPin));
            document = mongoCollection.find(where).first();
            //Retrieving the documents
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new Card(document);
        }catch(Exception e) {
            System.out.println(e);
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

    public Card getCardByCardId(final String cardId) {
        try {
            Document document;
            BasicDBObject where = new BasicDBObject();
            where.put("card_id", cardId);
            document = mongoCollection.find(where).first();

            //Retrieving the documents
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            System.out.println("Card " + document);
            return new Card(document);
        }catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void displayAllCards() {
        try {
            int counter = 1;
            for (Document document : mongoCollection.find()) {
                System.out.println("" + counter + ": " + document);
                counter = counter + 1;
            }
            System.out.println("Success: the success of running displayAllCards");
        }catch(Exception e) {
            System.out.println("Error: the failure of running displayAllCards");
        }

    }


    /* *************************************Methods for "U" section below**************************************** */

    /**
     * No return
     * If a card is found, it will update the balance of the card
     * null, implying incorrect details were supplied.
     * @param cardId The Opal card's ID
     * @param amount The Opal card's new balance
     * @author Jung
     */

    public void updateCardBalance(final String cardId, final double amount) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("card_id", cardId);
            mongoCollection.updateOne(where, Updates.set("balance", amount));
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }

    /**
     * No return
     * If a card is found, it will update boolean of linked to account
     * @param cardId The Opal card's ID
     * @param isLinked The Opal card's link_to_account
     * @author Jung
     */

    public void updateLinkAccount(final String cardId, final boolean isLinked) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("card_id", cardId);
            mongoCollection.updateOne(where, Updates.set("link_to_account", isLinked));
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }

    /**
     * No return
     * If a card is found, it will update boolean of card activation
     * @param cardId The Opal card's ID
     * @param isActivate The Opal card's activation
     * @author Jung
     */
    public void updateCardActivation(final String cardId, final boolean isActivate) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("card_id", cardId);
            mongoCollection.updateOne(where, Updates.set("active", isActivate));
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }

    /**
     * No return
     * If a card is found, it will update Document of Top up
     * @param cardId The Opal card's ID
     * @param topUp The Opal card's Top up
     * @author Jung
     */
    public void updateCardActivation(final String cardId, final TopUp topUp) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("card_id", cardId);
            mongoCollection.updateOne(where, Updates.set("top_up", topUp.convertToDocument()));
        }catch(Exception e) {
            System.out.println("Error: the failure of updating card's object");
        }
    }

    /* *************************************Methods for "D" section below**************************************** */



}
