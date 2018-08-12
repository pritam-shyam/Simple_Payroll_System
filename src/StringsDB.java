/**
 * StringDB class to hold SQL statements that are called in other classes.
 * SQL Statements include dropping tables, creating tables, insert into, alter
 * and update.
 * @author Pritam Shyam, Ty Ash, Nathaniel Burger, Reinaldy Lamdjani
 */
public class StringsDB 
{
	/**
	 * strings to drop tables during intialization
	 */
	public static String Drop1 = "DROP TABLE App.Payment_T";
	public static String Drop2 = "DROP TABLE App.Health_T";
	public static String Drop3 = "DROP TABLE App.Tax_T";
	public static String Drop4 = "DROP TABLE App.Employees_T";
	
	/**
	 * string to create Payment Table
	 */
	public static String Payment = "CREATE TABLE App.Payment_T"
			+ "("
			+ "EmployeeType INT,"
			+ "EmployeeDescription VARCHAR(50),"
			+ "EmployeePay DOUBLE,"
			+ "CONSTRAINT Payment_PK PRIMARY KEY (EmployeeType)"
			+ ")";
	
	/**
	 * string to create Health Plan Table
	 */
	public static String Health = "CREATE TABLE App.Health_T"
			+ "("
			+ "PlanNumber INT,"
			+ "PlanName VARCHAR(50),"
			+ "PlanDescription VARCHAR(100),"
			+ "PlanCost DOUBLE,"
			+ "CONSTRAINT Health_PK PRIMARY KEY (PlanNumber)"
			+ ")";
	
	/**
	 * string to create Tax Table	
	 */
	public static String Tax = "CREATE TABLE App.Tax_T"
			+ "("
			+ "TaxRankNumber INT,"
			+ "RankDescription VARCHAR(50),"
			+ "SalaryMin DOUBLE,"
			+ "SalaryMax DOUBLE,"
			+ "TaxRate DOUBLE,"
			+ "CONSTRAINT Tax_PK PRIMARY KEY (TaxRankNumber)"
			+ ")";
	
	/**
	 * string to create Employees Table
	 */
	public static String Employees = "CREATE TABLE App.Employees_T"
			+ "("
			+ "ID INT,"
			+ "EFirst VARCHAR(20),"
			+ "ELast VARCHAR(20),"
			+ "Address VARCHAR(20),"
			+ "City VARCHAR(20),"
			+ "State VARCHAR(10),"
			+ "ZipCode VARCHAR(10),"
			+ "Age INT,"
			+ "Gender VARCHAR(5),"
			+ "MaritalStatus VARCHAR(10),"
			+ "SocialSecurityNum VARCHAR(10),"
			+ "EmployeeType INT,"
			+ "PlanNumber INT,"
			+ "TaxRankNumber INT,"
			+ "CONSTRAINT Employees_PK PRIMARY KEY (ID),"
			+ "CONSTRAINT Employees_FK1 FOREIGN KEY (PlanNumber)"
				+ "REFERENCES Health_T (PlanNumber),"
			+ "CONSTRAINT Employees_FK2 FOREIGN KEY (TaxRankNumber)"
				+ "REFERENCES Tax_T (TaxRankNumber),"
			+ "CONSTRAINT Employees_FK3 FOREIGN KEY (EmployeeType)"
				+ "REFERENCES Payment_T (EmployeeType)"
			+ ")";
	
	/**
	 * strings to insert information into Payment Table
	 */
	public static String addP1  = "INSERT INTO APP.PAYMENT_T (EmployeeType, EmployeeDescription, EmployeePay)"
			+ "VALUES (1, 'Low Salary Employee', 40000)";
	public static String addP2 = "INSERT INTO APP.PAYMENT_T (EmployeeType, EmployeeDescription, EmployeePay)"
			+ "VALUES (2, 'Mid Salary Employee', 80000)";
	public static String addP3 = "INSERT INTO APP.PAYMENT_T (EmployeeType, EmployeeDescription, EmployeePay)"
			+ "VALUES (3, 'High Salary Employee', 120000)";
	
	/**
	 * strings to insert information into the Health Table
	 */
	public static String addH1 = "INSERT INTO APP.Health_T (PlanNumber, PlanName, PlanDescription, PlanCost)"
			+ "VALUES (1, 'Basic Health', 'Health plan including doctor visits and emergency appointments or surgerys', 150)";
	public static String addH2 = "INSERT INTO APP.Health_T (PlanNumber, PlanName, PlanDescription, PlanCost)"
			+ "VALUES (2, 'Benefit Health', 'Health plan including doctor visits and emergency appointments or surgerys', 250)";
	public static String addH3 = "INSERT INTO APP.Health_T (PlanNumber, PlanName, PlanDescription, PlanCost)"
			+ "VALUES (3, 'Premium Health', 'Health plan including doctor visits and emergency appointments or surgerys', 350)";
	
	/**
	 * strings to insert information into the Tax Table
	 */
	public static String addT1 = "INSERT INTO APP.Tax_T (TaxRankNumber, RankDescription, SalaryMin, SalaryMax, TaxRate)"
			+ "VALUES (1, 'Low Bracket', 0, 40000, .1200)";
	public static String addT2 = "INSERT INTO APP.Tax_T (TaxRankNumber, RankDescription, SalaryMin, SalaryMax, TaxRate)"
			+ "VALUES (2, 'Mid Bracket', 0, 80000, .1400)";
	public static String addT3 = "INSERT INTO APP.Tax_T (TaxRankNumber, RankDescription, SalaryMin, SalaryMax, TaxRate)"
			+ "VALUES (3, 'High Bracket', 0, 120000, .1600)";
	
	/**
	 * strings to insert information into the Employees Table	
	 */
	public static String addE1 = "INSERT INTO APP.Employees_T (ID, EFirst, ELast, Address, City, State, ZipCode, Age, Gender, MaritalStatus, SocialSecurityNum, EmployeeType, PlanNumber, TaxRankNumber)"
			+ "VALUES (001, 'Timothy', 'Ash', '123 Ash', 'Ames', 'IA', '50021', 20,'M', 'Single', '195395829', 1, 1, 1)";
	public static String addE2 = "INSERT INTO APP.Employees_T (ID, EFirst, ELast, Address, City, State, ZipCode, Age, Gender, MaritalStatus, SocialSecurityNum, EmployeeType, PlanNumber, TaxRankNumber)"
			+ "VALUES (002, 'Burger', 'Nathaniel', '456 Nate', 'Ames', 'IA', '50010', 21,'M', 'Single', '593750248', 2, 2, 2)";
	public static String addE3 = "INSERT INTO APP.Employees_T (ID, EFirst, ELast, Address, City, State, ZipCode, Age, Gender, MaritalStatus, SocialSecurityNum, EmployeeType, PlanNumber, TaxRankNumber)"
			+ "VALUES (003, 'Lamdjani', 'Reinaldy', '789 Rein', 'Ames', 'IA', '50011', 22,'M', 'Single', '946295827', 3, 3, 3)";
	
	/**
	 * variables used for options class
	 */
	protected static int empID;
	protected static String firstN;
	protected static String lastN;
	protected static String address;
	protected static String city;
	protected static String state;
	protected static String zip;
	protected static int age;
	protected static String gender;
	protected static String marital;
	protected static String ssn;
	protected static int type;
	protected static int plan;
	protected static int tax;
	
	static String addEmp = "INSERT INTO APP.Employees_T (ID, EFirst, ELast, Address, City, State, ZipCode, Age, Gender, MaritalStatus, SocialSecurityNum, EmployeeType, PlanNumber, TaxRankNumber)"
		  + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	static String delEmp = "DELETE FROM APP.Employees_T WHERE ID = ?";
	
	static String computePay = "SELECT e.ID, e.EFirst, e.ELast, e.EmployeeType, p.EmployeePay AS GrossPay, (t.TaxRate + h.PlanCost) AS Deductions, (p.EmployeePay - (t.TaxRate + h.PlanCost)) AS NetPay"
			+ "FROM APP.Employees_T e, APP.Payment_T p, APP.Health_T h, APP.Tax_T t"
			+ "WHERE e.EmployeeType = p.EmployeeType AND e.PlanNumber = h.PlanNumber AND e.TaxRankNumber = t.TaxRankNumber AND e.ID = 1";
	
}