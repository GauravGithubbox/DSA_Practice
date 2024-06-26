package rajat.recursion.basic;

public class Palindrome {
    // Recursive function to check if a string is a palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        // Base case: if the string has one or zero characters
        if (start >= end) {
            return true;
        }

        // Check if the first and last characters are the same
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive case: check the substring from start+1 to end-1
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String str1 = "racecar";
        String str2 = "hello";

        System.out.println("Is '" + str1 + "' a palindrome? " + isPalindrome(str1, 0, str1.length() - 1));
        System.out.println("Is '" + str2 + "' a palindrome? " + isPalindrome(str2, 0, str2.length() - 1));
    }
}
