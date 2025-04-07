package array;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println( "Count =>"+removeElement(nums,val));
    }

    private static int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for placing non-val elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Place the non-val element at index k
                k++; // Move the pointer
            }
        }
        return k;
    }
}
