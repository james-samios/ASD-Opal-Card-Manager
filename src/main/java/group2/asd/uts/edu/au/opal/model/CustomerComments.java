package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;

import java.util.ArrayList;

@Getter
public class CustomerComments {

    private final String comment;
    private final String order;

    /**
     * Creates a new Customer Comments object from the provided MongoDB Document.
     * @param document The provided MongoDB document.
     */
    public CustomerComments(final Document document) {
        this.comment = document.getString("comment");
        this.order = document.getString("order");
    }

    /**
     * Creates a new Customer Comments object from the registration form.
     * @param comment Text of the customer's comment
     * @param order The order of the comment
     */
    public CustomerComments(final String comment, final String order) {
        this.comment = comment;
        this.order = order;
    }

    @Override
    public String toString() {
        return comment + " " + order;
    }
}
