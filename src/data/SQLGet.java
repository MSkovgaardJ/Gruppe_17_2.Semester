/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Stephanie
 */
public class SQLGet {
    public static String checklogin(String username,String password){
        return "select * from systemuser where username = '" + username + "' and password = '" + password + "'";
    }
    
}