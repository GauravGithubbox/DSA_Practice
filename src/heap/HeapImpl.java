package heap;

import java.util.ArrayList;

public class HeapImpl {
    ArrayList<Integer> ar = new ArrayList<>();

    public void add(int data) {
        ar.add(data);
        int child = ar.size() - 1;
        int parent = (child - 1) / 2;
        while (ar.get(child) < ar.get(parent)) {   // T.C. logn
            // swap
            int temp = ar.get(child);
            ar.set(child, ar.get(parent));
            ar.set(parent, temp);
            child = parent;
            parent = (child-1)/2;

        }
    }

    public int peek() {
        return ar.get(0);
    }

    /*Delete in Heap:
3 step process
1- swap first and last node
2- remove last index from array
3- after removing the last index heap we need to fix (heapify)

Heapify → root
                    Take left
                     Take right

And fetch min and swap with root
*/
    private void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIdx = i;
        if (left < ar.size() && ar.get(minIdx) > ar.get(left)) {
            minIdx = left;
        }
        if (right < ar.size() && ar.get(minIdx) > ar.get(right)) {
            minIdx = right;
        }
        if (i != minIdx) {
            // swap
            int temp = ar.get(i);
            ar.set(i, ar.get(minIdx));
            ar.set(minIdx, temp);
            heapify(minIdx);
        }
    }

    public int remove() {
        int data = ar.get(0);
        int last = ar.size() - 1;
        // step -1 swap first and last
        int temp = ar.get(0);
        ar.set(0, ar.get(last));
        ar.set(last, temp);

        // step -2 delete last node
        ar.remove(last);

        // step -3 heapify (fixed the heap)
        heapify(0);
        return data;
    }

    public boolean isEmpty() {
        return ar.isEmpty();
    }

    public static void main(String[] args) {
        HeapImpl heap = new HeapImpl();
        heap.add(100);
        heap.add(10);
        heap.add(11);
        heap.add(14);
        while (!heap.isEmpty()){
            System.out.println(heap.peek());
            heap.remove();
        }

    }
}
