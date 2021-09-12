package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.api.API;
import group2.asd.uts.edu.au.opal.object.Customer;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    // This method is called by the servlet container to process a 'post' request
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handleRequest(req, resp);
    }

    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Reading post parameters from the request
        String param1 = req.getParameter("user_email");
        String param2 = req.getParameter("user_password");


        // Checking for null and empty values
        if(param1 == null || param2 == null || "".equals(param1) || "".equals(param2)) {
            req.setAttribute("error_message", "Please enter email and password");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            //Get customer data by calling API
            Customer customer = new API().getCustomer(param1, param2);

            //Check the customer is found or not
            boolean isUserFound = customer != null;

            if(isUserFound) {
                //Store customer into attribute

                //Push view to welcome.jsp
                req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
            } else {

                //Store error message into attribute
                req.setAttribute("error_message", "You are not an authorised user. Please check with administrator.");

                //Stay view at login.jsp
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }


    }
}
