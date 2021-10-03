package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.model.PaymentHistory;
import org.bson.Document;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class TestPaymentHistoryClass {
    private final UUID paymentMethodId = UUID.randomUUID();
    private final UUID cardId = UUID.randomUUID();
    private final double amount = 10.0;
    private final String status = "Complete";
    private final Date paymentDate = Calendar.getInstance().getTime();
    private final String paymentMethod = "CREDIT_CARD";

    private final Document document = new Document("payment_id", paymentMethodId.toString())
            .append("card_id", cardId.toString())
            .append("amount", amount)
            .append("status", status)
            .append("payment_date", paymentDate)
            .append("payment_method", paymentMethod);

    private final PaymentHistory paymentHistory = new PaymentHistory(document);

    @Test
    public void testPaymentHistoryConvertToDocument() {
        Document actualDocument = paymentHistory.convertClassToDocument();
        assertEquals(document, actualDocument);

    }

    /*Auto tests for getters*/
    @Test
    public void testGetPaymentHistoryIdMethod() {
        assertEquals(paymentMethodId, paymentHistory.getPaymentId());
    }

    @Test
    public void testGetCardIdMethod() {
        assertEquals(cardId, paymentHistory.getCardId());
    }

    @Test
    public void testGetAmountMethod() {
        assertEquals(amount, paymentHistory.getAmount(), 0);
    }

    @Test
    public void testGetStatusMethod() {
        assertEquals(status, paymentHistory.getStatus());
    }

    @Test
    public void testGetPaymentDateMethod() {
        assertEquals(paymentDate, paymentHistory.getPaymentDate());
    }

    @Test
    public void testGetPaymentMethodMethod() {
        assertEquals(paymentMethod, paymentHistory.getPaymentMethod());
    }

}
