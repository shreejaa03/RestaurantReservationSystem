package src.Control;

import java.util.List;
import src.Entity.Person;
import src.Entity.Employee;
import src.Database.Database;

/**
 * Control class Employee Manager.
 * 
 * @author Fabian Wong
 * @version 1.0
 * @since 13/11/2021
 */

public class EmployeeManager {


	public static List<Person> employees = Database.employeesDB;

	/**
	 * Adding a new employee to the database.
	 * @param firstName The first name of the employee.
	 * @param LastName The last name of the employee.
	 * @param gender The gender of the employee.
	 * @param contact The contact of the employee.
	 * @param id The id of the employee.
	 */
	public static void addEmployee(String firstName, String lastName, String gender, int contact, int id,
			String title) {
		Person employee = new Employee(firstName, lastName, gender, contact, id, title);
		employees.add(employee);
		System.out.println("[ACCEPTED] Employee Successfully Added!");
		employee.print();
	}

	/**
	 * Remove an exisiting employee from the Database
	 * @param id The id of the employee/
	 */
	public static void removeEmployee(int id) {
		for (Person p : employees) {
			// Found the employee to remove from the Database
			if (((Employee) p).getID() == id) {
				employees.remove(p);
				System.out.println("[ACCEPTED] Employee ID " + id + ": removed");
				return;
			}
		}
		// Unable to find the employee to remove from the Database
		System.out.println("[REJECTED] Employee ID " + id + ": Cant be found!");
	}

	/**
	 * Updates contact/title of an exisiting employee to the Database
	 * @param id The new ID of the employee.
	 * @param contact The new contact of the employee.
	 * @param title The new title of the employee.
	 */
	public static void editEmployee(int id, int contact, String title) {
		for (Person p : employees) {
			// Found the employee to update the information
			if (((Employee) p).getID() == id) {
				// Contact number to update is provided
				if (contact != -1)
					((Employee) p).setContact(contact);
				// Title to update is provided
				if (!title.equals(""))
					((Employee) p).setTitle(title);
				System.out.println("[ACCEPTED] Employee " + id + ": updated Personal Info");
				p.print();
				return;
			}
		}
		// Unable to find the employee to update the information
		System.out.println("[REJECTED] Employee " + id + ": Cant be found!");
	}
	
	/**
	 * Displays all employees information.
	 */
	public static void showAllEmployees() {
		for (Person p : employees) {
			Employee e = (Employee) p;
			System.out.printf("Employee ID: %d, Name: %s, Title: %s, Gender: %s, Contact: %d\n", e.getID(), e.getName(),
					e.getTitle(), e.getGender(), e.getContact());
		}
	}

	/**
	 * Shows employee information by ID
	 * @param id The id of the employee.
	 * @return status flag
	 */
	public static Boolean getEmployeeByID(int id) {
		for (Person p : employees) {
			Employee e = (Employee) p;
			if (e.getID() == id) {
				System.out.printf("Employee ID: %d, Name: %s, Title: %s, Gender: %s, Contact: %d\n", e.getID(),
						e.getName(), e.getTitle(), e.getGender(), e.getContact());
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the employee Database
	 */
	public static List<Person> getEmployeeList() {
		return employees;
	}
}



