import java.sql.SQLException;
import java.util.Scanner;

/**
 * Main class for the Dbas lab 1
 * 
 * @author Johan Sandmark, Jesper Norman
 * 
 */
public class mainKitchen {

	// The scanner for user input
	static Scanner scanner = new Scanner(System.in);

	// The database connection and communication
	static Database db = new Database();

	/**
	 * The main menu is running here
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		// The main menu
		int menuOption;
		boolean running = true;
		while (running) {

			// Output the menu
			printMenu();

			// Output > char and wait for user input
			System.out.println("> ");
			menuOption = stringToInt(scanner.nextLine());

			switch (menuOption) {
			case -1:
				System.out.println("Please enter a valid option");
				break;

			// Ingredients
			case 1:
				ingredientsMain();
				break;

			// Recipies
			case 2:
				// TODO
				break;

			// Exit
			case 3:
				running = false;
				break;

			// If something else was choosen in the menu
			default:
				System.out.println("This menu option is not available, please try again.");
				break;
			}

		}
		// Now the program is going to terminate, close the scanner stream
		scanner.close();
	}

	/**
	 * Method to print the main menu to sys out
	 */
	private static void printMenu() {
		System.out.println("");
		System.out.println("Kitchen main menu: ");
		System.out.println("1: Ingredients");
		System.out.println("2: Recipies");
		System.out.println("3: Exit");
	}

	/**
	 * Method to print the main ingredients menu to sys out
	 */
	private static void printMenuIngredientsMain() {
		System.out.println("");
		System.out.println("Ingredients menu: ");
		System.out.println("1: Show all ingredients");
		System.out.println("2: Show only ingredients in stock");
		System.out.println("3: Increase ingredient");
		System.out.println("4: Decrease ingredient");
		System.out.println("5: Add ingredient");
		System.out.println("6: Delete ingredient");
		System.out.println("7: Back");
	}

	/**
	 * Method to run when the user is in the main ingredients menu
	 * 
	 * @throws SQLException
	 */
	private static void ingredientsMain() throws SQLException {

		int menuOption;
		boolean runningInggredientsMain = true;

		// While the user is in this menu
		while (runningInggredientsMain) {

			// Print menu for ingredients
			printMenuIngredientsMain();

			// Output > char and wait for user input
			System.out.println("> ");
			menuOption = stringToInt(scanner.nextLine());

			switch (menuOption) {
			case -1:
				System.out.println("Please enter a valid option");
				break;

			// Show all ingredients in the system
			case 1:
				System.out.println("User should now se all ingredients (both in stock and empty)");
				System.out.println(db.getIngredients());
				break;

			case 2:
				System.out.println("User should now se all ingredients in stock");

				break;

			case 3:
				System.out.println("Let the user increase the stock of ingredient");
				break;

			case 4:
				System.out.println("Let the user decrease the stock of ingredient");
				break;

			case 5:
				System.out.println("Let the user add ingredient");
				break;

			case 6:
				System.out.println("Let the user delete ingredient");
				break;

			// Exit
			case 7:
				runningInggredientsMain = false;
				break;

			default:
				System.out.println("This menu option is not available, please try again.");
				break;
			}

		}
	}

	/**
	 * Method to update stock of indgredients
	 */
	private static void updateIngredients() {
		// case troligen
	}

	/**
	 * Method to delete from indgredients
	 */
	private static void deleteIngredients() {
		// case troligen
	}

	/**
	 * Show recipies to the user
	 */
	private static void showRecepies() {
		// case troligen
	}

	/**
	 * Converts a string to an int if possible.
	 * 
	 * @param s
	 *            String to convert.
	 * @return Converted value. -1 if not possible to convert.
	 */
	private static int stringToInt(String s) {
		int num;

		try {
			num = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return -1;
		}
		return num;

	}
}