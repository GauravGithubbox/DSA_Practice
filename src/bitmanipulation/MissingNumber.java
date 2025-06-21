package bitmanipulation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums ={3,0,1};
        int result = missingNumber(nums);
        System.out.println(result);
    }

    private static int missingNumber(int[] nums) {
                int xor = 0;
                int n = nums.length;
                for (int i = 0; i <= n; i++) {
                    xor ^= i;         // XOR all numbers from 0 to n
                }
                for (int num : nums) {
                    xor ^= num;      // XOR with all elements in the array
                }
                return xor;          // Result → missing number
            }


        // brute force solution
    /*private static int missingNumber(int[] nums) {
        int k =0;
        Arrays.sort(nums);
        for(int num : nums){
            if(num !=k){
                return k;
            }
            k++;
        }
        return k;
    }*/


}
