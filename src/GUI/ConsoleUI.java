package GUI;

import com.sun.org.apache.bcel.internal.generic.IADD;
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
import logic.Journal;

/**
 *
 * @author nikol
 */
public class ConsoleUI implements IUI {

    private final Scanner input = new Scanner(System.in);
    private ILogicFacade logicHandler;
    private final String HELP_START = "\nSENSUM UDRED\n"
            + "----------------------------------------------\n"
            + "Type 1 to login. you have to have a valid username and password\n"
            + "Type 0 to quit. closes the application" + "\n";
    private final String HELP_LOGIN = "\nSENSUM UDRED LOGIN\n"
            + "----------------------------------------------";
    private final String HELP_SYSTEM = "\nSENSUM UDRED SYSTEM MENU\n"
            + "----------------------------------------------\n"
            + "Type 1 to enter a journal menu   NOT DONE\n"
            + "\n"
            + "type 2 to list all citizens          DONE\n"
            + "Type 3 to list all journals          DONE\n"
            + "\n"
            + "Type 4 to list all Aid               DONE\n"
            + "Type 5 to add a new Aid          NOT DONE\n"
            + "Type 6 to edit a Aid             NOT DONE\n"
            + "\n"
            + "Type 7 to add a new System User  NOT DONE\n"
            + "Type 8 to edit a System User     NOT DONE\n"
            + "Type 0 to logout                 NOT DONE\n";
    private final String HELP_JOURNAL = "\nJOURNALS MENU\n"
            + "Type 0 to return to system       NOT DONE\n";

    /*--------------------------------------------------------------------------
    UI Related
    --------------------------------------------------------------------------*/
    /**
     * added to make sure input is allways correctly formattet
     *
     * @return -1 if faulty number.
     */
    private int getNumberInput() {
        int i = -1;
        System.out.print("input: ");
        try {

            i = input.nextInt();
        } catch (InputMismatchException e) {
            input.next(); // cleares the scanner for wrongfull input / prevents loop
        }
        return i;
    }
    private String getStringInput() {
        String s = "";
        System.out.print("input: ");
        try {
            s = input.nextLine();
        } catch (Exception e) {
            input.next(); // cleares the scanner for wrongfull input / prevents loop
        }
        return s;

    }
    private void startMenu() {
        int i = -1;
        while (i != 0) {   // while user imput is not 3 continue loop
            System.out.println(HELP_START);
            i = getNumberInput();
            switch (i) {
                case 1:
                    if (tryLogin()) {
                        systemMenu();
                    }
                    break;
                case 0:
                    System.out.println("Quitting application.");
                    //System.exit(1);
                    break;
                default:
                    System.out.println("Entered selection invalid. Select an option by entering a number 1 or 3.");
                    break;
            }

        }
        System.out.println("Return line."); //Tron Ref.
    }
    private void systemMenu() {
        int i = -1;
        while (i != 9) {
            System.out.println(HELP_SYSTEM);
            i = getNumberInput();
            switch (i) {
                case 1:
                    // Journals menu
                    journalMenu();
                    break;
                case 2:
                    // List citizen's
                    listCitizens();
                    break;
                case 3:
                    // List journal's
                    listJournals();
                    break;
                case 4:
                    // list Aid
                    listAids();
                    break;
                case 5:
                    // add aid
                    break;
                case 6:
                    // edit aid
                    break;
                case 7:
                    // Edit System user
                    break;
                case 8:
                    // System user menu
                    break;
                case 0:
                    logicHandler.logout();
                    System.out.println("loging out");
                    break;
                default:
                    System.out.println("Entered selection invalid. Select an option by entering a number");
                    break;
            }
            System.out.println("Return line.");
        }
    }
    private void journalMenu() {
        System.out.println(HELP_JOURNAL);
        System.out.println("Type SSN of Citizen");
        int ssn = getNumberInput();
        ICitizen citizen = getCitizen(ssn);
        if (citizen.getSSN() == -1) {
            System.out.println("no citizen found, adding a new on now");
            System.out.println("Type first name");
            String fname = getStringInput();
            System.out.println("Type last name");
            String lname = getStringInput();
            System.out.println("Type phone number");
            String phonenumber = getStringInput();
            System.out.println("Type address");
            String address = getStringInput();
            System.out.println("Type city");
            String city = getStringInput();
            System.out.println("Type postal address");
            int postalNumber = getNumberInput();

            citizen.setAddress(address);
            citizen.setCity(city);
            citizen.setFirstName(fname);
            citizen.setLastName(lname);
            citizen.setSSN(ssn);
            citizen.setPhoneNumber(phonenumber);
            citizen.setPostalNumber(postalNumber);

            addCitizen(citizen);
        }
        IJournal journal = logicHandler.newJournal();
        System.out.println("Listing journals:");
        Collection<IJournal> journals = logicHandler.getAllJournalsFor(ssn);
        for (IJournal j : journals) {
            System.out.println("ID : " + j.getID());
        }

        System.out.println("Return line.");
    }
    private boolean tryLogin() {
        System.out.println(HELP_LOGIN);
        System.out.print("Enter Username: ");
        String username = input.next();
        System.out.print("Enter password: ");
        String password = input.next();
        System.out.println("");
        if (logicHandler.login(username, password)) {
            return true;
        }
        System.out.println("Incorrect username. Returning to menu.");
        return false;
    }
    private void listCitizens() {
        Collection<ICitizen> listCitizens = getCitizens();
        System.out.println("got : " + listCitizens.size() + " Citizen's");
        System.out.println("-------------------------------------------");
        for (ICitizen c : listCitizens) {
            System.out.println(c.getFirstName() + " : SSN " + c.getSSN());
        }
    }
    private void listJournals() {
        Collection<IJournal> list = getJournals();
        System.out.println("got : " + list.size() + " journals's");
        System.out.println("-------------------------------------------");
        for (IJournal c : list) {
            System.out.println("ID :" + c.getID());
        }
    }
    private void listAids()
    {
        Collection<IAid> list = getAids();
        System.out.println("got : " + list.size() + " Aid's");
        System.out.println("-------------------------------------------");
        for (IAid c : list) {
            System.out.println("Name: " + c.getAidName()+" Decription: "+c.getAidDescribsion());
        }
    }
    /*--------------------------------------------------------------------------
    Data Related
    --------------------------------------------------------------------------*/
    private ICitizen getCitizen(int ssn) {
        return logicHandler.getCitizen(ssn);
    }

    private void addCitizen(ICitizen citizen) {
        logicHandler.addCitizen(citizen);
    }

    private IJournal getJournal(int journalno) {
        return logicHandler.getJournal(journalno);
    }

    private IAid getAid(int aidNo) {
        return logicHandler.getAid(aidNo);
    }

    private Collection<ICitizen> getCitizens() {
        return logicHandler.getCitizens();
    }

    private Collection<IJournal> getJournals() {
        return logicHandler.getJournals();
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
