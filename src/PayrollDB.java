import java.sql.*;
import java.io.*;

/**
 * PayrollDB Class that will build the Payroll database using
 * the provide SQL code. It will drop any information created previously
 * in order to avoid errors.
 * @author Pritam Shyam, Ty Ash, Nathaniel Burger, Reinaldy Lamdjani
 */
public class PayrollDB  extends StringsDB
{
	/**
	 * This will initiliaze the databse by adding tables and inserting values.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void initiliaze() throws SQLException, ClassNotFoundException, IOException
	{
		Connection con = DBconnect.getConnection();
		Statement stat = con.createStatement();
		
		try
		{
				try
				{
					stat.execute(Drop4);
					stat.execute(Drop3);
					stat.execute(Drop2);
					stat.execute(Drop1);
				}
				catch (SQLException error)
				{
					System.out.println("Error: "+ error.getMessage());
				}
			
			stat.execute(Payment);
			stat.execute(Health);
			stat.execute(Tax);
			stat.execute(Employees);
			
			stat.execute(addP1);
			stat.execute(addP2);
			stat.execute(addP3);
			
			stat.execute(addH1);
			stat.execute(addH2);
			stat.execute(addH3);
			
			stat.execute(addT1);
			stat.execute(addT2);
			stat.execute(addT3);
			
			stat.execute(addE1);
			stat.execute(addE2);
			stat.execute(addE3);
		}
		finally
		{
			con.close();
			stat.close();
		}
	}
}
