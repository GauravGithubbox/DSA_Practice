package revision.binarysearch;

public class UpperBound {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        int k = 2;
        int result = upperBound(nums, k);
        System.out.println("Upper Bound " + result);
    }

    private static int upperBound(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int result = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > k) {
                result = mid;
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
