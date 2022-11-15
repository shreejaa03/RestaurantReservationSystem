package src.Boundary;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import src.Entity.Employee;
import src.Entity.Person;
import src.Control.EmployeeManager;
import src.Database.Database;

public class UI {
	private Scanner sc = new Scanner(System.in);

	// Variations of the word with the meaning of Yes/No:
	// Add in to the array if any other variation is needed. Eg. {"Yes, "Y", "Yes!"}
	// Right now is Case-sensitive
	public static String[] yesOption = { "Yes", "Y" };
	public static String[] noOption = { "No", "N" };

	// Obtain input as only integer
	public int getInput() {

		// Initialise a variable to store the input
		int userInput = -1;
		// Condition for obtaining a valid input
		boolean handled = false;
		// Continue to prompt the user if input entered is not an Integer
		do {
			// Test if input entered is integer
			try {
				userInput = sc.nextInt();
				sc.nextLine();
				// Input entered is integer
				handled = true;
			} catch (InputMismatchException e) {
				// Input entered is not integer
				System.out.println("Error! Option must be an Integer! Please try again.");
				sc.next();
			}
		} while (!handled);

		// Return the valid input from user
		return userInput;
	}

	// Obtain input as only double
	public double getDouble() {

		// Initialise a variable to store the input
		double userInput = -1;
		// Condition for obtaining a valid input
		boolean handled = false;
		// Continue to prompt the user if input entered is not an Integer
		do {
			// Test if input entered is integer
			try {
				userInput = sc.nextDouble();
				sc.nextLine();
				// Input entered is integer
				handled = true;
			} catch (InputMismatchException e) {
				// Input entered is not integer
				System.out.println("Error! Option must be an double! Please try again.");
				sc.next();
			}
		} while (!handled);

		// Return the valid input from user
		return userInput;
	}

	// Obtain input as string will only letters
	public String getInputString() {

		// Initialise a variable to store the input
		String userInput = "";
		// Condition for obtaining a valid input
		boolean handled = false;
		// Continue to prompt the user if input entered is not a String and String does
		// not only contain letters
		do {
			try {
				userInput = sc.nextLine();
				// Input entered is a string and contains only letters
				if (userInput.length() == userInput.replaceAll("[^a-zA-Z ]", "").length())
					handled = true;
				// Input entered is a string but does not contain only letters
				else
					System.out.println("Error! Option must only contain letters! Please try again.");
			} catch (InputMismatchException e) {
				// Input entered is not a string
				System.out.println("Error! Option must be a String! Please try again.");
				sc.next();
			}
		} while (!handled);

		// Return the valid input from user
		return userInput;
	}

	// Obtain input as String that is contained in the String array provided
	public String getInputString(String[] stringToCheck) {

		// Initialise a variable to store the input
		String userInput = "";
		// Condition for obtaining a valid input
		boolean handled = false;

		List <String> checker = new ArrayList<String>();
		for(String s : stringToCheck){
			checker.add(s.toUpperCase());
		}
		// Continue to prompt the user if input entered is not a String and the String
		// entered does not exist in the string array
		do {
			try {
				userInput = sc.nextLine();
				//System.out.println("Input: " + userInput);
				// Input entered is a string and exist in the string array provided
				if (checker.contains(userInput.toUpperCase())) {
					handled = true;
				}
				// Input entered is a string but does not exist in the string array provided
				else {
					System.out.println("Error! Please only enter the option available! Please try again.");
				}

			} catch (InputMismatchException e) {
				// Input entered is not a string
				System.out.println("Error! Option must only contain letters! Please try again.");
				sc.next();
			}
		} while (!handled);

		// Return the valid input from user
		return userInput;
	}

	// Obtain input as a valid ID
	// If check == false, it checks if the ID exist. If it exist, it is not usable
	// as it is trying to obtain a new non-negative ID: CHECK FOR NON-EXISTING ID
	// If check == true, it checks if the ID exist. If it exist, the id is valid for
	// use: CHECKING FOR EXISTING ID
	public int getValidID(boolean check) {
		// Initialise a variable to store the input
		int userInput = -1;
		// Condition for obtaining a valid input
		boolean handled = false;
		// Continue to prompt the user if input entered is not an Integer and it is not
		// a valid ID
		do {
			try {
				userInput = sc.nextInt();
				sc.nextLine();
				boolean idExist = check;
				// Check if employee ID exist in the employees list in the Employee Manager
				for (Person p : EmployeeManager.employees) {
					// The input ID Exist
					if (((Employee) p).getID() == userInput) {
						if (check == false)
							System.out.println("Error! ID already Exist");
						idExist = !idExist;
						break;
					}
				}
				// Input entered is an Integer and currently does not exist
				if (!idExist) {
					// Check if input entered is non-negative
					if (userInput < 0)
						System.out.println("Error! ID cannot be negative");
					else
						handled = true;
				}
				// Input entered is not an existing ID in the employee list
				if (check == true && idExist)
					System.out.println("Error! ID does not Exist");
			} catch (InputMismatchException e) {
				// Input entered is not an Integer
				System.out.println("Error! Option must be an Integer! Please try again.");
				sc.next();
			}
		} while (!handled);

		// Return the valid input from user
		return userInput;

	}

	// Obtain input as a valid phone number from 8xxx xxxx - 9xxx xxxx (Valid SG
	// Phone Number)
	// If check == true, it checks if the contact number exist. If it exist, it is
	// not usable as it is trying to obtain a new valid contact number: CHECK FOR
	// NON-EXISTING ID
	// If check == false, it checks if the contact number exist. If it exist, the
	// contact number is valid for use: CHECKING FOR EXISTING ID
	public int getValidContactNumber(boolean check) {
		// Initialise a variable to store the input
		int userInput = -1;
		// Condition for obtaining a valid input
		boolean handled = false;
		// Continue to prompt the user if input entered is not an Integer and it is not
		// a valid Phone number
		do {
			try {
				userInput = sc.nextInt();
				sc.nextLine();
				double validNum = ((double) userInput) / 80000000.0f;
				boolean useable = check;
				// Input enter is a number between 8xxx xxxx - 9xxx xxxx
				if (validNum >= 1.0f && validNum < 1.25f) {
					// Check if the number already exist in the database (NO DUPLICATE PHONE
					// NUMBERS)
					for (Person p : Database.getPersonList()) {
						if (p.getContact() == userInput) {
							useable = !useable;
							break;
						}
					}
					// Input entered is a non-existing phone number in the database
					if (useable) {
						handled = true;

					}
					// Input entered is an existing phone number in the database
					else if (useable && check == true)
						System.out.println(
								"Error! The phone number already exist for another person, please ensure you typed in the correct phone number");
					else
						System.out.println(
								"Error! The phone number does not belong to any existing person in the database");
				}
				// Input enter is not a number between 8xxx xxxx - 9xxx xxxx
				else {
					System.out.println(
							"Error! Please enter a valid Phone Number (8xxxxxxx - 9xxxxxxx) ! Please try again.");
				}

			} catch (InputMismatchException e) {
				// Input entered is not an Integer
				System.out.println("Error! Option must be an Integer! Please try again.");
				sc.next();
			}
		} while (!handled);

		// Return the valid input from user
		return userInput;

	}

	// Combining all the options available as YES & NO for checking if input is
	// valid
	public static String[] booleanOption() {
		String[] booleans = new String[yesOption.length + noOption.length];
		System.arraycopy(yesOption, 0, booleans, 0, yesOption.length);
		System.arraycopy(noOption, 0, booleans, yesOption.length, noOption.length);
		return booleans;
	}

	public String getString() {
		String userInput = "";
		boolean handled = false;
		do {
			try {
				userInput = sc.nextLine();
				handled = true;
			} catch (InputMismatchException e) {
				System.out.println("Error! Input must be a string! Please try again.");
			}
		} while (!handled);

		return userInput;
	}
}