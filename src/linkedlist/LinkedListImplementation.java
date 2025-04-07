package gaurav.linkedlist;

public class LinkedListImplementation {
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

    //Add First Method
    public void addFirst(int data) {
        // Step -1 is to create new Node all the time
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //step-2
        // first we tried to link the node (basically when we are fetching head next address and adding in the node next that means
        // now my newNode has the address of the next node)
        newNode.next = head;
        //step-3
        head = newNode;

    }

    //Print Method
    public void printLL() {
        if (head == null) {
            System.out.println("Linked List is empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(" " + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    //Add Last method
    public void addLast(int data) {
        // step -1 is to create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //step -2 we know last node tail always have the null for adding newNode from last we need to add newNode in place of null
        tail.next = newNode;
        tail = newNode;
    }

    // Add at any place method
    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is Empty BC");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is Empty BC");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // now we have to travel around size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Implement iterative search
    public int iterativeSearch(int key) {
        if (size == 0) {
            System.out.println("LL is Empty");
        }

        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public void reverseLL() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String args[]) {
        LinkedListImplementation ll = new LinkedListImplementation();
        ll.addFirst(11);
        ll.addFirst(22);
        ll.addLast(99);
        ll.addLast(88);
        ll.add(2, 55);
        ll.printLL();
        System.out.println("Itration =" + ll.iterativeSearch(199));
        ll.removeFirst();
        ll.printLL();
        System.out.println("LL size=" + ll.size);
        ll.removeLast();
        ll.printLL();
        System.out.println("LL size=" + ll.size);
        System.out.println("Itration =" + ll.iterativeSearch(99));
        System.out.println("recursive search =" + ll.recSearch(99));
        ll.reverseLL();
        ll.printLL();

    }
}
