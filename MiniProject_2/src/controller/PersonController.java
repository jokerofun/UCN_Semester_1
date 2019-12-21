package controller;

import model.Person;
import model.PersonContainer;

import java.util.ArrayList;
/**
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class PersonController {
    private PersonContainer personContainer;

    public PersonController() {
        personContainer = PersonContainer.getInstance();
    }

    public Person createPerson(String name, String address, int postalCode, String city, String phone) {
        Person person = new Person(name, address, postalCode, city, phone);

        //If the add operation fails return null
        if (!personContainer.addPerson(person)) {
            person = null;
        }

        return person;
    }

    public boolean removePerson(Person person) {
        return personContainer.removePerson(person);
    }

    public void updatePerson(Person person, String name, String address, int postalCode, String city, String phone) {
        person.setName(name);
        person.setAddress(address);
        person.setPostalCode(postalCode);
        person.setCity(city);
        person.setPhone(phone);
    }

    public Person findPersonByName(String name) {
        return personContainer.findPersonByName(name);
    }

    public ArrayList<Person> findPersonsByName(String name) {
        return personContainer.findPersonsByName(name);
    }

    public Person findPersonByPhoneNumber(String phoneNumber) {
        return personContainer.findPersonByPhoneNumber(phoneNumber);
    }

    public ArrayList<Person> getAllPersons() {
        return personContainer.getAllPersons();
    }
}
