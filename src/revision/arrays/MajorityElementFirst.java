package revision.arrays;

public class MajorityElementFirst {
    public static void main(String[] args) {
        int[] number = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int result = majorityElement(number);
        System.out.println("Majority Element "+result);

    }

    private static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
