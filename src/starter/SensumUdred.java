
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starter;

import data.SQLHandler;
import data.postgreSQLCom;


import GUI.ConsoleUI;
import common.IDataFacede;
import common.ILogicFacade;
import common.IUI;
import data.DataFacade;
import logik.LogikFacade;

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
        System.out.println("Group 17");
        
        IUI ui = new ConsoleUI();
        ILogicFacade logic = new LogikFacade();
        IDataFacede data = new DataFacade();
        logic.addData(data);
        ui.addLogic(logic);  
        ui.Start();
        
//        SQLHandler sqlhandler = new SQLHandler();
//        System.out.println(sqlhandler.checkLogin("bo12345", "guest"));
        
    }
}
