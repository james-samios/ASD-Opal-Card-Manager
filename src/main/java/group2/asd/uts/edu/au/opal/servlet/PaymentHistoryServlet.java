package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBPaymentHistoryManager;
import group2.asd.uts.edu.au.opal.model.Card;
import group2.asd.uts.edu.au.opal.model.PaymentHistory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class PaymentHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //retrieve the current session
        HttpSession session = request.getSession();
        ArrayList<PaymentHistory> paymentHistories = new ArrayList<>();
        Card card = (Card) session.getAttribute("card");
        DBPaymentHistoryManager dbPaymentHistoryManager = new DBPaymentHistoryManager();
        paymentHistories = dbPaymentHistoryManager.readAllPaymentHistoryByProvidedCardId(card.getCardId());
        session.setAttribute("paymentHistories", paymentHistories);
        request.getRequestDispatcher("topuprecords.jsp").include(request, response);
    }
}
