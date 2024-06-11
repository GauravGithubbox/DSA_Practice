package rajat.binarysearch.striversheet.onedimensional;

public class BinarySearch {

    /**
     * Performs binary search on a sorted array to find the target element.
     *
     * @param arr The sorted array to search within.
     * @param target The element to search for.
     * @return The index of the target element if found, otherwise -1.
     */
    public static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {  // Updated to include the end index in the search range
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;  // Element is not found in the array
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int target = 5;

        int result = binarySearch(array, target);
        System.out.println("Element found at index: " + result);  // Should print the index of the target element
    }
}