package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.model.Card;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CardStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //retrieve the current session
        HttpSession session = request.getSession();

        Card card = (Card) session.getAttribute("card");
        boolean value = !card.isActive();

        //Create the card DBManager
        DBCardsManager dbCardsManager = new DBCardsManager();
        dbCardsManager.updateCardActive(card.getObjectId(), value);
        card.setActive(value);
        session.setAttribute("card", card);

        //Push view to welcome.jsp
        request.getRequestDispatcher("/carddetails.jsp").forward(request, response);

    }
}
