package rajat.recursion.striver;

public class StringToIntegerAtoi {

    // Main function to convert string to integer
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Use the custom trim function to remove leading and trailing spaces
        s = customTrim(s);
        if (s.isEmpty()) {
            return 0;
        }

        // Determine the sign
        int sign = 1;
        int index = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        // Start the recursive conversion
        return myAtoiRecursive(s, index, 0, sign);
    }

    // Custom recursive trim function to remove leading and trailing spaces
    private String customTrim(String s) {
        // Base case: empty string
        if (s.isEmpty()) {
            return s;
        }

        // Remove leading spaces
        if (s.charAt(0) == ' ') {
            return customTrim(s.substring(1));
        }

        // Remove trailing spaces
        if (s.charAt(s.length() - 1) == ' ') {
            return customTrim(s.substring(0, s.length() - 1));
        }

        // Return the trimmed string when no leading or trailing space
        return s;
    }

    // Helper function for recursive atoi conversion
    private int myAtoiRecursive(String s, int index, long currentNumber, int sign) {
        // Base case: end of string or non-digit character
        if (index == s.length() || !Character.isDigit(s.charAt(index))) {
            return (int) (sign * currentNumber);
        }

        // Add the current digit to the number
        currentNumber = currentNumber * 10 + (s.charAt(index) - '0');

        // Handle overflow
        if (sign * currentNumber > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (sign * currentNumber < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        // Recur for the next character
        return myAtoiRecursive(s, index + 1, currentNumber, sign);
    }

    public static void main(String[] args) {
        StringToIntegerAtoi solution = new StringToIntegerAtoi();

        // Test cases
        System.out.println(solution.myAtoi("42"));              // Output: 42
        System.out.println(solution.myAtoi("   -42"));          // Output: -42
        System.out.println(solution.myAtoi("4193 with words")); // Output: 4193
        System.out.println(solution.myAtoi("words and 987"));   // Output: 0
        System.out.println(solution.myAtoi("-91283472332"));    // Output: -2147483648 (Integer.MIN_VALUE)
    }
}
