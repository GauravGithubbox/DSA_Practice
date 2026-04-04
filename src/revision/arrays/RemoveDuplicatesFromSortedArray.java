package revision.arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {-2, 2, 4, 4, 4, 4, 5, 5};
        int result = removeDuplicates(nums);
        System.out.println("removeDuplicates " + result);
    }

    private static int removeDuplicates(int[] nums) {
        int temp = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp) {
                temp = nums[i];
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
