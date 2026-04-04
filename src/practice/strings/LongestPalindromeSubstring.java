package gaurav.strings;
//https://leetcode.com/problems/longest-palindromic-substring/description/
public class LongestPalindromeSubstring {

    int max = 0, start = 0, end = 0;

    public static void main(String[] args) {
        LongestPalindromeSubstring finder = new LongestPalindromeSubstring();

        String input1 = "babad";
        String input2 = "cbbd";
        String input3 = "a";
        String input4 = "ac";
        String input5 = "racecar";

        System.out.println("Longest palindrome substring of \"" + input1 + "\" is \"" + finder.longestPalindrome(input1) + "\"");
        System.out.println("Longest palindrome substring of \"" + input2 + "\" is \"" + finder.longestPalindrome(input2) + "\"");
        System.out.println("Longest palindrome substring of \"" + input3 + "\" is \"" + finder.longestPalindrome(input3) + "\"");
        System.out.println("Longest palindrome substring of \"" + input4 + "\" is \"" + finder.longestPalindrome(input4) + "\"");
        System.out.println("Longest palindrome substring of \"" + input5 + "\" is \"" + finder.longestPalindrome(input5) + "\"");
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (ch1 != ch2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if ((j - i + 1) > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
