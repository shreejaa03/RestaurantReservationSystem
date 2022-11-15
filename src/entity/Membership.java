package src.Entity;


public class Membership {
	
	//Type of membership
	String type = "";
	float discountPercent = 0.0f;

	static String[] availableMembership = {"Restaurant", "Other Entities"};
	
	//Constructor for membership
	public Membership(String type)
	{
		String[] name = type.split(" ");
		for (int i = 0; i < name.length; i++)
		{
			name[i] = name[i].substring(0, 1).toUpperCase() + name[i].substring(1);

			if (i == 0)
			{
				this.type += name[i];
			}
			else
			{
				this.type += (" " + name[i]);
			}
		}	
		this.discountPercent = setDiscountPercent(type);
	}
	//Obtaining the type of Membership
	public String getType()
	{
		return this.type;
	}
	//Updating the type of Membership
	public void setType(String type)
	{
		this.type = type;
		this.discountPercent = setDiscountPercent(type);
	}
	public static String[] getAvailableMembership()
	{
		printMembership();
		return availableMembership;
	}
	//Printing the available membership in the restaurant
	public static void printMembership()
	{
		System.out.println("============================MEMBERSHIP AVAILABLE====================================");
		for (String s : availableMembership)
		{
			System.out.println(s);
		}
		System.out.println("================================================================================");
	}
	//Set the discount percent according to the membership type
	public float setDiscountPercent(String type)
	{
		String convert = type.toLowerCase();
		if (convert.equals("restaurant"))
		{
			return 0.3f;
		}
		else if (convert.equals("other entities"))
		{
			return 0.2f;
		}
		else
		{
			return 0.0f;
		}
	}
	public float getDiscountPercent()
	{
		return this.discountPercent;
	}
}
