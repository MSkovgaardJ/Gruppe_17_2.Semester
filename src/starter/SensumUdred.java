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
<<<<<<< HEAD
        System.out.println("Group 17 is awesome");
        System.out.println("Look at me i'm mr missis");
        
        SQLHandler sqlhandler = new SQLHandler();
        System.out.println(sqlhandler.checkLogin("bo12345", "guest"));
        
        ConsoleUI cUI = new ConsoleUI();
        cUI.menuUI();
=======
        System.out.println("Group 17");
        
        IUI ui = new ConsoleUI();
        ILogicFacade logic = new LogikFacade();
        IDataFacede data = new DataFacade();
        logic.addData(data);
        ui.addLogic(logic);  
        ui.Start();
        
//        SQLHandler sqlhandler = new SQLHandler();
//        System.out.println(sqlhandler.checkLogin("bo12345", "guest"));
        
>>>>>>> UI
    }
}
