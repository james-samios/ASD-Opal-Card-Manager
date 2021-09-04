package group2.asd.uts.edu.au.opal.object;

import lombok.Getter;
import org.bson.Document;

import java.util.UUID;

@Getter
public class TopUp {

    private final boolean enabled;

    private double amount;
    private double when;
    private UUID paymentDetailsId;

    /**
     * Loads a Top Up object from an Opal Card object.
     * @param document The BSON document from the card document.
     * @author James
     */
    public TopUp(final Document document) {
        this.enabled = document.getBoolean("enabled");
        if (enabled) {
            this.amount = document.getDouble("amount");
            this.when = document.getDouble("when");
            this.paymentDetailsId = UUID.fromString(document.getString("payment_details_id"));
        }
    }
    public void updateBalance(double topUpFees) {
        this.amount = this.amount + topUpFees;
        
    }
}
