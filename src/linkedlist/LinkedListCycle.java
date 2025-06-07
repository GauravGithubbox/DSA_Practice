package linkedlist;


public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("this is how linked list look like");
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.printList(head);
        boolean hasCycle = hasCycles(head);
        System.out.println("result"+hasCycle);


    }

    private static boolean hasCycles(ListNode head) {
        return  false;
    }
}
