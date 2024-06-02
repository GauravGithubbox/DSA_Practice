package rajat.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/majority-element/description/
public class MajorityElement {

    /**
     * Finds the majority element using brute force.
     * A majority element appears more than n/2 times in the array.
     *
     * @param nums The input array of integers.
     * @return The majority element, or 0 if no majority element exists.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int majorityElement_bruteForce(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int majorityElement = 0;
        int n = nums.length;

        // Count the frequency of each element
        for (int ele : nums) {
            mp.put(ele, mp.getOrDefault(ele, 0) + 1);
        }

        // Find the element with a frequency greater than n/2
        for (Map.Entry<Integer, Integer> pair : mp.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
            if (pair.getValue() > n / 2) {
                majorityElement = pair.getKey();
            }
        }
        return majorityElement;
    }

    /**
     * Finds the majority element using Moore's Voting Algorithm.
     * A majority element appears more than n/2 times in the array.
     *
     * @param nums The input array of integers.
     * @return The majority element, or -1 if no majority element exists.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int majorityElement(int[] nums) {
        int element = Integer.MIN_VALUE;
        int count = 0;
        int n = nums.length;

        // Phase 1: Find a candidate for the majority element
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = nums[i];
            } else if (element == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Verify the candidate is the majority element
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == element) {
                cnt1++;
            }
        }

        if (cnt1 > n / 2) {
            return element;
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1, 2, 2};

        // Uncomment the following line to test the brute force method
        // int output = majorityElement_bruteForce(nums);
        // System.out.println(output);

        // Test Moore's Voting Algorithm method
        int output2 = majorityElement(nums);
        System.out.println(output2);
    }
}
