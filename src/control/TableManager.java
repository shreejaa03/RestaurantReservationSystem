package src.Control;

import src.Database.TableDatabase;
import src.Entity.Table;

/**
 * Control class for managing the interactions for TableUI
 * 
 * @author Ivan Pua
 * @version 1.0
 * @since 13/11/2021
 */
public class TableManager {

    /**
     * Constructor of tableManager
     * Instantiates a new TableDatabase
     * and initialises it with 10 tables
     */
    public TableManager() {
        new TableDatabase();
        this.initTables(5);
    }

    /**
     * Adds a single table to the database
     * @param tableID the ID of the table
     * @param seats the number of seats allocated to the table
     * <p>Seats must be an EVEN number between 2 and 10</p>
     * @exception IllegalArgumentException occurs when number of seats is not even and not within allowed range
     */
    public void addTable(int tableID, int seats) {
        if (seats < 2 || seats > 10 || seats % 2 != 0) {
            throw new IllegalArgumentException("Number of seats must be an even number. Minimum 2 and maximum 10");
        }

        if (TableDatabase.tableList != null) {
            if (TableDatabase.tableList.containsKey(tableID)) {
                System.out.println("Table with " + tableID + " already exists");
                return;
            }
        }
        
        Table newTable = new Table(tableID, seats);
        TableDatabase.tableList.put(tableID, newTable);
        System.out.println("Table " + tableID + " successfully added");
        
    }

    /**
     * Removes a table by tableID
     * @param tableID The ID of the table
     */
    public void removeTable(int tableID) {
        Table t = TableDatabase.tableList.remove(tableID);
        if (t == null)
            System.out.println("Table does not exist.");
        else
            System.out.println("Table successfully removed.");
    }

    /**
     * Deletes entire record of tables
     */
    public void deleteAllTables() {
        TableDatabase.tableList.clear();
        System.out.println("Tables deleted.");
    }

    /**
     * Displays table information by tableID
     * @param tableID The ID of the table
     */
    public void showTables(int tableID) {
        Table table = TableDatabase.tableList.get(tableID);
        System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Taken: " + table.isTaken() + ".");
    }

    /**
     * Displays table information for all table records
     */
    public void showTables() {
        for (Table table : TableDatabase.tableList.values()) {
            System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Taken: " + table.isTaken() + ".");
        }
    }

    /**
     * Displays table information for tables that are occupied/unoccupied.
     * @param showTaken If true, displays table information for occupied tables. Else, displays table information for unoccupied tables.
     */
    public void showTables(Boolean showTaken) {

        for (Table table : TableDatabase.tableList.values()) {
            if (showTaken) {
                if (table.isTaken())
                    System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Taken: " + table.isTaken() + ".");
            } else {
                if (!table.isTaken())
                    System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Taken: " + table.isTaken() + ".");
            }
            
        }
    }

    /**
     * @return Returns the number of tables in the database
     */
    public int getNumTables() {
        return TableDatabase.tableList.size();
    }

    /**
     * Initialises the tables into the database
     * Seats will be allocated randomly based on the seat constraints
     * @numTables The number of tables the user wants to initialize
     */
    public Boolean initTables(int numTables) {
        if (TableDatabase.tableList.isEmpty()) { 
            for (int i = 0; i < numTables; i++) {
                int num = -1;
                do {
                    num = (int)(Math.random() * 9) + 2;
                } while (num % 2 != 0);

                this.addTable(i+1, num);
            }
        } else {
            System.out.println("Tables already initialized.");
            System.out.println("Table Database must be cleared before re-initializing.");
            return false;
        }
        return true;
    }
}
