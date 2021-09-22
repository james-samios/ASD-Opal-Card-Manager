package group2.asd.uts.edu.au.opal.servlet;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import group2.asd.uts.edu.au.opal.dao.DB;
import group2.asd.uts.edu.au.opal.dao.DBCardsManager;
import group2.asd.uts.edu.au.opal.dao.DBCustomerManager;
import group2.asd.uts.edu.au.opal.dao.DBPaymentMethodManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;


/*This servlet is used to create database connection to mongoDB*/

public class ConnServlet extends HttpServlet {
    private MongoDatabase mongoDatabase;

    /*Add DB manager below*/
    private DBCardsManager dbCardsManager;
    private DBPaymentMethodManager dbPaymentMethodManager;
    private DBCustomerManager dbCustomerManager;

    //Create and instance of DBConnection for the deployment session
    @Override
    public void init() {
        try {
            DB db = new DB();
            ConnectionString connectionString = new ConnectionString(db.getUrl());
            MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
            mongoDatabase = MongoClients.create(settings).getDatabase(db.getDatabaseName());
            System.out.println("Connect to the database and wait for queries...");
        } catch (Exception e) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    //Add the DBConnector, DBManager, Connection instances to the session
    //The doGet() capture the current session from request and opens connection with database
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //The steps of what doGet() do
        //1 set page content text type
        //2 get the current session from parameter of HttpServletRequest request
        //3 create an instance of DBManager
        //4 An instance to connect to DBManager database
        //5 add the instance into current session

        //1 set page content text type
        response.setContentType("text/html;charset=UTF-8");

        //2 declare a session variable to store request session
        HttpSession session = request.getSession();

        //3 create an instance of Validator to initialise the error message
        Validator validator = new Validator();
        validator.clean(session);

        try {
            //4 An instance to connect to DBManager database with database manager's name
            dbCardsManager = new DBCardsManager(mongoDatabase);
            dbPaymentMethodManager = new DBPaymentMethodManager(mongoDatabase);
            dbCustomerManager = new DBCustomerManager(mongoDatabase);
        } catch (Exception ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //export the DB manager to the view-session (JSPs)
        //5 add the instance into current session
        session.setAttribute("dbCardsManager", dbCardsManager);
        session.setAttribute("dbPaymentMethodManager", dbPaymentMethodManager);
        session.setAttribute("dbCustomerManager", dbCustomerManager);
        session.setAttribute("validator", validator);
    }

    //Destroy the servlet and release the resources of the application (terminate also the db connection)
    @Override
    public void destroy() {
        try {
            mongoDatabase.drop();
        } catch (Exception ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
