package rajat.array;

import java.util.Arrays;
//https://leetcode.com/problems/merge-sorted-array/description/
public class MergeTwoSortedArraysWithoutExtraSpace {

    public static void swap(int[] arr1, int[] arr2, int a, int b) {
        int temp = arr1[a];
        arr1[a] = arr2[b];
        arr2[b] = temp;
    }

    /**
     * Merges two sorted arrays into one sorted array using extra space.
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     *
     * @param arr1 The first sorted array
     * @param arr2 The second sorted array
     * @return A new array containing all elements of arr1 and arr2 in sorted order
     */
    public static int[] mergeTwoSortedArraysWithExtraSpace(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int[] output = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Merge arrays into the output array
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                output[k++] = arr1[i++];
            } else {
                output[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1
        while (i < m) {
            output[k++] = arr1[i++];
        }

        // Copy remaining elements of arr2
        while (j < n) {
            output[k++] = arr2[j++];
        }

        return output;
    }

    /**
     * Merges two sorted arrays without using extra space.
     * Time Complexity: O((m + n) log (m + n))
     * Space Complexity: O(1)
     *
     * @param arr1 The first sorted array
     * @param arr2 The second sorted array
     */
    public static void mergeTwoSortedArraysWithoutExtraSpace(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int leftArrayPointer = m - 1;
        int rightArrayPointer = 0;

        // Swap elements to ensure the first array contains the smallest elements
        while (leftArrayPointer >= 0 && rightArrayPointer < n) {
            if (arr1[leftArrayPointer] > arr2[rightArrayPointer]) {
                swap(arr1, arr2, leftArrayPointer, rightArrayPointer);
            }
            leftArrayPointer--;
            rightArrayPointer++;
        }

        // Sort both arrays to ensure final sorted order
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        // Uncomment the below lines to test merging with extra space
        // int[] mergedArray = mergeTwoSortedArraysWithExtraSpace(arr1, arr2);
        // Arrays.stream(mergedArray).forEach(ele -> System.out.print(ele + " "));

        // Test merging without extra space
        mergeTwoSortedArraysWithoutExtraSpace(arr1, arr2);

        // Print the merged arrays
        for (int ele : arr1) System.out.print(ele + " ");
        System.out.println();
        for (int ele : arr2) System.out.print(ele + " ");
    }
}
