package revision.sortings;



public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {7, 4, 1, 5, 3};
        int[] result = sortWithBubbleSort(nums);

        for (int num : result) {
            System.out.println(num);
        }
    }

    private static int[] sortWithBubbleSort(int[] nums) {
        int n = nums.length;
        // Traverse through the array
        for (int i = n - 1; i >= 0; i--) {
            // Track if swaps are made
            boolean isSwapped = false;
            for (int j = 0; j <= i - 1; j++) {
                // Swap if next element is smaller
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSwapped = true;
                }
            }
            /** Break out of loop
             if no swaps done*/
            if (!isSwapped) {
                break;
            }
        }
        return nums;
    }
}
