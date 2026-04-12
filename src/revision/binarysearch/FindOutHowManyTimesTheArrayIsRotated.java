package revision.binarysearch;

// The number of rotations = index of the minimum element
// Because when a sorted array is rotated, the minimum element becomes the starting point of the original array.

// and we already know

/*

if nums[mid] > nums[end]   // means left part is smaller, and you can say this is a rotated array
       minimum is on RIGHT
else
       minimum is on LEFT (including mid)

 */


import java.util.ArrayList;
import java.util.Arrays;

public class FindOutHowManyTimesTheArrayIsRotated {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3));
        int result = findKRoation(list);
        System.out.println("Find K Rotation " + result);
    }

    private static int findKRoation(ArrayList<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) > list.get(end)) { // if we got this condition right means small values in the right side (means roated array)
                // and big values would on left side.
                // Minimum is in right half
                start = mid + 1;
            } else {
                // Minimum is in left half (including mid)
                end = mid;
            }
        }
        return start;
    }
}
