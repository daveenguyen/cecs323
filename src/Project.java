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
			System.out.println("\t3.  Get direction from stop A to stop B (without bus transfer)");
			System.out.println("\t4.  Get direction from stop A to stop B (with 1 bus transfer)");
			System.out.println("\t5.  Get stops on route (between stop A and B)");
			System.out.println("\t6.  Get arrival time for stop");
			System.out.println("\nADMIN options");
			System.out.println("\t7.  List all the data for a given route");
			System.out.println("\t8.  List of all the bus drivers");
			System.out.println("\t9.  List of all the stops");
			System.out.println("\t10. List of the service reports");
			System.out.println("\t11. Assign stop to route");
			System.out.println("\t12. Assign driver to route");
			System.out.println("\t13. Assign bus to route");
			System.out.println("\t14. Create new bus stop");
			System.out.println("\t15. Create new route");
			System.out.println("\t16. Update stop");
			System.out.println("\t17. Update route");
			System.out.println("\t18. Delete stop");
			System.out.println("\t19. Delete route");
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
			case 2:  System.out.println("OPTION = case 2: ");break;
			case 3:  System.out.println("OPTION = case 3: ");break;
			case 4:  System.out.println("OPTION = case 4: ");break;
			case 5:  System.out.println("OPTION = case 5: ");break;
			case 6:  System.out.println("OPTION = case 6: ");break;
			case 7:  System.out.println("OPTION = case 7: ");break;
			case 8:  listDrivers();break;
			case 9:  listStops();break;
			case 10: System.out.println("OPTION = case 10:");break;
			case 11: System.out.println("OPTION = case 11:");break;
			case 12: System.out.println("OPTION = case 12:");break;
			case 13: System.out.println("OPTION = case 13:");break;
			case 14: System.out.println("OPTION = case 14:");break;
			case 15: System.out.println("OPTION = case 15:");break;
			case 16: System.out.println("OPTION = case 16:");break;
			case 17: System.out.println("OPTION = case 17:");break;
			case 18: System.out.println("OPTION = case 18:");break;
			case 19: System.out.println("OPTION = case 19:");break;
			default: System.out.println("OPTION = default:");break;
		}
		confirm();
	}

	// Guest Functions
	static void listRoutes() {
		try {
			Statement stmt   = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM route");

			if(result.isBeforeFirst())
				while(result.next()) {
					int routeNum = result.getInt("routeNum");
					String direction = result.getString("direction");
					System.out.println("Route " + routeNum + " (" + direction + ")");
				}
			else
				System.out.println("0 rows returned.");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	// Admin Functions
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
				System.out.println("0 rows returned.");
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
				System.out.format("  #  %3s%33s%25s\n", "Num", "Cross-Streets", "Place");
				while(result.next()) {
					int stopNum = result.getInt("stopNum");
					String crossStreets = result.getString("crossStreets");
					String place = result.getString("place");
					System.out.format("%3d: %3d%33s%25s\n", ++n, stopNum, crossStreets, place);
				}
			}
			else
				System.out.println("0 rows returned.");
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
}
