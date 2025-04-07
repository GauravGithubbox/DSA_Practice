package array;

import java.util.Arrays;

public class LongestCommonPrefix {


    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        System.out.println(findLongestCommonPrefix(str));
    }

    private static String findLongestCommonPrefix(String[] str) {
        Arrays.sort(str);
        String s1= str[0];
        String s2 = str[str.length-1];
        int ind =0;
        while(!s1.isEmpty()){
            if(s1.charAt(ind) == s2.charAt(ind)){
                ind++;
            }else{
                break;
            }
        }

        return ind == 0 ? "" : s1.substring(0,ind) ;
    }
}
