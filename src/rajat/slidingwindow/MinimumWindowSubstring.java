package rajat.slidingwindow;
//https://leetcode.com/problems/minimum-window-substring/description/

import java.util.HashMap;

public class MinimumWindowSubstring {

    /**
     * Finds the minimum window in `s` which will contain all the characters in `t`.
     *
     * @param s The source string.
     * @param t The target string containing the characters to be included in the window.
     * @return The smallest window in `s` that contains all characters from `t`.
     *
     * Time Complexity: O(M + N), where M is the length of `s` and N is the length of `t`.
     * Space Complexity: O(N), for the hash maps used to store the character counts.
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Count characters in t
        HashMap<Character, Integer> targetCharCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCharCount.put(c, targetCharCount.getOrDefault(c, 0) + 1);
        }

        // Variables to track the minimum window
        int minLength = Integer.MAX_VALUE;
        int start = 0;  // Start index of the minimum window
        int left = 0;   // Left pointer of the window
        int right = 0;  // Right pointer of the window
        int required = targetCharCount.size();  // Number of unique characters in t
        int formed = 0; // Number of unique characters in current window matching t

        // HashMap to count characters in the current window
        HashMap<Character, Integer> windowCharCount = new HashMap<>();

        // Expand the window
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowCharCount.put(rightChar, windowCharCount.getOrDefault(rightChar, 0) + 1);

            // If the current character's count in the window matches the target character count, increment `formed`
            if (targetCharCount.containsKey(rightChar) &&
                    windowCharCount.get(rightChar) == targetCharCount.get(rightChar)) {
                formed++;
            }

            // Contract the window from the left to find the smallest valid window
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);

                // Update the minimum window size and start position
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Decrease the count of the character on the left
                windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
                if (targetCharCount.containsKey(leftChar) &&
                        windowCharCount.get(leftChar) < targetCharCount.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        // Return the minimum window or an empty string if no such window exists
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solver = new MinimumWindowSubstring();

        // Test Case 1
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        String result1 = solver.minWindow(s1, t1);
        System.out.println("Test Case 1: Expected \"BANC\", Got: \"" + result1 + "\"");

        // Test Case 2
        String s2 = "a";
        String t2 = "a";
        String result2 = solver.minWindow(s2, t2);
        System.out.println("Test Case 2: Expected \"a\", Got: \"" + result2 + "\"");

        // Test Case 3
        String s3 = "a";
        String t3 = "aa";
        String result3 = solver.minWindow(s3, t3);
        System.out.println("Test Case 3: Expected \"\", Got: \"" + result3 + "\"");

        // Test Case 4
        String s4 = "this is a test string";
        String t4 = "tist";
        String result4 = solver.minWindow(s4, t4);
        System.out.println("Test Case 4: Expected \"t stri\", Got: \"" + result4 + "\"");

        // Additional Test Case 5
        String s5 = "ab";
        String t5 = "a";
        String result5 = solver.minWindow(s5, t5);
        System.out.println("Test Case 5: Expected \"a\", Got: \"" + result5 + "\"");
    }
}
