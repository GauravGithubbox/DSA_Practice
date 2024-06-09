package rajat.array;

import java.util.Arrays;

public class RotateMatrix {

    /**
     * Rotates the given N x N matrix by 90 degrees clockwise.
     *
     * The rotation is performed in two steps:
     * 1. Transposing the matrix.
     * 2. Reversing each row.
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(1) (in-place rotation)
     *
     * @param matrix The N x N matrix to be rotated.
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (swap rows and columns)
        // Swap matrix[i][j] with matrix[j][i] for i < j
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        // Swap matrix[i][left] with matrix[i][right]
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            // Perform swapping from the left and right ends towards the center
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    /**
     * Utility method to print the given matrix in a readable format.
     *
     * @param matrix The matrix to be printed.
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * Main method to demonstrate the rotation of a matrix.
     * Provides a sample matrix, prints it, rotates it by 90 degrees clockwise,
     * and then prints the rotated matrix.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Sample 3x3 matrix
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original matrix:");
        printMatrix(matrix);

        System.out.println("Matrix after rotation:");
        rotate(matrix);
        printMatrix(matrix);
    }
}
