/*Given an practice.array nums, return true if the practice.array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original practice.array.

Note: An practice.array A rotated by x positions results in an practice.array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.



Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted practice.array.
You can rotate the practice.array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted practice.array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted practice.array.
You can rotate the practice.array by x = 0 positions (i.e. no rotation) to make nums.*/
package practice.array;

public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {


        // Define some test cases
        int[] testCase1 = {3, 4, 5, 1, 2}; // Rotated sorted practice.array
        int[] testCase2 = {2, 1, 3, 4};    // Not a rotated sorted practice.array
        int[] testCase3 = {1, 2, 3, 4};    // Already sorted practice.array
        int[] testCase4 = {1, 3, 2};       // Not a rotated sorted practice.array

        // Check the arrays and print the results
        System.out.println("Test Case 1: " + check(testCase1)); // Expected: true
        System.out.println("Test Case 2: " + check(testCase2)); // Expected: false
        System.out.println("Test Case 3: " + check(testCase3)); // Expected: true
        System.out.println("Test Case 4: " + check(testCase4)); // Expected: false
    }

    public static boolean check(int[] nums) {
        int incorrectRotation = 0;
        int n = nums.length;

        // Loop through the practice.array to count the number of "incorrect" places
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                incorrectRotation++;
            }
        }
        return incorrectRotation > 1 ? false : true;
    }
}
