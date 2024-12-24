package epam.example;

import java.util.Arrays;

public class Sorter {

    /**
     * Sorts the given array in ascending order.
     *
     * @param numbers the array to sort
     */
    public static void sort(int[] numbers) {
        java.util.Arrays.sort(numbers);
    }

    /**
     * Checks if the given number is valid based on the rules:
     * - Must be between 1 and 10 (inclusive).
     * - Any number greater than 10 or less than 1 is invalid.
     * - Any 3-digit number (positive or negative) is invalid.
     *
     * @param number the number to validate
     * @return true if the number is valid, false otherwise
     */
    public static boolean isValidNumber(int number) {
        // Invalid if greater than 10 or less than 1
        if (number > 10 || number < 1) {
            return false;
        }

        // Invalid if it is a 3-digit number
        if (number <= -100 || number >= 100) {
            return false;
        }

        return true;
    }
}