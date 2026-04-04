package practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;


public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        int result = lastStoneWeight(stones);
        System.out.println("result " + result);
    }

    private static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // largest
            int x = maxHeap.poll(); // second largest

            if (y != x) {
                maxHeap.add(y - x); // the difference is added back
            }
        }

        // If there's one stone left, return it, otherwise return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
