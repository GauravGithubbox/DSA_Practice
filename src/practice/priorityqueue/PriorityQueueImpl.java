package gaurav.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueImpl {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(Comparator.reverseOrder());
        priorityQueue.add(10);
        priorityQueue.add(11);
        priorityQueue.add(15);
        priorityQueue.add(106);
        priorityQueue.add(12);
        priorityQueue.add(12);

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.peek());
            priorityQueue.remove();
        }

    }
}
