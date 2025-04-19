package twopointers;

//https://leetcode.com/problems/valid-palindrome-ii/description/

public class ValidPalindrome_part_two {
    public static void main(String[] args) {
        String s = "abbcbbaa";
        boolean result = isValidPalindrome(s);
        System.out.println("result ="+result);
    }

    public static boolean isValidPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try skipping either left or right character
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true; // It's a palindrome as-is
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
