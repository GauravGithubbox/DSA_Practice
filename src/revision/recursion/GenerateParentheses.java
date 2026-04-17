package revision.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateAllParenthesis(n);
        System.out.println(Arrays.asList(result));
    }

    private static List<String> generateAllParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        helpers(res, "", 0, 0, n);
        return res;
    }

    private static void helpers(ArrayList<String> res, String s, int open, int close, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        if (open < n) {
            helpers(res, s + "(", open + 1, close, n);
        }
        if (close < open) {
            helpers(res, s + ")", open, close + 1, n);
        }
    }
}
