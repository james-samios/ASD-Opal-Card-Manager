package group2.asd.uts.edu.au.opal.servlet;
import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.model.Card;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class CancelAccountLinkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //retrieve the current session
        HttpSession session = request.getSession();

        Card card = (Card) session.getAttribute("card");
        card.setAccountId(new UUID(0, 0));
        session.setAttribute("card", card);
        session.setAttribute("customerEmail", "OFF");

        //Create the card DBManager
        DBCardsManager dbCardsManager = new DBCardsManager();
        dbCardsManager.updateAccountId(card.getObjectId(), card.getAccountId());

        //Push view to welcome.jsp
        request.getRequestDispatcher("/carddetails.jsp").forward(request, response);
    }
}
