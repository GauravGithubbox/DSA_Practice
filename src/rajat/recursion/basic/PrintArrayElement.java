package rajat.recursion.basic;

import java.util.ArrayList;

//  1 to N Without Loop
public class PrintArrayElement {
    // Recursive function to print array elements from start to end
    public static void printArrayFromStart(int[] arr, int index) {
        // Base case: if index reaches the length of the array, stop the recursion
        if (index == arr.length) {
            return;
        }

        // Print the current element
        System.out.print(arr[index] + " ");

        // Recursive call for the next element
        printArrayFromStart(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Array elements printed from start to end:");
        printArrayFromStart(arr, 0);
    }


}
