package rajat.recursion.striver.subsequence;

//https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
public class CountAllSubsequenceSumK {

    /**
     * This helper function recursively counts the number of subsequences in the array
     * whose sum equals the target value 'k'.
     *
     * @param nums  The input array of integers.
     * @param index The current index in the array being considered.
     * @param sum   The current sum of the chosen subsequence.
     * @param k     The target sum for the subsequences.
     * @return The count of subsequences whose sum equals 'k'.
     * <p>
     * Time Complexity: O(2^n) - Each element has two choices: either be included or excluded.
     * Space Complexity: O(n) - Maximum depth of the recursion tree.
     */
    private static int countSubsequenceWithKHelper(int[] nums, int index, int sum, int k) {
        // Base case: if we've considered all elements
        if (index == nums.length) {
            // Check if the current sum equals the target sum 'k'
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        // Include the current element and add it to the sum
        int count1 = countSubsequenceWithKHelper(nums, index + 1, sum + nums[index], k);
        // Exclude the current element and keep the sum as it is
        int count2 = countSubsequenceWithKHelper(nums, index + 1, sum, k);

        // Return the total count of subsequences that sum to 'k'
        return count1 + count2;
    }

    /**
     * This function initiates the recursive process to count subsequences
     * whose sum equals the target value 'k'.
     *
     * @param nums The input array of integers.
     * @param k    The target sum for the subsequences.
     * @return The count of subsequences whose sum equals 'k'.
     */
    public static int countSubsequenceWithK(int[] nums, int k) {
        return countSubsequenceWithKHelper(nums, 0, 0, k);
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {10, 20, 30, 40, 50};
        int k1 = 70;
        int output1 = countSubsequenceWithK(nums1, k1);
        System.out.println("Test Case 1 - Expected Output: 3, Actual Output: " + output1);
        // Explanation: {10, 20, 40}, {20, 50}, {30, 40} are the subsequences with sum 70.

        // Test Case 2
        int[] nums2 = {2, 3, 5, 8, 10};
        int k2 = 10;
        int output2 = countSubsequenceWithK(nums2, k2);
        System.out.println("Test Case 2 - Expected Output: 3, Actual Output: " + output2);
        // Explanation: {2, 8}, {3, 5, 2}, {10} are the subsequences with sum 10.

        // Test Case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 5;
        int output3 = countSubsequenceWithK(nums3, k3);
        System.out.println("Test Case 3 - Expected Output: 3, Actual Output: " + output3);
        // Explanation: {2, 3}, {5}, {1, 4} are the subsequences with sum 5.
    }
}
