package gaurav.strings;
//https://leetcode.com/problems/largest-odd-number-in-string/description/
public class LargestOddNumberInString {
    public static String largestOddNumber(String num) {
        int length = num.length() - 1;
        while (length >= 0) {
            int d = num.charAt(length) - '0';
            if (d % 2 != 0) {
                return num.substring(0, length + 1);
            }
            length--;
        }
        return "";
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(largestOddNumber("123456")); // Output: "12345"
        System.out.println(largestOddNumber("4206"));   // Output: ""
        System.out.println(largestOddNumber("35427"));  // Output: "35427"
        System.out.println(largestOddNumber("2468"));   // Output: ""
        System.out.println(largestOddNumber("13579"));  // Output: "13579"
    }
}
