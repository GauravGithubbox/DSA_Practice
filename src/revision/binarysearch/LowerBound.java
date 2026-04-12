package revision.binarysearch;

public class LowerBound {
    public static void main(String[] args) {
        int[] nums = {3, 5, 8, 15, 19};
        int target = 9;
        int result = lowerBound(nums, target);
        System.out.println("Lower bound " + result);
    }

    private static int lowerBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int result = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
