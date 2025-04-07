/*There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.



Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false*/
package binarysearch;

public class SearchInRotatedAndSortedArrayII {
        public static void main(String[] args) {
            int[] arr = {3, 3, 2, 1, 3, 3, 3, 3, 3};
            int target = 6;
            boolean found = search(arr, target);
            if (found) {
                System.out.println("Element " + target + " found in the array.");
            } else {
                System.out.println("Element " + target + " not found in the array.");
            }
        }

        public static boolean search(int[] arr, int k) {
            int n = arr.length; // size of the array.
            int low = 0, high = n - 1;
            while (low <= high) {
                int mid = (low + high) / 2;

                // if mid points the target
                if (arr[mid] == k)
                    return true;

                // Edge case:
                if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                    low = low + 1;
                    high = high - 1;
                    continue;
                }

                // if left part is sorted:
                if (arr[low] <= arr[mid]) {
                    if (arr[low] <= k && k <= arr[mid]) {
                        // element exists:
                        high = mid - 1;
                    } else {
                        // element does not exist:
                        low = mid + 1;
                    }
                } else { // if right part is sorted:
                    if (arr[mid] <= k && k <= arr[high]) {
                        // element exists:
                        low = mid + 1;
                    } else {
                        // element does not exist:
                        high = mid - 1;
                    }
                }
            }
            return false;
        }


}
