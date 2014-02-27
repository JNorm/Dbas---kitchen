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
	public String getIndigrients() throws SQLException {
		String query = "SELECT * FROM indigrients ";

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
		}
		
		//return the string with all info about ingredients
		return sb.toString();
	}

}
