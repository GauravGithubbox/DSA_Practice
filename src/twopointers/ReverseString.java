package twopointers;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }

    private static void reverseString(char[] s) {
        int first = 0;
        int last = s.length-1;
        char temp;
        while (first<last){
            temp = s[first];
            s[first] = s[last];
            s[last] = temp;
            System.out.println("Iteration -->"+first +" last ->"+last + "temp-->"+temp);
            first++;
            last--;

        }
        for(char c : s) {
            System.out.println("what happend ->" + c);
        }
    }
}
