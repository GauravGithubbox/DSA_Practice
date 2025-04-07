package gaurav.strings;
//https://leetcode.com/problems/rotate-string/description/
public class RotateString {
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        // Concatenate the string with itself and check if the goal is a substring
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(rotateString("abcde", "cdeab")); // Output: true
        System.out.println(rotateString("abcde", "abced")); // Output: false
        System.out.println(rotateString("abc", "abc")); // Output: true
        System.out.println(rotateString("abc", "cab")); // Output: true
        System.out.println(rotateString("abc", "acb")); // Output: false
    }
}
