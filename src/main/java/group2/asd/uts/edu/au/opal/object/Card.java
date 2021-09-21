package group2.asd.uts.edu.au.opal.object;

import lombok.Getter;
import org.bson.Document;

import java.util.UUID;

@Getter
public class Card {

    private final UUID cardId;
    private final int cardNumber;
    private final int cardPin;
    private final CardType type;
    private double balance;
    private boolean linked;
    private boolean active;
    private boolean locked;
    private TopUp topUp;

    /**
     * Loads an Opal Card object from the API.
     * @param document The BSON document from the cards collection.
     * @author James
     */
    public Card(final Document document) {
        this.cardId = UUID.fromString(document.getString("card_id"));
        this.cardNumber = document.getInteger("card_number");
        this.cardPin = document.getInteger("card_pin");
        this.type = CardType.valueOf(document.getString("type").toUpperCase());
        this.balance = document.getDouble("balance");
        this.linked = document.getBoolean("linked_to_account");
        this.active = document.getBoolean("active");
        this.locked = document.getBoolean("locked");
        this.topUp = new TopUp(Document.parse("top_up"));
    }

    /**
     * The type of card assigned to this object.
     */
    public enum CardType {
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