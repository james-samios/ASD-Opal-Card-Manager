package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.api.API;
import group2.asd.uts.edu.au.opal.object.Card;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cardLoginServlet")
public class CardLoginServlet extends HttpServlet {
    // This method is called by the servlet container to process a 'post' request
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        //retrieve the current session
        HttpSession session = req.getSession();

        //create an instance of the Validator class
        Validator validator = new Validator();

        //initialise the error message
        validator.clean(session);


        // Reading post parameters from the request
        String param1 = req.getParameter("card_number");
        String param2 = req.getParameter("card_pin");


        // Checking for null and empty values
        if(!validator.validateCardNumber(param1)) {
            System.out.println("card number error");
            session.setAttribute("cardNumberFormErr", "Error: 16 digits for card number");
            req.getRequestDispatcher("/opalcard.jsp").forward(req, resp);
        } else if(!validator.validateCardPin(param2)) {
            System.out.println("card pin error");
            session.setAttribute("cardPinFormErr", "Error: 4 digits for card pin");
            req.getRequestDispatcher("/opalcard.jsp").forward(req, resp);
        } else {
            //Get customer data by calling API
            Card card = new API().getCardByNumberAndPin(param1, param2);

            //Check the customer is found or not
            boolean isCardFound = card != null;

            if(isCardFound) {
                //Store customer into attribute
                session.setAttribute("card", card);

                //Push view to welcome.jsp
                req.getRequestDispatcher("/carddetails.jsp").forward(req, resp);
            } else {
                //Store error message into attribute
                session.setAttribute("cardNumAndPinErr", "Wrong card number or card pin");

                //Stay view at login.jsp
                req.getRequestDispatcher("/opalcard.jsp").forward(req, resp);
            }
        }
    }
}
