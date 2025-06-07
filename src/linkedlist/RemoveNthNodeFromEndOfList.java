package linkedlist;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n =1;
        ListNode result = removeNthFromEnd(head,n);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        System.out.println("Original List:");
        reverseLinkedList.printList(result);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count =0;
        while (temp!=null){
            count++;
            temp = temp.next;
        }
        int steps = count-n;
        if(steps == 0){
            return head.next;
        }
        temp = head;
        for(int i =1;i<steps;i++){
            temp= temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
