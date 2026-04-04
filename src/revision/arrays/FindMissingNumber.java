package revision.arrays;

import java.util.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 1, 4};
        int result = optimalSolutionForMissingNumbers(nums);
        System.out.println("missingNumber " + result);

    }

    private static int missingNumbers(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            } else {
                return nums.length;
            }
        }
        return -1;
    }


    //
    private static int optimalSolutionForMissingNumbers(int[] nums) {
        int N = nums.length;
        // Summation of first N natural numbers
        int sum1 = (N * (N + 1)) / 2;

        // Summation of all elements in nums
        int sum2 = 0;
        for (int num : nums) {
            sum2 += num;
        }

        // Calculate the missing number
        int missingNum = sum1 - sum2;

        // Return the missing number
        return missingNum;
    }
}
