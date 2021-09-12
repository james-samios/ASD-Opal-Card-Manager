package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.api.API;
import group2.asd.uts.edu.au.opal.object.Card;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cardLoginServlet")
public class CardLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // This method is called by the servlet container to process a 'post' request
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handleRequest(req, resp);
    }

    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Reading post parameters from the request

        String param1 = req.getParameter("cnumber");
        String param2 = req.getParameter("cpin");


        // Checking for null and empty values
        if(param1 == null || param2 == null || "".equals(param1) || "".equals(param2)) {
            req.setAttribute("error_message", "Please enter card number and pin");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            //Get customer data by calling API
            Card card = new API().getCard(param1, param2);

            //Check the customer is found or not
            boolean isCardFound = card != null;

            if(isCardFound) {
                //Store customer into attribute

                //Push view to welcome.jsp
                req.getRequestDispatcher("/carddetails.jsp").forward(req, resp);
            } else {
                System.out.println("No card matched");
                //Store error message into attribute
                req.setAttribute("error_message", "Card number or Card pin Error");

                //Stay view at login.jsp
                req.getRequestDispatcher("/opalcard.jsp").forward(req, resp);
            }
        }


    }
}
