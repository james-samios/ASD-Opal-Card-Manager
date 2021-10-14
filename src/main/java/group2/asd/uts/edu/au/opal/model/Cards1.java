<<<<<<< Updated upstream
package group2.asd.uts.edu.au.opal.model;
import group2.asd.uts.edu.au.opal.model.Trips;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;


public class Cards1 extends Document  implements Serializable {

    private ObjectId objectId;
    private UUID cardId;
    private UUID accountId;
    private String cardNumber;
    private String cardPin;
    private CardType1 type;
    private double balance;
    private boolean active;
    private boolean locked;
    private group2.asd.uts.edu.au.opal.model.TopUp1 topUp;
    private ArrayList<Trips> trips;
    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public UUID getCardId() {
        return cardId;
    }

    public void setCardId(UUID cardId) {
        this.cardId = cardId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardPin() {
        return cardPin;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

    public CardType1 getType() {
        return type;
    }

    public void setType(CardType1 type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public group2.asd.uts.edu.au.opal.model.TopUp1 getTopUp() {
        return topUp;
    }

    public void setTopUp(group2.asd.uts.edu.au.opal.model.TopUp1 topUp) {
        this.topUp = topUp;
    }

    public ArrayList<Trips> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trips> trips) {
        this.trips = trips;
    }



    /**
     * Loads an Opal Card object from the API.
     * @param document The BSON document from the cards collection.
     * @author Qiyang Wu
     */

    public Cards1(final Document document) {
        this.objectId = new ObjectId(document.get("_id").toString());
        this.cardId = UUID.fromString(document.get("card_id").toString());
        this.cardNumber = document.getString("card_number");
        this.cardPin = document.getString("card_pin");
        this.type = CardType1.valueOf(document.getString("type").toUpperCase());
        this.balance = document.getDouble("balance");
        this.accountId = UUID.fromString(document.get("account_id").toString());
        this.active = document.getBoolean("active");
        this.locked = document.getBoolean("locked");
        this.topUp = new group2.asd.uts.edu.au.opal.model.TopUp1(document.get("top_up", Document.class));

        /*add trips into trip array list*/
        this.trips = new ArrayList<>();
        for (Document eachTrip : document.getList("trips", Document.class)) {
            this.trips.add(new Trips(eachTrip));
        }
    }

    public Cards1 (final ObjectId objectId,
                   final UUID cardId,
                   final String cardNumber,
                   final String cardPin,
                   final CardType1 type,
                   final double balance,
                   final UUID accountId,
                   final boolean active,
                   final boolean locked,
                   final group2.asd.uts.edu.au.opal.model.TopUp1 topUp,
                   final ArrayList<Trips> trips) {
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
        for(Trips trip: trips) {
            allTrips.add(trip.convertClassToDocument());
        }
        return allTrips;
    }

    public void setTopUpPaymentMethodId(final UUID paymentMethodId) {this.topUp.setPaymentMethodId(paymentMethodId);}
    public void setTopUpEnabled(final boolean value) {this.topUp.setEnabled(value);}
    public void setTopUpAmount(final double value) {this.topUp.setAmount(value);}
    public void setTopUpWhen(final double value) {this.topUp.setWhen(value);}


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
        return "Card{" +
                "objectId=" + objectId +
                ", cardId=" + cardId +
                ", accountId=" + accountId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardPin='" + cardPin + '\'' +
                ", type=" + type +
                ", balance=" + balance +
                ", active=" + active +
                ", locked=" + locked +
                ", topUp=" + topUp +
                ", trips=" + trips +
                '}';
    }
    public Cards1(){

    }

=======
package group2.asd.uts.edu.au.opal.model;public class Cards1 {
>>>>>>> Stashed changes
}
