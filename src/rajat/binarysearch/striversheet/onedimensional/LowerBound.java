package rajat.binarysearch.striversheet.onedimensional;

public class LowerBound {

    /**
     * Finds the lower bound index of the target value in the given sorted array.
     * The lower bound is the smallest index where arr[i] >= target.
     *
     * @param arr    The sorted array in which to find the lower bound index.
     * @param target The target value for which to find the lower bound index.
     * @return The index of the lower bound value, or the index where target should be inserted.
     *         Returns arr.length if no such value exists.
     *
     * Time Complexity: O(log n) - Binary search in a sorted array.
     * Space Complexity: O(1) - Constant space usage.
     */
    public static int lowerBound(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int lower_bound = arr.length; // Initialize lower_bound to arr.length, indicating target not found

        // Binary search loop to find the lower bound index
        while (start <= end) {
            int mid = start + (end - start) / 2; // Calculate mid point to avoid overflow
            if(arr[mid] == target) {
                return arr[mid];
            }
            if (arr[mid] > target) {
                // If the middle element is greater than or equal to the target, update lower_bound and search left
                lower_bound = mid;
                end = mid - 1;
            } else {
                // If the middle element is less than the target, search right
                start = mid + 1;
            }
        }

        return lower_bound; // Return the lower bound index found
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {1, 2, 8, 10, 11, 12, 19};
        int target1 = 0;
        System.out.println("Lower bound index for target " + target1 + ": " + lowerBound(arr1, target1)); // Expected output: 0

        int[] arr2 = {1, 2, 8, 10, 11, 12, 19};
        int target2 = 5;
        System.out.println("Lower bound index for target " + target2 + ": " + lowerBound(arr2, target2)); // Expected output: 2

        int[] arr3 = {1, 2, 8, 10, 11, 12, 19};
        int target3 = 20;
        System.out.println("Lower bound index for target " + target3 + ": " + lowerBound(arr3, target3)); // Expected output: 7
    }
}
