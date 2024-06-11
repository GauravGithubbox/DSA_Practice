package rajat.binarysearch.striversheet.onedimensional;

import java.util.Arrays;

public class FindCeil {
    public static int findCeil(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ceil = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                ceil = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 10, 10, 12, 19};
        int target = 5;
        System.out.println(findCeil(nums, target));
    }
}


