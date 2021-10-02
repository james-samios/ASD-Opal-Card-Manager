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

    private final DBCardsManager dbCardsManager;
    private final UUID cardId = UUID.randomUUID();
    private final Trip trip = new Trip("Kings Cross", "Bondi Junction",
            Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
    private final ArrayList<Trip> trips = new ArrayList<Trip>() {{
        add(trip);
    }};

    private final Card expectedCard = new Card(new ObjectId(), cardId, "0000222244446666",
            "0246",
            CardType.ADULT,
            100.0,
            UUID.randomUUID(),
            false,
            false,
            new TopUp(UUID.randomUUID(), false, 10, 5),
            trips);
    private Card actualCard;

    public TestDBCardManagerClass () {
        dbCardsManager = new DBCardsManager();
    }

    @Test
    public void testCreateOpalCard() {
        /*create a new opal card to the table*/
        generateCardAndUpdateExpectedCardAndActualCard();
        /*Delete Card*/
        dbCardsManager.deleteCardByObjectId(expectedCard.getObjectId());
        /*Test*/
        assertEquals(expectedCard, actualCard);
        /*Rest actual card to null*/
        actualCard = null;
    }

    @Test
    public void testReadCardByObjectId() {
        /*create a new opal card to the table*/
        generateCardAndUpdateExpectedCardAndActualCard();
        /*Read Card*/
        actualCard = dbCardsManager.readCardByObjectId(expectedCard.getObjectId());
        /*Delete Card*/
        dbCardsManager.deleteCardByObjectId(expectedCard.getObjectId());
        /*Test*/
        assertEquals(expectedCard, actualCard);
        /*Rest actual card to null*/
        actualCard = null;
    }

    @Test
    public void testReadCardByCardId() {
        /*create a new opal card to the table*/
        generateCardAndUpdateExpectedCardAndActualCard();
        /*Read Card*/
        actualCard = dbCardsManager.readCardByCardId(expectedCard.getCardId().toString());
        /*Delete Card*/
        dbCardsManager.deleteCardByObjectId(expectedCard.getObjectId());
        /*Test*/
        assertEquals(expectedCard, actualCard);

    }

    @Test
    public void testReadCardByNumberAndPin() {
        /*create a new opal card to the table*/
        generateCardAndUpdateExpectedCardAndActualCard();
        /*Read Card*/
        actualCard = dbCardsManager.readCardByNumberAndPin(expectedCard.getCardNumber(), expectedCard.getCardPin());
        /*Delete Card*/
        dbCardsManager.deleteCardByObjectId(expectedCard.getObjectId());
        /*Test*/
        assertEquals(expectedCard, actualCard);

    }

    @Test
    public void testUpdateCardActive() {
        /*create a new opal card to the table*/
        generateCardAndUpdateExpectedCardAndActualCard();
        /*Update active of the expectedCard*/
        expectedCard.setActive(true);
        /*Update the instance on Table with the true value of active*/
        dbCardsManager.updateCardActive(expectedCard.getObjectId(), true);
        /*Read Card*/
        actualCard = dbCardsManager.readCardByObjectId(expectedCard.getObjectId());
        /*Delete Card*/
        dbCardsManager.deleteCardByObjectId(expectedCard.getObjectId());
        /*Test*/
        assertEquals(expectedCard, actualCard);

    }

    @Test
    public void testUpdateCardBalance() {
        /*create a new opal card to the table*/
        generateCardAndUpdateExpectedCardAndActualCard();
        /*Initialise new balance for testing*/
        double expectedAmount = 150.0;
        /*Set new balance into expectedCard*/
        expectedCard.setBalance(expectedAmount);
        /*Update the instance on Table with the new balance*/
        dbCardsManager.updateCardBalance(expectedCard.getObjectId(), expectedAmount);
        /*Read the actualCard*/
        actualCard = dbCardsManager.readCardByObjectId(expectedCard.getObjectId());
        /*Delete the card*/
        dbCardsManager.deleteCardByObjectId(expectedCard.getObjectId());
        /*Test two objects are the same or not*/
        assertEquals(expectedCard, actualCard);

    }

    @Test
    public void testUpdateAccountId() {
        /*create a new opal card to the table*/
        generateCardAndUpdateExpectedCardAndActualCard();
        /*Initialise new account ID for testing*/
        UUID expectedAccountId = UUID.randomUUID();
        /*set account ID into expectedCard for comparison*/
        expectedCard.setAccountId(expectedAccountId);
        /*Update account ID of the instance on table*/
        dbCardsManager.updateAccountId(expectedCard.getObjectId(), expectedAccountId);
        /*Read the actualCard*/
        actualCard = dbCardsManager.readCardByObjectId(expectedCard.getObjectId());
        /*Delete the card*/
        dbCardsManager.deleteCardByObjectId(expectedCard.getObjectId());
        /*Test two objects are the same or not*/
        assertEquals(expectedCard, actualCard);

    }

    @Test
    public void testUpdateCardType() {
        /*create a new opal card to the table*/
        generateCardAndUpdateExpectedCardAndActualCard();
        /*Initialise new card type for testing*/
        CardType expectedCardType = CardType.ADULT;
        /*set the card type into expectedCard for comparison*/
        expectedCard.setType(expectedCardType);
        /*Update card type of the instance on table*/
        dbCardsManager.updateCardType(expectedCard.getObjectId(), expectedCardType.toString().toUpperCase());
        /*Read the actualCard*/
        actualCard = dbCardsManager.readCardByObjectId(expectedCard.getObjectId());
        /*Delete the card*/
        dbCardsManager.deleteCardByObjectId(expectedCard.getObjectId());
        /*Test two objects are the same or not*/
        assertEquals(expectedCard, actualCard);

    }

    @Test
    public void testUpdateCardTopUp() {
        /*create a new opal card to the table*/
        generateCardAndUpdateExpectedCardAndActualCard();
        /*Initialise new top up for testing*/
        TopUp topUp = new TopUp(UUID.randomUUID(), true, 50.0, 10.0);
        /*set the top up into expectedCard for comparison*/
        expectedCard.setTopUp(topUp);
        /*Update card type of the instance on table*/
        dbCardsManager.updateCardTopUp(expectedCard.getObjectId(), topUp);
        /*Read the actualCard*/
        actualCard = dbCardsManager.readCardByObjectId(expectedCard.getObjectId());
        /*Delete the card*/
        dbCardsManager.deleteCardByObjectId(expectedCard.getObjectId());
        /*Test two objects are the same or not*/
        assertEquals(expectedCard, actualCard);

    }

    @Test
    public void testUpdateCardTrips() {
        /*create a new opal card to the table*/
        generateCardAndUpdateExpectedCardAndActualCard();
        /*Initialise new trips up for testing*/
        ArrayList<Trip> expectedTrips = new ArrayList<>();
        Trip newTrip = new Trip("Padstow", "Bondi",
                Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
        expectedTrips.add(newTrip);
        /*set the trips into expectedCard for comparison*/
        expectedCard.setTrips(expectedTrips);
        /*Update the trips of the instance on table*/
        dbCardsManager.updateCardTrips(expectedCard.getObjectId(), expectedCard.getArrayListOfDocumentOfTrips());
        /*Read card*/
        actualCard = dbCardsManager.readCardByObjectId(expectedCard.getObjectId());
        /*Delete the card*/
        dbCardsManager.deleteCardByObjectId(expectedCard.getObjectId());
        /*Test two objects are the same or not*/
        assertEquals(expectedCard, actualCard);

    }

    @Test
    public void testDeleteCardByObjectId() {
        /*create a new opal card to the table*/
        generateCardAndUpdateExpectedCardAndActualCard();
        /*Delete the card*/
        dbCardsManager.deleteCardByObjectId(expectedCard.getObjectId());
        /*Read card*/
        actualCard = dbCardsManager.readCardByObjectId(expectedCard.getObjectId());
        /*Test card which is removed from table*/
        assertNull(actualCard);
        /*Rest actual card to null*/
    }

    public void generateCardAndUpdateExpectedCardAndActualCard() {
        dbCardsManager.createOpalCard(expectedCard);
        actualCard = dbCardsManager.readCardByCardId(expectedCard.getCardId().toString());
        expectedCard.setObjectId(actualCard.getObjectId());
    }
}