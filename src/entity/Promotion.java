package src.Entity;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Reperesents the promotional packages in the restaurant
 * @author Shreejaa Saravanan
 * @version 1.0
 * @since 13-11-2021
 */

public class Promotion implements Serializable {
	/**
	 * The name for Promotion
	 */

    private String name;
	/**
	 * The description for Promotion
	 */

    private String description;
	/**
	 * The price for Promotion
	 */
    private double price;
	/**
	 * The ID for Promotion
	 */
    private int ID;
	/**
	 * The list of food items for Promotion
	 */
	
    private ArrayList <MenuItem> set = new ArrayList<MenuItem>();
	
	/**
	 * Creates a new Promotion with the given name , price, description and set
	 * @param Name  This MenuItem's name
	 * @param Price This MenuItem's price
	 * @param Description  This MenuItem's description
	 * @param Set This MenuItem's set of MenuItems
	 */

    public Promotion(String Name, double Price, ArrayList<MenuItem> Set, String Description) {
        this.name = Name;
        this.description = Description;
        this.price = Price;
        this.set = Set;
    }
	
	/**
	 * Creates a new Promotion with the given name , price, id and set
	 * @param ID  This MenuItem's id
	 * @param Price This MenuItem's price
	 * @param Name  This MenuItem's name
	 * @param Set This MenuItem's set of MenuItems
	 */
	
    public Promotion(int ID,String Name, double Price, ArrayList<MenuItem> Set) {
        this.ID = ID;
        this.name = Name;
        this.price = Price;
        this.set = Set;
    }
	
	/**
	 * Gets the id of this Promotion
	 * @return this Promotion's ID
	 */
	
    public int getID()
    {
        return this.ID;
    }

	/**
	 * Gets the name of this Promotion
	 * @return this Promotion's name
	 */
	
    public String getName()
    {
        return this.name;
    }
	
	/**
	 * Sets the name of this Promotion
	 * @param name The name to be given for this Promotion
	 */
	
    public void setName(String name)
    {
        this.name = name;
    }
	/**
	 * Gets the description of this Promotion
	 * @return this Promotion's description
	 */
	
    public String getDescription()
    {
        return this.description;
    }
	
	/**
	 * Sets the description of this Promotion
	 * @param description The description to be given for this Promotion
	 */
	
    public void setDescription(String description) {
        this.description = description;
    }
	
	/**
	 * Gets the price of this Promotion
	 * @return this Promotion's price
	 */
	
    public double getPrice()
    {
        return  this.price;
    }
	
	/**
	 * Sets the price of this Promotion
	 * @param price The price to be given for this Promotion
	 */
	
    public void setPrice(double price)
    {
        this.price = price;
    }
	/**
	 * Gets the set of this Promotion
	 * @return this Promotion's set of MenuItems
	 */
	
    public ArrayList<MenuItem> getSet() {
        return this.set;
    }
	/**
	 * Sets the set of this Promotion
	 * @param set The set of MenuItems to be given for Promotion
	 */
	
    public void setSet(ArrayList<MenuItem> set) {
        this.set = set;
    }
	
	/**
	 * It prints the name, description, price and set of this Promotion
	 */
		
    public void print(){
        System.out.println("Name: " + this.getName());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Price:" + this.getPrice());
        System.out.println("Set:");
        for(MenuItem m: set)
        {
            System.out.println("Name: " + m.getName());
            System.out.println(" Type: " + m.getType());
            System.out.println("Description: " + m.getDescription());
            System.out.println("Price:" + m.getPrice());
            System.out.println("-----------------------------------------------------------------");}
        }

	/**
	 * It prints the id and name of this Promotion
	 */
	
	public void printsimple() {
		System.out.printf("(%d) %s\n", this.getID() , this.getName());
	}
    }

