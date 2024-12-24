package epam.example;

import java.util.Arrays;

public class MainApp {
    /**
     * Main method to handle command-line input and print sorted numbers.
     *
     * @param args command-line arguments (up to 10 integers)
     */
    public static void main(String[] args) {
        if (args.length > 10) {
            System.out.println("Error: Maximum of 10 integers allowed.");
            return;
        }
        try {
            int[] numbers = Arrays.stream(args)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            epam.example.Sorter.sort(numbers);

            System.out.println("Sorted Numbers: " + Arrays.toString(numbers));
        } catch (NumberFormatException e) {
            System.out.println("Error: Please provide valid integers.");
        }
    }
}
