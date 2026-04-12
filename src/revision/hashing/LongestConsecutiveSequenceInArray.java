package revision.hashing;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequenceInArray {
    public static void main(String[] args) {
        int[] nums = {1, 9, 3, 10, 4, 20, 2};
        int result = longestConsecutives(nums);
        System.out.println("longestConsecutive " + result);
    }

    // optimal
    private static int longestConsecutives(int[] nums) {

        int maxLenght = 0;
        HashSet<Integer> seen = new HashSet<>();
        for (int n : nums) {
            seen.add(n);
            // now as per my understanding the array will look like this [1,2,3,4,9,10,20]
        }
        for (int s : seen) {
            if (!seen.contains(s - 1)) {  // we are checking if the previous value is not present that's means this is the starting point
                int startPoint = s;
                int length = 1;
                while (seen.contains(startPoint + 1)) {  // here we are checking if the next Consecutive element is present that's means this count should be incrase
                    startPoint++;
                    length++;
                }
                maxLenght = Math.max(length, maxLenght);
            }
        }


        return maxLenght;
    }

    private static int longestConsecutivesBruteFource(int[] nums) {
        // for solving this question what i am thinking is we just sort the array
        // after that run a loop from 1 to n and check if i - (i-1) == 1 that's mean this is the consuctive element keep the count ++
        if (nums.length == 0) return 0;

        Arrays.sort(nums);  // The code is functional and clean, but the time complexity is O(N log N) due to sorting. The standard interview expectation for this problem is O(N) using a HashSet.
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                continue; // skip duplicates
            }
            if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                count = 1; // reset
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}

