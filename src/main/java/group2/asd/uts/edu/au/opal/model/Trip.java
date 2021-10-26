package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.UUID;

@Getter
public class Trip extends Document {
    private ObjectId id;
    private final String tripStart;
    private final String tripEnd;
    private final Date startTime;
    private final Date endTime;
    private final Double fare;

    /**
     * Loads a Trip object from an Opal Card object.
     * @param document The BSON document from the card document.
     * @author Jung
     */

    /*Constructor*/
    public Trip(final Document document) {
        this.id = document.getObjectId("_id");
        this.tripStart = document.getString("trip_start");
        this.tripEnd = document.getString("trip_end");
        this.startTime = document.getDate("start_time");
        this.endTime = document.getDate("end_time");
        this.fare = document.getDouble("fare");
    }

    public Trip(final String tripStart, final  String tripEnd, final Date startTime, final Date endTime, final Double fare) {
        this.tripStart = tripStart;
        this.tripEnd = tripEnd;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fare = fare;
    }

    /*object convert to a document*/
    public Document convertClassToDocument() {
        return new Document("trip_start", tripStart)
                .append("trip_end", tripEnd)
                .append("start_time", startTime)
                .append("end_time", endTime)
                .append("fare", fare);
    }

    @Override
    public String toString() {
        return tripStart + " " + tripEnd + " " + startTime + " " + " " + endTime;
    }

    public Object getObjectId() {
        return id.toString();
    }

    public void setObjectId(ObjectId id) {
        this.id = id;
    }
    public String getTripStart() {
        return tripStart;
    }

    public String getTripEnd() {
        return tripEnd;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Double getFare() {
        return fare;
    }
}
