package src.Boundary;

import java.util.Arrays;

import src.Control.EmployeeManager;
import src.Entity.Employee;
import src.Entity.Person;


/**
 * UI for the Employee interface.
 * 
 * @author Fabian Wong
 * @version 1.0
 * @since 13/11/2021
 */

public class EmployeeUI extends UI {

	/**
	 * Driver method
	 */
	public void run() {
		int choice = -1;
		// Continue to run as long as the input entered is within 1-3
		do {
			// Display the option available for altering Employee database
			this.displayMenu();
			// Obtain the option entered
			choice = getInput();
			switch (choice) {
			// Adding a new Employee
			case 1:

				// Initialised the required attributes to create an Employee Object
				String firstName = "";
				String lastName = "";
				String gender = "";
				int contact = -1;
				int id = -1;
				String title = "";
				// Obtaining a valid new employee ID
				System.out.println("Please Enter the Employee's ID: ");
				id = getValidID(false);
				// Obtaining a valid employee First Name
				System.out.println("Please Enter the Employee's First Name: ");
				firstName = super.getInputString();
				// Obtaining a valid employee Last Name
				System.out.println("Please Enter the Employee's Last Name: ");
				lastName = super.getInputString();
				// Obtaining a valid employee Gender
				System.out.println("Please Enter the Employee's Gender (Male/Female): ");
				gender = super.getInputString(Person.returnGenderSynonym());
				// Obtaining a valid employee Contact Number
				System.out.println("Please Enter the Employee's Contact Number (8xxxxxxx - 9xxxxxxx): ");
				contact = super.getValidContactNumber(true);
				// Obtaining a valid employee Title
				System.out.println("Please Enter the Employee's Title: ");
				title = super.getInputString(
						Employee.getTitleList(true).toArray(new String[Employee.getTitleList(false).size()]));
				// Adding the Employee to the employee list using the manager
				EmployeeManager.addEmployee(firstName, lastName, gender, contact, id, title);
				break;
			// Removing an existing employee
			case 2:
				// Obtaining a valid exisiting employee ID
				System.out.println("Please Enter the Employee's ID: ");
				id = getValidID(true);
				// Removing the Employee from the employee list using the manager
				EmployeeManager.removeEmployee(id);
				break;
			// Updating information of an existing employee
			case 3:
				int uid = -1;
				int uContact = -1;
				String uTitle = "";
				// Obtaining a valid exisiting employee ID
				System.out.println("Please Enter the Employee's ID: ");
				uid = getValidID(true);
				String option = "";
				// Prompt the user if the selected information requires changes
				System.out.println("Do you want to change the contact (Y/N): ");
				option = super.getInputString(UI.booleanOption());
				// Information requires changing
				if (Arrays.asList(UI.yesOption).contains(option)) {
					// Obtaining a valid employee Contact Number
					System.out.println("Please Enter the updated Employee's Contact Number (8xxxxxxx - 9xxxxxxx): ");
					uContact = super.getValidContactNumber(true);
				}
				// Prompt the user if the selected information requires changes
				System.out.println("Do you want to change the title (Y/N): ");
				option = super.getInputString(UI.booleanOption());
				// Information requires changing
				if (Arrays.asList(UI.yesOption).contains(option)) {
					// Obtaining a valid employee Title
					System.out.println("Please Enter the updated Employee's Title: ");
					uTitle = super.getInputString(
							Employee.getTitleList(true).toArray(new String[Employee.getTitleList(false).size()]));
				}
				// Updating the Employee information using the manager
				EmployeeManager.editEmployee(uid, uContact, uTitle);
				break;
			case 4:
				EmployeeManager.showAllEmployees();
				break;
			case 5:
				System.out.println("Enter employee's ID: ");
				int eid = getInput();
				Boolean res = EmployeeManager.getEmployeeByID(eid);
				if (!res)
					System.out.println("No employee with this ID was found");
			default:
				break;
			}
		} while (choice < 6 && choice > 0);
	}

	// Displaying the UI menu for Altering Employees
	/**
	 * Displays the menu
	 */
	public void displayMenu() {
		System.out.println("\n################# EMPLOYEE MENU #################");
		System.out.println("1. Add Employee.");
		System.out.println("2. Remove Employee.");
		System.out.println("3. Edit Employee.");
		System.out.println("4. Show all Employees.");
		System.out.println("5. Find employee by ID.");
		System.out.println("6. Back.");
	}
}