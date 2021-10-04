package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;

import java.util.Date;

@Getter
public class Trip extends Document {
    private final String tripStart;
    private final String tripEnd;
    private final Date startTime;
    private final Date endTime;
    private final Double fare;
    private final String startPoint;
    private final String endPoint;

    /**
     * Loads a Trip object from an Opal Card object.
     * @param document The BSON document from the card document.
     * @author Jung
     */

    /*Constructor*/
    public Trip(final Document document) {
        this.tripStart = document.getString("trip_start");
        this.tripEnd = document.getString("trip_end");
        this.startTime = document.getDate("start_time");
        this.endTime = document.getDate("end_time");
        this.fare = document.getDouble("fare");
        this.startPoint = document.getString("start_point");
        this.endPoint = document.getString("end");
    }

    public Trip(final String tripStart, final  String tripEnd, final Date startTime, final Date endTime, final Double fare, final String startPoint, final String endPoint) {
        this.tripStart = tripStart;
        this.tripEnd = tripEnd;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fare = fare;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    /*object convert to a document*/
    public Document convertClassToDocument() {
        return new Document("trip_start", tripStart)
                .append("trip_end", tripEnd)
                .append("start_time", startTime)
                .append("end_time", endTime)
                .append("fare", fare)
                .append("start_point", startPoint)
                .append("end_point", endPoint);
    }

    @Override
    public String toString() {
        return tripStart + " " + tripEnd + " " + startTime + " " + " " + endTime;
    }
}
