package src.Entity;

import java.util.ArrayList;
import java.util.List;
import src.Entity.Restaurant;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * This is the Order Manager
 * @author Reeves Chiu
 * @version 1.0
 * @since 13/11/2021
 */

public class Order {


    /**
     * this are all the attributes needed to make an order
     */
	private int orderID;
	private int tableID;
	private int staffID;
    private String staffName;
	public List<OrderItem> itemList;


    /**
     * contructor single order
     * @param orderID
     * @param tableID
     * @param staffID
     * @param staffName
     */
    public Order(int orderID, int tableID, int staffID, String staffName){
        this.orderID = orderID;
        this.tableID = tableID;
        this.staffID = staffID;
        this.staffName = staffName;
        this.itemList = new ArrayList<OrderItem>();

    }

	
    /** 
     * @return int
     */
    public int getOrderID() {
		return this.orderID;
	}

	
    /** 
     * @return int
     */
    public int getStaffID() {
		return this.staffID;
	}
    
    /** 
     * @return String
     */
    public String getStaffName() {
		return this.staffName;
	}
	
    /** 
     * @return int
     */
    public int getTableID() {
		return this.tableID;
	}

    
    /** 
     * @param tableID
     */
    public void setTableID(int tableID) {
		this.tableID = tableID;
	}

    
    /** 
     * @return int
     */
    public int getitems() {
		return this.tableID;
	}

    
    /** 
     * add item in menu item into orders itemlist
     * @param pax
     * @param name
     * @param type
     * @param price
     */
    public void additems(int pax,String name,FoodCategory type, double price) {
        for (OrderItem i : itemList){
            if(i.getName() == name){
                i.pax += pax;
                return;
            }
        }
        
        OrderItem item = new OrderItem(pax, name, type, price);
        itemList.add(item);
	}

    
    /** 
     * 
     * add promo item in menu item into orders itemlist
     * @param pax
     * @param name
     * @param price
     * @param set
     */
    public void additemspromo(int pax,String name, double price , ArrayList<MenuItem> set ) {
        for (OrderItem i : itemList){
            if(i.getName() == name){
                i.pax += pax;
                return;
            }
        }
        
        OrderItem item = new OrderItem(pax, name, price, set);
        itemList.add(item);
	}

    
    /** 
     * Delete single item from the order itemlist
     * @param choice
     */
    public void deleteitems(int choice) {
        itemList.remove(choice-1);
	}

    /**
     * print of order ID , Staff and table number
     */
    public void print() {
		System.out.printf("Order ID: %d, Service Staff: %s, Table Number: %d\n", this.getOrderID(),this.getStaffName(),this.getTableID());

	}

    /**
     * print of order ID , Staff and table number & itemlist in the order
     */
    public void printItems() {
		// System.out.println("OrderID: " + this.getOrderID());
		// System.out.println("Service Staff: " + this.getStaffID());
		// System.out.println("Table Number: " + this.getTableID());
        
        int counter = 1;

        System.out.printf("Order ID: %d, Service Staff: %s, Table Number: %d\n", this.getOrderID(),this.getStaffName(),this.getTableID());
        System.out.println("          Pax    Dish Name                                   Price");
        System.out.printf("-------------------------------------------------------------------\n");
        for(OrderItem o : itemList){
            o.setTemp(counter);
            System.out.printf(" (%-2d)     %-4d   %-35s         $%.2f\n",o.getTemp(), o.getPax(),o.getName(),(o.getPax()*o.getPrice()));
            counter++;
        }

	}

    /**
     * print itemlist in the order
     */
    public void printAll() {
        System.out.println(" Pax    Dish Name                                   Price");
        System.out.printf("-------------------------------------------------------------\n");
        for(OrderItem o : itemList){
            System.out.printf(" %-4d   %-35s         $%.2f\n", o.getPax(),o.getName(),(o.getPax()*o.getPrice()));
        }

	}


    
    /** 
     * After payment is made the bill will be printed so display what the customer ordered
     * @param orderID
     * @param staffID
     * @param tableID
     * @param member
     * @param staffName
     * @param discount
     */
    public void printBill(int orderID, int staffID, int tableID, Boolean member , String staffName, float discount) {

        double total = 0;
        double temp;
        String str = "%";
        // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();

        //HEADER
        System.out.printf("----------------------------------------------------------------------------------------------------------------\n\n");
        System.out.printf("                                           %s\n", Restaurant.getName());
        System.out.printf("                                           %s\n", "10 Ang Mo Kio Street 12, Singapore 567740");
        System.out.printf("                                           %s%d\n", "TEL: " , 98765432);
        System.out.printf("                                           %s%d\n\n", "Check #: ", orderID );
        System.out.printf("     Server : %-15s                                                                    Date: ", staffName);
        System.out.println(formatter1.format(date));
        System.out.printf("     Table #: %-15d                                                                    Time: ", tableID);
        System.out.println(formatter2.format(date));
        // System.out.printf("                                                Client: %d\n", 6);
        System.out.printf("----------------------------------------------------------------------------------------------------------------\n\n");

        //BODY
        //System.out.printf("Order ID: %d, Staff ID: %d, Table Number: %d\n", this.getOrderID(),this.getStaffID(),this.getTableID());
        //System.out.println("Pax--Dish Name----------------------------------Price");
        for(OrderItem o : itemList){
            total = total + o.getPax()*o.getPrice();
            System.out.printf("     %-2d      %-35s                                                           $%.2f\n", o.getPax(),o.getName(),(o.getPax()*o.getPrice()));
        }
        System.out.printf("----------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("                                                                                                SUB-TOTAL: $%.2f  \n", total);
        System.out.printf("                                                                                       Tax(GST + Service): $%.2f  \n", total*0.17);
        if(!member){
            System.out.printf("----------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("                                                                                                    TOTAL: $%.2f  \n", total*1.17);
        }
        else{
            temp = (total*1.17)*discount;
            System.out.printf("                                                                                           Discount (%d%s): $%.2f  \n",(int)(discount*100) ,str,temp);
            System.out.printf("----------------------------------------------------------------------------------------------------------------\n");
            temp = (total*1.17)*(1-discount);
            System.out.printf("                                                                                                    TOTAL: $%.2f  \n", temp);
        }
        System.out.printf("================================================================================================================\n\n");

        //FOOTER
        System.out.printf("****************************************************************************************************************\n");
        System.out.printf("                                           THANKS FOR DINNING WITH US ! \n");
        System.out.printf("****************************************************************************************************************\n");



	}
    

}