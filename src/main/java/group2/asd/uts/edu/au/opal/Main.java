package group2.asd.uts.edu.au.opal;

import com.mongodb.Block;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import group2.asd.uts.edu.au.opal.api.API;
import group2.asd.uts.edu.au.opal.object.Card;
import group2.asd.uts.edu.au.opal.object.Customer;
import org.bson.Document;

import java.util.ArrayList;

/**
 * UTS Advanced Software Development - Assignment
 * Opal Card Management System
 * Created by: James Samios, Jack Shakespeare, Christopher Cruz, Nadeem Ahmed, Qiyang Wu and Tzu-Jung Yeh
 */
public class Main {

    private static ArrayList<Document> loggedInCustomers;
    private static API api;
    //private static MongoClient client;

    public static void main(String[] args) {

        //Customer test = new API().getCustomer("john.smith@gmail.com", "123gnjk12gnsbjky523fg%#2vnjk1");
        //Card test = new API().getCard("john.smith@gmail.com", "123gnjk12gnsbjky523fg%#2vnjk1");

        //if (test != null) {
            //System.out.println("Loaded Card: " + test);
        //} else {
            //System.out.println("Card is null.");
        //}


    }

    public static API getApi() {
        return api;
    }


}
