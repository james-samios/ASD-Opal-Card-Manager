package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.dao.DBCustomerManager;
import group2.asd.uts.edu.au.opal.dao.DBPaymentMethodManager;
import group2.asd.uts.edu.au.opal.model.Card;
import group2.asd.uts.edu.au.opal.model.Customer;
import group2.asd.uts.edu.au.opal.model.PaymentMethod;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CardLoginServlet extends HttpServlet {
    // This method is called by the servlet container to process a 'post' request
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        //retrieve the current session
        HttpSession session = req.getSession();

        //create an instance of the Validator class
        Validator validator = new Validator();

        //initialise all messages in session
        validator.clean(session);

        //Create the card DBManager
        DBCardsManager dbCardsManager = new DBCardsManager();

        // Reading post parameters from the request
        String cardNumber = req.getParameter("card_number");
        String cardPin = req.getParameter("card_pin");

        // Checking for null and empty values
        if(!validator.validateCardNumber(cardNumber)) {
            /*store error message of the type of card number*/
            session.setAttribute("cardNumberFormErr", "Error: 16 digits for card number");

            /*call method to store previous input and then push view to /opalcard.jsp*/
            setPreviousInput(session, req, resp, cardNumber, cardPin);
        } else if(!validator.validateCardPin(cardPin)) {
            /*store error message of the type of card Pin*/
            session.setAttribute("cardPinFormErr", "Error: 4 digits for card pin");

            /*call method to store previous input and then push view to /opalcard.jsp*/
            setPreviousInput(session, req, resp, cardNumber, cardPin);
        } else {
            //Get customer data by calling API
            Card card = dbCardsManager.readCardByNumberAndPin(cardNumber, cardPin);

            //Check the customer is found or not
            boolean isCardFound = card != null;

            if(isCardFound) {
                /*clean previous input*/
                validator.clean(session);

                if(card.getTopUp().isEnabled()) {
                    DBPaymentMethodManager dbPaymentMethodManager = new DBPaymentMethodManager();
                    PaymentMethod paymentMethod = dbPaymentMethodManager.readPaymentMethodByPaymentMethodId(
                            card.getTopUp().getPaymentMethodId().toString());

                    //Check the paymentMethod is null, then disable the payment
                    if(paymentMethod == null) {
                        card.setTopUpEnabled(false);
                    } else {
                        //otherwise, store payment into session
                        session.setAttribute("paymentMethod", paymentMethod);
                    }
                }

                if(card.getAccountId() != UUID.fromString("00000000-0000-0000-0000-000000000000")) {
                    DBCustomerManager dbCustomerManager = new DBCustomerManager();
                    Customer customer = dbCustomerManager.getCustomerByAccountId(card.getAccountId());
                    if(customer != null) {
                        session.setAttribute("customerEmail", customer.getEmailAddress());
                    }else {
                        session.setAttribute("customerEmail", "OFF");
                    }
                }

                //Store customer into attribute
                session.setAttribute("card", card);

                //Push view to welcome.jsp
                req.getRequestDispatcher("/carddetails.jsp").forward(req, resp);
            } else {
                /*Store error message of no matches of card number and pin*/
                session.setAttribute("cardNumAndPinErr", "Error: No match of card number and pin");

                /*call method to store previous input and then push view to /opalcard.jsp*/
                setPreviousInput(session, req, resp, cardNumber, cardPin);
            }
        }
    }


    private void setPreviousInput(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
                                  final String cardNumber, final String cardPin)
            throws IOException, ServletException {
        /*store previous input*/
        session.setAttribute("previous_card_number", cardNumber);
        session.setAttribute("previous_card_pin", cardPin);

        /*push view*/
        req.getRequestDispatcher("/opalcard.jsp").forward(req, resp);

    }
}
