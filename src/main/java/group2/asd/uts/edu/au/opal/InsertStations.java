package group2.asd.uts.edu.au.opal;

import group2.asd.uts.edu.au.opal.dao.DBStationsManager;
import group2.asd.uts.edu.au.opal.model.Station;

import java.util.ArrayList;
import java.util.Random;

public class InsertStations {
    public static void main(String[] args) {
        DBStationsManager dbStationsManager = new DBStationsManager();
        dbStationsManager.createStation(new Station("12:00am", "12:15am", "Central", "Bus", 60.00, buildCoordinates()));
        dbStationsManager.createStation(new Station("2:00am", "2:15am", "Townhall", "Bus", 60.00, buildCoordinates()));
        dbStationsManager.createStation(new Station("7:00am", "7:15am", "Redfern", "Bus", 60.00, buildCoordinates()));
        dbStationsManager.createStation(new Station("12:00am", "12:15am", "Circular Quay", "Bus", 60.00, buildCoordinates()));
        dbStationsManager.createStation(new Station("2:00am", "2:15am", "Museum Town", "Bus", 60.00, buildCoordinates()));
        dbStationsManager.createStation(new Station("7:00am", "7:15am", "New Town", "Bus", 60.00, buildCoordinates()));
        dbStationsManager.createStation(new Station("12:00am", "12:15am", "Central", "Train", 60.00, buildCoordinates()));
        dbStationsManager.createStation(new Station("2:00am", "2:15am", "Townhall", "Train", 60.00, buildCoordinates()));
        dbStationsManager.createStation(new Station("7:00am", "7:15am", "Redfern", "Train", 60.00, buildCoordinates()));
        dbStationsManager.createStation(new Station("12:00am", "12:15am", "Circular Quay", "Train", 60.00, buildCoordinates()));
        dbStationsManager.createStation(new Station("2:00am", "2:15am", "Museum Town", "Train", 60.00, buildCoordinates()));
        dbStationsManager.createStation(new Station("7:00am", "7:15am", "New Town", "Train", 60.00, buildCoordinates()));
    }

    private static ArrayList<Integer> buildCoordinates() {
        ArrayList<Integer> coords = new ArrayList<>();
        Random random = new Random();

        int x = random.nextInt(20 - 1 + 1) + 1;
        int y = random.nextInt(20 - 1 + 1) + 1;
        coords.add(x);
        coords.add(y);

        return coords;

    }
}
