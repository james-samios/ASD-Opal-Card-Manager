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


public class ChangePasswordServlet extends HttpServlet {

    private DBConnection connection;

    @Override
    public void init() {
        this.connection = DBConnection.getDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        
    }
}
