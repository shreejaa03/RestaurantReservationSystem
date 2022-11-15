package src.Entity;

import java.io.Serializable;
/**
 * Reperesents the menu items in the restaurant
 * @author Shreejaa Saravanan
 * @version 1.0
 * @since 13-11-2021
 */



public class MenuItem implements Serializable {
	
	/**
	 * The types for menuitem
	 */


	public static String[] types = {"APPETISER", "MAIN COURSE" , "DRINKS", "DESSERT"};
	
	/**
	 * The ID for menuitem
	 */

	int ID;
	
	/**
	 * The name for menuitem
	 */

	String name = "";
	
	/**
	 * The type for menuitem
	 */
	
	public FoodCategory type;
	
	/**
	 * The description for menuitem
	 */

	String description = "";
	
	/**
	 * The price for menuitem
	 */
	
	double price = 0.0;

	// static enum FoodCategory {
	// 	// APPETISER("Appetiser"), MAIN_COURSE("Main_Course"), DRINKS("Drinks"), DESSERT("Dessert");
		

	// 	private String name;

	// 	public String getName() {
	// 		return this.name;
	// 	}

	// 	FoodCategory(String name) {
	// 		this.name = name;
	// 	}
	// }

	// public MenuItem(int ID,String name) {
	// 	this.name = name;
	// 	this.ID = ID;
	// }

	/**
	 * Creates a new MenuItem with the given id, name , price and type
	 * @param ID    This MenuItem's ID
	 * @param name  This MenuItem's name
	 * @param type  This MenuItem's type
	 * @param price This MenuItem's price
	 */
	
	public MenuItem(int ID,String name,FoodCategory type,double price) {
		this.ID = ID;
		this.name = name;
		// if (type.contains("App")) {
		// 	this.type = FoodCategory.APPETISER;
		// } else if (type.contains("Main")) {
		// 	this.type = FoodCategory.MAIN_COURSE;
		// } else if (type.contains("Drink")) {
		// 	this.type = FoodCategory.DRINKS;
		// } else {
		// 	this.type = FoodCategory.DESSERT;
		// }
		this.price = price;
		this.type = type;

	}
	
	/**
	 * Creates a new MenuItem with the given name , description, price and type
	 * @param name        This MenuItem's name
	 * @param type        This MenuItem's type
	 * @param price       This MenuItem's price
	 * @param description This MenuItem's description
	 */


	public MenuItem(String name, String description, String type, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
		if (type.toLowerCase().contains("app")) {
			this.type = FoodCategory.APPETISER;
		} else if (type.toLowerCase().contains("main")) {
			this.type = FoodCategory.MAIN_COURSE;
		} else if (type.toLowerCase().contains("drink")) {
			this.type = FoodCategory.DRINKS;
		} else {
			this.type = FoodCategory.DESSERT;
		}

	}

	/**
	 * Gets the id of this MenuItem 
	 * @return this MenuItem's ID
	 */

	
	public int getID() {
		return this.ID;
	}

	/**
	 * Gets the name of this MenuItem
	 * @return this MenuItem's name
	 */
	
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of this MenuItem
	 * @param name The name to be given for this MenuItem
	 */
	
	public void setName(String name)
    {
      this.name = name;
    }

	/**
	 * Gets the description of this MenuItem
	 * @return this MenuItem's description
	 */

	
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the description of this MenuItem
	 * @param description The description to be given for this MenuItem
	 */

	
	public void setDescription(String description) {
        this.description = description;
    }

	/**
	 * Gets the type of this MenuItem
	 * @return this MenuItem's type
	 */
	
	public FoodCategory getType() {
		return this.type;
	}

	/**
	 * Sets the type of this MenuItem
	 * @param type The type to be given for this MenuItem
	 */
	
	public void setType(String type)
    {
        // if(new String("Appetiser").equals(type))
        // {
        //     this.type = FoodCategory.APPETISER;
        // }
        // if(new String("Main_Course").equals(type))
        // {
        //     this.type = FoodCategory.MAIN_COURSE;
        // }
        // if(new String("Drinks").equals(type))
        // {
        //     this.type = FoodCategory.DRINKS;
        // }
        // if(new String("Dessert").equals(type))
        // {
        //     this.type = FoodCategory.DESSERT;
        // }

		if (type.contains("App")) {
			this.type = FoodCategory.APPETISER;
		} else if (type.contains("Main")) {
			this.type = FoodCategory.MAIN_COURSE;
		} else if (type.contains("Drink")) {
			this.type = FoodCategory.DRINKS;
		} else {
			this.type = FoodCategory.DESSERT;
		}
    }
	
	/**
	 * Gets the price of this MenuItem
	 * @return this MenuItem's price
	 */
	
	public double getPrice(){
		return this.price;
	}

	/**
	 * Sets the price of this MenuItem
	 * @param price The price to be given for this MenuItem
	 */

	public void setPrice(double price)
    {
        this.price = price;
    }

	/**
	 * It prints the name, description, price and type of this MenuItem
	 */
	
	public void print() {
        System.out.println("Name: " + this.getName() );
        System.out.println("\nType: " + this.getType().getName());
        System.out.println("\nDescription: " + this.getDescription());
        System.out.println("\nPrice:" + this.getPrice());
        System.out.println("-----------------------------------------------------------------");
    }

	// public void print1() {
	// 	System.out.println("Name: " + this.getName() + " Type: " + type.getName());
	// 	System.out.println("Description: " + this.getDescription());
	// }

	/**
	 * It prints the id and name of this MenuItem
	 */
	
	public void printsimple() {
		System.out.printf("(%d) %s\n", this.getID() , this.getName());
	}

	/**
	 * This function ensures that there are no duplictae MenuItems being created by the user
	 * @param m The details of the MenuItem
	 * @return the result is true or false
	 */
	
	public boolean compareDuplicate(MenuItem m) {

		if (this.getName().equals(m.getName())) {
			return true;
		}

		return false;
	}

}
