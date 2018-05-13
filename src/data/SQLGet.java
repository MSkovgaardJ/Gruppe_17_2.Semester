package data;

/**
 *
 * @author Stephanie
 */

public class SQLGet 
{
    public final String getCitizen()
    {
        
        return null;
    }
   
    public final String getJournal()
    {
        
        return null;
    }
    
    public final String getAid()
    {
        
        return null;
    }
    
    public static String checklogin(String username,String password)
    {
        
        return "select * from systemuser where username = '" + username + "' and password = '" + password + "'";
    }
}
