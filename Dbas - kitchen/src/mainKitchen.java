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
				recipiesMain();
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
				System.out.println(db.getIngredientsInStock());
				break;

			case 3:
				System.out.println("Let the user increase the stock of ingredient");
				break;

			case 4:
				System.out.println("Let the user decrease the stock of ingredient");
				break;

			case 5:
				System.out.println("Let the user add ingredient");
				addIngredient();
				break;

			case 6:
				System.out.println("Let the user delete ingredient");
				deleteIngredients();
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
	 * Method to print the main recipies menu to sys out
	 */
	private static void printMenuRecipiesMain() {
		System.out.println("");
		System.out.println("Recipies menu: ");
		System.out.println("1: Show all recipies");
		System.out.println("2: Show all recipies with ingredients in stock");
		System.out.println("3: Show all recipies with ingredients possibly in stock");
		System.out.println("4: Back");
	}

	/**
	 * Method to run when the user is in the main recipies menu
	 * 
	 * @throws SQLException
	 */
	private static void recipiesMain() throws SQLException {

		int menuOption;
		boolean runningRecipiesMain = true;

		// While the user is in this menu
		while (runningRecipiesMain) {

			// Print menu
			printMenuRecipiesMain();

			// Output > char and wait for user input
			System.out.println("> ");
			menuOption = stringToInt(scanner.nextLine());

			switch (menuOption) {
			case -1:
				System.out.println("Please enter a valid option");
				break;

				// Show all recipies
			case 1:
				System.out.println("User should now se all recipies");
				System.out.println(db.getRecipies());
				break;

			case 2:
				System.out.println("User should now se all recipies with ingredients in stock");
				System.out.println(db.getRecipiesInStock());
				break;

			case 3:
				System.out.println("User should now se all recipies possibly with ingredients in stock");
				break;

			case 4:
				runningRecipiesMain = false;
				break;

			default:
				System.out.println("This menu option is not available, please try again.");
				break;
			}
		}

	}

	/**
	 * Method to add a new ingredient
	 * @throws SQLException 
	 */
	private static void addIngredient() throws SQLException {

		System.out.println("Enter the name of the ingredient:");
		System.out.println("> ");
		String name = scanner.nextLine();

		System.out.println("Enter the current stock of the ingredient:");
		System.out.println("> ");
		int stock = stringToInt(scanner.nextLine());

		db.addIngredient(name, stock);

	}

	/**
	 * Method to delete from ingredient
	 * @throws SQLException 
	 */
	private static void deleteIngredients() throws SQLException {

		System.out.println("Please enter the name of the ingedient that you would like to remove:");
		System.out.println(db.getIngredients());
		System.out.println("> ");
		String name = scanner.nextLine();

		db.removeIngredient(name);

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