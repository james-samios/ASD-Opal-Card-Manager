package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.UUID;

@Getter @Setter
public class PaymentMethod extends Document {

    private ObjectId objectId;
    private UUID paymentMethodId;
    private UUID opalCardId;
    private String cardNumber;
    private String cardName;
    private String cardCVC;
    private String expiryDate;

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
        this.cardNumber = document.getString("card_number");
        this.cardName = document.getString("card_name");
        this.cardCVC = document.getString("cvc");
        this.expiryDate = document.getString("expiry_date");
    }

    public PaymentMethod(String paymentMethodId, String opalCardId, String cardNumber, String cardName, String cardCVC,
                         String expiryDate) {
        this.paymentMethodId = UUID.fromString(paymentMethodId);
        this.opalCardId = UUID.fromString(opalCardId);
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardCVC = cardCVC;
        this.expiryDate = expiryDate;
    }

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
