package gaurav.binarysearch;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class FindMinimumInRotatedSortedArray {


    public static int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            // if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                ans = Math.min(ans, arr[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { // if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Example rotated sorted array
        int[] arr = {7,8,1,2,3,4,5,6};

        // Call the findMin method and store the result
        int minElement = findMin(arr);

        // Print the result
        System.out.println("The minimum element in the rotated sorted array is: " + minElement);
    }
}
