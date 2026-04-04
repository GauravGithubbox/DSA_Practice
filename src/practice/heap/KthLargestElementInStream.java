package practice.heap;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        // Add all initial numbers to the practice.heap
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val); // add value to practice.heap
        if (minHeap.size() > k) {
            minHeap.poll(); // remove smallest if practice.heap is larger than k
        }
        return minHeap.peek(); // kth largest is the smallest in the practice.heap
    }

    public static void main(String[] args) {
        KthLargestElementInStream kthLargest = new KthLargestElementInStream(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));  // returns 4
        System.out.println(kthLargest.add(5));  // returns 5
        System.out.println(kthLargest.add(10)); // returns 5
        System.out.println(kthLargest.add(9));  // returns 8
        System.out.println(kthLargest.add(4));  // returns 8
    }
}
