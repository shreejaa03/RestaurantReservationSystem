package src.Boundary;

import java.text.ParseException;

import src.Control.ReservationManager;

/**
 * UI for the reservation interface.
 * 
 * @author Ivan Pua
 * @version 1.0
 * @since 13/11/2021
 */
public class ReservationUI extends UI {
    private ReservationManager reservationManager = new ReservationManager();

    /**
     * Driver method. Handles all the UI display and user inputs
     */
    public void run() {
        int choice = -1;
        String custName;
        Boolean handled = false;

        do {
            this.displayMenu();
            choice = getInput();

            switch (choice) {
            case 1:
                int numPax = -1;
                Boolean isAvailable = false;
                int contactNum = -1;

                System.out.println("\nSelect date of reservation (MM-DD-YYYY): ");
                reservationManager.displayDates();
                try {
                    reservationManager.getDateChoice(getInput());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Incorrect value entered.");
                    System.out.println("Please try again.");
                    break;
                }

                System.out.println("\nSelect timeslot of reservation: ");
                reservationManager.displayTimes();
                try {
                    reservationManager.getTimeChoice(getInput());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Incorrect value entered.");
                    System.out.println("Please try again.");
                    break;
                }

                isAvailable = reservationManager.checkAvailability();

                if (!isAvailable) {
                    break;
                } else {
                    System.out.println("Select a Table: ");
                    do {
                        try {
                            reservationManager.getTableChoice(getInput());
                            handled = true;
                        } catch (NullPointerException e) {
                            System.out.println("Table you have selected is not available/does not exist.");
                            System.out.println("Please try again.");
                            System.out.println("Select a Table: ");
                        }
                    } while (!handled);
                    handled = false;

                    System.out.println("Enter Customer Name: ");
                    custName = getInputString();

                    System.out.println("Enter contact number: ");
                    contactNum = getInput();

                    System.out.println("Enter number of pax: ");
                    numPax = getInput();

                    try {
                        reservationManager.makeReservation(custName, contactNum, numPax);
                        System.out.println("Reservation added successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("# Pax is more than available seats for the table");
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Enter contact number: ");
                reservationManager.removeReservation(getInput());
                break;
            case 3:
                reservationManager.showAllReservations();
                break;
            case 4:
                System.out.println("Enter contact number: ");
                reservationManager.showAllReservations(getInput());
                break;
            case 5:
                System.out.println("\n============================================================");
                System.out.println("This option simulates the auto removal of a reservation");
                System.out.println("5 seconds after the reservation booking time has reached.");
                System.out.println("============================================================");
                System.out.println("Set Date");
                System.out.println("Enter Date (MM-DD-YYYY):");
                String date = getString();

                System.out.println("Set Time");
                System.out.println("Enter Time (HH:MM) 24 Hour format: ");
                String time = getString();

                reservationManager.setProxyDateTime(date, time);

                try {
                    reservationManager.simulateAutoRemove();
                } catch (ParseException e) {
                    System.out.println("Invalid date/time.");
                }
            default:
                break;
            }
        } while (choice > 0 && choice < 6);
    }

    /**
     * Displays the reservation menu.
     */
    public void displayMenu() {
        System.out.println("\n################# RESERVATION MENU #################");
        System.out.println("1. Make Reservation.");
        System.out.println("2. Remove Reservation.");
        System.out.println("3. Check Reservation.");
        System.out.println("4. Check Reservation by Contact Number.");
        System.out.println("5. Simulate Reservation Auto Remove");
        System.out.println("6. Back.");
    }
}