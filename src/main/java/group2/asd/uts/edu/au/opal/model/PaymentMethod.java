package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.UUID;

@Getter
public class PaymentMethod extends Document {

    private ObjectId objectId;
    private final UUID paymentMethodId;
    private final UUID opalCardId;
    private final long cardNumber;
    private final String cardName;
    private final int cardCVC;
    private final String expiryDate;

    /*Constructor*/
    /**
     * Loads an Opal Card object from DBPaymentMethodManager.
     * @param document The BSON document from the payment method collection.
     * @author Jung
     */
    public PaymentMethod(final Document document) {
        this.objectId = new ObjectId(document.get("_id").toString());
        this.paymentMethodId = UUID.fromString(document.get("payment_method_id").toString());
        this.opalCardId = UUID.fromString(document.get("opal_card_id").toString());
        this.cardNumber = document.getLong("card_number");
        this.cardName = document.getString("card_name");
        this.cardCVC = document.getInteger("cvc");
        this.expiryDate = document.getString("expiry_date");
    }

    public PaymentMethod(String paymentMethodId, String opalCardId, String cardNumber, String cardName,  String cardCVC,
                         String expiryDate) {
        this.paymentMethodId = UUID.fromString(paymentMethodId);
        this.opalCardId = UUID.fromString(opalCardId);
        this.cardNumber = Long.parseLong(cardNumber);
        this.cardName = cardName;
        this.cardCVC = Integer.parseInt(cardCVC);
        this.expiryDate = expiryDate;
    }

    public void setObjectId(ObjectId objectId) {this.objectId = objectId;}

    public Document convertClassToDocument() {
        return new Document("payment_method_id", paymentMethodId)
                .append("opal_card_id", opalCardId)
                .append("card_number", cardNumber)
                .append("card_name", cardName)
                .append("cvc", cardCVC)
                .append("expiry_date", expiryDate);
    }


    @Override
    public String toString() {
        return getPaymentMethodId() + " " +
                getOpalCardId() + " " +
                getCardNumber() + " " +
                getCardCVC() + " " +
                getCardName() + " " +
                getExpiryDate();
    }
}
