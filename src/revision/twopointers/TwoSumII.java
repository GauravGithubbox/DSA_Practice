package revision.twopointers;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoSum(numbers, target);

        System.out.println("result   =>" + Arrays.toString(result));
    }

    private static int[] findTwoSum(int[] numbers, int target) {
        // in  this question as we can see the practice.array is sorted practice.array and target sum that we need to find
        // this question can be solved using binary search
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            }
            if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }

        }
        return new int[]{-1, -1};
    }
}
