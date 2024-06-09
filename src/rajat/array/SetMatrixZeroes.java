package rajat.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}


public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair> zeroCordinates = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    Pair p = new Pair(i, j);
                    zeroCordinates.add(p);
                }
            }
        }

        for (Pair p : zeroCordinates) {
            int row = p.row;
            int col = p.col;

            setZeroesHelper(matrix, row, col);
        }
    }

    private static void setZeroesHelper(int[][] matrix, int row, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println("Original matrix:");
        printMatrix(matrix1);
        setZeroes(matrix1);
        System.out.println("Matrix after setZeroes:");
        printMatrix(matrix1);
    }
}
