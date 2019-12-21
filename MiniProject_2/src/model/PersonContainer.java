package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A container for all Persons in the system with search functionality
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class PersonContainer {
    private ArrayList<Person> persons;
    private static PersonContainer instance;

    /**
     * Private singleton constructor
     */
    private PersonContainer() {
        persons = new ArrayList<>();
    }

    /**
     * Singleton method to get hold of the instance
     * @return instance of this class
     */
    public static PersonContainer getInstance() {
        if (instance == null) {
            instance = new PersonContainer();
        }
        return instance;
    }

    /**
     * Adds a person to the container
     * @param person person to add
     * @return if the operation succeeded
     */
    public boolean addPerson(Person person) {
        if (person != null) {
            return persons.add(person);
        }
        return false;
    }

    /**
     * Removes a person from the container
     * @param person person to remove
     * @return if the operation succeeded
     */
    public boolean removePerson(Person person) {
        boolean succeed=false;
        if (person != null) {
            persons.remove(person);
            succeed=true;
        }
        return succeed;
    }

    /**
     * Gets all persons in the container
     * @return list of all persons in the container
     */
    public ArrayList<Person> getAllPersons() {
        return new ArrayList<Person>(persons);
    }

    /**
     * Gets a single person with the same name
     * @param name the name of the person to look for
     * @return Person with the same name
     */
    public Person findPersonByName(String name) {
        Iterator<Person> iterate = persons.iterator();
        Person foundPerson = null;
        Person person;
        boolean found = false;

        while (iterate.hasNext() && !found) {
            person = iterate.next();

            if (person.getName().equals(name)) {
                foundPerson = person;
                found = true;
            }
        }

        return foundPerson;
    }

    /**
     * Loops over all people in persons to find all matches with the given name pattern
     * @param name name of the people to look for
     * @return found persons
     */
    public ArrayList<Person> findPersonsByName(String name) {
        ArrayList<Person> foundPersons = new ArrayList<>();

        for (Person person : persons) {
            if (person.getName().matches("(.*)" + name + "(.*)")) {
                foundPersons.add(person);
            }
        }

        return foundPersons;
    }

    /**
     * Loops over all people in persons to find a match with the given phone number
     * @param phoneNumber phone number of the person to look for
     * @return found Person
     */
    public Person findPersonByPhoneNumber(String phoneNumber) {
        Iterator<Person> iterate = persons.iterator();
        Person foundPerson = null;
        Person person;
        boolean found = false;

        while (iterate.hasNext() && !found) {
            person = iterate.next();

            if (person.getPhone().equals(phoneNumber)) {
                foundPerson = person;
                found = true;
            }
        }

        return foundPerson;
    }
}
