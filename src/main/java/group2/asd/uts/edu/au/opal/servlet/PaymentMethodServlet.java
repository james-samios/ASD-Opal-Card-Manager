package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBPaymentMethodManager;
import group2.asd.uts.edu.au.opal.model.Customer;
import group2.asd.uts.edu.au.opal.model.PaymentMethod;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "PaymentMethodServlet", value = "/PaymentMethodServlet")
public class PaymentMethodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //first, last, dob, pay,
        // pay: card, paypal
        // card: =>card_number, cvc, expiry_date
        // paypal: => paypal_email, password, passwordConfirm

        DBPaymentMethodManager dbPaymentMethodManager = new DBPaymentMethodManager();

        HttpSession session = req.getSession();
        Customer currentUser = (Customer) session.getAttribute("customer");
        if (currentUser == null) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        String firstName = req.getParameter("name");
        String lastName = req.getParameter("last");

        String fullName = firstName + " " + lastName;
        String pay = req.getParameter("pay");
        String method = req.getParameter("method");
        // Card properties
        String name = req.getParameter("name");
        String cardNumber = req.getParameter("card_number");
        String cardCVC = req.getParameter("cvc");
        String expiryDate = req.getParameter("expiry_date");
        if (method == null) {
        } else if (method.equals("delete")) {
            String card = req.getParameter("card");
            dbPaymentMethodManager.deletePaymentMethodByID(card);
            req.getRequestDispatcher("/payment.jsp").forward(req, resp);
        } else if (method.equals("add")) {
            String customer = req.getParameter("customer");
            name = firstName + " " + lastName;
            PaymentMethod paymentMethod = new PaymentMethod(UUID.randomUUID(), UUID.fromString(customer), cardNumber, name, cardCVC, expiryDate);
            if (!validateCreditCardNumber(cardNumber, cardCVC)) {
                session.setAttribute("error", "Invalid credit card info");
//                req.getRequestDispatcher("/payment.jsp").forward(req, resp);
//                return;
            }

            dbPaymentMethodManager.createPaymentMethod(paymentMethod);
            session.setAttribute("card", paymentMethod);
            req.getRequestDispatcher("/paymentDetails.jsp").forward(req, resp);

        } else if (method.equals("update")) {
            String customer = req.getParameter("customer");
            String card_id = req.getParameter("card_id");
            PaymentMethod paymentMethod = new PaymentMethod(UUID.randomUUID(), UUID.fromString(customer), cardNumber, name, cardCVC, expiryDate);
            paymentMethod.setObjectId(new ObjectId(card_id));
            dbPaymentMethodManager.deletePaymentMethodByID(card_id);
            dbPaymentMethodManager.createPaymentMethod(paymentMethod);

            session.setAttribute("card", paymentMethod);
            req.getRequestDispatcher("/paymentDetails.jsp").forward(req, resp);
        } else if (pay.equals("paypal")) {
            String email = req.getParameter("paypal_email");
            String password = req.getParameter("password");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Customer currentUser = (Customer) session.getAttribute("customer");
        if (currentUser == null) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        String card = req.getParameter("card");
        if (card == null) {
            req.getRequestDispatcher("/payment.jsp").forward(req, resp);
        } else if (card.equals("all")) {
            UUID paymentUUID = UUID.fromString(currentUser.getAccountId().toString());

            DBPaymentMethodManager dbPaymentMethodManager = new DBPaymentMethodManager();
            List<PaymentMethod> paymentMethods = dbPaymentMethodManager.readPaymentByCustomerId(paymentUUID);
            if (paymentMethods == null || paymentMethods.size()<1) {
                paymentMethods = dbPaymentMethodManager.readPayments();
            }

            req.getSession().setAttribute("cards", paymentMethods);
            req.getRequestDispatcher("/paymentMethods.jsp").forward(req, resp);
        } else {
            DBPaymentMethodManager dbPaymentMethodManager = new DBPaymentMethodManager();
            PaymentMethod paymentMethod = dbPaymentMethodManager.readPaymentMethodByCardNumber(card);

            session.setAttribute("card", paymentMethod);
            req.getRequestDispatcher("/payment_edit.jsp").forward(req, resp);
        }
    }

    private static boolean validateCreditCardNumber(String str, String cvc) {
        if (cvc.length() != 3) {
            return false;
        }
        int sum = 0;
        boolean alternate = false;
        for (int i = str.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(str.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);

    }
}
