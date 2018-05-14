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
public class SystemUser
{
    private String userName;
    private String password;    
    private ILoginToken clearanceLevel;
    public SystemUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.clearanceLevel = new LoginToken(false, true,false);
    }    
    public ILoginToken getClearance()
    {        
        return clearanceLevel;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }  
}
