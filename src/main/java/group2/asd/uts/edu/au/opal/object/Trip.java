package group2.asd.uts.edu.au.opal.object;

import lombok.Getter;
import org.bson.Document;
import java.util.Date;

@Getter
public class Trip extends Document {
    private final String tripStart;
    private final String tripEnd;
    private final Date startTime;
    private final Date endTime;

    /**
     * Loads a Trip object from an Opal Card object.
     * @param document The BSON document from the card document.
     * @author Jung
     */
    /**Constructor**/
    public Trip(final Document document) {
        this.tripStart = document.getString("trip_start");
        this.tripEnd = document.getString("trip_end");
        this.startTime = document.getDate("start_time");
        this.endTime = document.getDate("end-time");
    }
    @Override
    public String toString() {
        return tripStart + " " + tripEnd + " " + startTime + " " + " " + endTime;
    }
}
