package common;

/**
 *
 * @author Stephanie
 */
public interface ISystemUser {
    public String getUserName();
    public String getPassword();
    public ILoginToken getClearance();
    public void setUserName(String userName);
    public void setPassword(String password) ;
    
}
