/**
 * Jose Rodriguez
 * 11/1/26
 * CSD420 Module 2.2 - Data Writer
 * Generates five random integers and five random doubles,
 * then appends them to a data file.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class RodriguezDataWriter {
    public static void main(String[] args) {
        Random random = new Random();
        int[] integers = new int[5];
        double[] doubles = new double[5];

        for (int i = 0; i < 5; i++) {
            integers[i] = random.nextInt(100) + 1;
            doubles[i] = random.nextDouble() * 100;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("rodriguez datafile.dat", true))) {
            writer.println("Integers:");
            for (int number : integers) {
                writer.println(number);
            }
            writer.println("Doubles:");
            for (double number : doubles) {
                writer.printf("%.2f%n", number);
            }
            writer.println("---");
            System.out.println("Random numbers appended to rodriguez datafile.dat");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
