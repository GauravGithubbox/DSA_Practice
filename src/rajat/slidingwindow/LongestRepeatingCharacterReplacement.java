package rajat.slidingwindow;

//https://leetcode.com/problems/longest-repeating-character-replacement/

public class LongestRepeatingCharacterReplacement {

    /**
     * Helper method to check if a substring from 'start' to 'end' can be converted into
     * a repeating character string with at most 'k' replacements.
     *
     * @param s     The input string.
     * @param start The starting index of the substring.
     * @param end   The ending index of the substring.
     * @param k     The maximum number of allowed replacements.
     * @return      True if the substring can be converted, otherwise false.
     *
     * Time Complexity: O(n), where n is the length of the substring.
     * Space Complexity: O(1), as the count array size is fixed.
     */
    private boolean canConvertToRepeating(String s, int start, int end, int k) {
        int[] count = new int[26];
        int maxFreq = 0;

        // Count the frequency of each character in the substring from start to end
        for (int i = start; i <= end; i++) {
            count[s.charAt(i) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(i) - 'A']);
        }

        // Number of characters to change to make all characters in the substring the same
        int charsToChange = (end - start + 1) - maxFreq;

        return charsToChange <= k;
    }

    /**
     * Brute-force solution to find the length of the longest substring that can be
     * converted to have repeating characters with at most 'k' replacements.
     *
     * @param s The input string.
     * @param k The maximum number of allowed replacements.
     * @return  The length of the longest valid substring.
     *
     * Time Complexity: O(n^3), where n is the length of the string.
     * Space Complexity: O(1).
     */
    public int characterReplacementBruteForce(String s, int k) {
        int n = s.length();
        int maxLength = 0;

        // Iterate over every possible substring
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Check if the substring from i to j can be converted with at most k replacements
                if (canConvertToRepeating(s, i, j, k)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    /**
     * Optimized solution using the sliding window technique to find the length of the
     * longest substring that can be converted to have repeating characters with at most 'k' replacements.
     *
     * @param s The input string.
     * @param k The maximum number of allowed replacements.
     * @return  The length of the longest valid substring.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1).
     */
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26]; // To store the frequency of each character in the current window
        int maxLength = 0; // The maximum length of a valid substring found
        int maxFreq = 0; // The maximum frequency of any character in the current window
        int left = 0; // The left pointer of the sliding window

        // Expand the window by moving the right pointer
        for (int right = 0; right < n; right++) {
            // Increment the frequency of the current character in the window
            count[s.charAt(right) - 'A']++;
            // Update the max frequency of any character in the current window
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            // Calculate the size of the current window
            int windowSize = right - left + 1;
            // If the number of characters to replace is more than k, shrink the window from the left
            if (windowSize - maxFreq > k) {
                // Decrement the frequency of the character that's no longer in the window
                count[s.charAt(left) - 'A']--;
                // Move the left pointer to the right to shrink the window
                left++;
            }

            // Update the maximum length of a valid substring found
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test Cases
        String test1 = "AABABBA";
        int k1 = 1;
        System.out.println("Test Case 1: " + characterReplacement(test1, k1)); // Expected Output: 4

        String test2 = "ABAB";
        int k2 = 2;
        System.out.println("Test Case 2: " + characterReplacement(test2, k2)); // Expected Output: 4

        String test3 = "AAABBC";
        int k3 = 2;
        System.out.println("Test Case 3: " + characterReplacement(test3, k3)); // Expected Output: 5
    }
}
