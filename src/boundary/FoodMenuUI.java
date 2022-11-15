package src.Boundary;

import java.util.ArrayList;
import src.Control.FoodMenuManager;
import src.Entity.MenuItem;
import src.Entity.Promotion;

/**
 * Represents the food menu manager
 * @author Shreejaa Saravanan
 * @version 1.0
 * @since 13-11-2021
 */

public class FoodMenuUI extends UI {
	
	/**
	* This function enables the user to add,delete and edit MenuItems in the food menu 
	* This function enables the user to add,delete and edit Promotions in the food menu
	* This function displays the updated food menu
	*/
    
    public void run() {

        int choice,c;
        String n,d,t,n1,d1,t1,n2;
        double p,p1;

        do {
            System.out.println("-----------------------------------FOOD MENU MANAGER-------------------------------");
            System.out.println("(1). Add a food item to the menu");
            System.out.println("(2). Delete a food item from the menu");
            System.out.println("(3). Update a food item in the menu");
            System.out.println("(4). Add a promotional package to the menu");
            System.out.println("(5). Delete a promotional package from the menu");
            System.out.println("(6). Update a promotional package in the menu");
            System.out.println("(7). Display the menu");
            System.out.println("(8). Exit");
            System.out.println("Enter your choice:");
            choice = getInput();
            System.out.println("");
            switch (choice) {
                case 1 :
                    System.out.println(" Please enter the name:");
                    n = getInputString();
                    System.out.println(" Please enter the description:");
                    d = getString();
                    System.out.print(" Please enter the price:");
                    p = getDouble();
                    System.out.println(" Please enter the type:");
                    t = getInputString(MenuItem.types);
                    FoodMenuManager.addFoodItem(n, d, p, t);
                    break;
                case 2 :
                    System.out.println(" Please enter the name of the food item to be removed:");
                    n = getInputString();
                    FoodMenuManager.removeFoodItem(n);
                    break;
                case 3 :
                    System.out.println(" Please enter the name of the food item to be updated:");
                   
                    n = getInputString();
                    System.out.println(" Please enter the new name:");
                    n2 = getInputString();
                    System.out.println(" Please enter the new description:");
                    d = getString();
                    System.out.println(" Please enter the new price:");
                    p = getDouble();
                    System.out.println(" Please enter the new type:");
                    t = getInputString(MenuItem.types);
                    FoodMenuManager.editFoodItem(n, d, p, t,n2);
                    break;
                case 4 :
                    System.out.println(" Please enter the name:");
                    n = getString();
                    System.out.println(" Please enter the description:");
                    d = getString();
                    System.out.print(" Please enter the price:");
                    p = getDouble();
                    System.out.println(" Please enter the no.of.items in the promotion:");
                    c = getInput();
                    ArrayList<MenuItem> pMenu = new ArrayList<MenuItem>();
                    for (int i = 0; i < c; i++) {
                        System.out.println("Please enter the name:");
                        n1 = getInputString();
                        System.out.println("Please enter the description:");
                        d1 = getString();
                        System.out.println("Please enter the price:");
                        p1 = getDouble();
                        System.out.println("Please enter the type:");
                        t1 = getInputString(MenuItem.types);

                        pMenu.add(FoodMenuManager.addFoodItemPromo(n1, d1, p1, t1)); 

                    }
                    FoodMenuManager.addPromotion(n, p, pMenu, d);
                    break;
                case 5 :
                    System.out.print(" Please enter the name:");
                    n = getString();
                    FoodMenuManager.removePromotion(n);
                    break;
                case 6 :
                    System.out.println(" Please enter the name of the promotional package to be updated:");
                    n = getString();
                    System.out.println(" Please enter the new name:");
                    n2 = getString();
                    System.out.println(" Please enter the new description:");
                    d = getString();
                    System.out.println(" Please enter the new price:");
                    p = getDouble();
                    System.out.println(" Please enter the new no.of food items:");
                    c = getInput();
                    ArrayList<MenuItem> pMenu1 = new ArrayList<MenuItem>();
                    for (int i = 0; i < c; i++) {
                        System.out.println(" Please enter the name:");
                        n1 = getInputString();
                        System.out.println(" Please enter the description:");
                        d1 = getString();
                        System.out.println(" Please enter the price:");
                        p1 = getDouble();
                        System.out.println(" Please enter the type:");
                        t1 = getInputString(MenuItem.types);
                        pMenu1.add(FoodMenuManager.addFoodItemPromo(n1, d1, p1, t1));
                    }
                    FoodMenuManager.editPromotion(n, p, pMenu1, d,n2);
                    break;
                case 7 :
                    System.out.println("-----------------------------FOOD MENU----------------------------------------------------------");
                    System.out.println("--------------------------------------- ALA CARTE-----------------------------------------------");
                    for(MenuItem m:FoodMenuManager.menuItems)
                    { System.out.println("Name: " + m.getName() );
                    System.out.println(" Type: " + m.getType());
                    System.out.println("Description: " + m.getDescription());
                    System.out.println("Price:" + m.getPrice());
                    System.out.println("----------------------------------------------------------------------------------------------------");}
                    System.out.println("-------------------------------------PROMOTIONAL PACKAGES-------------------------------------------");
                    for(Promotion i:FoodMenuManager.promoSet)
                    {
                        System.out.println("Name: " + i.getName() );
                        System.out.println("Description: " + i.getDescription());
                        System.out.println("Price:" + i.getPrice());
                        System.out.println("Set: ");
                        int j=1;
                        for(MenuItem m: i.getSet())

                        {
                            System.out.println(j++);

                            System.out.print(" Name: " + m.getName() );
                            System.out.print(" Type: " + m.getType());
                            System.out.print(" Description: " + m.getDescription());
                            System.out.print(" Price:" + m.getPrice());

                            System.out.println("   ");
                        }
                         System.out.println("*******************************************************************************");

                    }
                    break;
                case 8 :
                    return;
            }

        } while (choice != 8);
    }

	/**
	* Prints the menu manager options that are available
	*/
	
    public void displayMenu() {
        System.out.println("\n################# MENU MANAGER #################");
        System.out.println("1. Add Food Item.");
        System.out.println("2. Remove Food Item.");
        System.out.println("3. Edit Food Item.");
        System.out.println("4. Add Promotion.");
        System.out.println("5. Remove Promotion.");
        System.out.println("6. Edit Promotion.");
		System.out.println("7. Back.");
    }
}
