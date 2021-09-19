package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import java.util.UUID;
import org.bson.Document;
@Getter
public class PaymentHistory extends Document {
    private final UUID paymentId;
    private final UUID accountId;
    private final UUID cardId;
    private final double amount;
    private final String status;
    private final String paymentMethod;

    public PaymentHistory (Document document) {
        this.paymentId = UUID.fromString(document.getString("payment_id"));
        this.accountId = UUID.fromString(document.getString("account_id"));
        this.cardId = UUID.fromString(document.getString("card_id"));
        this.amount = document.getDouble("amount");
        this.status = document.getString("status");
        this.paymentMethod = document.getString("payment_method");
    }

    @Override
    public String toString() {
        return getPaymentId() + " -" +
                getAccountId() + " - " +
                getCardId() + " - " +
                getAmount() + " - " +
                getStatus() + " - " +
                getPaymentMethod();
    }

}
