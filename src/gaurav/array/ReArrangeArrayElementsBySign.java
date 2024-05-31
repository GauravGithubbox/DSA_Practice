/*You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.



Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.
Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
*/
package gaurav.array;

import java.util.ArrayList;
import java.util.Arrays;

public class ReArrangeArrayElementsBySign {
    public static int[] rearrangeArray(int[] nums) {
        int length = nums.length;
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        // Separate the positive and negative numbers
        for (int num : nums) {
            if (num < 0) {
                negative.add(num);
            } else {
                positive.add(num);
            }
        }
        // Rearrange the array
        for (int i = 0; i < length / 2; i++) {
            nums[2 * i] = positive.get(i);
            nums[2 * i + 1] = negative.get(i);
        }
        return nums;
    }

        public static void main(String[] args) {
            int[] nums = {3, 1, -2, -5, 2, -4};
            int[] result = rearrangeArray(nums);

            System.out.println("Rearranged Array: " + Arrays.toString(result));
        }
}