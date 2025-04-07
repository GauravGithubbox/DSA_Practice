package array;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int [] arr = {100000, 3, 4000, 2, 15, 1, 99999};
        int result = firstMissingPositive(arr);
        System.out.println("result = "+result);

    }

    private static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int smallest = 1;

        for (int num : nums) {
            if (num == smallest) {
                smallest++;
            }
        }

        return smallest;

    }
}
