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
public class ConsoleUI implements IUI {

<<<<<<< HEAD
public class ConsoleUI
{
    private Scanner input = new Scanner(System.in);
    private int intInput;
    private String textInput;
    private String username = "test";
    private String password = "test";

    public String HELP = "\n" + "Press 1 to login." + "\n" + "Press 2 to get help." + "\n" + "Press 3 to quit." + "\n";
    
    public void menuUI()
    {
        System.out.println("1. Login");
        System.out.println("2. Help");
        System.out.println("3. Quit");
        
        intInput = input.nextInt();
        
        switch(intInput)
        {
            case 1:
                System.out.println("Enter Username:");
                textInput = input.next();
                System.out.println("Enter password");
                textInput = input.next();
                
                if(textInput.equals(username) && textInput.equals(password)) {
                    System.out.println("Successfully logged in.");
                    // Make call to the next part of the system.
                    
                } else {
                    
                    System.out.println("Incorrect username. Returning to menu.");
                    menuUI();
                }
                
                break;
                
            case 2:
                System.out.println(HELP);
                
                menuUI();
                
                break;
                
            case 3:
                System.out.println("Quitting application.");
                System.exit(1);
                
                break;
                
            default:
                System.out.println("Entered selection invalid. Select an option by entering a number 1-3.");
                menuUI();
                
                break;
=======
    private ILogicFacade logicHandler;
    private Scanner input = new Scanner(System.in);
    private int intInput;
    private String textInput;
    private String username = "";
    private String password = "";
    private final String HELP_START = "\nType 1 to login. you have to have a valid username and password"
            + "\n" + "Type 3 to quit. closes the application" + "\n";
    private final String HELP_LOGIN = "\nEnter username and password to login";
    private final String HELP_SYSTEM = "\nwelcome to Sensum Udred\n"
            + "Type 1 to start a case\n"
            + "type 2 to list all cases\n"
            + "Type 3 to edit a case\n"
            + "\n"
            + "Type 8 to edit a System User\n"
            + "Type 9 to log out";
    private final String HELP_JOURNAL = "\nJOURNALS\n";

    public ConsoleUI() {
    }

    private void startMenu() {

        intInput = -1;
        while (intInput != 3) {   // while user imput is not 3 continue loop
            System.out.println(HELP_START);
            intInput = input.nextInt();
            switch (intInput) {
                case 1:
                    if (tryLogin()) {
                        systemMenu();
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

    private void systemMenu() {
        System.out.println(HELP_SYSTEM);
        intInput = input.nextInt();
        while (intInput != 9) {
            switch (intInput) {
                case 1:
                    journalMenu();
                    break;
                case 2:
                    for(ICitizen c : getCitizens())
                    {
                        System.out.println(c.getFirstName()+ " : SSN "+ c.getSSN());
                    }
                    break;
                case 3:
                    break;
                case 9:
                    System.out.println("loging out");
                    break;
                default:
                    System.out.println("Entered selection invalid. Select an option by entering a number");
                    break;
            }
>>>>>>> UI
        }
    }

    private void journalMenu() {
        System.out.println(HELP_JOURNAL);

        System.out.println("Type SSN of Citizen");
        intInput = input.nextInt();
        ICitizen citizen = getCitizen(intInput);
        if(citizen != null){
            
        }
        else 
        {
            
        }
    }

    private boolean tryLogin() {
        boolean correctUser;
        System.out.println(HELP_LOGIN);
        System.out.println("Enter Username:");
        username = input.next();
        System.out.println("Enter password");
        password = input.next();
        if (logicHandler.login(username, password)) {
            return true;
        }
        System.out.println("Incorrect username. Returning to menu.");
        return false;
    }

    private ICitizen getCitizen(int ssn) {
        return logicHandler.getCitizen(ssn);
    }
    private void addCitizen()
    {
        
    }

    private IJournal getJournal(int journalno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    }

    private IAid getAid(int aidno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    }

    private Collection<ICitizen> getCitizens() {return logicHandler.getCitizens();}

    private Collection<IJournal> getJournals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    }

    private Collection<IAid> getAids() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    }

    private boolean changeSystemUser(ISystemUser isu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addLogic(ILogicFacade logic) {
        this.logicHandler = logic;
    }

    @Override
    public void Start() {
        this.startMenu();
    }
}
