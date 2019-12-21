package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Class holding all general DVD information and a list of its specific copies
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.10.28
 */
public class DVD {
    private ArrayList<DVDCopy> dvdCopies;
    private int barcode;
    private String title;
    private String artist;
    private LocalDate publicationDate;

    /**
     * Constructor for DVD
     * @param barcode unique barcode of the DVD
     * @param title title of the dvd
     * @param artist artist of the dvd
     * @param publicationDate publication date of the dvd
     */
    public DVD(int barcode, String title, String artist, LocalDate publicationDate) {
        dvdCopies = new ArrayList<>();
        this.barcode = barcode;
        this.title = title;
        this.artist = artist;
        this.publicationDate = publicationDate;
    }

    /**
     * Method to get all copies of this dvd
     * @return All copies of this dvd
     */
    public ArrayList<DVDCopy> getDvdCopies() {
        return new ArrayList<DVDCopy>(dvdCopies);
    }

    /**
     * Add a copy of this DVD
     * @param dvdCopy dvdCopy to add
     * @return if operation succeeded
     */
    public boolean addDvdCopy(DVDCopy dvdCopy) {
        if (dvdCopy != null) {
            return dvdCopies.add(dvdCopy);
        }
        return false;
    }

    /**
     * Remove a copy of this DVD
     * @param dvdCopy dvdCopy to remove
     * @return if operation succeeded
     */
    public boolean removeDvdCopy(DVDCopy dvdCopy) {
        if (dvdCopy != null) {
            return dvdCopies.remove(dvdCopy);
        }
        return false;
    }

    /**
     *
     * @return barcode of this DVD
     */
    public int getBarcode() {
        return barcode;
    }

    /**
     *
     * @return title of this DVD
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return artist of this DVD
     */
    public String getArtist() {
        return artist;
    }

    /**
     *
     * @return publication date of this DVD
     */
    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    /**
     * Set the title of this dvd
     * @param title
     */
    public void setTitle(String title) { this.title = title;}

    /**
     * Set the barcode of this dvd
     * @param barcode
     */
    public void setBarcode(int barcode) { this.barcode = barcode;}

    /**
     * Set the artist of this dvd
     * @param artist
     */
    public void setArtist(String artist) {this.artist = this.artist;}

    /**
     * Set the publication date of this dvd
     * @param publicationDate
     */
    public void setPublicationDate(LocalDate publicationDate) { this.publicationDate = publicationDate;}

    @Override
    public String toString() {
        return title;
    }
}
