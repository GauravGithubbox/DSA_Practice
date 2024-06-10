package rajat.array;
//https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
public class CountInversion {
    private static int merge(int[] arr, int start, int mid, int end) {
        int leftIndex = start; // Starting index for the left subarray
        int rightIndex = mid + 1; // Starting index for the right subarray
        int inversionCount = 0;
        int[] temp = new int[end - start + 1]; // Temporary array for merging
        int k = 0; // Index for the temporary array

        // Merge the two subarrays into the temporary array
        while (leftIndex <= mid && rightIndex <= end) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[k++] = arr[leftIndex++];
            } else {
                temp[k++] = arr[rightIndex++];
                // Count inversions: all remaining elements in the left subarray
                // are greater than the current element from the right subarray
                inversionCount += (mid - leftIndex + 1);
            }
        }

        // Copy the remaining elements of the left subarray, if any
        while (leftIndex <= mid) {
            temp[k++] = arr[leftIndex++];
        }

        // Copy the remaining elements of the right subarray, if any
        while (rightIndex <= end) {
            temp[k++] = arr[rightIndex++];
        }

        // Copy the merged subarray back into the original array
        for (int i = 0; i < temp.length; i++) {
            arr[start + i] = temp[i];
        }

        return inversionCount;
    }

    public static int countInversionBruteForce(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int mergeSort(int[] nums, int start, int end) {
        int count = 0;
        if(start < end) {
            int mid = (start + end) / 2;
            count += mergeSort(nums, 0, mid);
            count += mergeSort(nums, mid + 1, end);
            count += merge(nums, start, mid, end);

        }
        return count;
    }
    public static int countInversion(int[] nums) {
        int start = 0, end = nums.length - 1;
        return mergeSort(nums, start, end);
    }

    public static void main(String[] args) {
        int nums[] = {2, 4, 1, 3, 5};
        System.out.println(countInversionBruteForce(nums));

        System.out.println(countInversion(nums));
    }
}
