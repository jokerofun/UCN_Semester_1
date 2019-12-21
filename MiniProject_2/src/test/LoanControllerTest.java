package test;

import controller.LoanController;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class LoanControllerTest {

    LoanController loanController;
    Loan loan;
    DVDContainer dvdContainer;
    LoanContainer loanContainer;
    DVD dvd1;
    DVDCopy dvd1Copy1, dvd1Copy2;

    @Before
    public void setUp() throws Exception {
        loanController = new LoanController();
        loan = new Loan(new Person("name2", "address", 10000, "city", "phone"));
        dvdContainer = DVDContainer.getInstance();
        loanContainer = LoanContainer.getInstance();

        loanContainer.addLoan(loan);

        dvd1 = new DVD(5, "TITLE", "ARTIST", LocalDate.now());
        dvdContainer.addDVD(dvd1);

        dvd1Copy1 = new DVDCopy(100, LocalDate.now(), 10.0);
        dvd1Copy2 = new DVDCopy(200, LocalDate.now(), 10.0);

        dvd1.addDvdCopy(dvd1Copy1);
        dvd1.addDvdCopy(dvd1Copy2);

        loan.addDvdCopy(dvd1Copy2);
    }

    @Test
    public void addDvdCopyAvailable() {
        Assert.assertTrue("Loaning failed", loanController.addDvdCopy(loan,dvd1.getBarcode(), dvd1Copy1.getSerialNumber()));
    }

    @Test
    public void addDvdCopyFail() {
        Assert.assertFalse("Loaning failed", loanController.addDvdCopy(loan,dvd1.getBarcode(), dvd1Copy2.getSerialNumber()));
    }

    @Test
    public void findDvdCopyOwner() {
        Assert.assertEquals(dvd1, loanController.findDVDCopyOwner(dvd1Copy1));
    }
}