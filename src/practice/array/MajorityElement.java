package practice.array;

import java.util.Arrays;

/*
Given an practice.array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the practice.array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/
public class MajorityElement {
    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2};

        System.out.println(findMajorityElement(nums));
    }

    private static int findMajorityElement(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        System.out.println(" n ="+n);
        for(int nu : nums) {
            System.out.println("nums--->" + nu);
        }
        System.out.println("what data __>"+nums[n/2]);
        return nums[n/2];
    }
}
