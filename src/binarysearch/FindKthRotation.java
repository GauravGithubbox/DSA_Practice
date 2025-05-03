package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindKthRotation {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        int result = findKRotation(arr);
        System.out.println("Rotation count "+result);

    }
        public static int findKRotation(List<Integer> arr) {
            int start = 0;
            int end = arr.size() - 1;

            while (start < end) {
                int mid = start + (end - start) / 2;

                if (arr.get(mid) <= arr.get(end)) {
                    // Minimum is in the left part including mid
                    end = mid;
                } else {
                    // Minimum is in the right part
                    start = mid + 1;
                }
            }

            // At the end of loop, start == end and points to the minimum element
            return start;  // This is the value of k
        }


}
