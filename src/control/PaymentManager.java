package src.Control;

import java.util.*;

import src.Database.OrderDatabase;
import src.Database.TableDatabase;
import src.Database.Database;
import src.Entity.Table;
import src.Entity.Person;
import src.Entity.Customer;
import src.Entity.Order;
import src.Entity.OrderItem;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is the Order Manager
 * @author Reeves Chiu
 * @version 1.0
 * @since 13/11/2021
 */

public class PaymentManager {

    public static List<Order> Orders = OrderDatabase.OrderDB;

    /**
     * Gets the invoice of an order
     * 
     * @param orderID The order ID to be printed.
     */
    public void getInovice(int orderID) {
        System.out.println("============================ INVOICE ====================================");
        for (Order o : Orders) {
            if (o.getOrderID() == orderID) {
                o.printAll();
                return;
            }

        }
        System.out.println("ERROR Order ID " + orderID + ": Cant be found!");
    }

    /**
     * Gets the recipt for an order
     * 
     * @param orderID  The ID of an order
     * @param member   Member flag
     * @param discount Discount allowed (if applicable)
     */
    public void getReceipt(int orderID, boolean member, Float discount) {
        // System.out.println("============================ Receipt
        // ====================================");
        for (Order o : Orders) {
            if (o.getOrderID() == orderID) {
                o.printBill(o.getOrderID(), o.getStaffID(), o.getTableID(), member, o.getStaffName(), discount);
                return;
            }

        }
        System.out.println("ERROR Order ID " + orderID + ": Cant be found!");
    }

    /**
     * Checkout an order
     * 
     * @param orderID The order ID of the order to be checkout.
     */
    public void checkout(int orderID) {
        for (Order o : Orders) {
            if (o.getOrderID() == orderID) {
                Table table = TableDatabase.tableList.get(o.getTableID());
                table.setTakenStatus();
                Orders.remove(o);
                return;
            }
        }

    }

    /**
     * Shows all orders
     */
    public void getAllOrders() {
        System.out.println("============================ All Orders ====================================");
        for (Order o : Orders) {
            System.out.printf("Order ID: %d, Staff ID: %d, Table Num: %d\n", o.getOrderID(), o.getStaffID(),
                    o.getTableID());
        }
    }

    /**
     * Saves the orders back into the CSV file
     * 
     * @param orderID The orderID of the order.
     */
    public void storeOrders(int orderID) {

        SimpleDateFormat formatter1 = new SimpleDateFormat("dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("MM");
        Date date = new Date();
        for (Order o : Orders) {
            for (OrderItem oi : o.itemList) {
                Database.updateRevenue("src/Database/csv/Orders.csv", orderID, oi.getName(), oi.getPrice(), oi.getPax(),
                        Integer.parseInt(formatter1.format(date)), Integer.parseInt(formatter2.format(date)));
            }
        }

    }

    /**
     * Get the discount information for a member.
     * 
     * @param contact The contact number of the customer.
     * @return float The discount allowed
     */
    public float getDiscount(int contact) {
        float dis = 0.0f;

        for (Person c : CustomerManager.customers) {
            if (((Customer) c).getContact() == contact) {
                // System.out.println(((Customer)c).getMembership().getType());
                // System.out.println(((Customer)c).getMembership().getDiscountPercent());
                dis = ((Customer) c).getMembership().getDiscountPercent();
                return dis;
            }
        }
        return dis;
    }

}