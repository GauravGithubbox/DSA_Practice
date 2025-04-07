package gaurav.queue.questions;

import java.util.Stack;

public class ImplementationQueueUsingStacks {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public ImplementationQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push element x to the back of the queue.
    public void push(int x) {
        // Move all elements from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        // Push the new element onto stack1
        stack1.push(x);
        // Move all elements back to stack1 from stack2
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    // Removes the element from the front of the queue and returns it.
    public int pop() {
        return stack1.pop();
    }

    // Get the front element.
    public int peek() {
        return stack1.peek();
    }

    // Returns whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementationQueueUsingStacks queue = new ImplementationQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // returns 1
        System.out.println(queue.pop());  // returns 1
        System.out.println(queue.empty()); // returns false
    }
}


