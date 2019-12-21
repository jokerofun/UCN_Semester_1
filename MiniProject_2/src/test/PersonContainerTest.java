package test;

import model.Person;
import model.PersonContainer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PersonContainerTest {

    @Test
    public void findPersonsByName() {
        PersonContainer personContainer = PersonContainer.getInstance();
        Person person1 = new Person("NAME1", "ADDRESS", 100, "CITY", "PHONE");
        Person person2 = new Person("NAME1", "ADDRESS", 100, "CITY", "PHoNE");
        personContainer.addPerson(person1);
        personContainer.addPerson(person2);
        ArrayList<Person> expectedPersons = new ArrayList<>();
        expectedPersons.add(person1);
        expectedPersons.add(person2);

        Assert.assertEquals(expectedPersons, personContainer.findPersonsByName("NAME1"));
    }

    @Test
    public void findPersonByPhoneNumber() {
        PersonContainer personContainer = PersonContainer.getInstance();
        Person person1 = new Person("NAME2", "ADDRESS", 100, "CITY", "PHONE");
        Person person2 = new Person("NAME2", "ADDRESS", 100, "CITY", "PHoNE");
        personContainer.addPerson(person1);
        personContainer.addPerson(person2);
        Assert.assertEquals(person1, personContainer.findPersonByPhoneNumber("PHONE"));
    }

    @Test
    public void findPersonByPhoneNumberNull() {
        PersonContainer personContainer = PersonContainer.getInstance();
        Person person1 = new Person("NAME3", "ADDRESS", 100, "CITY", "PHONE");
        personContainer.addPerson(person1);

        Assert.assertEquals(null, personContainer.findPersonByPhoneNumber("no"));

    }
}