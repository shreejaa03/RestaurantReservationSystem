package src.Control;

import java.util.ArrayList;
import java.util.List;
import src.Database.OrderDatabase;
import src.Database.Database;
import src.Database.TableDatabase;
import src.Entity.Table;
import src.Entity.Order;
import src.Entity.MenuItem;
import src.Entity.FoodCategory;
import src.Entity.Promotion;

import java.util.Scanner;


/**
 * This is the Order Manager
 * @author Reeves Chiu
 * @version 1.0
 * @since 13/11/2021
 */

public class OrderManager {

    /**
     * initialize an array from DB 
     * initialize an array to store orders
     */
    public static List<Order> Orders = OrderDatabase.OrderDB;
    public static List<MenuItem> menuItems = Database.menuItemsDB;
    public static List<MenuItem> itemList = new ArrayList<MenuItem>();
    public static ArrayList<Promotion> promoList= new ArrayList<Promotion>();
    private static int orderID = 1;
    Scanner sc = new Scanner(System.in);
	// public void run() {

	// }

    /**
     * This is the display menu so that the staff can navigate to what they need.
     */

	public void displayMenu() {
        System.out.println("################# FOOD MENU #################");
        System.out.println("1. Appetiser.");
        System.out.println("2. Main Course.");
        System.out.println("3. Drinks.");
        System.out.println("4. Dessert.");
        System.out.println("5. Promotional Set.");
        System.out.println("6. Back.");
	}

    
    /** 
     * 
     * This is the display menu so that the staff can navigate to what they need.
     *
     * @param choice
     */
    public void displaysubMenu(int choice) {
        int counter = 1;
        if (choice == 1){
                System.out.println("################# Appetiser MENU #################");
                for (MenuItem m : menuItems) {
                    if(m.getType().equals(FoodCategory.APPETISER)){
                        MenuItem item = new MenuItem(counter, m.getName(),m.getType(),m.getPrice());
                        itemList.add(item);
                        counter++;
                    }
                }
                for (MenuItem n : itemList) {
                    n.printsimple();
                }
                System.out.println("\nEnter \"#\" to go back.");
            return;
        }
        if (choice == 2){
                System.out.println("################# Main Course MENU #################");
                for (MenuItem m : menuItems) {
                    if(m.getType().equals(FoodCategory.MAIN_COURSE) ){
                        MenuItem item = new MenuItem(counter, m.getName(),m.getType(),m.getPrice());                        
                        itemList.add(item);
                        counter++;
                    }
                }
                for (MenuItem n : itemList) {
                    n.printsimple();
                }
                System.out.println("\nEnter \"#\" to go back.");
            return;
        }
        if (choice == 3){
                System.out.println("################# Drinks MENU #################");
                for (MenuItem m : menuItems) {
                    if(m.getType().equals(FoodCategory.DRINKS)){
                        MenuItem item = new MenuItem(counter, m.getName(),m.getType(),m.getPrice());
                        itemList.add(item);
                        counter++;
                    }
                }
                for (MenuItem n : itemList) {
                    n.printsimple();
                }
                System.out.println("\nEnter \"#\" to go back.");
            return;
        }
        if (choice == 4){
                System.out.println("################# Dessert MENU #################");
                for (MenuItem m : menuItems) {
                    if(m.getType() == FoodCategory.DESSERT ){
                        MenuItem item = new MenuItem(counter, m.getName(),m.getType(),m.getPrice());
                        itemList.add(item);
                        counter++;
                    }
                }
                for (MenuItem n : itemList) {
                    n.printsimple();
                }
                System.out.println("\nEnter \"#\" to go back.");
            return;
        }
        if (choice == 5){
            System.out.println("################# Promotional MENU #################");
            for (Promotion m : FoodMenuManager.promoSet) {
                    Promotion item = new Promotion(counter, m.getName(),m.getPrice(),m.getSet());
                    promoList.add(item);
                    counter++;
            }
            for (Promotion n : promoList) {
                n.printsimple();
            }
            System.out.println("\nEnter \"#\" to go back.");
        return;
    }

	}

	
    /** 
     * Create a new order and set table as taken & will be stored in Orders 
     * @param staffID
     * @param tableNo
     * @param staffName
     */
    public void createOrder(int staffID , int tableNo, String staffName) {

        Table table = TableDatabase.tableList.get(tableNo);

            table.setTakenStatus();
            Order order = new Order(orderID, tableNo, staffID, staffName);
            orderID ++;
            Orders.add(order);
    
            System.out.println("Order Successfully Created");
            order.print(); 

	}

    
    /** 
     * to get an existing order from Orders
     * @param orderID
     */
    public void getOrder(int orderID) {
        System.out.println("============================ ORDER ====================================");
        for(Order o : Orders){
            if (o.getOrderID() == orderID) {
                // System.out.printf("Order ID: %d, Staff ID: %d, Table Num: %d\n", o.getOrderID(),o.getStaffID(),o.getTableID());
                o.printAll();
                return;
            }
            
        }
        System.out.println("ERROR Order ID " + orderID + ": Cant be found!");
	}

	
    /** 
     * to add items to order
     * @param orderID
     */
    public void addOrder(int orderID) {

        for (Order o : Orders) {
			if (o.getOrderID() == orderID) {
                int choice = -1;
                
        
                do {
                    this.displayMenu();
                    choice = sc.nextInt();
        
                    switch (choice) {
                        case 1:
                            displaysubMenu(1);
                            additems(orderID);
                            itemList.clear();
                            break;
                        case 2:
                            displaysubMenu(2);
                            additems(orderID);
                            itemList.clear();
                            break;
                        case 3:
                            displaysubMenu(3);
                            additems(orderID);
                            itemList.clear();
                            break;
                        case 4:
                            displaysubMenu(4);
                            additems(orderID);
                            itemList.clear();
                            break;
                        case 5:
                            displaysubMenu(5);
                            additemspromo(orderID);
                            itemList.clear();
                            break;
                        default:
                            break;
                        }
                } while (choice < 6);
                return;
			}
		}
		System.out.println("ERROR Order ID " + orderID + ": Cant be found!");

	}

    
    /** 
     * delete order in Orders
     * @param orderID
     */
    public void deleteOrder(int orderID) {
        for (Order o : Orders) {
			if (o.getOrderID() == orderID) {
                Table table = TableDatabase.tableList.get(o.getTableID());
                if (table.isTaken() == false ){
                    System.out.println("ERROR !!!!");
                }
                else{
                    table.setTakenStatus();
                }
				Orders.remove(o);
				System.out.println("Order " + orderID + " is removed");
				return;
			}
		}
		System.out.println("ERROR Order ID " + orderID + ": Cant be found!");
	}

    public void getAllOrders(){
        System.out.println("============================ All Orders ====================================");
        for(Order o : Orders){
            o.print();
        }
    }

    
    /** 
     * Add menu items in order base on order ID
     * @param orderID
     */
    public void additems(int orderID){
        String input, input1;
        // double price = 12.50;


        System.out.println("Enter the item number: ");
        input = sc.next();
        if (input.equals("#")){
            return;
        }
        else if(Integer.parseInt(input) > itemList.size() || Integer.parseInt(input) < 1){
            System.out.println("Kindly input items within the range");
            return;
        }
        System.out.println("\nEnter how many servings (max=10): ");
        input1 = sc.next();
        if (input1.equals("#")){
            return;
        }
        else if(Integer.parseInt(input1) > 10 || Integer.parseInt(input1) < 1){
            System.out.println("Kindly input items within the range");
            return;
        }

        for (Order o : Orders) {
			if (o.getOrderID() == orderID) {
                for (MenuItem n : itemList) {
                    if(n.getID() == Integer.parseInt(input)){
                        // o.additems(Integer.parseInt(input1), n.getName(), n.getType(), n.getPrice());

                        o.additems(Integer.parseInt(input1), n.getName(), n.getType(), n.getPrice());
                    }
                }
                
			}
		}
    }

    
    /** 
     * Add menu items in order base on order ID
     * @param orderID
     */
    public void additemspromo(int orderID){
        String input, input1;

        System.out.println("Enter the item number: ");
        input = sc.next();
        if (input.equals("#")){
            return;
        }
        else if(Integer.parseInt(input) > promoList.size() || Integer.parseInt(input) < 1){
            System.out.println("Kindly input items within the range");
            return;
        }
        System.out.println("\nEnter how many servings (max=10): ");
        input1 = sc.next();
        if (input1.equals("#")){
            return;
        }
        else if(Integer.parseInt(input1) > 10 || Integer.parseInt(input1) < 1){
            System.out.println("Kindly input items within the range");
            return;
        }

        for (Order o : Orders) {
			if (o.getOrderID() == orderID) {
                for (Promotion n : promoList) {
                    if(n.getID() == Integer.parseInt(input)){
                        // o.additems(Integer.parseInt(input1), n.getName(), n.getType(), n.getPrice());
                        o.additemspromo(Integer.parseInt(input1), n.getName(),n.getPrice(),n.getSet());
                    }
                }
                
			}
		}
    }
    
    /** 
     * Delete selected items in specific order
     * @param orderID
     */
    public void deleteItem(int orderID){
        System.out.println("============================ DELETE ITEMS ====================================");
        for(Order o : Orders){
            if (o.getOrderID() == orderID) {
                int choice;

                System.out.printf("Order ID: %d, Service Staff: %s, Table Num: %d\n", o.getOrderID(),o.getStaffID(),o.getTableID());
                o.printItems();

                do{
                    System.out.println("Enter the item number to remove: ");
                    choice = sc.nextInt();

                    if(choice > o.itemList.size() || choice < 1){
                        System.out.println("Kindly input items within the range");
                        continue;
                    }

                }while(choice > o.itemList.size() || choice < 1);

                o.deleteitems(choice);
                System.out.println("Item successfully removed.");
                return;
            }
            
        }
        System.out.println("ERROR Order ID " + orderID + ": Cant be found!");

    }

    
}