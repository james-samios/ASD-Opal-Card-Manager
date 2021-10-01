package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;

@Getter
public class CustomerComments extends Document {
    private final String comment;
    private final String order;
    //add date

    /**Constructor**/
    public CustomerComments(final Document document) {
        this.comment = document.getString("customer_comments.comment");
        this.order = document.getString("customer_comments.order");
        //add date
    }

    @Override
    public String toString() {
        return comment + " " + order;
    }
}
