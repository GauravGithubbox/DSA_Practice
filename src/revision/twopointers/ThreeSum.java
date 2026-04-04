package revision.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int [] number = {-1,0,1,2,-1,-4};
        int target = 0;
        List<List<Integer>> result = threeSum(number,target);

        System.out.println("result =>"+result);
    }

    private static List<List<Integer>> threeSum(int[] number, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(number); // [-4,-1,-1,0,1,2]
        int first = 0;
        int second =1;
        int third =3;



        return result;
    }
}
