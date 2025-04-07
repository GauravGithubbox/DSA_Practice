package array;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums ={ 100,4,200,1,3,2};
        int result = longestConsecutive(nums);
        System.out.println("result="+result);
    }

    private static int longestConsecutive(int[] nums) {
        int count =0;
        Arrays.sort(nums);
        for(int i =1;i<nums.length-1;i++){
            if((nums[i] - nums[i-1]) == 1){
                count++;
            }
        }
        return count;

    }
}
