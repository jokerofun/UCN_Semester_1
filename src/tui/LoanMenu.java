package tui;

import controller.LoanController;
import model.DVDCopy;
import model.Loan;
import org.w3c.dom.Text;

import java.util.Scanner;

/**
 * This class represents a loan menu object, that prints out and handles the menu for managing loans. 
 *
 * The constructor of this class is called from the MainMenu class.
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class LoanMenu {
    // instance variables
    LoanController loanController;

    /**
     * Constructor for objects of class LoanMenu
     */
    public LoanMenu() {
        // initialise instance variables
        loanController = new LoanController();
    }
    
    /**
     * Handles the different options of loan menu.
     */
    public void start() {
        boolean running = true;
        while (running) {
            int choice = writeLoanMenu();
            if (choice == 1) { //Create loan
                createLoan();
            }
            else if (choice == 2) {
                returnDVDCopy();
            }else {
                running = false;
            }
        }
    }
    
    /**
     * Prints out the loan menu, and returns the choice of the user.
     * 
     * @return An integer that represents the choice of the user from the menu.
     */
    private int writeLoanMenu() {
        // creates a keyboard object to read input
        TextOptions menu = new TextOptions("\n ***** Loan menu *****", "Back"); 
        menu.addOption("Create loan");
        menu.addOption("Return DVD Copy");

        return menu.prompt();
    }
    
    /**
     * Prints out and handles the loan creating process.
     * 
     * First the method identifies the person by taking in the phone number.
     * 
     * Then adds the DVD copy with the given barcode and serial number to a list and prints it out.
     * If the DVD is successfully added it prints out a success message, if not, prints out an error message.
     * 
     * After adding a DVD the users have the opportunity to decide if they want ro add more DVDs to the list.
     */
    private void createLoan() {
        String phoneNumber = TextInput.inputString("To lend a DVD input your phone number: ");

        Loan currentLoan = loanController.createLoan(phoneNumber);
        if (currentLoan != null) {
            int choice2 = 1;
            while (choice2 != 2) {
                System.out.println("To add a DVD input its barcode and serial number.");

                int barcode = TextInput.inputNumberInt("Barcode: ");
                int serialNumber = TextInput.inputNumberInt("Serial number: ");

                if (loanController.addDvdCopy(currentLoan, barcode, serialNumber)) {
                    System.out.println("The DVD has been added successfully.\n");
                } else {
                    System.out.println("The DVD hasn't been added because of some error. Check if you entered the DVD info correctly.\n");
                }

                System.out.println("List of DVDs:");
                for (DVDCopy dvdCopy : currentLoan.getDvdCopies()) {
                    if (dvdCopy != null) {
                        System.out.println(loanController.findDVDCopyOwner(dvdCopy));
                    }
                }

                System.out.println("\nDo you want to add more DVDs?");
                System.out.println("[1] Yes");
                System.out.println("[2] No");
                choice2 = TextInput.inputNumberInt("");
            }
        }else {
            System.out.println("User not found.");
        }
    }

    private void returnDVDCopy() {
        int barcode = TextInput.inputNumberInt("Please enter the barcode: ");
        int serialNumber= TextInput.inputNumberInt("Please enter the serial number: ");

        if(loanController.returnDVDCopy(barcode, serialNumber)){
            System.out.println("The DVD Copy was returned.");
        }
        else{
            System.out.println("DVD Copy not found.");
        }
    }
}
