import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * Main class that includes all functionality of the system.
 * The functionality includes initialization and connecting to the database,
 * adding employees, editting employees, deleting employees, showing employees,
 * computation of payroll, and last, closing the program.
 * @author Pritam Shyam, Ty Ash, Nathaniel Burger, Reinaldy Lamdjani
 */
public class Menu
{
	/**
	 * This is the main method that displays menu options and asks for user input
	 * @param args main method
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void  main(String[] args) throws ClassNotFoundException, IOException, SQLException
	{
		/**
		 * Create a connection with the Payroll Database
		 */
		DBconnect.init(args[0]);
		PayrollDB ablsDB = new PayrollDB();
		boolean MenuDone = false;
		Scanner input = new Scanner(System.in);
		
		/**
		 * These are the options displayed by the main method for user input.
		 */
		while(!MenuDone)
		{
			try
			{
				System.out.println("_________________________");
				System.out.println("PAYROLL SYSTEM MENU: ABLS");
				System.out.println("");
				System.out.println("A. Create PayrollDB");
				System.out.println("B. Add Employee");
				System.out.println("C. Edit Employee");
				System.out.println("D. Delete Employee");
				System.out.println("E. Show Employees");
				System.out.println("F. Compute Payroll");
				System.out.println("G. Quit Program");
				System.out.println("");
				System.out.print("Option: ");
				
				String userIn = input.nextLine().toUpperCase();
				if(userIn.equals("A"))
				{
					ablsDB.initiliaze();
					System.out.println("");
					Connection con = DBconnect.getConnection();
					Statement stat = con.createStatement();
					String table = "App.Employees_T";
					ResultSet rs = stat.executeQuery("SELECT * FROM " + table);
					PrintDB.printResultSet(rs);
					con.close();
					rs.close();
					stat.close();
				}
				if(userIn.equals("B"))
				{
					Options.addEmp();
				}
				if(userIn.equals("C"))
				{
					Options.editEmp();
				}
				if(userIn.equals("D"))
				{
					Options.deleteEmp();
				}
				if(userIn.equals("E"))
				{
					Options.showDB();
				}
				if(userIn.equals("F"))
				{
					Options.computePay();
				}
				if(userIn.equals("G"))
				{
					MenuDone = true;
					System.out.println("Payroll program ended");
					input.close();
				}
			}
			finally
			{
				//Nothing neeed here.
			}
		}
	
	}	
}
