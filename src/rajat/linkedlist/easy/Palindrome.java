package rajat.linkedlist.easy;


import rajat.linkedlist.implementation.LinkedListImplementation;
import rajat.linkedlist.implementation.Node;

public class Palindrome {
    public static Node<Integer> reverseListRecursively(Node<Integer> head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node<Integer> smallOutput = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return smallOutput;
    }
    public static boolean isPalindrome(Node<Integer> head) {
        int lengthOfList = sizeOfList(head);
        int n = lengthOfList / 2;

        Node<Integer> temp = head;
        while(n - 1 > 0) {
            temp = temp.next;
            n--;
        }
        Node<Integer> head2 = temp;
        temp.next = null;
        head2 = reverseListRecursively(head2);

        while(head != null && head2 != null) {
            if(head.data != head2.data){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    private static int sizeOfList(Node<Integer> head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args) {
        LinkedListImplementation<Integer> list = new LinkedListImplementation<>();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(20);
        list.insertAtEnd(10);

        Node<Integer> head = list.getHead();
        list.printList();

        if(isPalindrome(head) == true) {
            System.out.println("Palindrom!");
        }
        else{
            System.out.println("Not Palindrome!");
        }
    }
}
