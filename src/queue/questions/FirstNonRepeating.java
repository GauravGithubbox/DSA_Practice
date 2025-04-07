package gaurav.queue.questions;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeating {
    public static String FirstNonRepeating(String A) {
        int freq[] = new int[26]; // 'a' - 'z'
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < A.length(); i++){
            char ch = A.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                sb.append('#');
            }else{
                sb.append(q.peek());
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String input = "aabccxb";
        String result = FirstNonRepeating(input);
        System.out.println("Input: " + input);
        System.out.println("First Non-Repeating Characters: " + result);
    }
}
