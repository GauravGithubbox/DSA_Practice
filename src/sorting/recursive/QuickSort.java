package sorting.recursive;

public class QuickSort {

    // Swap function to exchange elements at indices i and j
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Function to sort an array using the Quick Sort algorithm.
     *
     * @param arr   The array to be sorted
     * @param start The starting index of the segment to be sorted
     * @param end   The ending index of the segment to be sorted
     *
     * Time Complexity: O(n log n) on average, O(n^2) in the worst case.
     * Space Complexity: O(log n) due to recursion stack.
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, start, end);

            // Recursively sort elements before partition and after partition
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    /**
     * Partition function with arr[start] as the pivot.
     *
     * @param arr   The array to be partitioned
     * @param start The starting index of the segment to be partitioned
     * @param end   The ending index of the segment to be partitioned
     * @return      The index of the pivot element after partition
     *
     * Time Complexity: O(n), where n is the number of elements in the segment.
     * Space Complexity: O(1).
     */
    public static int partition(int[] arr, int start, int end) {
        int pivotElement = arr[start]; // Choose the first element as pivot
        int pivotIndex = start; // Initial pivot index

        // Rearrange the elements based on the pivot
        for (int j = pivotIndex + 1; j <= end; j++) {
            // If the current element is less than the pivot, swap it with the element at pivotIndex + 1
            if (arr[j] < pivotElement) {
                pivotIndex++;
                swap(arr, j, pivotIndex);
            }
        }

        // Place the pivot element in its correct position
        swap(arr, start, pivotIndex);
        return pivotIndex;
    }

    // Main function to test the Quick Sort
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        int n = arr.length;
        int start = 0, end = n - 1;

        // Sort the array
        quickSort(arr, start, end);

        // Print the sorted array
        System.out.println("Sorted array: ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
}
