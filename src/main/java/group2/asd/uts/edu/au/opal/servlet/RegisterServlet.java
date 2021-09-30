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

public class RegisterServlet extends HttpServlet {

    private DBConnection connection;
    private DBCustomerManager dbCustomerManager;

    @Override
    public void init() {
        this.connection = DBConnection.getDB();
        this.dbCustomerManager = new DBCustomerManager();
    }

    // This method is called by the servlet container to process a 'post' request
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("cpassword");
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String phone = req.getParameter("phone");

        if (email.isEmpty() || password.isEmpty()) {
            req.setAttribute("error_message", "Please fill out all required fields.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        if (!password.equals(confirm_password)) {
            req.setAttribute("error_message", "Please ensure the entered passwords match.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        Customer customer = new Customer(firstName, lastName, email, password, phone);
        dbCustomerManager.registerCustomer(customer, password);

        HttpSession session = req.getSession();
        session.setAttribute("customer", customer);
        req.getRequestDispatcher("/userprofile.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        // Store the db connection in the user's session. It should be checked / made a new instance for every servlet.
        session.setAttribute("db", connection);
    }
}
