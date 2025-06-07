package linkedlist;

public class DoublyLinkedList {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode; // If the list is empty, both head and tail point to the new node
        } else {
            newNode.next = head;  // New node's next is the current head
            head.prev = newNode;  // Current head's previous is set to the new node
            head = newNode;       // Head is updated to the new node
        }
    }

    public int removeFirst() {
        int data;
        if(head == null){

            System.out.println("Doubly Linked List is empty");
            return Integer.MIN_VALUE;
        }else {
            if(size == 1){
                data = head.data;
                head = tail= null;
                size--;
                return data;

            }
             data = head.data;
            head = head.next;
            head.prev =null;
            size--;
            return data;
        }

    }

    public void printData() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(8);
        dll.addFirst(9);
        dll.addFirst(10);
        dll.printData();
        System.out.println("size=" + dll.size);
        dll.removeFirst();
        dll.printData();
        System.out.println("size=" + dll.size);

    }
}
