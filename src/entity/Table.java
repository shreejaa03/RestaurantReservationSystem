package src.Entity;

/**
 * Stores table information for each instance of table
 * 
 * @author Ivan Pua
 * @version 1.0
 * @since 13/11/2021
 */
public class Table {

    private int id;
    private int seats;
    private Boolean taken;

    /**
     * Constructor for Table
     * @param id Table ID
     * @param seats Number of seats for the table
     */
    public Table(int id, int seats) {
        this.id = id;
        this.seats = seats;
        this.taken = false;
    }

    /**
     * @return Returns the Table ID of the table
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return The number of seats for the table
     */
    public int getSeats() {
        return this.seats;
    }

    /**
     * Sets the TableID for the table
     * @param id The ID of the table
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set mumber of seats for the table
     * @param seats the number of seats for the table
     */
    public void setSeats(int seats) {
        if (seats < 2 || seats > 11) {
            throw new IllegalArgumentException("Number of seats must be minimum 2 and maximum 10");
        } else {
            this.seats = seats;
        }
    }

    /**
     * @return a boolean value.
     * True if table is occupied
     * False if table is unoccupied
     */
    public Boolean isTaken() {
        return taken;
    }

    /**
     * Sets the table occupied status
     */
    public void setTakenStatus() {
        taken = !taken;
    }
}