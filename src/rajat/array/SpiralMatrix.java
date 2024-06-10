package rajat.array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();
        int minRow = 0, minCol = 0;
        int maxRow = matrix.length - 1, maxCol = matrix[0].length - 1;
        int count = 0, totalCount = matrix.length * matrix[0].length;

        while (count < totalCount) {
            // Right Wall
            for (int i = minRow, j = minCol; j <= maxCol && count < totalCount; j++) {
                output.add(matrix[i][j]);
                count++;
            }
            minRow++; // Update after traversing the right wall

            // Down Wall
            for (int i = minRow, j = maxCol; i <= maxRow && count < totalCount; i++) {
                output.add(matrix[i][j]);
                count++;
            }
            maxCol--; // Update after traversing the down wall

            // Bottom Wall
            for (int i = maxRow, j = maxCol; j >= minCol && count < totalCount; j--) {
                output.add(matrix[i][j]);
                count++;
            }
            maxRow--; // Update after traversing the bottom wall

            // Left Wall
            for (int i = maxRow, j = minCol; i >= minRow && count < totalCount; i--) {
                output.add(matrix[i][j]);
                count++;
            }
            minCol++;
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> output = spiralOrder(matrix);
        System.out.println(output);
    }
}
