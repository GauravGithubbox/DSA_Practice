package backtracking;

public class FindSubsetInString {
    private static void findSubset(String str, String ans, int i) {
        //Base case
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        // Yes choice
        findSubset(str, ans + str.charAt(i), i + 1);

        // No choice
        findSubset(str, ans, i + 1);

    }

    public static void main(String[] args) {
        String str = "abc";
        findSubset(str, "", 0);
    }


}
