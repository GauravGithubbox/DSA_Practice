package twopointers;

//https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);
        System.out.println("result ="+result);
    }

    private static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int start = 0;
        int end = s.length()-1;
        while (start<end){
         if(s.charAt(start) != s.charAt(end)){
             return false;
         }
         start++;
         end--;
        }
        return true;
    }
}
