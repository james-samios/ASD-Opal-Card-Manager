package group2.asd.uts.edu.au.opal.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StaffLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("name:" + username);
        System.out.println("password:" + password);

        if("admin".equals(username) && "123456".equals(password)){
            req.setAttribute("username",username);
            req.getRequestDispatcher("/faremanagement.jsp").forward(req,resp);
        }else{

            req.setAttribute("username",username);
            req.setAttribute("error", "Error staff name or password, please enter again");
            req.getRequestDispatcher("/stafflogin.jsp").forward(req,resp);
        }



    }
}
