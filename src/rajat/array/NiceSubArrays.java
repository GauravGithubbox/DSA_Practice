package rajat.array;

import java.util.HashMap;
import java.util.Map;

public class NiceSubArrays {

    /**
     * Counts the number of nice subarrays in the given nums array.
     *
     * @param nums The input array of integers
     * @param k The number of odd numbers required in a subarray
     * @return The count of nice subarrays
     */
    public static int countNiceSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Initialize with prefix sum 0 having one occurrence.

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            // Increment the prefix sum if the number is odd.
            if (num % 2 == 1) {
                prefixSum++;
            }

            // Check if there is a prefix sum that, when subtracted by k, is already in the map.
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }

            // Update the frequency of the current prefix sum in the map.
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;

        int result = countNiceSubarrays(nums, k);
        System.out.println("Number of nice subarrays: " + result); // Output: 2
    }
}
