import java.util.Scanner;

/**
 * Main class for the Dbas lab 1
 * @author Johan Sandmark, Jesper Norman
 *
 */

public class mainKitchen {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		
		Scanner scanner = new Scanner(System.in);
			
		
		boolean running = true;
		while(running){
			int menuOption = stringToInt(scanner.nextLine());			
		}
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