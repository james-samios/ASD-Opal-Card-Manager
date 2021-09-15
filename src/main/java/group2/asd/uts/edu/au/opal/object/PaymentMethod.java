package group2.asd.uts.edu.au.opal.object;

import lombok.Getter;
import org.bson.Document;
import java.util.UUID;

@Getter
public class PaymentMethod extends Document {

    private final UUID paymentDetailsId;
    private UUID accountId;
    private long cardNumber;
    private String cardName;
    private int cardCVC;
    private String expiryDate;

    /*Constructor*/
    /**
     * Loads an Opal Card object from DBPaymentMethodManager.
     * @param document The BSON document from the payment method collection.
     * @author Jung
     */
    public PaymentMethod(final Document document) {
        this.paymentDetailsId = UUID.fromString(document.get("payment_details_id").toString());
        this.accountId = UUID.fromString(document.get("account_id").toString());
        this.cardNumber = document.getLong("card_number");
        this.cardName = document.getString("card_name");
        this.cardCVC = document.getInteger("cvc");
        this.expiryDate = document.getString("expiry_date");
    }

    public PaymentMethod(String cardNumber, String cardName,  String cardCVC,
                         String expiryDate) {
        this.paymentDetailsId = UUID.randomUUID();
        this.accountId = UUID.randomUUID();
        this.cardNumber = Long.parseLong(cardNumber);
        this.cardName = cardName;
        this.cardCVC = Integer.parseInt(cardCVC);
        this.expiryDate = expiryDate;
    }

    public Document convertToDocument() {
        return new Document("payment_details_id", paymentDetailsId)
                .append("account_id", accountId)
                .append("card_number", cardNumber)
                .append("card_name", cardName)
                .append("cvc", cardCVC)
                .append("expiry_date", expiryDate);
    }


    @Override
    public String toString() {
        return new StringBuilder().append(getPaymentDetailsId()).append(" ")
                        .append(getAccountId()).append(" ").append(getCardNumber()).append(" ")
                        .append(getCardCVC()).append(" ").append(getCardName()).append(" ")
                        .append(getExpiryDate()).toString();
    }
}
