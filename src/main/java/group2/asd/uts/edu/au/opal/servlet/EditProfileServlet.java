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

public class EditProfileServlet extends HttpServlet {

    private DBCustomerManager dbCustomerManager;
    private Validator validator;

    @Override
    public void init() {
        this.dbCustomerManager = new DBCustomerManager();
        this.validator = new Validator();
    }

    // This method is called by the servlet container to process a 'post' request
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String email = req.getParameter("email");
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String phone = req.getParameter("phone");

        HttpSession session = req.getSession();

        // Validation
        if (!validator.validateEmail(email)) {
            session.setAttribute("editErr", "Please enter a valid email address.");
            req.getRequestDispatcher("/editProfile.jsp").forward(req, resp);
            return;
        }

        if (!validator.validateName(firstName + " " + lastName)) {
            session.setAttribute("editErr", "Please enter a valid first and last name.");
            req.getRequestDispatcher("/editProfile.jsp").forward(req, resp);
            return;
        }

        if (!validator.validatePhoneNumber(phone)) {
            session.setAttribute("editErr", "Please enter a valid phone number.");
            req.getRequestDispatcher("/editProfile.jsp").forward(req, resp);
            return;
        }

        Customer customer = (Customer) session.getAttribute("customer");
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmailAddress(email);
        customer.setPhoneNumber(phone);

        dbCustomerManager.updateCustomer(customer);

        req.getRequestDispatcher("/userprofile.jsp").forward(req, resp);
    }
}
