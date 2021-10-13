package group2.asd.uts.edu.au.opal.servlet;
import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.dao.DBCustomerManager;
import group2.asd.uts.edu.au.opal.model.Card;
import group2.asd.uts.edu.au.opal.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LinkAccountServlet extends HttpServlet {
    // This method is called by the servlet container to process a 'post' request
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //retrieve the current session
        HttpSession session = req.getSession();

        //create an instance of the Validator class
        Validator validator = new Validator();

        //initialise all messages in session
        validator.clean(session);

        //Reading post parameters from the request
        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");

        if(!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format (xxx.xxx@xxx.xxx.xx)");
            /*call method to store previous input and then push view to /carddetails.jsp*/
            setPreviousInput(session, req, resp, email, email);
        }else {
            DBCustomerManager dbCustomerManager = new DBCustomerManager();
            DBCardsManager dbCardsManager = new DBCardsManager();
            Customer customer = dbCustomerManager.getCustomer(email, password);
            if(customer == null) {
                session.setAttribute("passErr", "Error: user email or password wrong");

                /*call method to store previous input and then push view to /carddetails.jsp*/
                setPreviousInput(session, req, resp, email, email);
            }else {
                Card card = (Card) session.getAttribute("card");
                card.setAccountId(customer.getAccountId());
                dbCardsManager.updateAccountId(card.getObjectId(), customer.getAccountId());
                session.setAttribute("card", card);
                session.setAttribute("customerEmail", customer.getEmailAddress());

                //Push view to welcome.jsp
                req.getRequestDispatcher("/carddetails.jsp").forward(req, resp);
            }
        }
    }

    private void setPreviousInput(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
                                  final String email, final String password)
            throws IOException, ServletException {

        /*store previous input*/
        session.setAttribute("previous_email", email);
        session.setAttribute("previous_password", password);

        /*push view*/
        req.getRequestDispatcher("/linkaccount.jsp").forward(req, resp);

    }
}
