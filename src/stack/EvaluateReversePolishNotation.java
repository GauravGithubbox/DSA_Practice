package stack;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] token = {"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"};

        int result = evalRPN(token);
        System.out.println("result -->"+result);
    }

        private static int calculatePlishNotation(int second, int first, String operator) {
            switch (operator) {
                case "+":
                    return first + second;
                case "-":
                    return first - second;
                case "*":
                    return first * second;
                case "/":
                    return first / second;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        }

        public static int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            for (String token : tokens) {
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    // Pop two operands
                    int second = stack.pop();
                    int first = stack.pop();
                    // Perform operation
                    int result = calculatePlishNotation(second, first, token);
                    // Push result back to stack
                    stack.push(result);
                } else {
                    // Push number to stack
                    stack.push(Integer.parseInt(token));
                }
            }

            // Final result will be at the top of the stack
            return stack.pop();
        }

}
