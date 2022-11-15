package src.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Employee Object .
 * 
 * @author Fabian Wong
 * @version 1.0
 * @since 13/11/2021
 */

public class Employee extends Person {

	/**
	 * //Variable for storing the id of the Employee
	 * //Variable for storing the title position of the Employee
	 */

	
	int id;
	
	String title = "";

	static List<String> titles = new ArrayList<String>();


	/**
	 * Contructor for Employee
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param contact
	 * @param id
	 * @param title
	 */
	public Employee(String firstName, String lastName, String gender, int contact, int id, String title)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.contact = contact;
		this.id = id;
		String[] name = title.split(" ");
		for (int i = 0; i < name.length; i++)
		{
			name[i] = name[i].substring(0, 1).toUpperCase() + name[i].substring(1);

			if (i == 0)
			{
				this.title += name[i];
			}
			else
			{
				this.title += (" " + name[i]);
			}
		}	
	}
	
	/** Obtaining the name of the Employee
	 * @return String
	 */
	@Override
	//Obtaining the name of the Employee
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	/** Obtaining the first name of the Employee
	 * @return String
	 */
	//Obtaining the first name of the Employee
	public String getFirstName()
	{
		return this.firstName;
	}
	
	/** Obtaining the last name of the Employee
	 * @return String
	 */
	//Obtaining the last name of the Employee
	public String getLastName()
	{
		return this.lastName;
	}
	
	/** Obtaining the gender of the Employee
	 * @return String
	 */
	@Override
	//Obtaining the gender of the Employee
	public String getGender() {
		return this.gender;
	}
	
	/** Obtaining the contact number of the Employee
	 * @return int
	 */
	@Override
	//Obtaining the contact number of the Employee
	public int getContact() {
		return this.contact;
	}
	
	/** Obtaining the valid titles that can be held in the restaurant
	 * @param print
	 * @return List<String>
	 */
	//Obtaining the valid titles that can be held in the restaurant
	public static List<String> getTitleList(boolean print)
	{
		if (print)
		{
			printTitles();
		}
		return titles;
	}
	
	/** Obtaining the ID of the Employee
	 * @return int
	 */
	//Obtaining the ID of the Employee
	public int getID()
	{
		return this.id;
	}
	
	/** Obtaining the title position of the Employee
	 * @return String
	 */
	//Obtaining the title position of the Employee
	public String getTitle()
	{
		return this.title;
	}
	
	/** Updating the title position of the Employee
	 * @param title
	 */
	//Updating the title position of the Employee
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/** Changing the contact number of the Employee
	 * @param contact
	 * @Override
	 */
	@Override
	//Changing the contact number of the Employee
	public void setContact(int contact) {
		this.contact = contact;
	}
	/*public boolean compareId(Employee e)
	{
		if (this.getID() == e.getID())
		{
			return true;
		}
		return false;
	}*/

	/**
	 * Printing the information contained in the Employee
	 * @Override
	 */
	@Override
	//Printing the information contained in the Employee
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Name: " + this.getName());
		System.out.println("Gender: " + this.getGender() + " Contact: " + this.contact);
		System.out.println("ID: " + this.getID() + " Title: " + this.title);
	}

	/**
	 * Printing the available titles in the restaurant
	 */
	//Printing the available titles in the restaurant
	public static void printTitles()
	{
		System.out.println("============================TITLES AVAILABLE====================================");
		for (String s : titles)
		{
			System.out.println(s);
		}
		System.out.println("================================================================================");
	}
	

}
