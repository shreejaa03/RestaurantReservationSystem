package src.Control;

import src.Boundary.*;
import src.Entity.Restaurant;

/**
 * The main UI that connects to the other Menus
 * 
 * @author Ivan Pua
 * @version 1.0
 * @since 24/10/2021
 */
public class MainMenuManager {
	private MainMenuUI mainMenuUI = new MainMenuUI();
	private FoodMenuUI foodMenu = new FoodMenuUI();
	private OrderUI orderMenu = new OrderUI();
	private EmployeeUI employeeMenu = new EmployeeUI();
	private ReservationUI reservationMenu = new ReservationUI();
	private CustomerUI customerMenu = new CustomerUI();
	private PaymentUI paymentMenu = new PaymentUI();
	private TableUI tableMenu = new TableUI();
	private RevenueUI revenueMenu = new RevenueUI();

	/**
	 * Driver method for the entire system
	 * Infinite while loop allows the program to continue execution until user decides to exit
	 * @param restaurant The instance of the restarant
	 */
	public void run(Restaurant restaurant) {
		int choice = -1;

		// App loop
		while (true) {

			mainMenuUI.displayMenu(restaurant.getName());
			choice = mainMenuUI.getInput();

			switch (choice) {
				case 1:
					orderMenu.run();
					break;
				case 2:
					reservationMenu.run();
					break;
				case 3:
					paymentMenu.run();
					break;
				case 4:
					foodMenu.run();
					break;
				case 5:
					employeeMenu.run();
					break;
				case 6:
					customerMenu.run();
					break;
				case 7:
					tableMenu.run();
					break;
				case 8:
					revenueMenu.run();
				default:
					System.out.println("System Shutting Down...");
					break;
			}

			if (choice >= 9) break;
		}
	}
}