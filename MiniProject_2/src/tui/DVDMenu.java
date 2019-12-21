package tui;

import controller.DVDController;
import model.DVDCopy;
import model.DVD;

import java.util.Scanner;
import java.time.LocalDate;

/**
 * This class represents a DVD menu object, that prints out and handles the menu for managing DVDs. 
 *
 * The constructor of this class is called from the MainMenu class. 

 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class DVDMenu {
    DVDController dvdController;
    LocalDate localDate;

    /**
     * Constructor for objects of class LoanMenu
     */
    public DVDMenu() {
       dvdController = new DVDController();
    }
    
    
    /**
     * Handles the different options of DVD menu.
     */
    public void start() {
        boolean running = true;
        while (running) {
            int choice = writeDVDMenu();
            switch(choice){
                case 1: //Create dvd
                    createDVD();
                    break;
                case 2: //Create dvd copy
                    createDVDCopy();
                    break;
                case 3: //List all dvds
                    listDVDs();
                    break;
                case 4: //List all copies of a dvd
                    listDVDCopies();
                    break;
                case 5: //Delete dvd (by title)
                    deleteDVD();
                    break;
                case 6: //Delete copy of dvd (by serial number)
                    deleteDVDCopy();
                    break;
                case 7: //Update dvd
                    updateDVD();
                    break;
                case 8: //Update dvd copy
                    updateDVDCopy();
                    break;
                default: running = false;
            }

        }
    }

    
    /**
     * Prints out the DVD menu, and returns the choice of the user.
     * 
     * @return An integer that represents the choice of the user from the menu.
     */
    private int writeDVDMenu() {
        TextOptions menu = new TextOptions("\n ***** DVD menu *****", "Back"); 
        menu.addOption("Create DVD");
        menu.addOption("Create DVD Copy");
        menu.addOption("List all DVDs");
        menu.addOption("List all copies of a DVD");
        menu.addOption("Delete DVD");
        menu.addOption("Delete DVD Copy");
        menu.addOption("Update DVD");
        menu.addOption("Update DVD Copy");
        //TODO if you need more menu items they have to go here
        int choice = menu.prompt();

        return choice;
    }
    
    /**
     * Prints out and handles the DVD creating process.
     * 
     * The method takes in the informations of the DVD (barcode, title, artist, publication date).
     * 
     */
    private void createDVD() {
        System.out.println("To create a DVD input a BAR CODE, TITLE, ARTIST, and PUBLICATION DATE.");

        int barcode = TextInput.inputNumberInt("Barcode: ");
        String title = TextInput.inputString("Title: ");
        String artist = TextInput.inputString("Artist: ");
        LocalDate publicationDate = TextInput.inputDate("Publication date: ");

        dvdController.createDVD(barcode, title, artist, publicationDate);
    }

    /**
     * Prints out and handles the DVD copy creating process.
     * 
     * First the method takes in the barcode of the DVD.
     * Then the method takes in the informations of the copy(serial number, purchase date, purchase price).
     * 
     */
    private void createDVDCopy() {
        int barcode = TextInput.inputNumberInt("Type the BAR CODE of the DVD you want to add a copy to: ");

        DVD dvd = dvdController.findDVDByBarcode(barcode);
        if (dvd != null) {
            System.out.println("To create a DVD Copy input a SERIAL NUMBER and a PURCHASE PRICE:");

            int serialNumber = TextInput.inputNumberInt("Serial number: ");
            LocalDate purchaseDate = localDate.now();
            double purchasePrice = TextInput.inputNumberDouble("Purchase price: ");

            dvdController.createDVDCopy(dvd, serialNumber, purchaseDate, purchasePrice);
        }else {
            System.out.println("DVD not found.");
        }
    }

    private void listDVDs() {
        System.out.println("Available DVDs: ");
        dvdController.listDVDs();
    }

    private void listDVDCopies() {
        listDVDs();
        String title = TextInput.inputString("Enter title of a DVD ");
        
        DVD dvd = dvdController.findDVDByTitle(title);
        if (dvd != null) {
            System.out.print("Serial number: ");
            System.out.println(dvdController.getDVDCopies(dvd));
        }else {
            System.out.println("DVD not found.");
        }
    }

    private void deleteDVD() {
        listDVDs();
        String title = TextInput.inputString("Enter TITLE of a DVD: ");

        DVD dvd = dvdController.findDVDByTitle(title);
        if (dvd != null) {
            dvdController.removeDVD(dvd);
            System.out.println("DVD successfully removed");
        }else {
            System.out.println("DVD not found.");
        }
    }

    private void deleteDVDCopy() {
        listDVDs();
        String title = TextInput.inputString("Enter TITLE of a DVD: ");

        DVD dvd = dvdController.findDVDByTitle(title);
        if (dvd != null) {
            System.out.print("Serial number: ");
            System.out.println(dvdController.getDVDCopies(dvd));
            
            int serialNumber = TextInput.inputNumberInt("Enter SERIAL NUMBER: ");
            DVDCopy dvdCopy = dvdController.findDVDCopyBySerialNumber(dvd, serialNumber);

            if (dvdCopy != null) {
                dvdController.removeDVDCopy(dvd, dvdCopy);
            }else {
                System.out.println("DVD Copy not found.");
            }
        }else {
            System.out.println("DVD not found.");
        }
    }

    private void updateDVD() {
        listDVDs();
        String title = TextInput.inputString("Enter TITLE of a DVD: ");

        DVD dvd = dvdController.findDVDByTitle(title);
        if (dvd != null) {
            title = TextInput.inputString("Title: ");
            String artist = TextInput.inputString("Artist: ");
            LocalDate publicationDate = TextInput.inputDate("Publication date: ");

            dvdController.updateDVD(dvd, title, artist, publicationDate);
        }else {
            System.out.println("DVD not found.");
        }
    }

    private void updateDVDCopy() {
        listDVDs();
        String title = TextInput.inputString("Enter TITLE of a DVD: ");

        DVD dvd = dvdController.findDVDByTitle(title);
        if (dvd != null) {
            System.out.print("Serial number: ");
            System.out.println(dvdController.getDVDCopies(dvd));
            
            int serialNumberToLook = TextInput.inputNumberInt("Serial number: ");

            DVDCopy dvdCopy = dvdController.findDVDCopyBySerialNumber(dvd, serialNumberToLook);
            if (dvdCopy != null) {
                double purchasePrice = TextInput.inputNumberDouble("Purchase price: ");
                dvdController.updateDVDCopy(dvdCopy, purchasePrice);
            }else {
                System.out.println("DVD Copy not found.");
            }

        }else {
            System.out.println("DVD not found.");
        }
    }
}
