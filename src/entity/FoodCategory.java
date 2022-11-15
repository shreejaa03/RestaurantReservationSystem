package src.Entity;

/**
 * Reperesents the foodcategory types in the restaurant
 * 
 * @author Shreejaa Saravanan
 * @version 1.0
 * @since 13-11-2021
 */

public enum FoodCategory {
    
    /**
    *The types of MenuItem
    */
    
    APPETISER("Appetiser"), MAIN_COURSE("Main Course"), DRINKS("Drinks"), DESSERT("Dessert");
    
     /**
    *The name of the type of MenuItem
    */
    
    private String name;

    /**
	 * Gets the name of the type of MenuItem
	 * @return this name of the type of MenuItem
	 */
    
    public String getName() {
        return this.name;
    }
    
    /**
    * Sets the name of this Foodcategory
    * @param name Sets this name to the FoodCategory
    */

    FoodCategory(String name) {
        this.name = name;
    }
}

// public enum FoodCategory1 {
//     APPETISER, MAIN_COURSE, DRINKS, DESSERT;

// }
