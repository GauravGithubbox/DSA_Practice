/*Given a binary array nums, return the maximum number of consecutive 1's in the array.



Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2*/
package array;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {


        int[] testCase1 = {1, 1, 0, 1, 1, 1}; // Longest sequence of 1s is 3
        int[] testCase2 = {1, 0, 1, 1, 0, 1}; // Longest sequence of 1s is 2
        int[] testCase3 = {0, 0, 0, 0};       // No 1s, so result is 0
        int[] testCase4 = {1, 1, 1, 1};       // All 1s, so result is 4
        int[] testCase5 = {1, 0, 0, 1, 0, 1}; // Longest sequence of 1s is 1

        // Check the arrays and print the results
        System.out.println("Test Case 1: " + findMaxConsecutiveOnes(testCase1)); // Expected: 3
        System.out.println("Test Case 2: " + findMaxConsecutiveOnes(testCase2)); // Expected: 2
        System.out.println("Test Case 3: " + findMaxConsecutiveOnes(testCase3)); // Expected: 0
        System.out.println("Test Case 4: " + findMaxConsecutiveOnes(testCase4)); // Expected: 4
        System.out.println("Test Case 5: " + findMaxConsecutiveOnes(testCase5)); // Expected: 1
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }
        return maxCount;

    }
}
