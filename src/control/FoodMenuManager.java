package src.Control;
import java.util.ArrayList;
import java.util.List;
import src.Entity.MenuItem;
import src.Entity.Promotion;
import src.Database.Database;

/**
 * Reperesents the food menu manager for the food menu
 * @author Shreejaa Saravanan
 * @version 1.0
 * @since 13-11-2021
 */

public class FoodMenuManager{
    
    /**
	 * The list of MenuItems in the food menu
	 */
    public static List<MenuItem> menuItems= Database.menuItemsDB;
    
    /**
	 * The list of Promotional packages in the food menu
	 */
    
    public static ArrayList<Promotion> promoSet= new ArrayList<Promotion>();
    
    /**
	 * Adds MenuItems to the food menu
     * @param name        This MenuItem's name
	 * @param type        This MenuItem's type
	 * @param price       This MenuItem's price
	 * @param description This MenuItem's description
	 */

    public static void addFoodItem(String name, String description, double price, String type) {
        MenuItem newMenu = new MenuItem(name, description, type, price);
        menuItems.add(newMenu);
        System.out.println(" New Food Item Successfully Added!");
        newMenu.print();
    }
    
    /**
	 * Adds food items to the menu
     * @param name        This MenuItem's name
	 * @param type        This MenuItem's type
	 * @param price       This MenuItem's price
	 * @param description This MenuItem's description
     * @return this MenuItem's details
	 */
    
    public static MenuItem addFoodItemPromo(String name, String description, double price, String type) {
        MenuItem newMenu = new MenuItem(name, description, type, price);
        System.out.println("Food Item Successfully Added!");
        newMenu.print();
        return newMenu;
    }

     /**
	 * Deletes MenuItems from the food menu
     * @param name        This MenuItem's name
	 */
    
    
    public static void removeFoodItem(String name) {
        for (MenuItem m : menuItems) {
            if (m.getName().equals(name)) {
                menuItems.remove(m);
                System.out.println(name + " removed successfully");
                return;
            }
        }
        System.out.println(name + " cannot be found!");
    }
    
     /**
	 * Edits details of the MenuItems in the food menu
     * @param name        This MenuItem's name
	 * @param type        This MenuItem's type
	 * @param price       This MenuItem's price
	 * @param description This MenuItem's description
     * @param newName        Updated name to be given to this MenuItem
	 */
    

    public static void editFoodItem(String name, String description, double price, String type,String newName) {
        for (MenuItem m : menuItems) {
            if (m.getName().equals(name)) {
                if (price != -1)
                    m.setPrice(price);

                if (!name.equals(""))
                    m.setName(newName);
                if (!description.equals(""))
                    m.setDescription(description);
                if (!type.equals(""))
                    m.setType(type);
                System.out.println("Food Item information updated successfully");
                m.print();
                return;
            }
            
        }
        System.out.println(name + " cannot be found");

    }
    
    /**
	 * Adds Promotions to the Food menu
     * @param name        This Promotion's name
	 * @param set        This Promotion's set
	 * @param price       This Promotion's price
	 * @param description This Promotion's description
	 */
    

    public static void addPromotion(String name, double price, ArrayList<MenuItem> set, String description) {
        Promotion newPromo = new Promotion(name, price, set, description);
        promoSet.add(newPromo);
        System.out.println(" New Promotional Package Successfully Added!");
        newPromo.print();
    }
    
    /**
	 * Deletes Promotions from the Food menu
     * @param name        This Promotion's name
	 */

    public static void removePromotion(String name) {
        for (Promotion p : promoSet) {
            if (p.getName().equals(name)) {
                promoSet.remove(p);
                System.out.println(name + " removed successfully");
                return;
            }
        }
        System.out.println(name + " cannot be found!");
    }
    
    
    /**
	 * Edits Promotions in the Food menu
     * @param name        This Promotion's name
	 * @param set        This Promotion's set
	 * @param price       This Promotion's price
	 * @param description This Promotion's description
     * @param updName        Updated name for the Promotion
	 */

    public static void editPromotion(String name, double price, ArrayList<MenuItem> set, String description, String updName) {
        for (Promotion p : promoSet) {
            if (p.getName().equals(name)) {

                if (price != -1)
                    p.setPrice(price);

                if (!name.equals(""))
                    p.setName(updName);
                if (!description.equals(""))
                    p.setDescription(description);
                p.setSet(set);
                System.out.println("Promotional package information updated successfully!");
                p.print();
                return;
            }
            
        }
        System.out.println(name + " cannot be found!");
    }

}
