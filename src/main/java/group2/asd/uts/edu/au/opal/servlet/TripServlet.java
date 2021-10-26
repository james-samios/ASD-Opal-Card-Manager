package group2.asd.uts.edu.au.opal.servlet;

import group2.asd.uts.edu.au.opal.dao.DBStationsManager;
import group2.asd.uts.edu.au.opal.dao.DBTripManager;
import group2.asd.uts.edu.au.opal.model.Customer;
import group2.asd.uts.edu.au.opal.model.Station;
import group2.asd.uts.edu.au.opal.model.Trip;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TripServlet", value = "/trips")
public class TripServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBTripManager dbTripManager = new DBTripManager();
        String location = request.getParameter("location");
        String destination = request.getParameter("destination");
        String method = request.getParameter("method");
        HttpSession session = request.getSession();
        if (method == null) {
            DBStationsManager dbStationsManager = new DBStationsManager();
            Station locationStation = dbStationsManager.findStation(location);
            Station destinationStation = dbStationsManager.findStation(destination);

            // Compute time between stations
            int x1 = locationStation.getCoordinates().get(0);
            int y1 = locationStation.getCoordinates().get(1);

            int x2 = destinationStation.getCoordinates().get(0);
            int y2 = destinationStation.getCoordinates().get(1);
            Double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

            Double fare = Math.pow(distance * 1.40, 2);
            try {
                dbTripManager.createTrip(new Trip(
                        locationStation.getName(),
                        destinationStation.getName(),
                        new SimpleDateFormat("HH:mm:ss").parse(locationStation.getDepartureTime().replace("am", ":00").replace("pm", ":00")),
                        new SimpleDateFormat("HH:mm:ss").parse(destinationStation.getArrivalTime().replace("am", ":00").replace("pm", ":00")),
                        fare));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            List<Trip> trips = dbTripManager.readTrips();


            session.setAttribute("location", locationStation);
            session.setAttribute("destination", destinationStation);
            session.setAttribute("distance", distance.intValue());
            session.setAttribute("fare", fare.intValue());
            session.setAttribute("trips", trips);
            request.getRequestDispatcher("/trips.jsp").forward(request, response);
        }else if(method.equals("delete")){
            String trip = request.getParameter("trip");

            dbTripManager.deleteTripByID(trip);
            List<Trip> trips = dbTripManager.readTrips();
            session.setAttribute("trips", trips);
            request.getRequestDispatcher("/trips.jsp").forward(request, response);

        } else if(method.equals("update")){
            String tripId = request.getParameter("trip_id");
            Double fare = Double.parseDouble(request.getParameter("fare"));

            Trip trip  = null;
            trip = new Trip(
                    location,
                    destination,
                    new Date(),
                    new Date(),
                    fare);
            trip.setObjectId(new ObjectId(tripId));
            dbTripManager.deleteTripByID(tripId);
            dbTripManager.createTrip(trip);
            session.setAttribute("trip", trip);

            List<Trip> trips = dbTripManager.readTrips();
            session.setAttribute("trips", trips);
            request.getRequestDispatcher("/trips.jsp").forward(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Customer currentUser = (Customer) session.getAttribute("customer");
//        if (currentUser == null) {
//            req.getRequestDispatcher("/login.jsp").forward(req, resp);
//            return;
//        }
        String tripId = req.getParameter("trip");
        if (tripId == null) {
            req.getRequestDispatcher("/trips.jsp").forward(req, resp);
        } else {
            DBTripManager dbTripManager = new DBTripManager();
            Trip trip = dbTripManager.readTripByTripId(tripId);

            session.setAttribute("trip", trip);
            req.getRequestDispatcher("/trip_edit.jsp").forward(req, resp);
        }
    }
}
