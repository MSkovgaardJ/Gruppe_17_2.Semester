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

public class SQLHandler
{
    IDBCom comHandler;
    
    public SQLHandler()
    {
        comHandler = new postgreSQLCom();
    }
    
    public boolean checkLogin(String username, String password)
    {
        boolean fund = false; 
        
        try {
            Connection db = comHandler.Connect();
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.checklogin(username, password));
            
            if(rs.next()) {
              
              fund = true;
            }
            
            rs.close();
            st.close();
            db.close();
            
        } catch(Exception e) {
            
            System.out.println(e);
            
        } finally {
            
            return fund;
        }
    }
   
    public void getCredentials(String username, String password, ILoginToken login)
    {
        
    } 
    
    public void getJournal(IJournal journal)
    {
        
    }
    
    public void getCitizen(ICitizen citizen)
    {
        
    }
}
