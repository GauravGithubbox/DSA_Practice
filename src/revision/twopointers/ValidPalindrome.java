package revision.twopointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);

        System.out.println("string is palindrome " + result);
    }

    private static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        System.out.println("s  ----->" + s);

        // now assume in this s we have string like "amanaplanacanalpanama"
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;

            }
            start++;
            end--;

        }
        return true;
    }
}
