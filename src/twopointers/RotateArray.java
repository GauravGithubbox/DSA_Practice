package twopointers;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/description/
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};   // -------> [5,6,7,1,2,3,4]
        int k = 3;
        rotateArray(nums,k);
    }

    private static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // In case k is greater than the length of the array
        // [1,2,3,4,5,6,7] let’s take this example and k = 3
        // k=k%n , k = 3%7
        // k = 3 (remendir)
        reverse(nums, 0, n - 1); // first rotate the whole array [7,6,5,4,3,2,1]
        reverse(nums, 0, k - 1); // Then rotate array [ 0 to 2] that’s [5,6,7,4,3,2,1]
        reverse(nums, k, n - 1); // now rotat
        for(int num : nums){
            System.out.print(num + " ");
        }

    }
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
