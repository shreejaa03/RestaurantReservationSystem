package src.Entity;


/**
 * Customer Object .
 * 
 * @author Fabian Wong
 * @version 1.0
 * @since 13/11/2021
 */

public class Customer extends Person {
	
	//Variable for storing the member status of the Customer
	boolean member = false;
	//Membership held by the Customer
	Membership membership;


	/**
	 * Constructor for the Customer
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param contact
	 * @param membership
	 */
	//Constructor for the Customer
	public Customer(String firstName, String lastName, String gender, int contact, String membership)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.contact = contact;
		//Customer holds a membership
		if (!membership.equals("NA"))
		{
			this.member = true;
		}
		//Customer does not hold a membership
		else
		{
			this.member = false;
		}
		this.membership = new Membership(membership);
		
	}
	
	/** 
	 * Obtaining the name of the customer
	 * @return String
	 * @Override
	 */
	@Override
	//Obtaining the name of the customer
	public String getName() {
		return this.lastName + " " + this.firstName;
	}
	
	/** 
	 * Obtaining the first name of the customer
	 * @return String
	 */
	//Obtaining the first name of the customer
	public String getFirstName()
	{
		return this.firstName;
	}
	
	/** 
	 * Obtaining the last name of the customer
	 * @return String
	 */
	//Obtaining the last name of the customer
	public String getLastName()
	{
		return this.lastName;
	}
	
	/** 
	 * Obtaining the gender of the customer
	 * @return String
	 * @Override
	 */
	//Obtaining the gender of the customer
	@Override
	public String getGender() {
		return this.gender;
	}
	
	/** 
	 * Obtaining the contact number of the customer
	 * @return int
	 * 	@Override
	 */
	//Obtaining the contact number of the customer
	@Override
	public int getContact() {
		return this.contact;
	}
	
	/** 
	 * 	Changing the contact number of the customer
	 * @param contact
	 * 	@Override
	 */
	@Override
	//Changing the contact number of the customer
	public void setContact(int contact) {
		this.contact = contact;
	}
	
	/** 
	 * Obtaining the member status of the customer
	 * @return boolean
	 */
	//Obtaining the member status of the customer
	public boolean getMember()
	{
		return this.member;
	}
	
	/** 
	 * Obtaining the membership of the customer
	 * @return Membership
	 */
	//Obtaining the membership of the customer
	public Membership getMembership()
	{
		return this.membership;
	}
	
	/** 
	 * Updating the membership status of the customer
	 * @param membershipType
	 */
	//Updating the membership status of the customer
	public void setMemberShip(String membershipType)
	{
		if (membershipType.equals(""))
		{
			this.member = false;
			this.membership.setType("NA");;
		}
		else
		{
			this.member = true;
			this.membership.setType(membershipType);
		}
	}
	/**
	 * Printing the information contained in the Customer
	 * 	@Override
	 */
	@Override
	//Printing the information contained in the Customer
	public void print() {
		System.out.println("Name: " + this.getName());
		System.out.println("Gender: " + this.getGender() + " Contact: " + this.contact);
		System.out.println("Member: " + this.getMember() + " Membership Type: " + this.membership.getType());
	}
	public void printMinimal() {
		System.out.println("Name: " + this.getName() + " Contact: " + this.contact + " Member: " + this.getMember() );
	}


}
