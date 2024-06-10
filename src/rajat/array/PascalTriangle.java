package rajat.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {

    /**
     * Generates Pascal's Triangle with the given number of rows.
     *
     * @param numRows The number of rows to generate in Pascal's Triangle.
     * @return A list of lists, where each list represents a row in Pascal's Triangle.
     *
     * Time Complexity: O(numRows^2)
     * Space Complexity: O(numRows^2)
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();

        // Add the first row (always [1]).
        output.add(Arrays.asList(1));

        // Generate each row from the second row to the numRows-th row.
        for (int i = 1; i < numRows; i++) {
            // Initialize the new row with the first element as 1.
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            // Calculate the intermediate values for the current row.
            // Each value is the sum of the two values above it from the previous row.
            for (int j = 1; j < i; j++) {
                int sum = output.get(i - 1).get(j - 1) + output.get(i - 1).get(j);
                currentRow.add(sum);
            }

            // Add the last element as 1.
            currentRow.add(1);

            // Add the current row to the output list.
            output.add(currentRow);
        }

        return output;
    }

    /**
     * Main method to test the Pascal's Triangle generation.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int n = 5; // Define the number of rows for Pascal's Triangle
        List<List<Integer>> output = generate(n); // Generate Pascal's Triangle
        System.out.println(output); // Print the generated triangle
    }
}
