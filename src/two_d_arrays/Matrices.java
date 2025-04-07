package two_d_arrays;

import java.util.Scanner;

// I need create a function to accept the matrix number and print the number as well
// we also need to create the search function to find the index of the key
public class Matrices {
    public static boolean searchElement(int [][] matrix , int key){
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j]==key){
                    System.out.println("index = "+i + " " + j);
                    return true;
                }
            }
        }
        return  false;
    }
    public static void main(String[] args) {
        int [][] matrix = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                matrix[i][j]=scanner.nextInt();
            }
        }
        // now print the matrix
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        searchElement(matrix,9);
    }
}
