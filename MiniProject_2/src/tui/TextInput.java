package tui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
/**
 * Description of TextInput goes here.
 *
 * @author Bartosz Urban, Cosmin Hariton, Dominik Sári, Simeon Kolev
 * @version 2019.11.1
 */
public class TextInput {
    private static Scanner keyboard = new Scanner(System.in);
    /**
     * Constructor for objects of TextInput
     */
    public TextInput() {
        // initialise instance variables
    }
    

    //other methods
    public static int inputNumberInt(String question) {
        keyboard = new Scanner(System.in);
        int number = 0;
        printQuestion(question);
        while (!keyboard.hasNextInt()){
            System.out.println("Input must be a number (e.g 7) - try again");
            keyboard.nextLine();
        }
        number = keyboard.nextInt();
        return number;
    }

    public static double inputNumberDouble(String question) {
        keyboard = new Scanner(System.in);
        double number = 0.0;
        printQuestion(question);
        while (!keyboard.hasNextDouble()){
            System.out.println("Input must be a number (e.g 7,77) - try again");
            keyboard.nextLine();
        }
        number = keyboard.nextDouble();
        return number;
    }
    
    public static String inputString(String question) {
        keyboard = new Scanner(System.in);
        printQuestion(question);
        return keyboard.nextLine();
    }

    /**
     * Handles incorrect ranges for the date
     * @return Date only after it has been input correctly
     */
    public static LocalDate inputDate(String question) {
        printQuestion(question);

        boolean succeded = false;
        LocalDate publicationDate = null;

        while (!succeded) {
            int day = TextInput.inputNumberInt("Day: ");
            int month = TextInput.inputNumberInt("Month: ");
            int year = TextInput.inputNumberInt("Year: ");

            try {
                publicationDate = LocalDate.of(year, month, day);
                succeded = true;
            } catch (DateTimeException e) {
                System.out.println("Incorrect ranges for the date.");
            }
        }

        return publicationDate;
    }
    
    private static void printQuestion(String question) {
        System.out.print(" " + question + "\n" + ">");
    }

}
