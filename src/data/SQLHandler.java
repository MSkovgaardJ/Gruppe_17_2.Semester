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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author magnusm
 */
public class SQLHandler{
    IDBCom comhandler;    
    public SQLHandler() {
        comhandler = new postgreSQLCom();
    }   
    public boolean checkLogin(String username, String password) {
        boolean fund = false; 
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.checklogin(username, password));
            if (rs.next()) {
                if((rs.getString(1).equalsIgnoreCase(username))&&
                   (rs.getString(2).equalsIgnoreCase(password)))
                {
                    System.out.println("found user");
                    fund= true;                
                }
            }
            rs.close();
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return fund;               
    }   
    public void getCredentials(String username, String password, ILoginToken login) {   
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getlogincredentials(username, password));
            if (rs.next()) {
                boolean isAdmin = rs.getBoolean(1);
                boolean isCaseHandler = rs.getBoolean(2);
                login.setClearance(isAdmin, isCaseHandler); 
                System.out.println("got credentials");
                //System.out.println("is Admin "+ isAdmin +"\nis Casehandler "+ isCaseHandler);
            }
            rs.close();
            st.close();
        } 
        catch (SQLException e) {
        System.out.println(e);
        }            
        
    }     
    public void getJournal(IJournal journal) {
     
    }    
    public void getCitizen(ICitizen citizen) {
    
    }
    
}
