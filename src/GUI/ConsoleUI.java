package GUI;

import com.sun.org.apache.bcel.internal.generic.IADD;
import common.IAid;
import common.ICitizen;
import common.IJournal;
import common.IUI;
import java.util.Collection;
import java.util.Scanner;
import common.ILogicFacade;
import common.ISystemUser;

/**
 *
 * @author nikol
 */
public class ConsoleUI implements IUI {

    private Scanner input;
    private ILogicFacade logicHandler;
    private final String HELP_START = "\nSENSUM UDRED\n"
            + "----------------------------------------------\n"
            + "Type 1 to login. you have to have a valid username and password\n"
            + "Type 0 to quit. closes the application" + "\n";
    private final String HELP_LOGIN = "\nSENSUM UDRED LOGIN\n"
            + "----------------------------------------------";
    private final String HELP_SYSTEM = "\nSENSUM UDRED SYSTEM MENU\n"
            + "----------------------------------------------\n"
            + "Type 1 to enter a Journal menu   DONE\n"
            + "\n"
            + "type 2 to list all Citizens      DONE\n"
            + "Type 3 to list all Journals      DONE\n"
            + "\n"
            + "Type 4 to list all Aid           DONE\n"
            + "Type 5 to add a new Aid          Not Implamentet\n"
            + "Type 6 to edit a Aid             Not Implamentet\n"
            + "\n"
            + "Type 7 to add a new System User  Not Implamentet\n"
            + "Type 8 to edit a System User     Not Implamentet\n"
            + "Type 0 to Logout                 DONE\n";
    private final String HELP_JOURNAL = "\nJOURNALS MENU\n"
            + "----------------------------------------------\n"
            + "Type 1 to enter Citizen flow     DONE\n"
            + "Type 3 to edit a Journal         DONE\n"
            + "Type 4 to view a Journals info   DONE\n"
            + "Type 6 to edit a Citizen         DONE\n"
            + "Type 7 to view a Citizen         DONE\n"
            + "Type 0 to return to system       DONE\n";

    public ConsoleUI() {
        this.input = new Scanner(System.in);
    }

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
        String s = input.nextLine();
        try {
            if (!s.isEmpty()) {
                i = Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            //System.out.println("not a int return -1");
            //input.nextLine(); // cleares the scanner for wrongfull input / prevents loop
        }
        return i;
    }
    private boolean getBooleanInput() {
        while (true) {
            System.out.print("Input : ");
            String s = "";
            s = input.nextLine();
            switch (s.toLowerCase().charAt(0)) {
                case 'y':
                    return true;
                case 'n':
                    return false;
                default:
                    System.out.println("Not valid input");
            }
        }
    }

    private void cmdBreak() {
        System.out.println("----------------------------------------------");
    }

    private void startMenu() {
        int i = -1;
        while (i != 0) {   // while user imput is not 3 continue loop
            System.out.println(HELP_START);
            System.out.print("Input : ");
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
            System.out.print("Input : ");
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
        int i = -1;
        int id = -1;
        int ssn = -1;
        while (i != 0) {
            System.out.println(HELP_JOURNAL);
            System.out.print("Input : ");
            i = getNumberInput();
            switch (i) {
                case 1:
                    citizenFlow();
                    break;
                case 3:
                    cmdBreak();
                    listJournals();
                    cmdBreak();

                    System.out.print("Type ID of journal you want to work on: ");
                    id = getNumberInput();
                    logicHandler.getJournal(id);
                    if(logicHandler.getActiveJournal()!= null))
                    System.out.println("Loaded journal");
                    logicHandler.openJournalDiscription();
                    break;
                case 4:
                    cmdBreak();
                    listJournals();
                    cmdBreak();

                    System.out.print("Type ID of journal you want to view: ");
                    id = getNumberInput();
                    IJournal j = logicHandler.getJournal(id);
                    System.out.println("Journal No           : " + j.getJNO());
                    System.out.println("Journal Location     : " + j.getJournalLocation());
                case 6:
                    cmdBreak();
                    listCitizens();
                    cmdBreak();

                    System.out.print("Please enter SSN of Citizen : ");
                    ssn = getNumberInput();
                    if (logicHandler.citizenExist(ssn)) {
                        ICitizen c = getCitizen(ssn);
                        System.out.println("(USE THE THE SAME AS BEFORE LEAVE FIELD BLANK)");
                        System.out.println("SSN : " + c.getSSN() + " cant be changed: ");
                        System.out.print("First name : " + c.getFirstName() + " \nChange to : ");
                        String fname = input.nextLine();
                        System.out.print("last name : " + c.getLastName() + "\nChange to : ");
                        String lname = input.nextLine();
                        System.out.print("phone number : " + c.getPhoneNumber() + "\nChange to : ");
                        int phonenumber = getNumberInput();
                        System.out.print("address : " + c.getAddress() + "\nChange to : ");
                        String address = input.nextLine();
                        System.out.print("city : " + c.getCity() + "\nChange to : ");
                        String city = input.nextLine();
                        System.out.print("postal address : " + c.getPostalNumber() + "\nChange to : ");
                        int postalNumber = getNumberInput();

                        if (!fname.isEmpty()) {
                            c.setFirstName(fname.trim());
                        }
                        if (!lname.isEmpty()) {
                            c.setLastName(lname.trim());
                        }
                        if (phonenumber != -1) {
                            c.setPhoneNumber(phonenumber);
                        }
                        if (!address.isEmpty()) {
                            c.setAddress(address.trim());
                        }
                        if (!city.isEmpty()) {
                            c.setCity(city.trim());
                        }
                        if (postalNumber != -1) {
                            c.setPostalNumber(postalNumber);
                        }
                        cmdBreak();
                        listinfo(c);
                        cmdBreak();
                        System.out.println("Save Citizen info? y/n");
                        if (getBooleanInput()) {
                            logicHandler.saveCitizen();
                        }
                    }
                    break;
                case 7:
                    cmdBreak();
                    listCitizens();
                    cmdBreak();
                    System.out.print("Please enter SSN of Citizen : ");
                    ssn = getNumberInput();
                    if (logicHandler.citizenExist(ssn)) {
                        getCitizen(ssn);
                        listinfo(logicHandler.getActiveCitizen());
                    }
                case 0:
                    // does nothing.
                    break;
                default:
                    System.out.println("Entered selection invalid. Select an option by entering a number");
                    break;
            }
            System.out.println("Return line.");
        }
    }

    private void citizenFlow() {
        ICitizen citizen = null;
        IJournal journal = null;
        cmdBreak();
        System.out.print("Please enter SSN of Citizen : ");
        int ssn = getNumberInput();
        if (ssn == -1) {
            return;
        }
        if (!logicHandler.citizenExist(ssn)) {
            cmdBreak();
            System.out.println("No citizen found, do you want to add a new citizen? y/n");
            if (getBooleanInput()) {
                cmdBreak();
                addCitizen(ssn);
                cmdBreak();
            } else {
                return;
            }
        }
        citizen = getCitizen(ssn);

        Collection<Integer> journals = logicHandler.getAllJournalsFor(ssn);
        if (journals.isEmpty()) {
            logicHandler.newJournal();
            logicHandler.openJournalDiscription();
        } else {
            cmdBreak();
            System.out.println("Listing journals for: " + ssn);
            for (int ID : journals) {

                System.out.println("ID : " + ID);
            }
            cmdBreak();
            System.out.println("Conferm Citicen, " + citizen.getFirstName() + " " + citizen.getLastName() + " "
                    + "with SSN : " + citizen.getSSN() + "? y/n");
            if (getBooleanInput()) {
                System.out.println("Do you wan't to open a journal ? y/n");
                if (getBooleanInput()) {
                    System.out.print("Type ID of journal you want to work on: ");
                    int IDrespons = getNumberInput();
                    for (int ID : journals) {
                        if (ID == IDrespons) {
                            journal = logicHandler.getJournal(IDrespons);
                        }
                    }
                    if (journal != null) {
                        System.out.println("Loaded journal");
                        logicHandler.openJournalDiscription();
                    }
                } else {
                    System.out.println("Do you wan't to add a new journal ? y/n");
                    if (getBooleanInput()) {

                        System.out.println("Creating new journal for :" + citizen.getSSN());
                        journal = logicHandler.newJournal();
                        if (journal != null) {
                            //System.out.println("ACT J :\n"+logicHandler.getActiveJournal());
                            //System.out.println("ACT C :\n"+logicHandler.getActiveCitizen());
                            logicHandler.openJournalDiscription();
                            logicHandler.addJournal();
                        }
                    }
                }
            }
        }
    }

    private boolean tryLogin() {
        System.out.println(HELP_LOGIN);
        System.out.print("Type Username: ");
        String username = input.nextLine();
        System.out.print("Type password: ");
        String password = input.nextLine();
        if (logicHandler.login(username, password)) {
            return true;
        }
        System.out.println("Incorrect username. Returning to menu.");
        return false;
    }

    private void listCitizens() {
        Collection<ICitizen> listCitizens = getCitizens();
        System.out.println("Got : " + listCitizens.size() + " Citizen's");
        System.out.println("-------------------------------------------");
        for (ICitizen c : listCitizens) {
            System.out.println(c.getFirstName() + " : SSN " + c.getSSN());
        }
    }

    private void listJournals() {
        Collection<IJournal> list = getJournals();
        System.out.println("Got : " + list.size() + " journals's");
        System.out.println("-------------------------------------------");
        for (IJournal c : list) {
            System.out.println("ID :" + c.getJNO());
        }
    }

    private void listAids() {
        Collection<IAid> list = getAids();
        System.out.println("Got : " + list.size() + " Aid's");
        System.out.println("-------------------------------------------");
        for (IAid c : list) {
            System.out.println("Name: \t" + c.getAidName() + "\t Decription: " + c.getAidDescribsion() + "\t ID: " + c.getAidNo());
        }
    }

    private void listinfo(ICitizen c) {
        System.out.println("SSN : " + c.getSSN());
        System.out.println("First name : " + c.getFirstName());
        System.out.println("Last name : " + c.getLastName());
        System.out.println("Phone number : " + c.getPhoneNumber());
        System.out.println("Address : " + c.getAddress());
        System.out.println("City : " + c.getCity());
        System.out.println("postal address : " + c.getPostalNumber());
    }

    /*--------------------------------------------------------------------------
    Data Related
    --------------------------------------------------------------------------*/
    private void addCitizen(int ssn) {
        ICitizen citizen = logicHandler.newCitizen();
        System.out.println("SSN : " + ssn);
        System.out.print("First name : ");
        String fname = input.nextLine();
        System.out.print("Last name : ");
        String lname = input.nextLine();
        System.out.print("Phone number : ");
        int phonenumber = getNumberInput();
        System.out.print("Address : ");
        String address = input.nextLine();
        System.out.print("City : ");
        String city = input.nextLine();
        System.out.print("Postal address : ");
        int postalNumber = getNumberInput();

        citizen.setAddress(address);
        citizen.setCity(city);
        citizen.setFirstName(fname);
        citizen.setLastName(lname);
        citizen.setSSN(ssn);
        citizen.setPhoneNumber(phonenumber);
        citizen.setPostalNumber(postalNumber);
        logicHandler.addCitizen();
    }

    private ICitizen getCitizen(int ssn) {
        return logicHandler.getCitizen(ssn);
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
