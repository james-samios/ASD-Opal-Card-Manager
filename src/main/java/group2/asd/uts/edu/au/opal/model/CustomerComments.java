package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;

import java.util.ArrayList;

@Getter
public class CustomerComments {

    private final String comment;
    private final String date;

    /**
     * Creates a new Customer Comments object from the provided MongoDB Document.
     * @param document The provided MongoDB document.
     */
    public CustomerComments(final Document document) {
        this.comment = document.getString("comment");
        this.date = document.getString("date");
    }

    /**
     * Creates a new Customer Comments object from the registration form.
     * @param comment Text of the customer's comment
     * @param date The order of the comment
     */
    public CustomerComments(final String comment, final String date) {
        this.comment = comment;
        this.date = date;
    }

    @Override
    public String toString() {
        return comment + " " + date;
    }
}
