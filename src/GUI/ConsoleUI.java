package GUI;

import common.IAid;
import common.ICitizen;
import common.IJournal;
import common.ISystemUser;
import common.IUI;
import java.util.Collection;
import java.util.Scanner;
import common.ILogicFacade;
import common.IDataFacede;

/**
 *
 * @author nikol
 */

public class ConsoleUI implements IUI{
    private ILogicFacade logicHandler;
    private Scanner input = new Scanner(System.in);
    private int intInput;
    private String textInput;
    private String username = "";
    private String password = "";
    
    
    private final String HELP_START = "\nType 1 to login. you have to have a valid username and password"  
                       + "\n" + "Type 3 to quit. closes the application" + "\n";   
    private final String HELP_LOGIN = "\nEnter username og type back to "
                                + "go back to previus menu\n";
    private final String HELP_SYSTEM = "\nwelcome to Sensum Udred";
    public ConsoleUI(){
    }
    private void LoginMenu() {     
        
        intInput = -1;
        while (intInput!= 3) {   // while user imput is not 3 continue loop
            System.out.println(HELP_START);                                              
            intInput = input.nextInt();
            switch(intInput) {
                case 1:
                    if(tryLogin()){
                        SystemMenu();
                    }
                    break;                
                case 3:                                                         
                    System.out.println("Quitting application.");
                    //System.exit(1);
                    break;                
                default:
                    System.out.println("Entered selection invalid. Select an option by entering a number 1 or 3.");
                    break;
            }
        }
    }
    private void SystemMenu(){
              System.out.println(HELP_SYSTEM); 
              intInput = input.nextInt();
        
        switch(intInput) {
            case 1:
                                
                break;
                
            case 2:
                System.out.println(HELP_START);                
                LoginMenu();
                break;
                
            case 3:
                System.out.println("Quitting application.");
                System.exit(1);
                break;
                
            default:
                System.out.println("Entered selection invalid. Select an option by entering a number 1-3.");
                LoginMenu();
                break;
        }
    }
    private void JournalMenu(){
        System.out.println("type a nummer to :");
        System.out.println("1. Login");
        System.out.println("2. Help");
        System.out.println("3. Quit");
        
        intInput = input.nextInt();
        
        switch(intInput) {
            case 1:
                                
                break;
                
            case 2:
                System.out.println(HELP_START);                
                LoginMenu();
                break;
                
            case 3:
                System.out.println("Quitting application.");
                System.exit(1);
                break;
                
            default:
                System.out.println("Entered selection invalid. Select an option by entering a number 1-3.");
                LoginMenu();
                break;
        }
    }
    private boolean tryLogin(){       
        boolean correctUser;
        
        System.out.println(HELP_LOGIN);
        System.out.println("Enter Username:");
        username = input.next();
        if(username.equalsIgnoreCase("back")){return false;}
        System.out.println("Enter password");
        password = input.next();           
        if(logicHandler.login(username, password))
        {
            return true;
        }        
        System.out.println("Incorrect username. Returning to menu.");
        return false;                                
    }
    private ICitizen getCitizen(int ssn){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    private IJournal getJournal(int journalno){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    } 
    private IAid getAid(int aidno){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    }
    private Collection<ICitizen> getCitizens(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    }
    private Collection<IJournal> getJournals(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    }
    private Collection<IAid> getAids(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    }
    private boolean changeSystemUser(ISystemUser isu){        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void addLogic(ILogicFacade logic){
        this.logicHandler=logic;
    }
    @Override
    public void Start() {this.LoginMenu(); }
    
}
