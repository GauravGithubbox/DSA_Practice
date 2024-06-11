package rajat.binarysearch.striversheet.onedimensional;

public class UpperBound {
    public static int upperBound(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int upper_bound = arr.length;
        while (start <= end) {  // Updated to include the end index in the search range
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                upper_bound = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return upper_bound;  // Element is not found in the array
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int target = 8;
        System.out.println(upperBound(arr, target));
    }
}
