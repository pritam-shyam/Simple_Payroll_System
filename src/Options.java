import java.util.*;
import java.sql.*;

/**
 * Options class that holds the methods selected by the user in the menu class. 
 * Options include initialization and connecting to the database,
 * adding employees, editting employees, deleting employees, showing employees,
 * computation of payroll, and last, closing the program
 * @author Pritam Shyam, Ty Ash, Nathaniel Burger, Reinaldy Lamdjani
 */
public class Options extends StringsDB
{
	private static Scanner in = new Scanner(System.in);
	
	/**
	 * add employee method to insert employee information
	 * @throws SQLException
	 */
	public static void addEmp() throws SQLException
	{
		Connection con = DBconnect.getConnection();
		
		System.out.print("Employee ID: ");
		empID = in.nextInt();
		in.nextLine();
	    System.out.print("First Name: ");
		firstN = in.nextLine();
		System.out.print("Last Name: ");
		lastN = in.nextLine();
		System.out.print("Address: ");
		address = in.nextLine();
		System.out.print("City: ");
		city = in.nextLine();
		System.out.print("State: ");
		state = in.nextLine();
		System.out.print("Zip: ");
		zip = in.nextLine();
		System.out.print("Age: ");
		age = in.nextInt();
		in.nextLine();
		System.out.print("Gender: ");
		gender = in.nextLine();
		System.out.print("Marital Status: ");
		marital = in.nextLine();
		System.out.print("SSN: ");
		ssn = in.nextLine();
		System.out.print("Employee Type: ");
		type = in.nextInt();
		in.nextLine();
		System.out.print("Plan Number: ");
		plan = in.nextInt();
		in.nextLine();
		System.out.print("Tax Rank: ");
		tax = in.nextInt();
	
		PreparedStatement stat = con.prepareStatement(addEmp);
		stat.setInt(1, empID);
		stat.setString(2, firstN);
		stat.setString(3, lastN);
		stat.setString(4, address);
		stat.setString(5, city);
		stat.setString(6, state);
		stat.setString(7, zip);
		stat.setInt(8, age);
		stat.setString(9, gender);
		stat.setString(10, marital);
		stat.setString(11, ssn);
		stat.setInt(12, type);
		stat.setInt(13, plan);
		stat.setInt(14, tax);
		stat.executeUpdate();
		
		System.out.println("");
		System.out.println("Employee Number: " + empID + " added.");
		con.close();
		stat.close();
	}
	
	/**
	 * edit employee method to change employee information
	 * @throws SQLException
	 */
	public static void editEmp() throws SQLException 
	{
		System.out.print("\n");
		System.out.println("Edit options: Name, Address, City, State, Zip, Age & Marital");
		System.out.print("\n");
		System.out.print("Employee ID: ");
		empID = in.nextInt();
		Connection con = DBconnect.getConnection();
		Statement stat = con.createStatement();
		ResultSet result = stat.executeQuery("SELECT * FROM App.Employees_T WHERE ID =" + empID);
		while(result.next())
		{
			System.out.print("Enter option: ");
			String answer = in.next();
			
			if(answer.equals("Name"))
			{
				System.out.print("\n");
				System.out.print("Current name: " + result.getString("EFirst"));
				System.out.print(" ");
				System.out.print(result.getString("ELast"));
				System.out.print("\n");
				
				System.out.print("\n");
				System.out.print("Enter First Name: ");
				String newName = in.next();
				System.out.print("Enter Last Name: ");
				String newName2 = in.next();
				
				String nameChange = "UPDATE App.Employees_T SET EFirst = ?, ELast = ? WHERE ID =" + empID;
				PreparedStatement nChange = con.prepareStatement(nameChange);
				nChange.setString(1, newName);
				nChange.setString(2, newName2);
				nChange.executeUpdate();
				nChange.close();
				
				System.out.print("\n");
				System.out.println("Name for employee " + empID + " updated");
			}
			
			if(answer.equals("Address"))
			{
				System.out.print("\n");
				System.out.print("Current address: " + result.getString("Address"));
				System.out.print("\n");
				
				System.out.print("\n");
				System.out.print("Enter new address: ");
				String newAdd1 = in.next();
				String newAdd2 = in.nextLine();
				String newAdd = newAdd1 + newAdd2;
				
				String addChange = "UPDATE App.Employees_T SET Address = ? WHERE ID =" + empID;
				PreparedStatement aChange = con.prepareStatement(addChange);
				aChange.setString(1, newAdd);
				aChange.executeUpdate();
				aChange.close();
				
				System.out.print("\n");
				System.out.println("Address for employee " + empID + " updated");
			}
			
			if(answer.equals("City"))
			{
				System.out.print("\n");
				System.out.print("Current city: " + result.getString("City"));
				System.out.print("\n");
				
				System.out.print("\n");
				System.out.print("Enter new city: ");
				String newAdd1 = in.next();
				String newAdd2 = in.nextLine();
				String newAdd = newAdd1 + newAdd2;
				
				String addChange = "UPDATE App.Employees_T SET City = ? WHERE ID =" + empID;
				PreparedStatement aChange = con.prepareStatement(addChange);
				aChange.setString(1, newAdd);
				aChange.executeUpdate();
				aChange.close();
				
				System.out.print("\n");
				System.out.println("City for employee " + empID + " updated");
			}
			
			if(answer.equals("State"))
			{
				System.out.print("\n");
				System.out.print("Current state: " + result.getString("State"));
				System.out.print("\n");
				
				System.out.print("\n");
				System.out.print("Enter new state: ");
				String newAdd = in.next();
				
				String addChange = "UPDATE App.Employees_T SET State = ? WHERE ID =" + empID;
				PreparedStatement aChange = con.prepareStatement(addChange);
				aChange.setString(1, newAdd);
				aChange.executeUpdate();
				aChange.close();
				
				System.out.print("\n");
				System.out.println("State for employee " + empID + " updated");
			}
			
			if(answer.equals("Zip"))
			{
				System.out.print("\n");
				System.out.print("Current zip code: " + result.getString("ZipCode"));
				System.out.print("\n");
				
				System.out.print("\n");
				System.out.print("Enter new zip code: ");
				String newAdd = in.next();
				
				String addChange = "UPDATE App.Employees_T SET ZipCode = ? WHERE ID =" + empID;
				PreparedStatement aChange = con.prepareStatement(addChange);
				aChange.setString(1, newAdd);
				aChange.executeUpdate();
				aChange.close();
				
				System.out.print("\n");
				System.out.println("Zip code for employee " + empID + " updated");
			}
			
			if(answer.equals("Age"))
			{
				System.out.print("\n");
				System.out.print("Current age: " + result.getString("Age"));
				System.out.print("\n");
				
				System.out.print("\n");
				System.out.print("Enter new age: ");
				int newAdd = in.nextInt();
				
				String addChange = "UPDATE App.Employees_T SET Age = ? WHERE ID =" + empID;
				PreparedStatement aChange = con.prepareStatement(addChange);
				aChange.setInt(1, newAdd);
				aChange.executeUpdate();
				aChange.close();
				
				System.out.print("\n");
				System.out.println("Age for employee " + empID + " updated");
			}
			
			if(answer.equals("Marital"))
			{
				System.out.print("\n");
				System.out.print("Current marital status: " + result.getString("MaritalStatus"));
				System.out.print("\n");
				
				System.out.print("\n");
				System.out.print("Enter new marital status: ");
				String newAdd = in.next();
				
				String addChange = "UPDATE App.Employees_T SET MaritalStatus = ? WHERE ID =" + empID;
				PreparedStatement aChange = con.prepareStatement(addChange);
				aChange.setString(1, newAdd);
				aChange.executeUpdate();
				aChange.close();
				
				System.out.print("\n");
				System.out.println("Marital status for employee " + empID + " updated");
			}
		}
		
	}
	
	/**
	 * delete employee method to drop an employee from the database
	 * @throws SQLException
	 */
	public static void deleteEmp() throws SQLException 
	{
		System.out.print("Employee ID: ");
		empID = in.nextInt();
		Connection con = DBconnect.getConnection();
		PreparedStatement stat = con.prepareStatement(delEmp);
		stat.setInt(1, empID);
		stat.executeUpdate();
		System.out.println("");
		System.out.println("Employee Number " + empID + " deleted");	
		con.close();
		stat.close();
	}
	
	/**
	 * show database method to display all of the employee information contained in the system
	 * @throws SQLException
	 */
	public static void showDB() throws SQLException
	{
		Connection con = DBconnect.getConnection();
		Statement stat = con.createStatement();
		String table = "App.Employees_T";
		ResultSet rs = stat.executeQuery("SELECT * FROM " + table);
		PrintDB.printResultSet(rs);
		con.close();
		rs.close();
		stat.close();
	}
	
	/**
	 * computes the paycheck for each employee based on the employee ID inputed by the user
	 * @throws SQLException
	 */
	public static void computePay() throws SQLException
	{
		System.out.print("\n");
		System.out.print("Employee ID: ");
		empID = in.nextInt();
		
		Connection con = DBconnect.getConnection();
		Statement stat = con.createStatement();
		Statement stat2 = con.createStatement();
		Statement stat3 = con.createStatement();
		Statement stat4 = con.createStatement();
		
		double pay = 0;
		double health = 0;
		double tax = 0;
		String first;
		String last;
		
		ResultSet result = stat.executeQuery("SELECT * FROM App.Employees_T WHERE ID =" + empID);
		while(result.next())
		{
			first = result.getString("EFirst");
			last = result.getString("ELast");
			
			int type = result.getInt("EmployeeType");
			ResultSet result2 = stat2.executeQuery("SELECT * FROM App.Payment_T WHERE EmployeeType=" +type);
			while(result2.next())
			{
				pay = result2.getDouble("EmployeePay");	
			}
			
			int type2 = result.getInt("PlanNumber");
			ResultSet result3 = stat3.executeQuery("SELECT * FROM App.Health_T WHERE PlanNumber=" +type2);
			while(result3.next())
			{
				health = result3.getDouble("PlanCost");	
			}
			
			int type3 = result.getInt("TaxRankNumber");
			ResultSet result4 = stat4.executeQuery("SELECT * FROM App.Tax_T WHERE TaxRankNumber=" +type3);
			while(result4.next())
			{
				tax = result4.getDouble("TaxRate");	
			}
			
		double grossPay = pay;	
		double afterH = grossPay - health;
		double tax1 = (afterH * tax);
		double netPay = afterH - tax1;
		
		System.out.print("\n");
		System.out.println("Paycheck for " + last + " " + first);
		System.out.printf("Gross Pay: $%.2f\n", grossPay);
		System.out.printf("Health:    ($%.2f)\n", health);
		System.out.printf("Tax:       ($%.2f)\n", tax1);
		System.out.printf("Net Pay:   $%.2f\n", netPay);

	    }
	}

}

