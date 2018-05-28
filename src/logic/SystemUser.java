/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import common.ILoginToken;
import common.ISystemUser;

/**
 *
 * @author Morten Skovgaard
 */
public class SystemUser implements ISystemUser
{
    private String userName;
    private String password;    
    private ILoginToken clearanceLevel;
    public SystemUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.clearanceLevel = new LoginToken(false,false);
    }    
    @Override
    public ILoginToken getClearance()
    {        
        return clearanceLevel;
    }
    @Override
    public String getUserName() {
        return userName;
    }
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }  
}
