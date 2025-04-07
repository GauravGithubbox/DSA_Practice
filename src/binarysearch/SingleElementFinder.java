package binarysearch;
//https://leetcode.com/problems/single-element-in-a-sorted-array/description/
public class SingleElementFinder {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};

        System.out.println("The single element in the first array is: " + findSingleElement(nums1));
        System.out.println("The single element in the second array is: " + findSingleElement(nums2));
    }

    public static int findSingleElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Ensure mid is even for comparison
            if (mid % 2 == 1) {
                mid--;
            }
            // Check if the next element is the same
            if (nums[mid] == nums[mid + 1]) {
                // Move to the right half
                low = mid + 2;
            } else {
                // Move to the left half
                high = mid;
            }
        }

        // When low == high, we found the single element
        return nums[low];
    }
}
