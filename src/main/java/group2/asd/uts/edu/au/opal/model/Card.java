package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.UUID;

@Getter
public class Card extends Document {

    private ObjectId objectId;
    private UUID cardId;
    private long cardNumber;
    private int cardPin;
    private CardType type;
    private double balance;
    private UUID accountId;
    private boolean active;
    private boolean locked;
    private TopUp topUp;
    private ArrayList<Trip> trips;

    /**
     * Loads an Opal Card object from the API.
     * @param document The BSON document from the cards collection.
     * @author James
     */

    public Card(final Document document) {
        this.objectId = new ObjectId(document.get("_id").toString());
        this.cardId = UUID.fromString(document.get("card_id").toString());
        this.cardNumber = document.getLong("card_number");
        this.cardPin = document.getInteger("card_pin");
        this.type = CardType.valueOf(document.getString("type").toUpperCase());
        this.balance = document.getDouble("balance");
        this.accountId = UUID.fromString(document.get("account_id").toString());
        this.active = document.getBoolean("active");
        this.locked = document.getBoolean("locked");
        this.topUp = new TopUp(document.get("top_up", Document.class));

        /*add trips into trip array list*/
        this.trips = new ArrayList<>();
        for (Document eachTrip : document.getList("trips", Document.class)) {
            this.trips.add(new Trip(eachTrip));
        }
    }

    public Card (final ObjectId objectId,
                 final UUID cardId,
                 final long cardNumber,
                 final int cardPin,
                 final CardType type,
                 final double balance,
                 final UUID accountId,
                 final boolean active,
                 final boolean locked,
                 final TopUp topUp,
                 final ArrayList<Trip> trips) {
        this.objectId = objectId;
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
        this.type = type;
        this.balance = balance;
        this.accountId = accountId;
        this.active = active;
        this.locked = locked;
        this.topUp = topUp;
        this.trips = trips;
    }



    public Document convertClassToDocument() {
        Document document = new Document("card_id", cardId)
                .append("card_number", cardNumber)
                .append("card_pin", cardPin)
                .append("type", type.toString().toUpperCase())
                .append("balance", balance)
                .append("account_id", accountId)
                .append("active", active)
                .append("locked", locked);
        document.put("top_up", topUp.convertClassToDocument());
        document.append("trips", getArrayListOfDocumentOfTrips());
        return document;
    }

    public ArrayList<Document> getArrayListOfDocumentOfTrips() {
        ArrayList<Document> allTrips = new ArrayList<>();

        for(Trip trip: trips) {
            allTrips.add(trip.convertClassToDocument());
        }
        return allTrips;
    }

    public void setObjectId(final ObjectId objectId) {this.objectId = objectId;}
    public void setCardId(final UUID cardId) {this.cardId = cardId;}
    public void setCardNumber(String cardNumber) {this.cardNumber = Long.parseLong(cardNumber);}
    public void setCardPin(String cardPin) {this.cardPin = Integer.parseInt(cardPin);}
    public void setType(CardType type) {this.type = type;}
    public void setBalance(Double amount) {this.balance = amount;}
    public void setActive(boolean value) {this.active = value;}
    public void setAccountId(UUID accountId) {this.accountId = accountId;}
    public void setLocked(boolean value) {this.locked = value;}
    public void setTopUp(TopUp topUp) {this.topUp = topUp;}
    public void setTopUpEnabled(final boolean value) {this.topUp.setEnabled(value);}
    public void setTopUpAmount(final double value) {this.topUp.setAmount(value);}
    public void setTopUpWhen(final double value) {this.topUp.setWhen(value);}
    //public void setTopUpPaymentDetailsId(UUID paymentDetailsId) {this.topUp.setPaymentDetailsId(paymentDetailsId);}
    public void setTrips(ArrayList<Trip> trips) {this.trips = trips;}

    public String outPutCardFormat() {
        String strCardNumber = String.valueOf(cardNumber);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strCardNumber.length(); i++) {
            if (i % 4 == 0 && i != 0) {
                result.append("-");
            }

            result.append(strCardNumber.charAt(i));
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return getObjectId() + " " +
                getCardId() + " " +
                getCardNumber() + " " +
                getCardPin() + " " +
                getType() + " " +
                getBalance() + " " +
                getAccountId() + " " +
                isActive() + " " +
                isLocked() + " " +
                getTopUp() + " " +
                getTrips();
    }
}
