/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import common.ICitizen;
import common.IDBCom;
import common.IDataHandler;
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
public class SQLHandler implements IDataHandler{
    IDBCom comhandler;    
    public SQLHandler() {
        comhandler = new postgreSQLCom();
    }    
    @Override
    public boolean checkLogin(String username, String password) {
        boolean fund = false; 
        try {
            Connection db = comhandler.Connect();            
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.checklogin(username, password));
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
    @Override
    public void getCredentials(String username, String password, ILoginToken login) {
    
    }     
    @Override
    public void getJournal(IJournal journal) {
     
    }    
    @Override
    public void getCitizen(ICitizen citizen) {
    
    }
    
}
