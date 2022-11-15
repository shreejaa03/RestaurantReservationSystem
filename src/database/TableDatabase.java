package src.Database;

import java.util.HashMap;
import src.Entity.Table;

/**
 * Stores table information in a HashMap
 * 
 * @author Ivan PUa
 * @version 1.0
 * @since 10/11/2021
 */
public class TableDatabase {
    public static HashMap<Integer, Table> tableList;

    /**
     * Constructor to create TableDatabase
     */
    public TableDatabase() { 
        tableList = new HashMap<Integer, Table>(); // Map unique table number to Table object
    }
 }


