package data;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author nikol
 */
public class postgreSQLCom implements IDBCom {
    
    // Variables related to user credentials
    private final String username = "vlqzyoul"; // tuuvvgaa (change to username from the group)
    private final String password ="FmS71g9K6CXR8V1duPNYSNP5FqH2IIDc"; // 9cl0hEPLwN9cQOpdu-d9o1OpO3V3m9xr (change to password from the group)
    
    // Variables related to database connection
    private static final String DB_CONNECTION = "jdbc:postgresql://horton.elephantsql.com:5432/tuuvvgaa";
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private Connection conn;
    
    DBQueries dbQ = new DBQueries();
    
    public void dbConnection()
    {
        /* Attempts to locate a driver to allow for establishing a connection to the SQL server.
        Requires the PostgreSQL driver to be added to the project as a compile-time library.
        */
        try
        {
            Class.forName(DB_DRIVER);
        } catch(ClassNotFoundException classEx) {
            System.out.println(classEx);
        }
        
        /* Prompts the user to login with username and password before gaining access to the database.
        This does not check whether the entered data is actually correct.
        However, the database does not allow access unless the entered data is correct.
        The application should probably let the user know whether entered data is incorrect or correct, instead of the error it throws when it is incorrect.
        Should probably also be moved to a different class entirely.
        */ 
        userPrompt = "Enter Username: ";
        
//        System.out.println("Enter Username: ");
        username = "tuuvvgaa";
        
//        System.out.println("Enter password: ");
        password = "9cl0hEPLwN9cQOpdu-d9o1OpO3V3m9xr";
        
        
        
        try
        {
            conn = DriverManager.getConnection(DB_CONNECTION, username, password);
            
        } catch(SQLException sqlEx) {
            
            System.out.println(sqlEx.getMessage());
        }
    }
//    
//    public void dbQuery() {
//        // Utilizes queries from the DBQueries class to send queries to the SQL database.
//        
//        Statement statement;
//        ResultSet resultSet;
//        
//        try {
//            statement = conn.createStatement();
//            
//            resultSet = statement.executeQuery(""); // Replace "" with query to be used.
//            
//            while(resultSet.next()) {
//                
//                System.out.println(""); // Output result of query here.
//            }
//            
//            resultSet.close();
//            statement.close();
//        } catch(SQLException sqlqEx) {
//            
//            System.out.println(sqlqEx.getMessage());
//        }
//    }

    @Override
    public Connection Connect() {
        
    }
}
