package src.Entity;

import src.Database.TableDatabase;
/**
 * Stores information for a reservation instance
 * 
 * @author Ivan Pua
 * @version 1.0
 * @since 13/11/2021
 */
public class Reservation {

    private String name;
	private int pax;
	private int contact;
	private Table table;
    private String time;
    private String date;

    /**
     * Constructor for Reservation
     * @param name The name of the customer
     * @param pax The number of pax of customers seating at the table
     * @param contact The contact number of the customer makeing the reservation
     * @param table The reserved table assigned to the customer
     * @param time The time of the reservation 
     */
    public Reservation(String name, int pax, int contact, Table table, String time, String date) {
        this.name = name;
        this.pax = pax;
        this.contact = contact;
        this.table = table;
        this.time = time;
        this.date = date;
    }
    
    /**
     * Sets the name of the customer
     * @param name The name of the customer for this reseravtion
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The name of the customer for this reservation
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the number of customers to be expected
     * @param pax The number of customers to be expected
     */
    public void setPax(int pax) {
        this.pax = pax;
    }

    /**
     * @return The number of pax
     */
    public int getPax() {
        return this.pax;
    }

    /**
     * Sets the cotnact number of the customer
     * @param contact The contact number of the customer
     */
    public void setContact(int contact) {
        this.contact = contact;
    }

    /**
     * @return The contact number of the contact
     */
    public int getContact() {
        return this.contact;
    }

    /**
     * Sets the table to be assigned
     * @param tableID The tableID to be assigned
     */
    public void setTable(int tableId) {
        this.table = TableDatabase.tableList.get(tableId);
    }

    /**
     * @return Returns the table object
     */
    public Table getTable() {
        return this.table;
    }

    /**
     * Sets the time of the reservation
     * @param time 
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return The time of the reservation
     */
    public String getTime() {
        return this.time;
    }

    /**
     * Sets the date of the reservation
     * @param date The date of the reservation
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return The date of the reservation
     */
    public String getDate() {
        return this.date;
    }

}