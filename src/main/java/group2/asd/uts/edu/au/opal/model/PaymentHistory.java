package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;

import java.util.Date;
import java.util.UUID;
import org.bson.Document;
import org.bson.types.ObjectId;

@Getter
public class PaymentHistory extends Document {
    private ObjectId objectId;
    private final UUID paymentId;
    private final UUID cardId;
    private final double amount;
    private final String status;
    private final String paymentMethod;
    private final Date paymentDate;

    public PaymentHistory (Document document) {
        this.objectId = new ObjectId(document.get("_id").toString());
        this.paymentId = UUID.fromString(document.getString("payment_id"));
        this.cardId = UUID.fromString(document.getString("card_id"));
        this.amount = document.getDouble("amount");
        this.status = document.getString("status");
        this.paymentMethod = document.getString("payment_method");
        this.paymentDate = document.getDate("payment_date");
    }

    public PaymentHistory(final UUID paymentId,
                          final UUID cardId,
                          final double amount,
                          final String status,
                          final String paymentMethod,
                          final Date paymentDate) {

        this.paymentId = paymentId;
        this.cardId = cardId;
        this.amount = amount;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;

    }

    public Document convertClassToDocument() {
        return new Document("payment_id", paymentId.toString())
                .append("card_id", cardId.toString())
                .append("amount", amount)
                .append("status", status)
                .append("payment_method", paymentMethod)
                .append("payment_date", paymentDate);
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return getPaymentId() + " -" +
                getCardId() + " - " +
                getAmount() + " - " +
                getStatus() + " - " +
                getPaymentMethod() +
                getPaymentDate();
    }

}
