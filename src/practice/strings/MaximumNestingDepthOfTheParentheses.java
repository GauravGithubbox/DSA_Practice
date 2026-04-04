package gaurav.strings;
//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int maxCount = 0;
        int currentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                currentCount++;
                maxCount = Math.max(currentCount, maxCount);
            } else if (s.charAt(i) == ')') {
                currentCount--;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        MaximumNestingDepthOfTheParentheses pd = new MaximumNestingDepthOfTheParentheses();
        String testString = "((1+(2*3))+((8)/4))+1";
        int result = pd.maxDepth(testString);
        System.out.println("The maximum depth of parentheses in the string is: " + result);
    }
}
