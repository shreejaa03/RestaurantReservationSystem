package src.Boundary;

import src.Control.OrderManager;
import src.Database.Database;
import src.Entity.Person;
import src.Entity.Employee;
import src.Database.TableDatabase;
import src.Entity.Table;

/**
 * This is the Order UI
 * 
 * @author Reeves Chiu
 * @version 1.0
 * @since 13/11/2021
 */


public class OrderUI extends UI {


    /**
     * This is the checker and redirect to perform different functions
     */
    public void run() {

        int choice = -1;
        int staffID,tableNo,orderID;
        // String staffName;


        do {
            this.displayMenu();
            choice = getInput();
            OrderManager ordermgt = new OrderManager();

            switch (choice) {
            case 1:

                Employee staff = null;
                Table table;

                do{
                    System.out.println("Enter Table Number: ");
                    tableNo = getInput();

                    table = TableDatabase.tableList.get(tableNo);
                    if (table == null){
                        System.out.println("Table does not exist.");
                        continue;
                    }
                    else if (table.isTaken() == true ){
                        System.out.println("Table is Currently Taken");
                        continue;
                    }
                    
                }while( table == null|| table.isTaken());




                do{
                    if(staff != null && staff.getTitle() != "Server" ){
                        System.out.println("Staff ID is not a Server");
                    }
                    System.out.println("Enter Staff ID: ");
                    staffID = getInput();

                    if (staffID >= Database.employeesDB.size()){
                        System.out.println("Staff does not exist.");
                        continue;
                    }

                    Person temp =  Database.employeesDB.get(staffID);
                    staff = (Employee)temp;


                    
                }while( staff == null || !staff.getTitle().equals("Server"));
                
                // System.out.printf("NAME: %s\n", staff.getName());
    
                ordermgt.createOrder(staffID,tableNo,staff.getName());
                break;
            case 2:
                System.out.println("Enter Order: ");
                orderID = getInput();
                ordermgt.getOrder(orderID);
                break;
            case 3:
                System.out.println("Enter Order: ");
                orderID = getInput();
                ordermgt.addOrder(orderID);
                break;
            case 4:
                System.out.println("Enter Order: ");
                orderID = getInput();
                ordermgt.deleteItem(orderID);
                break;
            case 5:
                ordermgt.getAllOrders();
                break;
            case 6:
                System.out.println("Enter Order: ");
                orderID = getInput();
                ordermgt.deleteOrder(orderID);
                break;
            default:
                break;
            }
        } while (choice < 7);
    }


    /**
     * This is the display menu so that the staff can navigate to what they need.
     */
    public void displayMenu() {
        System.out.println("\n################# ORDER MENU #################");
        System.out.println("1. Create Order.");
        System.out.println("2. Get Order.");
        System.out.println("3. Add Order.");
        System.out.println("4. Delete Items.");
        System.out.println("5. Get All Orders.");
        System.out.println("6. Delete Order.");
        System.out.println("7. Back.");
    }
}