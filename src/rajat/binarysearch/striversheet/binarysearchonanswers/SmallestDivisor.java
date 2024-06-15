package rajat.binarysearch.striversheet.binarysearchonanswers;

public class SmallestDivisor {
    public static int smallestDivisorBruteForce(int[] nums, int threshold) {
        int low = 1, high  = Integer.MIN_VALUE;
        // Find the maximum value in the array
        for (int num : nums) {
            high = Math.max(high, num);
        }

        for (int i = low; i <= high; i++) {
            if (check(nums, threshold, i)) {
                System.out.println(i);
                return i;
            }
        }

        return -1;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high  = Integer.MIN_VALUE;
        // Find the maximum value in the array
        for (int num : nums) {
            high = Math.max(high, num);
        }
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(check(nums, threshold, mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }

        }
        return ans;
    }

    private static boolean check(int[] nums, int threshold, int divisor) {
        int sum = 0;
        for (int ele : nums) {
            if (ele % divisor == 0) {
                sum += ele / divisor;
            }
            if (ele % divisor != 0) {
                sum += (ele / divisor) + 1;
            }

            if (threshold < sum) {
                return false;
            }

        }

        return threshold >= sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println(smallestDivisorBruteForce(nums, threshold));
        System.out.println(smallestDivisor(nums, threshold));
    }
}
