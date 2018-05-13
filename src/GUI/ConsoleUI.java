package GUI;

import java.util.Scanner;

/**
 *
 * @author nikol
 */

public class ConsoleUI {
    
    private Scanner input = new Scanner(System.in);
    private int intInput;
    private String textInput;
    private String username = "test";
    private String password = "test";
    
    public String HELP = "\n" + "Press 1 to login." + "\n" + "Press 2 to get help." + "\n" + "Press 3 to quit." + "\n";
    
    public void menuUI() {
        System.out.println("1. Login");
        System.out.println("2. Help");
        System.out.println("3. Quit");
        
        intInput = input.nextInt();
        
        switch(intInput) {
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
        }
    }
}
