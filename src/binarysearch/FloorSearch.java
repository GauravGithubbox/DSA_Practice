/*Given a sorted array arr[] of size N without duplicates, and given a value x. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x. Find the index of K(0-based indexing).

Example 1:

Input:
N = 7, x = 0
arr[] = {1,2,8,10,11,12,19}
Output: -1
Explanation: No element less
than 0 is found. So output
is "-1".
Example 2:

Input:
N = 7, x = 5
arr[] = {1,2,8,10,11,12,19}
Output: 1
Explanation: Largest Number less than 5 is
2 (i.e K = 2), whose index is 1(0-based
indexing).*/
package binarysearch;

class FloorSearch {

    // Method to find the floor of x
    static int findFloor(long arr[], int n, long x) {
        int left = 0;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Prevent overflow

            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                result = mid;  // Update result to mid since it's a potential floor
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;  // If no exact match, return the floor value's index
    }

    // Main method to test the findFloor method
    public static void main(String[] args) {
        // Example array and target value
        long[] arr = {1, 2, 4, 6, 8, 10, 12, 14};
        long x = 5;
        int n = arr.length;

        // Call the findFloor method and print the result
        int result = findFloor(arr, n, x);
        if (result != -1) {
            System.out.println("The floor of " + x + " is at index: " + result + ", value: " + arr[result]);
        } else {
            System.out.println("No floor found for " + x + " in the array.");
        }
    }
}

