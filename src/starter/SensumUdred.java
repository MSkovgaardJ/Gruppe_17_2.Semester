/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starter;

import data.SQLHandler;
import data.postgreSQLCom;

/**
 *
 * @author Stephanie
 */
public class SensumUdred {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Group 17 is awesome");
        System.out.println("Look at me i'm mr missis");
        SQLHandler sqlhandler = new SQLHandler();
        System.out.println(sqlhandler.checkLogin("bo12345", "guest"));
        
    }
    
}