package src.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.time.*;

import src.Entity.Customer;
import src.Entity.Employee;
import src.Entity.MenuItem;
import src.Entity.OrderItem;
import src.Entity.Person;

/**
 * Converts the CSV items into the Database
 * @author Fabian Wong
 * @version 1.0
 * @since 13/11/2021
 */
public class Database {

	// List to store all the existing employee of the restaurant from a given .csv
	// file
	public static List<Person> employeesDB = new ArrayList<Person>();
	// List to store all the existing customer that visited the restaurant from a
	// given .csv file
	public static List<Person> customersDB = new ArrayList<Person>();
	// List to store all the existing menuItems that are available in the restaurant
	// from a given .csv file
	public static List<MenuItem> menuItemsDB = new ArrayList<MenuItem>();

	public static String restaurantName;

	/**
	 * Enum for easy access to the valid index for respective attributes from the csv
	 */
	static enum DesiredAttribute {
		// Person Attributes
		FIRSTNAME("FirstName", 0), 
		LASTNAME("LastName", 0), 
		GENDER("Gender", 0), 
		CONTACT("Contact", 0),
		TITLE("Title", 0), 
		ID("Id", 0), 
		MEMEBERTYPE("Member", 0),
		// MenuItem Attributes
		ITEMNAME("ItemName", 0), 
		ITEMDESCRIPTION("ItemDesc", 0), 
		ITEMTYPE("ItemType", 0), 
		ITEMPRICE("ItemPrice", 0),
		//Orders Attributes
		ORDERID ("OrderID" , 0),
		ORDERITEMNAME ("OrderItemName" , 0),
		ORDERDAY ("OrderDay" , 0),
		ORDERMONTH ("OrderMonth" , 0),
		ORDERQUANTITY ("OrderQuantity" , 0),
		ORDERPRICE ("OrderPrice" , 0);

		// Obtaining all the attributes initialised in DesiredAttribute
		static DesiredAttribute[] desired = DesiredAttribute.values();
		// Name of the DesiredAttribute
		private String name;
		// Index of the DesiredAttribute
		private int index;

		/**
		 * Obtaining the name of the DesiredAttribute
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * Obtaining the index of the DesiredAttribute
		 */
		public int getIndex() {
			return this.index;
		}

		/**
		 * Setting the index of the DesiredAttribute
		 */
		public void setIndex(int index) {
			this.index = index;
		}

		/**
		 * Setting the index of the DesireAttribute based of the name provided
		 */
		public static void setIndex(String name, int index) {
			for (DesiredAttribute d : desired) {
				if (name.contains(d.getName())) {
					d.setIndex(index);
				}
			}
		}

		/**
		 * Printing the desiredAttributes available
		 */
		public static void print() {

			for (DesiredAttribute d : desired) {
				System.out.println(d.getName() + d.getIndex());
			}
		}

		/**
		 * Constructor for the DesiredAttribute
		 * @param name Name of the desired attribute.
		 * @param index index of the DesiredAttribute
		 */
		DesiredAttribute(String name, int index) {
			this.name = name;
		}
	}

	// CAN BE REMOVED
	/*public static void main(String[] args) throws InterruptedException {

		//Database.parseCSV("src/Database/csv");
		//generatePastOrders("src/Database/csv/Orders.csv", 30, 5, 5, 4);
		//Database.computeRevenue("src/Database/csv/Orders.csv", 12, 11);
		//Database.updateRevenue("src/Database/csv/OrdersTest.csv", 1, "Chicken Pie", 3.2f, 5, 12, 11);
		
	 }*/
	 //TO BE REMOVED

	//  /**
	//   * Generates past orders from CSV file
	//   * @param filepath The path to the CSV file
	//   *	@param numOfDays Number of days to be accessed
	//   *	@param maxOrder
	//   */
	public static void generatePastOrders(String filepath, int numOfDays, int maxOrder, int maxItem, int maxQuantity)
	{
		FileWriter writeFile = null;
		BufferedWriter bufferWrite = null;
		PrintWriter printer = null;
		try
		{
			writeFile = new FileWriter(filepath, true);
			bufferWrite = new BufferedWriter(writeFile);
			printer = new PrintWriter(bufferWrite);
			
			printer.println("OrderID,OrderItemName,OrderPrice,OrderQuantity,OrderDay,OrderMonth");
			
			java.util.Random rand = new java.util.Random();
			LocalDateTime today = LocalDateTime.now();
			LocalDateTime edited = today;

			
			
			//Days
			for (int i = 0 ; i < numOfDays; i++)
			{
				int randomOrders = rand.nextInt(maxOrder)+ 1;
				//Order in day
				for (int j = 0 ; j < randomOrders; j++)
				{
					
					int randomOrderItems = rand.nextInt(maxItem) + 1;
					List<MenuItem> inMenu = new ArrayList<MenuItem>();
					for (int k = 0 ; k < randomOrderItems; k++)
					{
						
						int orderId = j;						
						MenuItem m = menuItemsDB.get(rand.nextInt(menuItemsDB.size()));				
						int quantity = rand.nextInt(maxQuantity) + 1;
						boolean exist = false;
						
						for (MenuItem mi : inMenu)
						{
							if (mi.compareDuplicate(m))
								exist = true;
						}
						if (!exist)
						{						
							//System.out.println(orderId + "," + m.getName()+ "," + m.getPrice() + "," + quantity +"," + edited.getDayOfMonth() + "," + edited.getMonthValue());
							printer.println(orderId + "," + m.getName()+ "," +  String.format("%.2f",m.getPrice()) + "," + quantity +"," + edited.getDayOfMonth() + "," + edited.getMonthValue());
							inMenu.add(m);
						}										
						else
							k--;
					}
					
				}
				edited = edited.minusDays(1);
			}
			
			
		}
		catch (Exception E)
		{
			System.out.println("Didnt Save");
		}
		finally
		{
			try {
				printer.flush();
				printer.close();
				bufferWrite.close();
				writeFile.close();
			} catch (IOException e) {
				//Display Error is unable to close Reader
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * Obtains all the CSV files in the folder path provided.
	 * @param folderPath The path to the folder containing the CSV files.
	 */
	public static void parseCSV(String folderPath) {
		// Obtaining the folder using the path provided
		File folder = new File(folderPath);
		// Obtaining the files in the respective folder
		File[] listOfFiles = folder.listFiles();

		// Traverse the file and search for .csv files only
		for (File file : listOfFiles) {
			if (file.isFile() && file.getName().contains(".csv")) {
				// System.out.println(file.getName());
				// System.out.println(file.getAbsolutePath());

				// Convert .csv to respective Java classes
				parseData(file.getAbsolutePath(), file.getName());
			}
		}
	}

	/**
	 * Converting the data from the csv files into useable classes in Java via path
	 * @param path The path of the csv file.
	 * @param type The type of the csv file.
	 */
	public static void parseData(String path, String type) {

		if (type.contains("Order"))
		{
			return;
		}
		// File path
		String file = path;

		// Used for reading file
		BufferedReader reader = null;

		// Current Line traversed
		String line = "";

		// Try to read the file
		try {
			// Reader used for reading the csv
			reader = new BufferedReader(new FileReader(file));

			// If the .csv file name contains the word Person, it is associated with
			// crafting the Customer/Employee Database
			if (type.contains("Person")) {
				// Reading the first line to obtain attribute from csv
				line = reader.readLine();
				String[] attributes = line.split(",");

				// Setting the DesiredAttributes with the valid index for obtaining the
				// attributes from the line later
				for (int i = 0; i < attributes.length; i++) {
					DesiredAttribute.setIndex(attributes[i], i);
				}
				// Read the entire .csv file
				while ((line = reader.readLine()) != null) {
					// Splitting the lines into respective attributes for constructing classes
					String[] personRow = line.split(",");

					// The person does not have an ID, hence is a customer
					if (personRow[DesiredAttribute.ID.getIndex()].equals("NA")) {
						// Construct the customer
						customersDB.add(InitialiseCustomer(personRow));
					}
					// The person has an ID, hence is an employee
					else {
						// Construct the employee
						employeesDB.add(InitialiseEmployee(personRow));
					}
				}
			}
			// If the .csv file name contains the word Item, it is associated with crafting
			// the MenuItem Database
			else if (type.contains("Item")) {
				// Reading the first line to obtain attribute from csv
				line = reader.readLine();
				String[] row = line.split(",");
				// Setting the DesiredAttributes with the valid index for obtaining the
				// attributes from the line later
				for (int i = 0; i < row.length; i++) {
					DesiredAttribute.setIndex(row[i], i);
				}
				// Read the entire .csv file
				while ((line = reader.readLine()) != null) {
					// Splitting the lines into respective attributes for constructing classes
					String[] itemRow = line.split(",");

					// Construct the menuItem
					menuItemsDB.add(InitialiseMenuItem(itemRow));
				}
			}
			// Since there is only 3 csv in the folder, the remaining file is for obtaining
			// Titles available in the restaurant
			else {
				// Read the entire .csv file
				while ((line = reader.readLine()) != null) {
					// Adding the available titles of the restaurant into the list
					Employee.getTitleList(false).add(line.replaceAll("[^a-zA-Z/ ]", "").trim());
				}
			}

		}
		// Display Error
		catch (Exception e) {
			e.printStackTrace();
		}
		// Close the reader after finished
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// Display Error is unable to close Reader
				e.printStackTrace();
			}
		}

	}

	/**
	 * Updates the revenue of the restaurant of particular day & month to the CSV
	 * @param path The path of the csv file to be updated
	 * @param orderID The orderID of the order.
	 * @param orderItemName The name of the order item.
	 * @param orderPrice The price of the order.
	 * @param quantity The quantity of the order item.
	 * @param day The day of the revenue update.
	 * @param month The month of the revenue update.
	 */
	public static void updateRevenue(String path, int orderID, String orderItemName, double orderPrice, int quantity,  int day, int month)
	{
		FileWriter writeFile = null;
		BufferedWriter bufferWriter = null;
		PrintWriter printer = null;
		try
		{
			writeFile = new FileWriter(path, true);
			bufferWriter = new BufferedWriter(writeFile);
			printer = new PrintWriter(bufferWriter);
			
			printer.println(orderID + "," + orderItemName + "," + String.format("%.2f",orderPrice) + "," + quantity + "," + day + "," + month);
			
		}
		catch (Exception E)
		{
			System.out.println("Didnt Save");
		}
		finally
		{
			try {
				printer.flush();
				printer.close();
				bufferWriter.close();
				writeFile.close();
			} catch (IOException e) {
				//Display Error is unable to close Reader
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Computes the Revenue of particular date & month
	 * @param path Path to the CSV file.
	 * @param day The day to be computed.
	 * @param month The month to be computed.
	 */
	public static double computeRevenue(String path, int day, int month)
	{
		//File path
		String file = path;	
		
		//Used for reading file
		BufferedReader reader = null;
		
		//Current Line traversed
		String line = "";
		
		double revenue = 0.0f;
		//Try to read the file
		try 
		{
			//Reader used for reading the csv
			reader = new BufferedReader(new FileReader(file));

			//Reading the first line to obtain attribute from csv
			line = reader.readLine();
			String[] attributes = line.split(",");
			
			//Setting the DesiredAttributes with the valid index for obtaining the attributes from the line later
			for (int i = 0; i < attributes.length; i++ )
			{
				DesiredAttribute.setIndex(attributes[i], i);
			}
			//Read the entire .csv file
			
			List<OrderItem> orders = new ArrayList<OrderItem>();

			while ((line = reader.readLine()) != null)
			{
				//Splitting the lines into respective attributes for constructing classes
				String[] orderRow = line.split(",");
				if ((Integer.parseInt(orderRow[DesiredAttribute.ORDERMONTH.getIndex()])) == month)
				{
					if (day != 0 && (Integer.parseInt(orderRow[DesiredAttribute.ORDERDAY.getIndex()])) == day || day == 0)
					{
						OrderItem ordItem = null;
						//Find the same order item in different order
						for (OrderItem oi : orders)
						{
							if (oi.getName().equals(orderRow[DesiredAttribute.ORDERITEMNAME.getIndex()]))
							{
								ordItem = oi;
							}
						}

						int quantity = (Integer.parseInt(orderRow[DesiredAttribute.ORDERQUANTITY.getIndex()]));
						String name = orderRow[DesiredAttribute.ORDERITEMNAME.getIndex()];
						Double price = (Double.parseDouble(orderRow[DesiredAttribute.ORDERPRICE.getIndex()]) * Double.parseDouble(orderRow[DesiredAttribute.ORDERQUANTITY.getIndex()]));
						revenue += (Double.parseDouble(orderRow[DesiredAttribute.ORDERPRICE.getIndex()]) * Double.parseDouble(orderRow[DesiredAttribute.ORDERQUANTITY.getIndex()]));
						
						if (ordItem == null)
						{						
							ordItem = new OrderItem(quantity, name , null , price);	
							orders.add(ordItem);				
						}
						else
						{
							ordItem.setPax(ordItem.getPax() + quantity);
							ordItem.setPrice(ordItem.getPrice() + price);
						}
							
					}
				}
			}

			System.out.println("============================================================================");
			System.out.println("TOTAL SALES REVENUE ON: " + ((day != 0) ? (day + "/") : "" ) + month + "/2021");
			System.out.println("============================================================================");
			
			for (OrderItem oi : orders)
			{
				System.out.println("Item Name: " + oi.getName());
				System.out.println("Quantity: " + oi.getPax());
				System.out.println("Total Sales: $" + String.format("%.2f",oi.getPrice()));		
			}
			System.out.println("============================================================================");
			System.out.println("TOTAL SALES REVENUE : $" +  String.format("%.2f",revenue));
			System.out.println("============================================================================");
					
		}
		//Display Error
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//Close the reader after finished
		finally
		{
			try {
				reader.close();
			} catch (IOException e) {
				//Display Error is unable to close Reader
				e.printStackTrace();
			}
		}
		
		return revenue;
			
	}
	

	public static Customer InitialiseCustomer(String[] row) {
		// Obtaining the respective attributes using the DesiredAttribute for accuracy
		String firstName = row[DesiredAttribute.FIRSTNAME.getIndex()];
		String lastName = row[DesiredAttribute.LASTNAME.getIndex()];
		String gender = row[DesiredAttribute.GENDER.getIndex()];
		int contactNumber = Integer.valueOf(row[DesiredAttribute.CONTACT.getIndex()]);
		String member = row[DesiredAttribute.MEMEBERTYPE.getIndex()];

		// Construct the Customer
		Customer c = new Customer(firstName, lastName, gender, contactNumber, member);
		// Return the constructed Customer
		return c;
	}

	// Constructing the Employee for adding into the database
	public static Employee InitialiseEmployee(String[] row) {
		// Obtaining the respective attributes using the DesiredAttribute for accuracy
		String firstName = row[DesiredAttribute.FIRSTNAME.getIndex()];
		String lastName = row[DesiredAttribute.LASTNAME.getIndex()];
		String gender = row[DesiredAttribute.GENDER.getIndex()];
		int contactNumber = Integer.valueOf(row[DesiredAttribute.CONTACT.getIndex()]);
		int id = Integer.valueOf(row[DesiredAttribute.ID.getIndex()]);
		String title = row[DesiredAttribute.TITLE.getIndex()];

		// Construct the Employee
		Employee e = new Employee(firstName, lastName, gender, contactNumber, id, title);
		// Return the constructed Employee
		return e;
	}

	// Constructing the Menu Item for adding into the database
	public static MenuItem InitialiseMenuItem(String[] row) {
		// Obtaining the respective attributes using the DesiredAttribute for accuracy
		String name = row[DesiredAttribute.ITEMNAME.getIndex()];
		String description = row[DesiredAttribute.ITEMDESCRIPTION.getIndex()];
		String type = row[DesiredAttribute.ITEMTYPE.getIndex()];
		float price = Float.parseFloat(row[DesiredAttribute.ITEMPRICE.getIndex()]);

		// Construct the MenuItem
		MenuItem m = new MenuItem(name, description, type, price);
		// Return the constructed MenuItem
		return m;
	}

	// Printing the customers, employees and menuitems database generated
	public static void printDatabase() {
		System.out.println("================CUSTOMERS==============================");
		for (Person p : customersDB) {
			p.print();
		}
		System.out.println("=======================================================");
		System.out.println("================EMPLOYEES==============================");
		for (Person p : employeesDB) {
			p.print();
		}
		System.out.println("=======================================================");
		System.out.println("================MENU ITEMS==============================");
		for (MenuItem m : menuItemsDB) {
			m.print();
		}
		System.out.println("=======================================================");
	}

	// Combining every customer and employee into one list for checking
	public static List<Person> getPersonList() {
		List<Person> everyone = new ArrayList<Person>(employeesDB);
		everyone.addAll(customersDB);
		return everyone;
	}
}
