package gaurav.queue.questions;

import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println("Index of first non-repeating character in \"" + s1 + "\": " + firstUniqChar(s1));
        System.out.println("Index of first non-repeating character in \"" + s2 + "\": " + firstUniqChar(s2));
        System.out.println("Index of first non-repeating character in \"" + s3 + "\": " + firstUniqChar(s3));
    }
    public static int firstUniqChar(String A) {
        int[] freq = new int[26]; // Array to store the frequency of each character
        Queue<Integer> q = new LinkedList<>(); // Queue to store the indices of characters

        // First pass: count the frequency of each character and add their indices to the queue
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            freq[ch - 'a']++;
            q.add(i);
        }

        // Second pass: find the first non-repeating character by checking the queue
        while (!q.isEmpty()) {
            int index = q.poll(); // Retrieve and remove the head of the queue
            if (freq[A.charAt(index) - 'a'] == 1) {
                return index;
            }
        }

        return -1; // No non-repeating character found
    }
}
