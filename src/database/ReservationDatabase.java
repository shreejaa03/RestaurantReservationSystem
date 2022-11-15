package src.Database;

import src.Entity.Reservation;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Stores the reservation information for each date & time
 * @author Ivan PUa
 * @version 1.0
 * @since 10/11/2021
 */
public class ReservationDatabase {
    public static SortedMap<String, TreeMap<String, ArrayList<Reservation>>> reservationList;

    /**
     * Constructor to create ReservationDatabase
     */
    public ReservationDatabase() {
        reservationList = new TreeMap<String, TreeMap<String, ArrayList<Reservation>>>();
    }
}
