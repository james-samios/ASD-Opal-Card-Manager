package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.dao.DBPaymentMethodManager;
import group2.asd.uts.edu.au.opal.model.Card;
import group2.asd.uts.edu.au.opal.model.TopUp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class CancelAutoTopUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //retrieve the current session
        HttpSession session = request.getSession();

        Card card = (Card) session.getAttribute("card");

        //Create the card DBManager
        DBCardsManager dbCardsManager = new DBCardsManager();
        DBPaymentMethodManager dbPaymentMethodManager = new DBPaymentMethodManager();

        //delete payment method from database
        dbPaymentMethodManager.deletePaymentByPaymentMethodId(card.getTopUp().getPaymentMethodId().toString());

        //Reset card's top up in database
        TopUp resetTopUp = new TopUp(new UUID(0, 0), false, 0, 0);
        dbCardsManager.updateCardTopUp(card.getObjectId(), resetTopUp);

        //rest card top up
        card.setTopUp(resetTopUp);

        //store card into session
        session.setAttribute("card", card);

        //Push view to welcome.jsp
        request.getRequestDispatcher("/carddetails.jsp").forward(request, response);
    }
}
