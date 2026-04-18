package revision.linkedlist;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // we will create different methods inside the ll class like
    // Add method  ---- > Add from start and Add from last and add in the middle
    // Delete Method -----> delete from start and delete from last
    // Search Method


    public void addFirst(int data) {    // for this we have 3 steps
        // Step 1 : create new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {    // that's means this is the first node we should start from this only
            head = tail = newNode;
            return;
        }
        // step 2 : newNode next = head; creating link
        newNode.next = head;

        // step 3 : head = newNode As we added first so now this first node is head node
        head = newNode;

    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addMiddle(int index, int data) {
        if (index == 0) {  // this is the same to add first
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next; //now we are pointing to the 2nd last element
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void printData() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // let's wrote a function for remove first

    public int removeFirst() {
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {   // if we only have one node then we have to update the head as well as tail
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int value = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;


        return value;

    }

    public static int  iterationSearch(int key){
        Node temp = head;
        int i =0;
        while (temp !=null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }



    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.printData();
        ll.addFirst(2);
        ll.printData();
        ll.addFirst(3);
        ll.printData();
        // adding from last

        ll.addLast(5);
        ll.printData();
        ll.addLast(6);
        ll.printData();
        ll.addLast(7);
        ll.printData();
        ll.addMiddle(3, 100);
        ll.printData();
        System.out.println("Size of this Linked List " + ll.size);

        ll.removeFirst(); // first node should be deleted
        ll.printData();
        ll.removeLast(); // last element should be deleted
        ll.printData();
        System.out.println("let's find the index of 6 ----> "+iterationSearch(6));
        System.out.println("let's find the index of 20 ----> "+iterationSearch(20));
        // After this here is how the ll is looking

/*

1 --> null
2 --> 1 --> null
3 --> 2 --> 1 --> null
3 --> 2 --> 1 --> 5 --> null
3 --> 2 --> 1 --> 5 --> 6 --> null
3 --> 2 --> 1 --> 5 --> 6 --> 7 --> null

*/
    }
}
