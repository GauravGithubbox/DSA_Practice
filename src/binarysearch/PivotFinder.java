package binarysearch;

public class PivotFinder {
    public static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        // If the array is not rotated
        if (arr[start] < arr[end]) {
            return 0; // Pivot is at index 0
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            // If mid element is greater than end, pivot must be to the right of mid
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                // Pivot is at mid or to the left of mid
                end = mid;
            }
        }

        // At the end of loop, start == end == pivot index
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int pivotIndex = findPivot(arr);
        System.out.println("Pivot index: " + pivotIndex);
        System.out.println("Pivot element: " + arr[pivotIndex]);
    }
}
