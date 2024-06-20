package rajat.slidingwindow;
//https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class MaxConsecutiveOnes3 {
    public static int longestOnesBruteForce(int[] nums, int k) {
        int maxOnes = 0;

        for (int i = 0; i < nums.length; i++) {
            int zeros = 0;
            int ones = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeros++;
                    if (zeros > k) {
                        break;
                    }
                }
                ones++;
            }
            maxOnes = Math.max(maxOnes, ones);
        }

        return maxOnes;
    }
    public static int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length;
        int ans = 0, zeroCount = 0;

        for(; j < n; j++){
            if(nums[j] == 0){
                zeroCount++;
            }

            while(zeroCount > k){
                if(nums[i] == 0){
                    zeroCount--;
                }
                i++;
                System.out.println(j + " " + i + " Length " + (j - i + 1));
                System.out.println("ZeroCount: " + zeroCount);

            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int output = longestOnes(nums, k);
        System.out.println(output);

        int output2 = longestOnesBruteForce(nums, k);
        System.out.println(output2);
    }
}
