package data;

import common.IDBCom;
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
    private static final String DB_CONNECTION = "jdbc:postgresql://dumbo.db.elephantsql.com:5432/vlqzyoul";
    private static final String DB_DRIVER = "org.postgresql.Driver";
    
  
    @Override
    public Connection Connect() {
        Connection conn = null;
        /* Attempts to locate a driver to allow for establishing a connection to the SQL server.
        Requires the PostgreSQL driver to be added to the project as a compile-time library.
        */
        try
        {
            Class.forName(DB_DRIVER);
        } catch(ClassNotFoundException classEx) {
            System.out.println(classEx);
        }
        
        try
        {
            conn = DriverManager.getConnection(DB_CONNECTION, username, password);
            System.out.println("connection succesfull");
            
        } catch(SQLException sqlEx) {
            
            System.out.println(sqlEx.getMessage());
        }
        return conn;
    }
    
}

