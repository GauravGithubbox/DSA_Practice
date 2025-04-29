package stack;

import java.util.Stack;
//https://leetcode.com/problems/daily-temperatures/
public class DailyTempratures {
    public static void main(String[] args) {
        int [] tempratures = {73,74,75,71,69,72,76,73};
        int [] result = dailyTemperatures(tempratures);
        for(int r : result){
            System.out.println("  "+r);
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        return result;
    }
}
