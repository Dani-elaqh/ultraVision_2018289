package ultraVision_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.Concert;
import controller.Customer;
import controller.MemberReg;
import controller.Movies;
import controller.Music;
import controller.Staff;

public class model {

	String dbServer = "jdbc:mysql://35.242.142.135:3306/ultra_vision";
	String user = "root";
	String password = "mapas";
	Connection conn = null;
	Statement stmt = null;

	// Constructor. Here these class is starting theDB connection
	// putting everything in the variables declared above
	public model() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Get a connection to the database
			conn = DriverManager.getConnection(dbServer, user, password);

			// Get a statement from the connection
			stmt = conn.createStatement();

		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			// Loop through the SQL Exceptions
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// This method is only in charge of asking the DB if a user exists
	// Notice that it is using the variables initialized by the constructor

	// method for inserting data into the data base, for the members table
	public boolean register(Customer regCustomer) {

		new model();

		boolean newCustomer = false;

		// query to insert into the database for the new customer
		try {

			String query = "INSERT INTO members (first_name, last_name, email, membertype, cardNumber, card_expirationdate) "
					+ "VALUES ( '" + regCustomer.getFirstName() + "', '" + regCustomer.getLastName() + "', '"
					+ regCustomer.getEmail() + "', '" + regCustomer.gettype() + "' , '" + regCustomer.getCard() + "', '"
					+ regCustomer.getDate() + "');";
			stmt.execute(query);
			newCustomer = true;

			closings();
		}

		catch (SQLException se) {
			System.out.println("SQL Exception:");

			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return newCustomer;
	}

	// method to show the table off music that is inside the database
	public String[][] music() {
		boolean rented = false;
		// Creating an array that we can return later
		String[][] data = null;
		try {

			String query = "SELECT * FROM music WHERE rented = '" + rented + "'";

			// Get a connection to the database
			String[] columnNames = new String[] { "Music ID", "Artist", "Title", "Year of Release", "Rented" };

			// Get a statement from the connection
			Statement stmt = conn.createStatement();

			// Execute the query
			ResultSet rs = stmt.executeQuery(query);

			// Instantiating the array
			data = new String[100][columnNames.length];
			// Creating a counter to keep track of the
			// row we're on
			int row = 0;

			// Loop through the result set
			while (rs.next()) {
				// this is printing the console

				// adding the data to an array
				data[row][0] = rs.getString("MusicID");
				data[row][1] = rs.getString("Artist");
				data[row][2] = rs.getString("Title");
				data[row][3] = rs.getString("year_Of_Realease");
				data[row][4] = rs.getString("rented");

				// go the the next row"
				row++;
			}

			// Close the result set, statement and the connection
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			// Loop through the SQL Exceptions
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// Returning the array of data
		return data;
	}

	public boolean regMusic(Music addMusic) {

		boolean newMusic = false;
		new model();

		// query to insert into the database for the new music title
		try {

			String query = "INSERT INTO music (Artist, Title, year_Of_Realease, rented) " + "VALUES ( '"
					+ addMusic.getArtist() + "', '" + addMusic.getTitle() + "', '" + addMusic.getYear() + "', '"
					+ addMusic.getRented() + "');";
			stmt.execute(query);

			newMusic = true;

			closings();
		}

		catch (SQLException se) {
			System.out.println("SQL Exception:");

			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return newMusic;
	}

	public String[][] movie() {
		
		boolean rented = false;
		// Creating an array that we can return later
		String[][] data = null;
		try {

			String query = "SELECT * FROM movies WHERE rented = '" + rented + "'";

			// Get a connection to the database
			String[] columnNames = new String[] { "Movie ID", "Director", "Title", "Year of Release", "Genre", "Rented" };

			// Get a statement from the connection
			Statement stmt = conn.createStatement();

			// Execute the query
			ResultSet rs = stmt.executeQuery(query);

			// Instantiating the array
			data = new String[100][columnNames.length];
			// Creating a counter to keep track of the
			// row we're on
			int row = 0;

			// Loop through the result set
			while (rs.next()) {
				// this is printing the console

				// adding the data to an array
				data[row][0] = rs.getString("MovieID");
				data[row][1] = rs.getString("Director");
				data[row][2] = rs.getString("Title");
				data[row][3] = rs.getString("year_Of_Realease");
				data[row][4] = rs.getString("Genre");
				data[row][5] = rs.getString("rented");

				// go the the next row"
				row++;
			}

			// Close the result set, statement and the connection
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			// Loop through the SQL Exceptions
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// Returning the array of data
		return data;
	}
	
	public boolean regMovie(Movies addMovie) {

		boolean newMovie = false;
		new model();

		// query to insert into the database for the new music title
		try {

			String query = "INSERT INTO music (Director, Title, year_Of_Realease, Genre, rented) " + "VALUES ( '"
					+ addMovie.getDir() + "', '" + addMovie.getTitle() + "', '" + addMovie.getYear() + "', '"
					+ addMovie.getGenre()+ "' , '"	+ addMovie.getRent() + "');";
			stmt.execute(query);

			newMovie = true;

			closings();
		}

		catch (SQLException se) {
			System.out.println("SQL Exception:");

			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return newMovie;
	}
	
public String[][] concert() {
		
		boolean rented = false;
		// Creating an array that we can return later
		String[][] data = null;
		try {

			String query = "SELECT * FROM liveconcert WHERE rented = '" + rented + "'";

			// Get a connection to the database
			String[] columnNames = new String[] { "LiveID", "Title", "Artist", "Year of Release", "Genre", "Rented", "Format" };

			// Get a statement from the connection
			Statement stmt = conn.createStatement();

			// Execute the query
			ResultSet rs = stmt.executeQuery(query);

			// Instantiating the array
			data = new String[100][columnNames.length];
			// Creating a counter to keep track of the
			// row we're on
			int row = 0;

			// Loop through the result set
			while (rs.next()) {
				// this is printing the console

				// adding the data to an array
				data[row][0] = rs.getString("LiveID");
				data[row][1] = rs.getString("Title");
				data[row][2] = rs.getString("Artist");
				data[row][3] = rs.getString("year_Of_Realease");
				data[row][4] = rs.getString("Genre");
				data[row][5] = rs.getString("Rented");
				data[row][6] = rs.getString("Format");	

				// go the the next row"
				row++;
			}

			// Close the result set, statement and the connection
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			// Loop through the SQL Exceptions
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// Returning the array of data
		return data;
	}
	
public boolean regConcert(Concert addLive) {

	boolean newLive = false;
	new model();

	// query to insert into the database for the new music title
	try {

		String query = "INSERT INTO liveconcert (Title, Artist, year_Of_Realease, Genre, Rented, Format ) " + "VALUES ( '"
				+ addLive.getTitle() + "', '" + addLive.getArtist() + "', '" + addLive.getYear() + "', '"
				+ addLive.getGenre()+ "' , '"	+ addLive.getRented() + "', '" + addLive.getFormat()+ "');";
		stmt.execute(query);

		newLive = true;

		closings();
	}

	catch (SQLException se) {
		System.out.println("SQL Exception:");

		while (se != null) {
			System.out.println("State  : " + se.getSQLState());
			System.out.println("Message: " + se.getMessage());
			System.out.println("Error  : " + se.getErrorCode());

			se = se.getNextException();

		}
	}

	catch (Exception e) {
		System.out.println(e);
	}
	return newLive;
}

public String[][] box() {
	
	boolean rented = false;
	// Creating an array that we can return later
	String[][] data = null;
	try {

		String query = "SELECT * FROM tvbox WHERE rented = '" + rented + "'";

		// Get a connection to the database
		String[] columnNames = new String[] { "BoxID", "Title", "Season" , "Genre", "Rented"};

		// Get a statement from the connection
		Statement stmt = conn.createStatement();

		// Execute the query
		ResultSet rs = stmt.executeQuery(query);

		// Instantiating the array
		data = new String[100][columnNames.length];
		// Creating a counter to keep track of the
		// row we're on
		int row = 0;

		// Loop through the result set
		while (rs.next()) {
			// this is printing the console

			// adding the data to an array
			data[row][0] = rs.getString("BoxID");
			data[row][1] = rs.getString("Title");
			data[row][2] = rs.getString("Season");	
			data[row][3] = rs.getString("Genre");
			data[row][4] = rs.getString("Rented");
			

			// go the the next row"
			row++;
		}

		// Close the result set, statement and the connection
		rs.close();
		stmt.close();
		conn.close();
		
	} catch (SQLException se) {
		System.out.println("SQL Exception:");

		// Loop through the SQL Exceptions
		while (se != null) {
			System.out.println("State  : " + se.getSQLState());
			System.out.println("Message: " + se.getMessage());
			System.out.println("Error  : " + se.getErrorCode());

			se = se.getNextException();
		}
	} catch (Exception e) {
		System.out.println(e);
	}

	// Returning the array of data
	return data;
}
	public String[][] updatecustomer() {

		// Creating an array that we can return later
		String[][] data = null;

		try {

			String query = "SELECT * FROM members";

			// Get a connection to the database

			// Get a statement from the connection
			Statement stmt = conn.createStatement();

			// Execute the query
			ResultSet rs = stmt.executeQuery(query);

			// Instantiating the array
			data = new String[100][4];
			// Creating a counter to keep track of the
			// row we're on
			int row = 0;

			// Loop through the result set
			while (rs.next()) {
				// this is printing the console
				System.out.println(rs.getString("MemberID") + "\t" + rs.getString("firts_name") + "\t"
						+ rs.getString("last_name") + "\t" + rs.getString("email") + "\t" + rs.getString("membertype")
						+ "\t" + rs.getString("cardNumber") + "\t" + rs.getString("card_expirationdate"));

				// adding the data to an array
				data[row][0] = rs.getString("LiveID");
				data[row][1] = rs.getString("Title");
				data[row][2] = rs.getString("Artist");
				data[row][3] = rs.getString("year_Of_Realease");
				data[row][4] = rs.getString("Genre");
				data[row][5] = rs.getString("Rented");
				data[row][6] = rs.getString("Format");

				// go the the next row
				row++;
			}

			// Close the result set, statement and the connection
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			// Loop through the SQL Exceptions
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// Returning the array of data
		return data;
	}

	private void closings() {

		try {
			stmt.close();
			conn.close();
		}

		catch (SQLException ex) {
			Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
