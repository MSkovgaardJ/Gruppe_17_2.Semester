package GUI;

import common.IAid;
import common.ICitizen;
import common.IJournal;
import common.IUI;
import java.util.Collection;
import java.util.Scanner;
import common.ILogicFacade;
import common.IDataFacede;
import common.ISystemUser;
import java.util.InputMismatchException;

/**
 *
 * @author nikol
 */
public class ConsoleUI implements IUI {

    private Scanner input = new Scanner(System.in);    
    private String username = "test";
    private String password = "test";
    private ILogicFacade logicHandler;
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
    /*--------------------------------------------------------------------------
    UI Related
    --------------------------------------------------------------------------*/
    /**
     * added to make sure input is allways correctly formattet
     * @return -1 if faulty number.
     */
    private int getNumberInput()
    {
        int i = -1;
        try{            
          
             i = input.nextInt();
        }
        catch(InputMismatchException e)
        {
             input.next(); // cleares the scanner for wrongfull input / prevents loop
        }
        return i;
    }
    private void startMenu() {
        int i = -1;
        while (i != 3) {   // while user imput is not 3 continue loop
            System.out.println(HELP_START);
            i = getNumberInput();
            switch (i) {
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
        int i = -1;
        while (i != 9) {
            System.out.println(HELP_SYSTEM);
            i= getNumberInput();
            switch (i) {
                case 1:
                    journalMenu();
                    break;
                case 2:
                    Collection<ICitizen> listCitizens = getCitizens();
                    for (ICitizen c :listCitizens ) {
                        System.out.println(c.getFirstName() + " : SSN " + c.getSSN());
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
        }
    }

    private void journalMenu() {
        System.out.println(HELP_JOURNAL);
        System.out.println("Type SSN of Citizen");
        int intInput = input.nextInt();
        ICitizen citizen = getCitizen(intInput);
        if (citizen != null) {

        } else {

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

    private void addCitizen() {

    }

    private IJournal getJournal(int journalno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    }

    private IAid getAid(int aidNo) {
        return logicHandler.getAid(aidNo);
    }

    private Collection<ICitizen> getCitizens() {
        return logicHandler.getCitizens();
    }

    private Collection<IJournal> getJournals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    }

    private Collection<IAid> getAids() {
        return logicHandler.getAids();
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
