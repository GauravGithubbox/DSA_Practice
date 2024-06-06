/*Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4*/
package gaurav.binarysearch;

public class SearchInsertPosition {

    // Method to find the insert position of target in a sorted array
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // Main method to test the searchInsert method
    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

        // Example array and target value
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        // Call the searchInsert method and print the result
        int result = searchInsertPosition.searchInsert(nums, target);
        System.out.println("Insert position of target " + target + " is: " + result);

        // Test with another target value
        target = 2;
        result = searchInsertPosition.searchInsert(nums, target);
        System.out.println("Insert position of target " + target + " is: " + result);

        // Test with another target value
        target = 7;
        result = searchInsertPosition.searchInsert(nums, target);
        System.out.println("Insert position of target " + target + " is: " + result);

        // Test with another target value
        target = 0;
        result = searchInsertPosition.searchInsert(nums, target);
        System.out.println("Insert position of target " + target + " is: " + result);
    }
}
