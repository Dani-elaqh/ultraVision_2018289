package ultraVision_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.Staff;

public class model {

	String dbServer = "jdbc:mysql://localhost:3306/ultra_vision";
    String user = "root";
    String password = "mapas";
    Connection conn = null;
    Statement stmt = null;
    
    //Constructor. Here these class is starting theDB connection
    //putting everything in the variables declared above
public model(){
        
        try{
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
    public boolean login(Staff userLogged){
        
        // Variable to define if the login is successful
        boolean login = false;
        try{
            // Building the query
            String query = "SELECT * FROM staff WHERE userID = '" + userLogged.getUn() + "' AND code = '" + userLogged.getPw() + "';";

            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query) ;

            // If there is an entry in the database that satisfies
            // the user name and password, then the login is successful
            // otherwise it fails
            login = rs.next();

            // Close the result set, statement and the connection
            rs.close() ;

            // Calling the method in charge of closing the connections
            closings();
            
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

        // Returning the login status
        return login;
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
