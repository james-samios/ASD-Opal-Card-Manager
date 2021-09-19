package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;

@Getter
public class TopUp extends Document {

    //private UUID paymentDetailsId;
    private boolean enabled;
    private double amount;
    private double when;

    /**
     * Loads a Top_up object from an Opal Card object.
     * @param document The BSON document from the card document.
     * @author James
     */
    public TopUp(final Document document) {
        //this.paymentDetailsId = UUID.fromString(document.get("payment_details_id").toString());
        this.enabled = document.getBoolean("enabled");
        this.amount = document.getDouble("amount");
        this.when = document.getDouble("when");
    }

    public TopUp(final boolean enabled, final double amount, final double when) {
        this.enabled = enabled;
        this.amount = amount;
        this.when = when;
    }


    public Document convertClassToDocument() {
        /*
        Document classToDocument = new Document("enabled", enabled)
                .append("amount", amount)
                .append("when", when);
                .append("payment_details_id", paymentDetailsId);

         */
        return new Document("enabled", enabled)
                .append("amount", amount)
                .append("when", when);
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
        return enabled + " " + amount + " " + when;
    }
}
