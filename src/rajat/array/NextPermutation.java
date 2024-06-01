package rajat.array;

import java.util.Arrays;
//https://leetcode.com/problems/next-permutation/description/
public class NextPermutation {
    public static void swap (int[] a, int i, int j) {
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }
    public static void reverse(int nums[], int start, int end){
        while(start < end){
            int c = nums[start];
            nums[start] = nums[end];
            nums[end] = c;

            start++;
            end--;
        }
    }
    public static void nextPermutation(int[] nums) {
        int breakPointIndex = -1;
        int n = nums.length;

        for(int i = n - 2; i >= 0; i--) {
            if(nums[i + 1] > nums[i]) {
                breakPointIndex = i;
                break;
            }
        }

        if(breakPointIndex == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // step 2
        for(int i = n - 1; i >= breakPointIndex; i--) {
            if(nums[i] > nums[breakPointIndex]){
                swap(nums, i, breakPointIndex);
                break;
            }
        }

        reverse(nums, breakPointIndex + 1, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 4, 3, 0, 0};
        nextPermutation(nums);
        Arrays.stream(nums).forEach(a -> System.out.print(a + " "));
    }
}
