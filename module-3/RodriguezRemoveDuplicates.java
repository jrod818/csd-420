/**
 * Jose Rodriguez
 * November 8, 2026
 * CSD420 Module 3.2 Assignment
 * 
 * This program generates 50 random integers between 1 and 20,
 * stores them in an ArrayList, and removes duplicate values
 * using a generic method.
 */

import java.util.ArrayList;
import java.util.Random;


public class RodriguezRemoveDuplicates {

    /**
     * Returns a new ArrayList containing the unique values
     * from the original list in their original order.
     *
     * @param list The original ArrayList
     * @param <E> The type of elements in the list
     * @return A new ArrayList without duplicates
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> uniqueList = new ArrayList<>();

        for (E item : list) {
            if (!uniqueList.contains(item)) {
                uniqueList.add(item);
            }
        }

        return uniqueList;
    }

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // Generate 50 random integers from 1 to 20
        for (int i = 0; i < 50; i++) {
            numbers.add(random.nextInt(20) + 1);
        }

        // Display the original list
        System.out.println("Original ArrayList (50 values):");
        System.out.println(numbers);

        // Remove duplicates
        ArrayList<Integer> uniqueNumbers = removeDuplicates(numbers);

        // Display the new list
        System.out.println("\nArrayList without duplicates:");
        System.out.println(uniqueNumbers);

        // Display the number of unique values
        System.out.println("\nOriginal count: " + numbers.size());
        System.out.println("Unique count: " + uniqueNumbers.size());
    }
}
