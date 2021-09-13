package group2.asd.uts.edu.au.opal.object;

import lombok.Getter;
import org.bson.Document;

import java.util.Date;
import java.util.UUID;

@Getter
public class Address extends Document {
    private final String addressLine1;
    private final String addressLine2;
    private final String suburb;
    private final int postCode;
    private final String state;

    /**Constructor**/
    public Address(final Document document) {
        this.addressLine1 = document.getString("address_line_1");
        this.addressLine2 = document.getString("address_line_2");
        this.suburb = document.getString("suburb");
        this.postCode = document.getInteger("post_code");
        this.state = document.getString("state");
    }

    @Override
    public String toString() {
        return addressLine1 + " " + addressLine2 + " " + suburb + " " + postCode + " " + state;
    }
}
