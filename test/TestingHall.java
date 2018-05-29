/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import common.ISystemUser;
import data.SQLGet;
import data.SQLHandler;
import data.SQLSet;
import data.postgreSQLCom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.SystemUser;

/**
 *
 * @author Stephanie
 */
public class TestingHall {

    public static void main(String[] args) {
        testSQL();
        testLogin();
    }

    private static void testSQL() {
        postgreSQLCom com = new postgreSQLCom();
        if (com.Connect() != null) {
            System.out.println("Connection test successful");
        } else {
            System.out.println("Connection test Failed");
        }
    }
    private static void testLogin()
    {   
        SQLHandler dataHandler= new SQLHandler();
        String username = "bo1234";
        String password = "guest";
        if(dataHandler.checkLogin(username, password))
        {
            SystemUser user = new SystemUser(username, password);
            dataHandler.getCredentials(user);
            if(!user.getClearance().isAdmin()
                && user.getClearance().isUser()
                && user.getClearance().isCaseHandler())
            {
                System.out.println("Correctly got credential for user "+ username);
            }
            else
            {
                System.out.println("Test failed, wrong credentials");
            }            
        }
        else
        {
            System.out.println("Test failed can't find system-user.");
        }        
    }
}
