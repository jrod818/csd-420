/**
 * Author: Jose Rodriguez
 * Date: November 22, 2026
 * Course: CSD420 - Advanced Java Programming
 * Assignment: Module 6.2 - Generic Bubble Sort
 * Description: Demonstrates bubble sorting with Comparable and Comparator,
 *              including tests for sorting, duplicates, empty arrays, and
 *              custom ordering.
 */
import java.util.Arrays;
import java.util.Comparator;

public class RodriguezModule6 {

    /** Sorts an array in ascending natural order using bubble sort.
     * @param <E> a type with a natural ordering
     * @param values the array to sort in place
     */
    public static <E extends Comparable<? super E>> void bubbleSort(E[] values) {
        for (int end = values.length - 1; end > 0; end--) {
            boolean swapped = false;
            for (int i = 0; i < end; i++) {
                if (values[i].compareTo(values[i + 1]) > 0) {
                    E temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /** Sorts an array using the ordering provided by a Comparator.
     * @param <E> the element type
     * @param values the array to sort in place
     * @param order the comparison rule
     */
    public static <E> void bubbleSort(E[] values, Comparator<? super E> order) {
        for (int end = values.length - 1; end > 0; end--) {
            boolean swapped = false;
            for (int i = 0; i < end; i++) {
                if (order.compare(values[i], values[i + 1]) > 0) {
                    E temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /** Prints the result of a test and fails if the result is incorrect. */
    private static <E> void check(String name, E[] actual, E[] expected) {
        boolean passed = Arrays.equals(actual, expected);
        System.out.println(name + ": " + (passed ? "PASS" : "FAIL"));
        System.out.println("  Actual: " + Arrays.toString(actual));
        if (!passed) {
            throw new AssertionError(name + " expected " + Arrays.toString(expected));
        }
    }

    /** Runs tests of both generic methods. */
    public static void main(String[] args) {
        Integer[] numbers = {9, 3, 7, 1, 3};
        bubbleSort(numbers);
        check("Comparable: integers with duplicates", numbers, new Integer[]{1, 3, 3, 7, 9});

        String[] names = {"Zoe", "Alex", "Maria", "Ben"};
        bubbleSort(names);
        check("Comparable: strings", names, new String[]{"Alex", "Ben", "Maria", "Zoe"});

        Integer[] descending = {4, 1, 8, 2};
        bubbleSort(descending, Comparator.reverseOrder());
        check("Comparator: descending integers", descending, new Integer[]{8, 4, 2, 1});

        String[] byLength = {"Christopher", "Ann", "Michael", "James"};
        bubbleSort(byLength, Comparator.comparingInt(String::length));
        check("Comparator: names by length", byLength,
                new String[]{"Ann", "James", "Michael", "Christopher"});

        Integer[] empty = {};
        bubbleSort(empty);
        check("Edge case: empty array", empty, new Integer[]{});

        Integer[] single = {42};
        bubbleSort(single, Comparator.naturalOrder());
        check("Edge case: one element", single, new Integer[]{42});

        System.out.println("All 6 tests passed.");
    }
}
