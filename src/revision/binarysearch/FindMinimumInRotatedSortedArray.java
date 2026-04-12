package revision.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

/*
* if arr[mid] > arr[end]
       minimum is in RIGHT side
else
       minimum is in LEFT side (including mid)*/


public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(4, 5, 6, 7, -7, 1, 2, 3));
        int result = findMinimum(nums);

        System.out.println("find min " + result);
    }

    private static int findMinimum(ArrayList<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) > arr.get(end)) { // if we got this condition right means small values in the right side (means roated array)
                                               // and big values would on left side.
                // Minimum is in right half
                start = mid + 1;
            } else {
                // Minimum is in left half (including mid)
                end = mid;
            }
        }

        return arr.get(start);
    }


}
