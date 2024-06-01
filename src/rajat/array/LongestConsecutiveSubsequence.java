package rajat.array;

import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSubsequence {
    //Time Complexity: O(n*log(n))
    public static int longestConsecutiveSubsequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // Sort the array
        Arrays.sort(arr);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < arr.length; i++) {
            // If current element is the same as the previous (duplicate), skip it
            if (arr[i] == arr[i - 1]) {
                continue;
            }
            // If current element is consecutive to the previous one
            if (arr[i] == arr[i - 1] + 1) {
                currentStreak += 1;
            } else {
                // Reset the current streak
                currentStreak = 1;
            }

            // Update the longest streak
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }

    // Time Complexity : O(n) + O(n) = O(n)
    // Space Complexity: O(n)
    public static int findLongestConsecutiveSubsequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : arr) {
            // Check if it is the start of a sequence
            if (set.contains(num - 1) == false) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the sequence
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 9, 3, 10, 4, 20, 2};
        System.out.println("Length of the longest consecutive subsequence: " + findLongestConsecutiveSubsequence(arr1)); // Output: 4

        int[] arr2 = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
        System.out.println("Length of the longest consecutive subsequence: " + findLongestConsecutiveSubsequence(arr2)); // Output: 5

       // Using Sorting Technique
        System.out.println("Length of the longest consecutive subsequence: " + longestConsecutiveSubsequence(arr1)); // Output: 4
        System.out.println("Length of the longest consecutive subsequence: " + longestConsecutiveSubsequence(arr2)); // Output: 5
    }
}

