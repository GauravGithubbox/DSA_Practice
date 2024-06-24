package gaurav.strings;

import java.util.HashMap;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if ((mapS.containsKey(charS) && mapS.get(charS) != charT) ||
                    (mapT.containsKey(charT) && mapT.get(charT) != charS)) {
                return false;
            }

            mapS.put(charS, charT);
            mapT.put(charT, charS);
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isIsomorphic("egg", "add"));    // Output: true
        System.out.println(isIsomorphic("foo", "bar"));    // Output: false
        System.out.println(isIsomorphic("paper", "title"));// Output: true
        System.out.println(isIsomorphic("ab", "aa"));      // Output: false
        System.out.println(isIsomorphic("ab", "ca"));      // Output: true
    }
}

