package rajat.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
    /**
     * Brute-force method to find the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return  The length of the longest substring without repeating characters.
     *
     * Time Complexity: O(n^3), where n is the length of the string.
     * Space Complexity: O(min(n, m)), where n is the length of the string and m is the size of the character set.
     */
    public int lengthOfLongestSubstringBruteForce(String s) {
        int n = s.length();
        int maxLength = 0;

        // Iterate over every possible substring
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Check if the substring from i to j has all unique characters
                if (allUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    /**
     * Helper method to check if all characters in the substring from 'start' to 'end' are unique.
     *
     * @param s     The input string.
     * @param start The starting index of the substring.
     * @param end   The ending index of the substring.
     * @return      True if all characters are unique, otherwise false.
     *
     * Time Complexity: O(n), where n is the length of the substring.
     * Space Complexity: O(min(n, m)), where n is the length of the substring and m is the size of the character set.
     */
    private boolean allUnique(String s, int start, int end) {
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (!uniqueChars.add(s.charAt(i))) {
                return false; // Duplicate character found
            }
        }
        return true; // All characters are unique
    }
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, ans = 0;
        int frequency[] = new int[128]; // Array to keep track of character frequencies
        int N = s.length(); // Length of the input string

        // Traverse the string with the 'right' pointer
        for (; right < N; ++right) {
            // Increment the frequency of the current character at 'right' position
            frequency[s.charAt(right)]++;

            // If frequency of the current character is more than 1,
            // it means there's a duplicate character within the current window
            while (frequency[s.charAt(right)] > 1) {
                // Reduce the frequency of the character at 'left' position and move 'left' forward
                frequency[s.charAt(left++)]--;
            }

            // Update the maximum length of the substring found so far
            ans = Math.max(ans, right - left + 1);
        }
        return ans; // Return the length of the longest substring without repeating characters
    }
    public static void main(String[] args) {
        // Test Cases
        String test1 = "abcabcbb";
        System.out.println("Test Case 1: " + lengthOfLongestSubstring(test1)); // Expected Output: 3

        String test2 = "bbbbb";
        System.out.println("Test Case 2: " + lengthOfLongestSubstring(test2)); // Expected Output: 1

        String test3 = "pwwkew";
        System.out.println("Test Case 3: " + lengthOfLongestSubstring(test3)); // Expected Output: 3

        String test4 = "dvdf";
        System.out.println("Test Case 4: " + lengthOfLongestSubstring(test4)); // Expected Output: 3

        String test5 = "tmmzuxt";
        System.out.println("Test Case 5: " + lengthOfLongestSubstring(test5)); // Expected Output: 5
    }
}
