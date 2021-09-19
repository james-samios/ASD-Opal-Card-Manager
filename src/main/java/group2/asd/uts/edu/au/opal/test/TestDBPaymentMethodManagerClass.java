package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.dao.DBPaymentMethodManager;
import group2.asd.uts.edu.au.opal.model.PaymentMethod;
import org.bson.types.ObjectId;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.UUID;

public class TestDBPaymentMethodManagerClass {
    private final DBPaymentMethodManager dbPaymentMethodManager = new DBPaymentMethodManager();
    private String paymentMethodId = UUID.randomUUID().toString();
    private String opalCardId = UUID.randomUUID().toString();
    private String cardNumber = "0000000000000000";
    private String cardName = "Yeh";
    private String cardCvc = "000";
    private String expiryDate = "12/25";


    @Test
    public void testCreatePaymentMethod() {
        PaymentMethod expectedPaymentMethod = new PaymentMethod(paymentMethodId, opalCardId, cardNumber,
                cardName, cardCvc, expiryDate);
        /*Test DBPaymentMethodManager createPaymentMethod method*/
        ObjectId objectId;
        System.out.println("Test DBPaymentMethodManager createPaymentMethod method...");
        dbPaymentMethodManager.createPaymentMethod(expectedPaymentMethod);
        PaymentMethod actualPaymentMethod = dbPaymentMethodManager.readPaymentMethodByPaymentMethodId(paymentMethodId);
        objectId = actualPaymentMethod.getObjectId();
        expectedPaymentMethod.setObjectId(objectId);
        assertEquals(expectedPaymentMethod, actualPaymentMethod);

        /*Test DBPaymentMethodManager readPaymentByObjectId method*/
        System.out.println("Test DBPaymentMethodManager readPaymentByObjectId method...");
        PaymentMethod getPaymentByObjectId =
                dbPaymentMethodManager.readPaymentByObjectId(objectId);
        assertEquals(expectedPaymentMethod, getPaymentByObjectId);

        /*Test DBPaymentMethodManager readPaymentMethodByPaymentMethodId method*/
        System.out.println("Test DBPaymentMethodManager readPaymentMethodByPaymentMethodId method...");
        PaymentMethod getPaymentByPaymentMethodId =
                dbPaymentMethodManager.readPaymentMethodByPaymentMethodId(paymentMethodId);
        assertEquals(expectedPaymentMethod, getPaymentByPaymentMethodId);

        /*Test DBPaymentMethodManager readPaymentMethodByNumberAndCVC method*/
        System.out.println("Test DBPaymentMethodManager readPaymentMethodByNumberAndCVC method...");
        PaymentMethod getPaymentByCardNumberAndCvc =
                dbPaymentMethodManager.readPaymentMethodByNumberAndCVC(cardNumber, cardCvc);
        assertEquals(expectedPaymentMethod, getPaymentByCardNumberAndCvc);

        /*Test DBPaymentMethodManager updatePaymentMethodByProvidedObjectId method*/
        System.out.println("Test DBPaymentMethodManager updatePaymentMethodByProvidedObjectId method...");
        paymentMethodId = UUID.randomUUID().toString();
        opalCardId = UUID.randomUUID().toString();
        cardNumber = "1111333311113333";
        cardName = "Tzu Jung";
        cardCvc = "123";
        expiryDate = "12/24";
        /*Update expectedPaymentMethod information*/
        expectedPaymentMethod.setPaymentMethodId(UUID.fromString(paymentMethodId));
        expectedPaymentMethod.setOpalCardId(UUID.fromString(opalCardId));
        expectedPaymentMethod.setCardNumber(cardNumber);
        expectedPaymentMethod.setCardName(cardName);
        expectedPaymentMethod.setCardCVC(cardCvc);
        expectedPaymentMethod.setExpiryDate(expiryDate);
        dbPaymentMethodManager.updatePaymentMethodByProvidedObjectId(expectedPaymentMethod);
        PaymentMethod getMethodByObjectId = dbPaymentMethodManager.readPaymentByObjectId(objectId);
        assertEquals(expectedPaymentMethod, getMethodByObjectId);

        /*Test DBPaymentMethodManager deletePaymentByObjectId method*/
        System.out.println("Test DBPaymentMethodManager deletePaymentByObjectId method...");
        dbPaymentMethodManager.deletePaymentByObjectId(objectId);
        PaymentMethod getPaymentMethod = dbPaymentMethodManager.readPaymentByObjectId(objectId);
        assertNull(getPaymentMethod);

    }
}
