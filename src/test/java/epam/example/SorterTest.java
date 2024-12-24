package epam.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SorterTest {

    private final int[] inputArray;
    private final int[] expectedSortedArray;
    private final int numberToValidate;
    private final boolean isNumberValid;

    /**
     * Constructor for injecting parameters into the test.
     *
     * @param inputArray           Array to sort (null for validation-only tests).
     * @param expectedSortedArray  Expected sorted result (null for validation-only tests).
     * @param numberToValidate     Number to validate.
     * @param isNumberValid        Expected validation result.
     */
    public SorterTest(int[] inputArray, int[] expectedSortedArray, int numberToValidate, boolean isNumberValid) {
        this.inputArray = inputArray;
        this.expectedSortedArray = expectedSortedArray;
        this.numberToValidate = numberToValidate;
        this.isNumberValid = isNumberValid;
    }

    /**
     * Define test parameters for both sorting and validation.
     *
     * @return Collection of test data.
     */
    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                // Test cases for sorting
                {new int[]{5, 2, 8, 1, 3}, new int[]{1, 2, 3, 5, 8}, 5, true},  // Sorting and valid number
                {new int[]{}, new int[]{}, 0, false},                          // Empty array and invalid number
                {new int[]{7}, new int[]{7}, 10, true},                        // Single element and valid number
                {new int[]{9, 1, 5}, new int[]{1, 5, 9}, 11, false},           // Normal sorting and invalid number

                // Test cases for validation
                {null, null, -1, false},                                       // Negative number (invalid)
                {null, null, -100, false},                                    // Three-digit negative number (invalid)
                {null, null, 100, false},                                     // Three-digit positive number (invalid)
                {null, null, 1, true},                                        // Boundary valid number
                {null, null, 10, true}                                        // Upper boundary valid number
        });
    }

    @Test
    public void testSort() {
        if (inputArray != null && expectedSortedArray != null) {
            Sorter.sort(inputArray);
            assertArrayEquals(expectedSortedArray, inputArray);
        }
    }

    @Test
    public void testNumberValidation() {
        assertEquals(isNumberValid, Sorter.isValidNumber(numberToValidate));
    }
}