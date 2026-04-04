package revision.sortings;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {7, 4, 1, 5, 3};
        int[] result = sortWithSelectionSort(nums);

        for (int num : result) {
            System.out.println(num);
        }

    }

    private static int[] sortWithSelectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i; // Assume the first element is the smallest

            for (int j = i + 1; j < nums.length; j++) {
                // If we find something smaller, remember its POSITION
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the smallest found element with the element at position i
            swap(nums, i, minIndex);
        }
        return nums;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
