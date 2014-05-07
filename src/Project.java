package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;  // for standard JDBC programs
import java.sql.Statement;
import java.util.Scanner;

public class Project {

	final static String BUS_SERVICE_NAME = "SADJ Bus Service";
	static Scanner in = new Scanner(System.in);
	static Connection conn = null;

	public static void main(String[] args) {
//		boolean isGuest;
		String URL = "jdbc:mysql://localhost/323project";
		String USER = "root";
		String PASS = "";

		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Create Connection Object
			conn = DriverManager.getConnection(URL, USER, PASS);
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error: unable to establish db connection!");
			System.exit(1);
		}


		// Print menu
		printHeader();
		// isGuest = printLogin();

		int option;
		do {
			printMenu();
			option = getMenuOption();
			parseOption(option);
		} while (option != 0);



		// Close Connection to DB when done
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		printExitMsg();
	}


	static void printHeader() {
		System.out.println("Welcome to " + BUS_SERVICE_NAME + "!");
	}

	static void printExitMsg() {
		System.out.println("Thank you for choosing " + BUS_SERVICE_NAME + "! Good-bye!");
	}

	static boolean printLogin() {
		System.out.println("GUESTS, leave username blank (just press enter).");
		System.out.print("Username: ");
		String username = in.nextLine();

		return username.isEmpty();
	}

	static int getMenuOption() {
		System.out.print("Please select an option: ");

		String line = in.nextLine();
		int option;
		try {
			option = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.out.println("Invalid option");
			option= -1;
		}

		return option;
	}

	static void printMenu() {
			System.out.println("GUEST options");
			System.out.println("\t1.  List all routes");
			System.out.println("\t2.  List passport routes");
			System.out.println("\t3.  Get directions from stop A to stop B (without bus transfer)");
			System.out.println("\t4.  Get directions from stop A to stop B (with 1 bus transfer)");
			System.out.println("\t5.  Get stops on route (between stop A and B)");
			System.out.println("\t6.  Get arrival times for stop");
			System.out.println("\nADMIN options");
			System.out.println("\t7.  List all the data for a given route");
			System.out.println("\t8.  List of all the bus drivers");
			System.out.println("\t9.  List of all the stops");
			System.out.println("\t10. List of the service reports");
			System.out.println("\t11. Assign stop to route");
			System.out.println("\t12. Unassign stop to route");
			System.out.println("\t13. Assign bus/driver to route");
			System.out.println("\t14. Unassign bus/driver to route");
			System.out.println("\t15. Create new bus stop");
			System.out.println("\t16. Create new route");
			System.out.println("\t17. Update stop");
			System.out.println("\t18. Update route");
			System.out.println("\t19. Delete stop");
			System.out.println("\t20. Delete route");
			System.out.println("\t0.  Exit Program");
	}

	static void confirm() {
		System.out.println("Press ENTER to continue...");
		in.nextLine();
	}

	static void parseOption(int option) {
		switch (option) {
			case 0:  System.out.println("OPTION = case 0: ");break;
			case 1:  listRoutes();break;
			case 2:  listPassportRoutes();break;
			case 3:  getDirection();break;
			case 4:  System.out.println("OPTION = case 4: ");break;
			case 5:  System.out.println("OPTION = case 5: ");break;
			case 6:  listArrivalTimes();break;
			case 7:  listRouteData();break;
			case 8:  listDrivers();break;
			case 9:  listStops();break;
			case 10: listServiceReports();break;
			case 11: createArriveTime();break;
			case 12: deleteArrivalTimes();break;
			case 13: createBusAssign();break;
			case 14: deleteBusAssign();break;
			case 15: createStop();break;
			case 16: createRoute();break;
			case 17: updateStop();break;
			case 18: updateRoute();break;
			case 19: deleteStop();break;
			case 20: deleteRoute();break;
			default: System.out.println("OPTION = default:");break;
		}
		confirm();
	}

	// Guest Functions
	static void listRoutes() {
		System.out.println("Querying routes...");
		try {
			Statement stmt   = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM route");
					
			if(result.isBeforeFirst())
			{
				int n = 0;
				System.out.format("  #  %3s%12s\n", "Num", "Direction");
				while(result.next()) {
					int routeNum = result.getInt("routeNum");
					String direction = result.getString("direction");
					System.out.format("%3d: %3d%12s\n", ++n, routeNum, direction);
				}
			}
			else
				System.out.println("0 rows returned");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	static void listPassportRoutes() {
		System.out.println("Querying passport routes...");
		try {
			Statement stmt   = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM route WHERE isPassport = TRUE");

			if(result.isBeforeFirst())
			{
				int n = 0;
				System.out.format("  #  %3s%12s\n", "Num", "Direction");
				while(result.next()) {
					int routeNum = result.getInt("routeNum");
					String direction = result.getString("direction");
					System.out.format("%3d: %3d%12s\n", ++n, routeNum, direction);
				}
			}
			else
				System.out.println("0 rows returned");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	static void listArrivalTimes() {
		System.out.print("Enter stop number: ");
		int targetStopNum = in.nextInt();
		in.nextLine();
		System.out.println("Querying arrival time data...");
		try {
			Statement stmt   = conn.createStatement();
			ResultSet result = stmt.executeQuery(String.format("SELECT routeNum, time FROM arriveTime WHERE stopNum = '%d' ORDER BY time", targetStopNum));

			if(result.isBeforeFirst())
			{
				int n = 0;
				System.out.format("  #  %5s%9s\n", "Route", "Time");
				while(result.next()) {
					int routeNum = result.getInt("routeNum");
					String time = result.getString("time");
					System.out.format("%3d: %5d%9s\n", ++n, routeNum, time);
				}
			}
			else
				System.out.println("0 rows returned");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	static void getDirection() {
		System.out.print("Enter starting stop number: ");
		int startStopNum = in.nextInt();
		in.nextLine();
		System.out.print("Enter ending stop number: ");
		int endStopNum = in.nextInt();
		in.nextLine();

		if (startStopNum == endStopNum)
		{
			System.out.println("Error: End and start stops are the same");
			return;
		}

		System.out.println("Querying direction...");
		try {
			Statement stmt   = conn.createStatement();
			ResultSet result = stmt.executeQuery(String.format("SELECT t1.routeNum FROM  (SELECT * FROM arrivetime WHERE stopnum='%d') as t1 INNER JOIN (SELECT * FROM arrivetime WHERE stopnum='%d') as t2 ON t1.routeNum=t2.routeNum", startStopNum, endStopNum));

			if(result.isBeforeFirst())
			{
				int n = 0;
				System.out.format("  #  %4s\n", "Route");
				while(result.next()) {
					int routeNum = result.getInt("routeNum");
					System.out.format("%3d: %4d\n", ++n, routeNum);
				}
			}
			else
				System.out.println("0 rows returned");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	// Admin Functions
	static void listRouteData() {
		System.out.print("Enter route number: ");
		int targetRouteNum = in.nextInt();
		in.nextLine();
		System.out.println("Querying route data...");
		try {
			Statement stmt   = conn.createStatement();
			ResultSet result = stmt.executeQuery(String.format("SELECT DISTINCT stopNum FROM arriveTime WHERE routeNum = '%d'", targetRouteNum));

			if(result.isBeforeFirst())
			{
				int n = 0;
				System.out.format("  #  %4s\n", "Stop");
				while(result.next()) {
					int stopNum = result.getInt("stopNum");
					System.out.format("%3d: %4d\n", ++n, stopNum);
				}
			}
			else
				System.out.println("0 rows returned");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	static void listDrivers() {
		System.out.println("Querying drivers...");
		try {
			Statement stmt   = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM driver");

			if(result.isBeforeFirst())
			{
				int n = 0;
				System.out.format("  #  %8s%22s%4s%11s%33s\n", "License", "Name", "Age", "Qualified", "Address");
				while(result.next()) {
					String driverLicense = result.getString("driverLicense");
					String name = result.getString("name");
					int age = result.getInt("age");
					String address = result.getString("address");
					String lastQTest = result.getString("lastQTest");
					System.out.format("%3d: %8s%22s%4d%11s%33s\n", ++n, driverLicense, name, age, lastQTest, address);
				}
			}
			else
				System.out.println("0 rows returned");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	static void listStops() {
		System.out.println("Querying stops...");
		try {
			Statement stmt   = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM stop");

			if(result.isBeforeFirst())
			{
				int n = 0;
				System.out.format("  #  %3s%33s\n", "Num", "Cross-Streets");
				while(result.next()) {
					int stopNum = result.getInt("stopNum");
					String crossStreets = result.getString("crossStreets");
					System.out.format("%3d: %3d%33s\n", ++n, stopNum, crossStreets);
				}
			}
			else
				System.out.println("0 rows returned");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	static void listServiceReports() {
		System.out.println("Querying service reports...");
		try {
			Statement stmt   = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM servicereport");

			if(result.isBeforeFirst())
			{
				int n = 0;
				System.out.format("  #  %8s%22s%10s\n", "License", "Date/Time", "Status");
				while(result.next()) {
					String license = result.getString("driverLicense");
					String dateTime = result.getString("dateTime");
					String status = result.getString("reportType");
					String description = result.getString("description");
					System.out.format("%3d: %8s%22s%10s\n", ++n, license, dateTime, status);
					System.out.format("      - %s\n", description);
				}
			}
			else
				System.out.println("0 rows returned");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	static void createArriveTime()
	{
		System.out.print("Stop Number: ");
		int stopNum = in.nextInt();
		in.nextLine();
		System.out.print("Route Number: ");
		int routeNum = in.nextInt();
		in.nextLine();
		System.out.print("Time (hh:mm): ");
		String time = in.nextLine();

		try {
			Statement stmt   = conn.createStatement();
			int numRows = stmt.executeUpdate(String.format("INSERT INTO arrivetime VALUES ('%d', '%d', '%s')", routeNum, stopNum, time));

			if(numRows > 0)
				System.out.println("Success: Assigned stop to route");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	static void deleteArrivalTimes()
	{
	}
	static void createBusAssign()
	{
		System.out.print("Driver License: ");
		String driverLicense = in.nextLine();
		System.out.print("License Plate: ");
		String licensePlate = in.nextLine();
		System.out.print("Route Number: ");
		int routeNum = in.nextInt();
		in.nextLine();
		System.out.print("Last Maintenance Date (yyyy-mm-dd): ");
		String lastMain = in.nextLine();

		try {
			Statement stmt   = conn.createStatement();
			int numRows = stmt.executeUpdate(String.format("INSERT INTO busassign VALUES ('%s', '%s', '%d', '%s')", driverLicense, licensePlate, routeNum, lastMain));

			if(numRows > 0)
				System.out.println("Success: Assigned bus/driver to route");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	static void deleteBusAssign()
	{
		System.out.print("Driver License: ");
		String driverLicense = in.nextLine();
		System.out.print("License Plate: ");
		String licensePlate = in.nextLine();
		System.out.print("Route Number: ");
		int routeNum = in.nextInt();
		in.nextLine();

		try {
			Statement stmt   = conn.createStatement();
			int numRows = stmt.executeUpdate(String.format("DELETE FROM busassign WHERE driverLicense = '%s' and licensePlate = '%s' and routeNum = %d", driverLicense, licensePlate, routeNum));

			if(numRows > 0)
				System.out.println("Success: Bus assignment deleted");
			else
				System.out.println("Error: A bus assignment does not exist with those parameters");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
			System.out.println("Error: The bus assignment is referenced by another item in the database");
		}
	}
	static void createStop()
	{
		System.out.print("Stop Number: ");
		int stopNum = in.nextInt();
		in.nextLine();
		System.out.print("Cross Streets: ");
		String crossStreets = in.nextLine();

		try {
			Statement stmt   = conn.createStatement();
			int numRows = stmt.executeUpdate(String.format("INSERT INTO stop VALUES ('%d', '%s')", stopNum, crossStreets));

			if(numRows > 0)
				System.out.println("Success: Stop created");
		}
		catch (SQLException e) {
			System.out.println("Error: A stop already exists with that stop number");
		}
	}
	static void createRoute()
	{
		System.out.print("Route Number: ");
		int routeNum = in.nextInt();
		in.nextLine();
		System.out.print("Direction (NS or WE): ");
		String direction = in.nextLine();
		if(direction.compareTo("NS") == 0)
			direction = "north/south";
		else if(direction.compareTo("WE") == 0)
			direction = "west/east";
		else
		{
			System.out.println("Error: Invalid direction");
			return;
		}

		try {
			Statement stmt   = conn.createStatement();
			int numRows = stmt.executeUpdate(String.format("INSERT INTO route VALUES ('%s', '%d')", direction, routeNum));

			if(numRows > 0)
				System.out.println("Success: Route created");
		}
		catch (SQLException e) {
			System.out.println("Error: A route already exists with that route number");
		}
	}
	static void updateStop()
	{
		System.out.print("Stop Number: ");
		int stopNum = in.nextInt();
		in.nextLine();
		System.out.print("Cross Streets: ");
		String crossStreets = in.nextLine();

		try {
			Statement stmt   = conn.createStatement();
			int numRows = stmt.executeUpdate(String.format("UPDATE stop SET crossStreets = '%s' WHERE stopNum=%s", crossStreets, stopNum));

			if(numRows > 0)
				System.out.println("Success: Stop updated");
			else
				System.out.println("Error: A stop does not exist with that stop number");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	static void updateRoute()
	{
		System.out.print("Route Number: ");
		int routeNum = in.nextInt();
		in.nextLine();
		System.out.print("Direction (NS or WE): ");
		String direction = in.nextLine();
		if(direction.compareTo("NS") == 0)
			direction = "north/south";
		else if(direction.compareTo("WE") == 0)
			direction = "west/east";
		else
		{
			System.out.println("Error: Invalid direction");
			return;
		}

		try {
			Statement stmt   = conn.createStatement();
			int numRows = stmt.executeUpdate(String.format("UPDATE route SET direction = '%s' WHERE routeNum = %d", direction, routeNum));

			if(numRows > 0)
				System.out.println("Success: Route updated");
			else
				System.out.println("Error: A route does not exist with that route number");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	static void deleteStop()
	{
		System.out.print("Stop Number: ");
		int stopNum = in.nextInt();
		in.nextLine();

		try {
			Statement stmt   = conn.createStatement();
			int numRows = stmt.executeUpdate(String.format("DELETE FROM stop WHERE stopNum = %d", stopNum));

			if(numRows > 0)
				System.out.println("Success: Stop deleted");
			else
				System.out.println("Error: A stop does not exist with that stop number");
		}
		catch (SQLException e) {
			System.out.println("Error: The stop is referenced by another item in the database");
		}
	}
	static void deleteRoute()
	{
		System.out.print("Route Number: ");
		int routeNum = in.nextInt();
		in.nextLine();

		try {
			Statement stmt   = conn.createStatement();
			int numRows = stmt.executeUpdate(String.format("DELETE FROM route WHERE routeNum = %d", routeNum));

			if(numRows > 0)
				System.out.println("Success: Route deleted");
			else
				System.out.println("Error: A route does not exist with that route number");
		}
		catch (SQLException e) {
			System.out.println("Error: The route is referenced by another item in the database");
		}
	}
}
