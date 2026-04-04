package revision.sortings;


/*
Start with the second element as the first element is assumed to be sorted.
Compare the second element with the first if the second is smaller then swap them.
Move to the third element, compare it with the first two, and put it in its correct position
Repeat until the entire array is sorted.
 */

public class InsertionSorting {
    public static void main(String[] args) {
        int[] nums = {7, 4, 1, 5, 3};
        int[] result = sortWithInsertionSort(nums);

        for (int num : result) {
            System.out.println(num);
        }
    }

    private static int[] sortWithInsertionSort(int[] nums) {
        int n = nums.length; // Size of the array

        // For every element in the array
        for (int i = 1; i < n; i++) {
            int key = nums[i]; // Current element as key
            int j = i - 1;

            // Shift elements that are greater than key by one position
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key; // Insert key at correct position
        }

        return nums;
    }
}
