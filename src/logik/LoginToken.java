/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logik;

import common.ILoginToken;

/**
 *
 * @author Morten Skovgaard
 */
public class LoginToken implements ILoginToken
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
    @Override
    public boolean isUser()
    {
       return user;
    }   
    @Override
    public boolean isCaseHandler()
    {
       return caseHandler;
    } 
    @Override
    public void setClearance(boolean isAdmin, boolean isCaseHandler) {
        this.admin = isAdmin;
        this.caseHandler = isCaseHandler;
    }
}
