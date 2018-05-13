/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import data.SQLGet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Stephanie
 */
public interface IDataHandler {
    public boolean checkLogin(String username, String password);   
    public void getCredentials(String username, String password, ILoginToken login);
    public void getJournal(IJournal journal);
    public void getCitizen(ICitizen citizen);   
   
    
}
