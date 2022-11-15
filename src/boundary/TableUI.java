package src.Boundary;

import src.Control.TableManager;
/**
 * UI for instantiating/deleting tables
 */
public class TableUI extends UI {
    private TableManager tableManager = new TableManager();

    /**
     * Driver method for running the UI
     */
    public void run() {
        int choice = -1;
        int tableID = -1, seats = -1;
        String response = "";

        do {
            this.displayMenu();
            choice = getInput();

            switch (choice) {
            case 1:
                System.out.println("Enter the Table ID to be created: ");
                tableID = getInput();

                System.out.println("Enter number of seats (EVEN number between 2 and 10): ");
                seats = getInput();
                try {
                    tableManager.addTable(tableID, seats);
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR]");
                    System.out.println("Number of seats must be an EVEN number between 2 and 10!");
                }
                break;
            case 2:
                System.out.println("Enter the Table ID to be removed: ");
                tableID = getInput();
                tableManager.removeTable(tableID);
                break;
            case 3:
                System.out.println("Are you sure you want to delete all tables? Y/N");
                System.out.println("You will lose all table information!");
                response = getString().toUpperCase();
                if (response.charAt(0) == 'Y') {
                    System.out.println("Deleting...");
                    tableManager.deleteAllTables();
                }
                else
                    break;
                break;
            case 4:
                System.out.println("Enter the ID of the table to view details.");
                tableID = getInput();
                tableManager.showTables(tableID);
                break;
            case 5:
                tableManager.showTables();
                break;
            case 6:
                tableManager.showTables(true); // set arg to true to show unoccupied tables
                break;
            case 7:
                tableManager.showTables(false); // set arg to false to show unoccupied tables
                break;
            case 8:
                System.out.println("How many tables do you want to initialize?");
                int numTables = getInput();
                Boolean res = tableManager.initTables(numTables);

                if (!res) {
                    System.out.println("Do you want to clear Table Database? Y/N");
                    response = getString().toUpperCase();
                    if (response.charAt(0) == 'Y') {
                        System.out.println("Deleting...");
                        tableManager.deleteAllTables();
                        tableManager.initTables(numTables);
                    }
                }
                break;
            default:
                break;
            }
        } while (choice < 9);
    }

    /**
     * Displays the UI menu
     */
    public void displayMenu() {
        System.out.println("\n################# TABLE MENU #################");
        System.out.println("1. Add a new table.");
        System.out.println("2. Remove a table.");
        System.out.println("3. Remove all tables.");
        System.out.println("4. Show table by ID.");
        System.out.println("5. Show all tables.");
        System.out.println("6. Show occupied tables.");
        System.out.println("7. Show unoccupied tables.");
        System.out.println("8. Initialize tables.");
        System.out.println("9. Back.");
    }
}
