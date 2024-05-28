package sorting.iterative;

//https://www.geeksforgeeks.org/problems/bubble-sort/1
// Total number of passes : n - 1
// Total number of comparisions : n(n-1)/2
// Time Complexity : O(n^2)

public class BubbleSort {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        int n = arr.length;
        bubbleSort(arr, n);

        // Print the sorted array
        System.out.println("Sorted array: ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

}
