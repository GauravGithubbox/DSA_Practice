package rajat.linkedlist.easy;
//https://leetcode.com/problems/odd-even-linked-list/
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    // Helper method to create a linked list from an array
    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to convert a linked list to a string
    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OddEvenLinkedList solution = new OddEvenLinkedList();

        // Test case 1: Odd number of elements
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = createList(arr1);
        System.out.println("Test case 1:");
        System.out.println("Input:  " + listToString(head1));
        head1 = solution.oddEvenList(head1);
        System.out.println("Output: " + listToString(head1));
        System.out.println();

        // Test case 2: Even number of elements
        int[] arr2 = {2, 1, 3, 5, 6, 4, 7};
        ListNode head2 = createList(arr2);
        System.out.println("Test case 2:");
        System.out.println("Input:  " + listToString(head2));
        head2 = solution.oddEvenList(head2);
        System.out.println("Output: " + listToString(head2));
        System.out.println();

        // Test case 3: Single element
        int[] arr3 = {1};
        ListNode head3 = createList(arr3);
        System.out.println("Test case 3:");
        System.out.println("Input:  " + listToString(head3));
        head3 = solution.oddEvenList(head3);
        System.out.println("Output: " + listToString(head3));
        System.out.println();

        // Test case 4: Empty list
        ListNode head4 = null;
        System.out.println("Test case 4:");
        System.out.println("Input:  " + listToString(head4));
        head4 = solution.oddEvenList(head4);
        System.out.println("Output: " + listToString(head4));
    }
}
