package bitmanipulation;

import java.math.BigInteger;

public class AddBinary {
    public static void main(String[] args) {
        String a ="11", b = "1";
        String result = addBinary(a,b);
        System.out.println(result);
    }

    private static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            int sum = bitA + bitB + carry;
            sb.append(sum % 2);     // Append binary digit (0 or 1)
            carry = sum / 2;        // Calculate carry for next digit

            i--; j--;
        }

        return sb.reverse().toString(); //
    }
}
