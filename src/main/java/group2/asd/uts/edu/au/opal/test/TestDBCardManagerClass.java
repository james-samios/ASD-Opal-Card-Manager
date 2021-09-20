package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.dao.DBCardsManager;

import group2.asd.uts.edu.au.opal.model.Card;
import group2.asd.uts.edu.au.opal.model.CardType;
import group2.asd.uts.edu.au.opal.model.TopUp;
import group2.asd.uts.edu.au.opal.model.Trip;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import static org.junit.Assert.*;
public class TestDBCardManagerClass {
    private final DBCardsManager dbCardsManager = new DBCardsManager();
    private final UUID cardId = UUID.randomUUID();
    final String cardNumber = "0000222244446666";
    final String cardPin = "0246";
    final CardType cardType = CardType.ADULT;
    final double balance = 100.0;
    final UUID accountId = UUID.randomUUID();
    final boolean active = false;
    final boolean locked = false;
    final TopUp topUp = new TopUp(UUID.randomUUID(), false, 10, 5);
    final Trip trip = new Trip("Kings Cross", "Bondi Junction",
            Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
    final ArrayList<Trip> trips = new ArrayList<Trip>() {{
        add(trip);
    }};

    final Card expectedCard = new Card(new ObjectId(), cardId, cardNumber, cardPin,
            cardType, balance, accountId, active,
            locked, topUp, trips);


    @Test
    public void testCreateOpalCard() {

        /*Test DBCardManager createOpalCard method*/
        System.out.println("Test DBCardManager createOpalCard method...");
        dbCardsManager.createOpalCard(expectedCard);

        /*Test DBCardManager readCardByNumberAndPin method*/
        System.out.println("Test DBCardManager readCardByNumberAndPin method...");
        Card actualCard = dbCardsManager.readCardByNumberAndPin(cardNumber, cardPin);
        expectedCard.setObjectId(actualCard.getObjectId());
        assertEquals(expectedCard, actualCard);

        /*Test DBCardManager readCardByObjectId method*/
        System.out.println("Test DBCardManager readCardByObjectId method...");
        actualCard = dbCardsManager.readCardByObjectId(actualCard.getObjectId());
        assertEquals(expectedCard, actualCard);

        /*Test DBCardManager readCardByCardId method*/
        System.out.println("Test DBCardManager readCardByCardId method...");
        actualCard = dbCardsManager.readCardByCardId(cardId.toString());
        assertEquals(expectedCard, actualCard);

        /*Test DBCardManager updateCardBalance method*/
        System.out.println("Test DBCardManager updateCardBalance method...");
        double expectedAmount = 150.0;
        expectedCard.setBalance(expectedAmount);
        dbCardsManager.updateCardBalance(actualCard.getObjectId(), expectedAmount);
        actualCard = dbCardsManager.readCardByCardId(cardId.toString());
        assertEquals(expectedCard, actualCard);

        /*Test DBCardManager updateCardActive method*/
        System.out.println("Test DBCardManager updateCardActive method...");
        expectedCard.setActive(true);
        dbCardsManager.updateCardActive(expectedCard.getObjectId(), true);
        actualCard = dbCardsManager.readCardByCardId(cardId.toString());
        assertEquals(expectedCard, actualCard);

        /*Test DBCardManager updateAccountId method*/
        System.out.println("Test DBCardManager updateAccountId method...");
        UUID expectedAccountId = UUID.randomUUID();
        expectedCard.setAccountId(expectedAccountId);
        dbCardsManager.updateAccountId(expectedCard.getObjectId(), expectedAccountId);
        actualCard = dbCardsManager.readCardByCardId(cardId.toString());
        assertEquals(expectedCard, actualCard);

        /*Test DBCardManager updateCardType method*/
        System.out.println("Test DBCardManager updateCardType method...");
        CardType expectedCardType = CardType.ADULT;
        expectedCard.setType(expectedCardType);
        dbCardsManager.updateCardType(expectedCard.getObjectId(), expectedCardType.toString().toUpperCase());
        actualCard = dbCardsManager.readCardByCardId(cardId.toString());
        assertEquals(expectedCard, actualCard);

        /*Test DBCardManager updateCardTopUp method*/
        System.out.println("Test DBCardManager updateCardTopUp method...");
        TopUp topUp = new TopUp(UUID.randomUUID(), true, 50.0, 10.0);
        expectedCard.setTopUp(topUp);
        dbCardsManager.updateCardTopUp(expectedCard.getObjectId(), topUp);
        actualCard = dbCardsManager.readCardByCardId(cardId.toString());
        assertEquals(expectedCard, actualCard);

        /*Test DBCardManager updateCardTrips method*/
        System.out.println("Test DBCardManager updateCardTrips method...");
        ArrayList<Trip> expectedTrips = new ArrayList<>();
        Trip newTrip = new Trip("Padstow", "Bondi",
                Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
        expectedTrips.add(newTrip);
        expectedCard.setTrips(expectedTrips);
        dbCardsManager.updateCardTrips(expectedCard.getObjectId(), expectedCard.getArrayListOfDocumentOfTrips());
        actualCard = dbCardsManager.readCardByCardId(cardId.toString());
        assertEquals(expectedCard, actualCard);


        /*Test DBCardManager deleteCardByObjectId method*/
        System.out.println("Test DBCardManager deleteCardByObjectId method...");
        dbCardsManager.deleteCardByObjectId(actualCard.getObjectId());
        dbCardsManager.readAllCards();
        actualCard = dbCardsManager.readCardByCardId(cardId.toString());
        assertNull(actualCard);

    }

}
