package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBConnection;
import group2.asd.uts.edu.au.opal.dao.DBCustomerManager;
import group2.asd.uts.edu.au.opal.model.Address;
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
    private Validator validator;

    @Override
    public void init() {
        this.connection = DBConnection.getDB();
        this.dbCustomerManager = new DBCustomerManager();
        this.validator = new Validator();
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

        HttpSession session = req.getSession();

        // Validation
        if (!validator.validateEmail(email)) {
            session.setAttribute("regErr", "Please enter a valid email address.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        if (!validator.validateName(firstName + " " + lastName)) {
            session.setAttribute("regErr", "Please enter a valid first and last name.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        if (!validator.validatePhoneNumber(phone)) {
            session.setAttribute("regErr", "Please enter a valid phone number.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        if (!validator.validatePassword(password)) {
            session.setAttribute("regErr", "Please enter a valid password. Requirements: Minimum 8 characters");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        String addressLine1 = req.getParameter("address_line_1");
        String addressLine2 = req.getParameter("address_line_2");
        String suburb = req.getParameter("suburb");
        int postcode = Integer.parseInt(req.getParameter("postcode"));
        String state = req.getParameter("state");

        Address address = new Address(addressLine1, addressLine2, suburb, postcode, state);

        if (email.isEmpty() || password.isEmpty()) {
            session.setAttribute("regErr", "Please fill out all required fields.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        if (!password.equals(confirm_password)) {
            session.setAttribute("regErr", "Please ensure the entered passwords match.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        Customer customer = new Customer(firstName, lastName, email, password, phone, address);
        dbCustomerManager.registerCustomer(customer, password);

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
