package group2.asd.uts.edu.au.opal.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TopUpMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //retrieve the current session
        HttpSession session = req.getSession();

        //create an instance of the Validator class
        Validator validator = new Validator();

        //initialise all messages in session
        validator.clean(session);

        /*push view*/
        req.getRequestDispatcher("/topupmenu.jsp").forward(req, resp);
    }
}