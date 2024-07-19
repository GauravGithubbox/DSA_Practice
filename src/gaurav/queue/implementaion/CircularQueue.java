package gaurav.queue.implementaion;

public class CircularQueue {
    int arr[];
    int size;
    int rear;
    int front;


    CircularQueue(int n) {
        arr = new int[n];
        size = n;
        rear = -1; // rear always start with -1 because after inserting the element rear will move
        front = -1; // In circular queue we also initialize front = -1
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1; // if rear is -1  and front is also -1 that mean we don't have any element
    }

    public boolean isFull() {
        return (rear + 1) % size == front; // When we are trying to put the element in the stack at the next index front is present that means
        // out queue is full
    }

    // Add function
    public void add(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    // Remove function
    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return -1;
        }
        int result = arr[front];
        // last element delete
        if (rear == front) {
            rear = front = -1;
        } else {
            front = (front + 1) % size;
        }
        return result;
    }

    // peek()
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return -1;
        }
        return arr[front];
    }

    public static void main(String args[]) {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.add(3);
        circularQueue.add(4);
        circularQueue.add(5);
        circularQueue.remove();
        circularQueue.add(6);
        circularQueue.remove();
        circularQueue.add(7);
        while (!circularQueue.isEmpty()) {
            System.out.println(circularQueue.peek());
            circularQueue.remove();
            // N 6 7 5 , 7 6 5

        }
    }
}
