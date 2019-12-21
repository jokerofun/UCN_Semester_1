package tui;

/**
 * This class represents a main menu object, that prints out and handles the main menu of the program.
 * It calls the person menu, loan menu or DVD menu, depending on the choice of the user.
 *
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class MainMenu {
    // instance variables 
    private LoanMenu loanMenu;
    
    private PersonMenu personMenu;
    private DVDMenu dvdMenu;
 
    /**
     * Constructor for objects of MainMenu
     */
    public MainMenu() {
        
        // initialise instance variables
        personMenu =new PersonMenu();
        loanMenu = new LoanMenu();
        dvdMenu = new DVDMenu();
        
    }

    /**
     * Handles the calls of the different menus.
     */
    public void start() { 
        boolean exit=false;
        while (!exit) { //! means while exit not is true (that is: false)
            int choice = writeMainMenu();
            if(choice == 1) { //Borrower Menu
                personMenu.start();
              
            }
            else if(choice == 2) { //DVD Menu
                dvdMenu.start();
            }
            else if(choice == 3) { //Loan Menu
                loanMenu.start(); 
            }
            else if(choice == 4) { //Generate Test Data
               //TryMe.generateTestData();  //Disabled for development.
            }else {
                writeEnd();
                exit = true;
            }//end else
        }//end while
    }
    
    /**
     * Prints out the main menu, and returns the choice of the user.
     * 
     * @return An integer that represents the choice of the user from the menu.
     */
    private int writeMainMenu(){
        TextOptions menu = new TextOptions("\n ***Main menu***", "Quit the program");
        menu.addOption("Manage person");
        menu.addOption("DVD menu");
        menu.addOption("Loan menu");
        //menu.addOption("Generate test data");     //Disabled for development
        return menu.prompt();
    }
    
    /**
     * If the user wants to quit the program, this method prints out a goodbye message.
     */
    private void writeEnd() {
        System.out.println(" Thank you and goodbye.");
    }

}
