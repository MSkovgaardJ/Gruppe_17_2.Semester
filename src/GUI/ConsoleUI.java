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
            + "type 2 to list all citizens      DONE\n"
            + "Type 3 to list all journals      DONE\n"
            + "\n"
            + "Type 4 to list all Aid           DONE\n"
            + "Type 5 to add a new Aid          Not Implamentet\n"
            + "Type 6 to edit a Aid             Not Implamentet\n"
            + "\n"
            + "Type 7 to add a new System User  Not Implamentet\n"
            + "Type 8 to edit a System User     Not Implamentet\n"
            + "Type 0 to logout                 NOT DONE\n";
    private final String HELP_JOURNAL = "\nJOURNALS MENU\n"
            + "----------------------------------------------\n"
            + "Type 1 to open a journal         NOT DONE\n"
            + "Type 2 to edit a journal         NOT DONE\n"
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
        input.next(); // clears the scanner.
        String s = "";
        try {
            s = input.nextLine();
        } catch (Exception e) {
            input.next(); // cleares the scanner for wrongfull input / prevents loop
        }
        return s;

    }
    private void cmdBreak()
    {
        System.out.println("----------------------------------------------");
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
        while (i != 0) {
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
        int i = getNumberInput();
        while (i != 0) {
            System.out.println("Type SSN of Citizen");
            int ssn = getNumberInput();
            // ICitizen citizen = getCitizen(ssn);
            if (logicHandler.findCitizen(ssn)) {           
                System.out.println(getCitizen(ssn).getFirstName() + getCitizen(ssn).getLastName());           
            } else {
                System.out.println("no citizen found, adding a new on now");
                cmdBreak();
                addCitizen(); }
            IJournal journal = null;
            Collection<IJournal> journals = logicHandler.getAllJournalsFor(ssn);
            cmdBreak();
            System.out.println("Listing journals for: "+ ssn);
            for (IJournal j : journals) {
   
                System.out.println("ID : " + j.getID());
            }
            System.out.print("Do you want to make a new journal for the citizan ? y/n");
            String respons = getStringInput();
            if (respons.contains("y")) {

            } else {
                System.out.print("Type ID of journal you want to work on: ");
                int IDrespons = getNumberInput();
                for (IJournal jj : journals) {
                    if (jj.getID() == IDrespons) {
                        journal = jj;
                    }
                }
                if (journal != null) {
                    System.out.println("Loaded journal");
                }
                //Open journal word ark
            }
            System.out.println("Return line.");
        }
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

    private void listAids() {
        Collection<IAid> list = getAids();
        System.out.println("got : " + list.size() + " Aid's");
        System.out.println("-------------------------------------------");
        for (IAid c : list) {
            System.out.println("Name: \t" + c.getAidName() + "\t Decription: " + c.getAidDescribsion() + "\t ID: " + c.getAidNo());
        }
    }

    /*--------------------------------------------------------------------------
    Data Related
    --------------------------------------------------------------------------*/
    private ICitizen getCitizen(int ssn) {
        return logicHandler.getCitizen(ssn);
    }

    private void addCitizen() {
        ICitizen citizen = logicHandler.newCitizen();
        System.out.print("SSN : ");
        int ssn = getNumberInput();
        System.out.print("First name : ");
        String fname = getStringInput();
        System.out.print("Type last name : ");
        String lname = getStringInput();
        System.out.print("Type phone number : ");
        String phonenumber = getStringInput();
        System.out.print("Type address : ");
        String address = getStringInput();
        System.out.print("Type city : ");
        String city = getStringInput();
        System.out.print("Type postal address : ");
        int postalNumber = getNumberInput();
        citizen.setAddress(address);
        citizen.setCity(city);
        citizen.setFirstName(fname);
        citizen.setLastName(lname);
        citizen.setSSN(ssn);
        citizen.setPhoneNumber(phonenumber);
        citizen.setPostalNumber(postalNumber);
        logicHandler.addCitizen(citizen);
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
