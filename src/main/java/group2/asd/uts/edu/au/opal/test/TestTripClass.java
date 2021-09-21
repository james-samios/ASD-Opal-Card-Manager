package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.model.Trip;
import org.bson.Document;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestTripClass {
    private final String tripStart = "Kings Cross";
    private final String tripEnd = "Bondi Junction";
    private final Date startTime = Calendar.getInstance().getTime();
    private final Date endTime = Calendar.getInstance().getTime();
    private final Document document = new Document("trip_start", tripStart)
            .append("trip_end", tripEnd)
            .append("start_time", startTime)
            .append("end_time", endTime);

    private final Trip expectedTrip = new Trip(tripStart, tripEnd, startTime, endTime);


    @Test
    public void testTripConstructor() {
        /*Display the document*/
        System.out.println("Display the Document: " + document);

        /*create a new Trip by provided document*/
        Trip trip = new Trip(document);
        assertEquals(expectedTrip, trip);
    }

    @Test
    public void testTripConvertToDocument() {
        Document classToDocument = expectedTrip.convertClassToDocument();
        assertEquals(document, classToDocument);
    }

    @Test
    public void testGetTripStartMethod() {
        assertEquals(tripStart, expectedTrip.getTripStart());
    }

    @Test
    public void testGetTripEndMethod() {
        assertEquals(tripEnd, expectedTrip.getTripEnd());
    }

    @Test
    public void testGetStartTimeMethod() {
        assertEquals(startTime, expectedTrip.getStartTime());
    }

    @Test
    public void testGetEndTimeMethod() {
        assertEquals(endTime, expectedTrip.getEndTime());
    }
}
