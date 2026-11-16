import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Author: Jose Rodriguez
 * Date: November 15, 2026
 * Course: CSD420
 * Assignment: Module 5.2 Programming Assignment
 * Description: Reads words from a text file and displays unique words
 * in ascending and descending alphabetical order. Includes tests
 * to verify duplicate removal and sorting.
 */
public class RodriguezModule5 {

    /** The input file is referenced directly rather than through command-line arguments. */
    private static final Path WORD_FILE = Path.of("collection_of_words.txt");

    /**
     * Reads words from a text file into a sorted set. A TreeSet removes
     * duplicates automatically. Words are compared without regard to case.
     *
     * @param file the file containing words separated by whitespace
     * @return the unique words in ascending alphabetical order
     * @throws IOException if the file cannot be read
     */
    public static TreeSet<String> readUniqueWords(Path file) throws IOException {
        TreeSet<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        for (String line : Files.readAllLines(file)) {
            for (String word : line.trim().split("\\s+")) {
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        }
        return words;
    }

    /**
     * Checks that duplicates are removed and that both sort orders are correct.
     *
     * @return true if all tests pass; otherwise, false
     */
    public static boolean runTests() {
        TreeSet<String> testWords = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        testWords.addAll(Arrays.asList("banana", "apple", "cherry", "apple", "Banana"));

        List<String> expectedAscending = Arrays.asList("apple", "banana", "cherry");
        List<String> expectedDescending = Arrays.asList("cherry", "banana", "apple");

        boolean noDuplicates = testWords.size() == 3;
        boolean ascendingCorrect = List.copyOf(testWords).equals(expectedAscending);
        boolean descendingCorrect = List.copyOf(testWords.descendingSet())
                .equals(expectedDescending);

        System.out.println("Duplicate removal test: " + (noDuplicates ? "PASS" : "FAIL"));
        System.out.println("Ascending order test: " + (ascendingCorrect ? "PASS" : "FAIL"));
        System.out.println("Descending order test: " + (descendingCorrect ? "PASS" : "FAIL"));
        return noDuplicates && ascendingCorrect && descendingCorrect;
    }

    /**
     * Runs the tests, reads the input file, and prints both sorted word lists.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        if (!runTests()) {
            System.err.println("A test failed. Please review the program.");
            return;
        }

        try {
            Set<String> words = readUniqueWords(WORD_FILE);
            System.out.println("\nUnique words in ascending order:");
            for (String word : words) {
                System.out.println(word);
            }

            System.out.println("\nUnique words in descending order:");
            for (String word : ((TreeSet<String>) words).descendingSet()) {
                System.out.println(word);
            }
        } catch (IOException e) {
            System.err.println("Unable to read " + WORD_FILE + ": " + e.getMessage());
        }
    }
}
