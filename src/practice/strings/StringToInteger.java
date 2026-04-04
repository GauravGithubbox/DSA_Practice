package gaurav.strings;
//https://leetcode.com/problems/string-to-integer-atoi/description/
public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger converter = new StringToInteger();

        String input1 = "42";
        String input2 = "   -42";
        String input3 = "4193 with words";
        String input4 = "words and 987";
        String input5 = "-91283472332";

        System.out.println("Input: \"" + input1 + "\" converts to " + converter.myAtoi(input1));
        System.out.println("Input: \"" + input2 + "\" converts to " + converter.myAtoi(input2));
        System.out.println("Input: \"" + input3 + "\" converts to " + converter.myAtoi(input3));
        System.out.println("Input: \"" + input4 + "\" converts to " + converter.myAtoi(input4));
        System.out.println("Input: \"" + input5 + "\" converts to " + converter.myAtoi(input5));
    }

    public int myAtoi(String s) {
        long num = 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0)
            return 0;

        int i = 0, sign = 1;

        // skip all preceding whitespaces
        while (i < chars.length && chars[i] == ' ') {
            i++;
        }

        // check if there is either a '+' or '-' in front of the number
        if (i < chars.length && (chars[i] == '-' || chars[i] == '+')) {
            sign = (chars[i] == '-') ? -1 : 1;
            i++;
        }

        // go through the rest of the characters in the string
        while (i < chars.length) {
            char current = chars[i];
            if (current < '0' || current > '9')
                break;

            num = num * 10 + (current - '0');

            // handle overflow cases
            if (sign * num <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if (sign * num >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            i++;
        }

        return (int) (sign * num);
    }
}
