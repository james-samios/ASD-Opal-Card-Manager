package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.model.CardType;
import group2.asd.uts.edu.au.opal.model.TopUp;
import group2.asd.uts.edu.au.opal.model.Trip;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.UUID;
@Setter @Getter
public class CardForm {


    private ObjectId objectId;
    private UUID cardId;
    private UUID accountId;
    private String cardNumber;
    private String cardPin;
    private CardType type;
    private String leixing;
    private double balance;
    private boolean active;
    private boolean locked;
    private TopUp topUp;
    private ArrayList<Trip> trips;

    public CardForm(final Document document) {
        System.out.println(document);
        this.objectId = new ObjectId(document.get("_id").toString());
        this.cardId = UUID.fromString(document.get("card_id").toString());
        this.cardNumber = document.getString("card_number");
        this.cardPin = document.getString("card_pin");
        if(document.getString("type") == null){
            this.type = CardType.ADULT;
        }else{
            this.type = CardType.valueOf(document.getString("type").toUpperCase());
        }

        this.balance = document.getDouble("balance");
        this.accountId = UUID.fromString(document.get("account_id").toString());
        this.active = document.getBoolean("active");
        this.locked = document.getBoolean("locked");
        this.topUp = new TopUp(document.get("top_up", Document.class));
        this.leixing = type.toString();
        /*add trips into trip array list*/
        this.trips = new ArrayList<>();
        if(document.getList("trips", Document.class) == null){
            return;
        }
        for (Document eachTrip : document.getList("trips", Document.class)) {
            this.trips.add(new Trip(eachTrip));
        }
    }



    @Override
    public String toString() {
        return "CardForm{" +
                "objectId=" + objectId +
                ", cardId=" + cardId +
                ", accountId=" + accountId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardPin='" + cardPin + '\'' +
                ", type=" + type +
                ", balance=" + balance +
                ", active=" + active +
                ", locked=" + locked +
                ", topUp=" + topUp +
                ", trips=" + trips +
                '}';
    }
}