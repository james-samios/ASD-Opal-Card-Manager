package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.model.Card;
import group2.asd.uts.edu.au.opal.model.CardType;
import group2.asd.uts.edu.au.opal.model.TopUp;
import group2.asd.uts.edu.au.opal.model.Trip;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import static org.junit.Assert.*;

public class TestCardClass {

    /*Fields used for auto testing references*/
    final ObjectId objectId = new ObjectId("612ed59a56cb54f515475557");
    final UUID cardId = UUID.fromString("8c7eda3f-ab45-4c82-9ba8-a462043f1dde");
    final String cardNumber = "3085220000000000";
    final String cardPin = "9999";
    final CardType cardType = CardType.CONCESSION;
    final double balance = 55.0;
    final UUID accountId = UUID.randomUUID();
    final boolean active = false;
    final boolean locked = false;
    final TopUp topUp = new TopUp(UUID.randomUUID(), false, 10, 5);
    final Trip trip = new Trip("Kings Cross", "Bondi Junction",
                Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 2.20);
    final ArrayList<Trip> trips = new ArrayList<Trip>() {{
            add(trip);
    }};

    final Card expectedCard = new Card(objectId, cardId, cardNumber, cardPin,
            cardType, balance, accountId, active,
            locked, topUp, trips);

    /*Constructor autotests*/
    @Test
    public void testCardConstructor() {
        Document document = new Document("_id", objectId)
                .append("card_id", cardId.toString())
                .append("card_number", cardNumber)
                .append("card_pin", cardPin)
                .append("type", cardType.toString())
                .append("balance", balance)
                .append("account_id", accountId.toString())
                .append("active", active)
                .append("locked", locked);
        document.put("top_up", topUp.convertClassToDocument());
        document.put("trips", trips);


        /*Display the document*/
        System.out.println("Display the Document: " + document);
        Card actualCard = new Card(document);
        assertEquals(expectedCard, actualCard);

    }

    @Test
    public void testCardConvertToDocument() {
        Document document = expectedCard.convertClassToDocument();
        Document expectDoc = new Document("card_id", cardId.toString())
                .append("card_number", cardNumber)
                .append("card_pin", cardPin)
                .append("type", cardType.toString().toUpperCase())
                .append("balance", balance)
                .append("account_id", accountId.toString())
                .append("active", active)
                .append("locked", locked);
        expectDoc.put("top_up", topUp.convertClassToDocument());
        ArrayList<Document> docTrips = new ArrayList<>();
        for(Trip trip: trips) {
            docTrips.add(trip.convertClassToDocument());
        }

        expectDoc.put("trips", docTrips);
        assertEquals(expectDoc, document);

    }


    /*Setter auto tests*/

    @Test
    public void testSetObjectIdMethod() {
        ObjectId expectedObjectId = new ObjectId();
        Card actualCard = this.expectedCard;
        actualCard.setObjectId(expectedObjectId);
        assertEquals(expectedObjectId, actualCard.getObjectId());
    }

    @Test
    public void testSetCardIdMethod() {
        UUID expectedCardId = UUID.randomUUID();
        this.expectedCard.setCardId(expectedCardId);
        assertEquals(expectedCardId, expectedCard.getCardId());
    }

    @Test
    public void testSetCardNumberMethod() {
        String expectedCardNumber = "0000222211113333";
        this.expectedCard.setCardNumber(expectedCardNumber);
        assertEquals(expectedCardNumber, expectedCard.getCardNumber());
    }

    @Test
    public void testSetCardPinMethod() {
        String expectedCardPin = "0000";
        Card actualCard = this.expectedCard;
        actualCard.setCardPin(expectedCardPin);
        assertEquals(expectedCardPin, actualCard.getCardPin());
    }

    @Test
    public void testSetCardTypeMethod() {
        CardType expectedType  = CardType.CHILD;
        Card actualCard = this.expectedCard;
        actualCard.setType(expectedType);
        assertEquals(expectedType, actualCard.getType());
    }

    @Test
    public void testSetCardBalanceMethod() {
        double expectedBalance = 100.0;
        Card actualCard = this.expectedCard;
        actualCard.setBalance(expectedBalance);
        assertEquals(expectedBalance, actualCard.getBalance(), 0);
    }

    @Test
    public void testSetAccountIdMethod() {
        UUID expectedAccountId = UUID.randomUUID();
        Card actualCard = this.expectedCard;
        actualCard.setAccountId(expectedAccountId);
        assertEquals(expectedAccountId, actualCard.getAccountId());
    }

    @Test
    public void testSetActiveMethod() {
        Card actualCard = this.expectedCard;
        actualCard.setActive(true);
        assertTrue(actualCard.isActive());
    }

    @Test
    public void testSetLockedMethod() {
        Card actualCard = this.expectedCard;
        actualCard.setLocked(true);
        assertTrue(actualCard.isLocked());
    }

    @Test
    public void testSetTopUpMethod() {
        Card actualCard = this.expectedCard;
        TopUp expectedTopUp = new TopUp(UUID.randomUUID(),true, 20, 10);
        actualCard.setTopUp(expectedTopUp);
        assertEquals(expectedTopUp, actualCard.getTopUp());
    }

    @Test
    public void testSetTopUpPaymentMethodIdMethod() {
        Card actualCard = this.expectedCard;
        UUID expectedPaymentMethodId = UUID.randomUUID();
        actualCard.setTopUpPaymentMethodId(expectedPaymentMethodId);
        assertEquals(expectedPaymentMethodId, actualCard.getTopUp().getPaymentMethodId());
    }


    @Test
    public void testSetTopUpEnabledMethod() {
        Card actualCard = this.expectedCard;
        actualCard.setTopUpEnabled(false);
        assertFalse(actualCard.getTopUp().isEnabled());
    }

    @Test
    public void testSetTopUpAmountMethod() {
        Card actualCard = this.expectedCard;
        double expectedAmount = 20.0;
        actualCard.setTopUpAmount(expectedAmount);
        assertEquals(expectedAmount, actualCard.getTopUp().getAmount(), 0);
    }

    @Test
    public void testSetTopUpWhenMethod() {
        Card actualCard = this.expectedCard;
        double expectedWhen = 15.0;
        actualCard.setTopUpWhen(expectedWhen);
        assertEquals(expectedWhen, actualCard.getTopUp().getWhen(), 0);
    }

    @Test
    public void testSetTripsMethod() {
        Card actualCard = this.expectedCard;
        ArrayList<Trip> expectedTrips = trips;
        expectedTrips.add(trip);
        actualCard.setTrips(expectedTrips);
        assertEquals(expectedTrips, actualCard.getTrips());
    }


    /*Getter auto tests*/

    @Test
    public void testGetObjectIdMethod() {
        assertEquals(objectId, expectedCard.getObjectId());
    }

    @Test
    public void testGetCardIdMethod() {
        assertEquals(cardId, expectedCard.getCardId());
    }

    @Test
    public void testGetCardNumberMethod() {
        assertEquals(cardNumber, expectedCard.getCardNumber());
    }

    @Test
    public void testGetCardPinMethod() {
        assertEquals(cardPin, expectedCard.getCardPin());
    }

    @Test
    public void testGetCardTypeMethod() {
        assertEquals(cardType, expectedCard.getType());
    }

    @Test
    public void testGetCardBalanceMethod() {
        assertEquals(balance, expectedCard.getBalance(), 0);
    }

    @Test
    public void testGetAccountIdMethod() {
        assertEquals(accountId, expectedCard.getAccountId());
    }

    @Test
    public void testGetIsActivateMethod() {
        assertEquals(active, expectedCard.isActive());
    }

    @Test
    public void testIsLockedMethod() {
        assertEquals(locked, expectedCard.isLocked());
    }

    @Test
    public void testGetTopUpMethod() {
        assertEquals(topUp, expectedCard.getTopUp());
    }

    @Test
    public void testGetTripsMethod() {
        assertEquals(trips, expectedCard.getTrips());
    }
}
