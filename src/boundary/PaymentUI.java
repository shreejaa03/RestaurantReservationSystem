package src.Boundary;

import src.Control.PaymentManager;
import src.Control.OrderManager;
import src.Entity.Order;

/**
 * This is the Payment UI
 * @author Reeves Chiu
 * @version 1.0
 * @since 13/11/2021
 */



public class PaymentUI extends UI {

    /**
     * This is the checker and redirect to perform different functions
     */
    public void run() {
        int choice = -1;
        int orderID = 0;
        Boolean mem = false;

        do {
            this.displayMenu();
            choice = getInput();
            PaymentManager paymentmgt = new PaymentManager();

            switch (choice) {
            case 1:
                String temp;
                float discount = 0.0f;
                boolean check = true;
                do{
                    paymentmgt.getAllOrders();
                    System.out.println("Enter Order ID: ");
                    temp = getString();

                    if(temp.equals("#")){
                        break;
                    }
                    
                    orderID = Integer.parseInt(temp);

                    for(Order o : OrderManager.Orders){
                        if (o.getOrderID() == orderID) {
                            check = false;
                            break;
                        }
                        
                    }

                }while(check);

                if(temp.equals("#")){
                    break;
                }

                System.out.println("Is the customer a member? (Y/N): ");
                String response = getString();                
                if (response.equals("Y")){
                    mem = true;
                    int Contact = -1;
                    // Obtaining a valid customer Contact Number
                    System.out.println("Please Enter the Customer's Contact Number (8xxxxxxx - 9xxxxxxx): ");
                    Contact = super.getValidContactNumber(false);
                    discount = paymentmgt.getDiscount(Contact);
                }
                    
                


                // paymentmgt.getInovice(orderID);
                // System.out.println("Proceed to the counter to make payment.");
                paymentmgt.getReceipt(orderID,mem,discount);
                paymentmgt.storeOrders(orderID);
                paymentmgt.checkout(orderID);

                break;
            case 2:
                paymentmgt.getAllOrders();
                break;
            default:
                break;
            }
        } while (choice < 2);
    }

    /**
     * This is the display menu so that the staff can navigate to what they need.
     */
    public void displayMenu() {
        System.out.println("################# PAYMENT MENU #################");
        System.out.println("Please select an option below.");
        System.out.println("1. Make Payment.");
        System.out.println("2. Get All Orders.");
        System.out.println("3. Exit.");
        // System.out.println("2. Exit.");
        // System.out.println("2. Exit.");

    }
}