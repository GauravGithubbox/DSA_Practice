package gaurav;//----------------------Question--------------------------
/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

        Example 1:

        Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4]
        Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]
        Example 2:

        Input: nums = [-1,-100,3,99], k = 2
        Output: [3,99,-1,-100]
        Explanation:
        rotate 1 steps to the right: [99,-1,-100,3]
        rotate 2 steps to the right: [3,99,-1,-100]
*/

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // If k is greater than the length of the array, we only need to rotate k % n times
        k = k % n;

        // Step 1: Reverse the entire array
        // Example: [1,2,3,4,5,6,7] becomes [7,6,5,4,3,2,1]
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        // After reversing the first 3 elements: [7,6,5,4,3,2,1] becomes [5,6,7,4,3,2,1]
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements from k to the end
        // After reversing elements from index 3 to 6: [5,6,7,4,3,2,1] becomes [5,6,7,1,2,3,4]
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        // Helper function to reverse elements in the array between indices start and end
        while (start < end) {
            // Swap elements at start and end
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            // Move towards the middle
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();

        // Example array and rotation value
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        // Print the original array
        System.out.println("Original array: ");
        printArray(nums);

        // Call the rotate method
        solution.rotate(nums, k);

        // Print the rotated array
        System.out.println("Rotated array: ");
        printArray(nums);
    }

    // Helper method to print the array
    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}