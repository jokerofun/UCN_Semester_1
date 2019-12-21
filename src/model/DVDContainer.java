package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class DVDContainer {
    private ArrayList<DVD> dvds;
    private static DVDContainer instance;

    private DVDContainer() {
        dvds = new ArrayList<>();
    }

    public static DVDContainer getInstance() {
        if (instance == null) {
            instance = new DVDContainer();
        }

        return instance;
    }

    public boolean addDVD(DVD dvd) {
        boolean succeeded = true;

        try{
            dvds.add(dvd);
        }catch (Exception e){
            //System.err.println(e.toString());
            succeeded = false;
        }

        return succeeded;
    }


    private boolean isBarcodeUnique(DVD dvd) {
        boolean isBarcodeUnique = false;

        for (DVD dvd1 : dvds) {
            if (dvd1.getBarcode() != dvd.getBarcode()) {
                isBarcodeUnique = true;
            }
        }

        return isBarcodeUnique;
    }

    public boolean removeDVD(DVD dvd) {
        return dvds.remove(dvd);
    }

    public boolean addDVDCopy(DVD dvd, DVDCopy dvdCopy) {
        boolean succeeded = true;

        try{
            dvd.addDvdCopy(dvdCopy);
        }catch (Exception e){
            //System.err.println(e.toString());
            succeeded = false;
        }

        return succeeded;
    }

    private boolean isSerialNumberUnique(DVD dvd, DVDCopy dvdCopy) {
        boolean isSerialNumberUnique = false;
        if (dvd.getDvdCopies() != null)
        for (DVDCopy dvdCopy1 : dvd.getDvdCopies()) {
            if (dvdCopy1.getSerialNumber() != dvdCopy.getSerialNumber()) {
                isSerialNumberUnique = true;
            }
        }

        return isSerialNumberUnique;
    }

    public boolean removeDVDCopy(DVD dvd, DVDCopy dvdCopy) {
        return dvd.removeDvdCopy(dvdCopy);
    }

    public DVD findDVDByTitle(String title) {
        DVD foundDVD = null;
        for(DVD d: dvds) {
            if(d.getTitle().toLowerCase().equals(title.toLowerCase())) {
                foundDVD = d;
            }
        }
        return foundDVD;
    }

    public DVD findDVDByBarcode(int barcode) {
        Iterator<DVD> dvdIterator = dvds.iterator();
        DVD foundDVD = null;
        DVD dvd;
        boolean found = false;

        while (dvdIterator.hasNext() && !found) {
            dvd = dvdIterator.next();

            if (dvd.getBarcode() == barcode) {
                foundDVD = dvd;
                found = true;
            }
        }

        return foundDVD;
    }

    public DVDCopy findDVDCopyBySerialNumber(DVD dvd, int serialNumber) {
        Iterator<DVDCopy> dvdCopyIterator = dvd.getDvdCopies().iterator();
        DVDCopy foundDVDCopy = null;
        DVDCopy dvdCopy;
        boolean found = false;

        while (dvdCopyIterator.hasNext() && !found) {
            dvdCopy = dvdCopyIterator.next();

            if (dvdCopy.getSerialNumber() == serialNumber) {
                foundDVDCopy = dvdCopy;
                found = true;
            }
        }

        return foundDVDCopy;
    }

    /**
     * Used to find parameters like title of a given DVDCopy
     * @param dvdCopy dvdCopy object
     * @return DVD it is associated to
     */
    public DVD findDVDCopyOwner(DVDCopy dvdCopy) {
        Iterator<DVD> dvdIterator = dvds.iterator();
        DVD foundDVD = null;
        DVD dvd;
        boolean found = false;

        while (dvdIterator.hasNext() && !found) {
            dvd = dvdIterator.next();
            if (dvd.getDvdCopies().contains(dvdCopy)) {
                foundDVD = dvd;
                found = true;
            }
        }

        return foundDVD;
    }

    public ArrayList<DVD> getAllDVDs() {return new ArrayList<DVD>(dvds);}

    public ArrayList<DVDCopy> getDvdCopies(DVD dvd) {return new ArrayList<DVDCopy>(dvd.getDvdCopies());}

}
