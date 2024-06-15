package rajat.binarysearch.striversheet.binarysearchonanswers;
//https://leetcode.com/problems/kth-missing-positive-number/

public class KthMissingPositive {

    /**
     * Brute Force Method to find the Kth missing positive number.
     *
     * This method iterates through the given array and counts how many positive numbers
     * are missing up to the Kth missing number. If a number in the array is less than or
     * equal to the current Kth missing count, it means that number would be accounted
     * for, so we increment K.
     *
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(1), no additional space required.
     *
     * @param arr Sorted array of positive integers.
     * @param k The Kth missing positive number to find.
     * @return The Kth missing positive number.
     */
    public static int findKthPositiveBruteForce(int[] arr, int k) {
        // Iterate through each element in the array
        for (int ele : arr) {
            // If the element is less than or equal to K, it means it's not missing
            if (ele <= k) {
                k++;
            } else {
                // If the current element is greater than K, no need to check further
                break;
            }
        }
        // Return the Kth missing positive number
        return k;
    }

    /**
     * Optimal Method to find the Kth missing positive number using Binary Search.
     *
     * This method uses binary search to find the position where the Kth missing positive
     * number would fit in the sequence. It calculates the number of missing numbers before
     * the current middle element to adjust the search range accordingly.
     *
     * Time Complexity: O(log n), where n is the length of the array.
     * Space Complexity: O(1), no additional space required.
     *
     * @param arr Sorted array of positive integers.
     * @param k The Kth missing positive number to find.
     * @return The Kth missing positive number.
     */
    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;

        // Binary search to find the point where the Kth missing positive number fits
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Calculate the number of missing numbers before arr[mid]
            int missingNumber = arr[mid] - (mid + 1);

            if (missingNumber < k) {
                low = mid + 1; // Move right if fewer missing numbers than K
            } else {
                high = mid - 1; // Move left if there are more or equal missing numbers than K
            }
        }

        // The Kth missing number is found by adding K to the final position (low)
        return low + k;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 7, 11};
        int k = 5;

        // Brute Force Approach
        System.out.println("Brute Force Result: " + findKthPositiveBruteForce(nums, k));
        // Output: 9

        // Optimal Binary Search Approach
        System.out.println("Binary Search Result: " + findKthPositive(nums, k));
        // Output: 9
    }
}
