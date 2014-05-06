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
		boolean isGuest;
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
		isGuest = printLogin();

		int option;
		do {
			printMenu(isGuest);
			option = getMenuOption();
			parseOption(option, isGuest);
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

	static void printMenu(boolean isGuest) {
		if (isGuest) {
			System.out.println("GUEST menu");
			System.out.println("\t1. List all routes");
			System.out.println("\t2. List passport routes");
			System.out.println("\t3. Get direction from stop A to stop B (without bus transfer)");
			System.out.println("\t4. Get direction from stop A to stop B (with 1 bus transfer)");
			System.out.println("\t5. Get stops on route (between stop A and B)");
			System.out.println("\t6. Get arrival time for stop");
			System.out.println("\t0. Exit Program");
		}
		else {
			System.out.println("ADMIN menu");
			System.out.println("\t0.  Exit Program");
			System.out.println("\t1.  List all the data for a given route");
			System.out.println("\t2.  List of all the bus drivers");
			System.out.println("\t3.  List of all the stops");
			System.out.println("\t4.  List of the service reports");
			System.out.println("\t5.  Assign stop to route");
			System.out.println("\t6.  Assign driver to route");
			System.out.println("\t7.  Assign bus to route");
			System.out.println("\t8.  Create new bus stop");
			System.out.println("\t9.  Create new route");
			System.out.println("\t10. Update stop");
			System.out.println("\t11. Update route");
			System.out.println("\t12. Delete stop");
			System.out.println("\t13. Delete route");
		}
	}

	static void parseOption(int option, boolean isGuest) {
		if (isGuest) {
			switch (option) {
				case 0:  System.out.println("OPTION = case 0: ");break;
				case 1:  listRoutes();break;
				case 2:  System.out.println("OPTION = case 2: ");break;
				case 3:  System.out.println("OPTION = case 3: ");break;
				case 4:  System.out.println("OPTION = case 4: ");break;
				case 5:  System.out.println("OPTION = case 5: ");break;
				case 6:  System.out.println("OPTION = case 6: ");break;
				default: System.out.println("OPTION = default:");break;
			}
		} else {
			switch (option) {
				case 0:  System.out.println("OPTION = case 0: ");break;
				case 1:  System.out.println("OPTION = case 1: ");break;
				case 2:  System.out.println("OPTION = case 2: ");break;
				case 3:  System.out.println("OPTION = case 3: ");break;
				case 4:  System.out.println("OPTION = case 4: ");break;
				case 5:  System.out.println("OPTION = case 5: ");break;
				case 6:  System.out.println("OPTION = case 6: ");break;
				case 7:  System.out.println("OPTION = case 7: ");break;
				case 8:  System.out.println("OPTION = case 8: ");break;
				case 9:  System.out.println("OPTION = case 9: ");break;
				case 10: System.out.println("OPTION = case 10:");break;
				case 11: System.out.println("OPTION = case 11:");break;
				case 12: System.out.println("OPTION = case 12:");break;
				case 13: System.out.println("OPTION = case 13:");break;
				default: System.out.println("OPTION = default:");break;
			}
		}
	}

	// Guest Functions
	static void listRoutes() {
		try {
			Statement stmt   = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM route");

			while(result.next()) {
				int routeNum = result.getInt("routeNum");
				String direction = result.getString("direction");
				System.out.println("Route " + routeNum + " (" + direction + ")");
			}
		}
		catch (SQLException e) {
			System.out.println(e.toString());
		}

	}
}
