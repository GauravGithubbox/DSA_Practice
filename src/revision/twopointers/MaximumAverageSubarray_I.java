package revision.twopointers;

public class MaximumAverageSubarray_I {
    public static void main(String[] args) {
        int nums[] = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double result = findMaxAverage(nums, k);
        System.out.println("max average =" + result);
    }

    private static double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        // first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // slide window
        for (int i = k; i < nums.length; i++) {

            sum = sum - nums[i - k]; // remove left element
            sum = sum + nums[i];     // add new element

            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;

    }
}
