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

        String password = req.getParameter("new_password");

        if (!validator.validatePassword(password)) {
            session.setAttribute("updatePassErr", "Invalid password. Minimum requirements: 8 characters");
            req.getRequestDispatcher("/changepassword.jsp").forward(req, resp);
            return;
        }

        manager.changePassword(customer.getAccountId(), password);
        resp.sendRedirect("/userprofile.jsp");
    }
}
