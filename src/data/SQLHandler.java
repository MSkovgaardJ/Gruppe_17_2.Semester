/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import common.ICitizen;
import common.IDBCom;
import common.ILoginToken;
import common.IJournal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author magnusm
 */
public class SQLHandler {
    IDBCom comhandler;
    
    public SQLHandler() {
        comhandler = new postgreSQLCom();
    }
    
    public boolean checkLogin(String username, String password) {
        boolean fund = false; 
        try {
            Connection db = comhandler.Connect();
            
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("select * from systemuser where username = '" + username + "' and password = '" + password + "'");
            if (rs.next()) {
              
              fund= true;  
                
               
            }
            rs.close();
            st.close();
            db.close();

        } catch (Exception e) {
            System.out.println(e);
        }
         finally {
              return fund;
         }
        
    }
   
    public void getCredentials(String username, String password, ILoginToken login) {
    
    } 
    
    public void getJournal(IJournal journal) {
     
    }
    
    public void getCitizen(ICitizen citizen) {
    
    }
    
}
