package stack;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    // Push element onto stack
    public void push(T value) {
        stack.add(value);
    }

    // Pop element from stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    // Peek at top element of stack
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Get size of stack
    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        // Stack of Integer
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        System.out.println("Top element is: " + intStack.peek()); // 2

        // Stack of String
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("Top element is: " + stringStack.peek()); // World
    }
}
