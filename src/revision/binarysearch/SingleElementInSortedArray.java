package revision.binarysearch;

import java.util.HashMap;
import java.util.Map;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {-8843, -8843, -7785, -7785, -6540, -6540, -98, -98, 268, 268, 706, 706, 848, 848, 1078, 7175, 7175, 8898, 8898};
        int result = findSingleNonDuplicateOptimizeSolution(nums);
        System.out.println("findSingleNonDuplicate " + result);

    }

    private static int findSingleNonDuplicateOptimizeSolution(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Make sure mid is even
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;  // move right
            } else {
                high = mid;     // move left
            }
        }

        return nums[low];
    }

    // this is a brute force approach we need to optimize this
    private static int findSingleNonDuplicate(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;

    }
}
