package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.model.PaymentMethod;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.UUID;
import static org.junit.Assert.assertEquals;

public class TestPaymentMethodClass {

    private final ObjectId objectId = new ObjectId("6147405173eeae77825d8320");
    private final UUID paymentMethodId = UUID.fromString("adc8a0e8-eda8-4ac1-989c-c82407d008e1");
    private final UUID opalCardId = UUID.fromString("8c7eda3f-ab45-4c82-9ba8-a462043f1dde");
    private final String cardNumber = "8765432112345678";
    private final String cardName = "Tzu Jung Yeh";
    private final String cardCvc = "000";
    private final String expiryDate = "12/21";

    /*create a new document and append all fields into the document*/
    private final Document document = new Document("_id", objectId)
            .append("payment_method_id", paymentMethodId.toString())
            .append("opal_card_id", opalCardId.toString())
            .append("card_number", cardNumber)
            .append("card_name", cardName)
            .append("cvc", cardCvc)
            .append("expiry_date", expiryDate);

    private final PaymentMethod paymentMethod = new PaymentMethod(
            UUID.fromString("adc8a0e8-eda8-4ac1-989c-c82407d008e1"),
            UUID.fromString("8c7eda3f-ab45-4c82-9ba8-a462043f1dde"),
            "8765432112345678",
            "Tzu Jung Yeh",
            "000",
            "12/21"
    );
    /*
    @Test
    public void testPaymentMethodConstructor() {

        System.out.println("Display the Document: " + document);


        PaymentMethod expectedPaymentMethod = new PaymentMethod(document);
        PaymentMethod actualPaymentMethod = paymentMethod;
        actualPaymentMethod.setObjectId(objectId);
        assertEquals(expectedPaymentMethod, actualPaymentMethod);
    }*/
    /*
    @Test
    public void testPaymentMethodConvertToDocument() {
        PaymentMethod paymentMethod = new PaymentMethod(document);
        Document paymentMethodDoc = paymentMethod.convertClassToDocument().append("_id", document.get("_id"));
        assertEquals(document, paymentMethodDoc);

    }*/

    /*Auto tests for getters*/
    /*
    @Test
    public void testGetPaymentMethodIdMethod() {
        assertEquals(paymentMethodId, paymentMethod.getPaymentMethodId());
    }

    @Test
    public void testGetOpalCardIdMethod() {
        assertEquals(opalCardId, paymentMethod.getOpalCardId());
    }

    @Test
    public void testGetCardNumberMethod() {
        assertEquals(cardNumber, paymentMethod.getCardNumber());
    }

    @Test
    public void testGetCardNameMethod() {
        assertEquals(cardName, paymentMethod.getCardName());
    }

    @Test
    public void testGetCardCvcMethod() {
        assertEquals(cardCvc, paymentMethod.getCardCVC());
    }

    @Test
    public void testGetCardExpiryMethod() {
        assertEquals(expiryDate, paymentMethod.getExpiryDate());
    }

    */
}
