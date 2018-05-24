package starter;

import data.SQLHandler;
import data.postgreSQLCom;

import GUI.ConsoleUI;
import common.IDataFacede;
import common.ILogicFacade;
import common.IUI;
import data.DataFacade;
import logic.LogicFacade;

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
        //tester.test();
        
        System.out.println("Gruppe 17");
        IUI ui = new ConsoleUI();
        ILogicFacade logic = new LogicFacade();
        IDataFacede data = new DataFacade();
        logic.setDataHandler(data);
        ui.addLogic(logic);  
        ui.Start();        
        
//        SQLHandler sqlhandler = new SQLHandler();
//        System.out.println(sqlhandler.checkLogin("bo12345", "guest"));
        
    }
}
