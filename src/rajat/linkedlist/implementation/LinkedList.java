package rajat.linkedlist.implementation;




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