import src.Entity.Restaurant;
import src.Database.Database;

/**
 * A Restaurant Reservation & Point of Sale System (RRPSS)
 * Users can computerize the process of making reservations, order taking,
 * and displaying of records. This system is intended to be used solely by restaurant staff only
 * 
 * @author Ivan Pua
 * @author Reeves Chiu
 * @author Fabian
 * @author Shreejaa
 * @version 1.0
 * @since 24/10/2021
 */
public class app {
	/**
	 * Driver program to run the system
	 * @param args no args accepted
	 */
	public static void main(String[] args) {
		String RESTAURANT_NAME = "McDonalds"; // TODO: think of a restaurant name
		Database.restaurantName = RESTAURANT_NAME;
		Restaurant awesomeRestaurant = new Restaurant(RESTAURANT_NAME);
		
		initDB(); // initialize the database with items from csv files

		awesomeRestaurant.run();
	}

	/**
	 * Initialises database with records form CSV files
	 */
	private static void initDB() {
		Database.parseCSV("src/Database/csv");
		// Database.printDatabase();
	}
}
