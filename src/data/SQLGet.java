/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Stephanie
 */
public class SQLGet         
  {  
    public static String getAllCitizens = "select * from Citizen";
    public static String getAllJournals = "select * from Journal";
    public static String getAllAids = "select * from Aid";
    public static String getCitizen(int ssn){
       return "select * from Citizen where SSS="+ssn;
    }  
    public static String getJournal(int jno){
        return null;
    }    
    public static String getAid(int aidno){
        return null;
    }    
    public static String checklogin(String username,String password){
        return "select Username, Password from systemuser where username = '" + username + "' and password = '" + password + "'";
    }
    public static String getlogincredentials(String username,String password){
        return "select isAdmin, isCaseHandler from systemuser where username = '" + username + "' and password = '" + password + "'";
    }
    
}
