package group2.asd.uts.edu.au.opal.object;

import lombok.Getter;
import org.bson.Document;

import java.util.UUID;

@Getter
public class TopUp extends Document {

    private UUID paymentDetailsId;
    private boolean enabled;
    private double amount;
    private double when;

    /**
     * Loads a Top_up object from an Opal Card object.
     * @param document The BSON document from the card document.
     * @author James
     */
    public TopUp(final Document document) {
        this.paymentDetailsId = UUID.fromString(document.get("payment_details_id").toString());
        this.enabled = document.getBoolean("enabled");
        this.amount = document.getDouble("amount");
        this.when = document.getDouble("when");
    }

    public Document convertToDocument() {
        Document document = new Document("payment_details_id", paymentDetailsId);
        document.append("enabled", enabled).append("amount", amount).append("when", when);
        return document;
    }

    public void setPaymentDetailsId(final UUID paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }

    public void setEnabled(final boolean isEnable) {
        this.enabled = isEnable;
    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }

    public void setWhen(final double amount) {
        this.when = amount;
    }

    @Override
    public String toString() {
        return paymentDetailsId + " " + enabled + " " + amount + " " + when;
    }
}
