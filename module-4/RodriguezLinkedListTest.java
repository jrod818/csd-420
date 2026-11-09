/**
 * Jose Rodriguez
 * 11/8/26
 * CSD420 Module 4.2 Assignment
 * 
 *
 * Compares LinkedList traversal using an Iterator
 * and the get(index) method.
 */

import java.util.Iterator;
import java.util.LinkedList;

public class RodriguezLinkedListTest {

    public static void main(String[] args) {

        testTraversal(50000);
        testTraversal(500000);
    }

    public static void testTraversal(int size) {

        LinkedList<Integer> numbers = new LinkedList<>();

        // Fill the list with integers from 0 to size - 1
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        System.out.println("\nTesting " + size + " integers");

        // Traverse using an Iterator
        long start = System.nanoTime();

        long iteratorSum = 0;
        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            iteratorSum += iterator.next();
        }

        long iteratorTime = System.nanoTime() - start;

        // Traverse using get(index)
        start = System.nanoTime();

        long getSum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            getSum += numbers.get(i);
        }

        long getTime = System.nanoTime() - start;

        // Verify both methods return the expected result
        long expectedSum = (long) size * (size - 1) / 2;

        boolean passed = iteratorSum == expectedSum
                && getSum == expectedSum;

        System.out.println("Iterator time: "
                + iteratorTime / 1_000_000.0 + " ms");

        System.out.println("get(index) time: "
                + getTime / 1_000_000.0 + " ms");

        System.out.println("Iterator sum: " + iteratorSum);
        System.out.println("get(index) sum: " + getSum);

        System.out.println("Test passed: " + passed);
    }
}
