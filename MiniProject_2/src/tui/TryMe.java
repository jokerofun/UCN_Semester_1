package tui;

import controller.DVDController;
import controller.PersonController;
import model.DVD;
import model.Person;

import java.time.LocalDate;

/**
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class TryMe {

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        //generateTestData(); //Disabled for development. Enable for test data.
        mainMenu.start();
    }

    public static void generateTestData() {
        DVDController dvdController = new DVDController();
        DVD dvd = dvdController.createDVD(1, "Cool title", "1", LocalDate.now());
        dvdController.createDVDCopy(dvd,1, LocalDate.now(), 10.0);
        dvdController.createDVDCopy(dvd,2, LocalDate.now(), 10.0);
        DVD dvd1 = dvdController.createDVD(2, "Cooler title", "2", LocalDate.now());
        dvdController.createDVDCopy(dvd1,1, LocalDate.now(), 10.0);
        DVD dvd2 = dvdController.createDVD(3, "Coolest title", "3", LocalDate.now());
        dvdController.createDVDCopy(dvd2,1, LocalDate.now(), 10.0);
        PersonController personController = new PersonController();
        Person person = personController.createPerson("Cool name", "1", 90, "1", "10");
    }
}
