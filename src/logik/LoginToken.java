/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logik;

/**
 *
 * @author Morten Skovgaard
 */
public class LoginToken
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
       return caseHandler;
   }   
    public void setCrendentials(isAdmin, isUser, isCaseHandler)
    {
       
    }
}
