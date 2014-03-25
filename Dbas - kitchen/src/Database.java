import java.sql.*;

/**
 * Database This class reads and writes to a database
 * 
 * @author Johan Sandmark
 * @version 140226
 * 
 */
public class Database {

	private boolean DEBUG = false;

	String url;
	String user;
	String passw;
	Statement stmt;

	/**
	 * Default constructor that creates a connection to an MySQL server running
	 * on localhost.
	 */
	public Database() {
		try {
			if (DEBUG) {
				System.out.println("Connecting...");
			}
			Class.forName("com.mysql.jdbc.Driver"); // loading driver

			url = "jdbc:mysql://localhost/kitchen_db";
			user = "root";
			passw = "";
			Connection conn = DriverManager.getConnection(url, user, passw);
			stmt = conn.createStatement();
			if (DEBUG) {
				System.out.println("Connection established!");
			}
		} catch (Exception e) {
			System.err.println("Error: Unable to connect to server");
			throw new RuntimeException("Error: Unable to connect to server ", e);
		}
	}

	/**
	 * Default constructor that creates a connection to the server based on
	 * parameters.
	 */
	public Database(String url, String user, String passw) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // loading driver
			this.url = url;
			this.user = user;
			this.passw = passw;
			Connection conn = DriverManager.getConnection(url, user, passw);
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.err.println("Error: Unable to connect to server");
		}
	}

	/**
	 * Method to get all indigrients
	 * @return The string with ingredientsinfo
	 */
	public String getIngredients() throws SQLException {
		String query = "SELECT * FROM ingredients";

		// Do the query
		ResultSet rs = stmt.executeQuery(query);
		//Create a stringbuilder
		StringBuilder sb = new StringBuilder();

		//The index of the results so we can track them
		int i = 1;

		// Extract data from result set until there is no one left
		while (rs.next()) {

			// Retrieve by column name
			String name = rs.getString("name");
			String stock = rs.getString("stock");

			if(stock == null){
				stock = "unknown amount";
			}

			//Append current tuple to the stringbuilder
			sb.append(i + ": " + name + ", " + stock);
			sb.append(System.getProperty("line.separator"));

			i++;
		}

		//return the string with all info about ingredients
		return sb.toString();
	}

	/**
	 * Method to get all indigrients in stock
	 * @return The string with ingredientsinfo
	 */
	public String getIngredientsInStock() throws SQLException {
		String query = "SELECT * FROM ingredients WHERE Stock > 0";

		// Do the query
		ResultSet rs = stmt.executeQuery(query);
		//Create a stringbuilder
		StringBuilder sb = new StringBuilder();

		//The index of the results so we can track them
		int i = 1;
		// Extract data from result set until there is no one left
		while (rs.next()) {

			// Retrieve by column name
			String name = rs.getString("name");
			int stock = rs.getInt("stock");

			//Append current tuple to the stringbuilder
			sb.append(i + ": " + name + ", " + stock);
			sb.append(System.getProperty("line.separator"));

			i++;
		}

		//return the string with all info about ingredients
		return sb.toString();
	}


	/**
	 * Method to return all recipies from the db
	 * @return String with all recipies
	 */
	public String getRecipies() throws SQLException {
		String query = "SELECT name FROM recipies";

		// Do the query
		ResultSet rs = stmt.executeQuery(query);
		//Create a stringbuilder
		StringBuilder sb = new StringBuilder();

		//The index of the results so we can track them
		int i = 1;
		// Extract data from result set until there is no one left
		while (rs.next()) {

			// Retrieve by column name
			String name = rs.getString("name");

			//Append current tuple to the stringbuilder
			sb.append(i + ": " + name);
			sb.append(System.getProperty("line.separator"));

			i++;
		}

		//return the string with all info about ingredients
		return sb.toString();
	}

	/**
	 * Method to return all recipies from the db that can be made (all ingredients in stock)
	 * @return String with all recipies that can be made
	 */
	public String getRecipiesInStock() throws SQLException {
		String query = "SELECT name FROM recipies WHERE name NOT IN (SELECT DISTINCT r.name FROM recipies r	LEFT JOIN inc ON (inc.rec_name = r.name) LEFT JOIN ingredients i ON (inc.ing_name = i.name) WHERE (inc.quantity > i.stock) OR i.stock IS NULL)";

		// Do the query
		ResultSet rs = stmt.executeQuery(query);
		//Create a stringbuilder
		StringBuilder sb = new StringBuilder();

		//The index of the results so we can track them
		int i = 1;
		// Extract data from result set until there is no one left
		while (rs.next()) {

			// Retrieve by column name
			String name = rs.getString("name");

			//Append current tuple to the stringbuilder
			sb.append(i + ": " + name);
			sb.append(System.getProperty("line.separator"));

			i++;
		}

		//return the string with all info about ingredients
		return sb.toString();
	}


	/**
	 * Add a ingredients to the db
	 * @param name, stock
	 */
	public void addIngredient(String name, int stock) throws SQLException {
		String query = "INSERT INTO `ingredients` (`name`,`stock`) VALUES " +
				"('" + name + "','" + stock + "')";				
		stmt.execute(query); 

	}

	/**
	 * Method to remove a ingredient
	 * @param name
	 * @throws SQLException
	 */
	public void removeIngredient(String name) throws SQLException {
		String query = "DELETE FROM `ingredients` WHERE name = " +
				"'" + name + "'";				
		stmt.execute(query); 

	}

}
