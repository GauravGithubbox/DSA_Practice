package rajat.binarysearch.striversheet.onedimensional;

public class FindFloor {

    /**
     * Finds the floor of the target value in the given sorted array.
     * The floor of a target is the largest element in the array that is less than or equal to the target.
     *
     * @param arr    The sorted array in which to find the floor value.
     * @param target The target value for which to find the floor.
     * @return The index of the floor value, or -1 if no such value exists.
     *         If all elements are greater than the target, returns -1.
     *
     * Time Complexity: O(log n) - Binary search in a sorted array.
     * Space Complexity: O(1) - Constant space usage.
     */
    public static int findFloor(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int floor = -1;

        // Binary search loop to find the floor value
        while (start <= end) {
            int mid = start + (end - start) / 2; // Calculate mid point to avoid overflow

            if (arr[mid] <= target) {
                // If the middle element is less than or equal to the target, it's a candidate for floor
                floor = mid;
                start = mid + 1; // Move the start to the right to find a larger floor value
            } else {
                // If the middle element is greater than the target, discard the right half
                end = mid - 1;
            }
        }

        return floor; // Return the index of the floor value found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        int target = 0;

        // Test case where the target is less than the smallest element in the array
        // Expected output: -1, since there's no element <= target
        System.out.println("Floor index for target " + target + ": " + findFloor(arr, target));
    }
}
