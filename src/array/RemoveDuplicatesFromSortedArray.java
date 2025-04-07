/*Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).*/
package array;

public class RemoveDuplicatesFromSortedArray {
    // Method to remove duplicates from a sorted array and return the number of unique elements
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueCount = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueCount - 1]) {
                nums[uniqueCount] = nums[i];
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

    // Main method to test the removeDuplicates method
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray remover = new RemoveDuplicatesFromSortedArray();

        // Example test case
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int uniqueCount = remover.removeDuplicates(nums);

        // Output the result
        System.out.println("Number of unique elements: " + uniqueCount);  // Output should be 5

        // Print the modified array with unique elements
        System.out.print("Modified array with unique elements: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
