package controller;


import model.*;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class LoanController {
    private LoanContainer loanContainer;
    private PersonController personController;
    private DVDController dvdController;

    public LoanController() {
        loanContainer = LoanContainer.getInstance();
        personController = new PersonController();
        dvdController = new DVDController();
    }

    public Loan createLoan(String phoneNumber) {
        Person person = personController.findPersonByPhoneNumber(phoneNumber);
        Loan loan = null;
        if (person != null) {
            loan = new Loan(person);

            //If the add operation fails return null
            if (!loanContainer.addLoan(loan)) {
                loan = null;
            }
        }

        return loan;
    }

    public boolean addDvdCopy(Loan loan, int barcode, int serialNumber) {
        boolean succeeded = false;
        DVD dvdToLend = dvdController.findDVDByBarcode(barcode);
        if (dvdToLend != null) {
            DVDCopy dvdCopyToLend = dvdController.findDVDCopyBySerialNumber(dvdToLend, serialNumber);

            //Checks if the DVDCopy is available to add it to the loan
            if (dvdCopyToLend != null && isDVDCopyAvailable(dvdCopyToLend)) {
                succeeded = loan.addDvdCopy(dvdCopyToLend);
            }
        }

        return succeeded;
    }

    /**
     * Loops through all the loans and their lent DVD Copies to check if the DVDCopy is available to lend
     * @param dvdCopyToLend dvd copy to check availability of
     * @return is the dvd copy available
     */
    private boolean isDVDCopyAvailable(DVDCopy dvdCopyToLend) {
        boolean succeeded = true;

        for (Loan loan : loanContainer.getAllLoans()) {
            for (DVDCopy dvdCopy : loan.getDvdCopies()) {
                if (dvdCopy.equals(dvdCopyToLend)) {
                    succeeded = false;
                }
            }
        }

        return succeeded;
    }

    public boolean returnDVDCopy(int barcode, int serialNumber) {
        DVDCopy dvdCopyToReturn = dvdController.findDVDCopy(barcode, serialNumber);
        boolean succeeded = false;

        if (dvdCopyToReturn != null) {
            Iterator<Loan> loanIterator = loanContainer.getAllLoans().iterator();
            while (loanIterator.hasNext() && !succeeded) {
                Loan loan = loanIterator.next();
                succeeded = loan.removeDvdCopy(dvdCopyToReturn);
            }
        }
        return succeeded;
    }

    public DVD findDVDCopyOwner(DVDCopy dvdCopy) {
        return dvdController.findDVDCopyOwner(dvdCopy);
    }

    public ArrayList<Loan> getAllLoans() {
        return new ArrayList<Loan>(loanContainer.getAllLoans());
    }
}
