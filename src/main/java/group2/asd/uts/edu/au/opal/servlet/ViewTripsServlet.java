package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.model.Card;
import group2.asd.uts.edu.au.opal.model.Trip;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class ViewTripsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get index of the selected card
        int index = Integer.parseInt(request.getParameter("index"));

        //retrieve the current session
        HttpSession session = request.getSession();

        //retrieve the linked card list
        ArrayList<Card> linkedCards = (ArrayList<Card>) session.getAttribute("linked_cards");

        //Get the selected card and retrieve the card's trips
        //1. Get selected card
        Card selectedCard = linkedCards.get(index);

        //2. Get selected card's trips
        ArrayList<Trip> trips = selectedCard.getTrips();

        //Store card type for css color style
        session.setAttribute("card_type", selectedCard.getType().toString().toLowerCase());

        //Store trips into the current session
        session.setAttribute("trips", trips);

        //Push view to trips.jsp
        request.getRequestDispatcher("/trips.jsp").forward(request, response);
    }
}