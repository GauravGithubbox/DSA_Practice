package gaurav.queue.implementaion;

public class Queue {
    static int arr[];
    static int size;
    static int rear;

    Queue(int n) {
        arr = new int[n];
        size = n;
        rear = -1; // rear always start with -1 because after inserting the element rear will move
    }

    public boolean isEmpty() {
        return rear == -1; // if rear is -1 mean no element present in the array then this method will return true
    }

    // Add function
    public void add(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return;
        }
        rear = rear + 1;
        arr[rear] = data;
    }

    // Remove function
    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return -1;
        }
        int front = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear = rear - 1;
        return front;
    }

    // peek()
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return -1;
        }
        return arr[0];
    }


    public static void main(String args[]) {
        Queue queue = new Queue(5);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();

        }
    }

}
