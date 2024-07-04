package rajat.linkedlist.implementation;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListImplementation<T> {
    // head
    private Node<T> head = null;
    public Node<T> getHead(){
        return head;
    }

    public void setHead(Node<T> newHead) {
        head = newHead;
    }
    // Insertion at beginning O(1)
    public void insertAtBeginning(T data) {
        Node<T> node = new Node<>(data);
        if(head == null) {
            head = node;
            return;
        } else {
            node.next = head;
            head = node;
        }
    }

    // Insertion at end
    // 1 -> 2 -> 3 -> NULL 4
    // 3 -> next = 4
    // Question is till where do i need to traverse?
    // 1 -> 2 -> 3-> null

    public void insertAtEnd(T data) {
        Node<T> temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }
        // temp will be pointing to 3

        temp.next = new Node<>(data);
    }

    // Insert At middle
    // Insertion at the given position (try)


    // Deletion at beginning O(1) time
    public void deletionAtBeginning(){
        // list is empty
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        // 1 -> 2 -> 3 ->null
        head = head.next;

    }

    // Deletion at the end

    public void deletionAtEnd() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        // 1 -> 2 -> 3 -> 4 -> 5 -> NULL

        Node<T> temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        // 4-> next = null
        temp.next = null;
    }

    // Deletion at the middle
    // Deletion at the given position (try)



    // Length of the list (try)
    // Search in the list, return T/F (try)
    // 1- > 2 -> 3 ->4 -> NULL
    // null <- 1 <- 2 <- 3 <-4 <- head
    public Node<T> reverseListRecursively(Node<T> h) {
        if(h == null || h.next == null) {
            return h;
        }

        Node<T> smallOutput = reverseListRecursively(h.next);
        h.next.next = h;
        h.next = null;
        return smallOutput;
    }

    public void printList() {
        Node<T> temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


}
public class LinkedList {
    public static void main(String[] args) {
        LinkedListImplementation<Integer> list = new LinkedListImplementation<>();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtBeginning(30);
        list.printList();

        // Insert At end

        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(60);
        list.printList();

        // Deletion at beginning

        list.deletionAtBeginning();
        list.printList();

        // Deletion at End
        list.deletionAtEnd();
        list.printList();

        Node<Integer> reversed = list.reverseListRecursively(list.getHead());
        list.setHead(reversed);
        list.printList();

    }

}
// Integer, String
// Generic