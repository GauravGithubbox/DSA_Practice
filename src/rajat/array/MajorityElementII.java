package rajat.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/majority-element-ii/description/
public class MajorityElementII {

    /**
     * Function to find all elements that appear more than n/3 times in the array
     * using the Boyer-Moore Voting Algorithm.
     *
     * @param nums The input array of integers.
     * @return A list containing the majority elements.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Initialize two potential candidates and their counts
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        // First pass: Find potential candidates for majority elements
        for (int num : nums) {
            if (count1 == 0 && candidate2 != num) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0 && candidate1 != num) {
                candidate2 = num;
                count2 = 1;
            } else if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Reset counts to validate the candidates
        count1 = 0;
        count2 = 0;

        // Second pass: Count the occurrences of the candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Check if the candidates occur more than n/3 times
        int n = nums.length;
        int threshold = n / 3;

        if (count1 > threshold) {
            result.add(candidate1);
        }
        if (count2 > threshold) {
            result.add(candidate2);
        }

        return result;
    }

    /**
     * Function to find all elements that appear more than n/3 times in the array
     * using a brute-force approach with HashMap.
     *
     * @param nums The input array of integers.
     * @return A list containing the majority elements.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static List<Integer> majorityElementBruteForce(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Check for elements that occur more than n/3 times
        int n = nums.length;
        int threshold = n / 3;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > threshold) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    // Main function to test the MajorityElementII
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 3, 1, 4, 5, 6};

        // Using Boyer-Moore Voting Algorithm
        List<Integer> output = majorityElement(nums);
        System.out.println("Using Boyer-Moore Voting Algorithm: " + output); // Output should be [1]

        // Using Brute Force approach with HashMap
        List<Integer> outputBruteForce = majorityElementBruteForce(nums);
        System.out.println("Using Brute Force approach: " + outputBruteForce); // Output should be [1]
    }
}
