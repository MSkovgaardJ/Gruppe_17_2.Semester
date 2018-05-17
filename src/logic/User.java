package logic;

/**
 *
 * @author Morten Skovgaard
 */

public class User
{
    private int userID;
    private LoginToken clearanceLevel;
    
    public LoginToken getClearance()
    {
        
        return clearanceLevel;
    }
}
