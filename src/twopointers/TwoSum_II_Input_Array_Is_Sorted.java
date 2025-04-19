package twopointers;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSum_II_Input_Array_Is_Sorted {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = calculateTwoSum(nums, target);
        for (int re : result) {
            System.out.println("response --" + re);
        }
    }

    private static int[] calculateTwoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{start, end};
            } else if (nums[start] + nums[end] < target) {
                start++;

            } else {
                end--;
            }
        }
        return new int[]{0, 0};
    }
}
