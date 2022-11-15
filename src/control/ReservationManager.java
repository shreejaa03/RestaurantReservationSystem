package src.Control;

import java.util.HashMap;
import java.util.TreeMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import src.Entity.Table;
import src.Database.TableDatabase;
import src.Database.ReservationDatabase;
import src.Entity.Reservation;

/**
 * Handles the control for the ReservationUI
 * 
 * @author Ivan Pua
 * @version 1.0
 * @since 13/11/2021
 */

public class ReservationManager {
	private ArrayList<String> availableDates;
	private HashMap<Integer, Table> availableTables;
	private int dateChoice;
	private int timeChoice;
	private int tableChoice;
	private String[] times = { "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30",
			"17:00", "17:30", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" };

	private String proxyDate;
	private String proxyTime;

	/**
	 * ReservationManager constructor Instantiates ReservationDatabase
	 */
	public ReservationManager() {
		new ReservationDatabase();
		this.initReservationList();
		this.availableDates = new ArrayList<String>();
	}

	/**
	 * Initialises reservationList
	 */
	private void initReservationList() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy, EEEE");
		Calendar calendar = Calendar.getInstance();

		for (int i = 1; i < 8; i++) {
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 1);
			Date nextDate = calendar.getTime();
			ReservationDatabase.reservationList.put(dateFormat.format(nextDate), this.initInnerHashMap());
			date = nextDate;
		}
	}

	/**
	 * Initialises the inner TreeMap to insert into reservationList
	 * 
	 * @return Returns the initialised inner TreeMap
	 */
	private TreeMap<String, ArrayList<Reservation>> initInnerHashMap() {
		TreeMap<String, ArrayList<Reservation>> r = new TreeMap<String, ArrayList<Reservation>>();

		for (int i = 0; i < times.length; i++) {
			r.put(times[i], new ArrayList<Reservation>());
		}

		return r;
	}

	/**
	 * Shows all existing reservations
	 */
	public void showAllReservations() {
		Object[] dateKeys = ReservationDatabase.reservationList.keySet().toArray();
		for (int i = 0; i < dateKeys.length; i++) {
			System.out.println();
			System.out.println(dateKeys[i]);
			System.out.println("#################################################");

			ReservationDatabase.reservationList.get(dateKeys[i]).forEach((k, v) -> {
				System.out.println("\nTimeslot: " + k);
				System.out.println("==============================================");
				if (v.isEmpty()) {
					System.out.println("Currently no reservations on this timeslot.\n");
				} else {
					for (int j = 0; j < v.size(); j++) {
						System.out.printf("Table#: %d\t Name: %s\t Contact: %d\n", v.get(j).getTable().getId(),
								v.get(j).getName(), v.get(j).getContact());
					}
				}
			});
		}
	}

	/**
	 * Shows all reservations for a particular contact number
	 * 
	 * @param contactNum The customer's contact number
	 */
	public void showAllReservations(int contactNum) {
		Object[] dateKeys = ReservationDatabase.reservationList.keySet().toArray();
		for (int i = 0; i < dateKeys.length; i++) {
			Object dateKey = dateKeys[i];
			ReservationDatabase.reservationList.get(dateKeys[i]).forEach((k, v) -> {
				for (int j = 0; j < v.size(); j++) {
					if (v.get(j).getContact() == contactNum) {
						System.out.println();
						System.out.println(dateKey);
						System.out.println("#################################################");
						System.out.println("\nTimeslot: " + k);
						System.out.println("==============================================");
						System.out.printf("Table#: %d\t Name: %s\t Contact: %d\n", v.get(j).getTable().getId(),
								v.get(j).getName(), v.get(j).getContact());
					}
				}
			});
		}
	}

	/**
	 * Shows all existing reservation by date
	 * 
	 * @deprecated not in use
	 */
	public void showReservationByDate() {
		Object[] dateKeys = ReservationDatabase.reservationList.keySet().toArray();
		for (int i = 0; i < dateKeys.length; i++) {
			System.out.printf("%d. %s\n", i + 1, dateKeys[i]);
		}
	}

	/**
	 * Displays the available dates for reservation
	 */
	public void displayDates() {
		this.availableDates.clear();

		ReservationDatabase.reservationList.forEach((k, v) -> {
			this.availableDates.add(k);
		});

		for (int i = 0; i < this.availableDates.size(); i++) {
			System.out.printf("%d. %s\n", i + 1, this.availableDates.get(i));
		}
	}

	/**
	 * Gets the date choice from user
	 * 
	 * @param dateChoice The choice of date from the user
	 */
	public void getDateChoice(int dateChoice) {
		this.dateChoice = dateChoice;
		System.out.printf("\n%s selected.\n", this.availableDates.get(dateChoice - 1));
	}

	/**
	 * Displays the available timeslots for reservation
	 */
	public void displayTimes() {
		for (int i = 0; i < times.length; i++) {
			System.out.printf("%d. %s\n", i + 1, times[i]);
		}
	}

	/**
	 * Gets the time choice from user
	 * 
	 * @param timeChoice The choice of reservation time from the user
	 */
	public void getTimeChoice(int timeChoice) {
		this.timeChoice = timeChoice;
		System.out.printf("\n%s selected.\n", times[timeChoice - 1]);
	}

	/**
	 * Get table choice from user
	 * 
	 * @param tableChoice The table selected to be reserved by the user
	 */
	public void getTableChoice(int tableChoice) {
		if (!this.availableTables.containsKey(tableChoice) || this.availableTables.get(tableChoice).isTaken())
			throw new NullPointerException("Table number not available");

		this.tableChoice = tableChoice;
	}

	/**
	 * Check current availability of tables and display them
	 * 
	 * @return A boolean value representing if the selected date & time is available
	 *         for reservation
	 */
	public Boolean checkAvailability() {
		String date = this.availableDates.get(this.dateChoice - 1);
		String time = this.times[this.timeChoice - 1];
		Boolean full = false;

		// This is an ArrayList of booked tables for that time and date
		ArrayList<Reservation> reservedTables = ReservationDatabase.reservationList.get(date).get(time);

		// HasmMap to store available tables. Mapping: TableID -> Table
		this.availableTables = TableDatabase.tableList;

		// Compare with all restaurant tables to find which ones are not on the list
		// Not on reservation list means it is not reserved
		if (!reservedTables.isEmpty()) {
			for (int i = 0; i < reservedTables.size(); i++)
				this.availableTables.remove(reservedTables.get(i).getTable().getId()); // remove reserved tables so that
																						// un-reserved tables can be
																						// shown
		} else if (reservedTables.size() == TableDatabase.tableList.size()) {
			full = true;
		}

		// show tables available for selected date & time
		if (!full) {
			System.out.printf("Available tables for %s, %s:\n", this.availableDates.get(this.dateChoice - 1),
					times[this.timeChoice - 1]);
			System.out.println("#################################################");
			for (int i = 0; i < this.availableTables.size(); i++) {
				Table t = this.availableTables.get(i + 1);
				if (t != null) {
					System.out.printf("%d. Table %d \t # Seats: %d \t Taken: %b\n", i + 1, t.getId(), t.getSeats(),
							t.isTaken());
				}
			}
		} else {
			System.out.printf("Reservation is full for %s, %s:\n", this.availableDates.get(this.dateChoice - 1),
					times[this.timeChoice - 1]);
			return false;
		}
		return true;
	}

	/**
	 * Inserts a reservation into reservationList
	 * 
	 * @param custName   The customer's name
	 * @param contactNum The customer's contact number
	 * @param numPax     Party size
	 */
	public void makeReservation(String custName, int contactNum, int numPax) {
		Table t = this.availableTables.get(this.tableChoice);

		if (numPax > t.getSeats()) {
			this.availableDates.clear();
			throw new IllegalArgumentException("Pax > Seats");
		}

		Reservation newReservation = new Reservation(custName, numPax, contactNum, t,
				this.availableDates.get(this.dateChoice - 1), times[this.timeChoice - 1]);
		ReservationDatabase.reservationList.get(this.availableDates.get(this.dateChoice - 1))
				.get(times[this.timeChoice - 1]).add(newReservation);
		this.availableDates.clear();
	}

	/**
	 * Removes a reservation of a specified customer by contact number
	 * 
	 * @param contactNum The customer's contact number
	 */
	public void removeReservation(int contactNum) {
		ReservationDatabase.reservationList.forEach((k, v) -> {
			v.forEach((time, res) -> {
				for (int i = 0; i < res.size(); i++) {
					if (res.get(i).getContact() == contactNum) {
						System.out.printf("Removing reservation for %s at %s, %s\n", res.get(i).getName(),
								res.get(i).getDate(), res.get(i).getTime());
						res.remove(i);
						System.out.println("Successfully removed");
					}
				}
			});
		});
	}

	/**
	 * Sets a proxy date to simulate the auto removal of reservation upon
	 * reservation date
	 * 
	 * @param date The date to be simulated
	 * @param time The time to be simulated
	 */
	public void setProxyDateTime(String date, String time) {
		this.proxyDate = date;
		this.proxyTime = time;
	}

	/**
	 * Simulates the removal of reservation upon reservation date & time after XX
	 * amount of time
	 * 
	 * @throws ParseException Exception occurs when the date & time input by user
	 *                        cannot be parsed
	 */
	public void simulateAutoRemove() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat formatDateTo = new SimpleDateFormat("MM-dd-yyyy, EEEE");
		Date d = dateFormat.parse(this.proxyDate);
		String sd = formatDateTo.format(d);

		ArrayList<Reservation> reservations = ReservationDatabase.reservationList.get(sd).get(this.proxyTime);
		if (!reservations.isEmpty()) {

			String time = this.proxyTime;
			TimerTask tt = new TimerTask() {
				@Override
				public void run() {
					reservations.clear();
					System.out.println("===============<SYSTEM MESSAGE>===============\n");
					System.out.println("Reservations cleared for " + sd + " " + time);
					System.out.println("\n===============<SYSTEM MESSAGE>===============");
					return;
				}
			};
			Timer t = new Timer();
			t.schedule(tt, 5000);
		} else {
			System.out.println("No reservations at this time.");
		}
	}
}