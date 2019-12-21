package model;

/**
 * Person with contact information
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class Person
{
    //instance variables
    private String name;
    private String address;
    private int postalCode;
    private String city;
    private String phone;

    /**
     * Constructor for Person
     * @param name name of the person
     * @param address their address
     * @param postalCode their postal zip code
     * @param city their city
     * @param phone their phone number
     */
    public Person(String name, String address, int postalCode, String city, String phone) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
