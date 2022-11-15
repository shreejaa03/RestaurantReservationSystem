package src.Entity;

import java.util.ArrayList;

/**
 * This is the Order Manager
 * @author Reeves Chiu
 * @version 1.0
 * @since 13/11/2021
 */

public class OrderItem {

	/**
	 * this are all the attributes needed to make an order item
	 */
    int tempID;
    int pax;
	String name = "";
    FoodCategory type;
	double price;
	private ArrayList <MenuItem> set = new ArrayList<MenuItem>();

	/**
	 * contructor for ala cart order item
	 * @param pax
	 * @param name
	 * @param type
	 * @param price
	 */

    public OrderItem(int pax,String name,FoodCategory type, double price){
        this.pax=pax;
        this.name=name;
        this.price=price;
		this.tempID = 0;
		this.type = type;
    }

	/**
	 * contructor for Promo set order
	 * @param pax
	 * @param name
	 * @param price
	 * @param Set
	 */

	public OrderItem(int pax,String name, double price,ArrayList<MenuItem> Set){
        this.pax=pax;
        this.name=name;
        this.price=price;
		this.tempID = 0;
		this.set = Set;

    }

	
	/** 
	 * @return int
	 */
	public int getPax() {
		return this.pax;
	}
	
	/** 
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/** 
	 * @return FoodCategory
	 */
	public FoodCategory getType() {
		return this.type;
	}
	
	
	/** 
	 * @return double
	 */
	public double getPrice(){
		return this.price;
	}
	
	/** 
	 * @param pax
	 */
	public void setPax(int pax)
	{
		this.pax = pax;
	}
	
	/** 
	 * @param price
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	/** 
	 * @return int
	 */
	public int getTemp() {
		return this.tempID;
	}
	
	
	/** 
	 * @param temp
	 */
	public void setTemp(int temp) {
		this.tempID = temp;
	}
	
	/** 
	 * @return ArrayList<MenuItem>
	 */
	public ArrayList<MenuItem> getSet() {
        return this.set;
    }
    
	/** 
	 * @param set
	 */
	public void setSet(ArrayList<MenuItem> set) {
        this.set = set;
    }
	
}
