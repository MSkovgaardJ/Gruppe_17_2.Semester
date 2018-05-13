package GUI;

import common.IAid;
import common.ICitizen;
import common.IJournal;
import common.ISystemUser;
import common.IUI;
import java.util.Collection;
import java.util.Scanner;
import common.IDataFaceda;

/**
 *
 * @author nikol
 */

public class ConsoleUI implements IUI{
    private IDataFaceda dataHandler;
    private Scanner input = new Scanner(System.in);
    private int intInput;
    private String textInput;
    private String username = "";
    private String password = "";
    
    public String HELP = "\n" + "Press 1 to login. you have to have a valid username and password" 
                       + "\n" + "Press 2 to get help. it basicly just means this message" 
                       + "\n" + "Press 3 to quit. closes the application" + "\n";    
    private void LoginMenu() {
        System.out.println("type a nummer to :");
        System.out.println("1. Login");
        System.out.println("2. Help");
        System.out.println("3. Quit");
        
        intInput = input.nextInt();
        
        switch(intInput) {
            case 1:
                                
                break;
                
            case 2:
                System.out.println(HELP);                
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
    private void SystemMenu(){
        System.out.println("type a nummer to :");
        System.out.println("1. Login");
        System.out.println("2. Help");
        System.out.println("3. Quit");
        
        intInput = input.nextInt();
        
        switch(intInput) {
            case 1:
                                
                break;
                
            case 2:
                System.out.println(HELP);                
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
                System.out.println(HELP);                
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
    public boolean tryLogin(){
        System.out.println("Enter Username:");
        this.username = input.next();
        System.out.println("Enter password");
        this.password = input.next();   

        if(textInput.equals(username) && textInput.equals(password)) {
            System.out.println("Successfully logged in.");
            // Make call to the next part of the system.
        } 
        else {                    
            System.out.println("Incorrect username. Returning to menu.");
            LoginMenu();
        }
                    
    }
    public ICitizen getCitizen(int ssn){
        
    }
    public IJournal getJournal(int journalno){
        
    }
    public void setDataHandler(IDataFaceda dataHandler){
        this.dataHandler = dataHandler;
    }  
    public IAid getAid(int aidno){
        
    }
    public Collection<ICitizen> getCitizens(){
        
    }
    public Collection<IJournal> getJournals(){
        
    }
    public Collection<IAid> getAids(){
        
    }
    public boolean changeSystemUser(ISystemUser isu){
        
    }
    
}
