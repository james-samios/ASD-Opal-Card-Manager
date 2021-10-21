package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBCustomerManager;
import group2.asd.uts.edu.au.opal.model.Address;
import group2.asd.uts.edu.au.opal.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditAddressServlet extends HttpServlet {

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
        HttpSession session = req.getSession();

        String addressLine1 = req.getParameter("address_line_1");
        String addressLine2 = req.getParameter("address_line_2");
        String suburb = req.getParameter("suburb");
        int postcode = Integer.parseInt(req.getParameter("postcode"));
        String state = req.getParameter("state");

        Address address = new Address(addressLine1, addressLine2, suburb, postcode, state);

        Customer customer = (Customer) session.getAttribute("customer");
        customer.setAddress(address);

        dbCustomerManager.updateCustomer(customer);

        req.getRequestDispatcher("/userprofile.jsp").forward(req, resp);
    }
}
