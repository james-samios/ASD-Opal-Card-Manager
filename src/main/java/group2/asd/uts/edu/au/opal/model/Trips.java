<<<<<<< Updated upstream
package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;

import java.util.Date;

@Getter
public class Trips extends Document {
    private final String tripStart;
    private final String tripEnd;
    private final Date startTime;
    private final Date endTime;

    /**
     * Loads a Trip object from an Opal Card object.
     * @param document The BSON document from the card document.
     * @author Qiyang Wu
     */

    /*Constructor*/
    public Trips(final Document document) {
        this.tripStart = document.getString("trip_start");
        this.tripEnd = document.getString("trip_end");
        this.startTime = document.getDate("start_time");
        this.endTime = document.getDate("end_time");
    }

    public Trips(final String tripStart, final  String tripEnd, final Date startTime, final Date endTime) {
        this.tripStart = tripStart;
        this.tripEnd = tripEnd;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /*object convert to a document*/
    public Document convertClassToDocument() {
        return new Document("trip_start", tripStart)
                .append("trip_end", tripEnd)
                .append("start_time", startTime)
                .append("end_time", endTime);
    }

    @Override
    public String toString() {
        return tripStart + " " + tripEnd + " " + startTime + " " + " " + endTime;
    }
=======
package group2.asd.uts.edu.au.opal.model;public class Trips {
>>>>>>> Stashed changes
}
