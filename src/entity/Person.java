package src.Entity;


/**
 * abstract Person Object .
 * 
 * @author Fabian Wong
 * @version 1.0
 * @since 13/11/2021
 */

public abstract class Person {


	/**
	 * // Variable for storing the first name of a Person
	 * // Variable for storing the last name of a Person
	 * // Variable for storing the gender of a Person
	 * // Variable for storing the contact number of a Person
	 * // Different Variations of input for Male and Female
	 */

	String firstName = "";
	
	String lastName = "";
	
	String gender = "";
	
	int contact = 0;

	
	static String[] genders = { "MALE", "FEMALE", "M", "F" };

	
	/** Abstract function to be overwritten by the child
	 * @param returnGenderSynonym(
	 * @return String
	 */
	// Abstract function to be overwritten by the child
	public abstract String getName();

	
	/** 
	 * @param returnGenderSynonym(
	 * @return String
	 */
	public abstract String getFirstName();

	
	/** 
	 * @param returnGenderSynonym(
	 * @return String
	 */
	public abstract String getLastName();

	
	/** 
	 * @param returnGenderSynonym(
	 * @return String
	 */
	public abstract String getGender();

	
	/** 
	 * @param returnGenderSynonym(
	 * @return int
	 */
	public abstract int getContact();

	
	/** 
	 * @param returnGenderSynonym(
	 */
	public abstract void setContact(int contact);

	
	/** 
	 * @param returnGenderSynonym(
	 */
	public abstract void print();

	
	/** Obtaining the variation used for inputing the gender
	 * @return String[]
	 */
	// Obtaining the variation used for inputing the gender
	public static String[] returnGenderSynonym() {
		return genders;
	}

	
	/** Compare to see if person already exist by checking the first and last name OR checking the contact number
	 * @param p
	 * @return boolean
	 */
	// Compare to see if person already exist by checking the first and last name OR
	// checking the contact number
	public boolean compareDuplicate(Person p) {

		if ((p.getFirstName().equals(this.getFirstName()) && p.getLastName().equals(this.getLastName()))
				|| (p.getContact() == this.getContact())) {
			return true;
		}

		return false;
	}

}
