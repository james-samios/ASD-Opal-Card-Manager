package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.model.Fares;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateDiscountsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();



        session.setAttribute("claimStatus","Claimed");

        request.getRequestDispatcher("linkedopalcards.jsp").forward(request, response);


    }
}
