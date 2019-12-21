package tui;

import controller.PersonController;
import model.Person;

/**
 * This class represents a person menu object, that prints out and handles the menu for managing persons. 
 *
 * The constructor of this class is called from the MainMenu class.
 *
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class PersonMenu{
    private PersonController personController;
    
    /**
     * Constructor for objects of class PersonMenu
     */
    public PersonMenu() {
        // initialise instance variables
        personController= new PersonController();

    }

    /**
     * Handles the different options of person menu.
     */
    public void start() {
        boolean running = true;
        while (running) {
            int choice = writePersonMenu();
            if (choice == 1) { //Create Person
                createPerson();
            }
            else if(choice==2){

                printPersons();//Prints all the persons
            }
            else if(choice==3){
                printPersonsByName();//Prints persons with a certain name
            }
            else if(choice==4){
                printPersonByPhone();//Prints person with a certain phone
            }
            else if(choice==5){
                updatePerson();//Update a person using phone number
            }
            else if(choice==6){
                deletePerson();//Deleting a person using a phone number
            }

            //TODO perhaps you need further menu items?
            else {
                running = false;
            }
        }

    }

    /**
     * Prints out the person menu, and returns the choice of the user.
     * 
     * @return An integer that represents the choice of the user from the menu.
     */
    private int writePersonMenu() {
        // creates a keyboard object to read input
        TextOptions menu = new TextOptions("\n ***** Person menu *****", "Back"); 
        menu.addOption("Create Person");
        menu.addOption("Print all persons");
        menu.addOption("Find person in date base by name");
        menu.addOption("Find person by phone");
        menu.addOption("Update a person by phone match");
        menu.addOption("Remove a person by phone match");
        int choice = menu.prompt();

        return choice;
    }

    /**
     * Prints out and handles the person creating process.
     * 
     * The method takes in the personal data of the person (name, address, phone number).
     * Address is taken in in three parts, by street, postal code and city.
     * 
     * After all the information about the person has been taken in, the method prints them out.
     * 
     */
    private void printPersons() {
        for(Person person: personController.getAllPersons())
        {
            printPersonInfo(person);
        }
    }

    private void deletePerson() {
        String phone = TextInput.inputString("Find person by phone number: ");
        Person person = personController.findPersonByPhoneNumber(phone);
        if (person != null) {
            if(personController.removePerson(person)){
                System.out.println("Person deleted");
            }
            else{
                System.out.println("Deleting failed.");
            }
        }else {
            System.out.println("Person not found.");
        }
    }

    private void updatePerson() {
        String phone = TextInput.inputString("Find person by phone number: ");
        Person person = personController.findPersonByPhoneNumber(phone);
        if (person != null) {
            String newName = TextInput.inputString("Update name: ");
            String newAddress = TextInput.inputString("Address: ");
            int newPostalCode = TextInput.inputNumberInt("Postal code: ");
            String newCity = TextInput.inputString("City: ");
            String newPhone = TextInput.inputString("Phone number: ");

            personController.updatePerson(person, newName, newAddress, newPostalCode, newCity, newPhone);
            printPersonInfo(person);
        }else {
            System.out.println("Person not found.");
        }
    }

    private void printPersonsByName() {
        String name = TextInput.inputString("Find persons by name: ");
        for(Person person : personController.findPersonsByName(name)){
            printPersonInfo(person);
        }

    }

    private void printPersonByPhone() {
        String phone = TextInput.inputString("Find person by phone number: ");
        Person person = personController.findPersonByPhoneNumber(phone);
        if (person != null) {
            printPersonInfo(person);
        }
    }

    private void printPersonInfo(Person person) {
        System.out.println("Name: " + person.getName());
        System.out.println("Street: " + person.getAddress());
        System.out.println("Postal Code: " + person.getPostalCode());
        System.out.println("City: " + person.getCity());
        System.out.println("Phone: " + person.getPhone());
        System.out.println("-------------");
    }

    private void createPerson() {
        String name = TextInput.inputString("To create a person enter the name:");
        String address = TextInput.inputString("Street: ");
        int postalCode = TextInput.inputNumberInt("Postal code:");
        String city = TextInput.inputString("City: ");
        String phone = TextInput.inputString("Phone number: ");

        Person newPerson = personController.createPerson(name,address ,postalCode,city,phone);
        printPersonInfo(newPerson);
    }
}
