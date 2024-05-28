package sorting.recursive;
//https://www.geeksforgeeks.org/problems/merge-sort/1

public class MergeSort {
    private static void merge(int[] arr, int start, int mid, int end) {
        int left = 0, right = 0;

        // Create Two Arrays
        int[] leftArray = new int[mid - start + 1];
        int[] rightArray = new int[end - mid];

        // Copy first Half
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[start + i];
        }

        // Copy Second Half
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }


        // Merge
        int k = start;
        while (left < leftArray.length && right < rightArray.length) {
            if (leftArray[left] <= rightArray[right]) {
                arr[k] = leftArray[left];
                left++;
            } else {
                arr[k] = rightArray[right];
                right++;
            }
            k++;
        }

        while (left < leftArray.length) {
            arr[k] = leftArray[left];
            k++;
            left++;
        }

        while (right < rightArray.length) {
            arr[k] = rightArray[right];
            k++;
            right++;
        }

    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            // Merge Sort Call
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        int n = arr.length;
        int start = 0, end = n - 1;
        mergeSort(arr, start, end);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
}
