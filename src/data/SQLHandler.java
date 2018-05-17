package data;

import common.IAid;
import common.ICitizen;
import common.IDBCom;
import common.ILoginToken;
import common.IJournal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

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
        } finally {            
            return fund;
        }
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
    
    
    public void getJournal(IJournal journal) 
    {
        try (Connection db = comhandler.Connect())  
        {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getJournal(journal.getjournalnumber()));
                
                if (rs.next())
                {
                    int journalnumber = rs.getInt(0);
                    boolean status = rs.getBoolean(1);
                    String journallocation = rs.getNString(2);
                    Date date = rs.getDate(3);
                    
                    journal.setjournalnumber(journalnumber);
                    journal.setdate(date);
                    journal.setjournallocation(journallocation);
                    journal.setstatus(status);
                    System.out.println("found journal");
                }
            rs.close();
            st.close();
        }
        catch (SQLException e) {
            System.out.println(e);

        }
    }    
    
    
    public void getCitizen(ICitizen citizen) 
    {
        try (Connection db = comhandler.Connect()) 
        {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getCitizen(citizen.getSSN()));
            if (rs.next()) 
            {
                String fname = rs.getString(1);
                String lname = rs.getString(2);
                String phonenumber = rs.getString(2);
                int ssn = rs.getInt(0);
                String address = rs.getString(0);
                String city = rs.getString(0);
                int postalNumber = rs.getInt(0);
                
                citizen.setAddress(address);
                citizen.setCity(city);
                citizen.setFirstName(fname);
                citizen.setLastName(lname);
                citizen.setSSN(ssn);
                citizen.setPhoneNumber(phonenumber);
                citizen.setPostalNumber(postalNumber);                
                System.out.println("got citizen");
            }
            rs.close();
            st.close();
        } 
        catch (SQLException e) {
        System.out.println(e);
        }     
    }    
    public Collection<ICitizen> getCitizens(ICitizen base)
    {
        Collection<ICitizen> list = new ArrayList<>();
        try (Connection db = comhandler.Connect()) {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getAllCitizens);
            while (rs.next()) {
                ICitizen citizen= base.clone();                
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                String phonenumber = rs.getString(7);
                int ssn = rs.getInt(1);
                String address = rs.getString(4);
                String city = rs.getString(6);
                int postalNumber = rs.getInt(5);
                
                citizen.setAddress(address);
                citizen.setCity(city);
                citizen.setFirstName(fname);
                citizen.setLastName(lname);
                citizen.setSSN(ssn);
                citizen.setPhoneNumber(phonenumber);
                citizen.setPostalNumber(postalNumber);   
           
                list.add(citizen);
                //System.out.println("is Admin "+ isAdmin +"\nis Casehandler "+ isCaseHandler);
            }
            System.out.println("got credentials");
            rs.close();
            st.close();
        } 
        catch (SQLException e) {
        System.out.println(e);
        } 
        return list;
    }
    
    public void getAid(IAid aid) 
    {
        try (Connection db = comhandler.Connect()) 
        {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(SQLGet.getAid(aid.getAidNo()));
            if (rs.next()) 
            {
                int aidNo = rs.getInt(0);
                String aname = rs.getNString(1);
                String discribsion = rs.getNString(2);
                
                
                   
                System.out.println("got aid");
            }
            rs.close();
            st.close();
        } 
        catch (SQLException e) {
        System.out.println(e);
        }     
    }    
}
