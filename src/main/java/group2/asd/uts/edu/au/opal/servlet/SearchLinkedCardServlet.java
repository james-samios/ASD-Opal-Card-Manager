package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.model.Card;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class SearchLinkedCardServlet extends HttpServlet {
    // This method is called by the servlet container to process a 'post' request
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        //Declare a variable to store the current session
        HttpSession session = req.getSession();

        //create an instance of the Validator class
        Validator validator = new Validator();

        //initialise all messages in session
        validator.clean(session);

        //Reading post parameters from the request
        String userInput = req.getParameter("search_input").toLowerCase();

        ArrayList<Card> linkedCards = (ArrayList<Card>) session.getAttribute("linked_cards");


        if(userInput.toLowerCase().equals("all")) {
            session.setAttribute("filter_cards", linkedCards);
        }else {
            ArrayList<Card> filterCards = new ArrayList<>();
            for(int i = 0; i < linkedCards.size(); i++) {
                if(linkedCards.get(i).getCardNumber().equals(userInput) ||
                        linkedCards.get(i).getType().toString().toLowerCase().equals(userInput)) {
                    filterCards.add(linkedCards.get(i));

                }
            }
            String result = "" + filterCards.size() + " card(s) found.";
            session.setAttribute("search_result", result);
            session.setAttribute("filter_cards", filterCards);
        }


        //Push to enquiry home page
        req.getRequestDispatcher("/linkedopalcards.jsp").forward(req, resp);
    }
}