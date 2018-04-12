/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensumudred;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author nikol
 */
public class DBConnect {
    
    // Variables related to user credentials
    private String username;
    private String password;
    private String userPrompt;
    private static Scanner userInput = new Scanner(System.in);
    
    // Variables related to database connection
    private static final String DB_CONNECTION = "jdbc:postgresql://horton.elephantsql.com:5432/tuuvvgaa";
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private Connection conn;
    
    public void dbConnection()
    {
        /* Attempts to locate a driver to allow for establishing a connection to the SQL server.
        Requires the PostgreSQL driver to be added to the project as a compile-time library.
        */
        try
        {
            Class.forName(DB_DRIVER);
        } catch(ClassNotFoundException cEx) {
            System.out.println(cEx);
        }
        
        /* Prompts the user to login with username and password before gaining access to the database.
        This does not check whether the entered data is actually correct.
        However, the database does not allow access unless the entered data is correct.
        The application should probably let the user know whether entered data is incorrect or correct, instead of the error it throws when it is incorrect.
        Should probably also be moved to a different class entirely.
        */ 
        userPrompt = "Enter Username: ";
        
        System.out.println("Enter Username: ");
        username = userInput.nextLine();
        
        System.out.println("Enter password: ");
        password = userInput.nextLine();
        
        
        
        try
        {
            conn = DriverManager.getConnection(DB_CONNECTION, username, password);
            
        } catch(SQLException sqlEx) {
            
            System.out.println(sqlEx.getMessage());
        }
    }
}
