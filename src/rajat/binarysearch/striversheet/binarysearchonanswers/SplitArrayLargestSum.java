package rajat.binarysearch.striversheet.binarysearchonanswers;

import java.util.Arrays;
//https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum {

    /**
     * Helper method to determine if it's possible to split the array into k subarrays
     * such that the largest sum of any subarray does not exceed the given max sum.
     *
     * @param nums The array of integers to split.
     * @param k The number of subarrays to split into.
     * @param max The maximum allowable sum for any subarray.
     * @return True if it's possible to split the array as required, otherwise false.
     *
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(1), only a few extra variables are used.
     */
    public static boolean isPossibleToSplit(int[] nums, int k, int max) {
        int count = 1; // Initialize count of subarrays needed
        int sum = 0;   // Current subarray sum

        for (int element : nums) {
            sum += element;
            if (sum > max) {
                // Start a new subarray
                count++;
                sum = element;
            }
        }

        // Check if the number of subarrays is within the allowed number
        return k >= count;
    }

    /**
     * Method to find the minimum possible largest sum when splitting the array into k subarrays.
     *
     * @param nums The array of integers to split.
     * @param k The number of subarrays to split into.
     * @return The minimum possible largest sum among k subarrays.
     *
     * Time Complexity: O(n log(sum)), where n is the length of the array.
     * Space Complexity: O(1), uses only a few extra variables.
     */
    public static int splitArray(int[] nums, int k) {
        // The minimum possible sum is the largest single element in the array.
        int low = Arrays.stream(nums).max().orElseThrow();

        // The maximum possible sum is the sum of all elements in the array.
        int high = Arrays.stream(nums).sum();

        int ans = -1; // To store the result (minimum possible largest sum)

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossibleToSplit(nums, k, mid)) {
                // If it's possible to split with the current max sum, try for a smaller value
                ans = mid;
                high = mid - 1;
            } else {
                // If not possible, try for a larger max sum
                low = mid + 1;
            }
        }

        return ans; // The minimum possible largest sum
    }

    public static void main(String[] args) {
        // Test Case 1: Basic scenario with a clear optimal split
        int[] books1 = {7, 2, 5, 10, 8};
        int students1 = 2;
        System.out.println("Test Case 1 (Expected 18): " + splitArray(books1, students1));

        // Test Case 2: Each element is its own subarray
        int[] books2 = {1, 2, 3, 4, 5};
        int students2 = 5;
        System.out.println("Test Case 2 (Expected 5): " + splitArray(books2, students2));

        // Test Case 3: All elements are large and need careful balancing
        int[] books3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int students3 = 3;
        System.out.println("Test Case 3 (Expected 17): " + splitArray(books3, students3));
    }
}
