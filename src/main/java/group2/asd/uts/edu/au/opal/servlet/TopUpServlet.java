package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.object.Card;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


public class TopUpServlet extends HttpServlet {
    // This method is called by the servlet container to process a 'post' request
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //retrieve the current session
        HttpSession session = req.getSession();

        //Get Card object
        Card card = (Card) session.getAttribute("card");

        //create an instance of the Validator class
        Validator validator = new Validator();

        //initialise the error message
        validator.clean(session);

        //Create the card DBManager
        DBCardsManager dbCardsManager = new DBCardsManager();

        //Reading post parameters from the request
        String amount = req.getParameter("amount");
        String paymentNumber = req.getParameter("payment_number");
        String paymentCvc = req.getParameter("payment_cvc");
        String paymentOwner = req.getParameter("payment_owner");
        String paymentExpiry = req.getParameter("payment_expiry");
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR) - 2000;
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);

        if(!validator.validateCardNumber(paymentNumber)) {
            session.setAttribute("cardNumberFormErr", "Error: 16 digits for credit card number");
            setPreviousInput(session, req, resp,
                    amount, paymentNumber, paymentOwner, paymentCvc, paymentExpiry);
        }else if(!validator.validateCardCvc(paymentCvc)) {
            session.setAttribute("cardCvcErr", "Error: 3 digits for credit card CVC");
            setPreviousInput(session, req, resp,
                    amount, paymentNumber, paymentOwner, paymentCvc, paymentExpiry);
        }else if(!validator.validateName(paymentOwner)) {
            session.setAttribute("cardNameErr", "Error: A-Z,a-z,and space for credit card owner");
            setPreviousInput(session, req, resp,
                    amount, paymentNumber, paymentOwner, paymentCvc, paymentExpiry);
        }else if(!validator.validateCardExpiry(paymentExpiry, month, year)) {
            //format the month from X to 0X if X < 10
            String sMonth = month < 10? "0" + month: "" + month;
            session.setAttribute("cardExpiryErr", "Error: XX/XX(>=" + sMonth + "/" + year +")");
            setPreviousInput(session, req, resp,
                    amount, paymentNumber, paymentOwner, paymentCvc, paymentExpiry);
        }else {
            /*need to add update payment method*/
            Double newBalance = card.getBalance() + Double.parseDouble(amount);
            dbCardsManager.updateCardBalance(card.getCardId().toString(), newBalance);
            card.setBalance(newBalance);
            session.setAttribute("card", card);
            req.getRequestDispatcher("/carddetails.jsp").forward(req, resp);
        }
    }
    private void setPreviousInput(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
                                  String amount, String paymentNumber, String paymentOwner, String paymentCvc,
                                  String expiry
    ) throws IOException, ServletException {
        session.setAttribute("previous_payment_amount", amount);
        session.setAttribute("previous_payment_number", paymentNumber);
        session.setAttribute("previous_payment_owner", paymentOwner);
        session.setAttribute("previous_payment_cvc", paymentCvc);
        session.setAttribute("previous_payment_expiry", expiry);
        req.getRequestDispatcher("/topupmenu.jsp").forward(req, resp);
    }
}
