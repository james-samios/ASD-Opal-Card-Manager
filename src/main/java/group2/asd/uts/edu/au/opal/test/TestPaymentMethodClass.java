package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.model.PaymentMethod;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.UUID;
import static org.junit.Assert.assertEquals;

public class TestPaymentMethodClass {

    private final ObjectId objectId = new ObjectId("612ed59a56cb54f515475557");
    private final UUID paymentMethodId = UUID.fromString("5653e70d-8291-4705-8140-291442652d58");
    private final UUID opalCardId = UUID.fromString("f4e2cf7d-0dcd-4db6-bfc0-5625c5da3254");
    private final long cardNumber = Long.parseLong("1234567812345678");
    private final String cardName = "John Smith";
    private final int cardCvc = 999;
    private final String expiryDate = "10/21";

    /*create a new document and append all fields into the document*/
    private final Document document = new Document("_id", objectId)
            .append("payment_method_id", paymentMethodId)
            .append("opal_card_id", opalCardId)
            .append("card_number", cardNumber)
            .append("card_name", cardName)
            .append("cvc", cardCvc)
            .append("expiry_date", expiryDate);

    private final PaymentMethod paymentMethod = new PaymentMethod(
            "5653e70d-8291-4705-8140-291442652d58",
            "f4e2cf7d-0dcd-4db6-bfc0-5625c5da3254",
            "1234567812345678",
            "John Smith",
            "999",
            "10/21"
    );

    @Test
    public void testPaymentMethodConstructor() {
        /*Display the document*/
        System.out.println("Display the Document: " + document);

        /*create a new payment method by provided document*/
        PaymentMethod expectedPaymentMethod = new PaymentMethod(document);
        PaymentMethod actualPaymentMethod = paymentMethod;
        actualPaymentMethod.setObjectId(objectId);
        assertEquals(expectedPaymentMethod, actualPaymentMethod);
    }

    @Test
    public void testPaymentMethodConvertToDocument() {
        PaymentMethod paymentMethod = new PaymentMethod(document);
        Document paymentMethodDoc = paymentMethod.convertClassToDocument().append("_id", document.get("_id"));
        assertEquals(document, paymentMethodDoc);

    }

    /*Auto tests for getters*/
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


}
