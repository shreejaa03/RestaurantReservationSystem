package src.Boundary;

import src.Control.CustomerManager;
import src.Entity.Customer;
import src.Entity.Membership;
import src.Entity.Person;

/**
 * UI for the Customer interface.
 * 
 * @author Fabian Wong
 * @version 1.0
 * @since 13/11/2021
 */

public class CustomerUI extends UI {

    /**
     * Driver method
     */
    public void run() {
        int choice = -1;
        // Continue to run as long as the input entered is within 1-3
        do {
            this.displayMenu();
            choice = getInput();

            switch (choice) {

            case 1:
                // Initialised the required attributes to create an (Member) Customer Object
				String firstName = "";
				String lastName = "";
				String gender = "";
				int contact = -1;
				String membership = "";
				// Obtaining a valid employee First Name
				System.out.println("Please Enter the Customer's First Name: ");
				firstName = super.getInputString();
				// Obtaining a valid employee Last Name
				System.out.println("Please Enter the Customer's Last Name: ");
				lastName = super.getInputString();
				// Obtaining a valid employee Gender
				System.out.println("Please Enter the Customer's Gender (Male/Female): ");
				gender = super.getInputString(Person.returnGenderSynonym());
				// Obtaining a valid employee Contact Number
				System.out.println("Please Enter the Customer's Contact Number (8xxxxxxx - 9xxxxxxx): ");
				contact = super.getValidContactNumber(true);
				// Obtaining a valid employee Title
				System.out.println("Please Enter the Customer's Membership Type: ");
				membership = super.getInputString(Membership.getAvailableMembership());
				// Adding the Employee to the employee list using the manager
				CustomerManager.newMembership(firstName, lastName, gender, contact, membership);
                break;
            case 2:
                displayCustomerDB();
                int cContact = -1;
                // Obtaining a valid customer Contact Number
                System.out.println("Please Enter the Customer's Contact Number (8xxxxxxx - 9xxxxxxx): ");
                cContact = super.getValidContactNumber(false);
                // Checking the membership for the Customer via the contact number
                CustomerManager.checkMembership(cContact);
                break;
            case 3:
                displayCustomerDB();
                int rContact = -1;
                // Obtaining a valid customer Contact Number
                System.out.println("Please Enter the Customer's Contact Number (8xxxxxxx - 9xxxxxxx): ");
                rContact = super.getValidContactNumber(false);
                // Removing the membership for the Customer via the contact number
                CustomerManager.removeMembership(rContact);
                break;
            default:
                break;
            }
        } while (choice < 4 && choice > 0);
    }

    // Displaying the UI menu for Altering Customers
    /**
     * Displays the menu
     */
    public void displayMenu() {
        System.out.println("\n################# CUSTOMER MENU #################");
        System.out.println("1. New Membership.");
        System.out.println("2. Check Membership.");
        System.out.println("3. Remove Membership");
        System.out.println("4. Back.");
    }

    // Displaying every customer information stored by the restaurant
    /**
     * Displays the customers in the Database
     */
    public void displayCustomerDB() {
        System.out.println(
                "============================CUSTOMER INFORMATION AVAILABLE====================================");
        for (Person p : CustomerManager.customers) {
            Customer c = (Customer) p;
            if (c.getMember())
                c.printMinimal();
        }
        System.out.println("================================================================================");
        System.out.println();

    }
}