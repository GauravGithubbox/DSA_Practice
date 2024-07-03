package rajat.recursion.striver.subsequence;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void subsetHelper(int[] nums, int index, List<Integer> ls, List<List<Integer>> output) {
        if(nums.length == index) {
            output.add(new ArrayList<>(ls));
            return;
        }

        ls.add(nums[index]);
        subsetHelper(nums, index + 1, ls, output);
        ls.remove(ls.size() - 1);
        subsetHelper(nums, index + 1, ls, output);

    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        subsetHelper(nums, 0, ls, output);
        return output;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> output = subsets(nums);
        System.out.println(output);
    }
}
