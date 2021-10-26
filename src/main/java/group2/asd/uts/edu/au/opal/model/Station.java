package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;

import java.util.ArrayList;

@Getter
public class Station extends Document {
    private String id;
    private final String arrivalTime;
    private final String departureTime;
    private final String name;
    private final String type;
    private final Double fare;
    private  final ArrayList<Integer> coordinates;

    /**
     * Loads a Trip object from an Opal Card object.
     * @param document The BSON document from the card document.
     * @author Jung
     */

    /*Constructor*/
    public Station(final Document document) {
        this.id = document.get("_id").toString();
        this.arrivalTime = document.getString("arrival");
        this.departureTime = document.getString("departure");
        this.name = document.getString("name");
        this.type = document.getString("type");
        this.fare = document.getDouble("fare");
        this.coordinates = (ArrayList<Integer>) document.get("coordinates");
    }

    public Station(final String id, final String arrival, final  String departure, final String name, final String type, final Double fare, final ArrayList<Integer> coords) {
        this.id = null;
        this.arrivalTime = arrival;
        this.departureTime = departure;
        this.name = name;
        this.type = type;
        this.fare = fare;
        this.coordinates = coords;
    }

    public Station(final String arrival, final  String departure, final String name, final String type, final Double fare, final ArrayList<Integer> coords) {
        this.arrivalTime = arrival;
        this.departureTime = departure;
        this.name = name;
        this.type = type;
        this.fare = fare;
        this.coordinates = coords;
    }

    /*object convert to a document*/
    public Document convertClassToDocument() {
        return new Document("arrival", arrivalTime)
                .append("departure", departureTime)
                .append("name", name)
                .append("type", type)
                .append("fare", fare)
                .append("coordinates", coordinates);
    }

    public String getID(){
        return id;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Double getFare() {
        return fare;
    }

    public ArrayList<Integer> getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Station{" +
                "arrivalTime='" + arrivalTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", fare=" + fare +
                '}';
    }
}
