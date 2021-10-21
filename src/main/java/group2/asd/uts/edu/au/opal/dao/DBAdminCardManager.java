package group2.asd.uts.edu.au.opal.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import group2.asd.uts.edu.au.opal.model.Card;
import group2.asd.uts.edu.au.opal.model.TopUp;
import group2.asd.uts.edu.au.opal.servlet.CardForm;
import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * DBCardsManager is used for access of cards table on mongoDB
 *
 * */
@Getter
public class DBAdminCardManager extends DBManager {

    public DBAdminCardManager() {
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
     *
     * @param cardNumber The Opal card's number
     * @param cardPin    The customer's password, in md5 hash form.
     * @return Card
     * @author Qiyang Wu
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
        } catch (Exception e) {
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    /**
     * Returns a Card with provided card ID.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     *
     * @param cardId The Opal card's ID
     * @return Card
     * @author Qiyang Wu
     */

    public CardForm readCardByCardId(final String cardId) {
        try {
            System.out.println("传入的cardId："+cardId);
            Document document;
            BasicDBObject where = new BasicDBObject();
            where.put("card_id", cardId);
            document = getCollection().find(where).first();

            //Retrieving the documents
            if (document == null || document.isEmpty()) {
                throw new Exception("Error: The document is null or empty.");
            }
            return new CardForm(document);
        } catch (Exception e) {
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }


    /**
     * Returns a Card with provided card ID.
     * If no data is found, it will return
     * null, implying incorrect details were supplied.
     *
     * @param objectId The Opal card's ID
     * @return Card
     * @author Qiyang Wu
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
        } catch (Exception e) {
            Logger.getLogger(DBCardsManager.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<CardForm> readAllCards() {
        List<CardForm> list = new ArrayList();
        try {
            int counter = 1;
            for (Document document : getCollection().find()) {
                System.out.println("" + counter + ": " + document);
                counter = counter + 1;
                list.add(new CardForm(document));

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: the failure of running displayAllCards");
        }
        return  list;
    }

    public List<CardForm> readAllCardsByType(String type) {
        List<CardForm> list = new ArrayList();
        BasicDBObject where = new BasicDBObject();
        where.put("type", type.toUpperCase());
        try {
            int counter = 1;
            for (Document document : getCollection().find(where)) {
                System.out.println("" + counter + ": " + document);
                counter = counter + 1;
                list.add(new CardForm(document));

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: the failure of running displayAllCards");
        }
        return  list;
    }
    public static void main(String[] args) {
//        Document document;
//        BasicDBObject where = new BasicDBObject();
//        where.put("card_id", "4c49abab-25f1-4d3d-99d7-2100ee1de7a1");
//        document = new DBCardsManager().getCollection().find(where).first();
//
//        //Retrieving the documents
//        if (document == null || document.isEmpty()) {
//            System.out.println("不行");
//        }

        new DBAdminCardManager().readAllCardsByType("ADULT");
    }
    /*   *************************************Methods for "U" section below****************************************   */

    /**
     * No return
     * If a card is found, it will update the balance of the card
     * null, implying incorrect details were supplied.
     * @param objectId The Opal card's ID
     * @param amount The Opal card's new balance
     * @author Qiyang Wu
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
     * @author Qiyang Wu
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
     * @author Qiyang Wu
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


    public void update(final ObjectId objectId
            , final String cardPin
            , final String cardNumber
            , final String type
            , final Double balance
            , final Boolean active) {
        try {
            BasicDBObject where = new BasicDBObject();
            where.put("_id", objectId);
            getCollection().updateMany(where, Updates.set("card_pin", cardPin));
            getCollection().updateMany(where, Updates.set("card_number", cardNumber));
            getCollection().updateMany(where, Updates.set("type", type));
            getCollection().updateMany(where, Updates.set("balance", balance));
            getCollection().updateMany(where, Updates.set("active", active));

            System.out.println("Success: the success of updating card's pin");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error: the failure of updating card's object");
        }
    }

    public void add(final String cardPin
            , final String cardNumber
            , final String type
            , final Double balance
            , final Boolean active) {
        try {
            String questionId = ObjectId.get().toString();
            ObjectId id = new ObjectId(questionId);
            getCollection().insertOne(new Document("_id",id)
                    .append("card_pin", cardPin)
                    .append("account_id","00000000-0000-0000-0000-000000000000")
                    .append("card_id", UUID.randomUUID().toString())
                    .append("card_number", cardNumber)
                    .append("type", type)
                    .append("balance", balance)
                    .append("active", active)
                    .append("locked", false)
                    .append("top_up",null)
                    .append("trips",null)
            );


            System.out.println("Success: the success of updating card's pin");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error: the failure of updating card's object");
        }
    }

    /**
     * No return
     * If a card is found, it will update the card's type
     * @param objectId The Opal card's object ID
     * @param type The Opal card's type
     * @author Qiyang Wu
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
     * @author Qiyang Wu
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
     * @author Qiyang Wu
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
     * @author Qiyang Wu
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
     * @author Qiyang Wu
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
