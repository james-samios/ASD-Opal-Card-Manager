package group2.asd.uts.edu.au.opal;

import group2.asd.uts.edu.au.opal.api.API;
import group2.asd.uts.edu.au.opal.object.Customer;

import java.util.ArrayList;

/**
 * UTS Advanced Software Development - Assignment
 * Opal Card Management System
 * Created by: James Samios, Jack Shakespeare, Christopher Cruz, Nadeem Ahmed, Qiyang Wu and Tzu-Jung Yeh
 */
public class Main {

    private static ArrayList<Customer> loggedInCustomers;
    private static API api;

    public static void main(String[] args) {
        api = new API();
        loggedInCustomers = new ArrayList<>();

        Customer test = api.getCustomer("john.smith@gmail.com", "123gnjk12gnsbjky523fg%#2vnjk1");
        if (test != null) {
            loggedInCustomers.add(test);
            System.out.println("Loaded Customer: " + test);
        } else {
            System.out.println("Customer is null.");
        }
    }

    public static API getApi() {
        return api;
    }
}
