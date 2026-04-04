package revision.arrays;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int [] number = {2, 4, 5, -1, -3, -4};
        int[] result = rearrangeArrays(number);
        for(int re : result){
            System.out.println(re);
        }
    }

    private static int[] rearrangeArrays(int[] nums) {
        int n = nums.length;

        /* Define 2 vectors, one for storing positive
        and other for negative elements of the array.*/
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) pos.add(nums[i]);
            else neg.add(nums[i]);
        }

        // Positives on even indices, negatives on odd.
        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = pos.get(i);
            nums[2 * i + 1] = neg.get(i);
        }

        // Return the result
        return nums;
    }
}
