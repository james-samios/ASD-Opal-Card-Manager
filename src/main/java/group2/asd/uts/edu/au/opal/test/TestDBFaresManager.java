package group2.asd.uts.edu.au.opal.test;

import group2.asd.uts.edu.au.opal.dao.DBFaresManager;
import group2.asd.uts.edu.au.opal.model.Fares;
import org.bson.Document;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.UUID;

public class TestDBFaresManager {
    private final Fares fare = new Fares(
            UUID.randomUUID(),
            16.3,
            50,
            8.15,
            3.66,
            4.55,
            5.23,
            6.99,
            8.99,
            2.56,
            3.18,
            3.66,
            4.89,
            6.29,
            4.50,
            5.60,
            6.40,
            8.40,
            10.80,
            3.20,
            3.79,
            4.87,
            2.24,
            2.65,
            3.40,
            4.00,
            4.60,
            6.00,
            6.21,
            7.76,
            3.20,
            6.21,
            7.76,
            2.24,
            7.60,
            9.40,
            4.00,
            3.10,
            3.88,
            2.43,
            3.10,
            3.88,
            1.70,
            3.80,
            4.70,
            6.00





    );

    Document expectedDocument = fare.convertClassToDocument();


    @Test
    public void testDBManager() {
        //Create fare into database
        DBFaresManager dbFaresManager = new DBFaresManager();
        dbFaresManager.createFare(fare);

        //Read fare from database

        Fares actualFare = dbFaresManager.readFare();
        System.out.println(actualFare.convertClassToDocument());
        //assertEquals(expectedDocument, actualFare.convertClassToDocument());

    }





}