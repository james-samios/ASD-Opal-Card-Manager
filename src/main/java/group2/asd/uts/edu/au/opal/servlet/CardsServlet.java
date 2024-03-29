package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBAdminCardManager;
import group2.asd.uts.edu.au.opal.model.Card;
import group2.asd.uts.edu.au.opal.model.CardType;
import org.bson.types.ObjectId;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@WebServlet(name = "CardsServlet", value = "/CardsServlet")
public class CardsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String method = request.getParameter("method");
        switch(method){
            case "add" :
                String cardId = UUID.randomUUID().toString();
                String cardPin = request.getParameter("cardPin");
                String cardNumber = request.getParameter("cardNumber");
                String e = null;
                if(type.equals("ADULT")){
                    e = CardType.ADULT.toString();
                }
                if(type.equals("CHILD")){
                    e = CardType.CHILD.toString();
                }  if(type.equals("SCHOOL")){
                e = CardType.SCHOOL.toString();
            }
                if(type.equals("CONCESSION")){
                    e = CardType.CONCESSION.toString();
                }

                String balance = request.getParameter("balance");
                String active = request.getParameter("active");
                Card card = new Card();
                card.setCardPin(cardPin);
                card.setCardNumber(cardNumber);
                card.setActive(Boolean.parseBoolean(active));
                card.setBalance(Double.parseDouble(balance));

                new DBAdminCardManager().add( cardPin
                        , cardNumber
                        ,  e.toUpperCase()
                        ,  card.getBalance()
                        , card.isActive());
                List<CardForm> list = new DBAdminCardManager().readAllCards();

                request.setAttribute("list",list);
                request.getRequestDispatcher("/ConcessionManager.jsp").forward(request,response);
                break;
            case "toadd" :
                request.getRequestDispatcher("/addCard.jsp").forward(request,response);
                break;
            case "delete" :
                String id = request.getParameter("id");
                System.out.println(id);
                new DBAdminCardManager().deleteCardByObjectId(new ObjectId(id));
                request.setAttribute("msg","<script>alert('delete success!')</script>");
                list = new DBAdminCardManager().readAllCards();

                request.setAttribute("list",list);
                request.getRequestDispatcher("/ConcessionManager.jsp").forward(request,response);

                break;
            case "edit" :
                String objectId = request.getParameter("objectId");
                cardId = request.getParameter("cardId");
                cardPin = request.getParameter("cardPin");
                cardNumber = request.getParameter("cardNumber");
                e = null;
                if(type.equals("ADULT")){
                    e = CardType.ADULT.toString();
                }
                if(type.equals("CHILD")){
                    e = CardType.CHILD.toString();
                }  if(type.equals("SCHOOL")){
                e = CardType.SCHOOL.toString();
            }
                if(type.equals("CONCESSION")){
                    e = CardType.CONCESSION.toString();
                }

                balance = request.getParameter("balance");
                active = request.getParameter("active");
                card = new Card();
                card.setCardPin(cardPin);
                card.setObjectId(new ObjectId(objectId));
                card.setCardNumber(cardNumber);
                card.setActive(Boolean.parseBoolean(active));
                card.setBalance(Double.parseDouble(balance));

                new DBAdminCardManager().update(card.getObjectId()
                        ,  cardPin
                        , cardNumber
                        ,  e.toUpperCase()
                        ,  card.getBalance()
                        , card.isActive());
                CardForm  cardForm = new DBAdminCardManager().readCardByCardId(cardId);

                request.setAttribute("card",cardForm);
                System.out.println(cardForm);
                request.getRequestDispatcher("/preEditCard.jsp").forward(request,response);

                break;
            case "preedit" :
                id = request.getParameter("id");
                cardForm = new DBAdminCardManager().readCardByCardId(id);

                request.setAttribute("card",cardForm);
                System.out.println(cardForm);
                request.getRequestDispatcher("/preEditCard.jsp").forward(request,response);
                break; //可选
            case "show" :

                list = new DBAdminCardManager().readAllCardsByType(type);

                request.setAttribute("list",list);
                request.getRequestDispatcher("/ConcessionManager.jsp").forward(request,response);
                break;

            default :

        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
