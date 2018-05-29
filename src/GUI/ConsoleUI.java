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
            + "Tast 1 for at logge ind. Du skal indtaste et valid brugernavn og adgangskode\n"
            + "Tast 0 for at lukke programmet.\n";
    private final String HELP_LOGIN = "\nSENSUM UDRED LOGIN\n"
            + "----------------------------------------------";
    private final String HELP_SYSTEM = "\nSENSUM UDRED SYSTEM MENU\n"
            + "----------------------------------------------\n"
            + "Tast 1 for at tilgå sags menuen \n"
            + "\n"
            + "Tast 2 for at liste alle Borger \n"
            + "Tast 3 for at liste alle journaler \n"
            + "\n"
            + "Tast 4 for at liste alle ydelser \n"
            + "Tast 5 for at tilføje en ny ydelse          Not Implamentet\n"
            + "Tast 6 for at redigerer en ydelse             Not Implamentet\n"
            + "\n"
            + "Tast 7 for at tilføje en ny system bruger  Not Implamentet\n"
            + "Tast 8 for at redigerer en system bruger   Not Implamentet\n"
            + "Tast 0 for at logge ud \n";
    private final String HELP_JOURNAL = "\nJOURNALS MENU\n"
            + "----------------------------------------------\n"
            + "Tast 1 for at tilgå en borger \n"
            + "Tast 3 for at redigerer en sag \n"
            + "Tast 4 for at se informationer om en sag\n"
            + "Tast 6 for at redigerer en borgers oplysninger \n"
            + "Tast 7 for at se en borgers oplysninger \n"
            + "Tast 0 for at komme tilbage til hoved menuen \n";

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
            System.out.print("Bruger input: ");
            String s = "";
            s = input.nextLine();
            switch (s.toLowerCase().charAt(0)) {
                case 'y':
                    return true;
                case 'n':
                    return false;
                default:
                    System.out.println("Ikke et rigtig input");
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
            System.out.print("Bruger input: ");
            i = getNumberInput();
            switch (i) {
                case 1:
                    if (tryLogin()) {
                        systemMenu();
                    }
                    break;
                case 0:
                    System.out.println("Lukker programmet.");
                    //System.exit(1);
                    break;
                default:
                    System.out.println("Det intastet input er ikke valid. Brug enten 1 eller 0");
                    break;
            }

        }
        //System.out.println("Retur line."); //Tron Ref.
    }

    private void systemMenu() {
        int i = -1;
        while (i != 0) {
            System.out.println(HELP_SYSTEM);
            System.out.print("Bruger input: ");
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
                    System.out.println("logger ud");
                    break;
                default:
                    System.out.println("Det intastet input er ikke valid. Indtast et af de viste numre");
                    break;
            }
            //System.out.println("Return line.");
        }
    }

    private void journalMenu() {
        int i = -1;
        int id = -1;
        int ssn = -1;
        while (i != 0) {
            System.out.println(HELP_JOURNAL);
            System.out.print("Bruger input : ");
            i = getNumberInput();
            switch (i) {
                case 1:
                    citizenFlow();
                    break;
                case 3:
                    cmdBreak();
                    listJournals();
                    cmdBreak();
                    System.out.print("Indtast ID på den journal som du ønsker at arbejde med: ");
                    id = getNumberInput();
                    logicHandler.getJournal(id);
                    if (logicHandler.getActiveJournal() != null) {
                        System.out.println("Journal hentet");
                        logicHandler.openJournalDiscription();
                    } else {
                        System.out.println("Fandt ikke den ønskede journal");
                    }
                    break;
                case 4:
                    cmdBreak();
                    listJournals();
                    cmdBreak();

                    System.out.print("Indtast ID på den journal som du ønsker at se: ");
                    id = getNumberInput();
                    logicHandler.getJournal(id);
                    IJournal j = logicHandler.getActiveJournal();
                    if (j != null) {
                        System.out.println("Journal nr           : " + j.getJNO());
                        System.out.println("Journal lokation     : " + j.getJournalLocation());
                        System.out.println("Tilknyttet borger    : " + j.getCitizen());
                    } else {
                        System.out.println("Fandt ikke den ønskede journal");
                    }
                case 6:
                    cmdBreak();
                    listCitizens();
                    cmdBreak();

                    System.out.print("Indtast et CPR nr på en borger: ");
                    ssn = getNumberInput();
                    if (logicHandler.citizenExist(ssn)) {
                        logicHandler.getCitizen(ssn);
                        ICitizen c = logicHandler.getActiveCitizen();
                        System.out.println("(Brug det samme som før, så lad feltet være blank)");
                        System.out.println("CPR : " + c.getSSN() + " kan ikke ændres: ");
                        System.out.print("Fornavn : " + c.getFirstName() + " \nÆndres til : ");
                        String fname = input.nextLine();
                        System.out.print("Efternavn : " + c.getLastName() + "\nÆndres til : ");
                        String lname = input.nextLine();
                        System.out.print("Telefon nummer : " + c.getPhoneNumber() + "\nÆndres til : ");
                        int phonenumber = getNumberInput();
                        System.out.print("Addresse : " + c.getAddress() + "\nÆndres til : ");
                        String address = input.nextLine();
                        System.out.print("By : " + c.getCity() + "\nÆndres til : ");
                        String city = input.nextLine();
                        System.out.print("Post nummer : " + c.getPostalNumber() + "\nÆndres til : ");
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
                        System.out.println("Gem borger information? y/n");
                        if (getBooleanInput()) {
                            logicHandler.saveCitizen();
                        }
                    } else {
                        System.out.println("Fandt ikke den ønskede borger");
                    }
                    break;
                case 7:
                    cmdBreak();
                    listCitizens();
                    cmdBreak();
                    System.out.print("Indtast venligtest et CPR nummer for en borger : ");
                    ssn = getNumberInput();
                    if (logicHandler.citizenExist(ssn)) {
                        logicHandler.getCitizen(ssn);
                        listinfo(logicHandler.getActiveCitizen());
                    } else {
                        System.out.println("Fandt ikke den ønskede borger");
                    }

                case 0:
                    // does nothing.
                    break;
                default:
                    System.out.println("Det intastet input er ikke valid. Indtast et af de viste numre");
                    break;
            }
            // System.out.println("Return line.");
        }
    }

    private void citizenFlow() {
        cmdBreak();
        System.out.print("Indtast venligtest et CPR nummer for en borger : ");
        int ssn = getNumberInput();
        if (ssn == -1) {
            return;
        }
        if (!logicHandler.citizenExist(ssn)) {
            cmdBreak();
            System.out.println("Ingen borger fundet. Vil du oprette en ny borger i systemet ? y/n");
            if (getBooleanInput()) {
                cmdBreak();
                addCitizen(ssn);
                cmdBreak();
            } else {
                return;
            }
        }
        logicHandler.getCitizen(ssn);
        ICitizen citizen = logicHandler.getActiveCitizen();

        System.out.println("Bekraft borger, " + citizen.getFirstName() + " " + citizen.getLastName() + " "
                + "med CPR nr : " + citizen.getSSN() + "? y/n");
        if (getBooleanInput()) {
            Collection<Integer> journals = logicHandler.getAllJournalsFor(ssn);
            if (journals.isEmpty()) {
                System.out.println("Ingen journaller fundet, opretter en ny.");
                logicHandler.newJournal();
                logicHandler.openJournalDiscription();
            } else {
                cmdBreak();
                System.out.println("Lister journaler for borgeren med CPR nr: " + ssn);
                for (int ID : journals) {

                    System.out.println("ID : " + ID);
                }
                cmdBreak();

                System.out.println("Vil du åbne borgerens journal ? y/n");
                if (getBooleanInput()) {
                    System.out.print("Indtast ID på den journal du ønsker at arbejde på: ");
                    int IDrespons = getNumberInput();
                    for (int ID : journals) {
                        if (ID == IDrespons) {
                            System.out.println("Henter journal");
                            logicHandler.getJournal(IDrespons);
                        }
                    }
                } else {
                    System.out.println("Vil du tilføje en ny journal ? y/n");
                    if (getBooleanInput()) {
                        System.out.println("Oprette ny journal for:" + citizen.getSSN());
                        logicHandler.newJournal();
                        logicHandler.addJournal();
                    }
                }
                if (logicHandler.getActiveJournal() != null) {
                    logicHandler.openJournalDiscription();
                } else {
                    System.out.println("Kan ikke lokalisere journal");
                }
            }
        }
    }

    private boolean tryLogin() {
        System.out.println(HELP_LOGIN);
        System.out.print("Indtast brugernavn : ");
        String username = input.nextLine();
        System.out.print("Indtast password   : ");
        String password = input.nextLine();
        if (logicHandler.login(username, password)) {
            return true;
        }
        System.out.println("Forkert burgernavn. Retunerer til menuen");
        return false;
    }

    private void listCitizens() {
        Collection<ICitizen> listCitizens = getCitizens();
        System.out.println("Fandt : " + listCitizens.size() + " borgere");
        System.out.println("-------------------------------------------");
        for (ICitizen c : listCitizens) {
            System.out.println(c.getFirstName() + " : CPR " + c.getSSN());
        }
    }

    private void listJournals() {
        Collection<IJournal> list = getJournals();
        System.out.println("Fandt : " + list.size() + " journaler");
        System.out.println("-------------------------------------------");
        for (IJournal c : list) {
            System.out.println("ID :" + c.getJNO());
        }
    }

    private void listAids() {
        Collection<IAid> list = getAids();
        System.out.println("Fandt : " + list.size() + " ydelser");
        System.out.println("-------------------------------------------");
        for (IAid c : list) {
            System.out.println("Navn: \t" + c.getAidName() + "\t Beskrivelse: " + c.getAidDescribsion() + "\t ID: " + c.getAidNo());
        }
    }

    private void listinfo(ICitizen c) {
        System.out.println("CPR : " + c.getSSN());
        System.out.println("Fornavn : " + c.getFirstName());
        System.out.println("Efternavn : " + c.getLastName());
        System.out.println("Telefon nummer : " + c.getPhoneNumber());
        System.out.println("Addresse : " + c.getAddress());
        System.out.println("By : " + c.getCity());
        System.out.println("Post nummer : " + c.getPostalNumber());
    }

    /*--------------------------------------------------------------------------
    Data Related
    --------------------------------------------------------------------------*/
    private void addCitizen(int ssn) {
        logicHandler.newCitizen();
        ICitizen citizen = logicHandler.getActiveCitizen();
        System.out.println("CPR : " + ssn);
        System.out.print("Fornavn : ");
        String fname = input.nextLine();
        System.out.print("Efternavn: ");
        String lname = input.nextLine();
        System.out.print("Telefon nummer : ");
        int phonenumber = getNumberInput();
        System.out.print("Addresse : ");
        String address = input.nextLine();
        System.out.print("By : ");
        String city = input.nextLine();
        System.out.print("Post nummer : ");
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
