package revision.slidingwindow;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int countSubstring = lengthOfLongestSubstring(str);
        System.out.println("Longest Substring =" + countSubstring);
    }

    private static int lengthOfLongestSubstring(String str) {
        int maxCount = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {

            }

        }
        return 0;
    }


}
