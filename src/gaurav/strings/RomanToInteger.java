package gaurav.strings;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/roman-to-integer/description/
public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger converter = new RomanToInteger();

        String roman1 = "III";
        String roman2 = "IV";
        String roman3 = "IX";
        String roman4 = "LVIII";
        String roman5 = "MCMXCIV";

        System.out.println("Roman numeral " + roman1 + " is equal to " + converter.romanToInt(roman1));
        System.out.println("Roman numeral " + roman2 + " is equal to " + converter.romanToInt(roman2));
        System.out.println("Roman numeral " + roman3 + " is equal to " + converter.romanToInt(roman3));
        System.out.println("Roman numeral " + roman4 + " is equal to " + converter.romanToInt(roman4));
        System.out.println("Roman numeral " + roman5 + " is equal to " + converter.romanToInt(roman5));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }
}

