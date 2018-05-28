package data;

import common.IAid;

/**
 *
 * @author Stephanie
 */
public class SQLGet         
  {  
    public static String getAllCitizens = "select * from Citizen";
    public static String getAllJournals = "select * from Journal";
    public static String getAllAids = "select * from Aid";
    
    
    public static String getCitizen(int ssn)
    {
       return "select * from Citizen where SSN="+ssn;
    }  
    public static String getJournal(int jno)
    {
        return "select * from Journal where JournalNumber=" + jno;
    }   
    
    public static String getJournalsForCitizen(int ssn)
    {
        return "select * from citizenHas where SSN="+ssn;
    }
    public static String getCitizenForJournal(int jno)
    {
        return "select * from citizenHas where journalnumber="+jno;
    }
    public static String getAid(int aidno){
        return "select * from Aid where AidNumber =" + aidno;
    }    
    public static String checkLogin(String username,String password){
        return "select Username, Password from systemuser where username = '" + username + "' and password = '" + password + "'";
    }
    public static String getLoginCredentials(String username,String password){
        return "select isAdmin, isCaseHandler from systemuser where username = '" + username + "' and password = '" + password + "'";
    }


}
