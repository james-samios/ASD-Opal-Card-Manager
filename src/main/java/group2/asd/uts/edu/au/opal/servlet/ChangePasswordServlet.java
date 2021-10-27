package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBCustomerManager;
import group2.asd.uts.edu.au.opal.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ChangePasswordServlet extends HttpServlet {

    private DBCustomerManager manager;
    private Validator validator;

    @Override
    public void init() {
        this.manager = new DBCustomerManager();
        this.validator = new Validator();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        String currentPassword = req.getParameter("password");
        String password = req.getParameter("npassword");
        String confirmPassword = req.getParameter("npassword2");

        if (currentPassword == null || password == null || confirmPassword == null) {
            session.setAttribute("updatePassErr", "Please fill out all fields.");
            req.getRequestDispatcher("/changepassword.jsp").forward(req, resp);
            return;
        }

        String currentToMd5 = manager.stringToMd5(currentPassword);

        if (!customer.getPassword().equals(currentToMd5)) {
            session.setAttribute("updatePassErr", "Incorrect password.");
            req.getRequestDispatcher("/changepassword.jsp").forward(req, resp);
            return;
        }

        if (!password.equals(confirmPassword)) {
            session.setAttribute("updatePassErr", "New passwords do not match.");
            req.getRequestDispatcher("/changepassword.jsp").forward(req, resp);
            return;
        }

        if (!validator.validatePassword(password)) {
            session.setAttribute("updatePassErr", "Invalid password. Minimum requirements: 8 characters");
            req.getRequestDispatcher("/changepassword.jsp").forward(req, resp);
            return;
        }

        customer.setPassword(currentToMd5);
        manager.changePassword(customer.getAccountId(), password);
        req.getRequestDispatcher("/userprofile.jsp").forward(req, resp);
    }
}
