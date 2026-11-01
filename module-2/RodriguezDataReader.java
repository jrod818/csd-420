/**
 * Jose Rodriguez
 * 11/1/26
 * CSD420 Module 2.2 - Data Reader
 * Reads and displays all data stored in the data file.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RodriguezDataReader {
    public static void main(String[] args) {
        File file = new File("rodriguez datafile.dat");

        try (Scanner reader = new Scanner(file)) {
            System.out.println("Contents of rodriguez datafile.dat:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found. Run RodriguezDataWriter first.");
        }
    }
}
