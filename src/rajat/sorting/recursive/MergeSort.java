package rajat.sorting.recursive;
//https://www.geeksforgeeks.org/problems/merge-sort/1

public class MergeSort {
    /**
     * Merges two sorted subarrays of arr[].
     * First subarray is arr[start..mid]
     * Second subarray is arr[mid+1..end]
     *
     * @param arr The main array containing the subarrays to be merged.
     * @param start The starting index of the first subarray.
     * @param mid The ending index of the first subarray.
     * @param end The ending index of the second subarray.
     */
    private static void merge(int[] arr, int start, int mid, int end) {
        // Temporary array to store the merged result
        int[] temp = new int[end - start + 1];
        int i = start;    // Initial index of the first subarray
        int j = mid + 1;  // Initial index of the second subarray
        int k = 0;        // Initial index of the merged array

        // Merge the two subarrays into the temporary array
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy any remaining elements of the first subarray
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy any remaining elements of the second subarray
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // Copy the merged elements back into the original array
        System.arraycopy(temp, 0, arr, start, temp.length);
    }

    /**
     * A utility method to print the array.
     *
     * @param arr The array to be printed.
     */
    private static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Main method to test the merge function.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int start = 0;
        int mid = (arr.length - 1) / 2;
        int end = arr.length - 1;

        System.out.println("Array before merging:");
        printArray(arr);

        merge(arr, start, mid, end);

        System.out.println("Array after merging:");
        printArray(arr);
    }
}
