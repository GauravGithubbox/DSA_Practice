package rajat.binarysearch.striversheet.binarysearchonanswers;

import java.util.Arrays;

public class AggressiveCows {

    /**
     * Helper method to determine if cows can be placed in stalls such that
     * the minimum distance between any two cows is at least 'dist'.
     * Time Complexity: O(n), where n is the number of stalls.
     * Space Complexity: O(1), as no extra space is used other than variables.
     *
     * @param stalls Array of stall positions sorted in increasing order.
     * @param cows The number of cows to place.
     * @param dist The minimum distance to be maintained between any two cows.
     * @return true if we can place all cows with at least 'dist' between them, else false.
     */
    private static boolean canWePlaceCows(int[] stalls, int cows, int dist) {
        int countCows = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0]; // The position of the last placed cow

        for (int i = 1; i < stalls.length; i++) {
            // Check if the current stall can accommodate a cow with at least 'dist' distance
            if (stalls[i] - lastPosition >= dist) {
                countCows++; // Place the cow
                lastPosition = stalls[i]; // Update the last position
            }
            // Optimized early exit if we have already placed all cows
            if (countCows >= cows) {
                return true;
            }
        }
        return countCows >= cows;
    }

    /**
     * Optimal method to find the maximum minimum distance between any two cows using Binary Search.
     *
     * Time Complexity: O(n log d), where n is the number of stalls and d is the distance range.
     * Space Complexity: O(1), no extra space required other than variables.
     *
     * @param stalls Array of stall positions.
     * @param cows The number of cows to place.
     * @return The maximum minimum distance between any two cows.
     */
    private static int findMaxMinDistance(int[] stalls, int cows) {
        Arrays.sort(stalls); // Sort the stalls to apply binary search

        int low = 1; // The minimum possible distance (1 or more to place two cows in adjacent stalls)
        int high = stalls[stalls.length - 1] - stalls[0]; // The maximum possible distance

        int ans = -1; // To store the best result

        // Binary search on the distance
        while (low <= high) {
            int mid = low + (high - low) / 2; // Midpoint of the current search range

            // Check if we can place cows with at least 'mid' distance
            if (canWePlaceCows(stalls, cows, mid)) {
                ans = mid; // Update the answer to the current midpoint
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Reduce the search range
            }
        }

        return ans; // Return the largest minimum distance found
    }

    /**
     * Brute force method to find the maximum minimum distance between any two cows.
     *
     * Time Complexity: O(n * d), where n is the number of stalls and d is the distance range.
     * Space Complexity: O(1), no extra space required other than variables.
     *
     * @param stalls Array of stall positions.
     * @param cows The number of cows to place.
     * @return The maximum minimum distance between any two cows.
     */
    private static int findMaxMinDistanceBruteForce(int[] stalls, int cows) {
        Arrays.sort(stalls); // Sort the stalls to iterate over distances

        int min = stalls[0];
        int max = stalls[stalls.length - 1];

        // Check each possible distance from 1 up to the maximum possible distance
        for (int dist = 1; dist <= (max - min); dist++) {
            // If we can place cows with at least 'dist' distance, continue checking larger distances
            if (canWePlaceCows(stalls, cows, dist)) {
                continue;
            } else {
                // The largest possible distance for which placement is successful is dist - 1
                return dist - 1;
            }
        }
        return -1; // If no valid distance found, return -1
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 8, 4, 9}; // Array of stall positions
        int cows = 3; // Number of cows to place

        // Find the maximum minimum distance using the brute force method
        int output1 = findMaxMinDistanceBruteForce(stalls, cows);
        System.out.println("Brute Force Result: " + output1); // Output: 3

        // Find the maximum minimum distance using the binary search method
        int output2 = findMaxMinDistance(stalls, cows);
        System.out.println("Binary Search Result: " + output2); // Output: 3
    }
}
