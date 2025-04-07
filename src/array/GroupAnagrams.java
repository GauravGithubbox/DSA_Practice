package array;

import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str= {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(str); // output will be ----> {["eat","tea","ate"],["bat],["nat","tan"]}


    }

    private static List<List<String>> groupAnagrams(String[] str) {
        Arrays.sort(str);  // [ate,bat,eat,nat,tan,tea]

        List<List<String>> result = List.of();

        return result;
    }
}
