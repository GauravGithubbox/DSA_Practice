package revision.arrays;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0};
        int result = findMaxConsecutiveOness(nums);
        System.out.println("findMaxConsecutiveOnes "+result);

    }

    private static int findMaxConsecutiveOness(int[] nums) {
        int maxOne =0;
        int count =0;
        for(int num : nums){
            if(num == 1){
                count++;
                maxOne = Math.max(maxOne,count);
            }else {
                count = 0;
            }
        }
        return maxOne;
    }

}
