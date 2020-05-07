package ultraVision_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.Customer;
import controller.MemberReg;
import controller.Staff;

public class model {

	String dbServer = "jdbc:mysql://35.242.142.135:3306/ultra_vision";
    String user = "root";
    String password = "mapas";
    Connection conn = null;
    Statement stmt = null;
    
    //Constructor. Here these class is starting theDB connection
    //putting everything in the variables declared above
public model(){
	
		
        
        try{
        	  Class.forName("com.mysql.jdbc.Driver");
        	
        	
        	
            // Get a connection to the database
            conn = DriverManager.getConnection(dbServer, user, password) ;

            // Get a statement from the connection
            stmt = conn.createStatement() ;

        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
        
    }
    
    // This method is only in charge of asking the DB if a user exists
    // Notice that it is using the variables initialized by the constructor
	
	//method for insertinf data into the data base
	public boolean register(Customer regCustomer) {
		
		new model();
		
		boolean newCustomer = false;
		
		
		//query to insert into the database for the new customer
		try {
    		
			String query = "INSERT INTO members (first_name, last_name, email, membertype, cardNumber, card_expirationdate) " + "VALUES ( '"
			+ regCustomer.getFirstName() + "', '" + regCustomer.getLastName() + "', '" + regCustomer.getEmail() + "', '"
			+regCustomer.gettype() + "' , '" + regCustomer.getCard() + "', '" + regCustomer.getDate()
			+ "');";
    		stmt.execute(query);
    		newCustomer = true;
            
            closings();
        }
        
        catch(SQLException se ){
            System.out.println( "SQL Exception:");
            
            while( se != null){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            
            }
        }
        
        catch (Exception e){
            System.out.println( e );
        }
	return newCustomer;
    }        
		
	
	//method to show the table off music that is inside the database
	public String[][] music( )
	{
            // Creating an array that we can return later
            String[][] data = null;
		try{
                  
                    String query = "SELECT * FROM music";

                    // Get a connection to the database
                   

                    // Get a statement from the connection
                    Statement stmt = conn.createStatement() ;

                    // Execute the query
                    ResultSet rs = stmt.executeQuery(query) ;
			
                    // Instantiating the array
                    data = new String[100][4];
                    // Creating a counter to keep track of the 
                    // row we're on
                    int row = 0;
			
                    // Loop through the result set
                    while(rs.next()) {
                        // this is printing the console
                        System.out.println( rs.getString("MusicID") + "\t" + rs.getString("Artist") + rs.getString("Title") + 
					"\t" + rs.getString("year_Of_Realease")) ;
                                
                        //  adding the data to an array
                        data[row][0] = rs.getString("MusicID");
                        data[row][1] = rs.getString("Artist");
                        data[row][2] = rs.getString("Title");
                        data[row][3] = rs.getString("year_Of_Realease");
                        
                        // go the the next row
                        row++;
                    }

                    // Close the result set, statement and the connection
                    rs.close() ;
                    stmt.close() ;
                    conn.close() ;
		}
		catch( SQLException se ){
                    System.out.println( "SQL Exception:" ) ;

                    // Loop through the SQL Exceptions
                    while( se != null ){
                    	System.out.println( "State  : " + se.getSQLState()  ) ;
                	System.out.println( "Message: " + se.getMessage()   ) ;
			System.out.println( "Error  : " + se.getErrorCode() ) ;

			se = se.getNextException() ;
                    }
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
                
                // Returning the array of data
                return data;
	}

		public String[][] updatecustomer( )	{

            // Creating an array that we can return later
            String[][] data = null;
            
		try{
                  
                    String query = "SELECT * FROM members";

                    // Get a connection to the database
                   

                    // Get a statement from the connection
                    Statement stmt = conn.createStatement() ;

                    // Execute the query
                    ResultSet rs = stmt.executeQuery(query) ;
			
                    // Instantiating the array
                    data = new String[100][4];
                    // Creating a counter to keep track of the 
                    // row we're on
                    int row = 0;
			
                    // Loop through the result set
                    while(rs.next()) {
                        // this is printing the console
                        System.out.println( rs.getString("MemberID") + "\t" + rs.getString("firts_name") +"\t"+ rs.getString("last_name") + 
                        		"\t" + rs.getString("email") +"\t" + rs.getString("membertype") +"\t" + rs.getString("cardNumber") + "\t" + rs.getString("card_expirationdate")) ;
                                
                        //  adding the data to an array
                        data[row][0] = rs.getString("MemberID");
                        data[row][1] = rs.getString("firts_name");
                        data[row][2] = rs.getString("last_name");
                        data[row][3] = rs.getString("email");
                        data[row][4] = rs.getString("membertype");
                        data[row][5] = rs.getString("cardNumber");
                        data[row][6] = rs.getString("card_expirationdate");
                        
                        // go the the next row
                        row++;
                    }

                    // Close the result set, statement and the connection
                    rs.close() ;
                    stmt.close() ;
                    conn.close() ;
		}
		catch( SQLException se ){
                    System.out.println( "SQL Exception:" ) ;

                    // Loop through the SQL Exceptions
                    while( se != null ){
                    	System.out.println( "State  : " + se.getSQLState()  ) ;
                	System.out.println( "Message: " + se.getMessage()   ) ;
			System.out.println( "Error  : " + se.getErrorCode() ) ;

			se = se.getNextException() ;
                    }
		}
		catch( Exception e ){
			System.out.println( e ) ;
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
