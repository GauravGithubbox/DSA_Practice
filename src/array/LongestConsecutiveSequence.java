package array;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums ={ 100,4,200,1,3,2};
        int result = longestConsecutive(nums);
        System.out.println("result="+result);
    }

    private static int longestConsecutive(int[] nums) {
        // Step 1: Put all the numbers in a HashSet to allow O(1) lookups
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        int maxCount = 0;
        // Step 2: Iterate through each number in the set
        for (int num : seen) {
            // Check if this number is the start of a sequence
            if (!seen.contains(num - 1)) {

                int currentNum = num;
                int count = 1;

                // Count the length of the sequence
                while (seen.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                // Update the maximum length of consecutive sequence
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}

// Dry Run
/*
seen = [100,4,200,1,3,2]
maxCount =0
iteration 1 ---> 100 ---> check 100-1 ---> 99 is not present ---> no action
iteration 2 ---> 4 ---> check 4-1 ---> 3 present
        currentNum = 4 COUNT 1
        while(5) ---> false
iteration 3 ---> 200 ---> check 200-1 ---> 199 is not present ---> no action
iteration 4 ---> 1 check 1-1 ---> 0 is not present ---> no action
iteration 5 ---> 3 check 3-2 is present
            currentNum = 3
            while(3+1) ---> true
            currntNum = 4
            count = 2
            ---> now the condition is false
iteration 6 ---> 2 ---> check 2-1 = 1 ---> present
        currntNum = 2
        count = 1
        while(3)
        currentNum = 3
        count = 2
        while(4)
        currentNum = 4
        count =3
        while(5)---> false

        }

        after loop the answer will be 3 then how we are getting 4


* */





