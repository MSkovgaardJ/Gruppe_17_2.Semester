package logik;

import common.ILoginToken;

/**
 *
 * @author Morten Skovgaard
 */
<<<<<<< HEAD

public class LoginToken
=======
public class LoginToken implements ILoginToken
>>>>>>> UI
{
   private boolean admin;
   private boolean user;
   private boolean caseHandler;

    public LoginToken(boolean admin, boolean user, boolean caseHandler)
    {
        this.admin = admin;
        this.user = user;
        this.caseHandler = caseHandler;
    }   
    @Override
    public boolean isAdmin()
    {
        return admin;
    }
<<<<<<< HEAD
   
   
   public boolean isAdmin()
   {
       
       return admin;
   }
   
   public boolean isUser()
   {
       
       return user;
   }
   
   public boolean isCaseHandler()
   {
       
=======
    @Override
    public boolean isUser()
    {
       return user;
    }   
    @Override
    public boolean isCaseHandler()
    {
>>>>>>> UI
       return caseHandler;
    } 
    @Override
    public void setClearance(boolean isAdmin, boolean isCaseHandler) {
        this.admin = isAdmin;
        this.caseHandler = isCaseHandler;
    }
}
