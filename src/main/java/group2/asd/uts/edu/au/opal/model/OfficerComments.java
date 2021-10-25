package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;

@Getter
public class OfficerComments extends Document {
    private final String comment;
    private final String order;


    /**Constructor**/
    public OfficerComments(final Document document) {
        this.comment = document.getString("officer_comments.comment");
        this.order = document.getString("officer_comments.order");

    }

    @Override
    public String toString() {
        return comment + " " + order;
    }
}
