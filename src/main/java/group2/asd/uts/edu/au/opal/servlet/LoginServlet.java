package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBConnection;
import group2.asd.uts.edu.au.opal.dao.DBCustomerManager;
import group2.asd.uts.edu.au.opal.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {

    private DBConnection connection;

    @Override
    public void init() {
        this.connection = DBConnection.getDB();
    }

    // This method is called by the servlet container to process a 'post' request
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");

        // Checking for null and empty values
        if(email == null || email.isEmpty() || password == null || password.isEmpty()) {
            req.setAttribute("error_message", "Please enter your email and password");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            //Get customer data by calling new DBCustomerManager object.
            Customer customer = new DBCustomerManager().getCustomer(email, password);

            if(customer != null) {
                //Store customer into attribute
                HttpSession session = req.getSession();
                session.setAttribute("customer", customer);

                //Push view to welcome.jsp
                req.getRequestDispatcher("/userprofile.jsp").forward(req, resp);
            } else {
                //Store error message into attribute
                req.setAttribute("error_message", "Sorry, there was an error retrieving your account details. Please try again later.");

                //Stay view at login.jsp
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        // Store the db connection in the user's session. It should be checked / made a new instance for every servlet.
        session.setAttribute("db", connection);
    }
}
