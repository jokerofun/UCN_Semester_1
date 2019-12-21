package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A container for all Loans in the system with search functionality
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class LoanContainer {
    private ArrayList<Loan> loans;
    private static LoanContainer instance;

    /**
     * Private singleton constructor
     */
    private LoanContainer() {
        loans = new ArrayList<>();
    }

    /**
     * Singleton method to get hold of the instance
     * @return instance of this class
     */
    public static LoanContainer getInstance() {
        if (instance == null) {
            instance = new LoanContainer();
        }

        return instance;
    }

    /**
     * Adds a loan to the container
     * @param loan loan to add
     * @return if the operation succeeded
     */
    public boolean addLoan(Loan loan) {
        if (loan != null) {
            return loans.add(loan);
        }
        return false;
    }

    /**
     * Removes a loan from this container
     * @param loan loan to remove
     * @return if the operation succeeded
     */
    public boolean removeLoan(Loan loan) {
        if (loan != null) {
            return loans.remove(loan);
        }
        return false;
    }

    /**
     * Returns all loans
     * @return list of all loans
     */
    public ArrayList<Loan> getAllLoans() {
        return new ArrayList<Loan>(loans);
    }

    /**
     * Loops over all loans in loans to find a match with the given id
     * @param id id of the loan
     * @return found Loan
     */
    public Loan findLoanById(int id) {
        Iterator<Loan> iterator = loans.iterator();
        Loan foundLoan = null;
        Loan loan;
        boolean found = false;

        while (iterator.hasNext() && !found) {
            loan = iterator.next();

            if (loan.getId() == id) {
                foundLoan = loan;
                found = true;
            }
        }

        return foundLoan;
    }
}
