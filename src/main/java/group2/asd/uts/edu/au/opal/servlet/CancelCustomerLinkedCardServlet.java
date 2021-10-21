package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.model.Card;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;


public class CancelCustomerLinkedCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get index of the selected card
        int index = Integer.parseInt(request.getParameter("index"));

        //retrieve the current session
        HttpSession session = request.getSession();

        //Create the card DBManager
        DBCardsManager dbCardsManager = new DBCardsManager();

        //Get card list
        ArrayList<Card> linkedCards = (ArrayList<Card>) session.getAttribute("linked_cards");

        //Get selected card
        Card selectedCard = linkedCards.get(index);

        //Update opal card's account id in the database with UUID(0, 0)
        dbCardsManager.updateAccountId(selectedCard.getObjectId(), new UUID(0, 0));

        //Remove selected card from the list
        linkedCards.remove(index);

        //Store the list into the current session
        session.setAttribute("linked_cards", linkedCards);

        //Push view to welcome.jsp
        request.getRequestDispatcher("/linkedopalcards.jsp").forward(request, response);
    }
}