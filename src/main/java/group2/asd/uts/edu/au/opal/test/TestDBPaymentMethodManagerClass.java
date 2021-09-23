package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.dao.DBPaymentMethodManager;
import group2.asd.uts.edu.au.opal.model.PaymentMethod;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.UUID;

public class TestDBPaymentMethodManagerClass {
    private final DBPaymentMethodManager dbPaymentMethodManager;
    private final String paymentMethodId;
    private final String opalCardId;
    private final String cardNumber;
    private final String cardName;
    private final String cardCvc;
    private final String expiryDate;
    private final PaymentMethod expectedPaymentMethod;
    private PaymentMethod actualPaymentMethod;

    public TestDBPaymentMethodManagerClass() {
        paymentMethodId = UUID.randomUUID().toString();
        opalCardId = UUID.randomUUID().toString();
        cardNumber = "0000000000000000";
        cardName = "Yeh";
        cardCvc = "000";
        expiryDate = "12/25";
        expectedPaymentMethod = new PaymentMethod(paymentMethodId, opalCardId, cardNumber,
                cardName, cardCvc, expiryDate);
        dbPaymentMethodManager = new DBPaymentMethodManager();
    }

    @Test
    public void testCreatePaymentMethod() {
        generateInstanceOnTable();
        dbPaymentMethodManager.deletePaymentByObjectId(expectedPaymentMethod.getObjectId());
        assertEquals(expectedPaymentMethod, actualPaymentMethod);
    }



    @Test
    public void testReadPaymentByObjectId() {
        generateInstanceOnTable();
        dbPaymentMethodManager.deletePaymentByObjectId(expectedPaymentMethod.getObjectId());
        assertEquals(expectedPaymentMethod, actualPaymentMethod);
    }

    @Test
    public void testReadPaymentMethodByPaymentMethodId() {
        generateInstanceOnTable();
        actualPaymentMethod = dbPaymentMethodManager.readPaymentMethodByPaymentMethodId(paymentMethodId);
        dbPaymentMethodManager.deletePaymentByObjectId(expectedPaymentMethod.getObjectId());
        assertEquals(expectedPaymentMethod, actualPaymentMethod);
    }

    @Test
    public void testReadPaymentMethodByNumberAndCVC() {
        generateInstanceOnTable();
        actualPaymentMethod = dbPaymentMethodManager.readPaymentMethodByNumberAndCVC(cardNumber, cardCvc);
        dbPaymentMethodManager.deletePaymentByObjectId(expectedPaymentMethod.getObjectId());
        assertEquals(expectedPaymentMethod, actualPaymentMethod);
    }

    @Test
    public void testUpdatePaymentMethodByProvidedObjectId() {
        generateInstanceOnTable();
        UUID expectedPaymentMethodId = UUID.randomUUID();
        UUID expectedOpalCardId = UUID.randomUUID();
        String expectedCardNumber = "1111333311113333";
        String expectedCardName = "Tzu Jung";
        String expectedCardCvc = "123";
        String expectedExpiryDate = "12/24";


        expectedPaymentMethod.setPaymentMethodId(expectedPaymentMethodId);
        expectedPaymentMethod.setOpalCardId(expectedOpalCardId);
        expectedPaymentMethod.setCardNumber(expectedCardNumber);
        expectedPaymentMethod.setCardName(expectedCardName);
        expectedPaymentMethod.setCardCVC(expectedCardCvc);
        expectedPaymentMethod.setExpiryDate(expectedExpiryDate);
        dbPaymentMethodManager.updatePaymentMethod(expectedPaymentMethod);
        actualPaymentMethod = dbPaymentMethodManager.readPaymentByObjectId(expectedPaymentMethod.getObjectId());
        dbPaymentMethodManager.deletePaymentByObjectId(expectedPaymentMethod.getObjectId());
        assertEquals(expectedPaymentMethod, actualPaymentMethod);
    }

    @Test
    public void testDeletePaymentByObjectId() {
        generateInstanceOnTable();
        dbPaymentMethodManager.deletePaymentByObjectId(expectedPaymentMethod.getObjectId());
        actualPaymentMethod = dbPaymentMethodManager.readPaymentMethodByPaymentMethodId(paymentMethodId);
        assertNull(actualPaymentMethod);
    }


    @Test
    public void testDeletePaymentByPaymentMethodId() {
        generateInstanceOnTable();
        dbPaymentMethodManager.deletePaymentByPaymentMethodId(paymentMethodId);
        actualPaymentMethod = dbPaymentMethodManager.readPaymentMethodByPaymentMethodId(paymentMethodId);
        assertNull(actualPaymentMethod);
    }



    public void generateInstanceOnTable() {
        dbPaymentMethodManager.createPaymentMethod(expectedPaymentMethod);
        actualPaymentMethod = dbPaymentMethodManager.readPaymentMethodByPaymentMethodId(paymentMethodId);
        expectedPaymentMethod.setObjectId(actualPaymentMethod.getObjectId());
    }


}
