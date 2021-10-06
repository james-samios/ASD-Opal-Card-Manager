package group2.asd.uts.edu.au.opal.model;
import lombok.Getter;
import org.bson.Document;

import java.util.UUID;

@Getter
public class Cards {

    public UUID cardId;
    public int cardNumber;
    public int cardPin;
    public CardType1 type;
    public double balance;
    public boolean linked;
    public boolean active;
    public boolean locked;
    public group2.asd.uts.edu.au.opal.model.TopUp1 topUp;

    /**
     * Loads an Opal Card object from the API.
     * @param document The BSON document from the cards collection.
     * @author Qiyang Wu
     */
    public Cards(final Document document) {
        this.cardId = UUID.fromString(document.getString("card_id"));
        this.cardNumber = document.getInteger("card_number");
        this.cardPin = document.getInteger("card_pin");
        this.type = CardType1.valueOf(document.getString("type").toUpperCase());
        this.balance = document.getDouble("balance");
        this.linked = document.getBoolean("linked_to_account");
        this.active = document.getBoolean("active");
        this.locked = document.getBoolean("locked");
        this.topUp = new group2.asd.uts.edu.au.opal.model.TopUp1(Document.parse("top_up"));
    }

    /**
     * The type of card assigned to this object.
     */
    public enum CardType1 {
        CHILD,
        SCHOOL,
        CONCESSION,
        ADULT;

        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase();
        }
    }
}
