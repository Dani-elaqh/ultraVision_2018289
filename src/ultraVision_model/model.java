package ultraVision_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import controller.Box;
import controller.Concert;
import controller.Customer;
import controller.Movies;
import controller.Music;
import controller.RegisterRent;
import controller.UpdateCustomer;

public class model {

	String dbServer = "jdbc:mysql://35.242.142.135:3306/ultra_vision";
	String user = "root";
	String password = "mapas";
	Connection conn = null;
	Statement stmt = null;

	// Constructor starting theDB connection
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
//boolean set to false, before inserting the new customer
		boolean newCustomer = false;

		// query to insert into the database for the new customer
		try {

			String query = "INSERT INTO members (first_name, last_name, email, membertype, cardNumber, card_expirationdate) "
					+ "VALUES ( '" + regCustomer.getFirstName() + "', '" + regCustomer.getLastName() + "', '"
					+ regCustomer.getEmail() + "', '" + regCustomer.gettype() + "' , '" + regCustomer.getCard() + "', '"
					+ regCustomer.getDate() + "');";
			stmt.execute(query);
			newCustomer = true;

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

	// Method for creating the loyalty card as the new member is created too
	public boolean LoyaltyCard(String email) {

		boolean newCard = false;
		// All members are created with 0 points
		int defaultPoint = 0;
		int cust_id = 0;

		// Query to get the member id to later used to create the loyalty card
		String query = "Select MemberID FROM members  WHERE email= '" + email + "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// taking the member id and putting in the variable cust_id

			while (rs.next()) {

				cust_id = rs.getInt("MemberID");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		// Query to insert the new loyalty card
		query = "INSERT INTO loyaltycard(MemberID, LoyaltyPoints)" + "VALUES  ( '" + cust_id + "', '" + defaultPoint
				+ "');";

		try {
			stmt.execute(query);
			newCard = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newCard;
	}

//MEthod in charge of updating customers details 
	public boolean updateN(UpdateCustomer custUpdated) {

		new model();

		boolean update = false;

		try {
			// Building the query
			String query = "UPDATE members SET first_name='" + custUpdated.getName() + "', last_name = '"
					+ custUpdated.getLname() + "' , email ='" + custUpdated.getMail() + "', membertype = '"
					+ custUpdated.getMember() + "' , cardNumber = '" + custUpdated.getCardN()
					+ "', card_expirationdate = '" + custUpdated.getExpDate() + "' WHERE MemberID = '"
					+ custUpdated.getId() + "' ";

			// Execute the query
			stmt.execute(query);
			update = true;

			// Calling the method in charge of closing the connections
			closings();
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

		return update;
	}

//	Method in charge of searching for a customer by email 

	public String[][] SearchMember(String email) {

		// Creating an array that we can return later
		String[][] data = null;
		try {

			String query = "SELECT * FROM members WHERE email = '" + email + "'";

			// Get a connection to the database
			String[] columnNames = new String[] { "Member ID", "First name", "Last name", "Email", "Member Type",
					"Card Number", "Card Exp Date" };

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
				data[row][0] = rs.getString("MemberID");
				data[row][1] = rs.getString("first_name");
				data[row][2] = rs.getString("last_name");
				data[row][3] = rs.getString("email");
				data[row][4] = rs.getString("membertype");
				data[row][5] = rs.getString("cardNumber");
				data[row][6] = rs.getString("card_expirationdate");

				// go the the next row"
				row++;
			}

			// Close the result set, statement and the connection
			rs.close();
			stmt.close();

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

	// this method is in charge of inserting the new music title into the database
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
		// returning the new title added
		return newMusic;
	}

	// Method is in charge of showing the movie table
	public String[][] movie() {

		boolean rented = false;
		// Creating an array that we can return later
		String[][] data = null;
		try {

			String query = "SELECT * FROM movies WHERE rented = '" + rented + "'";

			// Get a connection to the database
			String[] columnNames = new String[] { "Movie ID", "Director", "Title", "Year of Release", "Genre",
					"Rented" };

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

	// this method is in charge of adding new titles into the movie table in the
	// data base
	public boolean regMovie(Movies addMovie) {

		boolean newMovie = false;
		new model();

		// query to insert into the database for the new music title
		try {

			String query = "INSERT INTO music (Director, Title, year_Of_Realease, Genre, rented) " + "VALUES ( '"
					+ addMovie.getDir() + "', '" + addMovie.getTitle() + "', '" + addMovie.getYear() + "', '"
					+ addMovie.getGenre() + "' , '" + addMovie.getRent() + "');";
			stmt.execute(query);

			newMovie = true;

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
		closings();
		return newMovie;
	}

	// Method in charge of showing the table for the live concert table
	public String[][] concert() {

		boolean rented = false;
		// Creating an array that we can return later
		String[][] data = null;
		try {

			String query = "SELECT * FROM liveconcert WHERE rented = '" + rented + "'";

			// Get a connection to the database
			String[] columnNames = new String[] { "LiveID", "Title", "Artist", "Year of Release", "Genre", "Rented",
					"Format" };

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

// Method in charge of adding new concert titles into the database
	public boolean regConcert(Concert addLive) {

		boolean newLive = false;
		new model();

		// query to insert into the database for the new live concert title
		try {

			String query = "INSERT INTO liveconcert (Title, Artist, year_Of_Realease, Genre, Rented, Format ) "
					+ "VALUES ( '" + addLive.getTitle() + "', '" + addLive.getArtist() + "', '" + addLive.getYear()
					+ "', '" + addLive.getGenre() + "' , '" + addLive.getRented() + "', '" + addLive.getFormat()
					+ "');";
			stmt.execute(query);

			newLive = true;

			closings();
		}

		catch (SQLException se) {
			System.out.println("SQL Exception:");
			// Loop through the SQL Exceptions
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

	// Method in charge of displaying the Tvbox set table from the data base
	public String[][] box() {

		boolean rented = false;
		// Creating an array that we can return later
		String[][] data = null;
		try {

			String query = "SELECT * FROM tvbox WHERE rented = '" + rented + "'";

			// Get a connection to the database
			String[] columnNames = new String[] { "BoxID", "Title", "Season", "Genre", "Rented" };

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

	// Method where the the new titles added for the Tv box table
	public boolean regBox(Box addTv) {

		boolean newBox = false;
		new model();

		// query to insert into the database for the new tv box title
		try {

			String query = "INSERT INTO tvbox (Title, Season, Genre, Rented ) " + "VALUES ( '" + addTv.getTitle()
					+ "', '" + addTv.getSeason() + "' , '" + addTv.getGenre() + "', '" + addTv.getRented() + "');";
			stmt.execute(query);

			newBox = true;

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
		closings();
		return newBox;
	}

	// Method that records the rented titles into the data base for the music titles
	public boolean RentedMusic(RegisterRent addRented) {

		boolean newMlover = false;

		// query to insert into the database for the new music title
		try {

			String query = "INSERT INTO rentedmusic (MemberID, TitleID, Title, RentDate) " + "VALUES ( '"
					+ addRented.getId() + "', '" + addRented.getTitleID() + "','" + addRented.getTitle() + "', '"
					+ addRented.getDate() + "');";
			stmt.execute(query);

			newMlover = true;

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
		return newMlover;
	}

	// Method that is called when the user is registering rented titles for the
	// concert table into the rented live concert table
	public boolean RentedConcert(RegisterRent addRented) {

		boolean newConcert = false;

		// query to insert into the database for the new music title
		try {

			String query = "INSERT INTO rentedliveconcert (MemberID, TitleID, Title, RentDate) " + "VALUES ( '"
					+ addRented.getId() + "', '" + addRented.getTitleID() + "', '" + addRented.getTitle() + "', '"
					+ addRented.getDate() + "');";
			stmt.execute(query);

			newConcert = true;

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
		return newConcert;
	}

	// Method that records the rented titles from tvBox titles into the rented tvbox
	// table
	public boolean RentedTvBox(RegisterRent addRented) {

		boolean newTv = false;

		// query to insert into the database for the new music title
		try {

			String query = "INSERT INTO rentedtvbox (MemberID, TitleID, Title, RentDate) " + "VALUES ( '"
					+ addRented.getId() + "', '" + addRented.getTitleID() + "', '" + addRented.getTitle() + "', '"
					+ addRented.getDate() + "');";
			stmt.execute(query);

			newTv = true;

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
		return newTv;
	}

	// Boolean method that returns when the new rented titles is added to the rented
	// movies table
	public boolean RentedMovies(RegisterRent addRented) {

		boolean newMovies = false;

		// query to insert into the database for the new music title
		try {

			String query = "INSERT INTO rentedmovies (MemberID, TitleID, Title, RentDate) " + "VALUES ( '"
					+ addRented.getId() + "', '" + addRented.getTitleID() + "', '" + addRented.getTitle() + "', '"
					+ addRented.getDate() + "');";
			stmt.execute(query);

			newMovies = true;

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
		return newMovies;
	}

	// Method for recording and returning when a new rented title is added to the
	// Premium table
	public boolean RentedPremium(RegisterRent addRented) {

		boolean newPremium = false;

		// query to insert into the database for the new music title
		try {

			String query = "INSERT INTO rentedpremium (MemberID, TitleID, Title, RentDate) " + "VALUES ( '"
					+ addRented.getId() + "', '" + addRented.getTitleID() + "', '" + addRented.getTitle() + "', '"
					+ addRented.getDate() + "');";
			stmt.execute(query);

			newPremium = true;

			closings();
		}

		catch (SQLException se) {
			System.out.println("SQL Exception:");
			//// Loop through the SQL Exceptions
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
		return newPremium;
	}

	// Closing the connections after finishing the task with the data base
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
