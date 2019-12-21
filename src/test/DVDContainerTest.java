package test;

import model.DVD;
import model.DVDContainer;
import model.DVDCopy;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DVDContainerTest {

    @Test
    public void findDVDByBarcode() {
        DVDContainer dvdContainer = DVDContainer.getInstance();
        DVD dvd1 = new DVD(1, "TITLE", "ARTIST", LocalDate.now());
        DVD dvd2 = new DVD(2, "TITLE2", "ARTIST2", LocalDate.now());

        dvdContainer.addDVD(dvd1);
        dvdContainer.addDVD(dvd2);

        Assert.assertEquals(dvd1, dvdContainer.findDVDByBarcode(1));
    }

    @Test
    public void findDVDCopyBySerialNumber() {
        DVDContainer dvdContainer = DVDContainer.getInstance();
        DVD dvd1 = new DVD(1, "TITLE", "ARTIST", LocalDate.now());
        DVDCopy dvd1Copy1 = new DVDCopy(1, LocalDate.now(), 10.0);
        DVDCopy dvd1Copy2 = new DVDCopy(2, LocalDate.now(), 10.0);
        dvd1.addDvdCopy(dvd1Copy1);
        dvd1.addDvdCopy(dvd1Copy2);


        DVD dvd2 = new DVD(2, "TITLE2", "ARTIST2", LocalDate.now());
        DVDCopy dvd2Copy1 = new DVDCopy(1, LocalDate.now(), 10.0);
        DVDCopy dvd2Copy2 = new DVDCopy(2, LocalDate.now(), 10.0);
        dvd2.addDvdCopy(dvd2Copy1);
        dvd2.addDvdCopy(dvd2Copy2);

        dvdContainer.addDVD(dvd1);
        dvdContainer.addDVD(dvd2);

        Assert.assertEquals(dvd1Copy1, dvdContainer.findDVDCopyBySerialNumber(dvd1, 1));
    }

    @Test
    public void findDVDCopyOwner() {
        DVDContainer dvdContainer = DVDContainer.getInstance();

        DVD dvd1 = new DVD(5, "TITLE", "ARTIST", LocalDate.now());
        DVDCopy dvd1Copy1 = new DVDCopy(100, LocalDate.now(), 10.0);
        dvd1.addDvdCopy(dvd1Copy1);
        dvdContainer.addDVD(dvd1);

        Assert.assertEquals(dvd1, dvdContainer.findDVDCopyOwner(dvd1Copy1));
    }
}