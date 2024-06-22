package rajat.slidingwindow.practice;

public class LongestSubArrayWithOneDeletion {
    public static int longestSubarray(int[] nums) {
        int i = 0, j = 0, zeroCount = 0, maxLen = 0;

        for(;j < nums.length; j++) {
            if(nums[j] == 0) {
                zeroCount++;
            }
            while(zeroCount > 1) {
                if(nums[i] == 0){
                    zeroCount--;
                }
                i++;
            }
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }
    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = {1, 0, 1, 1, 0};
        System.out.println("Test Case 1: " + longestSubarray(nums1)); // Output: 4

        // Test Case 2
        int[] nums2 = {0, 1, 0, 0, 1, 1, 0, 1};
        System.out.println("Test Case 2: " + longestSubarray(nums2)); // Output: 5

        // Test Case 3
        int[] nums3 = {1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println("Test Case 3: " + longestSubarray(nums3)); // Output: 7
    }
}
