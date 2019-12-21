package controller;

import model.DVD;
import model.DVDContainer;
import model.DVDCopy;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class DVDController {
    private DVDContainer dvdContainer;

    public DVDController() {
        dvdContainer = DVDContainer.getInstance();
    }

    public DVD createDVD(int barcode, String title, String artist, LocalDate publicationDate) {
        DVD dvd = new DVD(barcode, title, artist, publicationDate);

        if (!dvdContainer.addDVD(dvd)) {
            dvd = null;
        }

        return dvd;
    }

    public void listDVDs() {
        ArrayList<DVD> dvds = getAllDVDs();
        if(!dvds.isEmpty()) {
            for(DVD d : dvds) {
            System.out.println("Title: " + d.getTitle() + "; Bar Code: " + d.getBarcode());
        }
        }else {
            System.out.println("No DVDs available");
        }
        
    }

    public void updateDVD(DVD dvd, String title, String artist, LocalDate publicationDate) {
        dvd.setTitle(title);
        dvd.setArtist(artist);
        dvd.setPublicationDate(publicationDate);
    }

    public void updateDVDCopy(DVDCopy dvdCopy, double purchasePrice) {
        dvdCopy.setPurchasePrice(purchasePrice);
    }

    public boolean removeDVD(DVD dvd) {
        return dvdContainer.removeDVD(dvd);
    }

    public boolean removeDVDCopy(DVD dvd, DVDCopy dvdCopy) {
        return dvdContainer.removeDVDCopy(dvd, dvdCopy);
    }

    public DVDCopy createDVDCopy(DVD dvd, int serialNumber, LocalDate purchaseDate, double purchasePrice) {
        DVDCopy dvdCopy = new DVDCopy(serialNumber, purchaseDate, purchasePrice);

        if (!dvdContainer.addDVDCopy(dvd, dvdCopy)) {
            dvdCopy = null;
    }

        return dvdCopy;
    }

    public DVD findDVDByTitle(String title) {
        return dvdContainer.findDVDByTitle(title);
    }

    public DVDCopy findDVDCopy(int barcode, int serialNumber) {
        DVD dvd = dvdContainer.findDVDByBarcode(barcode);
        DVDCopy dvdCopy = null;
        if (dvd != null) {
            dvdCopy = dvdContainer.findDVDCopyBySerialNumber(dvd, serialNumber);
        }
        return dvdCopy;
    }

    public DVD findDVDByBarcode(int barcode) {
        return dvdContainer.findDVDByBarcode(barcode);
    }

    public DVDCopy findDVDCopyBySerialNumber(DVD dvd, int serialNumber) {
        return dvdContainer.findDVDCopyBySerialNumber(dvd, serialNumber);
    }

    public DVD findDVDCopyOwner(DVDCopy dvdCopy) {
        return dvdContainer.findDVDCopyOwner(dvdCopy);
    }

    public ArrayList<DVD> getAllDVDs() {return new ArrayList<DVD>(dvdContainer.getAllDVDs());}

    public ArrayList<DVDCopy> getDVDCopies(DVD dvd) {return new ArrayList<DVDCopy>(dvdContainer.getDvdCopies(dvd));}
}
