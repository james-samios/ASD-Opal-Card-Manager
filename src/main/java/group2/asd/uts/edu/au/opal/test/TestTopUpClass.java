package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.model.TopUp;
import org.bson.Document;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTopUpClass {

    //private final UUID paymentDetailsId = UUID.fromString("5653e70d-8291-4705-8140-291442652d58");
    private final boolean enabled = true;
    private final double amount = 10.0;
    private final double when = 5.0;

    /*create a new document and append all fields into the document*/
    //private final Document document = new Document("payment_details_id", paymentDetailsId)
    private final Document document = new Document()
            .append("enabled", enabled)
            .append("amount", amount)
            .append("when", when);

    private final TopUp expectedTopUp = new TopUp(document);
    @Test
    public void testTopUpConstructor() {
        /*Display the document*/
        System.out.println("Display the Document: " + document);
        /*create a new payment method by provided document*/

        TopUp actualTopUp = new TopUp(enabled, amount, when);
        assertEquals(expectedTopUp, actualTopUp);

        /*check each fields in paymentMethod object are equal to the ones that are put into the document*/
        //sertEquals(paymentDetailsId, topUp.getPaymentDetailsId());
        /*
        assertEquals(amount, topUp.getAmount() , 0);
        assertEquals(when, topUp.getWhen(), 0);
        assertEquals(enabled, topUp.isEnabled());

         */
    }

    @Test
    public void testConvertClassToDocument() {
        Document actualTopUpDocument = expectedTopUp.convertClassToDocument();
        assertEquals(document, actualTopUpDocument);
    }

    @Test
    public void testGetEnabledMethod() {
        assertEquals(enabled, expectedTopUp.isEnabled());
    }

    @Test
    public void testGetAmountMethod() {
        assertEquals(amount, expectedTopUp.getAmount(), 0);
    }

    @Test
    public void testGetWhenMethod() {
        assertEquals(when, expectedTopUp.getWhen(), 0);
    }



}
