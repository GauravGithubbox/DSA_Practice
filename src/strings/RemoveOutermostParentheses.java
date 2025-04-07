package gaurav.strings;
//https://leetcode.com/problems/remove-outermost-parentheses/description/
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;

        // Iterate over each character in the string
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If openCount is greater than 0, append the character to the result
                if (openCount > 0) {
                    result.append(c);
                }
                openCount++;
            } else if (c == ')') {
                openCount--;
                // If openCount is greater than 0, append the character to the result
                if (openCount > 0) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

    // Main method to test the removeOuterParentheses method
    public static void main(String[] args) {
        // Create an instance of the class
        RemoveOutermostParentheses example = new RemoveOutermostParentheses();

        // Define test strings
        String testString1 = "(()())(())";
        String testString2 = "(()())(())(()(()))";
        String testString3 = "()()";

        // Call the removeOuterParentheses method and print the results
        String result1 = example.removeOuterParentheses(testString1);
        String result2 = example.removeOuterParentheses(testString2);
        String result3 = example.removeOuterParentheses(testString3);

        System.out.println("Original String 1: " + testString1);
        System.out.println("Result 1: " + result1);

        System.out.println("Original String 2: " + testString2);
        System.out.println("Result 2: " + result2);

        System.out.println("Original String 3: " + testString3);
        System.out.println("Result 3: " + result3);
    }
}
