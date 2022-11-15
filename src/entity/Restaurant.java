package src.Entity;


import src.Control.MainMenuManager;

/**
 * Stores related information about restaurant instance
 * 
 * @author Ivan Pua
 * @version 1.0
 * @since 13/11/2021
 */
public class Restaurant {

	private static String name;

	/**
	 * Constructor for restaurant
	 * @param name The name of the restaurant
	 */
	public Restaurant(String name) {
		Restaurant.name = name;
		// employeeList = new HashMap<Integer, Employee>(); // Map employee ID to corresponding Employee object
		// tableList = new ArrayList<Table>();
	}

	/**
	 * Driver program
	 */
	public void run() {
		MainMenuManager mainMenu = new MainMenuManager();
		mainMenu.run(this);
	}

	/**
	 * @return The restaurant name
	 */
	public static String getName() {
		return name;
	}

	/**
	 * Set restaurant name
	 */
	public void setName(String name) {
		Restaurant.name = name;
	}
}