import java.util.Scanner;

/**
 * Main class for the Dbas lab 1
 * 
 * @author Johan Sandmark, Jesper Norman
 * 
 */
public class mainKitchen {

	public static void main(String[] args) {
<<<<<<< HEAD
		Scanner scanner = new Scanner(System.in);
		Database db = new Database();

		int menuOption;
		boolean running = true;
		while (running) {
			printMenu();
			System.out.println("> ");
			menuOption = stringToInt(scanner.nextLine());

			switch (menuOption) {
			case -1:
				System.out.println("Please enter a valid option");
				break;

			case 1:
				addIngredients();
				break;

			case 2:
				deleteIngredients();
				break;

			case 3:
				updateIngredients();
				break;

			case 4:
				showRecepies();
				break;

			// quit
			case 5:
				running = false;
				break;
			}

		}
		scanner.close();
	}

	/**
  * 
  */
	private static void printMenu() {
		System.out.println("Kitchen menu: ");
		System.out.println("1: add ingredients");
		System.out.println("2: delete ingredients");
		System.out.println("3: update ingredients");
		System.out.println("4: show recepies");
		System.out.println("5: Exit");
	}

	/**
  * 
  */
	private static void addIngredients() {
		// case troligen
	}

	/**
  * 
  */
	private static void deleteIngredients() {
		// case troligen
	}

	/**
  * 
  */
	private static void updateIngredients() {
		// case troligen
	}

	/**
  * 
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
=======
		System.out.println("Hello world!");
		
		Scanner scanner = new Scanner(System.in);
			
		
		boolean running = true;
		while(running){
			int menuOption = stringToInt(scanner.nextLine());			
		}
>>>>>>> refs/remotes/origin/master
	}
	
	
	/**
	  * Converts a string to an int if possible.
	  * 
	  * @param s String to convert.
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
