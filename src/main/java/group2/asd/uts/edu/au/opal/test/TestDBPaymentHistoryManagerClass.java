package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.dao.DBPaymentHistoryManager;
import group2.asd.uts.edu.au.opal.model.PaymentHistory;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class TestDBPaymentHistoryManagerClass {
    private final UUID paymentMethodId = UUID.randomUUID();
    private final UUID cardId = UUID.randomUUID();
    private final double amount = 20.0;
    private final String status = "Complete";
    private final String paymentMethod = "CREDIT_CARD";
    private final Date paymentDate = Calendar.getInstance().getTime();
    private PaymentHistory paymentHistory = new PaymentHistory(paymentMethodId, cardId, amount, status, paymentMethod, paymentDate);


    @Test
    public void testCreatePaymentHistoryMethod() {
        DBPaymentHistoryManager dbPaymentHistoryManager = new DBPaymentHistoryManager();
        dbPaymentHistoryManager.createPaymentHistory(paymentHistory);
        PaymentHistory actualPaymentHistory =
                dbPaymentHistoryManager.readAPaymentHistoryByProvidedPaymentMethodId(paymentMethodId);
        paymentHistory.setObjectId(actualPaymentHistory.getObjectId());
        dbPaymentHistoryManager.deletePaymentHistoryByProvidedPaymentId(paymentMethodId);
        assertEquals(paymentHistory, actualPaymentHistory);
    }

    @Test
    public void testReadPaymentHistoryByProvidedPaymentMethodIdMethod() {
        DBPaymentHistoryManager dbPaymentHistoryManager = new DBPaymentHistoryManager();
        dbPaymentHistoryManager.createPaymentHistory(paymentHistory);
        PaymentHistory actualPaymentHistory =
                dbPaymentHistoryManager.readAPaymentHistoryByProvidedPaymentMethodId(paymentMethodId);
        paymentHistory.setObjectId(actualPaymentHistory.getObjectId());
        dbPaymentHistoryManager.deletePaymentHistoryByProvidedPaymentId(paymentMethodId);
        assertEquals(paymentHistory, actualPaymentHistory);
    }

}
