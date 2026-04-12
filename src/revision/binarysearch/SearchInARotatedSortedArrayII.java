package revision.binarysearch;

public class SearchInARotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3, 3, 3, 3};
        int k = 1;
        boolean result = searchInRotatedArray_II(nums, k);
        System.out.println("Search in rotated sorted array " + result);
    }

    private static boolean searchInRotatedArray_II(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        // applying binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // Check if the left part is sorted
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    // Target exists in the left sorted part
                    high = mid - 1;
                } else {
                    // Target does not exist in the left sorted part
                    low = mid + 1;
                }
            } else {
                // Check if the right part is sorted
                if (nums[mid] <= target && target <= nums[high]) {
                    // Target exists in the right sorted part
                    low = mid + 1;
                } else {
                    // Target does not exist in the right sorted part
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
