package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBCustomerManager;
import group2.asd.uts.edu.au.opal.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAccountServlet extends HttpServlet {

    private DBCustomerManager dbCustomerManager;

    @Override
    public void init() {
        this.dbCustomerManager = new DBCustomerManager();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Customer customer = (Customer) req.getSession().getAttribute("customer");

        if (customer != null) {
            dbCustomerManager.deleteAccount(customer.getAccountId());
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
