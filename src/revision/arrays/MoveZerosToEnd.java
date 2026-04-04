package revision.arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int [] nums = {0, 1, 4, 0, 5, 2};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {
        int j =0;
        int n = nums.length;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                // Move j forward
                j++;
            }
        }
        for(int num : nums){
            System.out.println("fuck "+num);
        }
    }
}
