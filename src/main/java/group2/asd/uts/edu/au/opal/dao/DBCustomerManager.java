package group2.asd.uts.edu.au.opal.dao;

import org.bson.Document;

public class DBCustomerManager extends DBManager {

    public DBCustomerManager() {
        super(CollectionType.ACCOUNTS);
    }

    /*   *************************************Methods for "C" section below****************************************   */
    /*   *************************************Methods for "R" section below****************************************   */
    public void displayAllCustomers() {
        try {
            int counter = 1;
            for (Document document : getCollection().find()) {
                System.out.println("" + counter + ": " + document);
                counter = counter + 1;
            }
        }catch(Exception e) {
            System.out.println("Error: the failure of displaying all payment methods");
        }

    }
    /*   *************************************Methods for "U" section below****************************************   */
    /*   *************************************Methods for "D" section below****************************************   */
}