package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;

@Getter
public class Address {

    private final String addressLine1;
    private final String addressLine2;
    private final String suburb;
    private final int postCode;
    private final String state;

    /**
     * Creates a new Address object from the provided MongoDB Document.
     * @param document The provided MongoDB document.
     */
    public Address(final Document document) {
        this.addressLine1 = document.getString("address_line_1");
        this.addressLine2 = document.getString("address_line_2");
        this.suburb = document.getString("suburb");
        this.postCode = document.getInteger("post_code");
        this.state = document.getString("state");
    }


    public Address(final String line1, final String line2, final String suburb, final int postcode, final String state) {
        this.addressLine1 = line1;
        this.addressLine2 = line2;
        this.suburb = suburb;
        this.postCode = postcode;
        this.state = state;
    }

    @Override
    public String toString() {
        return addressLine1 + " " + addressLine2 + " " + suburb + " " + postCode + " " + state;
    }
}
