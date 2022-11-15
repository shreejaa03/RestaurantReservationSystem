// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Random;



// public class AutoGenerateCSV {
	
// 	public static List<String> surnames = new ArrayList<String>();
// 	public static List<String> guyNames = new ArrayList<String>();
// 	public static List<String> girlNames = new ArrayList<String>();
// 	public static List<String> jobTitles = new ArrayList<String>();
// 	public static String[] genders = {"Male", "Female"};
// 	public static String[] membershipType = {"Restaurant","Other Entities", "NA"};
// 	public static List<Person> people = new ArrayList<Person>();
// 	public static List<MenuItem> appetiser = new ArrayList<MenuItem>();
// 	public static List<MenuItem> main = new ArrayList<MenuItem>();
// 	public static List<MenuItem> drinks = new ArrayList<MenuItem>();
// 	public static List<MenuItem> dessert = new ArrayList<MenuItem>();
// 	public static List<MenuItem> items = new ArrayList<MenuItem>();
	
// 	public static void main(String[] args) 
// 	{
// 		//parseCSV("D:\\2002");
// 		//generatePersonCSV("D:\\2002\\Person.csv", 200);
// 		//generateMenuItemCSV("D:\\2002\\Item.csv", 100);
// 	}
// 	public static void generateMenuItemCSV(String filepath, int numToGenerate)
// 	{
// 		FileWriter writeFile = null;
// 		BufferedWriter bufferWrite = null;
// 		PrintWriter printer = null;
// 		try
// 		{
// 			writeFile = new FileWriter(filepath, true);
// 			bufferWrite = new BufferedWriter(writeFile);
// 			printer = new PrintWriter(bufferWrite);
			
// 			printer.println("ItemName,ItemDescription,ItemType");
			
			
// 			for (int i = 0; i < (numToGenerate/4); i++)
// 			{
// 				Random rand = new Random();
// 				MenuItem m = getRandomItem(appetiser);
// 				if (!CheckItemExist(m))
// 				{
// 					System.out.println(m.getName() + "," + m.getDescription().replace(",", "|") + "," + m.getType());
// 					printer.println(m.getName() + "," + m.getDescription().replace(",", "|") + "," + m.getType());
// 					items.add(m);
// 				}
// 				else
// 				{
// 					i--;
// 				}
// 			}
// 			for (int i = 0; i < (numToGenerate/4); i++)
// 			{
// 				Random rand = new Random();
// 				MenuItem m = getRandomItem(main);
// 				if (!CheckItemExist(m))
// 				{
// 					System.out.println(m.getName() + "," + m.getDescription().replace(",", "|") + "," + m.getType());
// 					printer.println(m.getName() + "," + m.getDescription().replace(",", "|") + "," + m.getType());
// 					items.add(m);
// 				}
// 				else
// 				{
// 					i--;
// 				}
// 			}
// 			for (int i = 0; i < (numToGenerate/4); i++)
// 			{
// 				Random rand = new Random();
// 				MenuItem m = getRandomItem(drinks);
// 				if (!CheckItemExist(m))
// 				{
// 					System.out.println(m.getName() + "," + m.getDescription().replace(",", "|") + "," + m.getType());
// 					printer.println(m.getName() + "," + m.getDescription().replace(",", "|") + "," + m.getType());
// 					items.add(m);
// 				}
// 				else
// 				{
// 					i--;
// 				}
// 			}
// 			for (int i = 0; i < (numToGenerate/4); i++)
// 			{
// 				Random rand = new Random();
// 				MenuItem m = getRandomItem(dessert);
// 				if (!CheckItemExist(m))
// 				{
// 					System.out.println(m.getName() + "," + m.getDescription().replace(",", "|") + "," + m.getType());
// 					printer.println(m.getName() + "," + m.getDescription().replace(",", "|") + "," + m.getType());
// 					items.add(m);
// 				}
// 				else
// 				{
// 					i--;
// 				}
// 			}
			
			
			
			
// 		}
// 		catch (Exception E)
// 		{
// 			System.out.println("Didnt Save");
// 		}
// 		finally
// 		{
// 			try {
// 				printer.flush();
// 				printer.close();
// 				bufferWrite.close();
// 				writeFile.close();
// 			} catch (IOException e) {
// 				//Display Error is unable to close Reader
// 				// TODO Auto-generated catch block
// 				e.printStackTrace();
// 			}
// 		}
		
// 	}
// 	public static void generatePersonCSV(String filePath, int numToGenerate)
// 	{

// 		FileWriter writeFile = null;
// 		BufferedWriter bufferWrite = null;
// 		PrintWriter printer = null;
		
// 		try
// 		{
// 			writeFile = new FileWriter(filePath, true);
// 			bufferWrite = new BufferedWriter(writeFile);
// 			printer = new PrintWriter(bufferWrite);
			
// 			printer.println("FirstName,LastName,Gender,ContactNumber,Title,Id,MemberType");
// 			int idCount = 0;
// 			for (int i = 0; i < numToGenerate; i++)
// 			{
// 				String gender = getRandom(Arrays.asList(genders));
// 				String firstName = "";
// 				if (gender.equals("Male"))
// 				{
// 					firstName = getRandom(guyNames);
// 				}
// 				else
// 				{
// 					firstName = getRandom(girlNames);
// 				}
				
// 				String lastName = getRandom(surnames);
// 				int contactNum = getRandomPhoneNumber();
				
// 				Random rand = new Random();
				
// 				String title = "NA";
// 				String id = "NA";
// 				String memberType = "NA";
			
// 				Person newPerson = null;
				
// 				int randomRole = rand.nextInt(2);
// 				if (idCount < numToGenerate * 1/3 && (numToGenerate - i) <= ((numToGenerate * 1/3)- idCount))
// 				{
// 					randomRole = 1;
// 				}
// 				if (idCount >= numToGenerate * 1/3)
// 				{
// 					randomRole = 0;
// 				}
				
// 				//Employee
// 				if (randomRole == 1)
// 				{
// 					System.out.println(idCount);
					
// 					title = getRandom(jobTitles);
// 					if (title.equals("General Manager"))
// 					{
// 						jobTitles.remove("General Manager");
// 					}
// 					id = Integer.toString(idCount);
					
// 					newPerson = new Employee(firstName, lastName, gender, contactNum, Integer.parseInt(id), title);
					
// 					idCount++;
					
					
// 				}
// 				//Customer
// 				else
// 				{
// 					memberType = getRandom(Arrays.asList(membershipType));
// 					newPerson = new Customer(firstName, lastName, gender, contactNum, memberType);
// 				}
				
// 				if (!CheckPersonExist(newPerson))
// 				{
// 					System.out.println(firstName + "," + lastName + "," + gender + "," + contactNum + "," + title + "," + id + "," + memberType);
// 					printer.println(firstName + "," + lastName + "," + gender + "," + contactNum + "," + title + "," + id + "," + memberType);
// 					people.add(newPerson);
// 				}
// 				else
// 				{
// 					i--;
// 				}
				
// 			}
			
			
			
// 		}
// 		catch (Exception E)
// 		{
// 			System.out.println("Didnt Save");
// 		}
// 		finally
// 		{
// 			try {
// 				printer.flush();
// 				printer.close();
// 				bufferWrite.close();
// 				writeFile.close();
// 			} catch (IOException e) {
// 				//Display Error is unable to close Reader
// 				// TODO Auto-generated catch block
// 				e.printStackTrace();
// 			}
// 		}
// 	}
// 	public static void parseCSV(String folderPath)
// 	{
// 		File folder = new File(folderPath);
// 		File[] listOfFiles = folder.listFiles();

// 		for (File file : listOfFiles) {
// 		    if (file.isFile()) {
// 		        System.out.println(file.getName());
// 		        System.out.println(file.getAbsolutePath());
// 		        parseData(file.getAbsolutePath(), file.getName());
// 		    }
// 		}
// 	}
// 	public static void parseData(String path, String type)
// 	{
// 			System.out.println(path);
// 			System.out.println(type);
// 			System.out.println("==========================================");
// 			List<?> listToUse = null;
// 			boolean food = false;
			
// 			if (type.contains("Girl"))
// 			{
// 				listToUse = girlNames;
// 			}
// 			else if (type.contains("Guy"))
// 			{
// 				listToUse = guyNames;
// 			}
// 			else if (type.contains("Titles"))
// 			{
// 				listToUse = jobTitles;
// 			}
// 			else if (type.contains("Appetiser"))
// 			{
// 				listToUse = appetiser;
// 				food = true;
// 			}
// 			else if ( type.contains("Main"))
// 			{
// 				listToUse = main;
// 				food = true;
// 			}
// 			else if (type.contains("Drinks"))
// 			{
// 				listToUse = drinks;
// 				food = true;
// 			}
// 			else if (type.contains("Dessert"))
// 			{
// 				listToUse = dessert;
// 				food = true;
// 			}
// 			else
// 			{
// 				listToUse = surnames;
// 			}
		
// 			//File path
// 			String file = path;	
			
// 			//Used for reading file
// 			BufferedReader reader = null;
			
// 			//Current Line traversed
// 			String line = "";
			
// 			MenuItem item= null;
// 			boolean desc = false;
// 			String itemName = "";
// 			String itemDesc = "";
			
// 			//Try to read the file
// 			try 
// 			{
// 				reader = new BufferedReader(new FileReader(file));
// 				int count = 0;
// 				//Reading the first line to obtain attribute from csv
// 				while ((line = reader.readLine()) != null)
// 				{
					
// 					//line = reader.readLine();
// 					String[] csvAttributes = line.split("  ");
// 					for(String s : csvAttributes)
// 					{
// 						//System.out.println(s);
// 						String name = s;
						
// 						//System.out.println(s.trim() + " : " + s.replaceAll("[^a-zA-Z ]", ""));
// 						if ((s.trim().length() == s.replaceAll("[^a-zA-Z ]", "").length()) && s.length() > 0)
// 						{
// 							//count++;
// 							if (food)
// 							{
// 								itemDesc = name.trim() + ".";
// 							}
// 							else
// 							{
// 								((List<String>)listToUse).add(fixName(name.trim()));
// 							}
							
// 						}
// 						else if (s.contains("|") && food || s.contains(":") && food)
// 						{
// 							if (!s.contains("Recipe"))
// 								itemDesc = itemDesc + (" Ingredients: " + s);
// 							else
// 								itemDesc = itemDesc + s;
							
// 						}
// 						else if (s.replaceAll("[^a-zA-Z0-9]", "").length() > 0)
// 						{
							
// 							count++;
							
							
// 							if (food && s.replaceAll("[^0-9]", "").length() > 0)
// 							{
								
// 								if (!itemName.isEmpty() && !itemDesc.isEmpty())
// 								{
// 									item = new MenuItem(itemName, type, itemDesc );
// 									((List<MenuItem>)listToUse).add(item);
// 									itemName = "";
// 									itemDesc = "";
// 								}
// 								itemName = fixName(name.replaceAll("[^a-zA-Z &]", "").trim());
// 								desc = true;
// 							}
// 							else if (food && desc)
// 							{
// 								itemDesc = name.replaceAll("[^a-zA-Z &]", "").trim() + ".";
// 							}
// 							else if (!food)
// 							{
// 								if (fixName(name.replaceAll("[^a-zA-Z &]", "").trim()).length() >0)
// 									((List<String>)listToUse).add(fixName(name.replaceAll("[^a-zA-Z &]", "").trim()));
// 							}
							
// 						}
						
// 					}
					
// 				}
// 				if (!itemName.isEmpty() && !itemDesc.isEmpty() && desc)
// 				{
// 					item = new MenuItem(itemName, type, itemDesc );
// 					desc = false;
// 					itemName = "";
// 					itemDesc = "";
// 				}
// 				System.out.println(count);				
// 			}
// 			//Display Error
// 			catch(Exception e)
// 			{
// 				e.printStackTrace();
// 			}
// 			//Close the reader after finished
// 			finally
// 			{
// 				try {
// 					reader.close();
// 				} catch (IOException e) {
// 					//Display Error is unable to close Reader
// 					// TODO Auto-generated catch block
// 					e.printStackTrace();
// 				}
// 			}
// 			System.out.println("================DEBUG ABOVE==============================");
			
// 			if (food)
// 			{
// 				//System.out.println("FOOD");
// 				for (MenuItem s : (List<MenuItem>)listToUse)
// 				{
// 					s.print();
// 				}
// 			}
// 			else
// 			{
// 				for (String s : (List<String>)listToUse)
// 				{
// 					System.out.println(s);
// 				}
// 			}
// 	}
// 	public static String fixName(String name)
// 	{
		
// 		String fixedName = "";
// 		name = name.toLowerCase();
// 		String[] nameFixed = name.split(" ");
// 		int count = 0;
// 		for (String s : nameFixed)
// 		{
// 			if (s.length() > 0)
// 			{
// 				s = s.substring(0,1).toUpperCase() + s.substring(1);
// 				if (count > 0)
// 				{
// 					fixedName += " ";
// 				}
// 				fixedName += s;
// 				count++;
// 			}

// 		}
// 		return fixedName;
// 	}
// 	public static String getRandom(List<String> listToUse)
// 	{
// 		Random rand = new Random();
// 		String randomString = listToUse.get(rand.nextInt(listToUse.size()));
// 		return randomString;
// 	}
// 	public static MenuItem getRandomItem(List<MenuItem> listToUse)
// 	{
// 		Random rand = new Random();
// 		MenuItem item = listToUse.get(rand.nextInt(listToUse.size()));
// 		return item;
// 	}
// 	public static int getRandomPhoneNumber()
// 	{
// 		Random rand = new Random();
// 		int phoneNum = rand.nextInt(20000000) + 80000000;
// 		return phoneNum;
// 	}
// 	public static boolean CheckPersonExist(Person personToCheck)
// 	{
// 		for (Person p : people)
// 		{
// 			if (p.compareDuplicate(personToCheck))
// 			{
// 				return true;
// 			}
// 		}
// 		return false;
// 	}
// 	public static boolean CheckItemExist(MenuItem menuItem)
// 	{
// 		for (MenuItem m : items)
// 		{
// 			if (m.compareDuplicate(menuItem))
// 			{
// 				return true;
// 			}
// 		}
// 		return false;
// 	}
	

// }
