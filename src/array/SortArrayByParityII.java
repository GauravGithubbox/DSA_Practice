/*Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.



Example 1:

Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
Example 2:

Input: nums = [2,3]
Output: [2,3]*/
package array;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayByParityII {
    public static int[] sortArrayByParityII(int[] nums) {
        int length = nums.length;
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        // Separate the even and odd numbers
        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }

        // Rearrange the array
        for (int i = 0; i < length / 2; i++) {
            nums[2 * i] = even.get(i);
            nums[2 * i + 1] = odd.get(i);
        }

        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        int[] result = sortArrayByParityII(nums);

        System.out.println("Sorted Array by Parity II: " + Arrays.toString(result));
    }
}
