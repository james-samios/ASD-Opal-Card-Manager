package group2.asd.uts.edu.au.opal.object;

import lombok.Getter;
import org.bson.Document;
import java.util.UUID;

@Getter
public class PaymentMethod extends Document {

    private final UUID paymentDetailsId;
    private final UUID accountId;
    private final long cardNumber;
    private final String cardName;
    private final int cardCVC;
    private final String expiryDate;

    /*Constructor*/
    public PaymentMethod(final Document document) {
        this.paymentDetailsId = UUID.fromString(document.getString("payment_details_id"));
        this.accountId = UUID.fromString(document.getString("account_id"));
        this.cardNumber = document.getLong("card_number");
        this.cardName = document.getString("card_name");
        this.cardCVC = document.getInteger("cvc");
        this.expiryDate = document.getString("expiry_date");
    }

    @Override
    public String toString() {
        return getPaymentDetailsId() + " " + getAccountId() + " " + getCardNumber() + " " +
                getCardName() + " " + getCardCVC() + " " + getExpiryDate();
    }


}
