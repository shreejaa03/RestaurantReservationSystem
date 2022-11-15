package src.Boundary;

import java.util.Arrays;

import src.Database.*;

/**
 * UI for the Revenue interface.
 * 
 * @author Fabian Wong
 * @version 1.0
 * @since 13/11/2021
 */

public class RevenueUI extends UI {
    /**
     * Driver method
     */
    public void run() {
        int choice = -1;
        int orderID = 0;

        do {
            this.displayMenu();
            choice = getInput();
            if (choice == 1)
            {
                String option = "";
                int day = 0;
                int month = 0;           
                System.out.println("Display by month? (Y/N): ");
                option = super.getInputString(UI.booleanOption());
                if (Arrays.asList(UI.yesOption).contains(option)) {
					System.out.println("Please Enter the month : ");
                    month = super.getInput();
				}
                else
                {
                    System.out.println("Please Enter the day : ");
                    day = super.getInput();
                    System.out.println("Please Enter the month : ");
                    month = super.getInput();
                }
                Database.computeRevenue("src/Database/csv/Orders.csv", day, month);
            }
        } while (choice < 2);
    }

    /**
     * Displays the menu
     */
    public void displayMenu() {
        System.out.println("################# REVENUE MENU #################");
        System.out.println("Please select an option below.");
        System.out.println("1. Display Revenue by Month/Day.");
        System.out.println("2. Back.");

    }
}