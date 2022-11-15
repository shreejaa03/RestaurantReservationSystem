package src.Boundary;


public class MainMenuUI extends UI {

    /**
     * Displays the Main Menu
     */
    public void displayMenu(String restaurantName) {
        System.out.println("\nWelcome to " + restaurantName + " RRPSS!");
        System.out.println("################# MAIN MENU #################");
        System.out.println("Please select an option below.");
        System.out.println("1. Make an order.");
        System.out.println("2. Make a reservation.");
        System.out.println("3. Make Payment.");
        System.out.println("4. Menu Settings.");
        System.out.println("5. Employee Settings.");
        System.out.println("6. Customer Settings.");
        System.out.println("7. Restaurant Settings.");
        System.out.println("8. Print Sales Revenue Report.");
        System.out.println("9. Exit.");
    }
}