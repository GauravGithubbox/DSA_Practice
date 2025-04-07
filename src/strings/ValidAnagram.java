package gaurav.strings;
//https://leetcode.com/problems/valid-anagram/description/
import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagramBruteForce(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
    public static boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        // If lengths are different, they can't be anagrams
        if (n != m) {
            return false;
        } else {
            // Array to count character frequencies
            int[] count = new int[26];

            // Increment count for each character in s
            for (int i = 0; i < n; i++) {
                count[s.charAt(i) - 'a']++;
            }

            // Decrement count for each character in t
            for (int i = 0; i < m; i++) {
                count[t.charAt(i) - 'a']--;
            }

            // Check if all counts are zero
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isAnagramBruteForce("anagram", "nagaram")); // Output: true
        System.out.println(isAnagram("rat", "car")); // Output: false
    }
}
