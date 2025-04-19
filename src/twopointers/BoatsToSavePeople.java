package twopointers;

import java.util.Arrays;

//https://leetcode.com/problems/boats-to-save-people/description/
public class BoatsToSavePeople {
    public static void main(String[] args) {
        int [] nums= {1,1,2,2,3};
        int limit = 3;
        System.out.println(numberOfRescueBoats(nums , limit));
    }

    private static int numberOfRescueBoats(int[] nums, int limit) {
        Arrays.sort(nums);
        int boats = 0;
        int first = 0;
        int last = nums.length - 1;

        while (first <= last) {
            if (nums[first] + nums[last] <= limit) {
                first++; // Pair the lightest with the heaviest
            }
            last--; // Always move the heavier person
            boats++; // One boat used
        }

        return boats;
    }

}
