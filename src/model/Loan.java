package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * Class to hold information about the Loan. Including:
 * association to the lender, all DVDCopies
 * borrow date and period
 *
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class Loan {
    private Person person;
    private ArrayList<DVDCopy> dvdCopies;
    private int id;     //auto increment id
    private static int nextId=0;
    private LocalDate borrowDate;
    private Period period;

    /**
     * Constructor for Loan
     * @param person person to which the loan belongs to
     */
    public Loan(Person person) {
        id = nextId++;
        dvdCopies = new ArrayList<>();
        this.person = person;
    }

    /**
     * Get the person this loan belongs to
     * @return person this loan belongs to
     */
    public Person getPerson() {
        return person;
    }
    

    /**
     * Gets all DVDCopies in this loan
     * @return list of all DVDCopies in the loan
     */
    public ArrayList<DVDCopy> getDvdCopies() {
        return new ArrayList<DVDCopy>(dvdCopies);
    }

    /**
     * Add a specific dvd to this loan
     * @param dvdCopy specific dvdCopy to add
     * @return if the operation succeeded
     */
    public boolean addDvdCopy(DVDCopy dvdCopy) {
        boolean succeeded = false;
        if (dvdCopy != null) {
            dvdCopies.add(dvdCopy);
            succeeded = true;
        }
        return succeeded;
    }

    /**
     * Remove a specific dvd from this loan
     * @param dvdCopy specific dvdCopy to remove
     * @return if the operation succeeded
     */
    public boolean removeDvdCopy(DVDCopy dvdCopy) {
        if (dvdCopy != null) {
            return dvdCopies.remove(dvdCopy);
        }
        return false;
    }

    /**
     *
     * @return id of this loan
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return borrow date of this loan
     */
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    /**
     * Sets the borrow date of this loan
     * @param borrowDate java Time date that this loan was made on
     */
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    /**
     *
     * @return period of this loan
     */
    public Period getPeriod() {
        return period;
    }

    /**
     * Sets the period of this loan
     * @param period
     */
    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return person.getName() + "\n" + dvdCopies;
    }
}
