package model;

import java.time.LocalDate;

/**
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class DVDCopy{
    private int serialNumber;
    private LocalDate purchaseDate;
    private double purchasePrice;

    public DVDCopy(int serialNumber, LocalDate purchaseDate, double purchasePrice) {
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
    }

    /**
     *
     * @return serialNumber of this DVDCopy
     */
    public int getSerialNumber() {
        return serialNumber;
    }

    /**
     * Set the serial number of this dvd copy
     * @param serialNumber
     */
    public void setSerialNumber(int serialNumber) {this.serialNumber = serialNumber;}

    /**
     *
     * @return purchaseDate of this DVDCopy
     */
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Set the purchase date of this dvd copy
     * @param purchaseDate java Time date that this DVDCopy was made on
     */
    public void setPurchaseDate(LocalDate purchaseDate) {this.purchaseDate = purchaseDate;}

    /**
     *
     * @return purchasePrice of this DVDCopy
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Set the purchase price of this dvd copy
     * @param purchasePrice
     */
    public void setPurchasePrice(double purchasePrice) {this.purchasePrice = purchasePrice;}

    @Override
    public String toString() {
        return (String.valueOf(serialNumber));
    }
}
