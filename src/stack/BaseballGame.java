package stack;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String []  operations = {"5","2","3","+","C","D","+"};
        int result = calPoints(operations);
        System.out.println("Result ="+result);
    }

    private static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int last = stack.pop();
                int secondLast = stack.peek();
                int sum = last + secondLast;
                stack.push(last);  // Push last back
                stack.push(sum);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int total = 0;
        for (int score : stack) {
            total += score;
        }

        return total;

    }
}
