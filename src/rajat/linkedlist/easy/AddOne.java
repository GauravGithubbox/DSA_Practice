package rajat.linkedlist.easy;

import rajat.linkedlist.implementation.LinkedListImplementation;
import rajat.linkedlist.implementation.Node;
// https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
public class AddOne {
    public static Node<Integer> reverse(Node<Integer> head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node<Integer> smallOutput = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return smallOutput;
    }
    public static Node<Integer> addOne(Node<Integer> head) {
        int carry = 1, sum = 0;
        Node<Integer> temp = null;
        head = reverse(head);
        Node<Integer> reversedHead = head;
        while(head != null) {
            sum = carry + head.data;
            carry = sum / 10;
            head.data = sum % 10;
            temp = head;
            head = head.next;
        }

        if(carry > 0) {
            temp.next = new Node<Integer>(carry);
        }

        return reverse(reversedHead);
    }
    public static void main(String[] args) {
        LinkedListImplementation<Integer> list = new LinkedListImplementation<>();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(9);
        Node<Integer> head = list.getHead();
        list.printList();

        head = addOne(head);
        list.printList();

    }
}
