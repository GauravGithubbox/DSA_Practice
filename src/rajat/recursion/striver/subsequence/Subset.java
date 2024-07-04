package rajat.recursion.striver.subsequence;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class Subset {

    /**
     * Helper method to generate all subsets of the given array recursively.
     *
     * @param nums The input array of integers.
     * @param index The current index in the array being considered.
     * @param currentSubset The current subset being built.
     * @param output The list to store all subsets.
     *
     * Time Complexity: O(2^n) - Each element has two choices: include it or exclude it, leading to 2^n subsets.
     * Space Complexity: O(n) - The depth of the recursion tree is n, plus additional space for storing the subsets.
     */
    public static void subsetHelper(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> output) {
        // Base case: if we've considered all elements
        if (nums.length == index) {
            // Add the current subset to the output
            output.add(new ArrayList<>(currentSubset));
            return;
        }

        // Include the current element in the subset
        currentSubset.add(nums[index]);
        subsetHelper(nums, index + 1, currentSubset, output);

        // Backtrack: remove the current element from the subset
        currentSubset.remove(currentSubset.size() - 1);
        // Exclude the current element from the subset
        subsetHelper(nums, index + 1, currentSubset, output);
    }

    /**
     * Main method to initiate the process of generating all subsets.
     *
     * @param nums The input array of integers.
     * @return A list of all subsets of the input array.
     */
    public static List<List<Integer>> subsets(int[] nums) {
        // Output list to store all subsets
        List<List<Integer>> output = new ArrayList<>();
        // Temporary list to store the current subset
        List<Integer> currentSubset = new ArrayList<>();

        // Start the recursive process to generate all subsets
        subsetHelper(nums, 0, currentSubset, output);
        return output;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> output1 = subsets(nums1);
        System.out.println("Test Case 1 - Expected Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]");
        System.out.println("Actual Output: " + output1);

        // Test Case 2
        int[] nums2 = {4, 5};
        List<List<Integer>> output2 = subsets(nums2);
        System.out.println("Test Case 2 - Expected Output: [[], [4], [4, 5], [5]]");
        System.out.println("Actual Output: " + output2);

        // Test Case 3
        int[] nums3 = {1, 2};
        List<List<Integer>> output3 = subsets(nums3);
        System.out.println("Test Case 3 - Expected Output: [[], [1], [1, 2], [2]]");
        System.out.println("Actual Output: " + output3);
    }
}
