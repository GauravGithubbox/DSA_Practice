package rajat.recursion.striver.subsequence;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/generate-parentheses/description/
// Class to generate all combinations of n pairs of balanced parentheses
public class GenerateParenthesis {

    /**
     * Recursive helper function to generate valid parentheses combinations.
     *
     * @param current The current string being built.
     * @param openBracketCount The current count of open parentheses used.
     * @param closeBracketCount The current count of close parentheses used.
     * @param n The total number of pairs of parentheses to be generated.
     * @param result The list to store all valid parentheses combinations.
     */
    public static void generateParenthesisHelper(String current, int openBracketCount, int closeBracketCount, int n, List<String> result) {
        // Base case: If the current string has n open and n close parentheses
        if (openBracketCount == n && closeBracketCount == n) {
            result.add(current); // Add the current valid combination to the result list
            return;
        }

        // If the count of open parentheses is less than n, add an open parenthesis
        if (openBracketCount < n) {
            generateParenthesisHelper(current + "(", openBracketCount + 1, closeBracketCount, n, result);
        }

        // If the count of close parentheses is less than the open parentheses, add a close parenthesis
        if (closeBracketCount < openBracketCount) {
            generateParenthesisHelper(current + ")", openBracketCount, closeBracketCount + 1, n, result);
        }
    }

    /**
     * Public method to initiate the recursive generation of parentheses.
     *
     * @param n The number of pairs of parentheses.
     */
    public static void generateParenthesis(int n) {
        List<String> ls = new ArrayList<>(); // List to hold the result combinations
        generateParenthesisHelper("", 0, 0, n, ls); // Start the recursive process
        System.out.println(ls); // Print the result list
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.print("Test Case 1 (n = 3): ");
        generateParenthesis(n); // Expected Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]

        n = 2;
        System.out.print("Test Case 2 (n = 2): ");
        generateParenthesis(n); // Expected Output: ["(())", "()()"]

        n = 1;
        System.out.print("Test Case 3 (n = 1): ");
        generateParenthesis(n); // Expected Output: ["()"]
    }
}

/**
 * Time Complexity: O(4^n / sqrt(n)) - Catalan number complexity.
 * Space Complexity: O(n) for the recursion stack.
 */
