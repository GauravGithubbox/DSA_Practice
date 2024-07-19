package gaurav.queue.questions;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();

    }

    public void push(int x) {
        if(!q1.isEmpty()){
            q1.add(x);
        }else{
            q2.add(x);
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        int top = -1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                if(q1.isEmpty()){
                    break;
                }
                q2.add(top);
            }
        }else{
            while(!q2.isEmpty()){
                top = q2.remove();
                if(q2.isEmpty()){
                    break;
                }
                q1.add(top);
            }
        }
        return top;
    }

    public int top() {
        if (empty()) {
            return -1;
        }
        int top = -1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                q2.add(top);
            }
        }else{
            while(!q2.isEmpty()){
                top = q2.remove();

                q1.add(top);
            }
        }
        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();

    }
    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();

        // Pushing elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Printing the top element
        System.out.println("Top element after pushes: " + stack.top());

        // Popping elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // Checking if the stack is empty
        System.out.println("Is the stack empty? " + stack.empty());

        // Popping the remaining element
        System.out.println("Popped element: " + stack.pop());

        // Checking if the stack is empty again
        System.out.println("Is the stack empty? " + stack.empty());

        // Trying to pop from an empty stack
        System.out.println("Popped element: " + stack.pop());
    }
}
