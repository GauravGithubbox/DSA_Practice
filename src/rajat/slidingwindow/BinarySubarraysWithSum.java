package rajat.slidingwindow;
// https://leetcode.com/problems/binary-subarrays-with-sum/
public class BinarySubarraysWithSum {
    public static int countSubarraysWithSumBruteForce(int[] nums, int goal) {
        int count = 0;
        int n = nums.length;

        // Iterate through all possible subarrays
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];
                // If the sum of the current subarray equals the goal, increment count
                if (sum == goal) {
                    count++;
                }
            }
        }

        return count;
    }

    // Time and Space Complexity O(n) & O(1)
    public static int atMost(int[] nums, int goal){
        int N = nums.length;
        int cnt = 0;
        int ans = 0, i = 0, j = 0;

        for(; j < N; j++) {
            cnt += nums[j];
            while (i <= j && cnt > goal) {
                cnt -= nums[i];
                i++;
            }
            ans += j - i + 1;
        }

        return ans;
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        System.out.println(atMost(nums, goal));
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        int goal = 2;

        int output = numSubarraysWithSum(arr, goal);
        System.out.println(output);

        int output2 = countSubarraysWithSumBruteForce(arr, goal);
        System.out.println(output2);

    }
}
