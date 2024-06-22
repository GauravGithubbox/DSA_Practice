package rajat.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
//https://leetcode.com/problems/subarrays-with-k-different-integers/
public class SubarraysWithKDifferentIntegers {

    /**
     * Brute force method to find the number of subarrays with exactly `k` distinct integers.
     *
     * @param nums The input array of integers.
     * @param k The exact number of distinct integers required in the subarrays.
     * @return The number of subarrays with exactly `k` distinct integers.
     *
     * Time Complexity: O(N^3), where N is the length of the array.
     * Space Complexity: O(K), where K is the number of distinct integers in a subarray.
     */
    public int subarraysWithKDistinctBruteForce(int[] nums, int k) {
        int count = 0;

        // Iterate over all possible subarrays
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> distinctElements = new HashSet<>();

            for (int j = i; j < nums.length; j++) {
                distinctElements.add(nums[j]);

                // Check if the number of distinct integers in the subarray equals `k`
                if (distinctElements.size() == k) {
                    count++;
                } else if (distinctElements.size() > k) {
                    // No need to proceed further as the count of distinct integers exceeds `k`
                    break;
                }
            }
        }

        return count;
    }

    /**
     * Optimized method using sliding window to find the number of subarrays with exactly `k` distinct integers.
     *
     * @param nums The input array of integers.
     * @param k The exact number of distinct integers required in the subarrays.
     * @return The number of subarrays with exactly `k` distinct integers.
     *
     * Time Complexity: O(N), where N is the length of the array.
     * Space Complexity: O(K), where K is the number of distinct integers tracked in the HashMap.
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    /**
     * Helper method to calculate the number of subarrays with at most `k` distinct integers.
     *
     * @param nums The input array of integers.
     * @param k The maximum number of distinct integers allowed in the subarrays.
     * @return The number of subarrays with at most `k` distinct integers.
     *
     * Time Complexity: O(N), where N is the length of the array.
     * Space Complexity: O(K), where K is the number of distinct integers tracked in the HashMap.
     */
    private int atMost(int[] nums, int k) {
        int i = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Use sliding window approach to find subarrays with at most k distinct integers
        for (int j = 0; j < nums.length; j++) {
            // Increment the count of the current element in the window
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // If there are more than `k` distinct integers, shrink the window from the left
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            // Count the number of valid subarrays ending at `j`
            count += j - i + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraysWithKDifferentIntegers solver = new SubarraysWithKDifferentIntegers();

        // Test Case 1
        int[] nums1 = {1, 2, 1, 2, 3};
        int k1 = 2;
        int result1 = solver.subarraysWithKDistinct(nums1, k1);
        System.out.println("Optimized - Test Case 1: Expected 7, Got: " + result1);
        int result1BruteForce = solver.subarraysWithKDistinctBruteForce(nums1, k1);
        System.out.println("Brute Force - Test Case 1: Expected 7, Got: " + result1BruteForce);

        // Test Case 2
        int[] nums2 = {1, 2, 1, 3, 4};
        int k2 = 3;
        int result2 = solver.subarraysWithKDistinct(nums2, k2);
        System.out.println("Optimized - Test Case 2: Expected 3, Got: " + result2);
        int result2BruteForce = solver.subarraysWithKDistinctBruteForce(nums2, k2);
        System.out.println("Brute Force - Test Case 2: Expected 3, Got: " + result2BruteForce);

        // Test Case 3
        int[] nums3 = {2, 1, 2, 1, 2};
        int k3 = 2;
        int result3 = solver.subarraysWithKDistinct(nums3, k3);
        System.out.println("Optimized - Test Case 3: Expected 10, Got: " + result3);
        int result3BruteForce = solver.subarraysWithKDistinctBruteForce(nums3, k3);
        System.out.println("Brute Force - Test Case 3: Expected 10, Got: " + result3BruteForce);
    }
}
