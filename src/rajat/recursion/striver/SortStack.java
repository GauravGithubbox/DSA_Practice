package rajat.recursion.striver;

import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> stack ) {
        if(stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        sortStack(stack);
        
        insertRecursively(stack, top);
    }

    private static void insertRecursively(Stack<Integer> stack, int element) {
        if(stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        int top = stack.pop();

        insertRecursively(stack, element);

        stack.push(top);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        // Example stack
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
