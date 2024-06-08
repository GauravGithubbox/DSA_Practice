package rajat.array;

import java.util.HashMap;
//https://www.interviewbit.com/problems/subarray-with-given-xor/
public class CountSubArrayWithXorK {

    /**
     * Counts the number of subarrays with XOR equal to k using the optimized approach.
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(n), for the HashMap storing prefix XOR values.
     *
     * @param nums The input array of integers.
     * @param k The target XOR value.
     * @return The count of subarrays with XOR equal to k.
     */
    public static int optimizedCountSubArrayWithXorK(int[] nums, int k) {
        int count = 0;
        int xr = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int element : nums) {
            xr ^= element;
            int x = xr ^ k;
            if (map.containsKey(x)) {
                count += map.get(x);
            }
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        return count;
    }

    /**
     * Counts the number of subarrays with XOR equal to k using the brute force approach.
     * Time Complexity: O(n^2), where n is the length of the input array.
     * Space Complexity: O(1), no extra space used.
     *
     * @param nums The input array of integers.
     * @param k The target XOR value.
     * @return The count of subarrays with XOR equal to k.
     */
    public static int bruteForceCountSubarraysWithXorK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int xr = 0;
            for (int j = i; j < nums.length; j++) {
                xr ^= nums[j];
                if (xr == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println("Number of subarrays with XOR " + k + " (Brute Force): " + bruteForceCountSubarraysWithXorK(nums, k));
        System.out.println("Number of subarrays with XOR " + k + " (Optimized): " + optimizedCountSubArrayWithXorK(nums, k));
    }
}
