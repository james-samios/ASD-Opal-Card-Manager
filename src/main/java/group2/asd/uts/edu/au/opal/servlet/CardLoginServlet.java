package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.object.Card;

import java.io.IOException;
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

        //initialise the error message
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

            /*store previous input*/
            session.setAttribute("previous_card_number", cardNumber);
            session.setAttribute("previous_card_pin", cardPin);

            /*push view*/
            req.getRequestDispatcher("/opalcard.jsp").forward(req, resp);
        } else if(!validator.validateCardPin(cardPin)) {
            /*store error message of the type of card Pin*/
            session.setAttribute("cardPinFormErr", "Error: 4 digits for card pin");

            /*store previous input*/
            session.setAttribute("previous_card_number", cardNumber);
            session.setAttribute("previous_card_pin", cardPin);

            /*push view*/
            req.getRequestDispatcher("/opalcard.jsp").forward(req, resp);
        } else {
            //Get customer data by calling API
            Card card = dbCardsManager.getCardByNumberAndPin(cardNumber, cardPin);

            //Check the customer is found or not
            boolean isCardFound = card != null;

            if(isCardFound) {
                //Store customer into attribute
                session.setAttribute("card", card);

                /*clean previous input*/
                session.setAttribute("previous_card_number", "");
                session.setAttribute("previous_card_pin", "");

                //Push view to welcome.jsp
                req.getRequestDispatcher("/carddetails.jsp").forward(req, resp);
            } else {
                /*Store error message of no matches of card number and pin*/
                session.setAttribute("cardNumAndPinErr", "Error: No match of card number and pin");

                /*store previous input*/
                session.setAttribute("previous_card_number", cardNumber);
                session.setAttribute("previous_card_pin", cardPin);

                /*push view*/
                req.getRequestDispatcher("/opalcard.jsp").forward(req, resp);
            }
        }
    }
}
